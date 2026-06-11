package edu.escuelaing.arsw.ejercicio641;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatRemoteImpl
        extends UnicastRemoteObject
        implements ChatRemote {

    protected ChatRemoteImpl()
            throws RemoteException {
        super();
    }

    @Override
    public void receiveMessage(String message)
            throws RemoteException {

        System.out.println();
        System.out.println(
                "[REMOTE] " + message);
        System.out.print("> ");
    }
}
