import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Kika
 */
public interface RmiRemoteServiceInterface extends Remote{
    
    public String sendedMsg(String msg)throws RemoteException;
    
    
}
