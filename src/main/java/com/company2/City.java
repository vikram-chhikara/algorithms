package main.java.com.company2;
import main.java.com.company2.Neighbor;
import java.util.*;

public class City {
    
    private double x;
    private double y;
    public int val;
    private Neighbor nearestNeighbor;

    public City(double a, double b, int v){
        x = a;
        y = b;
        val = v;
        nearestNeighbor = null;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public Neighbor getNeighbor(){
        return nearestNeighbor;
    }
    public void  setNeighbor(Neighbor n){
        nearestNeighbor = n;
    }
}
