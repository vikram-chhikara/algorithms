package main.java.com.company2;
public class NodeC {
    
    private NodeC leader;
    private int val;

    public NodeC(int v){
        val = v;
    }

    public int getVal(){
        return val;
    }

    public NodeC getLeader(){
        return leader;
    }

    public void setLeader(NodeC l){
        leader = l;
    }
}
