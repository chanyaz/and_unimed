package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.util.List;

final class wm extends wj {
    private final wk a = new wk();

    wm() {
    }

    public final void a(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        List<Throwable> a = this.a.a(th, false);
        if (a != null) {
            synchronized (a) {
                for (Throwable th2 : a) {
                    printWriter.print("Suppressed: ");
                    th2.printStackTrace(printWriter);
                }
            }
        }
    }
}
