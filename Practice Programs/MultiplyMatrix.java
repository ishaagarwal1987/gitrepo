package Test;

public class MultiplyMatrix {

	int[][] multipyMatrix(int[][] arr1, int[][] arr2, int r1, int c1, int c2) {
		int product[][] = new int[r1][c2];

		int sum=0;
		for (int row = 0; row < r1; row++) {
			for (int col = 0; col < c2; col++) {
				{
					for(int k=0;k<c1;k++)
						sum = sum + arr1[row][k]*arr2[k][col];
					
					product[row][col] = sum;
					sum=0;
				}
			}
		}

		return product;
	}

	public static void main(String[] args) {

		int arr1[][] = { { 1,2,3}, { 4,5,6} };
		int arr2[][] = { { 7,8 }, {9,10 }, { 11,12 } };

		int r1 = 2, c1 = 3;
		int r2 = 3, c2 = 2;

		MultiplyMatrix obj = new MultiplyMatrix();

		int product[][] = obj.multipyMatrix(arr1, arr2, r1, c1, c2);

		System.out.println("Product of two matrix is : ");

		for (int[] i : product) {

			for (int j : i)
				System.out.print(j + "\t");

			System.out.println();
		}

	}

}
