package Test;

public class arrayDemo {

	public static void main(String[] args) {

		int sum = 0;
		int count = 0;
		int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };

		int arr2d[][] = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } };

		for (int i : arr)
			sum = sum + i;

		System.out.println("Addition of all the elements of the array is : " + sum);

		for (int[] i : arr2d) {
			count++;
			sum = 0;
			for (int j : i) {
				sum = sum + j;
			}
			System.out.println("Sum of row " + count + " = " + sum);
		}

	}

}
