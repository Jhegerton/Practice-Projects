package core;

public interface Main {
    public static void main(String[] args){
            try {
                Algorithms.pickOne(args);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
