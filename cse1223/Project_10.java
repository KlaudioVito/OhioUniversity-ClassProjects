package cse1223;

import java.util.Random;
import java.util.Scanner;

public class Project_10 {

	private static Random rnd = new Random();
	private static int[] currentDice = new int [5];
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Fill in the body
		rollDice(currentDice);
		promptForReroll(currentDice, scan);
		System.out.println(getResult(currentDice) + "\n");
		while(promptForPlayAgain(scan) == true){
			resetDice(currentDice);
			rollDice(currentDice);
			promptForReroll(currentDice, scan);
			System.out.println(getResult(currentDice) + "\n");
		}
	}
	
	// Given an array of integers as input, sets every element of the array to zero.
	private static void resetDice(int[] dice) {
		// Fill in the body
		for(int i = 0; i < dice.length; i++)
			dice[i] = 0;
	}
	
	// Given an array of integers as input, checks each element of the array.  If the value
	// of that element is zero, generate a number between 1 and 6 and replace the zero with
	// it.  Otherwise, leave it as is and move to the next element.
	private static void rollDice(int[] dice) {
		// Fill in the body
		for(int i = 0; i < dice.length; i++){
			if(dice[i] == 0){
				dice[i] = rnd.nextInt(6) + 1;
			}
		}
	}
	
	// Given an array of integers as input, create a formatted String that contains the
	// values in the array in the order they appear in the array.  For example, if the 
	// array contains the values [0, 3, 6, 5, 2] then the String returned by this method
	// should be "0 3 6 5 2".
	private static String diceToString(int[] dice) {
		// Fill in the body
		String dices = "";// = Arrays.toString(dice);
		for(int i = 0; i < dice.length; i++){
			dices = dices + dice[i] + " ";
		}
		return dices;			
	}
	
	
	// Given an array of integers and a Scanner as input, prompt the user with a message
	// to indicate which dice should be re-rolled.  If the user enters a valid index (between
	// 0 and the total number of dice -1) then set the die at that index to zero.  If the 
	// user enters a -1, end the loop and return to the calling program.  If the user enters
	// any other invalid index, provide an error message and ask again for a valid index.
	private static void promptForReroll(int[] dice, Scanner inScanner) {
		// Fill in the body
		int rolls = 4;
		System.out.println("You current dice is " + diceToString(dice));
		System.out.print("Select a die to re-roll (-1 to keep remaining dice): ");
		int input = inScanner.nextInt();
		while (input < -3 || input > 4){
			System.out.println("Error: Index must be between 0 and 4 (-1 to quit)!");
			promptForReroll(dice, inScanner);
		}
		while (input > -2 && input < 5 && rolls > 0){
			System.out.println("Remaining rolls: " + rolls);
			if (input == -1){
				System.out.println("Keeping remaining dice...");
				break;
			}
			else{
				dice[input] = 0;
				rollDice(dice);
				System.out.println("You current dice is " + diceToString(dice));
				System.out.print("Select a die to re-roll (-1 to keep remaining dice): ");
				input = inScanner.nextInt();
			}
			rolls--;
		}
	}
	
	// Given a Scanner as input, prompt the user to play again.  The only valid entries
	// from the user are 'Y' or 'N', in either upper or lower case.  If the user enters
	// a 'Y' the method should return a value of true to the calling program.  If the user
	// enters a 'N' the method should return a value of false.  If the user enters anything
	// other than Y or N (including an empty line), an error message should be displayed
	// and the user should be prompted again until a valid response is received.
	private static boolean promptForPlayAgain(Scanner inScanner) {
		// Fill in body
		System.out.print("Would you like to play again [Y/N]?: ");
		char userChoice = inScanner.next().charAt(0);
		userChoice = Character.toLowerCase(userChoice);
		
		while(userChoice != 'n' && userChoice != 'y'){
			System.out.println("ERROR! Only 'Y' or 'N' allowed as input!");
			System.out.print("Would you like to play again [Y/N]?: ");
			userChoice = inScanner.next().charAt(0);
			userChoice = Character.toLowerCase(userChoice);
		}

		if(userChoice == 'y'){
			return true;
		}
		else{
			System.out.println("Thanks for playing. Goodbye!");
			return false;
		}	
	}
	
	// Given an array of integers, determines the result as a hand of Poker Dice.  The
	// result is determined as:
	//	* Five of a kind - all five integers in the array have the same value
	//	* Four of a kind - four of the five integers in the array have the same value
	//	* Full House - three integers in the array have the same value, and the remaining two
	//					integers have the same value as well (Three of a kind and a pair)
	//	* Three of a kind - three integers in the array have the same value
	//	* Two pair - two integers in the array have the same value, and two other integers
	//					in the array have the same value
	//	* One pair - two integers in the array have the same value
	//	* Highest value - if none of the above hold true, the Highest Value in the array
	//						is used to determine the result
	//
	//	The method should evaluate the array and return back to the calling program a String
	//  containing the score from the array of dice.
	//
	//  EXTRA CREDIT: Include in your scoring a Straight, which is 5 numbers in sequence
	//		[1,2,3,4,5] or [2,3,4,5,6].
	private static String getResult(int[] dice) {
		// Fill in the body
		int[] counts = getCounts(dice);
	    String score = " ";

	    for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 5) {
                score = "Five of a kind ";
                break;
            } 
            else if (counts[i] == 4) {
            	score = "Four of a kind "; 
                break;
            } 
            else if (counts[i] == 3) {
            	score = "Three of a Kind ";
                for (int j = 0; j < counts.length; j++) {
                    if (counts[j]==2) {
                    	score = "Full House "; 
                        break;
                    }
                }
                break;
            }
            else if (counts[i] == 1){
            	for(int j = 0; j < counts.length; j++){
            		if(counts[j] == 1 && j != 1){
            			score = "Straight!";
            			break;
            		}
            	}
            }
            else if (counts[i] == 2) {
            	score = "One Pair ";
                for (int j = 0; j < counts.length; j++) {
                    if (counts[j] == 2 && j != i) {
                    	score = "Two Pairs "; 
                        break;
                    }
                }
               break;
            } 
            else {
            	score = "Highest Card ";
            }
        }
        return score;
	}
	
	// Given an array of integers as input, return back an array with the counts of the
	// individual values in it.  You may assume that all elements in the array will have 
	// a value between 1 and 6.  For example, if the array passed into the method were:
	//   [1, 2, 3, 3, 5]
	// Then the array of counts returned back by this method would be:
	// [1, 1, 2, 0, 1, 0]
	// (Where index 0 holds the counts of the value 1, index 1 holds the counts of the value
	//  2, index 2 holds the counts of the value 3, etc.)
	// HINT:  This method is very useful for determining the score of a particular hand
	//  of poker dice.  Use it as a helper method for the getResult() method above.
	private static int[] getCounts(int[] dice) {
		// Fill in the body
		int count[] = new int [6];
		for (int i = 0; i < dice.length; i++){
			if(dice[i] == 1)
				count[0]++;
			else if (dice[i] == 2)
				count[1]++;
			else if (dice[i] == 3)
				count[2]++;
			else if (dice[i] == 4)
				count[3]++;
			else if (dice[i] == 5)
				count[4]++;
			else if (dice[i] == 6)
				count[5]++;
		}
		return count;
	}
}
