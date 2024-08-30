package com.shivam.datetime;

import java.util.Date;

public class DateTimeUtil {
    public static int noOfHoursBetweenTwoDates(Date startTime, Date endTime) {
        long timeDiffInMillis = endTime.getTime() - startTime.getTime();
        double seconds = timeDiffInMillis / 1000.0;
        double minutes = seconds / 60;
        double hours = minutes / 60;
        return (int) Math.ceil(hours);
    }

    public static int compareTwoDates(Date date1, Date date2){
        return date1.compareTo(date2);
        // < 0  : Date 1 occurs before Date 2
        // == 0 : Date 1 is same as Date 2
        // > 0  : Date 1 occurs after Date 2
    }
}
