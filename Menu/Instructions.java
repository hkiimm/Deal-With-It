package Menu;

import Main.DealWithIt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is the Instructions class that displays the instructions of the game.
 *
 * <p>
 * Version 1 - 30 mins
 * Created the framework of the class.
 * Added mousewhere for the back button and made sure it leads back to the main menu.
 * Used another image as a placeholder until graphics were finished.
 *
 * Version 2 - 20 mins
 * Replaced the placeholder image with the real graphics with instructions.
 * Debugged and checked for errors.
 * </p>
 *
 * @author Hannah Kim, Sophia Nguyen
 * @version 06.02.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */
public class Instructions extends JPanel{

    /** This Image variable stores the background image. */
    private Image bg;
    /** This Menu variable holds the back button. */
    private Menu back;
    /** This boolean variable checks if a valid option has been selected. */
    private volatile boolean goBack;

    /**
     * The constructor of the class where the Instructions are constructed, and instance
     * variables are initialized using default values.
     *
     * The MouseListener checks where the mouse is located, and if it has been clicked.
     */
    public Instructions () {
        goBack = false;

        bg = DealWithIt.imageFromFile ("Menu/instruct.png");
        back = new Menu ("Menu/Back.png", new Point (1063,808));

        addMouseListener (new MouseAdapter(){
            public void mousePressed (MouseEvent e) {
                if (e.getX() > 1063 && e.getX() < 1235 && e.getY() > 808 && e.getY() < 898) {
                    goBack = true;
                    repaint();
                }
            }
        });
    }

    /**
     * This method gets called every time repaint() gets called to draw the image.
     *
     * @param g the graphics to be drawn
     */
    @Override
    public void paintComponent(Graphics g) {
        DealWithIt.graphics = (Graphics2D) g;
        g.drawImage (bg, 0, 0, null);
        back.draw();
    }

    /**
     * This method is called to draw the images. Once the back button has been
     * clicked, it exits the instructions.
     */
    public void back() {
        revalidate();
        repaint();
        while (!goBack);
    }
}
