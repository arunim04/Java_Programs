package JavaDS.heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// Time: O(n*log2(n)), Space: O(n)

public class RunningMedian {
    public static void main(String args[]){
        runningMedian();
    }

    public static void runningMedian(){
        Queue<Integer> pq_min=new PriorityQueue<>();
        Queue<Integer> pq_max=new PriorityQueue<>(Collections.reverseOrder());
        Scanner sc=new Scanner(System.in);
        System.out.println("enter value:");
        int n=sc.nextInt();
        double median;
        while (n!=-1){
            if (pq_max.size()==0||n<pq_max.peek())
                pq_max.add(n);
            else pq_min.add(n);

            boolean isOddCount= (pq_max.size()+pq_min.size())%2!=0?true:false;
            if (isOddCount){
                if (pq_max.size()<pq_min.size())
                    pq_max.add(pq_min.poll());
                median=pq_max.peek();
            }
            else {
                if (pq_max.size()>pq_min.size())
                    pq_min.add(pq_max.poll());
                median=(pq_max.peek()+pq_min.peek())/2.0;
            }
            System.out.println("median:"+median);
            System.out.println("enter value\n");
            n= sc.nextInt();
        }
    }
}
