package com.company2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.io.File;
import java.util.*;
public class KosarajuConnected {
    
    private static HashMap<Integer, Integer> mapLeader = new HashMap<>();
    private HashSet<Node> explored = new HashSet<>();
   // private int ttf = 0;
    //private int[] nodes = new int[875714];
    //private ArrayList<Node> nodes = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    private int[] componentCount = new int[1000000];

    public void init(HashSet<Node> nodes, boolean reverseTraverse){

       // System.out.println(explored.size());
        if(reverseTraverse){
            for(Node node: nodes){
                if(!explored.contains(node)){
                    dfs(node, node, true);
                }
            }
        }
        else{
           // System.out.println();
            while(!stack.empty()){
                Node n = stack.pop();
                if(!explored.contains(n)){
                    dfs(n, n, false);
                }
            }
        }

    }

    public void dfs(Node n, Node leader, boolean reverseTraverse){

        explored.add(n);

        if(!reverseTraverse){
            //componentCount[leader.getVal()] = componentCount[leader.getVal()] + 1;
            mapLeader.put(n.getVal(), leader.getVal());
            //System.out.println("n " + n.getVal() + " leader " + leader.getVal() + "........");
        }
        else{
           // System.out.println("n " + n.getVal() + " leader " + leader.getVal());
        }

        HashSet<Node> neighbors = reverseTraverse ? n.getIn() : n.getOut();

        //System.out.println("n " + n.getVal() + " neighbors size " + neighbors.size());

        for(Node neighbor: neighbors){
           // System.out.println("exploring neighbor " + neighbor.getVal() + " leader " + leader.getVal());
            if( !explored.contains(neighbor) ){
                dfs((Node) neighbor, leader, reverseTraverse);
            }
        }
        /*
        for(int i=0; i < neighbors.size(); i++){
            if( !explored.contains(neighbors.get(i)) ){
                dfs((Node) neighbors.get(i), leader, reverseTraverse);
            }
        }
        */
        if(reverseTraverse){
            //System.out.println("pushing " + n.getVal());
            stack.push(n);
            //System.out.println("in " + stack.peek().getVal());
        }     
    }
    public void createComponents(HashSet<Node> nodes){

        init(nodes, true);
        explored.clear();
        init(nodes, false);   
    }

    public ArrayList<Integer> getComponents(HashSet<Node> nodes){

        Arrays.sort(componentCount);
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = componentCount.length-1; i >= componentCount.length-5; i--){

            if(componentCount[i] == 0)  break;

            res.add(componentCount[i]);
        }
        return res;
    }

    public static boolean twoSAT(HashMap<Integer, Node> map){

        for (Integer key : map.keySet()) {
            int notKey = -key;

            if(mapLeader.get(key).equals(mapLeader.get(notKey))){
                return false;
            }    
        }
        return true;
    }
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(new File("test/data/2SAT_6.txt"));
            Scanner s2;
            HashSet<Node> nodes = new HashSet<>();
            HashMap<Integer, Node> map = new HashMap<>();

            //int i=0;
            //int max = 500000;
            int n = s.nextInt();

            while(s.hasNextLine()){
                String line = s.nextLine();
                s2 = new Scanner(line);

                while(s2.hasNext()){
                    int a = s2.nextInt();
                    int b = s2.nextInt();

                    
                    int notA = -a;
                    int notB = -b;

                    Node x;
                    Node y;

                    Node x2;
                    Node y2;

                    if(!map.containsKey(a)){
                        x = new Node(a);
                    }
                    else  x = map.get(a);

                    if(!map.containsKey(b)){
                        y = new Node(b);
                    }
                    else  y = map.get(b);
                    
                    if(!map.containsKey(notA)){
                        x2 = new Node(notA);
                    }
                    else  x2 = map.get(notA);

                    if(!map.containsKey(notB)){
                        y2 = new Node(notB);
                    }
                    else  y2 = map.get(notB);

                    //System.out.println("x " + x.getVal() + " y " + y.getVal() + " x2 " + x2.getVal() + " y2 " + y2.getVal());

                    x2.addOut(y);
                    y.addIn(x2);

                    y2.addOut(x);
                    x.addIn(y2);
/*
                    for(Node t: x.getOut()){
                        System.out.println(x.getVal() + " " + t.getVal());
                    }
                    for(Node t: x2.getOut()){
                        System.out.println(x2.getVal() + " " + t.getVal());
                    }
                    for(Node t: y.getOut()){
                        System.out.println(y.getVal() + " " + t.getVal());
                    }
                    for(Node t: y2.getOut()){
                        System.out.println(y2.getVal() + " " + t.getVal());
                    } */
                    map.put(a, x);
                    map.put(notA, x2);
                    map.put(b, y);
                    map.put(notB, y2);

                    nodes.remove(x);
                    nodes.remove(x2);
                    nodes.remove(y);
                    nodes.remove(y2);

                    nodes.add(x);
                    nodes.add(x2);
                    nodes.add(y);
                    nodes.add(y2);

                }     
            }
/*
            for(Node node: nodes){
                System.out.println("node " + node.getVal());
                for(Node neighbor: node.getOut()){
                    System.out.println("neighbor " + neighbor.getVal());
                }
                System.out.println();
            }
            
            while(s.hasNextInt()){
               // i++;
                int a = s.nextInt();
                int b = s.nextInt();

                Node x;
                Node y;
                if(!map.containsKey(a)){
                    x = new Node(a);
                    map.put(a, x);
                }
                else  x = map.get(a);

                if(!map.containsKey(b)){
                    y = new Node(b);
                    map.put(b, y);
                }
                else  y = map.get(b);
                            
                nodes.add(x);
                nodes.add(y);
                x.addOut(y);
                y.addIn(x);
            }
            */


            KosarajuConnected k = new KosarajuConnected();
            k.createComponents(nodes);
            //k.getComponents(nodes);
            System.out.println(twoSAT(map));
            //System.out.println(Arrays.toString(k.getComponents(nodes).toArray()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

