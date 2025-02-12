package com.celcom.day6;

import java.util.Scanner;

class VowelException extends Exception{
	
	public String toString() {
		return "Word contains vowels";
	}
}

public class Assignment2{
	static public int checkVowels(String word) {
		int flag = 0;
		for(int i = 0;i<word.length();i++) {
			if(word.charAt(i) == 'A' || word.charAt(i) == 'E'||word.charAt(i) == 'I'||word.charAt(i) == 'O'||word.charAt(i) == 'U') {
				flag = 1;
				break;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter word: ");
		String word = input.next().toUpperCase();
		if(Assignment2.checkVowels(word) == 1) {
			try {
				throw new VowelException();
			}
			catch(VowelException e) {
				System.out.println(e);
			}
		}
		else {
			System.out.println("Word not Contains vowels.");
		}

		
	}

}
