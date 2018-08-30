package com.mopub.mobileads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.appnext.base.b.c;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.CloseableLayout.OnCloseListener;
import com.mopub.common.DataKeys;

abstract class d extends Activity {
    protected AdReport a;
    private CloseableLayout b;
    private Long c;

    d() {
    }

    protected static Long a(Intent intent) {
        return intent.hasExtra(DataKeys.BROADCAST_IDENTIFIER_KEY) ? Long.valueOf(intent.getLongExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, -1)) : null;
    }

    @Nullable
    protected static AdReport b(Intent intent) {
        try {
            return (AdReport) intent.getSerializableExtra(DataKeys.AD_REPORT_KEY);
        } catch (ClassCastException e) {
            return null;
        }
    }

    Long a() {
        return this.c;
    }

    protected void b() {
        this.b.setCloseVisible(true);
    }

    protected void c() {
        this.b.setCloseVisible(false);
    }

    public abstract View getAdView();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.c = a(intent);
        this.a = b(intent);
        requestWindowFeature(1);
        getWindow().addFlags(c.jk);
        View adView = getAdView();
        this.b = new CloseableLayout(this);
        this.b.setOnCloseListener(new OnCloseListener() {
            public void onClose() {
                d.this.finish();
            }
        });
        this.b.addView(adView, new LayoutParams(-1, -1));
        setContentView(this.b);
    }

    protected void onDestroy() {
        this.b.removeAllViews();
        super.onDestroy();
    }
}
