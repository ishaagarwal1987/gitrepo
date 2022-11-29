package dataStructure;

public class DoublyNode {
	

    int data;
    DoublyNode prev, next;

    // Function to create a new binary tree node having a given key
    DoublyNode(int key) {
        data = key;
        prev = next = null;
    }

}
