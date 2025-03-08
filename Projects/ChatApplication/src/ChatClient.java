import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {

    private String hostname;
    private int port;
    private String username;

    public ChatClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);

            System.out.println("Connected to the chat server");

            new ReadThread(socket, this).start();
            new WriteThread(socket, this).start();
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }

    void setUsername(String username) {
        this.username = username;
    }

    String getUsername() {
        return this.username;
    }

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        ChatClient client = new ChatClient(hostname, port);
        client.execute();
    }
}

class ReadThread extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private ChatClient client;

    public ReadThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Error getting input stream: " + e.getMessage());
        }
    }

    public void run() {
        while (true) {

            try {
                String response = reader.readLine();
                if (response == null) {
                    break;
                }

                if (response.equals("SUBMITNAME")) {
                    System.out.println("Enter your username: ");
                    continue;
                } else if (response.equals("NAMEACCEPTED")) {
                    System.out.println("You can start chatting now!");
                    continue;
                }

                System.out.println("\n" + response);
                System.out.println(">");

            } catch (IOException e) {
                System.out.println("Error reading from server: " + e.getMessage());
                break;
            }
        }
    }
}

// Thread to write messages to server
class WriteThread extends Thread {
    private PrintWriter writer;
    private Socket socket;
    private ChatClient client;
    private Scanner scanner;

    public WriteThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;
        this.scanner = new Scanner(System.in);

        try {
            writer = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            System.out.println("Error getting output stream: " + e.getMessage());
        }

    }

    public void run() {
        String text;

        do {
            text = scanner.nextLine();

            if (client.getUsername() == null) {
                client.setUsername(text);
                writer.println(text);

            } else {
                writer.println(client.getUsername() + ": " + text);
            }

        } while (true);

    }
}



















