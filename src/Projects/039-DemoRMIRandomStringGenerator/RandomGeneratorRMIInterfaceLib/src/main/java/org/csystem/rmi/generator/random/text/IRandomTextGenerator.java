package org.csystem.rmi.generator.random.text;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRandomTextGenerator extends Remote {
    String BIND_NAME = "org-csystem-app-rmi-generator-text";

    String generateRandomTextEN(int count) throws RemoteException;
    String generateRandomTextTR(int count) throws RemoteException;
}
