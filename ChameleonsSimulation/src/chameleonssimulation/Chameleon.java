/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chameleonssimulation;

/**
 *
 * @author Abed Bilani
 */
public class Chameleon extends Thread{

    private Forest forest;
    private ChameleonId id;
    private ChameleonColor myColor, otherColor;

    // cham constructor will receive where the cham will meet and set an id for the cham and its color
    public Chameleon(Forest forest, ChameleonId id, ChameleonColor col) {
        this.forest = forest;
        this.id = id;
        this.myColor = col;
    }

    // add chameleon behavior 
    
    // eating 
    // mutating 
    // going to forest to mutate
}
