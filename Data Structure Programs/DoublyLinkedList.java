package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DoublyLinkedList {
	
	DoublyNode head = null;
	DoublyNode end = null;
	
	void menu() {
		System.out.println("1. Insert in a linked list. ");
		System.out.println("2. Delete in a linked list. ");
		System.out.println("3. Forward traversal of the linked list. ");
		System.out.println("4. Backward traversal of the linked list. ");
		System.out.println("5. Exit ");
	}
	
	void insert(DoublyLinkedList list)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int data = 0;

		try {
			System.out.println("Please enter the data: ");
			data = Integer.parseInt(br.readLine());

		} catch (Exception e) {
			System.out.println("Sorry! Try Again.. \n You entered wrong data.");
		}

		DoublyNode new_node = new DoublyNode(data);
		DoublyNode curr_node;
		
		if(list.head==null)
		{
			list.head = new_node;
			list.end = new_node;
		}
		else
		{
			curr_node=list.head;
			
			while(curr_node.next!=null)
				curr_node = curr_node.next;
			
			new_node.prev = curr_node;
			curr_node.next = new_node;
			list.end = new_node;
			
		}
		
		System.out.println("Data Inserted. ");
	}
	
	void printListForward(DoublyLinkedList list)
	{
		DoublyNode curr_node=list.head;
		
		System.out.print("Forward traversal is : ");
		while(curr_node.next!=null)
			{
				System.out.print(curr_node.data + "\t");
				curr_node = curr_node.next;
			}
		
		System.out.println(curr_node.data+"\n");
	}
	
	void printListBackward(DoublyLinkedList list)
	{
		DoublyNode curr_node=list.end;
		
		System.out.print("\nBackward traversal is : ");
		while(curr_node.prev!=null)
			{
				System.out.print(curr_node.data + "\t");
				curr_node = curr_node.prev;
			}
		System.out.println(curr_node.data +"\n");
	}
	
	void delete(DoublyLinkedList list)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int data = 0;
		try {
			System.out.println("Please enter the data you want to delete: ");
			data = Integer.parseInt(br.readLine());

		} catch (Exception e) {
			System.out.println("Sorry! Try Again.. \n You entered wrong data.");
		}
		
		DoublyNode curr_node=list.head;
		DoublyNode prev_node=list.head;
		
		if(curr_node.data ==data)
		{
			list.head = curr_node.next;
			curr_node.next.prev = null;
		}
		else
		{
			curr_node=curr_node.next;
			
			while(curr_node.next!=null)
			{
				if(curr_node.data==data)
				{
					prev_node.next = curr_node.next;
					curr_node.next.prev = prev_node;
				}
				prev_node=curr_node;
				curr_node=curr_node.next;
			}
			
			if(curr_node.data==data)
			{
				prev_node.next=null;
				list.end=prev_node;
			}
		}
		
		System.out.println("Data deleted. ");
		
	}
	

	public static void main(String[] args) {
		
		DoublyLinkedList list = new DoublyLinkedList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ch = 0;

		while (true) {
			list.menu();
			System.out.println("Enter your choice: ");
			try {
				ch = Integer.parseInt(br.readLine());

				switch (ch) {
				case 1:
					list.insert(list);
					break;

				case 2:
					list.delete(list);
					break;

				case 3:
					list.printListForward(list);
					break;
					
				case 4:
					list.printListBackward(list);
					break;

				case 5:
					System.out.print("Byeee..... ");
					System.exit(0);

				default:
					System.out.print("\nPlease enter the correct choice. ");
				}

			} catch (Exception e) {
				System.out.print("\nSorry! Try Again.. ");

			}

		}


	}

}
