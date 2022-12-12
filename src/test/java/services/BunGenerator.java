package services;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class BunGenerator {
    static int targetStringLength = 6;

    public static String randomName() {
        return RandomStringUtils.randomAlphabetic(targetStringLength);
    }
    public static float randomPrice() { return RandomUtils.nextFloat(0f,6f); }

}
