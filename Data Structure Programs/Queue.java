package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Queue {
	Node1 head = null;
	
	
	void menu() {
		System.out.println("1. Enqueue ");
		System.out.println("2. Dequeue ");
		System.out.println("3. Peek ");
		System.out.println("4. Is Empty ");
		System.out.println("5. Exit ");
	}
	
	void enqueue(Queue queue)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int data = 0;

		try {
			System.out.println("Please enter the data: ");
			data = Integer.parseInt(br.readLine());

		} catch (Exception e) {
			System.out.println("Sorry! Try Again.. \n You entered wrong data.");
		}
		
		Node1 new_node = new Node1(data);
		
		if(queue.head==null)
		{
			queue.head=new_node;
			
		}
		else
		{
			Node1 curr_node = queue.head;
			
			while(curr_node.next!=null)
				curr_node = curr_node.next;
			
			curr_node.next = new_node;
		}
		
		System.out.println("Data inserted. ");
	}
	
	void dequeue(Queue queue)
	{
		System.out.println("Data removed is "+queue.head.data);
		queue.head=queue.head.next;
	}
	
	void peek(Queue queue)
	{
		System.out.println("Data peeked is "+queue.head.data);
		
	}
	void isEmpty(Queue queue)
	{
		if(queue.head==null)
			System.out.println("Stack is empty.");
		else
			System.out.println("Stack is not empty.");
	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ch = 0;

		while (true) {
			queue.menu();
			System.out.println("Enter your choice: ");
			try {
				ch = Integer.parseInt(br.readLine());

				switch (ch) {
				case 1:
					queue.enqueue(queue);
					break;

				case 2:
					queue.dequeue(queue);
					break;

				case 3:
					queue.peek(queue);
					break;
					
				case 4:
					queue.isEmpty(queue);
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
