package com.yesmadam.androidApp.utils;
// 5. TestUtils.java ➔ (Helper Methods)

public class CommonUtils {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
