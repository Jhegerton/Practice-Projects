package problems;

import utils.M;
import java.util.*;

public class MedianOfArrays {

    private MedianOfArrays(){}
    public static void run(){

        Scanner scan = new Scanner(System.in);

        M.pl("Enter an array followed by commas");
        Integer[] arr1 = getArray(scan.nextLine());
        M.pl("Enter another array");
        Integer[] arr2 = getArray(scan.nextLine());

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr1));
        list.addAll(Arrays.asList(arr2));
        Collections.sort(list);

        if(list.size() % 2 == 0){
            M.pl(((float) list.get(list.size() / 2) + (float) list.get(list.size() / 2)) / 2);
        }else {
            M.pl((float) list.get((list.size() + 1) / 2));
        }

   }
   public static Integer[] getArray(String input){
       String[] strArr = input.split(",");
       Integer[] arr = new Integer[strArr.length];

       for(int i = 0; i < strArr.length; i++){
           arr[i] = Integer.parseInt(strArr[i]);
       }

       return arr;
   }

}



