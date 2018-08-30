package android.support.v4.text;

import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

public final class a {
    private static Method a;
    private static Method b;

    static {
        if (VERSION.SDK_INT >= 21) {
            try {
                b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
                return;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                a = cls.getMethod("getScript", new Class[]{String.class});
                b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e2) {
            a = null;
            b = null;
            Log.w("ICUCompat", e2);
        }
    }

    private a() {
    }

    private static String a(String str) {
        try {
            if (a != null) {
                return (String) a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompat", e);
        } catch (Throwable e2) {
            Log.w("ICUCompat", e2);
        }
        return null;
    }

    @Nullable
    public static String a(Locale locale) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) b.invoke(null, new Object[]{locale})).getScript();
            } catch (Throwable e) {
                Log.w("ICUCompat", e);
            } catch (Throwable e2) {
                Log.w("ICUCompat", e2);
            }
        } else {
            String b = b(locale);
            return b != null ? a(b) : null;
        }
        return locale.getScript();
    }

    private static String b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (b != null) {
                return (String) b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompat", e);
        } catch (Throwable e2) {
            Log.w("ICUCompat", e2);
        }
        return locale2;
    }
}
