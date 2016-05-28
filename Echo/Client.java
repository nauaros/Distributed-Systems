package ejemplo1.echosencillo;

import java.net.*;
import java.io.*;

public class Client {
	public static final int PORT = 2000;

	public static void main(String[] args) throws IOException {
		String line = null;
		Socket client = new Socket("localhost", PORT); /* Creation of socket */

		try {
			Reader t1 = new InputStreamReader(System.in);
			BufferedReader inKeyboard = new BufferedReader(t1);

			InputStream in = client.getInputStream(); /* socket input */
			Reader r1 = new InputStreamReader(in);
			BufferedReader inred = new BufferedReader(r1);

			OutputStream out = client.getOutputStream(); /* socket output */
			PrintStream outred = new PrintStream(out);

			while ((line = inKeyboard.readLine()) != null) {
				outred.println(line);

				line = inred.readLine(); /* reading echo from server */

				System.out.println("Received: " + line);

				if (line.equals("Bye."))
					break;
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}
}