package NumberConversions;

public class DecimalToHexadecimal {

    public static void main(String[] args) {

        int decimalNumber = 7562;
        String hexadecimal = "";
        String remainder;

        while (decimalNumber != 0) {
            remainder = Integer.toString(decimalNumber % 16);
            switch (remainder) {
                case "10" ->
                    remainder = "A";
                case "11" ->
                    remainder = "B";
                case "12" ->
                    remainder = "C";
                case "13" ->
                    remainder = "D";
                case "14" ->
                    remainder = "E";
                case "15" ->
                    remainder = "F";
              
            }
            hexadecimal = remainder.concat(hexadecimal);
            decimalNumber = decimalNumber / 16;
        }
        
        System.out.println("Hexadecimal number is "+hexadecimal);
    }

}
