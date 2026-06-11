package edu.escuelaing.arsw.ejercicio1;

import java.net.MalformedURLException;
import java.net.URL;

public class Ejercicio1 {

    public static void main(String[] args) {

        try {

            URL url = new URL(
                "http://www.eduardorico.com:80/docs/index.html?curso=arsw#ejercicio1"
            );

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("File: " + url.getFile());
            System.out.println("Ref: " + url.getRef());

        } catch (MalformedURLException e) {
            System.out.println("La URL es inválida");
            e.printStackTrace();
        }
    }
}