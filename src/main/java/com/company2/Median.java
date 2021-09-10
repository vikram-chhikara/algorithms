package com.company2;

import java.util.*;
import java.io.File;
import java.math.BigInteger;

public class Median {
    

    public static void main(String[] args){

        try{
            PriorityQueue<BigInteger> maxHeap = new PriorityQueue<BigInteger>(Collections.reverseOrder());
            PriorityQueue<BigInteger> minHeap = new PriorityQueue<BigInteger>();
       
            Scanner s = new Scanner(new File("first-project/src/test/data/Median.txt"));
            
            BigInteger sum = BigInteger.valueOf(0);

            while(s.hasNextInt()){
                BigInteger n = BigInteger.valueOf(s.nextInt());

                if(minHeap.isEmpty()){
                    minHeap.add(n);
                    sum = sum.add(n);
                    // System.out.println("minHeap " + minHeap.peek());
                    // System.out.println("sum " + sum);
                    // System.out.println();
                }
                else if(maxHeap.isEmpty()){
                    if(n.compareTo(minHeap.peek()) == 1){
                        maxHeap.add(minHeap.poll());
                        minHeap.add(n);
                    }
                    else  maxHeap.add(n);
                    //sum = sum.add((minHeap.peek().add(maxHeap.peek())).divide(BigInteger.valueOf(2))); 
                    sum = sum.add(maxHeap.peek());
                    // System.out.println("minHeap " + minHeap.peek());
                    // System.out.println("maxHeap " + maxHeap.peek());
                    // System.out.println("sum " + sum);
                    // System.out.println();
                }   
                else{

                    if(n.compareTo(minHeap.peek()) == 1){
                        minHeap.add(n);
                    }
                    else if(n.compareTo(maxHeap.peek()) == -1){
                        maxHeap.add(n);
                    }
                    else{
                        maxHeap.add(n);
                    }

                    int diff = maxHeap.size() - minHeap.size();

                    if(diff > 1){
                        minHeap.add(maxHeap.poll());
                        //System.out.println("minHeap " + minHeap.peek());
                        //System.out.println("maxHeap " + maxHeap.peek());
                        
                    }
                    else if(diff < -1){
                        maxHeap.add(minHeap.poll());
                        // System.out.println("minHeap " + minHeap.peek());
                        // System.out.println("maxHeap " + maxHeap.peek());
                    }

                    diff = maxHeap.size() - minHeap.size();

                    if(diff == 1){
                        sum = sum.add(maxHeap.peek());
                        //System.out.println("sum " + sum);
                    }
                    else if(diff == -1){
                        sum = sum.add(minHeap.peek());
                        //System.out.println("sum " + sum);
                    }
                    else if(diff == 0){
                        //   sum = sum.add((minHeap.peek().add(maxHeap.peek())).divide(BigInteger.valueOf(2)));
                        sum = sum.add(maxHeap.peek());
                        //System.out.println("sum " + sum);
                    }
                    //System.out.println();
                }


            }
            System.out.println(sum);
            System.out.println(sum.mod(BigInteger.valueOf(10000)));
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
