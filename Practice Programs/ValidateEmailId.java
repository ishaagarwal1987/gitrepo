package Test;

import java.util.Scanner;

public class ValidateEmailId {
	
	String emails[] = {"isha@123","nitin@123","kush@123"};
	
	boolean search(String str)
	{
		for (String s : emails) 
		{
			if(s.equals(str))
				return true;
		}
		
		return false;
	}

	void validate(String str) {
		if(search(str))
		{
			System.out.print("Your email id is verified.");
		}
		else
			System.out.print("Sorry! You entered an invalid email id. ");
		
	}

	public static void main(String[] args) {
		
		System.out.print("Please enter your email id : ");
		Scanner sc = new Scanner(System.in);
		String email = sc.next();
		ValidateEmailId val = new ValidateEmailId();
		val.validate(email);
		sc.close();
	
	}

}
