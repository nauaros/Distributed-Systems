package protocol.Server;

import java.util.*;

public class StringQueue {
	private ArrayList<String> list = new ArrayList<String>();

	public synchronized void push(final String p) {
		list.add(p);
		this.notify();
	}

	public synchronized String pop() {
		while (list.size() == 0) {
			try {
				this.wait();
			} catch (final InterruptedException e) {}
		}
		return list.remove(0);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
}