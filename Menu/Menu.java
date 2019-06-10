package Menu;

import Main.DealWithIt;

import java.awt.*;

/**
 * This Menu class holds the data for each Menu item.
 *
 * <p>
 * Version 1 - 30 mins
 * When the method is called, the image passed through the parameters is drawn at the specified location.
 * </p>
 *
 * @author Hannah Kim
 * @version 05.30.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */
public class Menu {

    /** This Point variable is the location that the image is being displayed at */
    public Point location;
    /** This Image variable holds the image being displayed */
    public Image button;

    /**
     * The constructor of the class where the Menu is constructed, and instance
     * variables are initialized using values passed in through the parameters.
     *
     * @param image location of the image
     * @param location where the image is going to be displayed
     */
    public Menu(String image, Point location) {
        button = DealWithIt.imageFromFile(image);
        this.location = location;
    }

    /**
     * This method draws the image at the specified location.
     */
    public void draw() {
        DealWithIt.graphics.drawImage(button, location.x, location.y, null);
    }
}