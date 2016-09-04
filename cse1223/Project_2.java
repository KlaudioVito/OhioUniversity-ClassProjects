package cse1223;

import javax.swing.JOptionPane;

public class Project_2 {
	private static String longString, subString,fullMessage, message1, message2, message3, message4,message5,message6,message7, replace, replaced;
	private static int position;
	public static void main (String[] args){
		longString = JOptionPane.showInputDialog("Enter a long string: ");
		subString = JOptionPane.showInputDialog("Enter a substring: " );
		
		message1 = "Length of long string: " + longString.length() + "\n";
		message2 = "Length of substring: " + subString.length() + "\n";
		message3 = "Starting position of substring: " + longString.indexOf(subString) + "\n";
		message4 = "String before your subtring : " + longString.substring(0, longString.indexOf(subString)) + "\n";
		message5 = "String after you subtring: " + longString.substring(longString.indexOf(subString)+subString.length(), longString.length())+ "\n";
		fullMessage = message1 + message2 + message3 + message4 + message5;
		JOptionPane.showMessageDialog(null, fullMessage);
		position = Integer.parseInt(JOptionPane.showInputDialog("Enter a position between 0 and " + (longString.length()-1)));
		message6 = "The character at position " + position + " is " + longString.charAt(position);
		JOptionPane.showMessageDialog(null, message6);
		replace = JOptionPane.showInputDialog("Enter a replacement string: ");
		replaced = longString.replaceAll(subString, replace);
		message7 = "You new string is : " + replaced;
		JOptionPane.showMessageDialog(null, message7);
		
	}

}
