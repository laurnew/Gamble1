
import java.util.ArrayList;

/**
 * @author Lauren Weiser, Emma Delucchi, Katrina Baber 4/24/2017, Gamble The
 *         Scorecard class uses the hand from the user's Yahtzee game to
 *         calculate the user's score on each line of the scorecard and display
 *         it
 */
public class Scorecard {

	static ArrayList<Integer> scoreRecord = new ArrayList<Integer>();

	int ifWon = 0;
	static int money = 0;

	/**
	 * initializes the Scorecard class
	 */
	public Scorecard() {
		for (int j = 0; j < 13; j++) {
			scoreRecord.add(0);
		}
	}

	/**
	 * calculates total score of upper section and prints scores of each line
	 * @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 * @param lineBet
	 *            containing the player's hand, number of dice, number of sides
	 * @returns total upper section score
	 */
	public static int upperSection(ArrayList<Dice> hand, int numOfDie, int numOfSides, int BET, int lineBet) {
		int won = 0;
		for (int dieValue = 1; dieValue <= numOfSides; dieValue++) { // num of
																		// sides
																		// + 1
			int currentCount = 0;
			for (int diePosition = 0; diePosition < numOfDie - 1; diePosition++) { // num
																					// of
																					// sides
				if (hand.get(diePosition).getRoll() == dieValue)
					currentCount++;
			}
			if (dieValue == lineBet) {
				won = dieValue * currentCount * BET;
				scoreRecord.add(won);
				money += won;
			} else
				scoreRecord.add(0);
		}
		if (won == 0) {
			won = (BET * -1);
			money += won;
			return won;
		} else
			return won;

	}

	/**
	 * calculates total score of lower section containing 
	 * the player's hand, number of sides, number of dice
	 * 
	 * @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 * @param betline
	 * @return total lower section score
	 */
	public static int lowerSection(ArrayList<Dice> hand, int numOfSides, int numOfDie, int BET, int betline) {
		int won = 0;
		int start = numOfDie + 1;
		if (betline == start) {
			won = threeOfAKind(hand, numOfDie, numOfSides, BET);
			scoreRecord.add(won);
			money += won;
		} else if (betline != start) {
			scoreRecord.add(0);
		} else if (betline == start + 1) {
			won = fourOfAKind(hand, numOfDie, numOfSides, BET);
			scoreRecord.add(won);
			money += won;
		} else if (betline != start + 1) {
			scoreRecord.add(0);
		} else if (betline == start + 2) {
			won = scoreFullHouse(hand, numOfSides, numOfDie, BET);
			scoreRecord.add(won);
			money += won;
		} else if (betline != start + 2) {
			scoreRecord.add(0);
		} else if (betline == start + 3) {
			won = smallStraight(hand, numOfDie, BET);
			scoreRecord.add(won);
			money += won;
		} else if (betline != start + 3) {
			scoreRecord.add(0);
		} else if (betline == start + 4) {
			won = largeStraight(hand, numOfDie, BET);
			scoreRecord.add(won);
			money += won;
		} else if (betline != start + 4) {
			scoreRecord.add(0);
		} else {
			won = YAHTZEE(hand, numOfDie, BET);// Yahtzee!!
			scoreRecord.add(won);
			money += won;
		}
		if (won == 0) {
			won = (BET * -1);
			money += 1;
			return won;
		} else
			return won;
	}

	/**
	 * calculates and displays score for three of a kind line
	 * containing the player's hand, number of dice, number of sides
	 * @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 *            
	 * @return score for that line
	 */
	public static int threeOfAKind(ArrayList<Dice> hand, int numOfDie, int numOfSides, int BET) {
		int numSame = 0;
		for (int placeHolder = 0; placeHolder < numOfDie - 1; placeHolder++) { // numOfDie
																				// -
																				// 1
																				// =
																				// 4
			if (hand.get(placeHolder).getRoll() == (hand.get(placeHolder + 1).getRoll())) {
				numSame += 1;
			} else {
				if (numSame < 3) { // if they already have 3 they don't need
									// more in order
					numSame = 0;
				}
			}
		}
		if (numSame >= 3) {
			return BET * 2;
		} else {
			return 0;
		}
	}

