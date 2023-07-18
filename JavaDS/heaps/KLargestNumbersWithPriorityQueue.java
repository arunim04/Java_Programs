package JavaDS.heaps;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// Time: O(n*log2(k)), Space: O(k)

public class KLargestNumbersWithPriorityQueue {
    public static void main(String args[]) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the length of the array");
        int[] al=new int[sc.nextInt()];
        System.out.println("enter the no.");
        int i=0;
        while (i<al.length){
            al[i]=sc.nextInt();
            i++;
        }
        System.out.println("enter k:");
        int k=sc.nextInt();
        if (k>al.length)
            throw new Exception("k can't be greater than array length");
        kLargest(al, k);
    }

    //priority queue in java by default creates a min heap
    //to create max heap we use PriorityQueue<Integer> pq=new ProrityQueue<Integer>(Collections.reverseOrder());
    public static void kLargest(int[] arr,int k){
        Queue<Integer> pq=new PriorityQueue<>();
        for (int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if (pq.size()>k)
                pq.poll();   //it pops out the element from the queue
        }
        System.out.println(k+"largest numbers:");
        while (!pq.isEmpty()){
            System.out.println(pq.poll()+"");
        }
    }
}
