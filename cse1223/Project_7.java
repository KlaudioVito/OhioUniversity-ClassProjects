package cse1223;

import java.util.Random;
import java.util.Scanner;

public class Project_7 {
	private static Scanner inScanner = new Scanner(System.in);
	private static Random rnd = new Random();
	private static int pool=100, userBet, winnings = 0, die1, die2, total;
	private static char highLow;
	public static void main(String[] args) {
		// Fill in the body
		while(pool > 0){
			getBet(inScanner, pool);
			getHighLow(inScanner);
			die1 = getRoll();
			die2 = getRoll();
			total = die1+die2;
				System.out.println("Die 1 rolls: " + die1 + "\nDie 2 rolls: " + die2 + "\nTotal of 2 dices is: " + total);
			if(determineWinnings(highLow, userBet,total) == 0){
				System.out.println("You lost!\n");
			}
			else
				System.out.println("You won " + determineWinnings(highLow, userBet,total) + " dollars.\n");
			if(pool == 0){
				System.out.println("No more credit. Goodbye!\n");
			}
		}
	}
	
	
	// Given a Scanner and a current maximum amount of money, prompt the user for
	// an integer representing the number of dollars that they want to bet.  This
	// number must be between 0 and to maximum number of dollars.  If the user enters
	// a number that is out of bounds, display an error message and ask again.
	// Return the bet to the calling program.
	private static int getBet(Scanner inScanner, int currentPool) {
		// Fill in the body
		
		System.out.println("You have " + currentPool + " dollars.");
		
		if(currentPool < 0){
			System.out.println("You cashed out " + currentPool + " dollars.\n");
			System.exit(0);
		}
		
		System.out.print("Enter an amount to bet (0 to quit): ");
		userBet = inScanner.nextInt();
		if(userBet == 0){
			System.out.println("You cashed out " + currentPool + " dollars.\nGoodbye!");
			System.exit(0);
		}
		while(userBet < 0 || userBet > currentPool){
			System.out.println("Your bet MUST be between 0 and 100 dollars.");
			getBet(inScanner, currentPool);
		}
		pool -= userBet;
		
		
		return userBet;
	}
	
	// Given a Scanner, prompt the user for a single character indicating whether they
	// would like to bet High ('H'), Low ('L') or Sevens ('S').  Your code should accept
	// either capital or lowercase answers, but should display an error if the user attempts
	// to enter anything but one of these 3 values and prompt for a valid answer.
	// Return the character to the calling program.
	private static char getHighLow(Scanner inScanner) {
		// Fill in the body
		System.out.print("High, low or sevens (H/L/S): ");
		highLow = inScanner.next().charAt(0);
		highLow = Character.toLowerCase(highLow);
		while (highLow != 'l' && highLow != 'h' && highLow != 's'){
			System.out.print("Incorrect input. Try again: ");
			getHighLow(inScanner);
		}
		return highLow;
	}
	
	// Produce a random roll of a single six-sided die and return that value to the calling
	// program
	private static int getRoll() {
		// Fill in the body
		return (1 +  rnd.nextInt(6));
	}
	
	// Given the choice of high, low or sevens, the player's bet and the total result of
	// the roll of the dice, determine how much the player has won.  If the player loses
	// the bet then winnings should be negative.  If the player wins, the winnings should
	// be equal to the bet if the choice is High or Low and 4 times the bet if the choice
	// was Sevens.  Return the winnings to the calling program.
	private static int determineWinnings(char highLow, int bet, int roll) {
		// Fill in the body
		if(highLow == 'l' && roll <= 6){
			winnings = bet;
		}
		else if (highLow == 'h' && roll >= 8){
			winnings = bet;
		}
		else if (highLow =='s' && roll == 7){
			winnings = bet*4;
		}
		else 
			winnings = 0;
		
		pool += winnings;
		return winnings;
	}
}