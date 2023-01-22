package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.ServerSocket.PORT;

public class Server {


    public static void main(String[] args) throws IOException {

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен");

            while (true) {

                try (Socket client = server.accept();
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                    System.out.println("Подключен клиент " + client.getPort());

                    writer.println("Hi from servsr");

                    System.out.println(reader.readLine());

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

