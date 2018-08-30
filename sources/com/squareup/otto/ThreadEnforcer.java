package com.squareup.otto;

import android.os.Looper;

public interface ThreadEnforcer {
    public static final ThreadEnforcer a = new ThreadEnforcer() {
        public void enforce(b bVar) {
        }
    };
    public static final ThreadEnforcer b = new ThreadEnforcer() {
        public void enforce(b bVar) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("Event bus " + bVar + " accessed from non-main thread " + Looper.myLooper());
            }
        }
    };

    void enforce(b bVar);
}
