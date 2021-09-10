package com.company2;

import java.util.*;
import java.util.logging.Logger;

import main.java.com.company2.OutEdge;

import java.io.File;

public class ShortestPath {
    
    private static HashSet<NodeW> explored = new HashSet<>();

    /**
     * Extract min w from heap until heap is empty
     * Loop over w outgoing edges v that are unexplored:
     *   Remove v from heap
     *   update its key
     *   insert back into the heap
     * 
     * return required node's key (key is shortest distance)
    */
    public static int getPath(PriorityQueue<NodeW> minHeap, HashMap<Integer, NodeW> mapOriginal, NodeW source){

        explored.clear();
        
        //int[] result = new int[10];
        int result = Integer.MAX_VALUE;

        HashMap<Integer, NodeW> map = mapOriginal;

        while(!minHeap.isEmpty()){
            NodeW w;
            w = minHeap.poll();             //remove min from heap
            //System.out.println("->>>>>>>>>>>>>> Retrieved " + w.getVal());
            explored.add(w);

            ArrayList<OutEdge> outList = w.getOutEdge();
            //System.out.println("outList size " + outList.size());
            for(OutEdge outEdge : outList){
                NodeW v = outEdge.getNode();
                int cost = outEdge.getCost();
                if(!explored.contains(v)){
                    minHeap.remove(v);
                    int newKey = Math.min(v.getKey(), w.getKey()+cost);
                    //System.out.println("candiate " + v.getVal() + "  cost " + (newKey - source.getWeight() + v.getWeight()));
                    result = Math.min(result, newKey - source.getWeight() + v.getWeight());
                    //System.out.println("result " + result);
                    v.setKey(newKey);
                    //System.out.println(v.getVal() + " new key " + newKey);
                    minHeap.add(v);                    
                }
                //System.out.println();
            }
            /*
            HashMap<NodeW, Integer> wOut = w.getOut();
            for (Map.Entry<NodeW,Integer> entry : wOut.entrySet()){
                NodeW v = entry.getKey();
                if(!explored.contains(v)){
                    minHeap.remove(v);
                    int newKey = Math.min(v.getKey(), w.getKey()+entry.getValue());
                    //System.out.println("candiate " + (newKey - w.getWeight() + v.getWeight()));
                    result = Math.min(result, newKey - w.getWeight() + v.getWeight());
                    v.setKey(newKey);
                    minHeap.add(v);                    
                }
            }
            */
        }
        //System.out.println("-----------------------------------------");

        /*
        for(int i = 0; i < destination.length; i++){
            if(map.containsKey(destination[i])){
                result[i] = map.get(destination[i]).getKey();
            }
        }
        return result;
        */
        return result;
    }
/*
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(new File("first-project/src/test/data/ShortestPath.txt"));
            Scanner s2;
            HashMap<Integer, NodeW> map = new HashMap<>();

            Comparator<NodeW> comparator = new Comparator<NodeW>(){
                @Override
                public int compare(NodeW n1, NodeW n2){
                    if(n1.getKey() > n2.getKey())  return 1;
                    else if(n1.getKey() < n2.getKey())  return -1;
                    else return 0;
                }
            };
            PriorityQueue<NodeW> minHeap = new PriorityQueue<>(comparator);
            int MAX_VALUE = 1000000;

            while(s.hasNextLine()){
                String line = s.nextLine();
                s2 = new Scanner(line);
                int nVal = s2.nextInt();
                
                NodeW n;
                if(!map.containsKey(nVal)){
                    n = new NodeW(nVal);
                    n.setKey(n.getVal() == 1 ? 0 : MAX_VALUE);
                }
                else  n = map.get(nVal);

                while(s2.hasNext()){
                    String[] edge = s2.next().split(",");  
                    int neighborVal = Integer.parseInt(edge[0]);    // GET NODE VAL
                    int distance = Integer.parseInt(edge[1]);       // GET DISTANCE FROM n
                    NodeW neighbor;
                    if(!map.containsKey(neighborVal)){
                        neighbor = new NodeW(neighborVal);
                        neighbor.setKey(MAX_VALUE);           
                    }
                    else  neighbor = map.get(neighborVal);
                    n.addOut(neighbor, distance);
                    neighbor.addIn(n, distance);
                    map.put(nVal, n);
                    map.put(neighborVal, neighbor);
                    
                }
            }
            for(NodeW n: map.values()){
                minHeap.add(n);
            }
            System.out.println(Arrays.toString(ShortestPath.getPath(minHeap, map, new int[]{7,37,59,82,99,115,133,165,188,197})));
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
*/
}
