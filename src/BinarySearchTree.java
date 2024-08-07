class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insert(root, key);
    }

    Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    boolean search(int key) {
        return search(root, key) != null;
    }

    Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (root.key > key) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    void delete(int key) {
        root = delete(root, key);
    }

    Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);
            root.right = delete(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    void inorder() {
        inorder(root);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

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
        System.out.println();

        System.out.println("Search for key 40: " + (bst.search(40) ? "Found" : "Not Found"));
        System.out.println("Search for key 90: " + (bst.search(90) ? "Found" : "Not Found"));

        System.out.println("Deleting key 20");
        bst.delete(20);
        System.out.println("Inorder traversal after deletion:");
        bst.inorder();
        System.out.println();

        System.out.println("Deleting key 30");
        bst.delete(30);
        System.out.println("Inorder traversal after deletion:");
        bst.inorder();
        System.out.println();

        System.out.println("Deleting key 50");
        bst.delete(50);
        System.out.println("Inorder traversal after deletion:");
        bst.inorder();
        System.out.println();
    }
}
