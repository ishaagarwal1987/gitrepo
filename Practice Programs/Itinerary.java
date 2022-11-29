package Test;

import java.util.HashMap;

public class Itinerary {
	
	void itinerary(HashMap<String,String> map)
	{
		String start = null;
		
		HashMap<String,String> revmap = new HashMap<>();
		
		for(String key : map.keySet())
		{
			 revmap.put(map.get(key),key);
		}
		
		for(String key : map.keySet())
		{
			 if(!revmap.containsKey(key))
			 {
				 start = key;
				 break;
			 }
		}
		
		System.out.print("Your itinerary is : \n "+start);
		
		while(map.containsKey(start))
		{
			System.out.print("  ----->   ");
			System.out.print(map.get(start));
			start = map.get(start);
			
		}
		
	}
	
	public static void main(String[] args) {
	
		HashMap<String,String> map = new HashMap<>();
		
		map.put("Chennai", "Bengaluru");
		map.put("Mumbai", "Delhi");
		map.put("Goa", "Chennai");
		map.put("Delhi", "Goa");
		
		Itinerary obj = new Itinerary();
		obj.itinerary(map);
		
	}

}
