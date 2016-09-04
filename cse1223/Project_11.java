package cse1223;
import java.io.*;
import java.util.*;
public class Project_11 {
	static List<Integer> series;
	public static void main(String[] args) throws FileNotFoundException {
		// Fill in the body
		int count = 0, highest = 0, lowest = 0;
		String low= "", high="";
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an input file name: ");
		String input = in.next();
		System.out.print("Enter an output file name: ");
		String output = in.next();
		in = new Scanner(new File (input));
		PrintWriter pw = new PrintWriter(new File(output));
		pw.println("Name			Mean Median Max	Min");
		pw.println("------------		---- ----- --- ---");
		while(in.hasNextLine()){
			count++;
			String name = in.nextLine();
			series = readNextSeries(in);
			int average = getAverage(series);
			if(count == 1){
				highest = average;
				lowest = average;
				high = low = name;
			}
			else{
				if(average > highest){
					highest = average;
					high = name;
				}
				if(average < lowest){
					lowest = average;
					low = name;
				}
			}
			pw.println(String.format("%-18s", name)+ String.format("%7d", average) + String.format("%7d",getMedian(series))+ String.format("%7d", getMax(series))+String.format("%7d", getMin(series)));	
		}
		pw.println("\nTotal number of partecipants: " + count);
		pw.println("Highest average score: " + high + " (" + highest + ")");
		pw.println("Lower average score: " + low + " (" + lowest + ")");
		pw.close();
		in.close();
	}
	
	// Given a Scanner as input read in a list of integers one at a time until a negative
	// value is read from the Scanner.  Store these integers in an ArrayList<Integer> and
	// return the ArrayList<Integer> to the calling program.
	private static List<Integer> readNextSeries(Scanner inScanner) {
		// Fill in the body
		List <Integer> nextSeries = new ArrayList<>();
		while(inScanner.hasNextLine()){
			int currentLine = Integer.parseInt(inScanner.nextLine());
			if(currentLine == -1) 
				break;
			nextSeries.add(currentLine);
		}
		return nextSeries;
		
	}
	
	// Given a List<Integer> of integers, compute the median of the list and return it to
	// the calling program.
	private static int getMedian(List<Integer> inList) {
		// Fill in the body
		if(inList.size() == 0)
			return -1;
		List<Integer> temp = inList;
		Collections.sort(temp);
		int Middle = temp.size()/2;
		if(temp.size()%2 == 1)
			return temp.get(Middle);
		else
			return (temp.get(Middle-1) + temp.get(Middle))/2;
	}
	
	// Given a List<Integer> of integers, compute the average of the list and return it to
	// the calling program.
	private static int getAverage(List<Integer> inList) {
		// Fill in the body
		int avg = 0;
		if(inList.size() == 0)
			return 0;
		for(int i = 0; i < inList.size(); i++)
			avg += inList.get(i);
		return (avg/inList.size());
	}
	
	public static int getMax(List<Integer> inList){
		if(inList.size() == 0)
			return -1;
		int largest = inList.get(0);
		for(int i = 0; i < inList.size(); i++){
			if(inList.get(i) > largest)
				largest = inList.get(i);
		}
		return largest;
	}
	public static int getMin(List<Integer> inList){
		if(inList.size() == 0)
			return -1;
		int smallest = inList.get(0);
		for(int i = 0; i < inList.size(); i++){
			if(inList.get(i) > smallest)
				smallest = inList.get(i);
		}
		return smallest;
	}

}
