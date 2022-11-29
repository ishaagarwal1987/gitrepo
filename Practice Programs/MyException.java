package Test;

public class MyException extends Exception{
	
	String msg;
	
	MyException(String msg)
	{
		this.msg=msg;
	}
	
	public String toString()
	{
		return "My Exception occured: "+msg;
	}

}
