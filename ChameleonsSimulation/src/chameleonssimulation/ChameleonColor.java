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
public class ChameleonColor {
    // in this class will generate a color for each created chameleon
    // depending on the 3 colors we have as default it will be 0 1 2 => blue yellow red

    public int interiorColor;
    private static final int blueColor = 0;
    private static final int redColor = 1;
    private static final int yellowColor = 2;
    public static final ChameleonColor BLUE = new ChameleonColor(blueColor);
    public static final ChameleonColor RED = new ChameleonColor(redColor);
    public static final ChameleonColor YELLOW = new ChameleonColor(yellowColor);

    /*
    *   a constructor for the chameleon color
     */
    public ChameleonColor(int colorNumber) {
        this.interiorColor = colorNumber;
    }

    /**
     * a chameleon need to change his color we need to implement this behavior
     *
     * @return
     */
    public ChameleonColor changeColor(ChameleonColor newColor) {
        // check if the current chameleon has the same color of the other chameleon
        if (this.interiorColor == newColor.interiorColor) {
            return new ChameleonColor(this.interiorColor);
        }
        return new ChameleonColor(3 - this.interiorColor - newColor.interiorColor);
    }

    @Override
    public String toString() {
        String color = "";
        switch (this.interiorColor) {
            case 0:
                color = "Blue";
                break;
            case 1:
                color = "Red";
                break;
            case 2:
                color = "Yellow";
                break;
        }
        return color;
    }
}
