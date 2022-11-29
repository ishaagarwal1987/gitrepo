package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CircularLinkedList {

	Node1 head = null;

	CircularLinkedList insert(CircularLinkedList list) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int data = 0;

		try {
			System.out.println("Please enter the data: ");
			data = Integer.parseInt(br.readLine());

		} catch (Exception e) {
			System.out.println("Sorry! Try Again.. \n You entered wrong data.");
		}

		Node1 node = new Node1(data);

		if (list.head == null) {
			list.head = node;
			node.next = node;
		} else {
			Node1 curr_node = list.head;

			if (curr_node.data >= node.data) {
				while (curr_node.next != head)
					curr_node = curr_node.next;

				curr_node.next = node;
				node.next = list.head;
				list.head = node;
			} else {
				while (curr_node.next != list.head && curr_node.next.data < node.data)
					curr_node = curr_node.next;

				node.next = curr_node.next;
				curr_node.next = node;

			}

		}

		System.out.println("Data inserted. ");
		return list;
	}

	void printList(CircularLinkedList list) {

		Node1 curr_node = list.head;
		System.out.print("Data present in the linked list. \t");

		while (curr_node.next != list.head) {
			System.out.print(curr_node.data + "\t");

			curr_node = curr_node.next;
		}

		System.out.println(curr_node.data + "\t");
	}

	void menu() {
		System.out.println("1. Insert in a linked list. ");
		System.out.println("2. Delete in a linked list. ");
		System.out.println("3. Display the linked list. ");
		System.out.println("4. Exit ");
	}

	CircularLinkedList delete(CircularLinkedList list) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int data = 0;
		try {
			System.out.println("Please enter the data you want to delete: ");
			data = Integer.parseInt(br.readLine());

		} catch (Exception e) {
			System.out.println("Sorry! Try Again.. \n You entered wrong data.");
		}

		Node1 prev = list.head;
		Node1 curr_node = prev;

		if (prev.data == data) {

			if (prev.next == list.head) {
				list.head = null;

			} else {
				//list.head = curr_node.next;

				while (curr_node.next != list.head)
					curr_node = curr_node.next;

				curr_node.next = prev.next;
				list.head = prev.next;;
			}

		} else {

			curr_node = curr_node.next;
			while (curr_node.next != list.head) {

				if (curr_node.data == data) {
					prev.next = curr_node.next;
					break;
				}

				prev = curr_node;
				curr_node = curr_node.next;

			}
			if (curr_node.data == data && curr_node.next == list.head) {
				prev.next = curr_node.next;

			}
		}
		System.out.println("Node deleted.");
		return list;
	}

	public static void main(String[] args) {

		CircularLinkedList list = new CircularLinkedList();
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
					list.printList(list);
					break;

				case 4:
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
