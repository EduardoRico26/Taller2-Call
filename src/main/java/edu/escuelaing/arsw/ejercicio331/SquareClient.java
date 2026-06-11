package edu.escuelaing.arsw.ejercicio331;

import java.io.*;
import java.net.*;

public class SquareClient {

    public static void main(String[] args) throws IOException {

        Socket socket = null;

        PrintWriter out = null;

        BufferedReader in = null;

        try {

            socket = new Socket("127.0.0.1", 35000);

            out =
                    new PrintWriter(
                            socket.getOutputStream(), true);

            in =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

        } catch (UnknownHostException e) {

            System.err.println("Host desconocido");
            System.exit(1);

        } catch (IOException e) {

            System.err.println("Error de conexión");
            System.exit(1);

        }

        BufferedReader teclado =
                new BufferedReader(
                        new InputStreamReader(System.in));

        String entradaUsuario;

        while ((entradaUsuario = teclado.readLine()) != null) {

            out.println(entradaUsuario);

            System.out.println(
                    "Cuadrado: " + in.readLine());
        }

        out.close();
        in.close();
        teclado.close();
        socket.close();
    }
}