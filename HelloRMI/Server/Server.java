package helloServer;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server {
 	
   public static void main(String[] args) {
    
     try {
          HelloImpl obj = new HelloImpl();
          Naming.rebind("HelloObject", obj);

	  System.err.println("Server ready");
     } catch (Exception e) {
          System.err.println("Server exception: " + e.toString());
          e.printStackTrace(System.err);
     }
   }
} 
