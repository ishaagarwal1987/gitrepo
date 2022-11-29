
public class KaprekarNumber {

    public void karprekar(int number, int power) {
        int parts = (int) Math.pow(10, power);
        int square = number * number;

        if (parts == number) {
            return;
        }

        int sum = square / parts + square % parts;

        if (sum == number) {
            System.out.print(number + " \t " + square + " \t ");
            System.out.println((square / parts) + " + " + (square % parts));
        }

    }

    public static void main(String[] args) {
        KaprekarNumber obj = new KaprekarNumber();
        //int number = 297;
        int square;
        int length;
        for (int number = 1; number < 1000; number++) {
            
            square = number * number;
            length = (int) Math.floor(Math.log10(square) + 1);

            obj.karprekar(number, length / 2);
            obj.karprekar(number, (length / 2) + 1);

        }

    }

}
