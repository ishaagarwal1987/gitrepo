
package NumberConversions;

public class BinaryToDecimal {

    public static void main(String[] args) {
       
        int binaryNumber = 101;
        int decimalNumber=0;
        int i=0;
        while(binaryNumber!=0)
        {
            decimalNumber = (int) (decimalNumber + (binaryNumber%10)*Math.pow(2, i));
            i++;
            binaryNumber = binaryNumber/10;
            
        }
        System.out.println("decimal number is "+decimalNumber);
    }
    
}
