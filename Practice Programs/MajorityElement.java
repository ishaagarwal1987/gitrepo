
//Given an integer array of size n, find all that appear more than (n/3) times.

package Test;

import java.util.HashMap;

public class MajorityElement {

	public void majoriyrElement(int arr[])
	{
		HashMap<Integer,Integer> map = new HashMap<>();
		int n = arr.length;
		
		for(int i : arr)
		{
			if(map.containsKey(i))
			{
				map.put(i, map.get(i)+1);
			}
			else
			{
				map.put(i, 1);
			}
		}
		
		System.out.println("The elements more than n/3 times are: \n");
		
		for(int key : map.keySet())
		{
			if(map.get(key)>(n/3))
			{
				System.out.print(key+"\t");
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int num[] = {1,3,2,5,1,3,1,5,1,3,3};
		MajorityElement obj = new MajorityElement();
		
		obj.majoriyrElement(num);
	}

}
