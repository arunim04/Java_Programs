package JavaDS.BinaryTrees;

import java.util.*;

public class BinaryTreeViews {
    static class Node {
        int data, lateralHeight; // lateralHeight will be initialised during top and bottom view
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

    // Time: O(n), Space: O(w) - w: tree width
    static void leftView(Node node) {   //can also be done using dfs, and printing a node value if a level (in HashSet) is seen for the first time
        if (node == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node tmp = q.remove();
                if (i == 0) System.out.print(tmp.data + " ");
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }
        }
    }

    static void rightView(Node node) {  //can also be done using dfs, and printing a node value if a level (in HashSet) is seen for the first time
        if (node == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node tmp = q.remove();
                if (i == 0) System.out.print(tmp.data + " ");
                if (tmp.right != null) q.add(tmp.right);
                if (tmp.left != null) q.add(tmp.left);
            }
        }
    }

    // Time: O(n), Space: O(n)
    static void topView(Node node) {
        if (node == null) return;
        Map<Integer,Integer> map = new TreeMap<>(); // treemap, unlike hashmap, sorts entries based on key
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node.lateralHeight = 0, node.data);
        while (!q.isEmpty()) {
            Node tmp = q.remove();
            int lateralHeight = tmp.lateralHeight;
            if (tmp.left != null) {
                q.add(tmp.left);
                tmp.left.lateralHeight = lateralHeight-1;
                if (!map.containsKey(tmp.left.lateralHeight))
                    map.put(tmp.left.lateralHeight,tmp.left.data);
            }
            if (tmp.right != null) {
                q.add(tmp.right);
                tmp.right.lateralHeight = lateralHeight+1;
                if (!map.containsKey(tmp.right.lateralHeight))
                    map.put(tmp.right.lateralHeight,tmp.right.data);
            }
        }
        System.out.print(map.values());   // thus, will print the map according to the key/lateral height order (for eg: -2, -1, 0, 1, 2, ...)
    }

    static void bottomView(Node node) {
        if (node == null) return;
        Map<Integer,Integer> map = new TreeMap<>(); // treemap, unlike hashmap, sorts entries based on key
        Queue<Node> q = new LinkedList<>(); // can also use ArrayDeque instead
        q.add(node);
        map.put(node.lateralHeight = 0, node.data);
        while (!q.isEmpty()) {
            Node tmp = q.remove();
            int lateralHeight = tmp.lateralHeight;
            if (tmp.left != null) {
                q.add(tmp.left);
                tmp.left.lateralHeight = lateralHeight-1;
                map.put(tmp.left.lateralHeight,tmp.left.data);
            }
            if (tmp.right != null) {
                q.add(tmp.right);
                tmp.right.lateralHeight = lateralHeight+1;
                map.put(tmp.right.lateralHeight,tmp.right.data);
            }
        }
        System.out.print(map.values());   // thus, will print the map according to the key/lateral height order (for eg: -2, -1, 0, 1, 2, ...)
    }

    public static void main(String[] args) {
        System.out.println("Create new binary tree");
        Node head=createBinaryTree();
        System.out.println();
        System.out.println("Left view:");
        leftView(head);
        System.out.println();
        System.out.println("Right view:");
        rightView(head);
        System.out.println();
        System.out.println("Top view:");
        topView(head);
        System.out.println();
        System.out.println("Bottom view:");
        bottomView(head);
    }

}
