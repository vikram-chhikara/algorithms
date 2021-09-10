package com.company2;
import java.util.*;
import java.io.File;
import java.math.BigInteger;

public class TwoSum {
    
    public static void main(String[] args) {
        
        HashSet<BigInteger> nums = new HashSet<>();
        HashMap<BigInteger, Integer> map = new HashMap<>();

        //int[] arr = new int[];
        try{
            Scanner s = new Scanner(new File("src/test/data/TwoSum.txt"));
            
            while(s.hasNext()){
                BigInteger n = new BigInteger(s.next());  
                nums.add(n);
            }
            
            int i = 0;
            for(int j=-10000; j <= 10000; j++ ){
                BigInteger target = BigInteger.valueOf(j);
                for(BigInteger num: nums ){
                    BigInteger complement = target.subtract(num);
                    if(num.equals(complement)){
                        continue;
                    }
                    if(map.containsKey(complement)){
                        i++;
                        break;
                    }
                    map.put(num, 1);
                }
            }
            System.out.println(i);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
