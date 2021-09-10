package main.java.com.company2;
import java.math.BigInteger;
import java.util.*;

public class NodeHuff {
    
    //private BigInteger val;
    private BigInteger weight;
    private NodeHuff left;
    private NodeHuff right;

    public NodeHuff(BigInteger w){
        //val = v;
        weight = w;
        left = null;
        right = null;
    }

    public BigInteger getVal(){
        return val;
    }

    public BigInteger getWeight(){
        return weight;
    }

    public NodeHuff getLeft(){
        return left;
    }

    public void addLeft(NodeHuff l){
        left = l;
    }

    public NodeHuff getRight(){
        return right;
    }

    public void addRight(NodeHuff r){
        right = r;
    }
}