	/**
	 * calculates and displays score for four of a kind line
	 * containing the player's hand, number of dice, number of sides
	 * @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 *            
	 * @return score for that line
	 */
	public static int fourOfAKind(ArrayList<Dice> hand, int numOfDie, int numOfSides, int BET) {
		int numSame = 0;
		for (int placeHolder = 0; placeHolder < numOfDie - 1; placeHolder++) { // numof
																				// die
																				// -
																				// 1
																				// =
																				// 4
			if (hand.get(placeHolder).getRoll() == (hand.get(placeHolder + 1).getRoll())) {
				numSame += 1;
			} else {
				if (numSame < 4) { // if they already have 4 they dont need more
									// in order
					numSame = 0;
				}
			}
		}
		if (numSame >= 4) {
			return BET * 2;
		} else {
			return 0;
		}
	}

	/**
	 * calculates and displays score for full house line
	 * containing the player's hand, number of sides, number of die
	 *@param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 *            
	 * @return score for that line
	 */
	public static int scoreFullHouse(ArrayList<Dice> hand, int numOfSides, int numOfDie, int BET) {
		int currentCount = 0;
		boolean threeOfKindFound = false;
		boolean twoOfKindFound = false;
		boolean greaterKind = false;
		for (int dieValue = 1; dieValue <= numOfSides; dieValue++) { // num of
																		// sides
																		// = 6
			for (int diePosition = 0; diePosition < numOfDie; diePosition++) // num
																				// of
																				// die
																				// =
																				// 5
			{
				if (hand.get(diePosition).getRoll() == dieValue) {
					currentCount += 1;
				}
			}
			if (currentCount == 3) {
				threeOfKindFound = true;
			}
			if (currentCount == 2) {
				twoOfKindFound = true;
			}
			if (currentCount >= 5) {
				greaterKind = true;
			}
			currentCount = 0;
		}
		if ((threeOfKindFound && twoOfKindFound) || greaterKind) {
			return 2 * BET;
		} else {
			return 0;
		}
	}

	/**
	 * calculates and displays score for small straight line
	 * containing the player's hand, number of dice
	 * @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 *            
	 * @return score for that line
	 */
	public static int smallStraight(ArrayList<Dice> hand, int numOfDie, int BET) {
		int numInOrder = 0;
		for (int placeHolder = 0; placeHolder < numOfDie - 1; placeHolder++) { // numofDie
																				// -
																				// 1
																				// =
																				// 4
			if (hand.get(placeHolder).getRoll() == (hand.get(placeHolder + 1).getRoll() - 1)) {
				numInOrder += 1;
			} else if (hand.get(placeHolder).getRoll() == (hand.get(placeHolder + 1).getRoll())) {
				numInOrder += 0; // nothing happens
			} else {
				if (numInOrder < 3) { // if they already have 4 they dont need
										// more in order
					numInOrder = 0;
				}
			}
		}
		if (numInOrder >= 3) {
			return 3 * BET;
		} else {
			return 0;
		}
	}

	/**
	 * calculates and displays score for large straight line
	 * containing the player's hand, number of die
	 * @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 *            
	 * @return score for that line
	 */
	public static int largeStraight(ArrayList<Dice> hand, int numOfDie, int BET) {
		int numInOrder = 0;
		for (int placeHolder = 0; placeHolder < numOfDie - 1; placeHolder++) { // numOfDie
																				// -
																				// 1
																				// =
																				// 4
			if (hand.get(placeHolder).getRoll() != (hand.get(placeHolder + 1).getRoll() - 1)) {
				if (hand.get(placeHolder).getRoll() == (hand.get(placeHolder + 1).getRoll())) {
					numInOrder += 0; // nothing happens
				} else {
					numInOrder = 0; // sets zero if any not in order
				}
			} else {
				numInOrder += 1;
			}
		}
		if (numInOrder >= 4) {
			return 4 * BET;
		} else {
			return 0;
		}
	}

	/**
	 * calculates and displays score for yahtzee line
	 * containing the player's hand, number of die
	 *  @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 *            
	 * @return score for that line
	 */
	public static int YAHTZEE(ArrayList<Dice> hand, int numOfDie, int BET) {
		boolean YAHTZEE = true;
		// ASSUME LIST IS SORTED
		for (int placeHolder = 0; placeHolder < numOfDie - 1; placeHolder++) { // numOfDie
																				// -
																				// 1
																				// =
																				// 4
			if (hand.get(placeHolder).getRoll() != (hand.get(placeHolder + 1).getRoll())) {
				YAHTZEE = false; // sets zero if any not in order
			}
		}
		if (YAHTZEE) {
			return 10 * BET;
		} else {
			return 0;
		}
	}

}
