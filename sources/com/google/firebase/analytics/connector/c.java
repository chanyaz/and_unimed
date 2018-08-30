package com.google.firebase.analytics.connector;

import android.util.Log;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import com.google.firebase.analytics.connector.internal.Adapter;

final class c implements AnalyticsConnectorHandle {
    private final /* synthetic */ String a;
    private final /* synthetic */ b b;

    c(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    public final void unregister() {
        if (this.b.a(this.a)) {
            AnalyticsConnectorListener listener = ((Adapter) this.b.a.get(this.a)).getListener();
            if (listener != null) {
                listener.onMessageTriggered(0, null);
            }
            this.b.a.remove(this.a);
            return;
        }
        Log.d("FA-C", "No listener registered");
    }
}
