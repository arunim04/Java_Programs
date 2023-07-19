package JavaDS.LinkedList;

// Time: O(n), Space: O(1)

public class CycleDetectionLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    public static void main(String [] args){
        Node head=createLinkedList();
        findCycle(head);
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
        node4.next = node2; // null for no cycle
        return head;
    }

    public static Node hasCycle(Node head){
        Node fp=head;
        Node sp=head;
        while (fp!=null && fp.next!=null){
            fp=fp.next.next;
            sp=sp.next;
            System.out.println(fp.data+""+sp.data);
            if (fp==sp) return sp;
        }
        return null;
    }

    public static void findCycle(Node head){
        Node meet=hasCycle(head);
        if (meet==null){
            System.out.println("\nNo cycle found");
            return;
        }
        Node cur=head;
        while (cur!=meet){
            cur=cur.next;
            meet=meet.next;
        }
        System.out.println("\nCycle found at node: " + cur.data);
    }
}
