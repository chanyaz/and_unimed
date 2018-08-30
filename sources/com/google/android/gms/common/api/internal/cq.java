package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.a;
import java.util.Collections;
import java.util.Map;

final class cq implements OnCompleteListener<Map<bz<?>, String>> {
    private final /* synthetic */ co a;

    private cq(co coVar) {
        this.a = coVar;
    }

    public final void onComplete(@NonNull a<Map<bz<?>, String>> aVar) {
        this.a.f.lock();
        try {
            if (this.a.n) {
                if (aVar.b()) {
                    this.a.o = new android.support.v4.util.a(this.a.a.size());
                    for (cn b : this.a.a.values()) {
                        this.a.o.put(b.b(), ConnectionResult.a);
                    }
                } else if (aVar.e() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) aVar.e();
                    if (this.a.l) {
                        this.a.o = new android.support.v4.util.a(this.a.a.size());
                        for (cn cnVar : this.a.a.values()) {
                            bz b2 = cnVar.b();
                            ConnectionResult a = availabilityException.a(cnVar);
                            if (this.a.a(cnVar, a)) {
                                this.a.o.put(b2, new ConnectionResult(16));
                            } else {
                                this.a.o.put(b2, a);
                            }
                        }
                    } else {
                        this.a.o = availabilityException.a();
                    }
                    this.a.r = this.a.d();
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", aVar.e());
                    this.a.o = Collections.emptyMap();
                    this.a.r = new ConnectionResult(8);
                }
                if (this.a.p != null) {
                    this.a.o.putAll(this.a.p);
                    this.a.r = this.a.d();
                }
                if (this.a.r == null) {
                    this.a.b();
                    this.a.c();
                } else {
                    this.a.n = false;
                    this.a.e.zzc(this.a.r);
                }
                this.a.i.signalAll();
                this.a.f.unlock();
            }
        } finally {
            this.a.f.unlock();
        }
    }
}
