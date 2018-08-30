package android.support.v4.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.RequiresApi;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window.OnFrameMetricsAvailableListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RequiresApi(24)
class ag extends ah {
    private static HandlerThread e = null;
    private static Handler f = null;
    OnFrameMetricsAvailableListener a = new OnFrameMetricsAvailableListener() {
        public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
            if ((ag.this.b & 1) != 0) {
                ag.this.a(ag.this.c[0], frameMetrics.getMetric(8));
            }
            if ((ag.this.b & 2) != 0) {
                ag.this.a(ag.this.c[1], frameMetrics.getMetric(1));
            }
            if ((ag.this.b & 4) != 0) {
                ag.this.a(ag.this.c[2], frameMetrics.getMetric(3));
            }
            if ((ag.this.b & 8) != 0) {
                ag.this.a(ag.this.c[3], frameMetrics.getMetric(4));
            }
            if ((ag.this.b & 16) != 0) {
                ag.this.a(ag.this.c[4], frameMetrics.getMetric(5));
            }
            if ((ag.this.b & 64) != 0) {
                ag.this.a(ag.this.c[6], frameMetrics.getMetric(7));
            }
            if ((ag.this.b & 32) != 0) {
                ag.this.a(ag.this.c[5], frameMetrics.getMetric(6));
            }
            if ((ag.this.b & 128) != 0) {
                ag.this.a(ag.this.c[7], frameMetrics.getMetric(0));
            }
            if ((ag.this.b & 256) != 0) {
                ag.this.a(ag.this.c[8], frameMetrics.getMetric(2));
            }
        }
    };
    private int b;
    private SparseIntArray[] c = new SparseIntArray[9];
    private ArrayList<WeakReference<Activity>> d = new ArrayList();

    ag(int i) {
        super();
        this.b = i;
    }

    void a(SparseIntArray sparseIntArray, long j) {
        if (sparseIntArray != null) {
            int i = (int) ((500000 + j) / 1000000);
            if (j >= 0) {
                sparseIntArray.put(i, sparseIntArray.get(i) + 1);
            }
        }
    }
}
