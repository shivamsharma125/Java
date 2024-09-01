package com.shivam.datetime;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
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

    public static Date getStartOfDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return calendar.getTime();
    }

    public static Date getEndOfDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE,calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND,calendar.getActualMaximum(Calendar.SECOND));
        return calendar.getTime();
    }

    public static LocalDate convertToLocaleDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static boolean isDateBetweenTwoDates(Date startDate, Date endDate, Date dateToCheck){
        LocalDate startLocaleDate = convertToLocaleDate(startDate);
        LocalDate endLocaleDate = convertToLocaleDate(endDate);
        LocalDate dailyRevenueDate = convertToLocaleDate(dateToCheck);

        return !dailyRevenueDate.isBefore(startLocaleDate) && !dailyRevenueDate.isAfter(endLocaleDate);
    }

    public static Date[] startAndEndDateOfCurrentMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDateOfMonth = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endDateOfMonth = calendar.getTime();

        return new Date[]{startDateOfMonth,endDateOfMonth};
    }
    public static Date[] startAndEndDateOfPreviousMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDateOfMonth = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endDateOfMonth = calendar.getTime();

        return new Date[]{startDateOfMonth,endDateOfMonth};
    }
    public static Date[] startAndEndDateOfCurrentFY(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, Calendar.APRIL);

        if (calendar.getTime().after(new Date())) {
            calendar.add(Calendar.YEAR, -1);
        }

        Date startOfFinancialYear = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, 31);
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.add(Calendar.YEAR, 1);
        Date endOfFinancialYear = calendar.getTime();

        return new Date[]{startOfFinancialYear,endOfFinancialYear};
    }
    public static Date[] startAndEndDateOfPreviousFY(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, Calendar.APRIL);

        if (calendar.getTime().after(new Date())) {
            calendar.add(Calendar.YEAR, -1);
        }
        calendar.add(Calendar.DAY_OF_MONTH,-1); // to get end of previous FY

        Date endOfFinancialYear = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.add(Calendar.YEAR, -1);
        Date startOfFinancialYear = calendar.getTime();

        return new Date[]{startOfFinancialYear,endOfFinancialYear};
    }
}
