package problems;

import utils.LeetException;
import utils.M;
import utils.Rand;

import java.util.*;

public class TwoSome {

    private TwoSome(){}

    public static void execute() throws LeetException {
        Scanner input = new Scanner(System.in);
        M.pl("Enter a limit greater than 0.");
        Integer limit = Integer.parseInt(input.nextLine());
        if(limit < 0){
            throw new LeetException("Limit out of bounds");
        }
        M.pl("Enter a value between 0 and " + limit);
        Integer val = Integer.parseInt(input.nextLine());
        if(val > limit || val < 0){
            throw new LeetException("Value out of bounds.");
        }
        Integer[] arr1 = new Integer[limit];
        Integer[] arr2 = new Integer[limit];
        try {
            System.arraycopy(generateArray(limit), 0, arr1, 0, arr1.length);
            System.arraycopy(generateArray(limit), 0, arr2, 0, arr2.length);
        }catch(Exception e){
            e.printStackTrace();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2.length; j++){
                if(!map.containsKey(arr1[i]) && arr1[i] + arr2[j] == val) {

                    M.pl("[" + i + "][" + j + "]" + " (" + arr1[i] + " + " + arr2[j] + ")");
                    map.put(arr1[i], arr2[j]);
                }
            }
        }
    }

    private static Integer[] generateArray(int size) throws Exception {
        Integer[] arr = new Integer[size];

        for(int i = 0; i < size; i++){
            arr[i] = Rand.gen().nextInt(Integer.MAX_VALUE) % size;
        }
        return arr;
    }
}
