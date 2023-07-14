package JavaDS.onedarray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Time: O(n), Space: O(n)

public class DistinctElementsInWindowOfSizeK {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the length of the array");
        int[] al=new int[sc.nextInt()];
        System.out.println("enter the array");
        int i=0;
        while (i<al.length){
            al[i]=sc.nextInt();
            i++;
        }
        System.out.println("enter the size of window k");
        int k=sc.nextInt();
        if (k > al.length) {
            System.out.println("window size can't be greater than array length");
            return;
        }
        findDistinctElementsInWindowOfSizeK(al,k);
    }

    public static void findDistinctElementsInWindowOfSizeK(int[] arr,int k){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<k;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        System.out.print(map.size()+"");
        for (int i=k;i<arr.length;i++){
            if (map.get(arr[i-k])==1){
                map.remove(arr[i-k]);
            }
            else map.put(arr[i-k],map.get(arr[i-k])-1);
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            System.out.print(map.size()+"");
        }
    }
}
