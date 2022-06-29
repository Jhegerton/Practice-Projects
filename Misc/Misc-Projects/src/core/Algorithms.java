package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.security.SecureRandom;
import java.util.Scanner;

public class Algorithms {
    static Scanner input = new Scanner(System.in);
    static List<String> choices = new ArrayList<>();
    static SecureRandom rand = new SecureRandom();

    private Algorithms(){}

    public static void pickOne(){
        System.out.println("Enter your choices");
         do{
                choices.add(input.nextLine());
        }while(input.hasNextLine());
         int count = choices.size();
         List<Integer> chance = new ArrayList<>();
         for(int i = 0; i < 103; i++){
             chance.add(rand.nextInt() % count);
         }
         Collections.sort(chance);
         int winner = 0;
         int greatest = 0;
         int number = 0;
         int past = 0;
         for(Integer index : chance){
             if(index == past){
                 number++;
             }
             else{
                 if(number > greatest){
                     winner = index;
                     greatest = number;
                 }
                 number = 1;
             }

         }
         System.out.println("The choice is " + choices.get(winner) + " with " + greatest/103 + "% of the vote.");
    }

}
