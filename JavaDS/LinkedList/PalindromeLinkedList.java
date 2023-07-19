package JavaDS.LinkedList;

import java.util.Scanner;

// Time: O(n), Space: O(1)

public class PalindromeLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    public static void main(String [] args){
        System.out.println("create singly linked list:");
        Node head=createLinkedList();
        printLinkedList(head);
        System.out.println("\nIs palindrome: " + isPalindrome(head));
    }

    public static Node createLinkedList() {
        Node head = null;
        Node cur = null;
        System.out.println("Enter numbers:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != -1) {
            if (head == null) {
                head = new Node(n);
                cur = head;
            } else {
                cur.next = new Node(n);
                cur = cur.next;
            }
            n = sc.nextInt();
        }
        return head;
    }
    public static void printLinkedList(Node head) {
        Node cur = head;
        System.out.println("\nLinked List: ");
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    public static Node findMiddleNode(Node head){
        Node fp=head;  //fast pointer
        Node sp=head;  //slow pointer
        while (fp!=null && fp.next!=null){
            fp=fp.next.next;
            sp=sp.next;
        }
        return sp;
    }

    public static Boolean isPalindrome(Node head){
        if (head==null) return true;
        Node cur=head;
        Node mid=findMiddleNode(head);
        Node last=reverseLinkedList(mid);
        while (last!=null){
            if (cur.data!= last.data) return false;
            cur=cur.next;
            last=last.next;
        }
        return true;
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
