package cajaclientrmi;

import cajaserver.Caja;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import util.Contador;

/**
 * Quita el elemento de la caja.
 * @author nauaros
 */
public class CajaClientRMIquita {

	/**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		Contador c = null;
		try {
			Caja caja = (Caja) Naming.lookup("rmi://localhost:2005/CajaRemota");

			c = (Contador) caja.lee();
			if (c != null) {
				System.out.println("valor de la caja: " + c.lee());
				caja.quita();
				System.out.println("Caja vaciada.");
			} else {
				System.out.println("La caja estaba vacia.");
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
