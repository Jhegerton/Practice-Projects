package problems;

import utils.M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LongestSubstring {

    private LongestSubstring(){}
    public static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();
        LinkedList<Character> chars = new LinkedList<>();
        LinkedList<String> strings = new LinkedList<>();
        int count = 0;
        String dummy = "";

        M.pl("Enter a string");
        String input = reader.readLine();

        char[] arr = input.toCharArray();

        for(char c : arr){
            if (chars.contains(c)) {
                strings.add(build.toString());
                chars.clear();
                build = new StringBuilder();
            }
            build.append(c);
            chars.add(c);
        }

        for(String substring : strings){
            if(count < substring.length()){
                dummy = substring;
                count = substring.length();
            }
        }

        M.pl("The longest substring is: " + dummy + ", with the length of " + count);




    }
}
