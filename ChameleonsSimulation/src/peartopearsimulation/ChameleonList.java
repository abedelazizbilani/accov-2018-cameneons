/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peartopearsimulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * to manage all the chameleon we need to add chameleons to a list , to do that
 * that we create class Chameleon list here we will loop through these clients
 * chameleons and mutate according to the formula in the doc
 *
 * @author Abed Bilani
 */
public class ChameleonList {

    List<Chameleon> chameleonsList;

    public ChameleonList() {
        chameleonsList = new ArrayList<>();
    }

    // the mutaion will happen here after we loop through the list
    public synchronized void mutate(Chameleon chameleon, String color) {
        for (Chameleon chameleonElement : chameleonsList) {
            // check for each chameleon color 
            // the same color => dont change color
            if (chameleonElement.getColor().equals(color)) {
                System.out.println("no mutation since the two chameleons have the same color which is : " + color);
                // set current chameleon color from list to null to close the socket
                chameleonElement.setColor(null);
            } else if ((chameleonElement.getColor().equals("Red") && color.equals("Blue")) || (chameleonElement.getColor().equals("Blue") && color.equals("Red"))) {
                chameleon.setColor("Yellow");
                // send color to thread to print
                chameleonElement.getWriter().println("Yellow");
                System.out.println("done mutating, new color: Yellow");
                // set as null to close thread
                chameleonElement.setColor(null);
            } else if ((chameleonElement.getColor().equals("Yellow") && color.equals("Blue")) || ((chameleonElement.getColor().equals("Blue") && color.equals("Yellow")))) {
                // send color to thread to print
                chameleonElement.getWriter().println("Red");
                System.out.println("done mutating, new color: Red");
                // set as null to close thread
                chameleonElement.setColor(null);
            } else if ((chameleonElement.getColor().equals("Yellow") && color.equals("Red")) || ((chameleonElement.getColor().equals("Red") && color.equals("Yellow")))) {
                // send color to thread to print
                chameleonElement.getWriter().println("Blue");
                System.out.println("done mutating, new color: Blue");
                // set as null to close thread
                chameleonElement.setColor(null);
            }

        }
    }

    // method to add chameleons to the arraylist
    public void add(Chameleon chameleon) {
        chameleonsList.add(chameleon);
    }
    
    // method to remove a chameleon from list 
    public void remove(Chameleon chameleon) throws IOException{
        // close reader and writer and the socket before removing
        chameleon.getReader().close();
        chameleon.getWriter().close();
        chameleon.getChameleonSocket().close();
        chameleonsList.remove(chameleon);
    }
}
