package Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.concurrent.Executors;
import java.util.concurrent.Executors;
import javax.management.RuntimeErrorException;

public class Server {

    public void start(final int port_number) {

        try (var serverSocket = new ServerSocket(port_number)) {
            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                while (true) {
                    var clientSocket = serverSocket.accept();
                    executor.submit(() -> {
                        System.out.println("Client connected");
                        var clientIP = clientSocket.getInetAddress().getHostAddress();
                        var clientPort = clientSocket.getPort();

                        try (var clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                                var output = new PrintWriter(clientSocket.getOutputStream(), true)) {
                            String line;
                            System.out.println("recieving");
                            while ((line = clientInput.readLine()) != null) {
                                System.out.println(clientIP + ". " + clientPort + ". " + line);
                                output.println(new StringBuilder(line).reverse());
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
