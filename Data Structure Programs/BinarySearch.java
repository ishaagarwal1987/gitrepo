package dataStructure;

import java.util.Scanner;

public class BinarySearch {

	int binarySearch(int arr[], int element, int start, int end) {

		
		if (start <= end) {
			
			int mid = (start + end) / 2;
			if (arr[mid] == element) {
				return mid;
			} else {
				if (arr[mid] > element)
					return binarySearch(arr, element, start, mid - 1);
				else
					return binarySearch(arr, element, mid + 1, end);
			}
		}

		return -1;

	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 5, 35, 45, 60, 320};

		Scanner sc = new Scanner(System.in);

		System.out.print("Array to be searched via Binary Search : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\nEnter the element: ");
		int element = sc.nextInt();
		sc.close();
		BinarySearch obj = new BinarySearch();
		int index = obj.binarySearch(arr, element, 0, arr.length - 1);

		if (index == -1)
			System.out.println("\nSorry! Element not found.");
		else
			System.out.println("\nElement found at the position : " + index);

	}

}
