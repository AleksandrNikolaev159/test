package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilDate.class);
    private static final String DATE_FORMAT = "dd-MM-yyyy";

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

    public static Date getDateOfString(String dateStr) {
        try {
            return new Timestamp(simpleDateFormat.parse(dateStr).getTime());
        } catch (ParseException e) {
            LOGGER.error("Error parse date", e);
        }
        return new Date();
    }

    public static String getStringOfDate(Date date) {
        return simpleDateFormat.format(date);
    }
}
