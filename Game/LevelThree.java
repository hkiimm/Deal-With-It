package Game;

import Main.DealWithIt;
import Menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

/**
 * This LevelThree class is the final level of the game.
 *
 * <p>
 * Version 1 - 30 mins
 * Initialized the basic variables in the constructor.
 * Created the basic outline of the class.
 *
 * Version 2 - 1.5 hours
 * Initialized images in the constructor.
 * Set up keyboard input and mousewhere.
 * Started building if statements for game options.
 *
 * Version 3 - 2 hours
 * Finished conditional statements and tested for errors.
 * Debugged the code, so the program works.
 * Added the user input statement in the main menu to get the users name.
 *
 * Version 4 - 1 hour
 * Added the save method to save the data inside the arraylist into a file.
 * Ran the method by calling it after adding the new data.
 * </p>
 *
 * @author Hannah Kim
 * @version 06.09.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */
public class LevelThree extends JPanel {

    /** This Image variable stores the background image. */
    private Image bg;
    /**
     * This boolean variable holds if the level has been won.
     */
    private volatile boolean won;
    /**
     * This Characters variable is an array of character images.
     */
    private Characters[] charact;
    /**
     * This Characters variable is an array of character choice options.
     */
    private Characters[] options;
    /**
     * This Characters variable is an array of endings.
     */
    private Characters[] end;
    /**
     * This boolean variable is true if a character is asking a question.
     */
    private boolean question;
    /**
     * This int variable counts the number of times the space bar is pressed.
     */
    private int count;
    /**
     * This boolean variable is true if option a was selected.
     */
    private boolean a;
    /**
     * This boolean variable is true if option b was selected.
     */
    private boolean b;
    /**
     * This boolean variable is true if option c was selected.
     */
    private boolean c;
    /**
     * This int variable counts the number of points the user accumulates.
     */
    public int points;
    /**
     * This Menu variable holds the button that leads the user back to the main menu.
     */
    private Menu back;
    /**
     * This boolean variable checks if the button has been clicked.
     */
    private boolean click;
    /**
     * This String variable holds the users name at the end.
     */
    public String name;

