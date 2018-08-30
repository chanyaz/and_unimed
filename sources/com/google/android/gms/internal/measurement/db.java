package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import java.util.Iterator;

public final class db {
    final String a;
    final String b;
    final long c;
    final long d;
    final zzer e;
    private final String f;

    db(es esVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzer zzer;
        ar.a(str2);
        ar.a(str3);
        this.a = str2;
        this.b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f = str;
        this.c = j;
        this.d = j2;
        if (this.d != 0 && this.d > this.c) {
            esVar.zzge().u().a("Event created with reverse previous/current timestamps. appId", dp.a(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzer = new zzer(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    esVar.zzge().r().a("Param name can't be null");
                    it.remove();
                } else {
                    Object a = esVar.k().a(str4, bundle2.get(str4));
                    if (a == null) {
                        esVar.zzge().u().a("Param value can't be null", esVar.l().b(str4));
                        it.remove();
                    } else {
                        esVar.k().a(bundle2, str4, a);
                    }
                }
            }
            zzer = new zzer(bundle2);
        }
        this.e = zzer;
    }

    private db(es esVar, String str, String str2, String str3, long j, long j2, zzer zzer) {
        ar.a(str2);
        ar.a(str3);
        ar.a((Object) zzer);
        this.a = str2;
        this.b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f = str;
        this.c = j;
        this.d = j2;
        if (this.d != 0 && this.d > this.c) {
            esVar.zzge().u().a("Event created with reverse previous/current timestamps. appId, name", dp.a(str2), dp.a(str3));
        }
        this.e = zzer;
    }

    final db a(es esVar, long j) {
        return new db(esVar, this.f, this.a, this.b, this.c, j, this.e);
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.b;
        String valueOf = String.valueOf(this.e);
        return new StringBuilder(((String.valueOf(str).length() + 33) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("Event{appId='").append(str).append("', name='").append(str2).append("', params=").append(valueOf).append('}').toString();
    }
}
