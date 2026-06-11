package edu.escuelaing.arsw.ejercicio331;

import java.io.*;
import java.net.*;

public class SquareServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(35000);
            System.out.println("Servidor iniciado en puerto 35000");
        } catch (IOException e) {
            System.err.println("No se pudo abrir el puerto 35000");
            System.exit(1);
        }

        Socket clientSocket = null;

        try {
            clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado");
        } catch (IOException e) {
            System.err.println("Error aceptando conexión");
            System.exit(1);
        }

        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));

        String inputLine;

        while ((inputLine = in.readLine()) != null) {

            try {

                int numero = Integer.parseInt(inputLine);

                int cuadrado = numero * numero;

                System.out.println("Número recibido: " + numero);

                out.println(cuadrado);

            } catch (NumberFormatException e) {

                out.println("Error: ingrese un número válido");

            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}