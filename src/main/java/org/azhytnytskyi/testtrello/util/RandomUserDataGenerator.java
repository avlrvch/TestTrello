
package org.azhytnytskyi.testtrello.util;

import java.util.Random;

public class RandomUserDataGenerator {
    
    private static Random random = new Random();
    private static String charsToUse = "1234567890abcdefghijklmnopqrstuvwxyz";
    
    public static String generateRandomName(int nameLength) {
        return generateSimpleCharSequence(nameLength);
    }

    public static String generateRandomEmail() {
        return generateSimpleCharSequence(8) + "@test.com";
    }

    public static String generateRandomPassword(int passwordLength) {
        return generateSimpleCharSequence(passwordLength);
    }
    
    private static String generateSimpleCharSequence(int charLength){
        String output = "";
        for (int i = 0; i < charLength; i++) {
            char c = charsToUse.charAt(random.nextInt(26));
            output +=c;
        }
        return output;
    }

}
