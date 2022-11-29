package dataStructure;

public class SelectionSort {

	static void selectionSort(int[] arr) {
		int n = arr.length;
		int index;
		for (int i = 0; i < n; i++) {
			index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;// searching for lowest index
				}
			}
			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;

		}
	}

	public static void main(String[] args) {
		int arr[] = { 3, 60, 35, 2, 45, 320, 5 };

		System.out.println("Array Before Selection Sort");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();

		selectionSort(arr);// sorting array elements using bubble sort

		System.out.println("Array After Selection Sort");
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

}
