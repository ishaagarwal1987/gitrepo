
//Find the union of 2 arrays

package Test;

import java.util.HashSet;

public class ArrayUnion {
	
	void union(int arr1[],int arr2[])
	{
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i :arr1)
			hs.add(i);
		
		for(int i :arr2)
			hs.add(i);
		
		System.out.println("Union of 2 arrays: \n");
		
		for(int i :hs)
			System.out.print(i+"\t");
	}

	public static void main(String[] args) {
		
		int arr1[] = {1,2,3,4,5};
		int arr2[] = {1,4,6,7,8,9};
		
		ArrayUnion obj = new ArrayUnion();
		
		obj.union(arr1, arr2);

	}

}
