package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.IOException;

public final class aei extends aez {
    public aei(adn adn, String str, String str2, wr wrVar, int i, int i2) {
        super(adn, str, str2, wrVar, i, 24);
    }

    private final void c() {
        AdvertisingIdClient m = this.a.m();
        if (m != null) {
            try {
                Info info = m.getInfo();
                String a = adw.a(info.getId());
                if (a != null) {
                    synchronized (this.b) {
                        this.b.T = a;
                        this.b.V = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                        this.b.U = Integer.valueOf(5);
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    protected final void a() {
        if (this.a.g()) {
            c();
            return;
        }
        synchronized (this.b) {
            this.b.T = (String) this.c.invoke(null, new Object[]{this.a.a()});
        }
    }

    public final Void b() {
        if (this.a.b()) {
            return super.call();
        }
        if (this.a.g()) {
            c();
        }
        return null;
    }
}
