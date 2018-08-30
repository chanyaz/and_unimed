package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.annotation.GuardedBy;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.gmsg.zzv;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public abstract class asn<ReferenceT> {
    @GuardedBy("this")
    private final Map<String, CopyOnWriteArrayList<zzv<? super ReferenceT>>> a = new HashMap();

    private final synchronized void a(String str, Map<String, String> map) {
        if (kk.a(2)) {
            String str2 = "Received GMSG: ";
            String valueOf = String.valueOf(str);
            hl.a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            for (String valueOf2 : map.keySet()) {
                str2 = (String) map.get(valueOf2);
                hl.a(new StringBuilder((String.valueOf(valueOf2).length() + 4) + String.valueOf(str2).length()).append("  ").append(valueOf2).append(": ").append(str2).toString());
            }
        }
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(str);
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                lf.a.execute(new aso(this, (zzv) it.next(), map));
            }
        }
    }

    public final synchronized void a(String str, Predicate<zzv<? super ReferenceT>> predicate) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(str);
        if (copyOnWriteArrayList != null) {
            Collection arrayList = new ArrayList();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                zzv zzv = (zzv) it.next();
                if (predicate.apply(zzv)) {
                    arrayList.add(zzv);
                }
            }
            copyOnWriteArrayList.removeAll(arrayList);
        }
    }

    public final boolean a(Uri uri) {
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            return false;
        }
        String path = uri.getPath();
        au.e();
        a(path, ht.a(uri));
        return true;
    }

    public synchronized void d() {
        this.a.clear();
    }

    public abstract ReferenceT f();

    public final synchronized void zza(String str, zzv<? super ReferenceT> zzv) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.a.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(zzv);
    }

    public final synchronized void zzb(String str, zzv<? super ReferenceT> zzv) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(zzv);
        }
    }
}
