package edu.escuelaing.arsw.ejercicio521;

import java.net.*;

public class TimeClientUDP {

    private static String lastKnownTime =
            "No time received yet";

    public static void main(String[] args)
            throws Exception {

        DatagramSocket socket =
                new DatagramSocket();

        socket.setSoTimeout(2000);

        InetAddress address =
                InetAddress.getByName("localhost");

        while (true) {

            try {

                byte[] sendBuffer =
                        "TIME".getBytes();

                DatagramPacket request =
                        new DatagramPacket(
                                sendBuffer,
                                sendBuffer.length,
                                address,
                                45000);

                socket.send(request);

                byte[] receiveBuffer =
                        new byte[256];

                DatagramPacket response =
                        new DatagramPacket(
                                receiveBuffer,
                                receiveBuffer.length);

                socket.receive(response);

                lastKnownTime =
                        new String(
                                response.getData(),
                                0,
                                response.getLength());

                System.out.println(
                        "Current server time: "
                                + lastKnownTime);

            } catch (SocketTimeoutException e) {

                System.out.println(
                        "Server unavailable. Last known time: "
                                + lastKnownTime);
            }

            Thread.sleep(5000);
        }
    }
}