package Test;

import java.util.Calendar;

public class CalenderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar obj = Calendar.getInstance();
		
		System.out.println("The Current Date is:" + obj.getTime());
		
		obj.add(Calendar.DATE, -15);
        System.out.println("15 days ago: " + obj.getTime());
        obj.add(Calendar.MONTH, 4);
        System.out.println("4 months later: " + obj.getTime());
        obj.add(Calendar.YEAR, 2);
        System.out.println("2 years later: " + obj.getTime());

        System.out.println("The given calendar's" + " year is: " + obj.get(Calendar.YEAR));
        System.out.println("The given calendar's" + " month is: " + obj.get(Calendar.MONTH));
        System.out.println("The given calendar's" + " day is: " + obj.get(Calendar.DATE));
	
        
	}

}
