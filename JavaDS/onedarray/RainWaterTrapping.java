package JavaDS.onedarray;

import java.util.ArrayList;
import java.util.Scanner;

public class RainWaterTrapping {
    public static void main(String args[]){
        System.out.println("enter the height of blocks");
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> al=new ArrayList<>();
        int n= sc.nextInt();
        while (n!=-1){
            al.add(n);
            n= sc.nextInt();
        }
        System.out.println("water blocks trapped is"+trap(al));
    }

    // Method 1
    // Time: O(n), Space: O(n)
    public static int trap(ArrayList<Integer> heights){
        int water=0;
        int lmax=0;
        int rmax=0;
        int h[]=new int[heights.size()];
        for (int i=0;i< heights.size();i++){
            if(heights.get(i)>lmax)
                lmax= heights.get(i);
            h[i]=lmax;
        }
        for (int i= heights.size()-1;i>=0;i--){
            if(heights.get(i)>rmax)
                rmax= heights.get(i);
            h[i]=Math.min(rmax,h[i]);

        }
        for (int i=0;i< heights.size();i++) {
            water += h[i] - heights.get(i);
        }
        return water;
    }

    // Method 2
    // Time: O(n), Space: O(1) (space optimised method)
    public static int trapOptimised(ArrayList<Integer> heights) {
        int water = 0;
        int l = 0, r = heights.size()-1;
        int lMax = heights.get(l), rMax = heights.get(r);
        while (l<r) {
            if (heights.get(l) <= heights.get(r)) {   // we always move pointer with lesser value
                if (heights.get(l) > lMax) {
                    lMax = heights.get(l);
                }
                water += lMax-heights.get(l);    //water will be 0 when lMax = heights.get(l)
                l++;
            } else {
                if (heights.get(r) > rMax) {
                    rMax = heights.get(r);
                }
                water += rMax-heights.get(r);
                r--;
            }
        }
        return water;
    }
}
