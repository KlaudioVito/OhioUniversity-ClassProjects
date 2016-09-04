package cse1223;

import java.math.BigInteger;
import java.util.Scanner;

public class Project_6 {
	private static BigInteger barCode;
	private static Scanner input = new Scanner(System.in);
	private static String barCodeValue;
	private static int all[] = new int[12];
	private static int evenSum = 0, oddSum = 0, check, checkComputed;
	
	public static void main (String[] args){
		System.out.print("Enter the 12-digit barcode: ");
		barCode = new BigInteger (input.next());
		barCodeValue ="0"+ barCode.toString();
		for(int i = 0; i < 11; i++){
			all[i] = barCodeValue.charAt(i)-'0';
		}
		all[11] = check = barCodeValue.charAt(11)-'0';
		for(int j = 0; j < all.length; j+=2)
			evenSum+=all[j];
		for(int j = 1; j < all.length; j+=2)
			oddSum+=all[j];
		
		int remainder = (oddSum*3 + evenSum)%10;
		 if(remainder != 0)
			checkComputed = 10 - remainder;
		 else if(remainder == 0)
			 checkComputed = 0;
		 
		 System.out.println("Check should be: " + checkComputed + "\nCheck is: " + check);
		 if(check == checkComputed){
			 System.out.println("UPC is valid");
		 }
		 else 
			 System.out.println("UPC is not valid");
	
		
	}
}
