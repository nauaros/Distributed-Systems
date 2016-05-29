package protocol.common;

import java.util.*;
import java.io.*;

public class ProtocolMessage implements Serializable {
	private Primitive primitive;
	private String message;

	public ProtocolMessage(Primitive p) {
		assert p.isCompound() == false;

		this.primitive = p;
		this.message = "";
	}

	public ProtocolMessage(Primitive p, String m) {
		assert p.isCompound() == true && m != null;
		this.primitive = p;
		this.message = m;
	}

	public Primitive getPrimitive() {
		return this.primitive;
	}

	public String getMessage() {
		return this.message;
	}

	public String toString() {
		String prettyPrint = "[ " + this.primitive;

		switch (this.primitive) {
			case HELLO:
			case PUSH:
			case PULL_OK:
				return "[ " + this.primitive + " : " + this.message + " ]";
			default:
				return "[ " + this.primitive + " ]";
		}

	}
}






