package edu.escuelaing.arsw.ejercicio641;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ChatApp {

    public static void main(String[] args)
            throws Exception {

        Scanner scanner =
                new Scanner(System.in);

        System.out.print(
                "Local registry port: ");

        int localPort =
                Integer.parseInt(
                        scanner.nextLine());

        Registry localRegistry =
                LocateRegistry.createRegistry(
                        localPort);

        ChatRemoteImpl localChat =
                new ChatRemoteImpl();

        localRegistry.rebind(
                "chat",
                localChat);

        System.out.println(
                "Local chat published.");

        System.out.print(
                "Remote IP: ");

        String remoteIp =
                scanner.nextLine();

        System.out.print(
                "Remote port: ");

        int remotePort =
                Integer.parseInt(
                        scanner.nextLine());

        Registry remoteRegistry =
                LocateRegistry.getRegistry(
                        remoteIp,
                        remotePort);

        ChatRemote remoteChat =
                (ChatRemote)
                        remoteRegistry.lookup(
                                "chat");

        System.out.println(
                "Connected to remote chat.");

        while (true) {

            System.out.print("> ");

            String message =
                    scanner.nextLine();

            remoteChat.receiveMessage(
                    message);
        }
    }
}