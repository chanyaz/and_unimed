package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class gq implements Runnable {
    private final /* synthetic */ Context a;
    private final /* synthetic */ lk b;

    gq(gp gpVar, Context context, lk lkVar) {
        this.a = context;
        this.b = lkVar;
    }

    public final void run() {
        Throwable e;
        try {
            this.b.b(AdvertisingIdClient.getAdvertisingIdInfo(this.a));
            return;
        } catch (IOException e2) {
            e = e2;
        } catch (IllegalStateException e3) {
            e = e3;
        } catch (GooglePlayServicesNotAvailableException e4) {
            e = e4;
        } catch (GooglePlayServicesRepairableException e5) {
            e = e5;
        }
        this.b.a(e);
        kk.b("Exception while getting advertising Id info", e);
    }
}
