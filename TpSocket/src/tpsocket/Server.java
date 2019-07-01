//package tpsocket;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manno
 */
public class Server {

    public static InetAddress MY_IP;
    public static final int MY_PORT = 7777;
    public static final int MAX_IN_CNX = 10;
    ServerSocket serverSocket = null;
    Socket socket = null;
    DataInputStream msg;

    public Server() {
        try {
            MY_IP = Inet4Address.getLocalHost();
            try {
                serverSocket = new ServerSocket(MY_PORT, MAX_IN_CNX, MY_IP);
                System.err.println("the server is waiting for connexions ...");
                socket = serverSocket.accept();
                receiveString();
            } catch (IOException ex) {
                System.err.println("IOException while creating server soket");
            }
        } catch (UnknownHostException ex) {
            System.err.println("UnknownHostException local host coudn't be found ->SERVER_IP");
        }

    }

    public void receiveString() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            msg = new DataInputStream(inputStream);
            String stringMsg;
            try {
                stringMsg = msg.readUTF();
                inputStream.close();
                closeSokets();
                System.out.println("A msg is received from the client( IP= " + socket.getInetAddress().toString() + " & PORT = "
                        + socket.getPort() + " ) with content: " + stringMsg);
            } catch (IOException ex) {
                System.err.println("IOException while receiving the string to the msg");
            }
        } catch (IOException ex) {
            System.err.println("IOException while creating InputStream");
        }

    }

    public void receiveInt() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            msg = new DataInputStream(inputStream);
            int intMsg;
            try {
                intMsg = msg.readInt();
                inputStream.close();
                System.out.println("A msg is received from the client( IP= " + socket.getInetAddress().toString() + " & PORT = "
                        + socket.getPort() + " ) with content: " + intMsg);
                closeSokets();
            } catch (IOException ex) {
                System.err.println("IOException while receiving the int to the msg");
            }
        } catch (IOException ex) {
            System.err.println("IOException while creating InputStream");
        }

    }

    public void closeDataInputStream() {
        if (msg != null) {
            try {
                msg.close();
                msg = null;
                System.out.println("closeDataInputStream done");
            } catch (IOException ex) {
                System.err.println("IOException while closing the DataInputStream");
            }
        }
    }

    public void closeSokets() {
        try {
            socket.close();
            serverSocket.close();
            socket = null;
            serverSocket = null;
            System.out.println("close sokets done");
        } catch (IOException ex) {
            System.err.println("IOException while closing the server sockets");
        }

    }

    public static void main(String[] args) {
        new Server();
    }
}
