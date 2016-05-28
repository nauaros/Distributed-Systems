package ejemplo3;

import java.net.*;
import java.io.*;

public class NewServer {
	public static final int PORT = 2000;

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(PORT);

		for (int i = 1; true; i++) {
			System.out.println("---- Accepting connections ----");
			try {
				Socket socket = server.accept();
				ProcessEcho echo = new ProcessEcho(socket);
				Thread thread = new Thread(new Maid(echo, i), "ECHO");
				thread.start();
			} catch (IOException e) {
				e.printStackTrace(System.err);
			}
		}
	}
}