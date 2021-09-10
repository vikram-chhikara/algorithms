package com.company2;

import java.util.*;

public class Node {
    
    private int val;
    private HashSet<Node> out;
    private HashSet<Node> in;
    private Node leader;
   // public boolean explored;

    public Node(int value){
        out = new HashSet<>();
        in = new HashSet<>();
        val = value;
        leader = null;
       // explored = false;
    }

    public HashSet<Node> getIn(){
        return in;
    }

    public void addIn(Node n){
        in.add(n);
    }

    public HashSet<Node> getOut(){
        return out;
    }

    public void addOut(Node n){
        out.add(n);
    }

    public int getVal(){
        return val;
    }

    public void setLeader(Node l){
        leader = l;
    }
    public Leader getLeader(){
        return leader;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash * val;
        return hash;
    }

    @Override
    public boolean equals(Object obj){

        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Node n = (Node) obj;
        return val == n.getVal();
    }
}
