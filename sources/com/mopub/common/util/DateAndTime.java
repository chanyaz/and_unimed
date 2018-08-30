package com.mopub.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateAndTime {
    protected static DateAndTime a = new DateAndTime();

    public static String getTimeZoneOffsetString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("Z", Locale.US);
        simpleDateFormat.setTimeZone(localTimeZone());
        return simpleDateFormat.format(now());
    }

    public static TimeZone localTimeZone() {
        return a.internalLocalTimeZone();
    }

    public static Date now() {
        return a.internalNow();
    }

    @Deprecated
    public static void setInstance(DateAndTime dateAndTime) {
        a = dateAndTime;
    }

    public TimeZone internalLocalTimeZone() {
        return TimeZone.getDefault();
    }

    public Date internalNow() {
        return new Date();
    }
}
