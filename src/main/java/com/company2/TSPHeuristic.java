package main.java.com.company2;
import java.io.File;
import java.math.BigDecimal;
import main.java.com.company2.TSP;
import main.java.com.company2.City;

import java.util.*;

public class TSPHeuristic {
    public static void main(String[] args){
        try{
            Stack<City> stack = new Stack<>();
            BigDecimal cost = BigDecimal.valueOf(0.0);
            HashSet<Integer> explored = new HashSet<>();

            ArrayList<City> cities = new ArrayList<>();
            cities.add(null);

            City origin = null;
            Scanner s = new Scanner(new File("test/data/TSPHeuristic.txt"));
            Scanner s2;

            int cityount = s.nextInt();

            while(s.hasNextLine()){
                String line = s.nextLine();
                s2 = new Scanner(line);

                while(s2.hasNext()){
                    int val = s2.nextInt();
                    City city = new City(s2.nextDouble(), s2.nextDouble(), val);
                    if(val == 1){
                        stack.push(city);
                        origin = city;
                    }
                    cities.add(city);
                }
            }
            explored.add(1);
            City cityFinal = null;
            //set nearest neighbor
            while(!stack.empty() && explored.size() != cityount){
                City source = stack.pop();
                double minDistance = Integer.MAX_VALUE;
                int nextCity = -1;
                
                for(int j = 2; j <= cityount; j++){
                    if(j != source.val && (!explored.contains(j))){
                        City destination = cities.get(j);
                        double distance = TSP.distance(source, destination);
                        if(distance < minDistance){
                            minDistance = distance;
                            if(!stack.empty())  stack.pop();
                            stack.push(destination);
                            nextCity = j;
                            cityFinal = destination;
                        }
                    }

                }  
                cost = cost.add(BigDecimal.valueOf(minDistance));
                
                explored.add(nextCity);
            }

            //return to first city to complete tour
            if(cityFinal != null){
                System.out.println("returning back home");
                cost = cost.add(BigDecimal.valueOf(TSP.distance(cityFinal, origin)));
            }

            System.out.println(cost);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