    /**
     * The constructor of the class where LevelThree is constructed, and instance
     * variables are initialized using default values.
     *
     * The ActionMap checks if the space bar has been pressed.
     * The MouseListener checks where the mouse is located, and which option is clicked.
     */
    public LevelThree() {
        won = false;
        question = false;
        click = false;
        count = 0;
        points = 0;
        a = false;
        b = false;
        c = false;
        bg = DealWithIt.imageFromFile("Game/party.png");

        back = new Menu("Game/LVL3/menu.png", new Point(670, 540));

        charact = new Characters[11];
        charact[0] = new Characters("Game/LVL3/0.png", new Point(0, 0));
        charact[1] = new Characters("Game/LVL3/1.png", new Point(0, 0));
        charact[2] = new Characters("Game/LVL3/2.png", new Point(0, 0));
        charact[3] = new Characters("Game/LVL3/3.png", new Point(0, 0));
        charact[4] = new Characters("Game/LVL3/4.png", new Point(0, 0));
        charact[5] = new Characters("Game/LVL3/5.png", new Point(0, 0));
        charact[6] = new Characters("Game/LVL3/6.png", new Point(0, 0));
        charact[7] = new Characters("Game/LVL3/7.png", new Point(0, 0));
        charact[8] = new Characters("Game/LVL3/8.png", new Point(0, 0));
        charact[9] = new Characters("Game/LVL3/9.png", new Point(0, 0));
        charact[10] = new Characters("Game/LVL3/10.png", new Point(0, 0));

        options = new Characters[10];
        options[0] = new Characters("Game/LVL3/1a.png", new Point(0, 0));
        options[1] = new Characters("Game/LVL3/2a.png", new Point(0, 0));
        options[2] = new Characters("Game/LVL3/3a.png", new Point(0, 0));
        options[3] = new Characters("Game/LVL3/4a.png", new Point(0, 0));
        options[4] = new Characters("Game/LVL3/5a.png", new Point(0, 0));
        options[5] = new Characters("Game/LVL3/6a.png", new Point(0, 0));
        options[6] = new Characters("Game/LVL3/7a.png", new Point(0, 0));
        options[7] = new Characters("Game/LVL3/8a.png", new Point(0, 0));
        options[8] = new Characters("Game/LVL3/9a.png", new Point(0, 0));
        options[9] = new Characters("Game/LVL3/10a.png", new Point(0, 0));

        end = new Characters[4];
        end[0] = new Characters("Game/LVL3/11a.png", new Point(0, 0));
        end[1] = new Characters("Game/LVL3/11b.png", new Point(0, 0));
        end[2] = new Characters("Game/LVL3/end.png", new Point(0, 0));
        end[3] = new Characters("Game/LVL3/end1.png", new Point(0, 0));

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released SPACE"), "next_state");
        getActionMap().put("next_state", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!question && count != 12)
                    count++;
                repaint();
            }
        });
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 415 && e.getX() < 1255 && e.getY() > 50 && e.getY() < 210) {
                    repaint();
                    a = true;
                } else if (e.getX() > 415 && e.getX() < 1255 && e.getY() > 253 && e.getY() < 410) {
                    repaint();
                    b = true;
                } else if (e.getX() > 415 && e.getX() < 1255 && e.getY() > 455 && e.getY() < 615) {
                    repaint();
                    c = true;
                }
                if (count == 12) {
                    if (e.getX() > 670 && e.getX() < 1090 && e.getY() > 540 && e.getY() < 613) {
                        click = true;
                    }
                }
            }
        });
    }

    /**
     * This method gets called every time repaint() gets called to draw the images.
     *
     * @param g the graphics to be drawn
     */
    @Override
    public void paintComponent(Graphics g) {
        DealWithIt.graphics = (Graphics2D) g;
        if (count != 12)
            g.drawImage(bg, 0, 0, null);

        if (count == 0)
            charact[0].drawImg();
        else if (count == 1) {
            charact[1].drawImg();
            reset();
        }
        else if (count == 2) {
            options[0].drawImg();
            question = true;
            if (a || b || c) {
                g.drawImage(bg, 0, 0, null);
                charact[2].drawImg();
                if (a) points++;
                reset();
            }
        } else if (count == 3) {
            options[1].drawImg();
            question = true;
            if (a || b || c) {
                g.drawImage(bg, 0, 0, null);
                charact[3].drawImg();
                if (c) points++;
                reset();
            }
        } else if (count == 4) {
            options[2].drawImg();
            question = true;
            if (a || b || c) {
                g.drawImage(bg, 0, 0, null);
                charact[4].drawImg();
                if (a) points++;
                reset();
            }
        } else if (count == 5) {
            options[3].drawImg();
            question = true;
            if (a || b || c) {
                g.drawImage(bg, 0, 0, null);
                charact[5].drawImg();
                if (b) points++;
                reset();
            }
        } else if (count == 6) {
            options[4].drawImg();
            question = true;
            if (a || b || c) {
                g.drawImage(bg, 0, 0, null);
                charact[6].drawImg();
                if (c) points++;
                reset();
            }
        } else if (count == 7) {
            options[5].drawImg();
            question = true;
            if (a || b || c) {
                g.drawImage(bg, 0, 0, null);
                charact[7].drawImg();
                if (c) points++;
                reset();
            }
        } else if (count == 8) {
            options[6].drawImg();
            question = true;
            if (a || b || c) {
                g.drawImage(bg, 0, 0, null);
                charact[8].drawImg();
                if (c) points++;
                reset();
            }
        } else if (count == 9) {
            options[7].drawImg();
            question = true;
            if (a || b || c) {
                g.drawImage(bg, 0, 0, null);
                charact[9].drawImg();
                if (a) points++;
                reset();
            }
        } else if (count == 10) {
            options[8].drawImg();
            question = true;
            if (a || b || c) {
                g.drawImage(bg, 0, 0, null);
                charact[10].drawImg();
                if (b) points++;
                reset();
            }
        } else if (count == 11) {
            options[9].drawImg();
            question = true;
            if (a || b || c) {
                if (b || c) {
                    points++;
                    reset();
                }
                if (points >= 8) {
                    g.drawImage(bg, 0, 0, null);
                    end[0].drawImg();
                } else {
                    g.drawImage(bg, 0, 0, null);
                    end[1].drawImg();
                }
            }
        } else if (count == 12) {
            if (points >= 8) {
                end[2].drawImg();
                back.draw();
            } else {
                end[3].drawImg();
                back.draw();
            }
        }
        if (click) {
            won = true;
        }
    }

    /**
     * This method resets the boolean variables to false.
     */
    private void reset() {
        a = false;
        b = false;
        c = false;
        question = false;
    }

    /**
     * This method writes to the file named "highscores.txt".
     * It saves the data in the arraylist into a file.
     */
    public void save() {
        PrintWriter output;
        try {
            output = new PrintWriter(new FileWriter("highscores.txt"));
            for (int i = 0; i < DealWithIt.highScore.size(); i++) {
                output.println(DealWithIt.highScore.get(i).name);
                output.println(DealWithIt.highScore.get(i).score);
            }
            output.close();
        } catch (IOException | NullPointerException e) {
        }
    }

    /**
     * This method is used to update the images until the level is over.
     *
     * @return the number of points the user obtains
     */
    public int startLvl3() {
        revalidate();
        repaint();
        while (!won);
        return points;
    }
}