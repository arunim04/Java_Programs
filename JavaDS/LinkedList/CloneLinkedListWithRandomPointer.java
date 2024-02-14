package JavaDS.LinkedList;

// Time: O(n), Space: O(1)

public class CloneLinkedListWithRandomPointer {
    static class Node{
        int data;
        Node next;
        Node random;
        Node(int data){
            this.data= data;
        }
    }

    public static void main(String [] args){
        System.out.println("create singly linked list:");
        Node head=createLinkedList();
        System.out.println("original:");
        printLinkedList(head);
        System.out.println("cloned:");
        printLinkedList(clone(head));
    }

    public static Node createLinkedList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        node1.random = node3;
        node2.random = node1;
        node3.random = null;
        node4.random = node2;
        return head;
    }

    public static void printLinkedList(Node head) {
        Node cur = head;
        System.out.print("Linked List: ");
        while (cur != null) {
            System.out.printf("%s(%s) ", cur.data, cur.random!= null ? cur.random.data : "");
            cur = cur.next;
        }
    }

    public static Node clone(Node head){
        Node cur=head;
        while (cur!=null){
            Node tmp=cur.next;
            cur.next=new Node(cur.data);
            cur.next.next=tmp;
            cur=tmp;
        }
        cur=head;

        while (cur!=null){
            if (cur.next!=null)
                cur.next.random=(cur.random!=null)?cur.random.next:null;
            cur=cur.next.next;
        }

        cur=head;
        Node cloneHead=cur.next;
        while (cur!=null){
            Node tmp=cur.next.next;
            cur.next.next=tmp!=null?tmp.next:null;
            cur.next=tmp;
            cur=tmp;
        }
        return cloneHead;
    }
}
