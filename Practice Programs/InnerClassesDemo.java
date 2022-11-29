package Test;

abstract class AnonymousInnerClass {
	   public abstract void display();
	}


public class InnerClassesDemo {
	
	private String msg="Welcome to Java"; 
	
	class Inner
	{  
		void hello()
		  {
			  System.out.println(msg+", Let us start learning Inner Classes");
		  }  
	}  
	
	void display()
	{  
		 class Inner
		 {  
			 void msg()
			 {
				 System.out.println("\n"+msg +". Msg from Method's Inner Class. ");
			 } 
		 }
		 
		 Inner l=new Inner();  
		  l.msg();  

	 }  

	
	public static void main(String[] args) {
		
		InnerClassesDemo obj = new InnerClassesDemo();
		
		InnerClassesDemo.Inner inner = obj.new Inner();
		
		inner.hello();
		
		obj.display();
		
		AnonymousInnerClass obj1 = new AnonymousInnerClass()
				{
	         		public void display()
	         		{
	         			System.out.println("\nAnonymous Inner Class");
	         		}

				};
		
				obj1.display();
	}

}
