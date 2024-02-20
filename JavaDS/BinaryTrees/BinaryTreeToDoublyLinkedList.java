package JavaDS.BinaryTrees;

import java.util.Scanner;

public class BinaryTreeToDoublyLinkedList {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node head;
    static Node prev;

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

    static void convertToDLL(Node node) {
        if (node == null) return;
        convertToDLL(node.left);    // inorder traversal
        if (prev == null) head = node;
        else {
            node.left = prev;
            prev.right = node;
        }
        prev = node;
        convertToDLL(node.right);
    }

    static void printDoublyLinkedList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.right;
        }
    }

    public static void main(String[] args){
        System.out.println("Create new binary tree");
        Node head = createBinaryTree();
        System.out.println();
        System.out.println("Doubly linked list: ");
        convertToDLL(head);
        printDoublyLinkedList();
    }

}
