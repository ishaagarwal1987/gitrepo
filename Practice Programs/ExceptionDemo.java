package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionDemo {
	int a,b;
	void divide(int a, int b)
	{
		int result;
		try {
			
			if(b==0)
				throw(new ArithmeticException("Can't divide by zero."));
			else
				{
				result = a/b; 
				System.out.println(a+"/"+b +" = "+result);
				}
			
			
			
		}catch(ArithmeticException e)
		{
			System.out.print("\nError : " + e.getMessage());
		}
		
	}
	
	void takeInput() throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("a = ");
		this.a = Integer.parseInt(br.readLine());
		
		System.out.print("\nb = ");
		this.b = Integer.parseInt(br.readLine());
		
		br.close();
	}

	public static void main(String[] args) {
		ExceptionDemo obj = new ExceptionDemo();
		
		try {
			obj.takeInput();
		} catch (IOException e) {
			System.out.println("\nError occured. ");
			e.printStackTrace();
		}
		finally {
			System.out.println("\nFinally block. ");
		}
		
		obj.divide(obj.a,obj.b);

	}

}
