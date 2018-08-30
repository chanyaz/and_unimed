package com.mopub.common.logging;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

final class a extends Handler {
    private static final Map<Level, Integer> a = new HashMap(7);

    static {
        a.put(Level.FINEST, Integer.valueOf(2));
        a.put(Level.FINER, Integer.valueOf(2));
        a.put(Level.FINE, Integer.valueOf(2));
        a.put(Level.CONFIG, Integer.valueOf(3));
        a.put(Level.INFO, Integer.valueOf(4));
        a.put(Level.WARNING, Integer.valueOf(5));
        a.put(Level.SEVERE, Integer.valueOf(6));
    }

    private a() {
    }

    public void close() {
    }

    public void flush() {
    }

    @SuppressLint({"LogTagMismatch"})
    public void publish(LogRecord logRecord) {
        if (isLoggable(logRecord)) {
            int intValue = a.containsKey(logRecord.getLevel()) ? ((Integer) a.get(logRecord.getLevel())).intValue() : 2;
            String str = logRecord.getMessage() + "\n";
            Throwable thrown = logRecord.getThrown();
            if (thrown != null) {
                str = str + Log.getStackTraceString(thrown);
            }
            Log.println(intValue, "MoPub", str);
        }
    }
}
