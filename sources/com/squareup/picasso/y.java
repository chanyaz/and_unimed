package com.squareup.picasso;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import java.lang.ref.ReferenceQueue;

class y extends Thread {
    private final ReferenceQueue<Object> a;
    private final Handler b;

    y(ReferenceQueue<Object> referenceQueue, Handler handler) {
        this.a = referenceQueue;
        this.b = handler;
        setDaemon(true);
        setName("Picasso-refQueue");
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                b bVar = (b) this.a.remove(1000);
                Message obtainMessage = this.b.obtainMessage();
                if (bVar != null) {
                    obtainMessage.what = 3;
                    obtainMessage.obj = bVar.a;
                    this.b.sendMessage(obtainMessage);
                } else {
                    obtainMessage.recycle();
                }
            } catch (InterruptedException e) {
                return;
            } catch (final Exception e2) {
                this.b.post(new Runnable() {
                    public void run() {
                        throw new RuntimeException(e2);
                    }
                });
                return;
            }
        }
    }
}
