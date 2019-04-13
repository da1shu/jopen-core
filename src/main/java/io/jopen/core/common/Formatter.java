package io.jopen.core.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author maxuefeng
 */
public class Formatter {


    // 几天前

    // 几小时前

    // 几分钟前

    public static String of(long timestamp, String P) {

        //
        DateTimeFormatter f = DateTimeFormatter.ofPattern(P);
        //
        LocalDateTime dateTime = LocalDateTimeUtil.toLocalDateTime(timestamp);

        return dateTime.format(f);
    }

    public static String of(LocalDateTime dateTime, String P) {

        //
        DateTimeFormatter f = DateTimeFormatter.ofPattern(P);
        return dateTime.format(f);
    }
}
