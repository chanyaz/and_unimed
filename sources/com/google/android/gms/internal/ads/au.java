package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.ac;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class au {
    private final Object a = new Object();
    private final Context b;
    private final ada c;
    private final gs d;
    private final ana e;
    private final ac f;
    private OnGlobalLayoutListener g;
    private OnScrollChangedListener h;
    private final DisplayMetrics i;
    private jq j;
    @GuardedBy("mLock")
    private int k = -1;
    @GuardedBy("mLock")
    private int l = -1;

    public au(Context context, ada ada, gs gsVar, ana ana, ac acVar) {
        this.b = context;
        this.c = ada;
        this.d = gsVar;
        this.e = ana;
        this.f = acVar;
        this.j = new jq(200);
        com.google.android.gms.ads.internal.au.e();
        this.i = ht.a((WindowManager) context.getSystemService("window"));
    }

    private final void a(WeakReference<zzaqw> weakReference, boolean z) {
        if (weakReference != null) {
            zzaqw zzaqw = (zzaqw) weakReference.get();
            if (zzaqw != null && zzaqw.getView() != null) {
                if (!z || this.j.a()) {
                    int[] iArr = new int[2];
                    zzaqw.getView().getLocationOnScreen(iArr);
                    akc.a();
                    int b = kb.b(this.i, iArr[0]);
                    akc.a();
                    int b2 = kb.b(this.i, iArr[1]);
                    synchronized (this.a) {
                        if (!(this.k == b && this.l == b2)) {
                            this.k = b;
                            this.l = b2;
                            zzaqw.zzuf().zza(this.k, this.l, !z);
                        }
                    }
                }
            }
        }
    }
}
