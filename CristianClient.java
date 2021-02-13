
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.util.Date;

public class CristianClient {

    public static void main(String args[]) {

      

        // Create and install a security manager
        //System.setSecurityManager(new RMISecurityManager());

        try {
            // "obj" es el identificador que usaremos para hacer referencia
            // al objeto remoto que implementa la interfaz "Cristian"
            Cristian obj = (Cristian) Naming.lookup("rmi://localhost/CristianServer");

            // Comienza el algoritmos
            Date d_local_1 = new Date();
            Date d_remote = obj.getDate();
            Date d_local_2 = new Date();

            System.out.println(
                    "Tiempo antes de RMI en la cliente es  " + d_local_1 + " (" + d_local_1.getTime() + " ms)");
            System.out.println(
                    "Tiempo después de RMI en la cliente es" + d_local_2 + " (" + d_local_2.getTime() + " ms)");
            System.out
                    .println("El tiempo devuelto por el servidor es " + d_remote + " (" + d_remote.getTime() + " ms)");

            long d = d_local_2.getTime()-d_local_1.getTime();
            System.out.println("La duración de la solicitud (D) es" + d + " ms");

            long theta = d_local_2.getTime()-d/2-d_remote.getTime();
            System.out.println("La desviación del reloj (Theta) es " + theta + " ms");
            System.out.println("La precisión es +/-" + d/2 + " ms");
            System.out.println("¿Es posible tener una precisión más precisa? (Sugerencia: intente 'ping" + args[0] + "')");
        } catch (Exception e) {
            System.out.println("Excepción HelloClient: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
