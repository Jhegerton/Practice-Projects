package utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Rand {

    private Rand(){}
    public static Random gen() throws NoSuchAlgorithmException {
        return SecureRandom.getInstanceStrong();
    }
    public static String genString(int n) throws  Exception{
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < n; i++){
            build.append((char) Lowercase(gen().nextInt(Integer.MAX_VALUE) % 26));
        }
        return build.toString();
    }
    private static int Lowercase(int n) throws LeetException {
        if(n >= 27 || n < 0){
            throw new LeetException("Unicode value out of bounds");
        }
        return 97 + n;
    }
}
