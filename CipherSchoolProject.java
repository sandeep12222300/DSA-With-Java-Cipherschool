// Node class
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BinarySearchTree class
class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a node
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Search for a node
    boolean search(int key) {
        return searchRec(root, key) != null;
    }

    // Delete a node
    void deleteNode(int key) {
        root = deleteRec(root, key);
    }

    // Inorder traversal
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    // Preorder traversal
    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    // Postorder traversal
    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    // Helper function to insert a node
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Helper function to search for a node
    Node searchRec(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }

    // Helper function to delete a node
    Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // Helper function to find the minimum value node
    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // Helper function for inorder traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Helper function for preorder traversal
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Helper function for postorder traversal
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Main method
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder traversal:");
        bst.inorder();

        System.out.println("Preorder traversal:");
        bst.preorder();

        System.out.println("Postorder traversal:");
        bst.postorder();

        System.out.println("Search for 40: " + (bst.search(40) ? "Found" : "Not Found"));
        System.out.println("Search for 25: " + (bst.search(25) ? "Found" : "Not Found"));

        bst.deleteNode(20);
        System.out.println("Inorder traversal after deleting 20:");
        bst.inorder();

        bst.deleteNode(30);
        System.out.println("Inorder traversal after deleting 30:");
        bst.inorder();

        bst.deleteNode(50);
        System.out.println("Inorder traversal after deleting 50:");
        bst.inorder();
    }
}
