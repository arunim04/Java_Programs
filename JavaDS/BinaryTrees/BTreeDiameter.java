package JavaDS.BinaryTrees;

import java.util.Scanner;

// Time: O(n), Space: O(h)

public class BTreeDiameter {
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

    static int ans=0;

    static int height(Node root){
        if (root==null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        ans=Math.max(ans,1+lh+rh);
        System.out.println(ans);
        return 1+Math.max(lh,rh);
    }

//ans returns the diameter
    public static void main(String[] args) {
        System.out.println("Create new binary tree");
        Node head = createBinaryTree();
        System.out.println();
        height(head);
    }

}
