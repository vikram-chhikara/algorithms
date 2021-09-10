package main.java.com.company2;

import java.util.*;
import main.java.com.company2.Node;
import com.company2.Node;
import com.company2.NodeW;
import com.company2.ShortestPath;
import java.io.*;
import java.io.File;
import java.lang.reflect.Array;
import java.math.BigInteger;

public class APSP {
    
    public static Comparator<NodeW> comparator = new Comparator<NodeW>(){
        @Override
        public int compare(NodeW n1, NodeW n2){
            if(n1.getKey() > n2.getKey())  return 1;
            else if(n1.getKey() < n2.getKey())  return -1;
            else return 0;
        }
    };
    public static PriorityQueue<NodeW> minHeap = new PriorityQueue<>(comparator);

    public static HashMap<Integer, NodeW> initializeMap(HashMap<Integer, NodeW> map, int source, int N){
        int MAX_VALUE = 1000000;

        HashMap<Integer, NodeW> mapNew = new HashMap<>();

        for(int i = 1; i < N; i++){  
            if(map.containsKey(i)){
                NodeW nodeW = map.get(i);
                if(i == source)  nodeW.setKey(0);
                else  nodeW.setKey(MAX_VALUE);
                mapNew.put(i, nodeW);
                minHeap.add(nodeW);
            }
        }
        
        return mapNew;
    }
    public static void main(String[] args){
        try{
            
            Scanner s = new Scanner(new File("test/data/APSP_3.txt"));
            Scanner s2;

            HashMap<Integer, NodeW> map = new HashMap<>();
            //ArrayList<Edge> edges = new ArrayList<>();

            int nodeCount = s.nextInt();
            int edgeCount = s.nextInt();

            int N = nodeCount + 1;

            int MAX_VALUE = 1000000;

            while(s.hasNextLine()){
                String line = s.nextLine();
                s2 = new Scanner(line);

                while(s2.hasNext()){
                    int n1Val = s2.nextInt();
                    int n2Val = s2.nextInt();
                    int cost = s2.nextInt();

                    NodeW n1;
                    if(!map.containsKey(n1Val)){
                        n1 = new NodeW(n1Val);
                        n1.setKey(MAX_VALUE);  
                    }
                    else  n1 = map.get(n1Val);

                    NodeW n2;
                    if(!map.containsKey(n2Val)){
                        n2 = new NodeW(n2Val);
                        n2.setKey(MAX_VALUE);  
                    }
                    else  n2 = map.get(n2Val);

                    //n1.addOut(n2, cost);
                    //n1.addOutEdge(n2, cost);
                    OutEdge outEdge = new OutEdge(n2, cost);
                    n1.addOutEdge(outEdge);
                    //n2.addIn(n1, cost);
                    //n2.addInEdge(n1, cost);
                    InEdge inEdge = new InEdge(n1, cost);
                    n2.addInEdge(inEdge);

                    map.put(n1Val, n1);
                    map.put(n2Val, n2);

                    //Edge edge = new Edge(n1, n2, cost);
                    //edges.add(edge);


                }
            }
            /////////////////////////////        STEP 1       /////////////////////////////////////
            // G -> G'
            int zVal = N;
            NodeW z = new NodeW(zVal);   
            for(int i = 1; i <= 1000; i++){
                if(map.containsKey(i)){
                    NodeW n = map.get(i);
                    int nVal = n.getVal();
                    //z.addOut(n, 0);
                    //z.addOutEdge(n, 0);
                    OutEdge outEdge = new OutEdge(n, 0);
                    z.addOutEdge(outEdge);
                    //n.addIn(z, 0);
                    //n.addInEdge(z, 0);
                    InEdge inEdge = new InEdge(z, 0);
                    n.addInEdge(inEdge);
                    map.put(zVal, z);
                    map.put(nVal, n);
                    //edges.add(new Edge(z, n, 0));
                }
            }
            
            /////////////////////////////        STEP 2       /////////////////////////////////////

            int[][] arr = BellmanFord.shortestPath(z, map, N);
            
            /////////////// TESTING ///////////////
            /*
            for(int v=1; v < N; v++){
                System.out.println(arr[N-1][v]);
            }
            */

            ///////////////  /////////////////////

            if(BellmanFord.negativeCycle == false){
                int result = Integer.MAX_VALUE;
                 /////////////////////////////     STEP 3       /////////////////////////////////////
                for(int i = 1; i < N; i++){
                    if(map.containsKey(i)){
                        NodeW n = map.get(i);
                        n.setWeight(arr[N-1][i]);
                        map.put(i, n);
                    }
                }
                map.remove(N);
                HashMap<Integer, NodeW> mapNew = new HashMap<>();

                for (Map.Entry<Integer, NodeW> entry : map.entrySet()) {
                    int nVal = entry.getKey();
                    NodeW n = entry.getValue();
                    int w = n.getWeight();

                    if(map.containsKey(nVal)){

                        ArrayList<OutEdge> outList = map.get(nVal).getOutEdge();
                        ArrayList<OutEdge> outListNew = new ArrayList<>();
                        for(OutEdge outEdge : outList){
                            NodeW neighbor = outEdge.getNode();
                            int cost = outEdge.getCost();
                            int weightNeighbor = neighbor.getWeight();
                            cost = cost + w - weightNeighbor;
                            outListNew.add(new OutEdge(neighbor, cost));
                        }
                        n.setOutEdge(outListNew);
                        mapNew.put(nVal, n);
                        /*
                        HashMap<NodeW, Integer> outMap = map.get(nVal).getOut();                   //update cost of outgoing edge of n
                        HashMap<NodeW, Integer> outMapNew = new HashMap<>(); 
                        for(Map.Entry<NodeW, Integer> item : outMap.entrySet()) {
                            NodeW neighbor = item.getKey();
                            int cost = item.getValue();
                            int neighborVal = neighbor.getVal();
                            int weightNeighbor = neighbor.getWeight();
                            cost = cost + w - weightNeighbor;

                            outMapNew.put(neighbor, cost);
                        }
                        n.setOut(outMapNew);
                        mapNew.put(nVal, n);
                        */
                    }
                }
                /////////////// TESTING ///////////////
                /*
                System.out.println("mapNew.size" + mapNew.size());
                for (NodeW nodeW : mapNew.values()) {
                    int v = nodeW.getVal();

                    for(OutEdge outEdge : nodeW.getOutEdge()){
                        NodeW key = outEdge.getNode();
                        Integer value = outEdge.getCost();
                        System.out.println("n " + v + " neighbor " + key.getVal() + " cost " + value);

                    }
                }
                */
                ////////////////////////////////////////

                /////////////////////////////     STEP 4       /////////////////////////////////////
                
                
                for(int i = 1; i < N; i++){
                    minHeap.clear();
                    HashMap<Integer, NodeW> mapFinal = APSP.initializeMap(mapNew, i, N);
                    
                    result = Math.min(result, ShortestPath.getPath(minHeap, mapFinal, mapFinal.get(i)));

                    ////////////////////    TESTING     ////////////////////
                    /*
                    for (NodeW nodeW : mapNew.values()) {
                        System.out.println(nodeW.getVal() + " " + nodeW.getKey());
                    }
                    */
                    /////////////////////               ///////////////////
                }
                
                System.out.println(result);
            }
            else{
                System.out.println("Negative Cycle Detected");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
