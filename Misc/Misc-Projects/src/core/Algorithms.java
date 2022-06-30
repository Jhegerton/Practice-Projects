package core;

import java.math.BigInteger;
import java.time.Clock;
import java.util.*;
import java.security.SecureRandom;

public class Algorithms {
    static Scanner input = new Scanner(System.in);
    static List<String> choices = new ArrayList<>();
    static Random rand = new Random();
    static Clock time = Clock.systemUTC();

    private Algorithms(){}

    public static void pickOne(String[] args){

        rand.setSeed(time.millis());
        final BigInteger PRIME = BigInteger.probablePrime(12, rand);

         int count = args.length;

         Map<Integer, Double> results = new HashMap<>();
         double total = 0.0;

         for(Integer i = 0; i < PRIME.intValue(); i++){
             int res = rand.nextInt(Integer.MAX_VALUE) % count;
             if(results.containsKey(res)){
                 results.replace(res, results.get(res) + 1);
                 total = total + results.get(res);
             }
             else{
                 results.put(res, 1.0);
             }
         }
        Integer winner = 0;
        Double temp = 0.0;
        for(Map.Entry<Integer, Double> entry : results.entrySet()){
            Integer key = entry.getKey();
             if(temp < results.get(key)){
                 winner = key;
                 temp = results.get(key);
             }
         }

        for(Map.Entry<Integer, Double> entry : results.entrySet()){
            Integer key = entry.getKey();
            System.out.println(args[key] + " with " + Math.round(results.get(key)) + " votes (" + Math.round(results.get(key) / PRIME.doubleValue() * 100) + "%)");
        }
        System.out.println(args[winner]);

    }

}
