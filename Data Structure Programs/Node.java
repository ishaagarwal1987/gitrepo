package dataStructure;

class Node {

    int data;
    Node left, right;

    // Function to create a new binary tree node having a given key
    Node(int key) {
        data = key;
        left = right = null;
    }
}