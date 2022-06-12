package problems;

import utils.M;

import java.util.*;

public class AddTwoNumbers {

    static LinkedList<Integer> ll;
    static Scanner input;

    private AddTwoNumbers(){}

    public static void run(){
        M.pl("Enter an integer");
        Integer num1 = Integer.parseInt(input.nextLine());
        M.pl("Enter a second integer");
        Integer num2 = Integer.parseInt(input.nextLine());

        ll = new LinkedList<>();
        LinkedList<Integer> ll0 = new LinkedList<>(construct(num1, ll));
        ll.clear();
        LinkedList<Integer> ll1 = new LinkedList<>(construct(num2, ll));

        M.pl(num1);
        print(ll0);
        M.pl();
        M.pl(num2);
        print(ll1);
        M.pl();
        M.pl(num1 + num2);
        print(sum(ll0, ll1));


    }
    public static void test(){
        LinkedList<Integer> ll2 = new LinkedList<>();
        Integer start = 0;
        M.pl(deconstruct(construct(255, ll2), start));
    }
    private static LinkedList<Integer> construct(Integer num, LinkedList<Integer> linkedList){
       if(num.equals(0)){
           return linkedList;
       }
       linkedList.add(num % 10);
       return construct(num / 10, linkedList);
    }
    private static Integer deconstruct(LinkedList<Integer> linkedList, Integer num){
        num += linkedList.getLast();
        linkedList.removeLast();
        if(linkedList.isEmpty()){
            return num;
        }
        return deconstruct( linkedList, num * 10);
    }
    private static LinkedList<Integer> sum(LinkedList<Integer> ll1, LinkedList<Integer> ll2){
        LinkedList<Integer> templl = new LinkedList<>();
        return construct(deconstruct(ll1, 0) + deconstruct(ll2, 0), templl);
    }
    private static void print(LinkedList<Integer> lln){
        for(Integer num : lln) {
            M.p(num + " <- ");
        }
    }
}
