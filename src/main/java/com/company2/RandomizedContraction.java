package com.company2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;


public class RandomizedContraction {
   
    /***
     * Create a map of node to adjacency list and a set/list of edges
     * while atleast two keys left in map, pick a random edge to contract from the set.
     * To contract:
     * 1. Remove that edge (u,v)from the set. 
     * 2. Redirect all edges coming to v from v to u (Iterate of map[v]) (except for u,v)
     * 3. Remove v from the map 
     * 
     * Run above n^2 times, where n is the size of map.
     * @return
     */
    public static int minCut(HashMap<String, HashMap<String, Integer>> map, ArrayList<String> nodes){

        while(nodes.size() > 2){
            int index = new Random().nextInt(nodes.size());
            String random = nodes.get(index);
            nodes.remove(index);
          //  System.out.println("random "+ random);
            if(map.containsKey(random)){
                HashMap<String, Integer> adjacencyMap = map.get(random);

                String adjacentNode = "-1" ;
                for ( String key : adjacencyMap.keySet() ) {
                    adjacentNode = key;
                    break;
                }
               // System.out.println("adjacentNode " + adjacentNode);

                if(map.containsKey(adjacentNode)){
                    HashMap<String, Integer> adjacentNodeMap  = map.get(adjacentNode);
                    
                    Iterator it = adjacencyMap.entrySet().iterator();
                    while(it.hasNext()){
                        Map.Entry pair = (Map.Entry) it.next();
                        String key = (String) pair.getKey();
                        Integer value = (Integer) pair.getValue();

                        if(key != adjacentNode){
                            if(adjacentNodeMap.containsKey(key)){
                                adjacentNodeMap.put(key, adjacentNodeMap.get(key) + value); 
                            }
                            else{
                                adjacentNodeMap.put(key, value);
                            }
                            if(map.containsKey(key)){
                                HashMap<String, Integer> neighborMap = map.get(key);
                                neighborMap.remove(random);
                                if(neighborMap.containsKey(adjacentNode)){
                                    neighborMap.put(adjacentNode, neighborMap.get(adjacentNode) + value);
                                }
                                else{
                                    neighborMap.put(adjacentNode, value);
                                }
                                map.put(key, neighborMap);
                            }
                        }
                    }
                    adjacentNodeMap.remove(random);
                    map.put(adjacentNode, adjacentNodeMap);
                    map.remove(random); 
                }
                //System.out.println();
                /***
                 * Remove after debugging
                 
                for (Map.Entry<String,HashMap<String,Integer>> entry : map.entrySet()){ 
                    System.out.println("node = " + entry.getKey());
                    for(Map.Entry<String,Integer> value : entry.getValue().entrySet()){
                        System.out.println("neighbhor = " + value.getKey() + " value = " + value.getValue());
                    }
                }
                
                System.out.println();
                */
            }
        }
        if(map.containsKey(nodes.get(0))){   
            return map.get(nodes.get(0)).get(nodes.get(1));
        }
        return -1;
    }
}
