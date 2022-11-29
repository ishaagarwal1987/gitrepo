
import java.util.Scanner;


public class Factorial {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int fac = 1;
        
        for(int i =1; i<=number ; i++)
        {
            fac = fac *i ;
        }
        
        System.out.println("Factorial of " + number + " is "+fac);
    }
    
}
