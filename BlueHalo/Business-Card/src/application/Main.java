package application;

public abstract class Main {

    public static void main(String[] args){
        try {
            if(args.length != 1){
                throw new CardException(Errors.ONLY_ONE_ARG.getError());
            }
            else{
                Input.getInput(args[0]);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
