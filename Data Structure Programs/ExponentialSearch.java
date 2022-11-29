package dataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class ExponentialSearch {
	
	int exponentialSearch(int arr[],int element)
	{
		if (arr[0] == element)
            return 0;
		
		 int i = 1;
	        while (i < arr.length && arr[i] <= element)
	            i = i*2;
	        
	     return Arrays.binarySearch(arr, i/2, 
                    Math.min(i, arr.length-1), element);
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 5, 35, 45, 60, 320};

		Scanner sc = new Scanner(System.in);

		System.out.print("Array to be searched via Exponential Search : ");
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
