//package tpsocket;

import java.io.*;
import java.net.*;

/**
 *
 * @author Manno
 */
public class Client {
    public static String  USED_CLIENT_IP = "172.26.1.47";
    public static InetAddress MY_IP;
    public final int MY_PORT = 7778;
    public final String USED_SERVER_IP = Server.USED_SERVER_IP;
    public InetAddress SERVER_IP;
    public final int SERVER_PORT =Server.MY_PORT;
    Socket socket = null;
    DataOutputStream msg = null;
    public Client() {
        try {
            MY_IP = Inet4Address.getByName(USED_CLIENT_IP);
            try {
                SERVER_IP = Inet4Address.getByName(USED_SERVER_IP);
                try {
                    socket = new Socket(SERVER_IP, SERVER_PORT, MY_IP, MY_PORT);
                    System.out.println("Client Soket is successfully created");
                } catch (IOException ex) {
                    System.err.println("IOException while creating client soket");
                    ex.printStackTrace();
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
                    msg.writeInt(intMsg);
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

    public void closeSoket() {
        if (socket != null) {
            try {
                socket.close();
                socket = null;
                System.out.println("close soket done");
            } catch (IOException ex) {
                System.err.println("IOException while closing the client socket");
            }

        }
    }

    public static void executeStringSenario() {
        Client client = new Client();
        client.sendAString("Slm");
        client.closeSoket();
    }

    public static void executeIntSenario() {
        Client client = new Client();
        client.sendAnInteger(5);
        client.closeSoket();
    }

    public static void execute(int senario) {
        if (senario == 1) {
            executeStringSenario();
        } else {
            executeIntSenario();
        }
    }

    public static void main(String[] args) {
        execute(Server.senario);
    }

}
