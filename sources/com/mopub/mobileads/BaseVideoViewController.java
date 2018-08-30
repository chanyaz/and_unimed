package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.mopub.common.logging.MoPubLog;

public abstract class BaseVideoViewController {
    private final Context a;
    private final RelativeLayout b = new RelativeLayout(this.a);
    private final BaseVideoViewControllerListener c;
    @Nullable
    private Long d;

    public interface BaseVideoViewControllerListener {
        void onFinish();

        void onSetContentView(View view);

        void onSetRequestedOrientation(int i);

        void onStartActivityForResult(Class<? extends Activity> cls, int i, Bundle bundle);
    }

    protected BaseVideoViewController(Context context, @Nullable Long l, BaseVideoViewControllerListener baseVideoViewControllerListener) {
        this.a = context;
        this.d = l;
        this.c = baseVideoViewControllerListener;
    }

    protected void a() {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.b.addView(b(), 0, layoutParams);
        this.c.onSetContentView(this.b);
    }

    void a(int i, int i2, Intent intent) {
    }

    protected abstract void a(Configuration configuration);

    protected abstract void a(@NonNull Bundle bundle);

    void a(String str) {
        if (this.d != null) {
            BaseBroadcastReceiver.a(this.a, this.d.longValue(), str);
        } else {
            MoPubLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
    }

    protected void a(boolean z) {
        MoPubLog.e("Video cannot be played.");
        a(EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_FAIL);
        if (z) {
            this.c.onFinish();
        }
    }

    protected abstract VideoView b();

    protected void b(boolean z) {
        if (z) {
            this.c.onFinish();
        }
    }

    public boolean backButtonEnabled() {
        return true;
    }

    protected abstract void c();

    protected abstract void d();

    protected abstract void e();

    protected abstract void f();

    /* renamed from: g */
    protected BaseVideoViewControllerListener d() {
        return this.c;
    }

    public ViewGroup getLayout() {
        return this.b;
    }

    /* renamed from: h */
    protected Context f() {
        return this.a;
    }
}
