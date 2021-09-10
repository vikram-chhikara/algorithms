package com.company2;

import java.math.BigInteger;

public class Karatsuba {
    
    public BigInteger appendZeros(BigInteger a, int count){

        String s = ""+a;

        for(int i=0;i<count;i++){
            s = "0" + s;
        }

        return new BigInteger(s);
    } 
    public BigInteger multiply(BigInteger x, BigInteger y){
        
        int n = (""+x).length();

        if(n == 1){
            return x.multiply(y);
        }

        BigInteger a = new BigInteger((""+x).substring(0,n/2));
        BigInteger b = new BigInteger((""+x).substring(n/2,n));

        int delta = (""+a).length() - (""+b).length();
        if(delta > 0){
            b = appendZeros(b, delta);
        }
        else if(delta < 0){
            a = appendZeros(a, delta);
        }
        
        System.out.println("a "+a);
        System.out.println("b "+b);

        BigInteger c = new BigInteger((""+y).substring(0,n/2));
        BigInteger d = new BigInteger((""+y).substring(n/2,n));

        delta = (""+c).length() - (""+d).length();
        if(delta > 0){
            d = appendZeros(d, delta);
        }
        else if(delta < 0){
            c = appendZeros(c, delta);
        }

        BigInteger ac = multiply(a, c);
        BigInteger ad = multiply(a, d);
        BigInteger bc = multiply(b, c);
        BigInteger bd = multiply(b, d);

        BigInteger first = ac.multiply(BigInteger.valueOf((long) Math.pow(10, n)));
        BigInteger second = (ad.add(bc)).multiply(BigInteger.valueOf((long) Math.pow(10, n/2)));

        return (first.add(second)).add(bd);
    }
    
}
