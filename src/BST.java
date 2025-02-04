import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BST {

    public static Node searchBST(Node root, int target) {
        while (root != null) {
            if (target == root.data)
                return root;
            else if (target < root.data)
                root = root.left;
            else
                root = root.right;
        }
        return root;
    }

    public static List<Integer> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        q.add(root);
        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                Node temp = q.poll();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                ans.add(temp.data);
            }
        }
        return ans;
    }

    public static Node insertionBST(Node root, int target) {
        if (root == null) return new Node(target);
        Node cur = root;
        while (true) {
            if (target < cur.data) {
                if (cur.left == null) {
                    cur.left = new Node(target);
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new Node(target);
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }

    public static Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public static Node deletionBST(Node root, int target) {
        Node parent = null;
        Node current = root;

        while (current != null && current.data != target) {
            parent = current;
            if (target < current.data)
                current = current.left;
            else
                current = current.right;
        }

        if (current == null) return root;

        if (current.left == null && current.right == null) {
            if (current != root) {
                if (parent.left == current) parent.left = null;
                else parent.right = null;
            } else {
                root = null;
            }
        }

        else if (current.left != null && current.right != null) {
            Node successor = findMin(current.right);
            int val = successor.data;
            root = deletionBST(root, successor.data);
            current.data = val;
        }

        else {
            Node child = (current.left != null) ? current.left : current.right;

            if (current != root) {
                if (current == parent.left) parent.left = child;
                else parent.right = child;
            } else {
                root = child;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(9);
        root.left = new Node(2);
        root.right = new Node(11);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        Node root1 = insertionBST(root, 13);

        List<Integer> ans = levelOrder(root1);
        for (int x : ans) {
            System.out.print(x + " ");
        }

        System.out.println();

        Node root2 = deletionBST(root1, 11);
        List<Integer> ans2 = levelOrder(root2);
        for (int x : ans2) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
