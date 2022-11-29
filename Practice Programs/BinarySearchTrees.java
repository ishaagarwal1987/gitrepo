
class Node {

    int data;
    Node left, right;

    // Function to create a new binary tree node having a given key
    Node(int key) {
        data = key;
        left = right = null;
    }
}

public class BinarySearchTrees {

    public static Node insert(Node root, int key) {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }

        // if the given key is less than the root node,
        // recur for the left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        } // otherwise, recur for the right subtree
        else {
            // key >= root.data
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static Node constructBST(int[] keys) {
        Node root = null;
        for (int key : keys) {
            root = insert(root, key);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);

        postorder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static void printTree(Node root)
    {
        
    }

    public static void main(String[] args) {
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        Node root = constructBST(keys);
        printTree(root);
        System.out.print("In-order tree traversal : ");
        inorder(root);
        System.out.println("");
        System.out.print("Pre-order tree traversal : ");
        preorder(root);
        System.out.println("");
        System.out.print("Post-order tree traversal : ");
        postorder(root);
    }

}
