package main.java.com.company2;

public class Solution {
    

    public static String stringCompression(String str){

        int i = 0;
        int j = 0;
        StringBuilder result = new StringBuilder();
        while(i < str.length()){
            result.append(str.charAt(i));
            while(j < str.length() && (str.charAt(i) == str.charAt(j))){
                j++;
            }
            result.append(j-i);
            i = j;
        }
        return result.toString();
    }
    public static void main(String[] args){

        String input = "aabcccccaaa";
        System.out.println(stringCompression(input));
    }
}
