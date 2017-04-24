import java.util.Random;

/**
 * @author Lauren Weiser, Emma Delucchi, Katrina Baber 4/24/2017, Gamble The
 *         Dice class creates a die object and "rolls it"
 */
public class Dice {
	/**
	 * initializes the class
	 */
	public Dice() {
		numOfSides = 1; // default so you know something's wrong
	}

	/**
	 * sets the numbers of sides on each die
	 * 
	 * @param num
	 */
	public void setNumOfSides(int num) {
		numOfSides = num;
		roll();
	}

	/**
	 * generates a random number between 1 and numOfSides
	 * 
	 * @return random number between 1 and numOfSides
	 */
	public int roll() {
		Random rand = new Random();
		faceUp = rand.nextInt(numOfSides) + 1;
		return faceUp;
	}

	/**
	 * @return faceUp
	 */
	public int getRoll() {
		return faceUp;
	}

	/**
	 * prints the roll
	 */
	public void print() {
		System.out.println(faceUp);
	}

	private int faceUp;
	private int numOfSides;

}