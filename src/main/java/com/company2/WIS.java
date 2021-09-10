package main.java.com.company2;

import java.util.*;
import java.io.File;
import java.math.BigInteger;

public class WIS {
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(new File("test/data/WIS.txt"));
            int nodesCount = s.nextInt();

            BigInteger[] arr = new BigInteger[nodesCount + 1];

            arr[0] = BigInteger.valueOf(0);
            BigInteger first = BigInteger.valueOf(s.nextInt());
            BigInteger second = BigInteger.valueOf(s.nextInt());

            arr[1] = first;
            arr[2] = second;

            int[] res = new int[nodesCount + 1];
            BigInteger[] nodes = new BigInteger[nodesCount+1];
            nodes[0] = BigInteger.valueOf(0);
            nodes[1] = first;
            nodes[2] = second;
            int i = 3;
            while(s.hasNextInt()){
                //System.out.println(minHeap.size());
                BigInteger weight = BigInteger.valueOf(s.nextInt());
                nodes[i] = weight;
                BigInteger temp = arr[i-2].add(weight);
                arr[i] = temp.compareTo(arr[i-1]) == 1 ? temp : arr[i-1];
                i++;
            }
            
            i = arr.length-1;
            while(i > 2){
                BigInteger temp2 = arr[i-2].add(nodes[i]);
                if(temp2.compareTo(arr[i-1]) == 1){
                    res[i] = 1;
                    i -= 2;
                }
                else  i--;
            }
            if(res[3] == 1){
                res[1] = 1;
            }
            else{
                if(res[1] > res[2])  res[1] = 1;
                else  res[2] = 1;
            }
            
            StringBuilder wis = new StringBuilder();

            int[] input = new int[]{1, 2, 3, 4, 17, 117, 517, 997};
            //int[] input = new int[]{1, 2, 3, 4,5,6,7,8,9,10};  
            for(int j = 0; j < input.length; j++){
                wis.append(res[input[j]]);
            }
            
            System.out.println(wis);
            System.out.println(arr[arr.length-1]);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
