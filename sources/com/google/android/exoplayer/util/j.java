package com.google.android.exoplayer.util;

import android.os.HandlerThread;
import android.os.Process;

public final class j extends HandlerThread {
    private final int a;

    public j(String str, int i) {
        super(str);
        this.a = i;
    }

    public void run() {
        Process.setThreadPriority(this.a);
        super.run();
    }
}
