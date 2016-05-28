package ejemplo3;

import java.io.IOException;
import java.io.*;
import java.net.Socket;

public class ProcessEcho implements Process {
	private final PrintStream out;
	private final BufferedReader in;

	public ProcessEcho(Socket s) throws IOException {
		this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		this.out = new PrintStream(s.getOutputStream());
	}

	public String getLine() throws IOException {
		return in.readLine();
	}

	public String processLine(String line) {
		return line;
	}

	public void putLine(String line) throws IOException {
		out.println(line);
	}

	public void close() throws IOException {
		out.close();
		in.close();
	}
}