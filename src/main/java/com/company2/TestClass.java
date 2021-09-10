package com.company2;

import java.io.File;
import java.math.BigInteger;
import java.util.*;

public class TestClass {

public static int minCut = Integer.MAX_VALUE;

public static void print(String s){
    System.out.println(s);
}
public static void main(String[] args) {
    /*
        MergeSort sort = new MergeSort();
        int[] arr = new int[]{1,4,7,8,2,9,6,3,5};
        //System.out.println( Arrays.toString(sort.mergeSort(arr)) );
        BigInteger b = BigInteger.valueOf(12345);
        String aStr = (""+b).substring(0, 3);
        //System.out.println(aStr);
        Karatsuba k = new Karatsuba();
        String xStr = "3141592653589793238462643383279502884197169399375105820974944592";
        String yStr = "2718281828459045235360287471352662497757247093699959574966967627";
        BigInteger x = new BigInteger(xStr);
        BigInteger y = new BigInteger(yStr);
        //System.out.println(Karatsuba.multiply(x, y));
        //System.out.println(Karatsuba2.karatsuba(x, y));
        BigInteger t = new BigInteger("12");
        //System.out.println(t.shiftRight(2));

        try{
            Scanner s = new Scanner(new File("first-project/src/test/data/IntegerArray.txt"));
            int[] input = new int[100000];
            int i=0;
            while(s.hasNextInt()){
                input[i++] = s.nextInt();
            }
            s.close();
            //System.out.println(ArrayInversion.inversions(input));
        } catch (Exception e){
            e.printStackTrace();
        }

        AlienWordsCompare a = new AlienWordsCompare();
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("leetc");

        arr = new int[]{2, 20, 1, 15, 3, 11, 13, 6, 16, 10, 19, 5, 4, 9, 8, 14, 18, 17, 7, 12};
    */
        //System.out.println(QuickSort.sort(arr, 0, arr.length-1));
        //System.out.println(Arrays.toString(arr));
    /*
        try{
            Scanner s = new Scanner(new File("first-project/src/test/data/QuickSortIntegerArray.txt"));
            int max = 10000;
            int[] input = new int[max];
            int i=0;
            while(i < max && s.hasNextInt()){
                input[i++] = s.nextInt();
            }
            s.close();
            //System.out.println(ArrayInversion.inversions(input));
        
            //System.out.println();
            //System.out.println(Arrays.toString(input));
            //arr = new int[]{5, 4, 3};
            System.out.println(QuickSort.sort(input, 0, input.length-1));
            //System.out.println(Arrays.toString(input));
            //System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }
        */
    /*
        List<String> list = new ArrayList<String>();
        list.add("One");
        list.add("Two");
        String random = list.get(new Random().nextInt(list.size()));
        System.out.println(random);
    */
    /*
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        HashMap<String, Integer> adjacentMap1 = new HashMap<>();
        HashMap<String, Integer> adjacentMap2 = new HashMap<>();
        HashMap<String, Integer> adjacentMap3 = new HashMap<>();
        HashMap<String, Integer> adjacentMap4 = new HashMap<>();
        HashMap<String, Integer> adjacentMap5 = new HashMap<>();

        adjacentMap1.put("2", 1);
        adjacentMap1.put("3", 1);
        adjacentMap1.put("5", 1);

        adjacentMap2.put("1", 1);
        adjacentMap2.put("3", 1);
        adjacentMap2.put("4", 1);

        adjacentMap3.put("1", 1);
        adjacentMap3.put("2", 1);
        adjacentMap3.put("4", 1);

        adjacentMap4.put("2", 1);
        adjacentMap4.put("3", 1);
        adjacentMap4.put("5", 1);

        adjacentMap5.put("4", 1);
        adjacentMap5.put("1", 1);

        map.put("1", adjacentMap1);
        map.put("2", adjacentMap2);
        map.put("3", adjacentMap3);
        map.put("4", adjacentMap4);
        map.put("5", adjacentMap5);

        ArrayList<String> nodes = new ArrayList<>();

        nodes.add("1");
        nodes.add("2");
        nodes.add("3");
        nodes.add("4");
        nodes.add("5");
        System.out.println(RandomizedContraction.minCut(map, nodes));
    */ 
    /*
        try{
            Scanner s = new Scanner(new File("first-project/src/test/data/AdjacencyList.txt"));
            Scanner s2;
            int max = 2;
            int i=0;

            HashMap<String, HashMap<String, Integer>> oldMap = new HashMap<>();
            ArrayList<String> oldNodes = new ArrayList<>();

            while(s.hasNextLine()){
                String line = s.nextLine();
                s2 = new Scanner(line);
                String node = String.valueOf(s2.nextInt()); 
                oldNodes.add(node);
                HashMap<String, Integer> adjacentMap = new HashMap<>();
                while(s2.hasNextInt()){
                    String n = String.valueOf(s2.nextInt());
                    if(adjacentMap.containsKey(n)){
                        adjacentMap.put(n, adjacentMap.get(n)+ 1);
                    }
                    else{
                        adjacentMap.put(n, 1);
                    }
                }
                oldMap.put(node, adjacentMap);
                //i++;
            }
            int minCut = Integer.MAX_VALUE;
            
            HashMap<String, HashMap<String, Integer>> map = oldMap;
            ArrayList<String> nodes = oldNodes;
            
            for(int l = 0; l < 10; l++){
                minCut = Math.min(minCut, RandomizedContraction.minCut(map, nodes));
                map = oldMap;
                nodes = oldNodes;
                System.out.println("nodes " + Arrays.toString(nodes.toArray()));
            }
            

            System.out.println(minCut);

            //System.out.println(RandomizedContraction.minCut(map, nodes));
            s.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    */
        //
    /*
        int l =0;
        do{
            try{
                Scanner s = new Scanner(new File("first-project/src/test/data/AdjacencyList.txt"));
                Scanner s2;
                int max = 2;
                int i=0;
        
                HashMap<String, HashMap<String, Integer>> oldMap = new HashMap<>();
                ArrayList<String> oldNodes = new ArrayList<>();
        
                while(s.hasNextLine()){
                    String line = s.nextLine();
                    s2 = new Scanner(line);
                    String node = String.valueOf(s2.nextInt()); 
                    oldNodes.add(node);
                    HashMap<String, Integer> adjacentMap = new HashMap<>();
                    while(s2.hasNextInt()){
                        String n = String.valueOf(s2.nextInt());
                        if(adjacentMap.containsKey(n)){
                            adjacentMap.put(n, adjacentMap.get(n)+ 1);
                        }
                        else{
                            adjacentMap.put(n, 1);
                        }
                    }
                    oldMap.put(node, adjacentMap);
                    //i++;
                }
                //int minCut = Integer.MAX_VALUE;
                        
            // for(int l = 0; l < 10; l++){
                minCut = Math.min(minCut, RandomizedContraction.minCut(oldMap, oldNodes));
                
            //  }
                    
                /*
                System.out.println(RandomizedContraction.minCut(map, nodes));
                System.out.println("nodes " + Arrays.toString(nodes.toArray()));
                for (Map.Entry<String,HashMap<String,Integer>> entry : map.entrySet()){ 
                    System.out.println("node = " + entry.getKey());
                    for(Map.Entry<String,Integer> value : entry.getValue().entrySet()){
                        System.out.println("neighbhor = " + value.getKey() + " value = " + value.getValue());
                    }
                }
                
                //System.out.println(RandomizedContraction.minCut(map, nodes));
                s.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        while (l < 5);
        System.out.println(minCut);
        //
        */

        // Node n1 = new Node(1);
        // Node n2 = new Node(2);
        // Node n3 = new Node(3);
        // Node n4 = new Node(4);
        // Node n5 = new Node(5);
        // Node n6 = new Node(6);
        // Node n7 = new Node(7);
        // Node n8 = new Node(8);

        // n1.addOut(n2);
        
        // n2.addOut(n3);
        // n3.addOut(n1);

        // n2.addOut(n4);
        // n4.addOut(n5);
        // n5.addOut(n6);
        // n6.addOut(n7);
        // n7.addOut(n5);

        // n4.addOut(n8);
        // n8.addOut(n4);

        // ArrayList<Node> nodes = new ArrayList<>();
        // nodes.add(n1);
        // nodes.add(n2);
        // nodes.add(n3);
        // nodes.add(n4);
        // nodes.add(n5);
        // nodes.add(n6);
        // nodes.add(n7);
        // nodes.add(n8);

        //KosarajuConnected k = new KosarajuConnected();
        //System.out.println(Arrays.toString(k.getComponents(nodes).toArray()));
/*
        try{
            Scanner s = new Scanner(new File("com/company2/GraphEdgesConnected.txt"));
            HashSet<Node> nodes = new HashSet<>();
            HashMap<Integer, Node> map = new HashMap<>();
            //int i=0;
            //int max = 500000;
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
            
            KosarajuConnected k = new KosarajuConnected();
            System.out.println(Arrays.toString(k.getComponents(nodes).toArray()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
*/

    }
}
