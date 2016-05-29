package runserver;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import util.Contador;
import cajaserver.CajaImpl;

/**
 * Lanza el servidor de Caja(s) de Contador(es)
 * @author nauaros
 */
public class RunCaja {
	public static void main(String[] args) {
		try {
			CajaImpl<Contador> cc = new CajaImpl<Contador>();

			Registry registro = LocateRegistry.createRegistry(2005);

			registro.rebind("CajaRemota", cc);
			System.out.println("Objeto remoto enlazado");
		} catch (RemoteException re) {
			re.printStackTrace(System.err);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
