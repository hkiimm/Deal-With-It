package Game;

import Main.DealWithIt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This LevelTwo class is the second level of the game.
 *
 * <p>
 * Version 1 - 1 hour
 * Created the basic outline of the class.
 * Initialized variables in the constructor.
 * Called the class in the driver class, so it shows up when new game is clicked.
 *
 * Version 2 - 1 hour
 * Initialized the images as Characters and put them into organized arrays.
 * Added keyboard input and mousewhere.
 *
 * Version 3 - 1.5 hours
 * Added if statements for when the images should be shown.
 * Made sure that keyboard only works for some screens, and mousewhere only works for some screens.
 * Made reset method that resets variables, so program works as intended.
 *
 * Version 4 - 30 mins
 * Debugged program making sure everything works as intended.
 * </p>
 *
 * @author Hannah Kim
 * @version 06.07.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */
public class LevelTwo extends JPanel{

    /** This Image variable stores the background image. */
    private Image bg;
    /** This boolean variable holds if the level has been won. */
    private volatile boolean won;
    /** This boolean variable is true if the user selects yes. */
    private boolean yes;
    /** This boolean variable is true if the user selects no. */
    private boolean no;
    /** This boolean variable is true if the character is asking a question. */
    private boolean question;
    /** This int variable counts the number of times the space bar is pressed. */
    private int count;
    /** This Characters variable stores an array of introductory scenes. */
    private Characters[] intro;
    /** This Characters variable stores an array of questions the character asks. */
    private Characters[] questions;
    /** This Characters variable stores an array of answers for the option yes. */
    private Characters[] answerY;
    /** This Characters variable stores an array of answers for the option no. */
    private Characters[] answerN;

