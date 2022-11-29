package Test;

public class WideningExample {

	public static void main(String[] args) {
		
		char c = 'F';
		int x = c ; 
		long y = x;
		float z = y;
		
		System.out.println("Before conversion char value is : " + c);
		System.out.println("After conversion int value is : " + x);
		System.out.println("After conversion long value is : " + y);
		System.out.println("After conversion float value is : " + z);
		

	}

}
