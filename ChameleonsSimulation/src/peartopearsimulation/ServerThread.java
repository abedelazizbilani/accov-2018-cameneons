/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peartopearsimulation;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abed Bilani
 */
public class ServerThread implements Runnable {

    private final Chameleon chameleon;
    private final ChameleonList chameleonList;

    public ServerThread(Socket socket, ChameleonList chameleonList) throws IOException {
        chameleon = new Chameleon(socket);
        this.chameleonList = chameleonList;
        chameleonList.add(chameleon);
        
    }

    @Override
    public void run() {
        String colorString;
        try {
            while(!(colorString = chameleon.getReader().readLine()).equals(".")){
                if(chameleonList.getCount()==0){
                    chameleon.setColor(colorString);
                    chameleonList.incrementCount();
                }else{
                    chameleonList.mutate(chameleon, colorString);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
