package main.java.com.company2;

import java.util.*;

import com.company2.NodeW;

import java.io.File;
import java.math.BigInteger;

public class BellmanFord {
    
    public static boolean negativeCycle = false;

    public static int[][] shortestPath(NodeW s, HashMap<Integer, NodeW> map, int N){

        int[][] arr = new int[N+1][N+1];

        int sVal = s.getVal();
        arr[0][sVal] = 0;
        
        for(int i = 1; i <= N-1; i++){
            arr[0][i] = 1000000;
        }

        for(int i = 1; i <= N-1; i++){
            for(int v = 1; v <= N; v++){
                if(map.containsKey(v)){
                    //HashMap<NodeW, Integer> inMap = map.get(v).getIn();
                    ArrayList<InEdge> inList = map.get(v).getInEdge();
                    int minIn = Integer.MAX_VALUE;
                    NodeW minN;
                    //System.out.println("vertex " + v);

                    for(InEdge inEdge : inList){
                        NodeW w = inEdge.getNode();
                        int cost = inEdge.getCost();
                        //System.out.println("incoming from " + w.getVal() + " with cost " + cost);
                        minIn = Math.min(minIn, arr[i-1][w.getVal()] + cost);
                        //System.out.println("minIn " + minIn);
                        //System.out.println();
                    }
                    /*
                    for(Map.Entry<NodeW, Integer> entry : inMap.entrySet()) {
                        NodeW w = entry.getKey();
                        int cost = entry.getValue();
                        System.out.println("incoming from " + w.getVal() + " with cost " + cost);
                        minIn = Math.min(minIn, arr[i-1][w.getVal()] + cost);
                        System.out.println("minIn " + minIn);
                        System.out.println();
                    }
                    */
                    arr[i][v] = Math.min(arr[i-1][v], minIn);
                }
            }
        }

        //check of negative cycle
        for(int v = 1; v <= N-1; v++){
            if(map.containsKey(v)){

                ArrayList<InEdge> inList = map.get(v).getInEdge();
                int minIn = Integer.MAX_VALUE;
                NodeW minN;
                for(InEdge inEdge : inList){
                    NodeW n = inEdge.getNode();
                    int cost = inEdge.getCost();
                    minIn = Math.min(minIn, arr[N-1][n.getVal()] + cost);
                }
                arr[N][v] = Math.min(arr[N-1][v], minIn);
                if(arr[N][v] != arr[N-1][v]){
                    negativeCycle = true;
                    break;
                }
                /*
                HashMap<NodeW, Integer> inMap = map.get(v).getIn();
                int minIn = Integer.MAX_VALUE;
                NodeW minN;
                for(Map.Entry<NodeW, Integer> entry : inMap.entrySet()) {
                    NodeW n = entry.getKey();
                    int cost = entry.getValue();
                    
                    minIn = Math.min(minIn, arr[N-1][n.getVal()] + cost);
                }
                arr[N][v] = Math.min(arr[N-1][v], minIn);
                if(arr[N][v] != arr[N-1][v]){
                    negativeCycle = true;
                    break;
                }
                */
            }
        }

        /////////////// TESTING ///////////////
        /*for(int v = 1; v <= N-1; v++){
            System.out.println(arr[N-1][v]);
        }
        */
        ////////////////////////////////////////
        return arr;
    }
}
