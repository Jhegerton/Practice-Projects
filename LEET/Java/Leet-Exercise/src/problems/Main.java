package problems;

import utils.M;

public interface Main {

    static void main(String[] args){
        if(args.length == 0) {
            try {
                PalindromicSubstring.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            M.err("ERROR: This program does not take arguments");
            System.exit(1);

        }
    }
}
