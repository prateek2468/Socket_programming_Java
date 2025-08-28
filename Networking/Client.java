package Networking;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Client {

    public void start(final int port_number, final Scanner scanner) {

        try (var socket = new Socket("localhost", port_number);
                var writer = new PrintWriter(socket.getOutputStream(), true);
                var serverReturn = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Socket created");
            String userInput;
            while (!(userInput = scanner.nextLine()).isEmpty()) {
                writer.println(userInput);
                System.out.println("Response :- " + serverReturn.readLine());

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
