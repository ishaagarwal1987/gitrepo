package Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
	
	void hashMap()
	{
		System.out.println("HashMap: ");
		
		HashMap<Integer,String> hm=new HashMap<Integer,String>();  
		
		hm.put(1, "Ram");
		hm.put(2, "Krishna");
		hm.put(3, "Shyam");
		hm.put(4, "Mohan");
		
		for(Map.Entry m:hm.entrySet()){    
		       System.out.println(m.getKey()+"\t "+m.getValue());  
		}

	}
	void treeMap()
	{
		System.out.println("\nTreeMap: ");
		
		TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
		
		map.put(1, "Ram");
		map.put(2, "Krishna");
		map.put(3, "Shyam");
		map.put(4, "Mohan");
		
		for(Map.Entry m:map.entrySet()){    
		       System.out.println(m.getKey()+"\t "+m.getValue());  
		}
		
	}
	void hashTable()
	{
		System.out.println("\nHashTable: ");
		
		Hashtable<Integer,String> ht=new Hashtable<Integer,String>();    
		
		ht.put(1, "Ram");
		ht.put(2, "Krishna");
		ht.put(3, "Shyam");
		ht.put(4, "Mohan");
		
		for(Map.Entry m:ht.entrySet()){    
		       System.out.println(m.getKey()+"\t "+m.getValue());
		}
	}

	public static void main(String[] args) {
		
		MapDemo obj = new MapDemo();
		
		obj.hashMap();
		obj.treeMap();
		obj.hashTable();

	}

}
