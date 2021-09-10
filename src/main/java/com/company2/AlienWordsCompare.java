package com.company2;

import java.util.*;

public class AlienWordsCompare implements Comparator<Character>{

    private HashMap<Character, Integer> alienAlphabet = new HashMap<>();

    @Override
    public int compare(Character o1, Character o2) {
            
        if(alienAlphabet.containsKey(o1) && alienAlphabet.containsKey(o2)){
            return alienAlphabet.get(o1) - alienAlphabet.get(o2);
        }
        return 1;
    }
    
    public void uploadDictionary(String alphabetStr){

        for(int i=0; i < alphabetStr.length(); i++){
            alienAlphabet.put(alphabetStr.charAt(i), i);
        }
    }
    
}
