package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class hk extends hg {
    private Context a;

    hk(Context context) {
        this.a = context;
    }

    public final void a() {
        boolean isAdIdFakeForDebugLogging;
        Throwable e;
        try {
            isAdIdFakeForDebugLogging = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.a);
        } catch (IOException e2) {
            e = e2;
        } catch (IllegalStateException e3) {
            e = e3;
        } catch (GooglePlayServicesNotAvailableException e4) {
            e = e4;
        } catch (GooglePlayServicesRepairableException e5) {
            e = e5;
        }
        ke.a(isAdIdFakeForDebugLogging);
        kk.e("Update ad debug logging enablement as " + isAdIdFakeForDebugLogging);
        kk.b("Fail to get isAdIdFakeForDebugLogging", e);
        isAdIdFakeForDebugLogging = false;
        ke.a(isAdIdFakeForDebugLogging);
        kk.e("Update ad debug logging enablement as " + isAdIdFakeForDebugLogging);
    }

    public final void b() {
    }
}
