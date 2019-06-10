package Menu;

import Main.DealWithIt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * This class is the SplashScreen that displays the company logo and game name.
 *
 * <p>
 * Version 1 - 2.5 hours
 * Created the basic outline of the class.
 * Initialized variables with default values.
 * Figured out how alpha and transparency works.
 * Added the drawImage() method that draws the specified image at a certain alpha.
 * Made sure the timer of each image works.
 * Figured out why the program would continue looping.
 * Learned about what this:actionPerformed does.
 *
 * Version 2 - 30 mins
 * Debugged and made sure the splash screen ran smoothly.
 * Made sure there were no errors.
 * </p>
 *
 * @author Hannah Kim
 * @version 05.24.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */
public class SplashScreen extends JPanel{

    /** This char variable stores the alpha of the animation */
    private char alpha;
    /** This boolean variable determines if the animation is fading or not */
    private boolean fade;
    /** This int variable counts the number of images ran */
    private volatile int count;
    /** This Image variable stores the logo image */
    private Image logo;
    /** This Image variable stores the splashScreen image */
    private Image splashScreen;

    /**
     * The constructor of the class where the SplashScreen is constructed, and instance
     * variables are initialized using default values.
     */
    public SplashScreen () {
        alpha = 0;
        fade = false;
        count = 0;

        logo = DealWithIt.imageFromFile ("Menu/logo.png");
        splashScreen = DealWithIt.imageFromFile ("Menu/splash.png");
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
        else
            alpha++;

        if (alpha == 255)
            fade = true;

        if (alpha == 0)
            counter();

        if (count == 0)
            drawImage (logo, alpha);
        else if (count == 1)
            drawImage (splashScreen, alpha);
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
     * This method starts playing the animation for the splash screen.
     */
    public void play() {
        revalidate();
        Timer time = new Timer(5, this::actionPerformed);
        time.start();
        while (count == 0);
        time = new Timer(5, this::actionPerformed);
        time.start();
        while (count == 1);
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
