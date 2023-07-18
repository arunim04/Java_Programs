package JavaDS.heaps;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// Time: O(n*log2(n)), Space: O(n)

public class ConnectNRopesWithMinCost {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the length of the array");
        int[] al=new int[sc.nextInt()];
        System.out.println("enter the rope size");
        int i=0;
        while (i<al.length){
            al[i]=sc.nextInt();
            i++;
        }
        System.out.println("min cost:"+nRopesMinCost(al));
    }

    public static int nRopesMinCost(int[] arr){
        Queue<Integer> pq=new PriorityQueue<>();
        for (int val:arr)
            pq.add(val);
        int minCost=0;
        while (pq.size()>1){
            int sum=pq.poll()+ pq.poll();
            minCost+=sum;
            pq.add(sum);
        }
        return minCost;
    }
}
