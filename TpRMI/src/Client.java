
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.registry.*;
import java.rmi.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    public  RmiRemoteServiceInterface stub = null;
    public static final String URL = "rmi://127.0.0.1:1099/TestRMI";
    public Client(String mName) throws java.net.UnknownHostException {
        try {
            stub = (RmiRemoteServiceInterface) Naming.lookup(URL);

        } catch (NotBoundException ex) {
            System.err.println("NotBoundException when lookup");
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            System.err.println("MalformedURLException when lookup");
            ex.printStackTrace();
        } catch (RemoteException ex) {
            System.err.println("RemoteException when creation stub");
            ex.printStackTrace();
        }
        sendToServer(mName);

    }
    public void sendToServer(String name){
        if (stub != null) {
            System.out.println("Connected to the server successfully");
            try {
                System.out.println(stub.sendedMsg(name));
            } catch (RemoteException ex) {
                System.err.println("RemoteException when geting response");
            }

        } else {
            System.err.println("Connection failed");
        }
    }

    public static void main(String[] args) throws java.net.UnknownHostException {
       new Client("Malika");
    }
}
		