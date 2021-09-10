package main.java.com.company2;

import java.util.*;
import java.io.File;
import java.math.BigInteger;

public class Huffman {
    
    static final int COUNT = 10; 
    public static HashSet<BigInteger> weights = new HashSet<BigInteger>(); 
    public static boolean nodeFound = false;
    public static int minCodeLen = 0;

    static void print2DUtil(NodeHuff root, int space) 
    { 
        // Base case 
        if (root == null) 
            return; 
    
        // Increase distance between levels 
        space += COUNT; 
    
        // Process right child first 
        print2DUtil(root.getRight(), space); 
    
        // Print current node after space 
        // count 
        System.out.print("\n"); 
        for (int i = COUNT; i < space; i++) 
            System.out.print(" "); 
        System.out.print(root.getWeight() + "\n"); 
    
        // Process left child 
        print2DUtil(root.getLeft(), space); 
    } 
    
    // Wrapper over print2DUtil() 
    static void print2D(NodeHuff root) 
    { 
        // Pass initial space count as 0 
        print2DUtil(root, 0); 
    } 

    public static NodeHuff getHuffTree(PriorityQueue<NodeHuff> minHeap){

        while(minHeap.size() > 1){
            //System.out.println(minHeap.size());
            NodeHuff n1 = minHeap.poll();
            NodeHuff n2 = minHeap.poll();

            //BigInteger newVal = new BigInteger(n1.getVal().toString() + n2.getVal().toString());
            BigInteger newWeight = n1.getWeight().add(n2.getWeight());
            NodeHuff n = new NodeHuff(newWeight);
            n.addLeft(n1);
            n.addRight(n2);
            minHeap.add(n);
        }   
        return minHeap.poll();
    }

    public static int getMinCodeLen(NodeHuff node, int depth){

        //if(node != null)  System.out.println("node " + node.getWeight() + " depth " + depth);

        if(node == null)  return 0;

        if(nodeFound == false && weights.contains(node.getWeight())){
            minCodeLen = depth;
            nodeFound = true;
        }  
        
        int depthDown  = getMinCodeLen(node.getLeft(), depth + 1);
        
        if(depthDown != 0){
            return depthDown;
        }

        depthDown = getMinCodeLen(node.getRight(), depth + 1);

        return depthDown;
    }

    public static int getMaxDepth(NodeHuff node){

        if(node == null)  return -1;

        int leftHeight = getMaxDepth(node.getLeft());
        int rightHeight = getMaxDepth(node.getRight());
        //System.out.println("node " + node.getWeight()+ " leftHeight " + leftHeight + " rightHeight " + rightHeight);
        if(leftHeight >= rightHeight)  return leftHeight + 1;
        else return rightHeight + 1;
    }

    public static void main(String[] args) {

        Comparator<NodeHuff> comparator = new Comparator<NodeHuff>(){
                
            @Override
            public int compare(NodeHuff n1, NodeHuff n2){
                if(n1.getWeight().compareTo(n2.getWeight()) == 1)  return 1;
                else if(n1.getWeight().compareTo(n2.getWeight()) == -1)  return -1;
                else return 0;
            }
        };

        PriorityQueue<NodeHuff> minHeap = new PriorityQueue<>(comparator);

        try{
            Scanner s = new Scanner(new File("test/data/Huffman.txt"));
            int nodesCount = s.nextInt();
            //BigInteger i = BigInteger.valueOf(1);
            while(s.hasNextInt()){
                //System.out.println(minHeap.size());
                BigInteger weight = BigInteger.valueOf(s.nextInt());
                NodeHuff n = new NodeHuff(weight);
                minHeap.add(n);
                weights.add(weight);
                //i = i.add(BigInteger.valueOf(1));      
            }
            NodeHuff huffTree = Huffman.getHuffTree(minHeap);
            System.out.println(huffTree.getWeight());
            //Huffman.print2D(huffTree);
            System.out.println(Huffman.getMaxDepth(huffTree));
            Huffman.getMinCodeLen(huffTree, 0);
            System.out.println(minCodeLen);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
}
