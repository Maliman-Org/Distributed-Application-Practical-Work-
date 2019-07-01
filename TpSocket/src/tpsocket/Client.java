//package tpsocket;

import java.io.*;
import java.net.*;


/**
 *
 * @author Manno
 */
public class Client {

    public static InetAddress MY_IP;
    public static final int MY_PORT = 7777;
    public static final String USED_SERVER_IP = "";
    public static InetAddress SERVER_IP;
    public static final int SERVER_PORT = 7777;
    Socket socket = null;
    DataOutputStream msg = null;

    public Client() {
        try {
            MY_IP = Inet4Address.getLocalHost();
            try {
                SERVER_IP = Inet4Address.getByName(USED_SERVER_IP);
                try {
                    socket = new Socket(SERVER_IP, SERVER_PORT, MY_IP, MY_PORT);
                    System.out.println("Client Soket is successfully created");
                } catch (IOException ex) {
                    System.err.println("IOException while creating client soket");
                }
            } catch (UnknownHostException hostServerException) {
                System.err.println("UnknownHostException Server host " + USED_SERVER_IP + " coudn't be found ->SERVER_IP");
            } catch (SecurityException se) {
                System.err.println("SecurityException Server didnt allow the operation ->SERVER_IP");
            }
        } catch (UnknownHostException hostException) {
            System.err.println("UnknownHostException local host coudn't be found ->MY_IP");
        }
    }

    public void sendAnInteger(int intMsg) {
    if (socket != null) {
            OutputStream output = null;
            try {
                output = socket.getOutputStream();
                msg = new DataOutputStream(output);
                try {
                    msg.write(intMsg);
                    try {
                        msg.flush();
                        System.out.println("msg send is successfully");
                        closeDataOutputStream();
                    } catch (IOException ex) {
                        System.err.println("IOException while sending the msg");
                    }
                } catch (IOException ex) {
                    System.err.println("IOException while assigning the int to the msg");
                }
            } catch (IOException ex) {
                System.err.println("IOException while creating OutputStream");
            }

        } else {
            System.err.println("soket is null i can't send the int msg");
        }
    }

    public void sendAString(String stringMsg) {
        if (socket != null) {
            OutputStream output = null;
            try {
                output = socket.getOutputStream();
                msg = new DataOutputStream(output);
                try {
                    msg.writeUTF(stringMsg);
                    try {
                        msg.flush();
                        System.out.println("msg send is successfully");
                        closeDataOutputStream();
                    } catch (IOException ex) {
                        System.err.println("IOException while sending the msg");
                    }
                } catch (IOException ex) {
                    System.err.println("IOException while assigning the string to the msg");
                }
            } catch (IOException ex) {
                System.err.println("IOException while creating OutputStream");
            }

        } else {
            System.err.println("soket is null i can't send the string msg");
        }
    }

    public void closeDataOutputStream() {
        if (msg != null) {
            try {
                msg.close();
                msg = null;
                System.out.println("closeDataOutputStream done");
            } catch (IOException ex) {
                System.err.println("IOException while closing the DataOutputStream");
            }
        }
    }
    
    public void closeSoket(){
        try {
            socket.close();
            socket=null;
            System.out.println("close soket done");
        } catch (IOException ex) {
            System.err.println("IOException while closing the client socket");
        }
        
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.sendAString("Slm");
        client.sendAnInteger(5);
        client.closeSoket();
    }

}
