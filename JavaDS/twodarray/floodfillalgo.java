package JavaDS.twodarray;

import java.util.Arrays;
import java.util.Scanner;

// Time: O(m*n), Space: O(m*n)

public class floodfillalgo {
    public static void main(String[] args){
        System.out.println("enter the dimension of grid");
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        //make grid with border to avoid boundary conditions
        char[][] arr=new char[m+2][n+2];
        for (int i=0;i<m+2;i++)
            Arrays.fill(arr[i],'o');
        System.out.println("enter grid with p for passage and o for obstacle");
        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < n+ 1; j++)
                arr[i][j]=sc.next().charAt(0);
        System.out.println("Enter coordinates to start ");
        int srr = sc.nextInt();
        int scc = sc.nextInt();
        if(arr[srr][scc]!='p'){
            System.out.println("invalid coordinates");
            System.exit(0);
        }
        floodfillalgo ff=new floodfillalgo();
        ff.fillgrid(arr,scc,srr);
    }
    private void fillgrid(char[][]arr,int r,int c){
        if(arr[r][c]=='p'){
            arr[r][c]='w';
            System.out.println("\ngrid:");
            for (int i = 1; i < arr.length - 1; i++){
                for (int j = 1; j < arr[i].length - 1; j++)
                    System.out.print(arr[i][j] +" ");
                System.out.println();
            }
            fillgrid(arr, r + 1, c);
            fillgrid(arr, r - 1, c);
            fillgrid(arr, r, c + 1);
            fillgrid(arr, r, c - 1);
        }
    }
}
