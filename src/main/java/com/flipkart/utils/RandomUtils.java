package com.flipkart.utils;

import java.util.Random;

public class RandomUtils {

    // Generate a random integer between min and max
    public static int generateRandomInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    // Generate a random string of specified length
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString();
    }

    // Generate a random boolean value
    public static boolean generateRandomBoolean() {
        Random rand = new Random();
        return rand.nextBoolean();
    }
}
