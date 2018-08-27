/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peartopearsimulation;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Abed Bilani
 */
public class ServerThread implements Runnable {

    private final Chameleon chameleon;
    private final List<Chameleon> chameleonList;

    public ServerThread(Socket socket, List<Chameleon> chameleonList) throws IOException {
        chameleon = new Chameleon(socket);
        this.chameleonList = chameleonList;
        chameleonList.add(chameleon);
        
        
        
    }

    @Override
    public void run() {

    }
}
