package ru.mia.graduate.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private static final String VOTE_TIME ="11:00";
    // DataBase doesn't support LocalDate.MIN/MAX
    public static final LocalDate MIN_DATE = LocalDate.of(1, 1, 1);
    public static final LocalDate MAX_DATE = LocalDate.of(3000, 1, 1);

    private DateTimeUtil() {
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }

    public static LocalDate parseLocalDate(String str) {
        return StringUtils.isEmpty(str) ? null : LocalDate.parse(str);
    }

    public static LocalTime parseLocalTime(String str) {
        return StringUtils.isEmpty(str) ? null : LocalTime.parse(str);
    }

    public static LocalDateTime parseLocalDateTime(String str) {
        return StringUtils.isEmpty(str) ? null : LocalDateTime.parse(str,DATE_TIME_FORMATTER);
    }

    public static boolean isBeforeVoteTime(String userTime){
        if(StringUtils.isEmpty(userTime))return  false;

        LocalDateTime userDateTime= LocalDateTime.parse(userTime,DATE_TIME_FORMATTER);

        if(userDateTime.toLocalTime().isBefore(LocalTime.parse(VOTE_TIME)))return true;
        return false;
    }

    public static boolean isBeforeToday(String userTime){
        if(StringUtils.isEmpty(userTime))return  false;

        LocalDateTime userDateTime= LocalDateTime.parse(userTime,DATE_TIME_FORMATTER);
        LocalDate currentDate = LocalDate.now();
        if(userDateTime.toLocalDate().isBefore(currentDate))return true;
        return false;
    }



    public static String nowFormatted()
    {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER );
    }

}
