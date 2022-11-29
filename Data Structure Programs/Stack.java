package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stack {
	
	Node1 head = null;
	
	void menu() {
		System.out.println("1. Push ");
		System.out.println("2. Pop ");
		System.out.println("3. Peek ");
		System.out.println("4. Is Empty ");
		System.out.println("5. Exit ");
	}
	
	void push(Stack stack)
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

		if (stack.head == null) {
			stack.head = new_node;
		} else {
			new_node.next = stack.head;
			stack.head = new_node;

		}

		System.out.println("Data inserted. ");
	}
	
	void pop(Stack stack)
	{
		System.out.println("Data Poped is : "+stack.head.data);
		stack.head = stack.head.next;
	}
	
	void peek(Stack stack)
	{
		System.out.println("Data Peeked is : "+stack.head.data);
	}
	
	void isEmpty(Stack stack)
	{
		if(stack.head==null)
			System.out.println("Stack is empty.");
		else
			System.out.println("Stack is not empty.");
	}

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ch = 0;

		while (true) {
			stack.menu();
			System.out.println("Enter your choice: ");
			try {
				ch = Integer.parseInt(br.readLine());

				switch (ch) {
				case 1:
					stack.push(stack);
					break;

				case 2:
					stack.pop(stack);
					break;

				case 3:
					stack.peek(stack);
					break;
					
				case 4:
					stack.isEmpty(stack);
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
