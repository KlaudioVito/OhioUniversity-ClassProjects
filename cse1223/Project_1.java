package cse1223;

import javax.swing.JOptionPane;

public class Project_1 {
	static private int a, b;
	static String message;
	public static void main (String[] args){
		a = Integer.parseInt(JOptionPane.showInputDialog("Enter the first number: "));
		b = Integer.parseInt(JOptionPane.showInputDialog("Enter the second number: "));
		message = a + " + " + b + " = " + (a+b) + "\n"
				+ a + " - " + b + " = " + (a-b) + "\n"
				+ a + " * " + b + " = " + (a*b) + "\n"
				+ a + " / " + b + " = " + (a/b) + "\n"
				+ a + " % " + b + " = " + (a%b) + "\n"
				+ "The average of your numbers is: " + ((a+b)/2) + "\n";
		JOptionPane.showMessageDialog(null, message);
		
	}

}
