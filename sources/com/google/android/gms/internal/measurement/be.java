package com.google.android.gms.internal.measurement;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

final class be implements Logger {
    private int a = 2;
    private boolean b;

    be() {
    }

    public final void error(Exception exception) {
    }

    public final void error(String str) {
    }

    public final int getLogLevel() {
        return this.a;
    }

    public final void info(String str) {
    }

    public final void setLogLevel(int i) {
        this.a = i;
        if (!this.b) {
            String str = (String) bk.b.a();
            Log.i((String) bk.b.a(), new StringBuilder(String.valueOf(str).length() + 91).append("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append(str).append(" DEBUG").toString());
            this.b = true;
        }
    }

    public final void verbose(String str) {
    }

    public final void warn(String str) {
    }
}
