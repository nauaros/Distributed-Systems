/**
 * TimePrinter.java Imprime la hora cada segundo.
 */
package ejemplo.timeprinter;

public class TimePrinter implements Runnable {
	public void run() {
		while (true) {
			System.out.println(new java.util.Date());
			try {
				Thread.sleep(1000); // ms
			} catch (InterruptedException x) {}
		}
	}

	public static void main(String[] args) {
		final Runnable tarea = new TimePrinter(); // Runnable es una interfaz
		new Thread(tarea, "Hilo de TimePrinter").start();
	}
}