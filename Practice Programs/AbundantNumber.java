
public class AbundantNumber {

    public static void main(String[] args) {

        int abundant = 0;
        int deficient = 0;
        int perfect = 0;
        int number = 10000;
        int factorSum;
        //int i = 6;
        for (int i = 1; i <= number; i++) {
            
            factorSum = 0;
            //System.out.print("Factors are ");
            for (int factor = 1; factor < i; factor++) {

                if (i % factor == 0) {
                    factorSum = factorSum + factor;
                    //System.out.print(factor+" , ");
                }
            }

            if (factorSum < i) {
                deficient++;
            } else if (factorSum == i) {
                perfect++;
            } else {
                abundant++;
            }
        }
        System.out.println("Abundant numbers are " + abundant);
        System.out.println("Deficient numbers are " + deficient);
        System.out.println("Perfect numbers are " + perfect);

    }
}
