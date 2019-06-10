package Menu;

import Main.DealWithIt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * This class is the Goodbye that displays the fading goodbye screen.
 *
 * <p>
 * Version 1 - 30mins
 * Created the framework of the class.
 * Initialized variables in the constructor and added the alpha and face mechanism.
 * Added a timer that times the fading of the goodbye screen.
 * Once the goodbye screen stops fading, it closes the frame.
 *
 * Version 2 - 10mins
 * Checked for errors within the if statements.
 * Debugged and made sure the screen worked well without bugs.
 * </p>
 *
 * @author Hannah Kim
 * @version 05.27.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */
public class Goodbye extends JPanel{

    /** This char variable stores the alpha of the animation */
    private char alpha;
    /** This boolean variable determines if the animation is fading or not */
    private boolean fade;
    /** This int variable counts the number of images it's ran */
    private volatile int count;
    /** This Image variable stores the background image */
    private Image bg;

    /**
     * The constructor of the class where the Goodbye is constructed, and instance
     * variables are initialized using default values.
     */
    public Goodbye () {
        alpha = 255;
        fade = false;
        count = 0;

        bg = DealWithIt.imageFromFile ("Menu/goodbye.png");
    }

    /**
     * This method gets called every time repaint() gets called to draw the image
     * at the specified alpha.
     *
     * @param g the graphics to be drawn
     */
    @Override
    public void paintComponent(Graphics g) {
        DealWithIt.graphics = (Graphics2D) g;

        if (fade)
            alpha--;

        if (alpha == 255)
            fade = true;

        if (alpha == 0)
            counter();

        if (count == 0)
            //company logo is drawn
            drawImage (bg, alpha);
    }

    /**
     * This method draws an image at a specific alpha.
     *
     * @param image the image that's going to be drawn
     * @param alpha the alpha that it's going to be drawn at
     */
    private void drawImage(Image image, char alpha) {
        DealWithIt.graphics.setColor(Color.BLACK);
        DealWithIt.graphics.fillRect(0, 0, getWidth(), getHeight());
        DealWithIt.graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha / 255.f));
        DealWithIt.graphics.drawImage(image, (getWidth() - image.getWidth(null)) / 2, (getHeight() - image.getHeight(null)) / 2, null);
    }

    /**
     * This method starts playing the animation for the goodbye screen.
     */
    public void play() {
        revalidate();
        //Starts the animation
        Timer time = new Timer(20, this::actionPerformed);
        time.start();
        //while the logo is being displayed
        while (count == 0);

    }

    /**
     * This method is referenced when this::actionPerformed is used in the play() method.
     *
     * @param e instance of the ActionEvent class
     */
    private void actionPerformed (ActionEvent e) {
        repaint();
    }

    /**
     * This method is called when alpha == 0 to reset the variables.
     */
    private void counter(){
        count++;
        alpha = 0;
        fade= false;
    }
}
