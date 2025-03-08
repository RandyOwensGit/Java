import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

// Server Logic
public class ChatServer {

    private static final int PORT = 12345;
    private static HashSet<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Chat Server Online...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }

        } catch (IOException e) {
            System.out.println("Error in the server: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // request username
                while (true) {
                    out.println("SUBMITNAME");
                    String name = in.readLine();

                    if (name == null) {
                        return;
                    }

                    synchronized (writers) {
                        writers.add(out);
                        break;
                    }
                }

                // Welcome message
                out.println("NAMEACCEPTED");
                broadcast("User has joined the chat!");

                // Handle messages
                String message;
                while ((message = in.readLine()) != null) {
                    if (!message.isEmpty()) {
                        broadcast(message);
                    }
                }

            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            } finally {

                if (out != null) {
                    synchronized (writers) {
                        writers.remove(out);
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e.getMessage());
                }

            }
        }

        private void broadcast(String message) {
            synchronized (writers) {
                for (PrintWriter writer : writers) {
                    writer.println(message);
                }
            }
        }

    }

}















