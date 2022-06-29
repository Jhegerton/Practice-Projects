package core;

public interface Main {
    public static void main(String[] args){
        if(args.length == 0) {
            try {
                Algorithms.pickOne();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            System.err.println("This program does not take arguments");
            System.exit(1);
        }
    }
}
