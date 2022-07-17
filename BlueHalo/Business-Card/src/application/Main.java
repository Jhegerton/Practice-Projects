package application;

public abstract class Main {
    /**
     * Main class and method
     * <p>
     *     The main method recieves the ocr data as a text file. To use add the url to the
     *     text file as a command line argument and it will pull the information from that
     *     location. The program will only run with one argument, being the location.
     * </p>
     * @author Harrison Egerton
     * <em>July 17th, 2022</em>
     * @param args
     */

    public static void main(String[] args){
        try {
            if(args.length != 1){
                throw new CardException("This program takes only one argument");
            }
            else{
                System.out.println(Input.getInput(args[0]));
            }
        }
        catch(Exception e){
            System.err.println(e);
            System.exit(1);
        }
    }
}
