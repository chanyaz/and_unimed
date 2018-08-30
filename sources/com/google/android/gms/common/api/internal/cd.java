package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.atomic.AtomicReference;

public abstract class cd extends LifecycleCallback implements OnCancelListener {
    protected volatile boolean b;
    protected final AtomicReference<ce> c;
    protected final e d;
    private final Handler e;

    protected cd(LifecycleFragment lifecycleFragment) {
        this(lifecycleFragment, e.a());
    }

    @VisibleForTesting
    private cd(LifecycleFragment lifecycleFragment, e eVar) {
        super(lifecycleFragment);
        this.c = new AtomicReference(null);
        this.e = new Handler(Looper.getMainLooper());
        this.d = eVar;
    }

    private static int a(@Nullable ce ceVar) {
        return ceVar == null ? -1 : ceVar.a();
    }

    public final void a(int r7, int r8, android.content.Intent r9) {
        /*
        r6 = this;
        r5 = 18;
        r1 = 13;
        r2 = 1;
        r3 = 0;
        r0 = r6.c;
        r0 = r0.get();
        r0 = (com.google.android.gms.common.api.internal.ce) r0;
        switch(r7) {
            case 1: goto L_0x0034;
            case 2: goto L_0x0018;
            default: goto L_0x0011;
        };
    L_0x0011:
        r1 = r3;
    L_0x0012:
        if (r1 == 0) goto L_0x005a;
    L_0x0014:
        r6.h();
    L_0x0017:
        return;
    L_0x0018:
        r1 = r6.d;
        r4 = r6.a();
        r4 = r1.a(r4);
        if (r4 != 0) goto L_0x0068;
    L_0x0024:
        r1 = r2;
    L_0x0025:
        if (r0 == 0) goto L_0x0017;
    L_0x0027:
        r2 = r0.b();
        r2 = r2.c();
        if (r2 != r5) goto L_0x0012;
    L_0x0031:
        if (r4 != r5) goto L_0x0012;
    L_0x0033:
        goto L_0x0017;
    L_0x0034:
        r4 = -1;
        if (r8 != r4) goto L_0x0039;
    L_0x0037:
        r1 = r2;
        goto L_0x0012;
    L_0x0039:
        if (r8 != 0) goto L_0x0011;
    L_0x003b:
        if (r9 == 0) goto L_0x0043;
    L_0x003d:
        r2 = "<<ResolutionFailureErrorDetail>>";
        r1 = r9.getIntExtra(r2, r1);
    L_0x0043:
        r2 = new com.google.android.gms.common.api.internal.ce;
        r4 = new com.google.android.gms.common.ConnectionResult;
        r5 = 0;
        r4.<init>(r1, r5);
        r0 = a(r0);
        r2.<init>(r4, r0);
        r0 = r6.c;
        r0.set(r2);
        r0 = r2;
        r1 = r3;
        goto L_0x0012;
    L_0x005a:
        if (r0 == 0) goto L_0x0017;
    L_0x005c:
        r1 = r0.b();
        r0 = r0.a();
        r6.a(r1, r0);
        goto L_0x0017;
    L_0x0068:
        r1 = r3;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.cd.a(int, int, android.content.Intent):void");
    }

    public final void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null) {
            this.c.set(bundle.getBoolean("resolving_error", false) ? new ce(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    protected abstract void a(ConnectionResult connectionResult, int i);

    public void b() {
        super.b();
        this.b = true;
    }

    public final void b(Bundle bundle) {
        super.b(bundle);
        ce ceVar = (ce) this.c.get();
        if (ceVar != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", ceVar.a());
            bundle.putInt("failed_status", ceVar.b().c());
            bundle.putParcelable("failed_resolution", ceVar.b().d());
        }
    }

    public final void b(ConnectionResult connectionResult, int i) {
        ce ceVar = new ce(connectionResult, i);
        if (this.c.compareAndSet(null, ceVar)) {
            this.e.post(new cf(this, ceVar));
        }
    }

    public void d() {
        super.d();
        this.b = false;
    }

    protected abstract void f();

    protected final void h() {
        this.c.set(null);
        f();
    }

    public void onCancel(DialogInterface dialogInterface) {
        a(new ConnectionResult(13, null), a((ce) this.c.get()));
        h();
    }
}
