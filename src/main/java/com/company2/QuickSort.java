package com.company2;

import java.util.Arrays;

public class QuickSort {
    
    private static int numComparisons = 0;

    public static int partition(int[] arr, int l, int r){
  
       // System.out.println("arr " + Arrays.toString(arr));
       // System.out.println("l " + l);
       // System.out.println("r " + r);
        
        int pivot = arr[l];
        int i = l+1;        
        //partition
        for(int j = l+1; j <= r; j++){   
         //   System.out.println("i "+ i + " j "+ j);
            if(arr[j] < pivot ){     
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;  
            }
                        
        }
        
     //   System.out.println("i "+ i);

        arr[l] = arr[i-1];     
        arr[i-1] = pivot;
     //   System.out.println(Arrays.toString(arr));

        return i-1;
    }

    public static int partition2(int[] arr, int l, int r){
  
        // System.out.println("arr " + Arrays.toString(arr));
        // System.out.println("l " + l);
         //System.out.println("r " + r);
         
         int pivot = arr[r];
         int i = l; 
       
         //partition
         for(int j = l; j < r; j++){   
           //  System.out.println("i "+ i + " j "+ j);
             if(arr[j] < pivot ){     
                 int temp = arr[i];
                 arr[i] = arr[j];
                 arr[j] = temp;
                 i++;  
             }                   
         }
         arr[r] = arr[i];     
         arr[i] = pivot;
        // System.out.println(Arrays.toString(arr));
 
         return i;
    }

    public static int partition2SwapFirst(int[] arr, int l, int r){
        // System.out.println("arr " + Arrays.toString(arr));
        // System.out.println("l " + l);
        // System.out.println("r " + r);
         
        int pivot = arr[r];
        int tempo=0;
        tempo = arr[l];
        arr[l] = pivot;
        arr[r] = tempo;
/*
        for(int i = r; i >= l+1; i--){
            arr[i] = arr[i-1];
        }
        arr[l] = pivot;
        */
        int i = l+1;        
        //partition
        for(int j = l+1; j <= r; j++){   
            if(arr[j] < pivot ){     
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;  
            }             
        }  

        arr[l] = arr[i-1];     
        arr[i-1] = pivot;
        //System.out.println("arr " + Arrays.toString(arr));
        return i-1;
    }

    public static int partition3(int[] arr, int l, int r){

        System.out.println("arr " + Arrays.toString(Arrays.copyOfRange(arr, l, r+1)));
        //System.out.println("left " + arr[l]);
        //System.out.println("right " + arr[r]);
        
        int pivot=0;
        int i =0;
        int idx=0;
        int median = 0;        
        median = (l+r)/2;

        int[] a = new int[]{arr[l], arr[median], arr[r]};
        Arrays.sort(a);
    //       System.out.println("a "+ Arrays.toString(a));

        pivot = a[1];
        i = l;  
        idx=0;
        if(arr[l] == pivot)  idx = l;    
        else if(arr[r] == pivot)  idx = r;
        else if(arr[median] == pivot)  idx = median;
     //   System.out.println("pivot " + pivot);
        System.out.println("median " + arr[idx]);
        //partition
        for(int j = l; j <= r; j++){   
    //        System.out.println("i "+ i + " j "+ j);
            if(arr[j] < pivot && arr[i] != pivot){     
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;  
            System.out.println("arr "+ Arrays.toString(arr));
            System.out.println();
            }
            if( i <= r && arr[i] == pivot){
                i++;
            }         
        }
    //    System.out.println(Arrays.toString(arr));
    //    System.out.println("i "+ i);

        if(idx == r){
            arr[idx] = arr[i];     
            arr[i] = pivot;
      //      System.out.println(Arrays.toString(arr));
            return i;
        }
        else if(idx == l || idx == median){
            arr[idx] = arr[i-1];     
            arr[i-1] = pivot;
         //   System.out.println(Arrays.toString(arr));
            return i-1;
        }

        return i;

    }

    public static int partition3SwapFirst(int[] arr, int l, int r){

        //System.out.println("arr " + Arrays.toString(Arrays.copyOfRange(arr, l, r+1)));
        //System.out.println("left " + arr[l]);
        //System.out.println("right " + arr[r]);
        
        int pivot=0;
        int i =0;
        int idx=0;
        int median = 0;        
        median = (l+r)/2;

        int[] a = new int[]{arr[l], arr[median], arr[r]};
        Arrays.sort(a);
    //       System.out.println("a "+ Arrays.toString(a));

        pivot = a[1];
        i = l;  
        idx=0;
        if(arr[l] == pivot)  idx = l;    
        else if(arr[r] == pivot)  idx = r;
        else if(arr[median] == pivot)  idx = median;
     //   System.out.println("pivot " + pivot);
      //  System.out.println("median " + arr[idx]);
        
        int tempo = arr[l];
        arr[l] = arr[idx];
        arr[idx] = tempo;

        i = l+1;        
        //partition
        for(int j = l+1; j <= r; j++){   
         //   System.out.println("i "+ i + " j "+ j);
            if(arr[j] < pivot ){     
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;  
            }              
        }
        
     //   System.out.println("i "+ i);

        arr[l] = arr[i-1];     
        arr[i-1] = pivot;
     //   System.out.println(Arrays.toString(arr));

        return i-1;

    }

    public static int sort(int[] arr, int i, int j){
        if(i >= j)  return numComparisons;
        int k = partition3SwapFirst(arr, i, j);

        int old = numComparisons;
        numComparisons += k-i;
        numComparisons += (j-k);
        int newCount = numComparisons - old;
        //System.out.println("count "+ newCount);
        //System.out.println();
        sort(arr, i, k-1);
        sort(arr, k+1, j);

        return numComparisons;
    }

}