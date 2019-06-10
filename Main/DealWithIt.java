package Main;

import Game.LevelOne;
import Game.LevelTwo;
import Game.LevelThree;
import Game.Score;
import HighScore.HighScores;
import GameMenu.HoldingScreen;
import Menu.SplashScreen;
import Menu.Goodbye;
import Menu.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the DealWithIt driver class that runs the program.
 *
 * <p>
 * Version 1 - 30 mins
 * Added the BufferedImage reader to get the image from the file.
 * Initialized the dimensions and frames of the screen.
 *
 * Version 2 - 30 mins
 * Added the SplashScreen object to the main method.
 * Tested for errors.
 *
 * Version 3 - 30 mins
 * Added the while loop and main menu object.
 * Tested for errors in the main menu by adding a switch statement.
 * Used System.out.println as place holders of actual objects.
 *
 * Version 4 - 1 hour
 * Added the level 1, instructions, and goodbye objects.
 * Kept high scores as a place holder.
 * Set the screens to a JPanel variable called currentScreen.
 *
 * Version 5 - 1 hour
 * Added the level 2 and 3 objects.
 * Added the HoldingScreen object between each class.
 * Made sure it worked and debugged incase there were problems in the flow.
 *
 * Version 6 - 2 hours
 * Added the HighScores object.
 * Added the readHS() method that reads a text file and adds the scores to the ArrayList.
 * Problems with the location of the file, therefore had to debug and make sure there were no problems.
 * Made sure the try catch worked.
 * </p>
 *
 * @author Hannah Kim
 * @version 06.09.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */
public class DealWithIt {

    /** This JPanel variable holds the current screen that is being displayed. */
    public static JPanel currentScreen;
    /** This JFrame variable is the main frame being used. */
    public static JFrame frame;
    /** This Graphics2D variable holds the graphics that are being drawn. */
    public static Graphics2D graphics;
    /** This List variable stores the name and score of all the players. */
    public static List<Score> highScore;
    /** This String variable gets the name of the user after they complete level 3. */
    public static String name;

    /**
     * This method retrieves an image from a file.
     *
     * @param path the path to get the image
     * @return returns the image that was retrieved from the file
     */
    public static BufferedImage imageFromFile(String path) {
        try {
            URL resource = DealWithIt.class.getClassLoader().getResource(path);
            if (resource == null) throw new NullPointerException();
            return ImageIO.read(resource);
        } catch (IOException | NullPointerException e) {
            System.err.println("There was an error retrieving " + path);
        }
        return null;
    }

    /**
     * This method reads the names and scores stored inside the "highscores.txt" file.
     * Adds the data onto an ArrayList called highScore.
     */
    private static void readHS() {
        BufferedReader input;
        try {
            input = new BufferedReader(new FileReader("highscores.txt"));
            String line = input.readLine();
            while (line != null) {
                String name = line;
                int score = Integer.parseInt(input.readLine());
                highScore.add(new Score(name,score));
                line = input.readLine();
            }
            input.close();
        }
        catch (IOException e) {
            System.err.println ("There was an error retrieving highscores.hk");
        }
    }

    /**
     * Initialize the JFrame to be able to use in the rest of the program.
     */
    private static void initializeFrame() {
        frame = new JFrame();
        frame.setSize(1320, 990);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    /**
     * The main method runs the game.
     *
     * @param args String arguments used in the command line
     */
    public static void main(String args[]) {
        highScore = new ArrayList<>();
        readHS();
        SwingUtilities.invokeLater(DealWithIt::initializeFrame);
        SplashScreen splash = new SplashScreen();
        frame.add (splash);
        splash.play();
        currentScreen = splash;
        while (frame.isVisible()) {
            frame.remove(currentScreen);
            MainMenu menu = new MainMenu();
            frame.add(menu);
            int n = menu.selectedOption();
            currentScreen = menu;
            switch (n) {
                case 1:
                    frame.remove (currentScreen);
                     LevelOne lvl1 = new LevelOne();
                    frame.add(lvl1);
                    lvl1.startLvl1();
                    currentScreen = lvl1;
                    frame.remove (currentScreen);
                    HoldingScreen screen = new HoldingScreen();
                    frame.add(screen);
                    int x = screen.play();
                    currentScreen = screen;
                    if (x == 2)
                        break;
                    else
                        frame.remove(currentScreen);
                    LevelTwo lvl2 = new LevelTwo();
                    frame.add(lvl2);
                    lvl2.startLvl2();
                    currentScreen = lvl2;
                    frame.remove (currentScreen);
                    HoldingScreen screen1 = new HoldingScreen();
                    frame.add(screen1);
                    int y = screen1.play();
                    currentScreen = screen1;
                    if (y == 2)
                        break;
                    else
                        frame.remove(currentScreen);
                    LevelThree lvl3 = new LevelThree();
                    frame.add(lvl3);
                    int i = lvl3.startLvl3();
                    currentScreen = lvl3;
                    name = JOptionPane.showInputDialog(frame, "Please enter your name: ");
                    highScore.add (new Score(name,i));
                    lvl3.save();
                    break;
                case 2:
                    frame.remove (currentScreen);
                    HighScores score = new HighScores();
                    frame.add(score);
                    score.clicked();
                    currentScreen = score;
                    break;
                case 3:
                    frame.remove (currentScreen);
                    Instructions ins = new Instructions();
                    frame.add(ins);
                    ins.back();
                    currentScreen = ins;
                    break;
                case 4:
                    frame.remove(currentScreen);
                    Goodbye bye = new Goodbye();
                    frame.add(bye);
                    bye.play();
                    currentScreen = bye;
                    frame.setVisible (false);
                    frame.dispose ();
                    break;
            }
        }
    }
}
