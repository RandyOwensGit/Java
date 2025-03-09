package server;

import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
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

                ChatServer.addWriter(out);
                break;
            }

            // Welcome message
            out.println("NAMEACCEPTED");
            ChatServer.broadcast("User has joined the chat!");

            // Handle messages
            String message;
            while ((message = in.readLine()) != null) {
                if (!message.isEmpty()) {
                    ChatServer.broadcast(message);
                }
            }

        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {

            if (out != null) {
                ChatServer.removeWriter(out);
            }
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error closing socket: " + e.getMessage());
            }

        }
    }

}