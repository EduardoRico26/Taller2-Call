package edu.escuelaing.arsw.ejercicio521;

import java.net.*;
import java.time.LocalTime;

public class TimeServerUDP {

    public static void main(String[] args) throws Exception {

        DatagramSocket socket =
                new DatagramSocket(45000);

        System.out.println("UDP Time Server started");

        byte[] receiveBuffer =
                new byte[256];

        while (true) {

            DatagramPacket request =
                    new DatagramPacket(
                            receiveBuffer,
                            receiveBuffer.length);

            socket.receive(request);

            String requestMessage =
                    new String(
                            request.getData(),
                            0,
                            request.getLength());

            System.out.println(
                    "Request received: "
                            + requestMessage);

            String currentTime =
                    LocalTime.now().toString();

            byte[] sendBuffer =
                    currentTime.getBytes();

            DatagramPacket response =
                    new DatagramPacket(
                            sendBuffer,
                            sendBuffer.length,
                            request.getAddress(),
                            request.getPort());

            socket.send(response);
        }
    }
}
