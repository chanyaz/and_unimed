package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class jb {
    private static ast a;
    private static final Object b = new Object();
    @Deprecated
    private static final zzalz<Void> c = new jc();

    public jb(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        a(context);
    }

    @VisibleForTesting
    private static ast a(Context context) {
        ast a;
        synchronized (b) {
            if (a == null) {
                amn.a(context);
                if (((Boolean) akc.f().a(amn.cI)).booleanValue()) {
                    a = iw.a(context);
                } else {
                    a = new ast(new jh(new File(context.getCacheDir(), "volley")), new gl(new on()));
                    a.a();
                }
                a = a;
            }
            a = a;
        }
        return a;
    }

    public final zzanz<String> a(int i, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        Object jiVar = new ji();
        zzy jfVar = new jf(this, str, jiVar);
        ke keVar = new ke(null);
        apk jgVar = new jg(this, i, str, jiVar, jfVar, bArr, map, keVar);
        if (ke.c()) {
            try {
                keVar.a(str, "GET", jgVar.b(), jgVar.a());
            } catch (Throwable e) {
                kk.e(e.getMessage());
            }
        }
        a.a(jgVar);
        return jiVar;
    }

    @Deprecated
    public final <T> zzanz<T> a(String str, zzalz<T> zzalz) {
        zzanz lkVar = new lk();
        a.a(new jj(str, lkVar));
        return kq.a(kq.a(lkVar, new je(this, zzalz), hr.a), Throwable.class, new jd(this, zzalz), lf.b);
    }

    public final zzanz<String> a(String str, Map<String, String> map) {
        return a(0, str, map, null);
    }
}
