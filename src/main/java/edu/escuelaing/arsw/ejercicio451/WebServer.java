package edu.escuelaing.arsw.ejercicio451;

import java.io.*;
import java.net.*;
import java.nio.file.Files;

public class WebServer {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(35000);

        System.out.println("Web Server running on port 35000");

        while (true) {

            Socket clientSocket = serverSocket.accept();

            handleRequest(clientSocket);

            clientSocket.close();
        }
    }

    private static void handleRequest(Socket clientSocket)
            throws IOException {

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));

        OutputStream out =
                clientSocket.getOutputStream();

        String requestLine = in.readLine();

        if (requestLine == null) {
            return;
        }

        System.out.println(requestLine);

        String[] parts = requestLine.split(" ");

        String path = parts[1];

        if (path.equals("/")) {
            path = "/index.html";
        }

        File file =
                new File(
                        "src/main/resources" + path);

        if (!file.exists()) {

            send404(out);

            return;
        }

        sendFile(out, file);
    }

    private static void sendFile(
            OutputStream out,
            File file)
            throws IOException {

        String contentType =
                Files.probeContentType(
                        file.toPath());

        byte[] data =
                Files.readAllBytes(
                        file.toPath());

        String headers =
                "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: "
                        + contentType
                        + "\r\n"
                        + "Content-Length: "
                        + data.length
                        + "\r\n\r\n";

        out.write(headers.getBytes());

        out.write(data);

        out.flush();
    }

    private static void send404(OutputStream out)
            throws IOException {

        String response =
                "HTTP/1.1 404 Not Found\r\n\r\n"
                        + "<h1>404 File Not Found</h1>";

        out.write(response.getBytes());

        out.flush();
    }
}
