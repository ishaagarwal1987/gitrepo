
package NumberConversions;

public class BinaryToOctal {
    
    public int convertBinaryToDecimal(int binaryNumber) {
        int decimalNumber=0;
        int i=0;
        while(binaryNumber!=0)
        {
            decimalNumber = (int) (decimalNumber + (binaryNumber%10)*Math.pow(2, i));
            i++;
            binaryNumber = binaryNumber/10;
        }
        
        return decimalNumber;
    }
    
    public String convertDecimalToOctal(int decimalNumber)
    {
        String octal = "";
        
        while (decimalNumber!=0) 
        {
          octal = Integer.toString(decimalNumber%8).concat(octal);
          decimalNumber = decimalNumber/8;
        }
        return octal;
    }

    public static void main(String[] args) {
        BinaryToOctal obj = new  BinaryToOctal();
        
        int binaryNumber = 1010101;
        int decimalNumber = obj.convertBinaryToDecimal(binaryNumber);
        
        System.out.println("Octal number is "+obj.convertDecimalToOctal(decimalNumber));
    }
    
}
