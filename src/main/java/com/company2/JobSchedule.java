package main.java.com.company2;

import java.util.*;
import java.io.File;
import java.math.BigInteger;

public class JobSchedule {
    
    public static BigInteger getCompletionTime(Job[] jobs){
        BigInteger weightedCompletionTime = BigInteger.valueOf(0);
        BigInteger timeElapsed = BigInteger.valueOf(0);

        for(Job j: jobs){
            //weightedCompletionTime += j.getWeight()*(timeElapsed + j.getLength());
            BigInteger weight = BigInteger.valueOf(j.getWeight());
            BigInteger length = timeElapsed.add(BigInteger.valueOf(j.getLength()));

            weightedCompletionTime = weightedCompletionTime.add(weight.multiply(length));
            timeElapsed = timeElapsed.add(BigInteger.valueOf(j.getLength()));
        }
        
        return weightedCompletionTime;
    }
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(new File("test/data/JobSchedule.txt"));
            Scanner s2;
            Job[] jobs = new Job[s.nextInt()];
            int i =0;

            while(s.hasNextLine()){
                String line = s.nextLine();
                s2 = new Scanner(line);

                while(s2.hasNext()){
                    int weight = s2.nextInt();
                    int length = s2.nextInt();

                    Job j = new Job(weight, length);
                    jobs[i++] = j;

                }
            }

            Comparator<Job> comparator1 = new Comparator<Job>(){
                @Override
                public int compare(Job j1, Job j2){
                    if( (j1.getWeight() - j1.getLength()) < (j2.getWeight() - j2.getLength()) )  return 1;
                    else if((j1.getWeight() - j1.getLength()) > (j2.getWeight() - j2.getLength()))  return -1;
                    else{
                        if(j1.getWeight() < j2.getWeight())  return 1;
                        else if(j1.getWeight() > j2.getWeight())  return -1;
                        else return 0;
                    }
                }
            };

            Comparator<Job> comparator2 = new Comparator<Job>(){
                @Override
                public int compare(Job j1, Job j2){
                    double w1 = j1.getWeight();
                    double l1 = j1.getLength();

                    double w2 = j2.getWeight();
                    double l2 = j2.getLength();

                    if( ( w1/l1) < (w2/l2) )  return 1;
                    else if(( w1/l1) > (w2/l2))  return -1;
                    else return 0;
/*
                    if( ( (double)j1.getWeight() / (double)j1.getLength()) < ((double)j2.getWeight() / (double)j2.getLength()) )  return 1;
                    else if(((double)j1.getWeight() / (double)j1.getLength()) > ((double)j2.getWeight() / (double)j2.getLength()))  return -1;
                    else return 0;
                    */
                }
            };

            Arrays.sort(jobs, comparator2);
            System.out.println(JobSchedule.getCompletionTime(jobs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
