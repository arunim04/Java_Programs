package JavaDS.onedarray;

import java.util.Scanner;

public class primenumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a no. n to find prime nos. till it");
        int a = sc.nextInt();
        int[] num=new int[a+1];
        for(int i=0;i<=a;i++){
            num[i]=i;
        }
        primo(num);
    }
    public static void primo(int[] num){
        num[0]=-1;num[1]=-1;
        for(int i=2;i<=Math.sqrt(num.length-1);i++){
            if (num[i] != -1) {
                for(int j=2;j<=(num.length-1)/i;j++) {
                    int c = i * j;
                    num[c] = -1;
                }
            }
        }
        for(int i=2;i<=num.length-1;i++){
            if(num[i]!=-1)
                System.out.print(num[i]+" ");
        }
    }
}
