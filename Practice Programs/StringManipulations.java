package Test;

public class StringManipulations {

	public static void main(String[] args) {
		
		System.out.println("String Manipulations. \n");
		
		String str = new String("Hello World");
		System.out.println(str + " \tString Length = "+str.length());
		System.out.println("String substring : " +str.substring(2));
		
		//String Comparisons
		
		String str1 = "Hello ! ";
		System.out.print("\nComparing two Strings:\t "+str +"\tand \t"+str1);
		System.out.println("\t"+str.compareTo(str1));
		
		String str2 ="";
		System.out.println("\nChecking empty string: "+str2.isEmpty());
		
		System.out.println("\nTo lower case: \t"+str.toLowerCase());
		
		System.out.println("\nReplace: "+str.replace('H', 'h'));
		
		
		System.out.println("\nChecking strings are equal: \t "+ str +"\t and \t"+str1 +str.equals(str2));
		
		System.out.println("\nCreating StringBuffer");
		StringBuffer s=new StringBuffer("Welcome to Java! ");
		s.append(" Enjoy your learning");
		System.out.println(s);
		s.insert(0, 'w');
		System.out.println(s);
		s.replace(0, 1, "Hello! ");
		System.out.println(s);
		s.delete(0, 6);
		System.out.println(s);
		
		System.out.println("\nCreating StringBuilder");
		StringBuilder sb1=new StringBuilder("Happy");
		sb1.append(" Learning");
		System.out.println(sb1);
		System.out.println("Inserting in String Builder: "+sb1.insert(0, "Hello! "));
		System.out.println("Deleting: "+sb1.delete(0, 6));
		System.out.println("Reverse: "+sb1.reverse());
		
		System.out.println("\nConversion of Strings to StringBuffer and StringBuilder");
        
        StringBuffer sbr = new StringBuffer(str); 
        sbr.reverse(); 
        System.out.println("String to StringBuffer");
        System.out.println(sbr); 
          
         
        StringBuilder sbl = new StringBuilder(str); 
        sbl.append(" world"); 
        System.out.println("String to StringBuilder");
        System.out.println(sbl);              

		
		
		

		


		

	}

}
