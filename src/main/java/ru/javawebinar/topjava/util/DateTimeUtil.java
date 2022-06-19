package ru.javawebinar.topjava.util;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private static final LocalDateTime MIN_DATE=LocalDateTime.of(1,1,1,0,0);
    private static final LocalDateTime MAX_DATE=LocalDateTime.of(3000,1,1,0,0);
//    public static boolean isBetweenHalfOpen(LocalTime lt, LocalTime startTime, LocalTime endTime) {
//        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) < 0;
//    }

    public static LocalDateTime getStartInclusive(LocalDate localDateTime){
        return localDateTime!=null?localDateTime.atStartOfDay() :MIN_DATE;
    }
    public static @Nullable LocalDate parseLocalDate(@Nullable String s){
        return StringUtils.isEmpty(s) ? null:LocalDate.parse(s);
    }
    public static @Nullable LocalTime parseLocalTime(@Nullable String s){
        return StringUtils.isEmpty(s) ? null:LocalTime.parse(s);
    }

    public static LocalDateTime getEndInclusive(LocalDate localDateTime){
        return localDateTime!=null?localDateTime.plus(1, ChronoUnit.DAYS).atStartOfDay() :MAX_DATE;
    }
    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }
}

