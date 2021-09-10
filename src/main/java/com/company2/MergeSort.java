 
package com.company2;

import java.util.Arrays;

/*
Assume input of even length
 [1,4,7,8,2,6,3,5] -> [1,2,3,4,5,6,7,8]
 Divide in half until both left and right equal size 1
 sort left and right side, then merge simpe comparison O(N)
 
*/
public class MergeSort{

    public static int[] merge(int[] arr1, int[] arr2){

        int i = 0;
        int j = 0;
        int k = 0;

        int[] result = new int[arr1.length+arr2.length];

        while(i<arr1.length && j<arr2.length){
            if(arr1[i] <= arr2[j]){
                result[k] = arr1[i];
                i += 1;
            }
            else{
                result[k] = arr2[j];
                j += 1;
            }
            k += 1;
        }

        if(j == arr2.length){
            for(; i<arr1.length; i++){
                result[k] = arr1[i];
                k += 1;
            }
        }
        else if(i == arr1.length){
            for(; j<arr2.length; j++){
                result[k] = arr2[j];
                k += 1;
            }
        }
        return result;
    }

    public int[] mergeSort(int[] arr){

        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }
}