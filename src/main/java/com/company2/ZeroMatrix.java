package main.java.com.company2;

import java.util.Arrays;

public class ZeroMatrix {

    public static void helper(int[][] arr, int i, int j){
        arr[i][j] = 1;
    }
    public static void zeroMatrix(int m, int n){

        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                helper(arr, i, j);
                System.out.println(Arrays.deepToString(arr));
            }
        }
    }
    public static void main(String[] args){
        
        zeroMatrix(2,2);
    }
    
}
