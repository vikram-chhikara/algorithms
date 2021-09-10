package com.company2;
import java.util.*;

import main.java.com.company2.InEdge;
import main.java.com.company2.OutEdge;

public class NodeW {
    
    private int val;
    private HashMap<NodeW, Integer> out;
    private HashMap<NodeW, Integer> in;
    private ArrayList<InEdge> inEdge;
    private ArrayList<OutEdge> outEdge;
    private int key;
    private int weight;
    // public boolean explored;

    public NodeW(int value){
        out = new HashMap<NodeW, Integer>();
        in = new HashMap<NodeW, Integer>();

        outEdge = new ArrayList<OutEdge>();
        inEdge = new ArrayList<InEdge>();
        val = value;
        // explored = false;
    }

    public HashMap<NodeW, Integer> getIn(){
        return in;
    }

    public ArrayList<InEdge> getInEdge(){
        return inEdge;
    }

    public void addIn(NodeW n, int distance){
       in.put(n, distance);
    }

    /*
    public void addInEdge(NodeW n, int distance){
        inEdge.add(new InEdge(n, distance));
    }
    */
    public void addInEdge(InEdge inE){
        inEdge.add(inE);
    }

    public HashMap<NodeW, Integer> getOut(){
        return out;
    }

    public ArrayList<OutEdge> getOutEdge(){
        return outEdge;
    }

    public void setIn(HashMap<NodeW, Integer> inMap){
        in = inMap;
    }

    public void setInEdge(ArrayList<InEdge> inList){
        inEdge = inList;
    }

    public void setOut(HashMap<NodeW, Integer> outMap){
        out = outMap;
    }

    public void setOutEdge(ArrayList<OutEdge> outList){
        outEdge = outList;
    }

    public void addOut(NodeW n, int distance){
       out.put(n, distance);
    }
    /*
    public void addOutEdge(NodeW n, int distance){
        outEdge.add(new OutEdge(n, distance));
    }
    */
    public void addOutEdge(OutEdge outE){
        outEdge.add(outE);
    }


    public int getVal(){
        return val;
    }

    public int getKey(){
        return key;
    }

    public void setKey(int k){
        key = k;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int w){
        weight = w;
    }
    
}
    

