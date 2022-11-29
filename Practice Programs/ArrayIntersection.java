
// Find intersection of 2 arrays

package Test;

import java.util.HashSet;

public class ArrayIntersection {
	
	void intersection(int arr1[],int arr2[])
	{
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i :arr1)
			hs.add(i);
		
		System.out.println("Intersection of 2 arrays: \n");
		
		for(int i :arr2)
			{
				if(hs.contains(i))
				{
					System.out.print(i+"\t");
					hs.remove(i);
				}
			}
	}

	public static void main(String[] args) {
	
		int arr1[] = {1,2,3,4,5};
		int arr2[] = {1,4,6,7,8,9,4};
		
		ArrayIntersection obj = new ArrayIntersection();
		
		obj.intersection(arr1, arr2);
		
	}

}
