package JavaDS.BinaryTrees;

import java.util.*;

public class BinaryTreeTraversals {
    static class Node {
        int data, lateralHeight; // lateralHeight will be initialised in verticalTraversal()
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
    static void preOrderTraversal(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    static void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    static void postOrderTraversal(Node node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    // Time: O(n), Space: O(n)
    public static void levelOrderTraversal(Node node) {
        Queue<Node> q = new LinkedList<>();  // can also use ArrayDeque instead
        if (node != null)
            q.add(node);
        while (!q.isEmpty()) {
            Node tmp = q.remove();
            System.out.print(tmp.data + " ");
            if (tmp.left != null) q.add(tmp.left);
            if (tmp.right != null) q.add(tmp.right);
        }
    }

    // Time: O(nlogn), Space: O(n)
    public static ArrayList<Integer> verticalOrder(Node root){
        Queue<Pair> q=new ArrayDeque<>();
        Map<Integer,ArrayList<Integer>> map=new TreeMap<>();

        q.add(new Pair(0,root));
        while (!q.isEmpty()){
            Pair cur=q.poll();
            if(map.containsKey(cur.hd)){
                map.get(cur.hd).add(cur.node.data);
            }
            else{
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(cur.node.data);
                map.put(cur.hd,temp);
            }

            if(cur.node.left!=null){
                q.add(new Pair(cur.hd-1,cur.node.left));
            }
            if(cur.node.right!=null){
                q.add(new Pair(cur.hd+1,cur.node.right));
            }
        }

        ArrayList<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> entry:map.entrySet()){
            ans.addAll(entry.getValue());
        }
        return ans;
    }

    static class Pair{
        int hd; //horizontal distance
        Node node;

        public Pair(int hd,Node node){
            this.node=node;
            this.hd=hd;
        }
    }

    public static void main(String[] args) {
        System.out.println("Create new binary tree");
        Node head = createBinaryTree();
        System.out.println("Preorder traversal:");
        preOrderTraversal(head);
        System.out.println();
        System.out.println("Inorder traversal:");
        inOrderTraversal(head);
        System.out.println();
        System.out.println("Postorder traversal:");
        postOrderTraversal(head);
        System.out.println();
        System.out.println("Levelorder traversal:");
        levelOrderTraversal(head);
        System.out.println();
    }

}
