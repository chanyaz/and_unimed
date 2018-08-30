package com.appnext.base.b;

import java.util.Calendar;
import java.util.Date;

public class m {
    public static Date d(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return instance.getTime();
    }
}
