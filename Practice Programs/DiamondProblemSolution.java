package Test;

public class DiamondProblemSolution implements First, Second {

	public void show() 
    {  
        First.super.show(); 
        Second.super.show(); 
    } 

	public static void main(String[] args) {
		
		DiamondProblemSolution obj = new DiamondProblemSolution();
		obj.show();

	}

}
