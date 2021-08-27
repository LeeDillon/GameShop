package demo.utilities;

import java.util.Scanner;



public class Utilities {
	
	static Scanner scan = new Scanner(System.in);
	
	private static Utilities instance = null;
	
	private Utilities() {
		
	}
	
	public static Utilities getInstance() {
		if(instance == null) {
			instance = new Utilities();
		}
		return instance;
	}
	public static String getUser() {
		System.out.println("Please enter your Username:");
		return scan.nextLine();
	}
	public static String getPass() {
		System.out.println("Please enter your Password:");
		return scan.nextLine();
	}
	
	public String getString() {
		return scan.nextLine();
	}
	
	public int getInt() {
		while(true) {
			try {
				int input = Integer.parseInt(getString());
				return input;
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}
	
	public double getDbl() {
		while(true) {
			try {
				double input = Double.parseDouble(getString());
				return input;
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}
}
