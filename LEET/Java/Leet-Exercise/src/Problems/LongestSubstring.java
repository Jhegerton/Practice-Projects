package Problems;

import Utils.M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class LongestSubstring {
    public static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();
        Vector<Character> charVec = new Vector<>();
        Vector<String> stringVec = new Vector<>();
        int count = 0;
        String dummy = "";

        M.pl("Enter a string");
        String input = reader.readLine();

        char[] arr = input.toCharArray();

        for(char c : arr){
            if (charVec.contains(c)) {
                stringVec.add(build.toString());
                charVec.clear();
                build = new StringBuilder();
            }
            build.append(c);
            charVec.add(c);
        }

        for(String substring : stringVec){
            if(count < substring.length()){
                dummy = substring;
                count = substring.length();
            }
        }

        M.pl("The longest substring is: " + dummy + ", with the length of " + count);




    }
}
