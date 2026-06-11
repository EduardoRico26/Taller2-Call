package edu.escuelaing.arsw.ejercicio432;

import java.io.*;
import java.net.*;

public class TrigonometricClient {

    public static void main(String[] args) throws IOException {

        Socket socket =
                new Socket("127.0.0.1", 35000);

        PrintWriter out =
                new PrintWriter(
                        socket.getOutputStream(), true);

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));

        BufferedReader keyboard =
                new BufferedReader(
                        new InputStreamReader(System.in));

        String userInput;

        while ((userInput = keyboard.readLine()) != null) {

            out.println(userInput);

            System.out.println(
                    "Response: "
                            + in.readLine());
        }

        socket.close();
    }
}