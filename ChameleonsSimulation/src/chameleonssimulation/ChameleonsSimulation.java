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
public class ChameleonsSimulation {

    static ChameleonColor[] colors = {
        ChameleonColor.BLUE,
        ChameleonColor.RED,
        ChameleonColor.YELLOW,
        ChameleonColor.BLUE,
        ChameleonColor.BLUE,
        ChameleonColor.RED,
        ChameleonColor.YELLOW,
        ChameleonColor.RED,
        ChameleonColor.YELLOW,
        ChameleonColor.BLUE
    };
    // create an array of type chameleon
    static Chameleon[] chameleons = new Chameleon[colors.length];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //create meetup location aka forest
        Forest forest = new Forest();
        // create chemeleons from the static array
        for (int i = 0 ;i<colors.length;i++){
            
             chameleons[i]=new Chameleon(forest,new ChameleonId(i),colors[i]);
            new Thread(chameleons[i]).start();
            //(new Thread (new Chameleon(forest,new ChameleonId(i), colors[i]))).start();
        }
    }
}
