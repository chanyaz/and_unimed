package com.google.firebase;

import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;

final class c implements BackgroundStateChangeListener {
    c() {
    }

    public final void onBackgroundStateChanged(boolean z) {
        FirebaseApp.a(z);
    }
}
