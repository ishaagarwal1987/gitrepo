package dataStructure;

public class InsertionSort {

	static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int j = 1; j < n; j++) {
			int key = arr[j];
			int i = j - 1;
			while ((i > -1) && (arr[i] > key)) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = key;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 3, 60, 35, 2, 45, 320, 5 };

		System.out.println("Array Before Insertion Sort");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();

		insertionSort(arr);// sorting array elements using bubble sort

		System.out.println("Array After Insertion Sort");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
