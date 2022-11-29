package Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Vector;

public class CollectionsDemo {

	void arrayList()
	{
		System.out.print("ArrayList: \t");
		
		ArrayList<String> students = new ArrayList<String>();
		
		students.add("Ram");
		students.add("Sita");
		students.add("Shyam");
		students.add("Radha");
		students.add("Raman");
		
		System.out.println(students);
		
	}
	void vector()
	{
		System.out.print("\nVector: \t");
		
		Vector<Integer> vec = new Vector();
		
		vec.add(10);
		vec.add(20);
		vec.add(30);
		vec.add(40);
		vec.add(50);
		vec.add(60);
		
		System.out.println(vec);
	}
	void linkedList()
	{
		System.out.print("\nLinkedList: \t");
	      
		LinkedList<String> list=new LinkedList<String>(); 
		
		list.add("Agra");
		list.add("Mathura");
		list.add("Vridavan");
		list.add("Ayodhya");
		
		System.out.println(list);

	}
	void hashSet()
	{
		System.out.print("\nHashSet: \t");
		
		HashSet<Integer> set=new HashSet<Integer>(); 
		
		set.add(100);
		set.add(200);
		set.add(300);
		set.add(400);
		set.add(500);
		set.add(600);
		
		System.out.println(set);
	}
	void linkedHashSet()
	{
		System.out.print("\nLinkedHashSet: \t");
		
		LinkedHashSet<Integer> listHashSet = new LinkedHashSet<Integer>();  
		
		listHashSet.add(5);
		listHashSet.add(10);
		listHashSet.add(15);
		listHashSet.add(20);
		listHashSet.add(25);
		listHashSet.add(30);
		
		System.out.println(listHashSet);
		
	}
	
	public static void main(String[] args) {
		
		CollectionsDemo obj = new CollectionsDemo();
		
		obj.arrayList();
		obj.vector();
		obj.linkedList();
		obj.hashSet();
		obj.linkedHashSet();
			
	}

}
