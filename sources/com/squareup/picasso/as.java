package com.squareup.picasso;

import android.os.Process;

class as extends Thread {
    public as(Runnable runnable) {
        super(runnable);
    }

    public void run() {
        Process.setThreadPriority(10);
        super.run();
    }
}
