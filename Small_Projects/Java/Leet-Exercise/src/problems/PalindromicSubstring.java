package problems;
import utils.M;
import utils.Rand;

import java.util.*;

public class PalindromicSubstring {

    private PalindromicSubstring(){}

    public static void run() throws Exception {
        Scanner input = new Scanner(System.in);
        M.pl("Enter a string length");
        Integer n = Integer.parseInt(input.nextLine());
        String string = Rand.genString(n);
        List<Integer> stack1 = new ArrayList<>();
        List<String> stack2 = new ArrayList<>();

        for (String subString : findPalindrome(string)) {
            if (!stack1.isEmpty() && checkPalindrome(subString)) {
                if (subString.length() > stack1.get(0)) {
                    stack1.clear();
                    stack2.clear();
                    stack1.add(subString.length());
                    stack2.add(subString);
                }
                if (subString.length() == stack1.get(0) && !(subString.equals(stack2.get(0)))) {
                    stack1.add(subString.length());
                    stack2.add(subString);
                }
            } else {
                stack1.add(subString.length());
                stack2.add(subString);
            }
        }
        displayResults(string, stack1, stack2);

    }

    private static LinkedList<String> findPalindrome(String string) {
        LinkedList<Character> ll1 = new LinkedList<>();
        List<Character> list = new ArrayList<>(Arrays.asList(M.convertArr(string.toCharArray())));
        ll1.addAll(list);
        LinkedList<String> ll2 = new LinkedList<>();
        StringBuilder build = new StringBuilder();
        while (!ll1.isEmpty()) {

            for (int i = 0; i < ll1.size(); i++) {
                if (ll1.get(i).equals(ll1.get((ll1.size() - 1) - i))) {
                    build.append(ll1.get(i));
                } else {
                    if ((build.toString().length() >= 2)) {
                        ll2.add(build.toString());
                    }
                    build = new StringBuilder();
                }
            }
            ll1.removeFirst();
        }
        return ll2;
    }
    private static boolean  checkPalindrome(String string) throws NullPointerException {
        Character[] arr = M.convertArr(string.toCharArray());
        Deque<Character> queue = new ArrayDeque<>();
        for (Character character : arr) {
            queue.push(character);
        }
        for(int i = arr.length - 1;  i >= 0; i--){
            assert queue.peek() != null;
            if(queue.peek().equals(arr[i])){
                queue.pop();
            }
        }
        return queue.isEmpty();
    }

    private static void displayResults(String string, List<Integer> stack1, List<String> stack2){
        M.pl(string + "\n\n");
        if (stack1.isEmpty()) {
            M.pl("No palindromic substrings");
        } else {
            M.pl("Longest palindromic substring(s):");
            for (int i = 0; i < stack1.size(); i++) {
                M.pl("Size " + stack1.get(i) + " String: " + stack2.get(i));
            }
        }
    }
}