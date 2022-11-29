package dataStructure;

public class PolymorphismDemo {

	int sum (int a,int b)
	{
		return a+b;
	}
	
	int sum (int a,int b,int c)
	{
		return a+b+c;
	}
	double sum (double a,double b)
	{
		return a+b;
	}
	
	public static void main(String[] args) {
		
		PolymorphismDemo obj = new PolymorphismDemo();
		
		System.out.println("Polymorphism Demo \n");
		System.out.println("5 + 7 = "+obj.sum(5, 7));
		System.out.println("5 + 7 + 9  = "+obj.sum(5, 7, 9));
		System.out.println("5.2 + 7.5 = "+obj.sum(5.2, 7.5));

	}

}
