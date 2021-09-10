package main.java.com.company2;
import java.util.*;

import javax.crypto.Mac;

import java.io.File;

public class Cluster {

    public static int getMaxSpacing(PriorityQueue<Edge> minHeap, int k, HashMap<Integer, NodeC> nodes, HashMap<NodeC, HashSet<NodeC>> map){

        //System.out.println("initial map size " + map.size());

        int maxSpacing = -1;
        while(map.size() > k){
            Edge edge = minHeap.poll();
            maxSpacing = edge.getCost();
            NodeC n1 = edge.getNode1();
            NodeC n2 = edge.getNode2();

            NodeC n1Leader = n1.getLeader();
            NodeC n2Leader = n2.getLeader();

            //System.out.println("n1 " + n1.getVal() + " leader " + n1Leader.getVal());
            //System.out.println("n2 " + n2.getVal() + " leader " + n2Leader.getVal());
            //System.out.println();

            if(n1Leader != n2Leader){
                for(NodeC node : map.get(n2Leader)){
                    //System.out.println("before");
                    //System.out.println("node " + node.getVal());
                    node.setLeader(n1Leader);
                    HashSet<NodeC> set = map.get(n1Leader);     
                    set.add(node);
                    map.put(n1Leader, set);
                    //System.out.println("after");
                    map.remove(node);
                    //System.out.println("map size " + map.size());
                }
            }
        }
        if(minHeap.isEmpty()){
            return maxSpacing;
        }
        Edge e = minHeap.poll();
        while(e.getNode1().getLeader() == e.getNode2().getLeader()){
            e = minHeap.poll();
        }
        return e.getCost();
    }

