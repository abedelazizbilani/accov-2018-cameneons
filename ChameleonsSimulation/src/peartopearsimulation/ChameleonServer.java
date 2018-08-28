/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peartopearsimulation;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * in this class we will add a server for sockets all chameleons will connect to
 * this socket and will launch a new thread
 *
 * @author abed.bilani
 */
public class ChameleonServer {

    // add main 
    // in main launch server socket 
    // accept clients 
    // and start a thread
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // create a chameleon list to add connecting clients to
        ArrayList<ChameleonClient> list = new ArrayList<>();
        ChameleonServer.runSocket();
    }

    public static void runSocket() throws IOException, ClassNotFoundException {
        // creating server sockets
        ServerSocket serverSocket = new ServerSocket(1308);
        ChameleonList clientList = new ChameleonList();

        System.out.println("Server up and ready for connections .....");
        while (true) {
            // launch server on a new thread using class Server Thread
            // and send server socket along with chameleon list new instance to be able to add a new client
            Socket clientSocket = serverSocket.accept();
            Thread serverThread = new Thread(new ServerThread(clientSocket, clientList));
            serverThread.setDaemon(true);
            serverThread.start();
            System.out.println("socket created");
        }
    }
}
