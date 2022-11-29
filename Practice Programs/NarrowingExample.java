package Test;

public class NarrowingExample {
	
	public static void main(String[] args) {
		
		int x = 100;
		char ch = (char)x;
		
		System.out.println("Before conversion int value is : " + x);
		System.out.println("Afetr conversion char value is : " + ch);
		
	}

}
