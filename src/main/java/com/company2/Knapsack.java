package main.java.com.company2;

import java.util.*;
import java.io.File;
import java.math.BigInteger;

public class Knapsack {
    
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(new File("test/data/Knapsack.txt"));
            Scanner s2;

            int knapSackSize = s.nextInt();
            int itemsCount = s.nextInt();

            int[][] arr = new int[itemsCount+1][knapSackSize+1];

            int[] weights = new int[itemsCount+1];
            int[] values = new int[itemsCount+1];

            int j=1;
            while(s.hasNextLine()){
                String line = s.nextLine();
                s2 = new Scanner(line);

                while(s2.hasNext()){
                    int value = s2.nextInt();
                    int weight = s2.nextInt();
                    values[j] = value;
                    weights[j] = weight;
                    j++;
                }
            }
            // i = 4, w = 2
            
            for(int w = 0; w <= knapSackSize; w++){
                for(int i = 1; i <= itemsCount; i++){
                    if(w-weights[i] >= 0)  arr[i][w] = Math.max(arr[i-1][w], arr[i-1][w-weights[i]]+ values[i]);
                    else  arr[i][w] = arr[i-1][w];
                }
            }
            System.out.println(arr[itemsCount][knapSackSize]);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
