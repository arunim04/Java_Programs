package JavaDS.BinaryTrees;

import java.util.Scanner;

public class MinTimeToBurnBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int maxTime = 0;
    static int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1; // this will give height of a tree with just one node as 1
    }

    // Time: O(n), Space: O(h)
    static int minTimeToBurn(Node node, int value) {
        if (node == null) return -1;
        if (node.data == value) {    // inputted leaf node found
            return 1;   // returning 1 as the node depth at the inputted leaf (since we're adding leaf node burning time to the total burning time) // otherwise, return 0
        }
        int leftMinDepth = minTimeToBurn(node.left, value);
        if (leftMinDepth != -1) {
            maxTime = Math.max(maxTime, leftMinDepth + 1 + height(node.right));    // get max height of right subtree if node depth is received from the left subtree
            return leftMinDepth + 1;     // increasing node depth at the parent node
        }
        int rightMinDepth = minTimeToBurn(node.right, value);
        if (rightMinDepth != -1) {
            maxTime = Math.max(maxTime, rightMinDepth + 1 + height(node.left));     // get max height of left subtree if node depth is received from the right subtree
            return rightMinDepth + 1;    // increasing node depth at the parent node
        }
        return -1;  // -1 means leaf node isn't found in any of the subtrees of the current node
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

    public static void main(String[] args) {
        System.out.println("Create new binary tree");
        Node head=createBinaryTree();
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter leaf value to start burning from:");
        int time = minTimeToBurn(head, sc.nextInt());
        System.out.println(time == -1 ? "Inputted leaf node not found" : "Min time to burn: " + maxTime);
    }
}
