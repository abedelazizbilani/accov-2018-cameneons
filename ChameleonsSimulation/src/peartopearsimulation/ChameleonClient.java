/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peartopearsimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * in this we will create a client class in which we will connect to main server
 * and launch a new thread
 *
 * @author abed.bilani
 */
public class ChameleonClient {

    private static BufferedReader inputStream(InputStream inputStream) throws IOException {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private static BufferedReader readFromSocket(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private static PrintWriter writeToSocket(Socket socket) throws IOException {
        return new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }

    // add buffers to read and write to the socket
    // main class in which we will launch a thread and connect to server socket
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 1308);
            BufferedReader read = readFromSocket(socket);
            PrintWriter write = writeToSocket(socket);
            Scanner sc = new Scanner(System.in);
            String chameleonColor;
            do {
                System.out.println("provide a valid color for the chameleon");
                System.out.println("choose between Red , Blue or Yellow");
                System.out.println("note : case sensitive");
                chameleonColor = sc.nextLine();
            } while ((!chameleonColor.equals("Red")) || (!chameleonColor.equals("Blue")) || (!chameleonColor.equals("Yellow")));
            Thread socketThread = new Thread(new ChameleonProp(read, write, chameleonColor));
            socketThread.start();
        } catch (Exception e) {
        } finally {
            if (socket != null) {
                socket.close();
            }
        }

    }
}
