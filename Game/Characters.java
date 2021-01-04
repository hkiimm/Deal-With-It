package Game;

import Main.DealWithIt;

import java.awt.*;

/**
 * This Character class holds the data for each character item.
 *
 * <p>
 * Version 1 - 20 mins
 * When the method is called, the image passed through the parameters is drawn at the specified location.
 * </p>
 *
 * @author Hannah Kim, Sophia Nguyen
 * @version 06.04.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */
public class Characters {

    /** This Point variable is the location that the image is being displayed at */
    public Point location;
    /** This Image variable holds the image being displayed */
    public Image button;

    /**
     * The constructor of the class where the Characters are constructed, and instance
     * variables are initialized using values passed in through the parameters.
     *
     * @param image location of the image
     * @param location where the image is going to be displayed
     */
    public Characters (String image, Point location) {
        button = DealWithIt.imageFromFile(image);
        this.location = location;
    }

    /**
     * This method draws the image at the specified location.
     */
    public void drawImg() {
        DealWithIt.graphics.drawImage(button, location.x, location.y, null);
    }
}
