package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

// Thread to write messages to server
public class WriteThread extends Thread {
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

