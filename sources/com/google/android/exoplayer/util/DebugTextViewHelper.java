package com.google.android.exoplayer.util;

import android.widget.TextView;
import com.google.android.exoplayer.a;
import com.google.android.exoplayer.chunk.f;
import com.google.android.exoplayer.upstream.BandwidthMeter;

public final class DebugTextViewHelper implements Runnable {
    private final TextView a;
    private final Provider b;

    public interface Provider {
        BandwidthMeter getBandwidthMeter();

        a getCodecCounters();

        long getCurrentPosition();

        f getFormat();
    }

    private String a() {
        return b() + " " + c() + " " + d() + " " + e();
    }

    private String b() {
        return "ms(" + this.b.getCurrentPosition() + ")";
    }

    private String c() {
        f format = this.b.getFormat();
        return format == null ? "id:? br:? h:?" : "id:" + format.a + " br:" + format.c + " h:" + format.e;
    }

    private String d() {
        BandwidthMeter bandwidthMeter = this.b.getBandwidthMeter();
        return (bandwidthMeter == null || bandwidthMeter.getBitrateEstimate() == -1) ? "bw:?" : "bw:" + (bandwidthMeter.getBitrateEstimate() / 1000);
    }

    private String e() {
        a codecCounters = this.b.getCodecCounters();
        return codecCounters == null ? "" : codecCounters.b();
    }

    public void run() {
        this.a.setText(a());
        this.a.postDelayed(this, 1000);
    }
}
