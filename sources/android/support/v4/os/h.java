package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Trace;

public final class h {
    private h() {
    }

    public static void a() {
        if (VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static void a(String str) {
        if (VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }
}
