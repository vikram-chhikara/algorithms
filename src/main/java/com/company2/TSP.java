package main.java.com.company2;
import java.io.File;
import java.lang.reflect.Array;

import main.java.com.company2.City;

import java.util.*;

public class TSP {
    
    public static double distance(City c1, City c2){

        double a = Math.pow(c1.getX() - c2.getX(), 2);
        double b = Math.pow(c1.getY() - c2.getY(), 2);

        return Math.sqrt(a+b);
    }
    
    public static void combinations(int set, int at, int r, int n, ArrayList<Integer> subsets){
        int elementsLeftToPick = n - at;
        if (elementsLeftToPick < r) return;

        // We selected 'r' elements so we found a valid subset!
        if (r == 0) {
        subsets.add(set);
        } else {
        for (int i = at; i < n; i++) {
            // Try including this element
            set ^= (1 << i);

            combinations(set, i + 1, r - 1, n, subsets);

            // Backtrack and try the instance where we did not include this element
            set ^= (1 << i);
        }
        }
    }

    public static ArrayList<Integer> combinations(int r, int n){
        
        ArrayList<Integer> subsets = new ArrayList<>();
        combinations(0, 0, r, n, subsets);
        return subsets;
    }


    public static double getPathCost(ArrayList<City> cities, int N, HashMap<Integer, City> map, double[][] m){

        double minCost = Double.POSITIVE_INFINITY;
        final int END_STATE = (1 << N) - 1;
        double[][] memo = new double[N][1 << N];
        int S = 0;
        //initialize memo table
        for(int i = 0; i < N; i++){
            if(i != S){
                memo[i][1 << S | 1 << i] = m[S][i];
            }
        }
        //solve
        for(int r = 3; r <= N; r++){
            for(int subset: combinations(r, N)){
                if(notIn(S, subset))  continue;
                for(int next = 0; next < N; next++){
                    if(next == S || notIn(next, subset))  continue;
                    int prevState = subset ^ (1 << next);
                    double minDistance = Double.POSITIVE_INFINITY;
                    for(int end = 0; end < N; end++){
                        if(end == S || end == next|| notIn(end, subset))  continue;
                        double newDistance = memo[end][prevState] + m[next][end];
                        minDistance = Math.min(minDistance, newDistance);
                        memo[next][subset] = minDistance;
                    }

                }
            }
        }
        for(int j = 0; j < N; j++){
            if(j == S)    continue;
            minCost = Math.min(minCost, memo[j][END_STATE] + m[j][S]);
        }
        return minCost;
    }

    public static boolean notIn(int S, int subset){
        return (subset & (1 << S)) == 0;
    }
    public static void main(String[] args){
        try{

            HashMap<Integer, City> map = new HashMap<>();
            Scanner s = new Scanner(new File("test/data/TSP.txt"));
            Scanner s2;

            int cityount = s.nextInt();
            double[][] m = new double[cityount][cityount];

            ArrayList<City> cities = new ArrayList<>();

            int k = 0;
            while(s.hasNextLine()){
                String line = s.nextLine();
                s2 = new Scanner(line);
 
                while(s2.hasNext()){
                    City city = new City(s2.nextDouble(), s2.nextDouble(), k);
                    cities.add(city);
                    map.put(k, city);  
                    k++;          
                }
            }
            double min = Double.POSITIVE_INFINITY;
            int min_i = -1;
            int min_j = -1;

            for(int i = 0; i < cityount-1; i++){
                for(int j = i + 1; j < cityount; j++){
                    m[i][j] = TSP.distance(map.get(i), map.get(j));
                    m[j][i] = m[i][j];
                }
            }
            //System.out.println(TSP.getPathCost(cities, cityount, map, m));
            City c1 = new City(998.3333, 9855.0000, 0);
            City c2 = new City(98550.0000, 89683.3333 ,1);
            System.out.println(TSP.distance(c1, c2));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
