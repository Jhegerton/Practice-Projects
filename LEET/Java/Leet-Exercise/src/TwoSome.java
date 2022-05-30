import java.util.*;
import java.time.*;

public class TwoSome {
    private static  Scanner input;
    private static HashMap<Integer, Integer> map;

    public static void execute() throws Exception{
        input = new Scanner(System.in);
        System.out.println("Enter a limit greater than 0.");
        Integer limit = Integer.parseInt(input.nextLine());
        if(limit < 0){
            throw new Exception("Limit out of bounds");
        }
        System.out.println("Enter a value between 0 and " + limit);
        Integer val = Integer.parseInt(input.nextLine());
        if(val > limit || val < 0){
            throw new Exception("Value out of bounds.");
        }
        Integer[] arr1 = new Integer[limit];
        Integer[] arr2 = new Integer[limit];
        System.arraycopy(generateArray(limit), 0, arr1, 0, arr1.length);
        System.arraycopy(generateArray(limit), 0, arr2, 0, arr2.length);

        map = new HashMap<>();

        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2.length; j++){
                if(!map.containsKey(arr1[i])) {
                    if (arr1[i] + arr2[j] == val) {
                        System.out.println("[" + i + "][" + j + "]" + " (" + arr1[i] + " + " + arr2[j] + ")");
                        map.put(arr1[i], arr2[j]);
                    }
                }
            }
        }
    }

    private static Integer[] generateArray(int size) throws InterruptedException {
        Integer[] arr = new Integer[size];
        Random rand = new Random();
        Clock time = Clock.systemUTC();
        Thread.sleep(1);
        rand.setSeed(time.millis());

        for(int i = 0; i < size; i++){
            arr[i] = rand.nextInt(Integer.MAX_VALUE) % size;
        }
        return arr;
    }
}
