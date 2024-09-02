package JavaDS.BinarySearchTree;
import  JavaDS.BinarySearchTree.BinarySearchTreeOps;

import java.util.Scanner;

public class FloorCeilOfAValueInBST {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Time: O(h), Space: O(1)
    static int floor(Node node, int value) {
        int floor = Integer.MAX_VALUE;
        while (node != null) {
            if (node.data == value) return node.data;   // return the same value if present
            if (node.data < value) {
                floor = node.data;
                node = node.right;
            } else node = node.left;
        }
        return floor;
    }
    static int ceil(Node node, int value) {
        int ceil = Integer.MIN_VALUE;
        while (node != null) {
            if (node.data == value) return node.data;   // return the same value if present
            if (value < node.data) {
                ceil = node.data;
                node = node.left;
            } else node = node.right;
        }
        return ceil;
    }

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

    public static void main(String args[]){
        System.out.println("Create new binary search tree");
        Node head = createBST();
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value to find floor & ceil of: ");
        int val = sc.nextInt();
        System.out.printf("\nFloor for %s: %s\n", val, floor(head,val));
        System.out.printf("Ceil for %s: %s\n", val, ceil(head,val));
    }
}
