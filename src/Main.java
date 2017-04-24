import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import javax.swing.JFrame;

/**
 * 
 * @author Lauren Weiser, Emma Delucchi, Katrina Baber 4/24/2017, Gamble Main
 *         class plays a game of Gamble
 *
 */

public class Main {

	static Hand hand = new Hand();

	static Dice dice = new Dice();

	static Scorecard scorecard = new Scorecard();

	/**
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame start = new startFrame();
				start.setTitle("Get ready to play!");
				start.setLocation(400,100);
				start.setVisible(true);
				start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
			}
		});

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

			/**
			 * the user is able to bet on a scorecard line if they enter an
			 * invalid answer they are asked to try again
			 */
			while (flag1 == false) {
				Scanner input1 = new Scanner(System.in);
				System.out.println("Enter how much you would like to bet:");
				bet = input1.next();
				// int bet1 = Integer.parseInt(bet);
				if (!Hand.isNumeric(bet)) {
					System.out.println("Please enter a number");
				} else {
					flag1 = true;
				}
			}
			flag1 = false;

			while (flag2 == false) {
				Scanner input2 = new Scanner(System.in);
				System.out.println("Enter which line (1-13) you would like to bet on:");
				line = input2.next();

				if (!Hand.isNumeric(line)) {
					System.out.println("Please enter a number");
				}
				if (Hand.isNumeric(line)) {
					int line1 = Integer.parseInt(line);
					if (line1 > 13 || line1 < 1) {
						System.out.println("Please enter a valid response");
					} else {
						flag2 = true;
					}
				}

			}
			flag2 = false;

			/** resets hand each time they play a new game **/
			myHand = new Hand();
			myHand.setNumOfDie(numOfDie);
			myHand.setNumOfTurnLeft(numOfRolls);
			while (!myHand.getHandComplete()) {
				myHand.setCurrentHand(numOfSides);
			}
			ArrayList<Dice> hand = myHand.returnHand();
			int bet1 = Integer.parseInt(bet);
			int line1 = Integer.parseInt(line);
			System.out.println(myScorecard.upperSection(hand, numOfDie, numOfSides, bet1, line1));
			myScorecard.lowerSection(hand, numOfSides, numOfDie, bet1, line1);
			// myScorecard.printPossible(); prints the current hands options
			myHand.gameComplete();

		}

	}

}
