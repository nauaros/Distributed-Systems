package helloServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.ServerNotActiveException;

public class HelloImpl extends UnicastRemoteObject implements Hello {
  
  public HelloImpl() throws RemoteException { super(); }

  public String sayHello() throws RemoteException {
    String ipAddress = null;
    try {
        ipAddress = getClientHost();
    } catch (ServerNotActiveException snae) {
        snae.printStackTrace();
    }

    return "Hello world, your IP address is " + ipAddress;

  }

  public Person girlfriend(Person p) throws RemoteException {
     Person girl = new Person();
     girl.setName("Ashley");
     girl.setAge(28);
     girl.setCity("Ottawa");

     return girl;
  }
}
