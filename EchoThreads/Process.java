package ejemplo3;

import java.io.IOException;
import java.net.Socket;

public interface Process extends AutoCloseable {
	public String getLine() throws IOException;
	public String processLine(String line);
	public void putLine(String line) throws IOException;
}