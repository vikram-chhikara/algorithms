package main.java.com.company2;

import java.util.concurrent.ThreadLocalRandom;


public class Random {
    
    static String[] list = new String[]{"astrology", "business", "job"};

    static String[] activity = new String[]{"read book"};

    static String[] time_and_date = new String[]{"week", "tomorrow", "today", "year", "mystery" };

    static String[] numbers = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    static String[] location = new String[]{"everywhere", "computer", "inside", "very very far away", "different dimension", "on the stars", "mystery"};

    static String[] yes_or_no = new String[]{"yes", "no"};

    static String[] good_or_bad = new String[]{"good", "bad"};

    static String[] identity = new String[]{"creator", "alien", "future", "past", "android", "mystery"};

    public static String getRandom(String[] list){
        int[] randomIntArr = new int[list.length];

        for(int i = 0; i < list.length; i++){
            randomIntArr[i] = ThreadLocalRandom.current().nextInt(0, list.length);
        }
        return list[randomIntArr[ThreadLocalRandom.current().nextInt(0, randomIntArr.length)]];


    }
    public static String where(){
        return getRandom(location);
    }

    public static String who(){
        return getRandom(identity);
    }

    public static String yes_or_no(){
        return getRandom(yes_or_no);
    }
    

    public static void main(String[] args) {
        
        System.out.println(yes_or_no());
    }
}
