package JavaDS.BinarySearchTree;

import JavaDS.BinaryTrees.BinaryTreeOps;

import java.util.Scanner;

public class IsBinaryTreeBST {
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

    // Time: O(h), Space: O(h)
    static int minValue(Node node) {
        if (node == null) return -1;
        if (node.left != null)
            return minValue(node.left);
        return node.data;
    }
    static int maxValue(Node node) {
        if (node == null) return -1;
        if (node.right != null)
            return maxValue(node.right);
        return node.data;
    }

    // Time: O(n*h), Space: O(h)
    static boolean isBST(Node node) {
        if (node == null) return true;
        if (node.left != null)
            if (maxValue(node.left) > node.data)
                return false;
        if (node.right != null)
            if (node.data > minValue(node.right))
                return false;
        return isBST(node.left) && isBST(node.right);
    }

    // Time: O(n), Space: O(h)
    static boolean isBSTOptimised(Node node, int min, int max) {
        if (node == null) return true;
        if (min > node.data || node.data > max) return false;
        return isBSTOptimised(node.left, min, node.data - 1) && isBSTOptimised(node.right, node.data + 1, max);
    }

    static Node prev=null;
    // Time: O(n), Space: O(h)
    static boolean isBSTOptimised2(Node node) {
        if (node == null) return true;
        if (isBSTOptimised2(node.left)) {
            if (prev != null && prev.data > node.data)  // coz in inorder traversal of BST, prev element is always lesser than current element
                return false;
            prev = node;
            return isBSTOptimised2(node.right);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Create new binary tree");
        Node head=createBinaryTree();
        System.out.println();
        System.out.println("Is BST: " + isBST(head));
        System.out.println("Is BST (optimised method): " + isBSTOptimised(head, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }
}
