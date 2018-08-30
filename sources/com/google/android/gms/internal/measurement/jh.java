package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.annotation.GuardedBy;
import android.util.Log;
import com.appnext.base.a.c.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class jh {
    private static final ConcurrentHashMap<Uri, jh> a = new ConcurrentHashMap();
    private static final String[] i = new String[]{c.gv, "value"};
    private final ContentResolver b;
    private final Uri c;
    private final ContentObserver d;
    private final Object e = new Object();
    private volatile Map<String, String> f;
    private final Object g = new Object();
    @GuardedBy("listenersLock")
    private final List<zzwr> h = new ArrayList();

    private jh(ContentResolver contentResolver, Uri uri) {
        this.b = contentResolver;
        this.c = uri;
        this.d = new ji(this, null);
    }

    public static jh a(ContentResolver contentResolver, Uri uri) {
        jh jhVar = (jh) a.get(uri);
        if (jhVar != null) {
            return jhVar;
        }
        jh jhVar2 = new jh(contentResolver, uri);
        jhVar = (jh) a.putIfAbsent(uri, jhVar2);
        if (jhVar != null) {
            return jhVar;
        }
        jhVar2.b.registerContentObserver(jhVar2.c, false, jhVar2.d);
        return jhVar2;
    }

    private final Map<String, String> c() {
        Cursor query;
        try {
            Map<String, String> hashMap = new HashMap();
            query = this.b.query(this.c, i, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    hashMap.put(query.getString(0), query.getString(1));
                }
                query.close();
            }
            return hashMap;
        } catch (SecurityException e) {
        } catch (SQLiteException e2) {
        } catch (Throwable th) {
            query.close();
        }
        Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
        return null;
    }

    private final void d() {
        synchronized (this.g) {
            for (zzwr zzrx : this.h) {
                zzrx.zzrx();
            }
        }
    }

    public final Map<String, String> a() {
        Map<String, String> c = jj.a("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? c() : this.f;
        if (c == null) {
            synchronized (this.e) {
                c = this.f;
                if (c == null) {
                    c = c();
                    this.f = c;
                }
            }
        }
        return c != null ? c : Collections.emptyMap();
    }

    public final void b() {
        synchronized (this.e) {
            this.f = null;
        }
    }
}
