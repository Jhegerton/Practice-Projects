package RandGen.com.flipcoin;
import java.util.Random;
class Main {
    private static Random rand = new Random(System.currentTimeMillis());
    public static void main(String[] args){
        //System.out.printf("%s!", "Hello World");
        flipcoin(1000000000);
    }

    private static void flipcoin(Integer numTimes){
        Double start = (double) System.currentTimeMillis() / 1000;
        Integer side;
        Integer heads = 0; Integer tails = 0;

        for(Integer i = 0; i < numTimes; i++){
          side = rand.nextInt(0,2);
          //System.out.println(side);
          if(side == 0){
            heads++;
          } else{
            tails++;
          }
        }
        //System.out.printf("Num Heads %d, Num Tails %d\n", heads, tails);
        Double headsPct = (double) heads / (double) numTimes * 100;
        Double tailsPct = (double) tails / (double) numTimes * 100;
        Double end = (double) System.currentTimeMillis() / 1000;
        Double elapsedTime = end - start;
        System.out.printf("Random Test: Heads %.0f%% Tails %.0f%%. Took %.5f seconds\n", headsPct, tailsPct, elapsedTime);

    }
}