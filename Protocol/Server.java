package protocol.Server;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {
	public static final int PORT = 2000;
	public static final int NThreads = 5;
	private static final StringQueue queue = new StringQueue();
	public static ExecutorService exec = Executors.newFixedThreadPool(NThreads);


	public static void main(String[] args) {
		System.out.println("Setting up server:");
		runServer();
	}

	public static void runServer() {
		try {
			ServerSocket sock = new ServerSocket(PORT);

			while(true) {
				Socket s = sock.accept();
				exec.execute(new MaidRunnable(s, queue));
			}
		} catch(IOException ioe) {
			System.err.println("Server: I/O Error: " + ioe);
		}
	}
}