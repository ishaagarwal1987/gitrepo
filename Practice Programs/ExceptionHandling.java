package Test;

public class ExceptionHandling {

	public static void main(String[] args) {

		int arr[] = { 10, 20, 30, 40 };

		try {
			arr[6] = 50;

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index is out of bounds! \n Array size is " + arr.length);
		} finally {
			for (int i : arr)
				System.out.print(i + " ");
		}

	}

}
