package cse1223;

import java.util.Random;
import java.util.Scanner;

public class Project_5 {
	private static Random rnd = new Random();
	private static Scanner input = new Scanner (System.in);
	private static int in, random, count = 0;
	
	public static void main (String[] args){
		random = 1 +  rnd.nextInt(100);
		System.out.print("Enter your guess between 1 and 100: ");
		in = input.nextInt();
		
		while (in < 1 || in > 100){
			System.out.println("Your guess is out of bounds.");
			System.out.print("Enter your guess between 1 and 100: ");
			in = input.nextInt();
		}
		
		if(in == random){
			System.out.println("That was lucky!");
			count++;
		}
		
		else{
			while (in != random){
				if(in > random){
					System.out.println("Too high.");
				}
				else if (in < random){
					System.out.println("Too low.");
				}
				System.out.print("Enter your guess between 1 and 100: ");
				in = input.nextInt();
				count ++;
			}
		}
		System.out.println("\nI had chosen " + random + " as the target number.\nYou guessed it in " + count + " tries.");
		if(count > 1 && count <= 4){
			System.out.println("That was amazing!");
		}
		else if (count > 4 && count <= 6){
			System.out.println("That was good!");
		}
		else if (count == 7){
			System.out.println("That was OK!");
		}
		else if (count > 7 && count <= 9){
			System.out.println("That was not very good!");
		}
		else if (count > 9){
			System.out.println("This just isn't your game!");
		}
	}

}
