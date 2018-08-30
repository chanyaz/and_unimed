package com.mopub.common.logging;

import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MoPubLog {
    public static final String LOGGER_NAMESPACE = "com.mopub";
    private static final Logger a = Logger.getLogger(LOGGER_NAMESPACE);
    private static final a b = new a();

    static {
        a.setUseParentHandlers(false);
        a.setLevel(Level.ALL);
        b.setLevel(Level.FINE);
        LogManager.getLogManager().addLogger(a);
        a(a, b);
    }

    private MoPubLog() {
    }

    private static void a(@NonNull Logger logger, @NonNull Handler handler) {
        Handler[] handlers = logger.getHandlers();
        int length = handlers.length;
        int i = 0;
        while (i < length) {
            if (!handlers[i].equals(handler)) {
                i++;
            } else {
                return;
            }
        }
        logger.addHandler(handler);
    }

    public static void c(String str) {
        c(str, null);
    }

    public static void c(String str, Throwable th) {
        a.log(Level.FINEST, str, th);
    }

    public static void d(String str) {
        d(str, null);
    }

    public static void d(String str, Throwable th) {
        a.log(Level.CONFIG, str, th);
    }

    public static void e(String str) {
        e(str, null);
    }

    public static void e(String str, Throwable th) {
        a.log(Level.SEVERE, str, th);
    }

    public static void i(String str) {
        i(str, null);
    }

    public static void i(String str, Throwable th) {
        a.log(Level.INFO, str, th);
    }

    @VisibleForTesting
    public static void setSdkHandlerLevel(@NonNull Level level) {
        b.setLevel(level);
    }

    public static void v(String str) {
        v(str, null);
    }

    public static void v(String str, Throwable th) {
        a.log(Level.FINE, str, th);
    }

    public static void w(String str) {
        w(str, null);
    }

    public static void w(String str, Throwable th) {
        a.log(Level.WARNING, str, th);
    }
}
