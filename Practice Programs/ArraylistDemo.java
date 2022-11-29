
import java.util.ArrayList;

public class ArraylistDemo {

    public static void main(String[] args) {
        ArrayList<Integer> arrli = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            arrli.add(i);
        }

        System.out.print("Array List ");
        System.out.println(arrli);
        arrli.remove(3);
        System.out.println("Array List after : " + arrli);
    }

}
