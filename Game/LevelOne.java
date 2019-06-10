package Game;

import Main.DealWithIt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * This LevelOne class is the first level of the game.
 *
 * <p>
 * Version 1 - 30 mins
 * Created the basic frame of the level.
 * Drew the background onto the class.
 *
 * Version 2 - 30 mins
 * Initialized the variables in the constructor.
 * Added the images into an array of Characters.
 * Set up keyboard input.
 *
 * Version 3 - 30 mins
 * Added the if statements.
 * Finished the level and made sure it doesn't crash.
 * </p>
 *
 * @author Hannah Kim, Sophia Nguyen
 * @version 06.01.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */


public class LevelOne extends JPanel{

    /** This Image variable stores the background image. */
    private Image bg;
    /** This boolean variable holds if the level has been won. */
    private volatile boolean won;
    /** This int variable holds the number of times the user presses the space bar. */
    private int count;
    /** This Characters variable stores an array of scenes. */
    private Characters[] scenes;

    /**
     * The constructor of the class where LevelOne is constructed, and instance
     * variables are initialized using default values.
     *
     * The ActionMap checks if the space bar has been pressed.
     */
    public LevelOne () {
        won = false;
        count = 0;

        bg = DealWithIt.imageFromFile ("Game/classroom.png");

        scenes = new Characters[13];
        scenes[0] = new Characters ("Game/LVL1/1.png", new Point (0,0));
        scenes[1] = new Characters ("Game/LVL1/2.png", new Point (0,0));
        scenes[2] = new Characters ("Game/LVL1/3.png", new Point (0,0));
        scenes[3] = new Characters ("Game/LVL1/4.png", new Point (0,0));
        scenes[4] = new Characters ("Game/LVL1/5.png", new Point (0,0));
        scenes[5] = new Characters ("Game/LVL1/6.png", new Point (0,0));
        scenes[6] = new Characters ("Game/LVL1/7.png", new Point (0,0));
        scenes[7] = new Characters ("Game/LVL1/8.png", new Point (0,0));
        scenes[8] = new Characters ("Game/LVL1/9.png", new Point (0,0));
        scenes[9] = new Characters ("Game/LVL1/10.png", new Point (0,0));
        scenes[10] = new Characters ("Game/LVL1/11.png", new Point (0,0));
        scenes[11] = new Characters ("Game/LVL1/12.png", new Point (0,0));
        scenes[12] = new Characters ("Game/LVL1/13.png", new Point (0,0));

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
        getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                repaint();
            }
        });
    }

    /**
     * This method gets called every time repaint() gets called to draw the images.
     *
     * @param g the graphics to be drawn
     */
    @Override
    public void paintComponent(Graphics g)
    {
        DealWithIt.graphics = (Graphics2D) g;
        if (count != 13)
            g.drawImage (bg, 0, 0, null);

        if (count == 0)
            scenes[0].drawImg();
        else if (count == 1)
            scenes[1].drawImg();
        else if (count == 2)
            scenes[2].drawImg();
        else if (count == 3)
            scenes[3].drawImg();
        else if (count == 4)
            scenes[4].drawImg();
        else if (count == 5)
            scenes[5].drawImg();
        else if (count == 6)
            scenes[6].drawImg();
        else if (count == 7)
            scenes[7].drawImg();
        else if (count == 8)
            scenes[8].drawImg();
        else if (count == 9)
            scenes[9].drawImg();
        else if (count == 10)
            scenes[10].drawImg();
        else if (count == 11)
            scenes[11].drawImg();
        else if (count == 12)
            scenes[12].drawImg();
        if (count == 13)
            won = true;
    }

    /**
     * This method is used to update the images until the level is over.
     */
    public void startLvl1() {
        revalidate();
        repaint();
        while (!won);
    }
}