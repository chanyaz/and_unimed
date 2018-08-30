package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ad implements OnTouchListener {
    final /* synthetic */ VastWebView a;
    private boolean b;

    ad(VastWebView vastWebView) {
        this.a = vastWebView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.b = true;
                break;
            case 1:
                if (this.b) {
                    this.b = false;
                    if (this.a.b != null) {
                        this.a.b.onVastWebViewClick();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
