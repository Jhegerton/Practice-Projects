package utils;

import java.security.SecureRandom;
import java.util.Random;

public class Rand {

    public Random gen() throws Exception{
        return SecureRandom.getInstanceStrong();
    }
}
