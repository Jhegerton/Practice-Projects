package utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Rand {

    private Rand(){}
    private static Random gen() throws NoSuchAlgorithmException {
        return SecureRandom.getInstanceStrong();
    }
    public static Object gen(char l) throws Exception {
        if(l == 'i'){
            return gen().nextInt(Integer.MAX_VALUE);
        }
        else if(l == 'd'){
            return gen().nextDouble(Double.MAX_VALUE);
        }
        else if(l == 'l'){
            return gen().nextLong(Long.MAX_VALUE);
        }
        else if(l =='f'){
            return gen().nextFloat(Float.MAX_VALUE);
        }
        else if(l == 'b') {
            return gen().nextBoolean();
        }
        else {
            throw new LeetException("Option is invalid");
        }

    }
    public static String genString(int n) throws  Exception{
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(Boolean.TRUE.equals(gen('b'))) {
                build.append(lowercase((Integer) gen('i')));
            }
            else{
                build.append(uppercase((Integer) gen('i')));
            }
        }
        return build.toString();
    }
    public static String genString(int n, char l) throws  Exception{
        StringBuilder build = new StringBuilder();
        if(l == 'l') {
            for (int i = 0; i < n; i++) {
                build.append(lowercase(gen().nextInt(Integer.MAX_VALUE)));
            }
        }
        else if( l == 'u'){
            for (int i = 0; i < n; i++) {
                build.append(uppercase(gen().nextInt(Integer.MAX_VALUE)));
            }
        }
        else{
            throw new LeetException("Option is invalid");
        }
        return build.toString();
    }
    private static char lowercase(int n){
        return ((char) (97 + (n % 26)));
    }
    private static char uppercase(int n){
        return ((char) (65 + (n % 26)));
    }
}
