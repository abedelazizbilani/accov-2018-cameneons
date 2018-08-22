/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chameleonssimulation;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abed Bilani
 */
public class Forest {
    
    // place where the chameleon will meet 
    private boolean firsChameleon = true;
    private boolean forestFull = false;
    
    private ChameleonColor firstChameleonColor , secondChameleonColor;
    // when chameleon meet we need to check 
   public synchronized ChameleonColor chameleonMeeting(ChameleonId id , ChameleonColor color){
       
       ChameleonColor mutatedColor = null;
       // check if there is already 2 chameleons in the forest
       // if yes put thread on hold
       while(forestFull){
           try {
               wait();
           } catch (InterruptedException ex) {
               Logger.getLogger(Forest.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       // check if this is the chameleon to enter
       if(firsChameleon){
             this.firstChameleonColor = color;
               // set first chameleon to false
               this.firsChameleon = false;
               // use wait to put thread on hold
           try {
               wait();
           } catch (InterruptedException ex) {
               Logger.getLogger(Forest.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       else{
           // here we will check for the second chameleon
           this.secondChameleonColor = color;
           // set forest full to true 
           this.forestFull  = true;
           mutatedColor = firstChameleonColor;
           // notify all waiting threads
           notifyAll();
       }
       return mutatedColor;
   }
}
