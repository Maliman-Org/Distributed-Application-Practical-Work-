
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kika
 */
public class ImplementationRmiRemoteService extends UnicastRemoteObject implements RmiRemoteServiceInterface {

    protected ImplementationRmiRemoteService() throws RemoteException { }

    @Override
    public String sendedMsg(String name) throws RemoteException {
        System.out.println(name + " want to contact");
        System.out.println("*****************************");
        return "Server send you your data Mr/Mm " + name;
    }

}
