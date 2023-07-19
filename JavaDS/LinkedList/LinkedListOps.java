package JavaDS.LinkedList;

//Time: O(n)

public class LinkedListOps {
    public static class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data=data;
        }
    }

    public static void main(String[] args){
        Node<Integer> n1=new Node<>(10);
        Node<Integer> n2=new Node<>(20);
        Node<Integer> n3=new Node<>(30);
        Node<Integer> head=n1;
        head.next=n2;
        n2.next=n3;
        n3.next=null;
        insert(65,head,2);
        traverse(head);
        delete(head,1);
        traverse(head);
    }

    public static void traverse(Node<Integer> head){
        Node<Integer> cur=head;
        while (cur!=null){
            System.out.println(cur.data);
            cur=cur.next;
        }
    }

    public static void insert(int data,Node<Integer> head,int pos){
        Node<Integer> toAdd=new Node(data);
        if (pos==0){
            toAdd.next=head;
            head=toAdd;
            return;
        }
        Node<Integer> prev=head;
        for (int i=0;i<pos-1;i++)
            prev=prev.next;
        toAdd.next=prev.next;
        prev.next=toAdd;
    }

    public static void delete(Node<Integer> head,int pos){
        if (pos==0) {
            head = head.next;
            return;
        }
        Node prev=head;
        for (int i=0;i<pos-1;i++)
            prev=prev.next;
        prev.next=prev.next.next;
    }
}
