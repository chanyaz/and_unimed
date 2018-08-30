package com.appnext.base.operations.imp;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import com.appnext.base.a.b.b;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.b.g;
import com.appnext.base.b.j;
import com.appnext.base.operations.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class geo extends c implements j.c {
    private static final String KEY = geo.class.getSimpleName();
    private j gZ;
    private List<b> ha;

    public geo(com.appnext.base.a.b.c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    public void a(final Location location) {
        this.gZ.a(null);
        g.cC().b(new Runnable() {
            public void run() {
                try {
                    if (location != null) {
                        List fromLocation = new Geocoder(d.getContext(), Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        if (fromLocation != null && fromLocation.size() > 0) {
                            geo.this.ha = new ArrayList();
                            geo.this.ha.add(new b(geo.KEY, geo.class.getSimpleName() + "ci", ((Address) fromLocation.get(0)).getLocality(), a.String.getType()));
                            geo.this.ha.add(new b(geo.KEY, geo.class.getSimpleName() + "co", ((Address) fromLocation.get(0)).getCountryCode(), a.String.getType()));
                        }
                    }
                } catch (Throwable th) {
                    com.appnext.base.b.a(th);
                }
                geo.this.b();
            }
        });
    }

    protected String aX() {
        return geo.class.getSimpleName();
    }

    public void bB() {
        try {
            if (hasPermission()) {
                synchronized (this) {
                    this.gZ = new j();
                    this.gZ.a((j.c) this);
                    this.gZ.init();
                }
                return;
            }
            com.appnext.base.operations.d.bG().a(this);
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
    }

    public void bC() {
        synchronized (this) {
            if (this.gZ != null) {
                this.gZ.a(null);
                this.gZ.cF();
                this.gZ = null;
            }
        }
    }

    protected boolean bF() {
        return false;
    }

    protected boolean bv() {
        return true;
    }

    protected List<b> getData() {
        return this.ha;
    }

    public boolean hasPermission() {
        return bE() && (f.g(d.getContext(), "android.permission.ACCESS_FINE_LOCATION") || f.g(d.getContext(), "android.permission.ACCESS_COARSE_LOCATION"));
    }

    public void onError(String str) {
        if (this.gZ != null) {
            this.gZ.a(null);
        }
        com.appnext.base.operations.d.bG().a(this);
    }
}
