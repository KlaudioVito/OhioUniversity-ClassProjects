package cse201;

import java.util.Scanner;

public class Project_02 {
	private static Scanner scan = new Scanner(System.in);
	private static Scanner scanString = new Scanner(System.in);
	
	public static void main (String[] args){
		
		for(int i = 0; i < 39; i++)
			System.out.print("*");
		System.out.println("\n* Welcome to your first Java program! *");
		for(int i = 0; i < 39; i++)
			System.out.print("*");
		
		System.out.println("\n*** Test integer arithmetic ***");
		System.out.print("Enter first integer number: ");
		int x = scan.nextInt();
		System.out.print("Enter second integer number: ");
		int y = scan.nextInt();
		System.out.println(
				  x + " + " + y +" = " + (x+y) +"\n"
				+ x + " - " + y +" = " + (x-y)+"\n" 
				+ x + " * " + y +" = " + (x*y)+"\n"
				+ x + " / " + y +" = " + (x/y)+"\n"
				+ x + " % " + y +" = " + (x%y)+"\n");
		
		System.out.println("\n*** Test real arithmetic ***");
		System.out.print("Enter first real number: ");
		double x1 = scan.nextDouble();
		System.out.print("Enter second reale number: ");
		double y1 = scan.nextDouble();
		System.out.println(
				  x1 + " + " + y1 +" = " + (x1+y1) +"\n"
				+ x1 + " - " + y1 +" = " + (x1-y1)+"\n" 
				+ x1 + " * " + y1 +" = " + (x1*y1)+"\n"
				+ x1 + " / " + y1 +" = " + (x1/y1)+"\n");
		
		System.out.println("\n*** Test String operations ***");
		System.out.print("Enter a string of characters: ");
		String input = scanString.nextLine();
		
		System.out.println("The length of string \"" + input + "\" is " + input.length());
		System.out.print("Enter an integer between 0 and " + input.length() + " :");
		int index = scan.nextInt();
		System.out.println("The character at index " + index + " of the string \"" + input + "\" is \'" + input.charAt(index)+"\'");
		System.out.print("Enter another string of characters: ");
		String subString = scanString.nextLine();
		System.out.println("The first occurrence of string \"" + subString + "\" in string \"" +input+ "\" is at position " + input.indexOf(subString) );
		
		System.out.println("\n*** One last test ***");
		System.out.print("Enter you birthday (mm/dd/yyyy): ");
		String bDay = scanString.nextLine();
		String euDay = bDay.substring(3, 5), euMonth = bDay.substring(0,2), euYear = bDay.substring(6,10);
		System.out.println("You were born on: " + euDay + "-" + euMonth + "-" + euYear);
		
	}

}
