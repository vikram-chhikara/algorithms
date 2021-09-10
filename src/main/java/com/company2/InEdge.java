package main.java.com.company2;
import java.util.*;
import com.company2.NodeW;
public class InEdge {
    private NodeW node;
    private int cost;

    public InEdge(NodeW n, int c){
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
