package helloClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import helloServer.Hello;
import helloServer.Person;

public class Client {
 
  public Client() {}

  public static void main(String[] args) {
     String host = "localhost";
   
     try {
         Hello stub = (Hello) Naming.lookup("HelloObject");
         
         String response = stub.sayHello();
         System.out.println("response: " + response);

         Person mike = new Person();
         mike.setName("Mike");
	 mike.setAge(24);
         mike.setCity("Toronto");
     
         Person girl = (Person) stub.girlfriend(mike);
         System.out.println(girl.info());
     } catch (Exception e) {
         System.err.println("Client exception: " + e.toString());
     }
  }
}
