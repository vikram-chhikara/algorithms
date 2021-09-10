package main.java.com.company2;

import java.util.Arrays;

public class MatrixRotation {

    public static String[][] result;

    public static void swapLeftTop(int start, int end, String[][] arr){

        int j = start;
        for(int i = end; i >= start; i--){
            result[start][start + (end-i)] = arr[i][j];
        }
    }

    public static void swapTopRight(int start, int end, String[][] arr){

        int i = start;
        for(int j = start; j <= end; j++){
            result[j][end] = arr[i][j];
        }
    }

    public static void swapRightBottom(int start, int end, String[][] arr){

        int j = end;
        for(int i = start; i <= end; i++){
            result[j][start + (end-i)] = arr[i][j];
        }
    }

    public static void swapBottomLeft(int start, int end, String[][] arr){

        int i = end;
        for(int j = end; j >= start; j--){
            result[j][start] = arr[i][j];
        }
    }

    public static void rotate(String[][] arr){

        int n = arr.length;
        result = new String[n][n];
        int start = 0;
        int end = arr.length - 1;

        while( (end - start) >= 1){

            swapLeftTop(start, end, arr);
            swapTopRight(start, end, arr);
            swapRightBottom(start, end, arr);
            swapBottomLeft(start, end, arr);

            for(int i = 0; i < n; i++){
                System.out.println(result[i][0]);
            }
            start += 1;
            end -= 1;
    
        }
    }

    public static void rotateInPlace(String[][] arr){

        int n = arr.length;

        int start = 0;
        int end = n - 1;
        String temp = "";
        String s = "";

        while((end - start) >= 1){

            for(int k = start; k < end; k++){

                //swapLeftTop
                s = arr[end-k][start];
                temp = arr[start][start+k];
                arr[start][start+k] = s;

                //swapTopRight
                s = temp;
                temp = arr[start+k][end];
                arr[start+k][end] = s;

                //swapRightBottom
                s = temp;
                temp = arr[end][end-k];
                arr[end][end-k] = s;

                //swapBottomLeft
                s = temp;
                temp = arr[end-k][start];
                arr[end-k][start] = s;
            }
            start += 1;
            end -= 1;
        }
    }
    public static void main(String[] args){

        String[][] arr  = {
            {"a", "b", "c", "d"},
            {"e", "f", "g", "h"},
            {"i", "j", "k", "l"},
            {"m", "n", "o", "p"}
        };
        rotateInPlace(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
