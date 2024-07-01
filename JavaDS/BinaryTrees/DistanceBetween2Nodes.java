package JavaDS.BinaryTrees;

import java.util.Scanner;

public class DistanceBetween2Nodes {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Time: O(n), Space: O(h) if we consider stack space for recursive calls
    // solution assumes either both given values are present in the tree, or both are absent
    static Node lca(Node node, int value1, int value2) {
        if (node == null) return null;
        if (node.data == value1 || node.data == value2)     // return the node itself as its ancestor if its value matches the input // also signifies that the key is found
            return node;
        Node leftLca = lca(node.left, value1, value2);
        Node rightLca = lca(node.right, value1, value2);
        if (leftLca != null && rightLca != null)            // this means one key is present in one subtree and other is present in other; so this node is the LCA
            return node;
        return (leftLca != null) ? leftLca : rightLca;      // else, return either leftLca or rightLca, whichever isn't null, i.e. either of the node has been found, or both the nodes have been found in either the left or the right subtree, thus, making the most recently found one as the lca
    }

    static int findLevel(Node node, int distance, int value) {  // here, we're considering root node to be at level 0  // -1 return ultimately means value not found
        if (node == null) return -1;
        if (node.data == value) return distance;
        int lDist = findLevel(node.left, distance + 1, value);
        return (lDist != -1) ? lDist : findLevel(node.right, distance + 1, value);
    }

    static int distBetween2Nodes(Node node, int value1, int value2) {
        Node lca = lca(node, value1, value2);
        if (lca == null) return -1;
        return findLevel(lca, 0, value1) + findLevel(lca, 0, value2);
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
        System.out.println("Enter value1 and value2 to find lowest common ancestor:");
        Node tmp = lca(head, sc.nextInt(), sc.nextInt());
        System.out.println(tmp == null ? "No LCA" : "LCA: " + tmp.data);
        System.out.println();
        System.out.println("Enter value to find its distance from root:");
        int dist = findLevel(head, 0, sc.nextInt());
        System.out.println(dist == -1 ? "Element not found in the path" : "Distance from root: " + dist);
        System.out.println("Enter value1 and value2 to find distance between them");
        dist = distBetween2Nodes(head, sc.nextInt(), sc.nextInt());
        System.out.println(dist == -1 ? "Unable to calculate distance between given values" : "Distance between given values: " + dist);
    }
}
