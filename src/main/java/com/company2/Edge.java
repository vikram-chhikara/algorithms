package main.java.com.company2;

import java.util.*;

public class Edge {

    private NodeC node1;
    private NodeC node2;
    private int cost;

    public Edge(NodeC n1, NodeC n2, int c){
        node1 = n1;
        node2 = n2;
        cost = c;
    }

    public int getCost(){
        return cost;
    }

    public NodeC getNode1(){
        return node1;
    }

    public NodeC getNode2(){
        return node2;
    }
}
    

