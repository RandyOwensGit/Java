package client;

import java.io.*;
import java.net.*;

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