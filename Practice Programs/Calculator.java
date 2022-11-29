package Test;

import java.util.Scanner;

public class Calculator {

	final void display() {
		System.out.println("1 . Addition");
		System.out.println("2 . Substraction");
		System.out.println("3 . Multiplication");
		System.out.println("4 . Division");
		System.out.println("5 . Exit");
	}

	double add(double a, double b) {

		return a + b;
	}

	double subtract(double a, double b) {
		return a - b;
	}

	double multiply(double a, double b) {
		return a * b;
	}

	double divide(double a, double b) {
		return a / b;
	}

	static void calculator() {
		
		Calculator cal = new Calculator();
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		double num1 = 0, num2 = 0;

		while (true) {
			cal.display();

			System.out.print("Enter your choice : ");
			choice = sc.nextInt();

			if (choice != 5) {
				System.out.print("Enter 1st number : ");
				num1 = sc.nextDouble();
				System.out.print("Enter 2nd number : ");
				num2 = sc.nextDouble();
			}

			switch (choice) {
			case 1: System.out.println("\n"+num1+" + "+num2 +" = " + cal.add(num1, num2) +"\n");
					break;
			case 2:	System.out.println("\n"+num1+" - "+num2 +" = " + cal.subtract(num1, num2)+"\n");
					break;
			case 3:	System.out.println("\n"+num1+" * "+num2 +" = " + cal.multiply(num1, num2)+"\n");
					break;
			case 4:	System.out.println("\n"+num1+" / "+num2 +" = " + cal.divide(num1, num2)+"\n");
					break;
			case 5: sc.close();
					System.exit(0);
					break;
			default: System.out.println("Enetr the valid choice : ");
					 break;
			}

		}
	}

	public static void main(String[] args) {

		Calculator.calculator();

	}

}
