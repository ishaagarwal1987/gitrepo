package Test;

public class AccessSepciferDemo {
	
	private void display()
	{
		System.out.println("Private method. ");
	}
	
	void show()
	{
		System.out.println("Default method. ");
	}
	
	protected void print()
	{
		System.out.println("Protected method. ");
	}
	
	public void message()
	{
		System.out.println("Public method. ");
	}

}
