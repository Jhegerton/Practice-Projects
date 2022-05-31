import java.util.*;

public class AddTwoNumbers {

    static LinkedList<Integer> ll;

    public static void run(){
        ll = new LinkedList<>();
    }
    public static void test(){
        LinkedList<Integer> ll2 = new LinkedList<>();
        for(Integer num : construct(255, ll2)){
            System.out.println(num);
        }
    }
    private static LinkedList<Integer> construct(Integer num, LinkedList<Integer> linkedList){
       if(num.equals(0)){
           return linkedList;
       }
       linkedList.add(num % 10);
       return construct(num / 10, linkedList);
    }
}
