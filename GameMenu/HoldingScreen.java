package GameMenu;

import Main.DealWithIt;
import Menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This HoldingScreen class is to be placed between each level.
 *
 * <p>
 * Version 1 - 1 hour
 * Created the frame work of the class.
 * Added the mouse where to check which button has been pressed.
 * Updated the driver class to place this class in between each level.
 * </p>
 *
 * @author Hannah Kim
 * @version 06.04.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */
public class HoldingScreen extends JPanel{

    /** This Image variable stores the background image. */
    private Image bg;
    /** This Menu[] variable is an array of Menu option objects */
    private Menu[] options;
    /** This boolean variable holds if a valid option has been selected */
    private volatile boolean selected;
    /** This int variable holds the option that's been selected */
    private int page;

    /**
     * The constructor of the class where the HoldingScreen is constructed, and instance
     * variables are initialized using default values.
     *
     * The MouseListener checks where the mouse is located, and which option is clicked.
     */
    public HoldingScreen () {
        page = 0;
        selected = false;
        bg = DealWithIt.imageFromFile ("GameMenu/holding.png");

        options = new Menu[2];
        options[0] = new Menu("GameMenu/continue.png", new Point (450, 500));
        options[1] = new Menu("GameMenu/exitgame.png", new Point(450,600));

        addMouseListener (new MouseAdapter(){
            public void mousePressed (MouseEvent e) {
                if (e.getX() > 450 && e.getX() < 870 && e.getY() > 500 && e.getY() < 572) {
                    repaint();
                    page = 1;
                    selected = true;
                }
                else if (e.getX() > 450 && e.getX() < 870 && e.getY() > 600 && e.getY() < 672) {
                    repaint();
                    page = 2;
                    selected = true;
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

        for (int i = 0 ; i < options.length ; i++) {
            options[i].draw();
        }
    }

    /**
     * This method is called to draw the images. If the continue button is
     * clicked the game continues, if not the game exits.
     *
     * @return the selected menu option
     */
    public int play() {
        revalidate();
        repaint();
        while (!selected);
        return page;
    }
}
