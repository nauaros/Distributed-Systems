package ejemplo3;

public class Maid implements Runnable {
	/* instance variable */
	public final Process p;
	public final int id;

	Maid(Process p, int identifier) {
		this.p = p;
		this.id = identifier;
	}

	public void run() {
		try {
			String input, output;

			while ((input = p.getLine()) != null) {
				output = this.p.processLine(input);
				this.p.putLine(output);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}