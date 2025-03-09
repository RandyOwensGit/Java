package server;


import java.io.*;
import java.net.*;
import java.util.*;

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

    public static void addWriter(PrintWriter writer) {
        synchronized (writers) {
            writers.add(writer);
        }
    }

    public static void removeWriter(PrintWriter writer) {
        synchronized (writers) {
            writers.remove(writer);
        }
    }

    public static void broadcast(String message) {
        synchronized (writers) {
            for (PrintWriter writer : writers) {
                writer.println(message);
            }
        }
    }

}















