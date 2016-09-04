package cse1223;

import java.util.Scanner;

public class Project_9 {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter a number(Q to quit): ");
	      String input = scan.nextLine();
	      input = input.toUpperCase();
	      char quit = input.charAt(0);
	      while (quit != 'Q'){
	    	  System.out.println("The Roman Numeral " + input + " is the number " + decode(input) + "\n");
	    	  System.out.print("Enter a number(Q to quit): ");
	          input = scan.nextLine();
	          input = input.toUpperCase();
		      quit = input.charAt(0);
	      }
	      if(quit == 'Q'){
	    	  System.out.println("Goodbye!");
	    	  System.exit(0);
	      }
	}
	private static int decodeSingle(char letter) {
		switch(letter) {
			case 'M': return 1000;
			case 'D': return 500;
			case 'C': return 100;
			case 'L': return 50;
			case 'X': return 10;
			case 'V': return 5;
			case 'I': return 1;
			default: return 0;
		}
	}
	public static int decode(String roman) {
		int result = 0;
		String uRoman = roman.toUpperCase(); //case-insensitive
		for(int i = 0;i < uRoman.length() - 1;i++) {//loop over all but the last character
			//if this character has a lower value than the next character
			if (decodeSingle(uRoman.charAt(i)) < decodeSingle(uRoman.charAt(i+1))) {
				//subtract it
				result -= decodeSingle(uRoman.charAt(i));
			} else {
				//add it
				result += decodeSingle(uRoman.charAt(i));
			}
		}
		//decode the last character, which is always added
		result += decodeSingle(uRoman.charAt(uRoman.length()-1));
		return result;
	}
}
