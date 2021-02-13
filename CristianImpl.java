
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class CristianImpl extends UnicastRemoteObject implements Cristian {

    public CristianImpl() throws RemoteException {
        super();
    }

    public Date getDate() throws RemoteException  {
        return new Date();
    }

    public static void main(String args[]) {

// Crea e instala un administrador de seguridad
        //System.setSecurityManager(new RMISecurityManager());

        try {
            Cristian obj = new CristianImpl();
            // Vincular esta instancia de objeto al nombre "CristianServer"
           // Naming.rebind ("rmi://localhost/HelloServer", obj);
            Naming.rebind("CristianServer", obj);
            System.out.println("CristianServer enlazado en el registro");
        } catch (Exception e) {
            System.out.println("Excepción CristianImpl: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