    /**
     * The constructor of the class where LevelTwo is constructed, and instance
     * variables are initialized using default values.
     *
     * The ActionMap checks if the space bar has been pressed.
     * The MouseListener checks where the mouse is located, and which option is clicked.
     */
    public LevelTwo () {
        won = false;
        yes = false;
        no = false;
        question = false;
        count = 0;
        bg = DealWithIt.imageFromFile ("Game/gym.png");

        intro = new Characters[3];
        intro[0] = new Characters ("Game/LVL2/intro.png", new Point (0,0));
        intro[1] = new Characters ("Game/LVL2/intro1.png", new Point (0,0));
        intro[2] = new Characters ("Game/LVL2/intro2.png", new Point (0,0));

        questions = new Characters[10];
        questions[0] = new Characters ("Game/LVL2/Questions/1q.png", new Point (0,0));
        questions[1] = new Characters ("Game/LVL2/Questions/2q.png", new Point (0,0));
        questions[2] = new Characters ("Game/LVL2/Questions/3q.png", new Point (0,0));
        questions[3] = new Characters ("Game/LVL2/Questions/4q.png", new Point (0,0));
        questions[4] = new Characters ("Game/LVL2/Questions/5q.png", new Point (0,0));
        questions[5] = new Characters ("Game/LVL2/Questions/6q.png", new Point (0,0));
        questions[6] = new Characters ("Game/LVL2/Questions/7q.png", new Point (0,0));
        questions[7] = new Characters ("Game/LVL2/Questions/8q.png", new Point (0,0));
        questions[8] = new Characters ("Game/LVL2/Questions/9q.png", new Point (0,0));
        questions[9] = new Characters ("Game/LVL2/Questions/10q.png", new Point (0,0));

        answerY = new Characters[10];
        answerY[0] = new Characters ("Game/LVL2/Yes/1y.png", new Point (0,0));
        answerY[1] = new Characters ("Game/LVL2/Yes/2y.png", new Point (0,0));
        answerY[2] = new Characters ("Game/LVL2/Yes/3y.png", new Point (0,0));
        answerY[3] = new Characters ("Game/LVL2/Yes/4y.png", new Point (0,0));
        answerY[4] = new Characters ("Game/LVL2/Yes/5y.png", new Point (0,0));
        answerY[5] = new Characters ("Game/LVL2/Yes/6y.png", new Point (0,0));
        answerY[6] = new Characters ("Game/LVL2/Yes/7y.png", new Point (0,0));
        answerY[7] = new Characters ("Game/LVL2/Yes/8y.png", new Point (0,0));
        answerY[8] = new Characters ("Game/LVL2/Yes/9y.png", new Point (0,0));
        answerY[9] = new Characters ("Game/LVL2/Yes/10y.png", new Point (0,0));

        answerN = new Characters[10];
        answerN[0] = new Characters ("Game/LVL2/No/1n.png", new Point (0,0));
        answerN[1] = new Characters ("Game/LVL2/No/2n.png", new Point (0,0));
        answerN[2] = new Characters ("Game/LVL2/No/3n.png", new Point (0,0));
        answerN[3] = new Characters ("Game/LVL2/No/4n.png", new Point (0,0));
        answerN[4] = new Characters ("Game/LVL2/No/5n.png", new Point (0,0));
        answerN[5] = new Characters ("Game/LVL2/No/6n.png", new Point (0,0));
        answerN[6] = new Characters ("Game/LVL2/No/7n.png", new Point (0,0));
        answerN[7] = new Characters ("Game/LVL2/No/8n.png", new Point (0,0));
        answerN[8] = new Characters ("Game/LVL2/No/9n.png", new Point (0,0));
        answerN[9] = new Characters ("Game/LVL2/No/10n.png", new Point (0,0));

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released SPACE"), "next_state");
        getActionMap().put("next_state", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (question == false)
                    count++;
                repaint();
            }
        });
        addMouseListener (new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 485 && e.getX() < 625 && e.getY() > 440 && e.getY() < 578) {
                    repaint();
                    yes = true;
                }
                else if (e.getX() > 695 && e.getX() < 835 && e.getY() > 440 && e.getY() < 578) {
                    repaint();
                    no = true;
                }
            }
        });
    }

    /**
     * This method gets called every time repaint() gets called to draw the images.
     * Only certain images are drawn due to the if statements.
     *
     * @param g the graphics to be drawn
     */
    @Override
    public void paintComponent(Graphics g) {
        DealWithIt.graphics = (Graphics2D) g;
        if (count != 13)
            g.drawImage (bg, 0, 0, null);

        if (count == 0)
            intro[0].drawImg();
        else if (count == 1)
            intro[1].drawImg();
        else if (count == 2)
            intro[2].drawImg();
        else if (count == 3) {
            question = true;
            questions[0].drawImg();
            if (yes == true) {
                g.drawImage (bg, 0, 0, null);
                answerY[0].drawImg();
                reset();
            }
            else if (no == true) {
                g.drawImage (bg, 0, 0, null);
                answerN[0].drawImg();
                reset();
            }
        }
        else if (count == 4) {
            question = true;
            questions[1].drawImg();
            if (yes == true) {
                g.drawImage (bg, 0, 0, null);
                answerY[1].drawImg();
                reset();
            }
            else if (no == true) {
                g.drawImage (bg, 0, 0, null);
                answerN[1].drawImg();
                reset();
            }
        }
        else if (count == 5) {
            question = true;
            questions[2].drawImg();
            if (yes == true) {
                g.drawImage (bg, 0, 0, null);
                answerY[2].drawImg();
                reset();
            }
            else if (no == true) {
                g.drawImage (bg, 0, 0, null);
                answerN[2].drawImg();
                reset();
            }
        }
        else if (count == 6) {
            question = true;
            questions[3].drawImg();
            if (yes == true) {
                g.drawImage (bg, 0, 0, null);
                answerY[3].drawImg();
                reset();
            }
            else if (no == true) {
                g.drawImage (bg, 0, 0, null);
                answerN[3].drawImg();
                reset();
            }
        }
        else if (count == 7) {
            question = true;
            questions[4].drawImg();
            if (yes == true) {
                g.drawImage (bg, 0, 0, null);
                answerY[4].drawImg();
                reset();
            }
            else if (no == true) {
                g.drawImage (bg, 0, 0, null);
                answerN[4].drawImg();
                reset();
            }
        }
        else if (count == 8) {
            question = true;
            questions[5].drawImg();
            if (yes == true) {
                g.drawImage (bg, 0, 0, null);
                answerY[5].drawImg();
                reset();
            }
            else if (no == true) {
                g.drawImage (bg, 0, 0, null);
                answerN[5].drawImg();
                reset();
            }
        }
        else if (count == 9) {
            question = true;
            questions[6].drawImg();
            if (yes == true) {
                g.drawImage (bg, 0, 0, null);
                answerY[6].drawImg();
                reset();
            }
            else if (no == true) {
                g.drawImage (bg, 0, 0, null);
                answerN[6].drawImg();
                reset();
            }
        }
        else if (count == 10) {
            question = true;
            questions[7].drawImg();
            if (yes == true) {
                g.drawImage (bg, 0, 0, null);
                answerY[7].drawImg();
                reset();
            }
            else if (no == true) {
                g.drawImage (bg, 0, 0, null);
                answerN[7].drawImg();
                reset();
            }
        }
        else if (count == 11) {
            question = true;
            questions[8].drawImg();
            if (yes == true) {
                g.drawImage (bg, 0, 0, null);
                answerY[8].drawImg();
                reset();
            }
            else if (no == true) {
                g.drawImage (bg, 0, 0, null);
                answerN[8].drawImg();
                reset();
            }
        }
        else if (count == 12) {
            question = true;
            questions[9].drawImg();
            if (yes == true) {
                g.drawImage (bg, 0, 0, null);
                answerY[9].drawImg();
                reset();
            }
            else if (no == true) {
                g.drawImage (bg, 0, 0, null);
                answerN[9].drawImg();
                reset();
            }
        }
        if (count == 13) {
            won = true;
        }
    }

    /**
     * This method resets the boolean variables to false everytime an image is drawn.
     * */
    private void reset () {
        yes = false;
        no = false;
        question = false;
    }

    /**
     * This method is used to update the images until the level is over.
     */
    public void startLvl2() {
        revalidate();
        repaint();
        while (!won);
    }
}
