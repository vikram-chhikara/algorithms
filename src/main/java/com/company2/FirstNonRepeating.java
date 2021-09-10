package main.java.com.company2;

import java.util.LinkedHashSet;

public class FirstNonRepeating{

    public static int firstNonRepeatingChar(String str){

        int[] count = new int[26];

        for(int i = 0 ; i < str.length(); i++){
            count[str.charAt(i)-97] += 1; 
            
        }
        for(int i = 0 ; i < str.length(); i++){
            if( count[((int)str.charAt(i))-97] == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        
        int result = firstNonRepeatingChar("leetcode");
        
        if(result == -1){
            System.out.println("No such char found");
        }
        else{
            System.out.println(result);
        }
    }
}
