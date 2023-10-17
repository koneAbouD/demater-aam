package africa.box.dm.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatter {

    private final static String DATE_FORMAT = "yyyy/MM/dd";
    private final static String DATE_TIME_FORMAT = "yyyy/MM/dd h:m a";

    private final static DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_FORMAT).withZone(ZoneId.systemDefault());

    private final static DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_TIME_FORMAT).withZone(ZoneId.systemDefault());

    private DateFormatter() {}

    public static LocalDate toDate(String date) {
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    public static LocalDateTime toDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
    }

    public static String localDate(){
        return DATE_FORMATTER.format(LocalDate.now());
    }

    public static String localDateTime(){
        return DATE_TIME_FORMATTER.format(LocalDate.now());
    }
}
