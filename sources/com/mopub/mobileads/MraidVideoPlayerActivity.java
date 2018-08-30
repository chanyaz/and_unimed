package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.appnext.base.b.c;
import com.mopub.common.AdType;
import com.mopub.common.DataKeys;
import com.mopub.common.FullAdType;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener;
import com.mopub.mraid.MraidVideoViewController;
import com.mopub.nativeads.NativeVideoViewController;

public class MraidVideoPlayerActivity extends BaseVideoPlayerActivity implements BaseVideoViewControllerListener {
    @Nullable
    private BaseVideoViewController a;
    private long b;

    protected static long a(Intent intent) {
        return intent.getLongExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, -1);
    }

    private BaseVideoViewController a(Bundle bundle) {
        String stringExtra = getIntent().getStringExtra(BaseVideoPlayerActivity.VIDEO_CLASS_EXTRAS_KEY);
        if (FullAdType.VAST.equals(stringExtra)) {
            return new VastVideoViewController(this, getIntent().getExtras(), bundle, this.b, this);
        } else if (AdType.MRAID.equals(stringExtra)) {
            return new MraidVideoViewController(this, getIntent().getExtras(), bundle, this);
        } else {
            if ("native".equals(stringExtra)) {
                return new NativeVideoViewController(this, getIntent().getExtras(), bundle, this);
            }
            throw new IllegalStateException("Unsupported video type: " + stringExtra);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.a != null) {
            this.a.a(i, i2, intent);
        }
    }

    public void onBackPressed() {
        if (this.a != null && this.a.backButtonEnabled()) {
            super.onBackPressed();
            this.a.f();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.a != null) {
            this.a.a(configuration);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(c.jk);
        this.b = a(getIntent());
        try {
            this.a = a(bundle);
            this.a.a();
        } catch (IllegalStateException e) {
            BaseBroadcastReceiver.a(this, this.b, EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_FAIL);
            finish();
        }
    }

    protected void onDestroy() {
        if (this.a != null) {
            this.a.e();
        }
        super.onDestroy();
    }

    public void onFinish() {
        finish();
    }

    protected void onPause() {
        if (this.a != null) {
            this.a.c();
        }
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.d();
        }
    }

    protected void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.a != null) {
            this.a.a(bundle);
        }
    }

    public void onSetContentView(View view) {
        setContentView(view);
    }

    public void onSetRequestedOrientation(int i) {
        setRequestedOrientation(i);
    }

    public void onStartActivityForResult(Class<? extends Activity> cls, int i, Bundle bundle) {
        if (cls != null) {
            try {
                startActivityForResult(Intents.getStartActivityIntent(this, cls, bundle), i);
            } catch (ActivityNotFoundException e) {
                MoPubLog.d("Activity " + cls.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
            }
        }
    }
}
