package dataStructure;

import java.util.Scanner;

public class LinearSearch {
	
	int linearSearch(int arr[],int element)
	{
		int index=-1;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]== element)
				return i;
		}
		
		
		return index;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 60, 35, 2, 45, 320, 5 };
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Array to be searched via linear Search : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\nEnter the element: ");
		int element = sc.nextInt();
		sc.close();
		LinearSearch obj = new LinearSearch();
		int index = obj.linearSearch(arr,element);
		
		if(index==-1)
			System.out.println("\nSorry! Element not found.");
		else
			System.out.println("\nElement found at the position : "+ index);
		

	}

}
