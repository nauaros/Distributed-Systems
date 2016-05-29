package protocol.Client;

import java.util.*;
import java.io.*;
import java.net.*;
import protocol.common.Primitive;
import protocol.common.ProtocolMessage;

public class Client {
	final private int PORT = 2000;

	public static void main(String[] args) throws IOException {
		String host = "localhost";
		String line;

		Socket sock = new Socket(host, 2000);
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;

		try {
			ois = new ObjectInputStream(sock.getInputStream());
			oos = new ObjectOutputStream(sock.getOutputStream());

			System.out.println("Press <Enter> to start");
			System.in.read();

			oos.writeObject(new ProtocolMessage(Primitive.HELLO, "Peter"));
			System.out.println((ProtocolMessage) ois.readObject());

			System.out.println("Press <Enter> to continue");
			System.in.read();

			oos.writeObject(new ProtocolMessage(Primitive.PUSH, "We're in Istambul"));
			System.out.println((ProtocolMessage) ois.readObject());

			System.out.println("Press <Enter> to continue");
			System.in.read();

			oos.writeObject(new ProtocolMessage(Primitive.PULL));
			System.out.println((ProtocolMessage) ois.readObject());

			System.out.println("Press <Enter> to continue");
			System.in.read();

			oos.writeObject(new ProtocolMessage(Primitive.PULL_WAIT));
			System.out.println((ProtocolMessage) ois.readObject());

			System.out.println("Press <Enter> to finish");
			System.in.read();

		} catch (IOException e) {
			System.err.println("Client: I/O error " + e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ois.close();
			oos.close();
			sock.close();
		}
	}
}
