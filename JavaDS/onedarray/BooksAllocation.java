package JavaDS.onedarray;

import java.util.Scanner;

// Time: O(N*log(N))

public class BooksAllocation {
    public static void main(String args[]){
        System.out.println("enter the no. of books");
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[sc.nextInt()];
        int i=0;
        while (i< arr.length){
            arr[i]=sc.nextInt();
            i++;
        }
        System.out.println("enter the no. of people");
        int m= sc.nextInt();
        System.out.println(minPages(arr,arr.length,m));
    }

    public static int minPages(int[] arr,int n,int m){
        int sum=0;
        if (n<m)
            return -1;
        int mx = arr[0];

        // Count total number of pages
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            mx = (Math.max(arr[i], mx));
        }
        int start=arr[n-1];
        int end=sum;
        int result=Integer.MAX_VALUE;
        while (start<=end){
            int mid=start + (end - start) / 2;
            if (isPossible(arr, n, m, mid)) {
                result = mid;
                end = mid - 1;
            }
            else start=mid+1;
        }
        return result;
    }

    public static boolean isPossible(int[] arr,int n,int m,int min){
        int studentserequired=1;
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>min){
                studentserequired++;
                sum=arr[i];
            }
        }
        return studentserequired<=m;
    }
}
