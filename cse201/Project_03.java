package cse201;

import java.util.Random;
import java.util.Scanner;

public class Project_03 {
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		String input;
		System.out.print("Enter a string: ");
		input = scan.nextLine();
		if(Character.isSpace(input.charAt(0)))
			System.out.println("Empty string");
		else if(Character.isDigit(input.charAt(0)) && Character.isDigit(input.charAt(input.length()-1)))
			System.out.println(input + " is a number");
		else if (Character.isLetter(input.charAt(0)) && Character.isLetter(input.charAt(input.length()-1)))
			System.out.println(input + " is a word");
		else
			System.out.println(input + " is something else");
		
		Random rnd = new Random();
		int a = rnd.nextInt(20);
		int b = rnd.nextInt(20);
		int add = a + b;
		int sub = a - b;
		int mult = a * b;
		int div = a / b;
		int mod = a % b;
		System.out.println("Please answer the following questions: ");
		int correct = 0;
		System.out.print(a + " + " + b + " = ");
		int addIn = scan.nextInt();
		if(addIn == add){
			System.out.println("Correct!");
			correct++;
		}
		else
			System.out.println("Wrong!");
		
		System.out.print(a + " - " + b + " = ");
		int subIn = scan.nextInt();
		if(subIn == sub){
			System.out.println("Correct!");
			correct++;
		}
		else
			System.out.println("Wrong!");

		System.out.print(a + " * " + b + " = ");
		int multIn = scan.nextInt();
		if(multIn == mult){
			System.out.println("Correct!");
			correct++;
		}
		else
			System.out.println("Wrong!");

		System.out.print(a + " / " + b + " = ");
		int divIn = scan.nextInt();
		if(divIn == div){
			System.out.println("Correct!");
			correct++;
		}
		else
			System.out.println("Wrong!");

		System.out.print(a + " % " + b + " = ");
		int modIn = scan.nextInt();
		if(modIn == mod){
			System.out.println("Correct!");
			correct++;
		}
		else
			System.out.println("Wrong!");
		
		System.out.println("You got " + correct + " correct answers!");
		System.out.println("That's " + (correct/5.0)*100.0 + "%");
	}

}
