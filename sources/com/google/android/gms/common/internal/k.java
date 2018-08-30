package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.com/google/android/gms/common/internal/e;

abstract class k extends com/google/android/gms/common/internal/e<Boolean> {
    private final /* synthetic */ BaseGmsClient a;
    public final int b;
    public final Bundle c;

    @BinderThread
    protected k(BaseGmsClient baseGmsClient, int i, Bundle bundle) {
        this.a = baseGmsClient;
        super(baseGmsClient, Boolean.valueOf(true));
        this.b = i;
        this.c = bundle;
    }

    protected void a() {
    }

    protected abstract void a(ConnectionResult connectionResult);

    protected void a(Boolean bool) {
        PendingIntent pendingIntent = null;
        if (bool == null) {
            this.a.b(1, null);
            return;
        }
        switch (this.b) {
            case 0:
                if (!e()) {
                    this.a.b(1, null);
                    a(new ConnectionResult(8, null));
                    return;
                }
                return;
            case 10:
                this.a.b(1, null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                this.a.b(1, null);
                if (this.c != null) {
                    pendingIntent = (PendingIntent) this.c.getParcelable("pendingIntent");
                }
                a(new ConnectionResult(this.b, pendingIntent));
                return;
        }
    }

    protected abstract boolean e();
}
