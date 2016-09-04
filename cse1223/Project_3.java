package cse1223;

import java.util.Random;
import java.util.Scanner;

public class Project_3 {
	private static Scanner input = new Scanner(System.in);
	private static Random rnd = new Random();
	private static int a, b, add, sub, mult, div, mod, correct = 0, addIn, subIn, multIn, divIn, modIn;
	private static String name;
	public static void main (String[] args){
		a = rnd.nextInt(20);
		b = rnd.nextInt(20);
		add = a + b;
		sub = a - b;
		mult = a * b;
		div = a / b;
		mod = a % b;
		
		System.out.print("Enter your name: ");
		name = input.nextLine();
		System.out.println("Welcome "+ name+ "! Please answer the following questions: ");
		
		System.out.print(a + " + " + b + " = ");
		addIn = input.nextInt();
		if(addIn == add){
			System.out.println("Correct!");
			correct++;
		}
		else
			System.out.println("Wrong!");
		
		System.out.print(a + " - " + b + " = ");
		subIn = input.nextInt();
		if(subIn == sub){
			System.out.println("Correct!");
			correct++;
		}
		else
			System.out.println("Wrong!");

		System.out.print(a + " * " + b + " = ");
		multIn = input.nextInt();
		if(multIn == mult){
			System.out.println("Correct!");
			correct++;
		}
		else
			System.out.println("Wrong!");

		System.out.print(a + " / " + b + " = ");
		divIn = input.nextInt();
		if(divIn == div){
			System.out.println("Correct!");
			correct++;
		}
		else
			System.out.println("Wrong!");

		System.out.print(a + " % " + b + " = ");
		modIn = input.nextInt();
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
