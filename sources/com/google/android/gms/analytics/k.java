package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.ah;
import com.google.android.gms.internal.measurement.t;
import com.google.android.gms.internal.measurement.x;
import java.util.ListIterator;

@VisibleForTesting
public class k extends s<k> {
    private final ah b;
    private boolean c;

    @VisibleForTesting
    public k(ah ahVar) {
        super(ahVar.g(), ahVar.c());
        this.b = ahVar;
    }

    protected final void a(q qVar) {
        t tVar = (t) qVar.b(t.class);
        if (TextUtils.isEmpty(tVar.b())) {
            tVar.b(this.b.o().b());
        }
        if (this.c && TextUtils.isEmpty(tVar.d())) {
            x n = this.b.n();
            tVar.d(n.c());
            tVar.a(n.b());
        }
    }

    public final void a(String str) {
        ar.a(str);
        Uri a = l.a(str);
        ListIterator listIterator = this.a.c().listIterator();
        while (listIterator.hasNext()) {
            if (a.equals(((zzo) listIterator.next()).zzk())) {
                listIterator.remove();
            }
        }
        this.a.c().add(new l(this.b, str));
    }

    public final void b(boolean z) {
        this.c = z;
    }

    @VisibleForTesting
    final ah g() {
        return this.b;
    }

    public final q h() {
        q a = this.a.a();
        a.a(this.b.p().b());
        a.a(this.b.q().b());
        b(a);
        return a;
    }
}
