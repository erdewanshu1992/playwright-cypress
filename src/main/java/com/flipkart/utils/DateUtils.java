package com.flipkart.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    // Get the current date in "yyyy-MM-dd" format
    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    // Add days to the current date
    public static String addDaysToCurrentDate(int daysToAdd) {
        Date currentDate = new Date();
        long millisecondsInADay = 1000 * 60 * 60 * 24L;
        long newTime = currentDate.getTime() + (daysToAdd * millisecondsInADay);
        Date newDate = new Date(newTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(newDate);
    }

    // Format a given Date object to "yyyy-MM-dd"
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
