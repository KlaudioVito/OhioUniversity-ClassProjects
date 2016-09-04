package cse1223;

import java.util.Random;
import java.util.Scanner;

public class Project_4 {
	private static Random rnd = new Random();
	private static Scanner input = new Scanner(System.in);
	private static char in;
	private static String R, P, S,cmp, user;
	private static int randomSelect;
	
	public static void main (String[] args){
		R = "Rock";
		P = "Paper";
		S = "Scissors";
		
		System.out.print("Select one of [R/P/S]: ");
		in = input.next().charAt(0);
		in = Character.toUpperCase(in);
		if (in == 'R') {
			user = R;
			System.out.println("Your choose: " + R);
		}
		else if (in == 'P'){
			user = P;
			System.out.println("Your choose: " + P);
		}
		else if(in == 'S'){
			user = S;
			System.out.println("Your choose: " + S);
		}
		else{
			user = R;
			System.out.println("Invalid choice! Defaulting to rock.");
		}
		
		randomSelect = rnd.nextInt(3);
		if(randomSelect == 0)
			cmp = R;
		else if (randomSelect == 1)
			cmp = P;
		else
			cmp = S;
		System.out.println("I chose " + cmp);
		
		if( (cmp == R && user == S) || (cmp == S && user == P) || (cmp == P && user == R)){
			System.out.println(cmp + " beats " + user + " - you lose!");
		}
		else if ((cmp == R && user == R) || (cmp == S && user == S) || (cmp == P && user == P)){
			System.out.println("A tie");
		}
		else{
			System.out.println(user + " beats " + cmp + " - you win");
		}
		
	}
}
