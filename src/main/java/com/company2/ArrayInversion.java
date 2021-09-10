package com.company2;

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInversion {
    
    /** 
     * add left inversions by sorting and comparing
     * add right inversions by sorting 
     * add split inversins by merging both by sorting and comparing
     * compare - sallest on right with biggest on left
    */

    private static BigInteger count = BigInteger.valueOf(0);

    public static int[] getSplitInversions(int[] left, int[] right){

        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));

       // int i = left.length-1;

       int[] result = new int[left.length+right.length];
/*
        int stopPtr = -1;
        for(int j=0, i = left.length-1; j < right.length; j++){
            while(i >=0 && i > stopPtr){
                if(right[j] < left[i]){
                    count = count.add(BigInteger.valueOf(1));
                    i -=1;
                }
                else{
                    stopPtr = i;
                    break;
                }
            } 
            i = left.length-1;   
            //System.out.println("count " + count);  
        }
*/
        int k=0;
        int i=0;
        int j=0;

        int stopPtr = 0;

        while(i<left.length && j<right.length){
            if(right[j] < left[i]){
                result[k]= right[j];
                count = count.add(BigInteger.valueOf(left.length - stopPtr));
                j+=1;
            }
            else{
                result[k] = left[i];
                stopPtr += 1;
                i+= 1;         
            }
            k+=1;
        }
        if(j == right.length){
            for(; i<left.length; i++){
                result[k] = left[i];
                k += 1;
            }
        }
        else if(i == left.length){
            for(; j<right.length; j++){
                result[k] = right[j];
                k += 1;
            }
        }     
        return result;
    }

    public static int[] getInversions(int[] input){

        int n = input.length;

        if(n == 1){
            return input;
        }

        int[] x = getInversions(Arrays.copyOfRange(input, 0, n/2));
        int[] y = getInversions(Arrays.copyOfRange(input, n/2, n));

        return getSplitInversions(x,y);
    }
    public static BigInteger inversions(int[] input){
        
        getInversions(input);
        return count;
    }
}
