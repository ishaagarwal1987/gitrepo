package Test;

abstract class Figure {
	abstract int area(int side1, int side2);

	int perimeter(int side1, int side2) {
		return 2*(side1 + side2);
	}
}

public class AbstractionDemo extends Figure{

	@Override
	int area(int side1, int side2) {
		
		return side1*side2;
	}
	
	public static void main(String[] args) {
		AbstractionDemo obj = new AbstractionDemo();
		
		System.out.println("Abstraction Demo: ");
		System.out.println("\nArea of rectangle with sides 3cm and 4cm = " + obj.area(3, 4)+"sq.cm");
		System.out.println("\nPerimeter of rectangle with sides 3cm and 4cm = " + obj.perimeter(3, 4)+"cm");

	}

	
}
