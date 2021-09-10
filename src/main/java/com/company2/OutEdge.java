package main.java.com.company2;
import java.util.*;
import com.company2.NodeW;

public class OutEdge {
    private NodeW node;
    private int cost;

    public OutEdge(NodeW n, int c){
        node = n;
        cost = c;
    }

    public int getCost(){
        return cost;
    }

    public NodeW getNode(){
        return node;
    }
}
