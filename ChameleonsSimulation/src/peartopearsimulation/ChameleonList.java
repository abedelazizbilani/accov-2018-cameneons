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
    int count;

    public ChameleonList() {
        chameleonsList = new ArrayList<>();
        count = 0;
    }

// the mutaion will happen here after we loop through the list
    public synchronized void mutate(Chameleon chameleon, String color) {

        // check for each chameleon color 
        // the same color => dont change color
        this.chameleonsList.stream().filter((chameleonElement) -> (chameleonElement.getColor() != null)).forEach((chameleonElement) -> {
            if (chameleonElement.getColor().equals(color)) {
                System.out.println("no mutation since the two chameleons have the same color which is : " + color);
                chameleonElement.getWriter().println(color);
                chameleon.getWriter().println(color);
                // set current chameleon color from list to null to close the socket
                chameleonElement.setColor(null);
                this.decrementCount();
            } else if ((chameleonElement.getColor().equals("Red") && color.equals("Blue")) || (chameleonElement.getColor().equals("Blue") && color.equals("Red"))) {
                chameleon.setColor("Yellow");
                // send color to thread to print
                // set as null to close thread
                chameleonElement.getWriter().println("Yellow");
                chameleon.getWriter().println("Yellow");

                System.out.println("done mutating, new color: Yellow");
                chameleonElement.setColor(null);
                this.decrementCount();
            } else if ((chameleonElement.getColor().equals("Yellow") && color.equals("Blue")) || ((chameleonElement.getColor().equals("Blue") && color.equals("Yellow")))) {
                // send color to thread to print
                chameleonElement.getWriter().println("Red");
                chameleon.getWriter().println("Red");
                System.out.println("done mutating, new color: Red");
                // set as null to close thread
                chameleonElement.setColor(null);
                this.decrementCount();
            } else if ((chameleonElement.getColor().equals("Yellow") && color.equals("Red")) || ((chameleonElement.getColor().equals("Red") && color.equals("Yellow")))) {
                // send color to thread to print
                chameleonElement.getWriter().println("Blue");
                chameleon.getWriter().print("Blue");
                System.out.println("done mutating, new color: Blue");
                // set as null to close thread
                chameleonElement.setColor(null);
                this.decrementCount();
            }
        });

    }

    // method to add chameleons to the arraylist
    public void add(Chameleon chameleon) {
        this.chameleonsList.add(chameleon);
    }

    // method to remove a chameleon from list 
    public void remove(Chameleon chameleon) throws IOException {
        // close reader and writer and the socket before removing
        chameleon.getReader().close();
        chameleon.getWriter().close();
        chameleon.getChameleonSocket().close();
        this.chameleonsList.remove(chameleon);
    }

    public int getCount() {
        return this.count;
    }

    public void incrementCount() {
        this.count++;
    }

    public void decrementCount() {
        this.count--;
    }
}
