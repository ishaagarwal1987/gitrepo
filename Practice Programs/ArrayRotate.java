package Test;

public class ArrayRotate {

	int[] rotateArray(int arr[], int step) {
		
		int result[] = new int[arr.length];
		if (step > arr.length) 
			step = step % arr.length;
		
		int i;
		
		for(i =0 ;(step+i)<arr.length;i++)
			result[i] = arr[step+i];
		
		for(int j=0;i<arr.length;i++,j++)
			result[i] = arr[j];
			
		return result;
	}

	public static void main(String[] args) {

		ArrayRotate obj = new ArrayRotate();
		int step_size = 4;

		int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };

		System.out.println("Array before rotation is : ");
		for (int i : arr)
			System.out.print(i + " ");

		arr = obj.rotateArray(arr, step_size);

		System.out.println("\n\nArray after rotation is : ");
		for (int i : arr)
			System.out.print(i + " ");

	}

}
