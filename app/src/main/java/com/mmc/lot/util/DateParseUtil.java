package com.mmc.lot.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * Created by louis on 2018/3/25.
 */

public class DateParseUtil {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", new Locale("zh", "CN"));

    public static byte[] format(long time) {
        String dateStr = dateFormat.format(new Date(time));
        byte[] dateBytes = new byte[7];

        try {
            // year
            int yearHigh = Integer.valueOf(dateStr.substring(0, 2));
            dateBytes[0] = (byte) yearHigh;
            int yearLow = Integer.valueOf(dateStr.substring(2, 4));
            dateBytes[1] = (byte) yearLow;

            // month
            int month = Integer.valueOf(dateStr.substring(4, 6));
            dateBytes[2] = (byte) month;
            // day
            int day = Integer.valueOf(dateStr.substring(6, 8));
            dateBytes[3] = (byte) day;

            // hour
            int hour = Integer.valueOf(dateStr.substring(8, 10));
            dateBytes[4] = (byte) hour;

            // min
            int min = Integer.valueOf(dateStr.substring(10, 12));
            dateBytes[5] = (byte) min;

            // sec
            int sec = Integer.valueOf(dateStr.substring(12, 14));
            dateBytes[6] = (byte) sec;

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(dateBytes));

        return dateBytes;
    }

}
