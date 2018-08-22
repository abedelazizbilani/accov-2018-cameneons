/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chameleonssimulation;

import java.util.concurrent.Callable;

/**
 * In this class i am creating a chameleon object that implements 
 * @author Abed Bilani
 */
public class Chameleon implements Callable<String> {

    private Forest forest;
    private ChameleonId id;
    private ChameleonColor myColor, otherChameleonColor;

    // cham constructor will receive where the cham will meet and set an id for the cham and its color
    public Chameleon(Forest forest, ChameleonId id, ChameleonColor col) {
        this.forest = forest;
        this.id = id;
        this.myColor = col;
    }

    // add chameleon behavior
    // this function is to display current behavior of the chameleon
    public void currentBehavior(String behavior) {
        System.out.println("i am " + this.id + " and my color is " + this.myColor + " and " + behavior);
    }

    // eating 
    // eating behavior 
    public void eat() {
        this.currentBehavior("i am eating");
    }

    // muutation behavior
    public void mutate() {
        this.currentBehavior("i am going to mutate");
        // get the color of the other chameleon in the forest
        otherChameleonColor = forest.chameleonMeeting(id, myColor);
        // change my color according to the other chameleon color
        // the mutation happens here
        myColor = myColor.changeColor(otherChameleonColor);
        // done mutating
        System.out.println("I am done mutating");
        
    }

    // going to forest to mutate
    public void goingToForest() {
        this.currentBehavior("i am going to the forest");
    }
    
    @Override
    public String call(){
        while (true){
            this.eat();
            this.goingToForest();
            this.mutate();
        }
    }
}
