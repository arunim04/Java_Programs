package JavaDS.Stacks;

// Time: O(1), Space: O(1)

import java.util.Scanner;

public class LinkedListImplementationOfQueue {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    static class Queue {
        Node front, rear;
        Queue() {
            front = rear = null;
        }

        // Time: O(1)
        public void enqueue(int num) {
            Node tmp = new Node(num);
            if (rear == null)
                front = rear = tmp;
            else {
                rear.next = tmp;
                rear = tmp;
            }
            printQueue();
        }

        // Time: O(1)
        public void dequeue() {
            if (front != null) {
                if (front.next == null)
                    front = rear = null;
                else front = front.next;
            }
            printQueue();
        }

        public void printQueue() {
            if (front == null) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.print("Queue: ");
            Node cur = front;
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue llQ = new Queue();
        System.out.println("Options: enter 1 for enqueue | enter 2 for dequeue | enter -1 to exit");
        while (true) {
            System.out.println("Enter option:");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter number: ");
                    llQ.enqueue(sc.nextInt());
                    break;
                case 2:
                    llQ.dequeue();
                    break;
                case -1:
                    System.out.println("Exiting");
                    return;
            }
        }
    }
}
