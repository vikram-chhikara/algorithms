package main.java.com.company2;
import java.util.*;

public class NodeMST {
    private int val;
    private HashMap<NodeMST, Integer> neighbors; 
    private int key;

    public NodeMST(int value){
        neighbors = new HashMap<NodeMST, Integer>();
        val = value;
        // explored = false;
    }

    public int getVal(){
        return val;
    }

    public HashMap<NodeMST, Integer> getNeighbors(){
        return neighbors;
    }

    public void addNeighbor(NodeMST n, int cost){
        neighbors.put(n, cost);
    }

    public int getKey(){
        return key;
    }

    public void setKey(int k){
        key = k;
    }
}
