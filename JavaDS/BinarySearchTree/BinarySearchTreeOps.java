package JavaDS.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTreeOps {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Time: O(h), Space: O(h)
    static Node insert (Node node, int data) {
        if (node == null) return new Node(data);
        if (data < node.data) node.left = insert(node.left,data);
        else node.right = insert(node.right,data);
        return node;
    }

    static Node createBST() {
        Node node = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value:");
        int data = sc.nextInt();
        while (data != -1) {
            node = insert(node,data);   // always return the root node
            System.out.println("Enter value:");
            data = sc.nextInt();
        }
        return node;
    }

    // Time: O(n), Space: O(n)
    static void levelOrderTraversal(Node node) {    // same as that for binary tree // all other traversals are also same as for binary tree
        if (node == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            Node tmp = q.remove();
            System.out.print(tmp.data + " ");
            if(tmp.left != null) q.add(tmp.left);
            if(tmp.right != null) q.add(tmp.right);
        }
    }

    static Node minValue(Node node) {   // here, node is the root node of the right subtree of some parent node
        if (node == null) return null;
        if (node.left != null)
            return minValue(node.left);
        return node;
    }

    static Node delete(Node node, int key) {    // returns the root node finally
        if (node == null) {
            System.out.println("Value: " + key + " not found");
            return null;
        }
        if (key < node.data) node.left = delete(node.left, key);
        else if (key > node.data) node.right = delete(node.right, key);
        else {  // key == node.data
            // condition when either of the children is null, or both are null
            if (node.left == null) return node.right;   // node.right (can be null) will take place of deleted node
            if (node.right == null) return node.left;   // node.left (can be null) will take place of deleted node
            // condition when both children are not null
            Node tmp = minValue(node.right);            // gives the smallest (leftmost) element in the right subtree of that node // i.e., inorder successor or the next bigger element after that node
            node.data = tmp.data;
            node.right = delete(node.right, tmp.data);  // remove the smallest (leftmost) element in the right subtree of the node
        }
        return node;
    }

    public static void main (String args[]) {
        System.out.println("Create new binary search tree");
        Node head = createBST();
        System.out.println();
        System.out.println("Level order traversal:");
        levelOrderTraversal(head);
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value to delete: ");
        delete(head, sc.nextInt());
        System.out.println();
        System.out.println("Level order traversal:");
        levelOrderTraversal(head);
    }
}
