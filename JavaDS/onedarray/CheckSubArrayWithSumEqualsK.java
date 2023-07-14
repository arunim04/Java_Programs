package JavaDS.onedarray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Time: O(n), Space: O(n)

public class CheckSubArrayWithSumEqualsK {
    public static void main(String argsp[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the length of the array");
        int al[]=new int[sc.nextInt()];
        int i=0;
        System.out.println("enter the elements");
        while (i< al.length){
            al[i]= sc.nextInt();
            i++;
        }
        System.out.println("enter the sum");
        int sum=sc.nextInt();
        findSubArrayWithSumEqualsK(al,sum);
    }

    public static void findSubArrayWithSumEqualsK(int[] arr,int sum){
        Map<Integer,Integer> map=new HashMap<>();
        int cursum=0;
        int start=0;
        int end=-1;
        for (int i=0;i<arr.length;i++){
            cursum+=arr[i];
            if (cursum-sum==0){
                start=0;end=i;
                break;
            }
            if (map.containsKey(cursum-sum)){
                start=map.get(cursum-sum)+1;
                end=i;
                break;
            }
            map.put(cursum,i);
        }
        if (end==-1){
            System.out.println("not found");
        }
        else System.out.println(start+","+end);
    }
}
