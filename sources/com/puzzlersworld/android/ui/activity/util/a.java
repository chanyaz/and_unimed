package com.puzzlersworld.android.ui.activity.util;

import com.appnext.base.b.c;
import com.puzzlersworld.wp.dto.StringConstants;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class a {
    public static final List<Long> a = Arrays.asList(new Long[]{Long.valueOf(TimeUnit.DAYS.toMillis(365)), Long.valueOf(TimeUnit.DAYS.toMillis(30)), Long.valueOf(TimeUnit.DAYS.toMillis(1)), Long.valueOf(TimeUnit.HOURS.toMillis(1)), Long.valueOf(TimeUnit.MINUTES.toMillis(1)), Long.valueOf(TimeUnit.SECONDS.toMillis(1))});
    public static List<String> b = Arrays.asList(new String[]{"year", c.js, c.jr, c.jq, c.jp, c.jo});
    public static List<String> c = Arrays.asList(new String[]{"year", c.js, c.jr, c.jq, c.jp, c.jo});

    public static String a(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a.size()) {
                break;
            }
            long longValue = j / ((Long) a.get(i2)).longValue();
            if (longValue > 0) {
                stringBuffer.append(longValue).append(" ");
                if (longValue > 1) {
                    stringBuffer.append((String) c.get(i2));
                } else {
                    stringBuffer.append((String) b.get(i2));
                }
                stringBuffer.append(" ");
                stringBuffer.append(StringConstants.AGO.getMessage());
            } else {
                i = i2 + 1;
            }
        }
        return "".equals(stringBuffer.toString()) ? "0 " + StringConstants.SECOND.getMessage() + " " + StringConstants.AGO.getMessage() : stringBuffer.toString();
    }

    public static void a() {
        b = Arrays.asList(new String[]{StringConstants.YEAR.getMessage(), StringConstants.MONTH.getMessage(), StringConstants.DAY.getMessage(), StringConstants.HOUR.getMessage(), StringConstants.MINUTE.getMessage(), StringConstants.SECOND.getMessage()});
        c = Arrays.asList(new String[]{StringConstants.YEARS.getMessage(), StringConstants.MONTHS.getMessage(), StringConstants.DAYS.getMessage(), StringConstants.HOURS.getMessage(), StringConstants.MINUTES.getMessage(), StringConstants.SECONDS.getMessage()});
    }
}
