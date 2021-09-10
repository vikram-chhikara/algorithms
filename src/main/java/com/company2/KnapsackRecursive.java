package main.java.com.company2;

import java.util.*;
import java.io.File;
import java.lang.reflect.Array;
import java.math.BigInteger;

public class KnapsackRecursive {
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(new File("test/data/Knapsack_big.txt"));
            Scanner s2;

            int knapSackSize = s.nextInt();
            int itemsCount = s.nextInt();

            int[] dp = new int[knapSackSize+1];

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

            for(int i = 0; i <= itemsCount; i++){
                for(int w = knapSackSize; w >= 0; w--){
                    if(weights[i] <= w){
                        dp[w] = Math.max(dp[w], dp[w-weights[i]] + values[i]);
                    }
                }
            }
            System.out.println(dp[knapSackSize]);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
