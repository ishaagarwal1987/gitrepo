
public class PyramidPrint {

    public static void main(String[] args) {
        int spacecount = 6;
        for (int i = 0; i < 10; i++) {
            System.out.print("   ");
            for (int k = 0; k < spacecount; k++) {
                System.out.print("\t");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*\t");
            }
            System.out.println("");
            spacecount--;
        }

    }
}
