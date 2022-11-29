package dataStructure;

import java.io.BufferedReader;

import java.io.InputStreamReader;

public class SingleLinkedList {

	Node1 head = null;
	

	SingleLinkedList insert(SingleLinkedList list) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int data = 0;
		try {
			System.out.println("Please enter the data: ");
			data = Integer.parseInt(br.readLine());
			
		} catch (Exception e) {
			System.out.println("Sorry! Try Again.. \n You entered wrong data.");
		}
		Node1 node = new Node1(data);

		if (head == null) {
			list.head = node;
		} else {

			Node1 last = list.head;

			while (last.next != null)
				last = last.next;
			last.next = node;

		}

		System.out.println("Data inserted. ");
		return list;
	}

	void printList(SingleLinkedList list) {
		Node1 last = list.head;
		System.out.print("Data present in the linked list. ");
		while (last.next != null) {
			System.out.print(last.data + "\t");
			last = last.next;
		}

		System.out.println(last.data + "\t");
	}

	void menu() {
		System.out.println("1. Insert in a linked list. ");
		System.out.println("2. Delete in a linked list. ");
		System.out.println("3. Display the linked list. ");
		System.out.println("4. Exit ");
	}

	SingleLinkedList delete(SingleLinkedList list) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int data = 0;
		try {
			System.out.println("Please enter the data you want to delete: ");
			data = Integer.parseInt(br.readLine());
			
		} catch (Exception e) {
			System.out.println("Sorry! Try Again.. \n You entered wrong data.");
		}
		
		
		Node1 prev = list.head;
		Node1 curr_node = prev.next;
		if(prev.data==data)
			{
				list.head = curr_node;
				return list;
			}

		while (curr_node.next != null) {

			if(curr_node.data==data)
				{
					prev.next = curr_node.next;
					break;
				}
			
			prev = curr_node;
			curr_node = curr_node.next;
			
		}
		if(curr_node.data==data)
		{
			prev.next = null;
			
		}
		System.out.println("Node deleted.");
		return list;
	}

	public static void main(String[] args)  {

		SingleLinkedList list = new SingleLinkedList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ch = 0;

		while (true) {
			list.menu();
			System.out.println("Enter your choice: ");
			try {
				ch = Integer.parseInt(br.readLine());
				//System.out.println(ch);
				switch (ch) {
				case 1:
					list.insert(list);
					break;

				case 2:list.delete(list);
					break;

				case 3:
					list.printList(list);
					break;

				case 4:System.out.print("Byeee..... ");
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
