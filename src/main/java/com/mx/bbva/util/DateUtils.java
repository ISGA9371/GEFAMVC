package com.mx.bbva.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Date;

public class DateUtils {

    public Date getCurrentDate() {
        DateTime dateTime = new DateTime();
        DateTime dateTimeMexico = dateTime.withZone(DateTimeZone.forID("America/Mexico_City"));
        return dateTimeMexico.toLocalDateTime().toDate();
    }
}
