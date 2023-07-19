package JavaDS.LinkedList;

import java.util.Scanner;

// Time: O(n), Space: O(1)

public class ReverseALinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    public static void main(String [] args){
        System.out.println("create a singly linked list");
        Node head=createLinkedList();
        printLinkedList(head);
        head=reverseLinkedList(head);
        printLinkedList(head);
    }

    public static Node createLinkedList(){
        Node head=null;
        Node curr=null;
        System.out.println("insert numbers");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while (n!=-1){
            if (head==null){
                head=new Node(n);
                curr=head;
            }
            else {
                curr.next=new Node(n);
                curr=curr.next;
            }
            n=sc.nextInt();
        }
        return head;
    }

    public static void printLinkedList(Node head){
        Node curr=head;
        System.out.println("\nLinked List:");
        while (curr!=null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static Node reverseLinkedList(Node head){
        Node prev=null;
        Node curr=head;
        Node temp;
        while (curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
