
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    
    public static final String URL = "rmi://127.0.0.1:1099/TestRMI";
    public void waitClient(){
         try {
            Naming.rebind(URL,new ImplementationRmiRemoteService());
            System.out.println("Server is waiting...");
        } catch (RemoteException ex) {
            System.err.println("RemoteException when creating object");
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            System.err.println("MalformedURLException ==> wrong URL");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
       Server server =new Server();
       server.waitClient();
 
    }

}
