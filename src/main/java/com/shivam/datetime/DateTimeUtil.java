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
        // the below methods checks time using millis

        return date1.compareTo(date2);
        // < 0  : Date 1 occurs before Date 2
        // == 0 : Date 1 is same as Date 2
        // > 0  : Date 1 occurs after Date 2

//        or

//        date1.before(date2); // date1 occurs before date 2
//        date1.equals(date2); // date 1 is equal to date 2
//        date1.after(date2); // date 1 occurs after date 2
    }
}
