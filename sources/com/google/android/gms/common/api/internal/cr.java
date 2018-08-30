package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.a;
import java.util.Collections;
import java.util.Map;

final class cr implements OnCompleteListener<Map<bz<?>, String>> {
    private SignInConnectionListener a;
    private final /* synthetic */ co b;

    cr(co coVar, SignInConnectionListener signInConnectionListener) {
        this.b = coVar;
        this.a = signInConnectionListener;
    }

    final void a() {
        this.a.onComplete();
    }

    public final void onComplete(@NonNull a<Map<bz<?>, String>> aVar) {
        this.b.f.lock();
        try {
            if (this.b.n) {
                if (aVar.b()) {
                    this.b.p = new android.support.v4.util.a(this.b.b.size());
                    for (cn b : this.b.b.values()) {
                        this.b.p.put(b.b(), ConnectionResult.a);
                    }
                } else if (aVar.e() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) aVar.e();
                    if (this.b.l) {
                        this.b.p = new android.support.v4.util.a(this.b.b.size());
                        for (cn cnVar : this.b.b.values()) {
                            bz b2 = cnVar.b();
                            ConnectionResult a = availabilityException.a(cnVar);
                            if (this.b.a(cnVar, a)) {
                                this.b.p.put(b2, new ConnectionResult(16));
                            } else {
                                this.b.p.put(b2, a);
                            }
                        }
                    } else {
                        this.b.p = availabilityException.a();
                    }
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", aVar.e());
                    this.b.p = Collections.emptyMap();
                }
                if (this.b.isConnected()) {
                    this.b.o.putAll(this.b.p);
                    if (this.b.d() == null) {
                        this.b.b();
                        this.b.c();
                        this.b.i.signalAll();
                    }
                }
                this.a.onComplete();
                this.b.f.unlock();
                return;
            }
            this.a.onComplete();
        } finally {
            this.b.f.unlock();
        }
    }
}
