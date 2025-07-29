package com.celcom.day6;

public class Exercise {

	public static void main(String[] args) {
		
//		single for loop patern
//		String s = "* ";
//		int a;
//		
//		Scanner in = new Scanner(System.in);
//		a = in.nextInt();
//		for(int i =0;i<a;i++) {
//			System.out.println(s);
//			s=s.concat("* ");
//		}
		
		for (int i = 1; i <= 9; i++) {
				for(int j = 1;j<=9;j++) {
					System.out.print(j + " ");	
				}
				System.out.println();
			
		}

	}

}
