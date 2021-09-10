package main.java.com.company2;
import java.util.*;
import java.io.File;

public class MST {
    
    private static HashSet<NodeMST> explored = new HashSet<>();

    public static int getCostMST(PriorityQueue<NodeMST> minHeap){

        int cost = 0;

        while(!minHeap.isEmpty()){
            NodeMST w;
            w = minHeap.poll();             //remove min from heap
           //System.out.println("node " + w.getVal() + " key " + w.getKey());
            cost += w.getKey();
            //System.out.println("cost " + cost);
            explored.add(w);
            HashMap<NodeMST, Integer> neighbors = w.getNeighbors();

            for (Map.Entry<NodeMST,Integer> entry : neighbors.entrySet()){
                NodeMST v = entry.getKey();
                if(!explored.contains(v)){
                    //System.out.println("v " + v.getVal() + " key " + v.getKey());
                    minHeap.remove(v);
                    v.setKey(Math.min(v.getKey(), entry.getValue()));
                    //System.out.println("v " + v.getVal() + " key " + v.getKey());
                    minHeap.add(v);
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(new File("test/data/MST.txt"));
            Scanner s2;
            HashMap<Integer, NodeMST> map = new HashMap<>();

            Comparator<NodeMST> comparator = new Comparator<NodeMST>(){
                @Override
                public int compare( NodeMST n1, NodeMST n2){
                    if(n1.getKey() > n2.getKey())  return 1;
                    else if(n1.getKey() < n2.getKey())  return -1;
                    else return 0;
                }
            };
            PriorityQueue<NodeMST> minHeap = new PriorityQueue<>(comparator);
            int MAX_VALUE = 1000000;

            int nodesCount = s.nextInt();
            int edgesCount = s.nextInt();

            while(s.hasNextLine()){
                String line = s.nextLine();
                s2 = new Scanner(line);

                while(s2.hasNext()){
                    int n1Val = s2.nextInt();
                    int n2Val = s2.nextInt();
                    int cost = s2.nextInt();

                    NodeMST n1;
                    NodeMST n2;

                    if(!map.containsKey(n1Val)){
                        n1 = new NodeMST(n1Val);
                        n1.setKey(n1.getVal() == 1 ? 0 : MAX_VALUE);           
                    }
                    else  n1 = map.get(n1Val);

                    if(!map.containsKey(n2Val)){
                        n2 = new NodeMST(n2Val);
                        n2.setKey(n2.getVal() == 1 ? 0 : MAX_VALUE);                  
                    }
                    else  n2 = map.get(n2Val);

                    n1.addNeighbor(n2, cost);
                    n2.addNeighbor(n1, cost);
                    map.put(n1Val, n1);
                    map.put(n2Val, n2);
                }
            }
            for(NodeMST n: map.values()){
                minHeap.add(n);
            }
            /*
            for (Map.Entry<Integer, NodeMST> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                

            }
            */
            System.out.println(MST.getCostMST(minHeap));
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
