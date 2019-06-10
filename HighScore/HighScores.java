package HighScore;

import Game.Score;
import Main.DealWithIt;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * This HighScores class displays the high scores.
 *
 * <p>
 * Version 1 - 1.5 hour
 * Created the framework of the class.
 * Initialized the variables with default values.
 * Added the mouse where for the back button.
 * Figured out how to draw out the values stored in the ArrayList.
 *
 * Version 2 - 30 mins
 * Created the sort() method.
 * Sorted the data from greatest score, to lowest score using selection sort.
 * Sorts the data whenever the user checks high scores.
 * </p>
 *
 * @author Hannah Kim
 * @version 06.08.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */
public class HighScores extends JPanel{

    private volatile boolean selected;
    private Image bg;
    private Image back;

    /**
     *
     */
    public HighScores() {
        selected = false;

        bg = DealWithIt.imageFromFile ("HighScore/score.png");
        back = DealWithIt.imageFromFile ("HighScore/Back.png");

        addMouseListener (new MouseAdapter(){
            public void mousePressed (MouseEvent e) {
                if (e.getX() > 1063 && e.getX() < 1235 && e.getY() > 808 && e.getY() < 898) {
                    selected = true;
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
        g.drawImage (bg, 0, 0, null);
        g.drawImage(back, 1063, 808, null);

        g.setFont (new Font("Serif", Font.BOLD, 40));
        for (int i = 0; i < 10 && i < DealWithIt.highScore.size() ; i++) {
            Score score = DealWithIt.highScore.get(i);
            g.drawString(score.name, 375, 300 + 50 * i);
            g.drawString(String.valueOf(score.score), 900, 300 + 50 * i);
        }
    }

    public void sort() {
        for (int i = 0 ; i < DealWithIt.highScore.size() ; i++) {
            int maxIndex = i;
            for (int x = i ; x < DealWithIt.highScore.size() ; x++) {
                if (DealWithIt.highScore.get(x).score > DealWithIt.highScore.get(maxIndex).score)
                    maxIndex = x;
            }
            Score min = DealWithIt.highScore.get(maxIndex);
            DealWithIt.highScore.set (maxIndex, DealWithIt.highScore.get(i));
            DealWithIt.highScore.set (i, min);
        }
    }

    public void clicked () {
        sort();
        repaint();
        revalidate();
        while(!selected);
    }
}
