package JavaDS.BinaryTrees;

import java.util.Scanner;

public class BinaryTreeOps {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node createBinaryTree() {
        Node node = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value:");
        int data = sc.nextInt();
        if (data != -1) {
            node = new Node(data);
            System.out.println("Enter left child for " + data);
            node.left = createBinaryTree();
            System.out.println("Enter right child " + data);
            node.right = createBinaryTree();
        }
        return node;
    }

    // Time: O(n), Space: O(h) if we consider stack space for recursive calls
    static int size(Node node) {
        if (node == null) return 0;
        return size(node.left) + 1 + size(node.right);
    }

    static int height(Node node) {
        if (node == null) return -1;
        if (node.left == null && node.right == null) return 0;  // we are taking height of a tree with just one node as 0
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    static int maximum(Node node) { // similarly, we can find minimum node
        if (node == null)
            return Integer.MIN_VALUE;
        return Math.max(node.data, Math.max(maximum(node.left), maximum(node.right)));
    }

    public static void main(String[] args) {
        System.out.println("Create new binary tree");
        Node head = createBinaryTree();
        System.out.println();
        System.out.println("Size of binary tree: " + size(head));
        System.out.println();
        System.out.println("Height of binary tree: " + height(head));
        System.out.println();
        System.out.println("Max value in binary tree: " + maximum(head));
        System.out.println();
    }
}
