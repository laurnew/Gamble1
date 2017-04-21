import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Spring;

public class Main {

	static Hand hand = new Hand();

	static Dice dice = new Dice();

	static Scorecard scorecard = new Scorecard();

	public static void main(String[] args) {
		int numOfSides = 6;
		int numOfRolls = 4;
		int numOfDie = 5;

		Hand myHand = new Hand();
		myHand.setNumOfDie(numOfDie);
		myHand.setNumOfTurnLeft(numOfRolls);
		Scorecard myScorecard = new Scorecard();
		Boolean allUsed = false;
		Boolean flag1 = false;
		Boolean flag2 = false;
		while (!myHand.getGameComplete() && !allUsed) {
			String bet = null;
			String line = null;

			while (flag1 == false) {
				Scanner input1 = new Scanner(System.in);
				System.out.println("Enter how much you would like to bet:");
				bet = input1.next();
				// int bet1 = Integer.parseInt(bet);
				if (!isNumeric(bet)) {
					System.out.println("Please enter a number");
				} else {
					flag1 = true;
				}
			}

			while (flag2 == false) {
				Scanner input2 = new Scanner(System.in);
				System.out.println("Enter which line (1-13) you would like to bet on:");
				line = input2.next();

				if (!isNumeric(line)) {
					System.out.println("Please enter a number");
				}
				if (isNumeric(line)) {
					int line1 = Integer.parseInt(line);
					if (line1 > 13 || line1 < 1) {
						System.out.println("Please enter a valid response");
					} else {
						flag2 = true;
					}
				}

			}

			int bet1 = Integer.parseInt(bet);
			int line1 = Integer.parseInt(line);

			myHand = new Hand(); // resets hand each time they play a new game
			myHand.setNumOfDie(numOfDie);
			myHand.setNumOfTurnLeft(numOfRolls);
			while (!myHand.getHandComplete()) {
				myHand.setCurrentHand(numOfSides);
			}
			ArrayList<Dice> hand = myHand.returnHand();
			System.out.println(myScorecard.upperSection(hand, numOfDie, numOfSides, bet1, line1));
			myScorecard.lowerSection(hand, numOfSides, numOfDie, bet1, line1);
			// myScorecard.printPossible(); prints the current hands options
			myHand.gameComplete();
		}

	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
