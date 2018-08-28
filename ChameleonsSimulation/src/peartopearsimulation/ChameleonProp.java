/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peartopearsimulation;

import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * moved chameleon properties here
 *
 * @author Abed Bilani
 */
public class ChameleonProp implements Runnable {

    // properties
    private String color;
    private final PrintWriter write;
    private final BufferedReader read;

    public ChameleonProp(BufferedReader read, PrintWriter write, String color) {
        this.color = color;
        this.read = read;
        this.write = write;
    }

    // launch the thread
    @Override
    public void run() {
        // need to implement the behavior and mutation for the chameleon like the first solution in a different way
        while (true) {
            try {
                System.out.println("i am eating");
                System.out.println("i am going to the forest");
                System.out.println("i am going to mutate my color is " + color);
                String inputString;
                this.write.printf("%s\n", color);
                this.write.flush();
                if ((inputString = this.read.readLine()) != null) {
                    this.color = inputString;
                    System.out.println("mutation done my color is : " + color);
                }
            } catch (Exception e) {
            }
        }

    }
}
