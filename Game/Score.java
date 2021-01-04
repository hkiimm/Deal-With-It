package Game;

/**
 * This class creates a new high score for every player.
 *
 * <p>
 * Version 1 - 10 mins
 * Created the constructor to make the new Score objects.
 * toString method creates a string of the two variables.
 * </p>
 *
 * @author Hannah Kim, Sophia Nguyen
 * @version 06.06.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Ms. Krasteva
 */
public class Score {
    /** This String variable holds the name of the user. */
    public String name;
    /** This int variable stores the score the user obtained. */
    public int score;

    /**
     * The constructor of the class constructs a new Score, and instance
     * variables are initialized using values passed through the parameters.
     *
     * @param n name of the user
     * @param s score of the user
     */
    public Score(String n, int s) {
        name = n;
        score = s;
    }

    /**
     * This method returns the name and score to be written in the ArrayList.
     *
     * @return name and score of the user
     */
    @Override
    public String toString() {
        return "" + name + ":" + score;
    }
}
