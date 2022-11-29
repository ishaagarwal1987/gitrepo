package Test;

public class MyExceptionDemo {

	public static void main(String[] args) {
		try
		{
			System.out.println("Starting of try block");		throw new MyException("This is My error Message");

		}catch(MyException e)
		{
			System.out.println("Catch Block") ;
			System.out.println(e) ;

		}

	}

}
