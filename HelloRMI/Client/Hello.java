package helloServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
   public String sayHello() throws RemoteException;
   public Person girlfriend(Person p) throws RemoteException;
}