    public static int getLargestK(PriorityQueue<Edge> minHeap, HashMap<NodeC, HashSet<NodeC>> map, HashMap<Integer, NodeC> nodes, int arrLen){

        int initialMapSize = map.size();

        while(!minHeap.isEmpty()){
            Edge edge = minHeap.poll();
            NodeC n1 = edge.getNode1();
            NodeC n2 = edge.getNode2();

            NodeC n1Leader = n1.getLeader();
            NodeC n2Leader = n2.getLeader();

            if(n1Leader != n2Leader){
                for(NodeC node : map.get(n2Leader)){
                    //System.out.println("before");
                    //System.out.println("node " + node.getVal());
                    node.setLeader(n1Leader);
                    HashSet<NodeC> set = map.get(n1Leader);     
                    set.add(node);
                    map.put(n1Leader, set);
                    //System.out.println("after");
                    map.remove(node);
                    //System.out.println("map size " + map.size());
                }
            }
        }
        return map.size() + (arrLen - initialMapSize);
    }
    public static void main(String[] args){
        
        try{
            Scanner s = new Scanner(new File("test/data/ClusteringC.txt"));
            Scanner s2;

            int nodeCount = s.nextInt();
            int bitCount = s.nextInt();

            List<List<Integer>> arr = new ArrayList<List<Integer>>();  

            /*
            int[][] arr = new int[nodeCount+1][bitCount];
            int row = 0;
            int col = 0;
        */
            Comparator<Edge> comparator = new Comparator<Edge>(){
                
                @Override
                public int compare(Edge e1, Edge e2){
                    if(e1.getCost() > e2.getCost())  return 1;
                    else if(e1.getCost() < e2.getCost())  return -1;
                    else return 0;
                }
            };

            PriorityQueue<Edge> minHeap = new PriorityQueue<>(comparator);

            HashMap<Integer, NodeC> nodes = new HashMap<>();
            HashMap<NodeC, HashSet<NodeC>> map = new HashMap<>();

            while(s.hasNextLine()){
                String line = s.nextLine();
                s2 = new Scanner(line);
                List<Integer> list = new ArrayList<>();
                //col = 0;
                while(s2.hasNext()){
                    list.add(s2.nextInt());
                    //arr[row][col++] = s2.nextInt();
                }
                if(!list.isEmpty()){
                    arr.add(list);
                }
                //row++;
            }
            //arr = Arrays.copyOfRange(arr, 1, arr.length);
            for(int r = 0; r < arr.size() - 1; r++){
                List<Integer> a = arr.get(r);
                for(int k = r+1; k < arr.size(); k++){

                    int hamming = 0;
                    List<Integer> b = arr.get(k);
                    for(int i = 0; i < a.size(); i++){        // XOR check for hamming < 3
                        if(a.get(i) != b.get(i)){
                            hamming++;
                        }
                        if(hamming > 2){
                            break;
                        }
                    }
                    if(hamming < 3){
                        int n1Val = r+1;
                        int n2Val = k+1;
                        int cost = hamming;

                        NodeC n1;
                        NodeC n2;

                        if(!nodes.containsKey(n1Val)){
                            n1 = new NodeC(n1Val);
                            n1.setLeader(n1);
                            HashSet<NodeC> set1 = new HashSet<>();
                            set1.add(n1);
                            //System.out.println(" " + n1Val);
                            map.put(n1, set1);
                            nodes.put(n1Val, n1);
                        }
                        else  n1 = nodes.get(n1Val);

                        if(!nodes.containsKey(n2Val)){
                            n2 = new NodeC(n2Val);
                            n2.setLeader(n2);
                            HashSet<NodeC> set2 = new HashSet<>();
                            set2.add(n2);
                            //System.out.println(" " + n2Val);
                            map.put(n2, set2);
                            nodes.put(n2Val, n2);
                        }
                        else  n2 = nodes.get(n2Val);

                        Edge edge = new Edge(n1, n2, cost);
                        minHeap.add(edge);
                    }
                }
            } 
            /*while(!minHeap.isEmpty()){
                Edge edge = minHeap.poll();
                System.out.println(edge.getNode1().getVal() + " " + edge.getNode2().getVal());
            }  */        
            System.out.println(Cluster.getLargestK(minHeap, map, nodes, arr.size()));   
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
/*
    public static void main(String[] args) {

        try{
            Scanner s = new Scanner(new File("test/data/Cluster.txt"));
            Scanner s2;

            HashMap<NodeC, HashSet<NodeC>> map = new HashMap<>();
            HashMap<Integer, NodeC> nodes = new HashMap<>();

            int nodeCount = s.nextInt();

            Comparator<Edge> comparator = new Comparator<Edge>(){
                
                @Override
                public int compare(Edge e1, Edge e2){
                    if(e1.getCost() > e2.getCost())  return 1;
                    else if(e1.getCost() < e2.getCost())  return -1;
                    else return 0;
                }
            };

            PriorityQueue<Edge> minHeap = new PriorityQueue<>(comparator);

            while(s.hasNextLine()){
                String line = s.nextLine();
                s2 = new Scanner(line);

                while(s2.hasNext()){
                    int n1Val = s2.nextInt();
                    int n2Val = s2.nextInt();
                    int cost = s2.nextInt();

                    NodeC n1;
                    NodeC n2;

                    if(!nodes.containsKey(n1Val)){
                        n1 = new NodeC(n1Val);
                        n1.setLeader(n1);
                        HashSet<NodeC> set1 = new HashSet<>();
                        set1.add(n1);
                        map.put(n1, set1);
                        nodes.put(n1Val, n1);
                        //System.out.println("map size " + map.size());
                        
                    }
                    else  n1 = nodes.get(n1Val);

                    if(!nodes.containsKey(n2Val)){
                        n2 = new NodeC(n2Val);
                        n2.setLeader(n2);
                        HashSet<NodeC> set2 = new HashSet<>();
                        set2.add(n2);
                        map.put(n2, set2);
                        nodes.put(n2Val, n2);
                        //System.out.println("map size " + map.size());
                    }
                    
                    else  n2 = nodes.get(n2Val);

                    Edge edge = new Edge(n1, n2, cost);
                    minHeap.add(edge);
                }
            }
            System.out.println(Cluster.getMaxSpacing(minHeap, 4, nodes, map));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    */
}
