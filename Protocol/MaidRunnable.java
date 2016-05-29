package protocol.Server;

import java.util.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import protocol.common.Primitive;
import protocol.common.ProtocolMessage;

class MaidRunnable implements Runnable {
	private final Socket socket;
	private final StringQueue queue;

	MaidRunnable(Socket s, StringQueue c) {
		this.socket = s;
		this.queue = c;
	}

	public void run() {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;

		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());

			while (true) {
				ProtocolMessage me = (ProtocolMessage) ois.readObject();
				ProtocolMessage ms;
				System.out.println("<< " + me);

				switch (me.getPrimitive()) {
					case HELLO:
						ms = new ProtocolMessage(Primitive.HELLO, "Hi from the server.");
						break;
					case PUSH:
						queue.push(me.getMessage());
						ms = new ProtocolMessage(Primitive.PUSH_OK);
						break;
					case PULL:
						synchronized (queue) {
							if (queue.isEmpty()) {
								ms = new ProtocolMessage(Primitive.NOTHING);
							} else {
								ms = new ProtocolMessage(Primitive.PULL_OK, queue.pop());
							}
						}
						break;
					case PULL_WAIT:
						ms = new ProtocolMessage(Primitive.PULL_OK, queue.pop());
						break;
					default:
						ms = new ProtocolMessage(Primitive.NOTUNDERSTAND);
				}
				oos.writeObject(ms);
				System.out.println(">> " + ms);
			}
		} catch (IOException e) {
			System.err.println("End of Client");
		} catch (ClassNotFoundException ex) {
			System.err.println("ProtocolMessage class not found");
		} finally {

			try {
				ois.close();
				oos.close();
				socket.close();
			} catch (Exception x) {
				System.err.println("Maid: Error when closing sockets");
			}
		}
	}
}