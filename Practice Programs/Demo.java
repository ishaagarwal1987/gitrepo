package Test;

import java.util.Scanner;

public class Demo {
	public static void main(String args[]){
	
		int ch=1;
		System.out.println("Enter the choice : ");
		Scanner sc = new Scanner(System.in) ;
			ch = sc.nextInt();
			sc.close();
		
		switch(ch)
			{
				case 1: System.out.println("apple");
						break;
				case 2: System.out.println("Banana");
						break;
				case 3: System.out.println("orange");
						break;
				default: System.out.println("Invalid Choice");
						break;
			}
		
	}
}
