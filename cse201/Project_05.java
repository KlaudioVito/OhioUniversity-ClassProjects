package cse201;

import java.util.Scanner;

public class Project_05 {
	public static void main(String[] args)
    {
        // Fill in the body
		Scanner scan = new Scanner(System.in);
		char response;
		System.out.print("Would you like to compute Hailstone series (y/n): ");
		response = scan.next().charAt(0);
		response = Character.toLowerCase(response);
		if(response == 'n'){
			System.out.println("Goodbye!");
			System.exit(0);
		}
		else if (response == 'y'){
			int input = getStartingValue(scan);
			char answer;
			while(input > 0){
				System.out.println("Generated series for starting value " + input);
				System.out.println("Series converged in " + computeLength(input));
				System.out.println("Larget value generated is " + computeMax(input));
				System.out.print("Would you like to compute another series (y/n): ");
				answer = scan.next().charAt(0);
				if(answer == 'y')
					continue;
				else
					break;
			}
			System.out.println("Goodbye!");
		}
		else{
			System.out.println("Wrong input. Goobye!");
			System.exit(0);
		}
		
    }
	

    // Given a Scanner in, this method (repeatedly, if necessary)
    // prompts the user to enter a positive integer, inputs the 
    // integer, and if it is positive returns it. Otherwise, is
    // keeps asking the user for a positve integer.
    private static int getStartingValue(Scanner in)
    {
        // Fill in the body
    	int input = in.nextInt();
    	while(input > 0)
    		System.out.print("Enter a positive integer: ");
    	return input;
    }

    // Given a positive starting value x, this method generates the
    // corresponding Hailstone series and returns the length of the
    // series (i.e., how many steps it takes before the series hits 1).
    private static int computeLength(int x)
    {
        // Fill in the body
    	int count = 0, series = x;
    	while(series != 1){
    		if(x%2 == 0){
    			series = x/2;
        		count++;
    		}
    		else if (x%3 == 0){
        		series = (3*x+1);
        		count++;
        	}
    	}
    	
    	return count;
    		
    }

    // Given a positive starting value x, this method generates the
    // corresponding Hailstone series and returns the maximum value
    // in the series (i.e., the largest value it generates before
    // the series hits 1).
    private static int computeMax(int x)
    {
        // Fill in the body
    	int max = x, series = x;
    	while(series != 1){
    		if(x%2 == 0){
    			series = x/2;
    			if(series > max)
    				max = series;
    		}
    		else if (x%3 == 0){
        		series = (3*x+1);
        		if(series > max)
        			max = series;
        	}
    	}
    	return max;
    }

    // Given the starting value, the length, and the max value in a
    // Hailstone series, this method outputs them with appropriate
    // messages.
    private static void outputResults(int start, int length, int max)
    {
        // Fill in the body
    	length = computeLength(start);
    	max = computeMax(start);
    	for(int i = 0; i < length; i++){
    		while(start != 1){
        		if(start%2 == 0){
        			start = start/2;
        			System.out.print(start + " ");
        		}
        		else if (start%3 == 0){
            		start = (3*start+1);
            		System.out.print(start + " ");
            	}
        	}	
    	}
    }
}
