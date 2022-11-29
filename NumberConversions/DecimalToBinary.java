
package NumberConversions;

public class DecimalToBinary {

    public static void main(String[] args) {
       
       int decimalNumber = 11;
       
       String binaryNumber = "";
       int remainder;
       String str;
       
       while(decimalNumber!=0)
       {
           remainder = decimalNumber%2;
           str= Integer.toString(remainder);
           binaryNumber=str.concat(binaryNumber);
           decimalNumber=decimalNumber/2;
       }
       
        System.out.println("Binary Number is "+binaryNumber);
        
    }
    
}
