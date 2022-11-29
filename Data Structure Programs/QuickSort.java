package dataStructure;

public class QuickSort {
	
	public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            try {
                int p = partition(arr, start, end);
                quickSort(arr, start, p - 1);
                quickSort(arr, p + 1, end);
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }

    }

    public int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int x = start - 1;
        try {
            for (int i = start; i <= end; i++) {

                if (arr[i] < pivot) {
                    x++;
                    if (x != i) {
                        swap(arr, x, i);
                    }
                }

            }
            swap(arr, x + 1, end);
        } catch (Exception e) {
            System.out.println("Hello " + e);
        }
        return x + 1;
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }


	public static void main(String[] args) {
		int arr[] = { 3, 60, 35, 2, 45, 320, 5 };

		System.out.println("Array Before Quick Sort");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		 QuickSort obj = new QuickSort();
	        int n = arr.length;
	        obj.quickSort(arr, 0, n - 1);// sorting array elements using bubble sort

		System.out.println("Array After Quick Sort");
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

}
