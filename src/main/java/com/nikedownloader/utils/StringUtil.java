package com.nikedownloader.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringUtil {

    public static String xmlDateTimeToString(String xmlDateTime) {
        DateTimeFormatter xmlDateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime parse = LocalDateTime.parse(xmlDateTime, xmlDateTimeFormat);
        return parse.format(dateTimeFormat);
    }

    public static String roundStringNumber(String distance) {
        BigDecimal bigDecimal = new BigDecimal(distance).setScale(2,BigDecimal.ROUND_HALF_UP);
        return String.valueOf(bigDecimal);
    }
}
