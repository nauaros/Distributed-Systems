/**
 * Servidor.java Servidor echo sencillo.
 */
package ejemplo1.echosencillo;

import java.net.*;
import java.io.*;

public class Server {
	public static final int PORT = 2000;

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(PORT); /* creation of socket */

		while (true) {
			try {
				System.out.println("----- Server accepting connections -----");

				try (Socket sock = server.accept()) {

					InputStream in = sock.getInputStream(); // Socket input

					Reader r1 = new InputStreamReader(in);
					PrintStream outred;
					

					try (BufferedReader inred = new BufferedReader(r1)) {
						OutputStream out = sock.getOutputStream(); // Socket output
						outred = new PrintStream(out);
						String line;

						while ((line = inred.readLine()) != null) {
							System.out.println("Echoing: " + line);
							outred.println(line);

							if (line.equals("Bye.")) 
								break;
						}
					} 
					outred.close();
				}
			} catch (IOException e) {
				e.printStackTrace(System.err);
			}
		}
	}
}