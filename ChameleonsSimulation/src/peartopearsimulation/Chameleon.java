/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peartopearsimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * here as in the other solution we will add the chameleon methods the
 * difference is the chameleon will have his own socket
 *
 * @author abed.bilani
 */
public class Chameleon {

    // chameleon properties 
    private String color;
    private Socket chameleonSocket;
    // reader and writer for the chameleon
    private final BufferedReader reader;
    private final PrintWriter writer;

    // add reader and writer 
    // getters and setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Socket getChameleonSocket() {
        return chameleonSocket;
    }

    public void setChameleonSocket(Socket chameleonSocket) {
        this.chameleonSocket = chameleonSocket;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    final BufferedReader getInput(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    final PrintWriter getOutput(Socket socket) throws IOException {
        return new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }

    public Chameleon(Socket socket) throws IOException {
        chameleonSocket = socket;
        reader = getInput(socket);
        writer = getOutput(socket);
        color = null;
    }
}
