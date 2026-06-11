package edu.escuelaing.arsw.ejercicio432;

import java.io.*;
import java.net.*;

public class TrigonometricServer {

    private static String currentFunction = "cos";

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(35000);

        System.out.println("Trigonometric Server started");

        Socket clientSocket = serverSocket.accept();

        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));

        String inputLine;

        while ((inputLine = in.readLine()) != null) {

            if (inputLine.startsWith("fun:")) {

                String function =
                        inputLine.substring(4).trim().toLowerCase();

                if (function.equals("sin")
                        || function.equals("cos")
                        || function.equals("tan")) {

                    currentFunction = function;

                    out.println(
                            "Function changed to: "
                                    + currentFunction);

                    System.out.println(
                            "Current function: "
                                    + currentFunction);

                } else {

                    out.println("Invalid function");
                }

            } else {

                try {

                    double value =
                            Double.parseDouble(inputLine);

                    double result;

                    switch (currentFunction) {

                        case "sin":
                            result = Math.sin(value);
                            break;

                        case "tan":
                            result = Math.tan(value);
                            break;

                        default:
                            result = Math.cos(value);
                    }

                    out.println(result);

                } catch (NumberFormatException e) {

                    out.println("Invalid number");
                }
            }
        }

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}