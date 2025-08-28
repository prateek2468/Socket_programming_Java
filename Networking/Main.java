package Networking;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        final int port_number = 12345;

        try (var scanner = new Scanner(System.in)) {
            System.out.println("Is this a server ? (y/n) ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                new Server().start(port_number);
            } else {
                new Client().start(port_number, scanner);
            }

        }
    }

}
