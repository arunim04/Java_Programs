package JavaDS.BinarySearchTree;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Time: O(h), Space: O(n)

public class FindPairWithGivenSum {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static  int isPairPresent(Node root,int target){
        Set<Integer> set= new HashSet<Integer>();
        boolean ans=util(root,target,set);
        return ans?1:0;
    }
    static boolean util(Node root, int sum, Set<Integer> set){
        if(root==null) return false;
        if(util(root.left,sum,set)){
            return true;
        }
        if(set.contains(sum-root.data)){
            return true;
        }
        set.add(root.data);
        return util(root.right,sum,set);
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
        System.out.println("enter the sum to search");
        int sum=sc.nextInt();
        isPairPresent(head,sum);
    }
}
