
package NumberConversions;

import java.util.Hashtable;

public class BinaryToHexadecimal {
    
    public void binaryToHexadecimal(String binaryNumber)
    {
        try{
            Hashtable<String, String> ht1 = new Hashtable<>();
        
        String str=null;
        
        String hexadecimal="";
        
        ht1.put("0000","0");
        ht1.put("0001","1");
        ht1.put("0010","2");
        ht1.put("0011","3");
        
        ht1.put("0100","4");
        ht1.put("0101","5");
        ht1.put("0110","6");
        ht1.put("0111","7");
        
        ht1.put("1000","8");
        ht1.put("1001","9");
        ht1.put("1010","A");
        ht1.put("1011","B");
        
        ht1.put("1100","C");
        ht1.put("1101","D");
        ht1.put("1110","E");
        ht1.put("1111","F");
        
        switch (binaryNumber.length()%4) {
            case 1 -> binaryNumber = "000".concat(binaryNumber);
            case 2 -> binaryNumber = "00".concat(binaryNumber);
            case 3 -> binaryNumber = "0".concat(binaryNumber);
            default -> {
            }
        }
        
        while(binaryNumber.length()!=0)
        {
            str = binaryNumber.substring(0,4);
            //System.out.println("str = "+str);
            str = ht1.get(str);
            hexadecimal = hexadecimal.concat(str);
            binaryNumber = binaryNumber.substring(4);
        }
        System.out.println("hexadecimal number is "+hexadecimal);
        }
        catch(Exception ex)
        {
            System.out.println(""+ex);
        }
    }

    public static void main(String[] args) {
        
       String binaryNumber = "1101100";
       BinaryToHexadecimal obj = new BinaryToHexadecimal();
       obj.binaryToHexadecimal(binaryNumber);
    }
    
}
