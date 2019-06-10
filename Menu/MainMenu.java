package Menu;

import Main.DealWithIt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is the MainMenu where the user can select to play the game, see the high
 * scores, see the instructions, or quit the game.
 *
 * <p>
 * Version 1 - 1.5 hour
 * Created the framework of the class.
 * Initialized variables using  default values.
 * Set the mouse where for 'New Game', 'Instructions, and 'Goodbye'.
 * Figured out how mouse where worked and implemented it in my code.
 *
 * Version 2 - 30 mins
 * Changed the coordinates of the mouse where for a fourth button.
 * Added another button called 'High Score'.
 * Debugged and checked for errors.
 * </p>
 *
 * @author Hannah Kim
 * @version 05.29.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */
public class MainMenu extends JPanel {
    /** This boolean variable holds if a valid option has been selected */
    private volatile boolean selected;
    /** This Image variable holds the background image */
    private Image bg;
    /** This Menu[] variable is an array of Menu option objects */
    private Menu[] options;
    /** This int variable holds the option that's been selected */
    private int page;

    /**
     * The constructor of the class where the MainMenu is constructed, and instance
     * variables are initialized using default values.
     *
     * The MouseListener checks where the mouse is located, and if it has been clicked.
     */
    public MainMenu() {
        selected = false;
        page = 0;

        options = new Menu[4];
        options[0] = new Menu ("Menu/newgame.png", new Point(450,325));
        options[1] = new Menu ("Menu/scores.png", new Point (450, 425));
        options[2] = new Menu ("Menu/instructions.png", new Point (450,525));
        options[3] = new Menu ("Menu/quit.png", new Point (450,625));

        bg = DealWithIt.imageFromFile("Menu/menu.png");

        addMouseListener (new MouseAdapter(){
            public void mousePressed (MouseEvent e) {
                if (e.getX() > 450 && e.getX() < 870 && e.getY() > 325 && e.getY() < 397) {
                    repaint();
                    page = 1;
                    selected = true;
                }
                else if (e.getX() > 450 && e.getX() < 870 && e.getY() > 425 && e.getY() < 497) {
                    repaint();
                    page = 2;
                    selected = true;
                }
                else if (e.getX() > 450 && e.getX() < 870 && e.getY() > 525 && e.getY() < 597) {
                    repaint();
                    page = 3;
                    selected = true;
                }
                else if (e.getX() > 450 && e.getX() < 870 && e.getY() > 625 && e.getY() < 697) {
                    repaint();
                    page = 4;
                    selected = true;
                }
            }
        });
    }

    /**
     * This method gets called every time repaint() gets called to draw the
     * background and buttons.
     *
     * @param g the graphics to be drawn
     */
    @Override
    public void paintComponent(Graphics g) {
        DealWithIt.graphics = (Graphics2D) g;
        g.drawImage(bg, 0, 0, null);

        for (int i = 0 ; i < options.length ; i++)
        {
            options[i].draw();
        }
    }

    /**
     * This method is used to update the images until a menu option is selected. Once a menu
     * option has been selected, it returns the menu option.
     *
     * @return the selected option
     */
    public int selectedOption () {
        repaint();
        revalidate();
        while(!selected);
        return page;
    }
}
