package edu.escuelaing.arsw.ejercicio2;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Ingrese una URL: ");
            String direccion = scanner.nextLine();

            URL url = new URL(direccion);

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(url.openStream()));

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter("resultado.html"));

            String linea;

            while ((linea = reader.readLine()) != null) {
                writer.println(linea);
            }

            reader.close();
            writer.close();

            System.out.println("Archivo resultado.html generado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al leer la URL.");
            e.printStackTrace();
        }

        scanner.close();
    }
}