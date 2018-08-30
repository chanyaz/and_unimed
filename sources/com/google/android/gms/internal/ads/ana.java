package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.appnext.base.b.c;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class ana {
    @VisibleForTesting
    private boolean a;
    private final List<amy> b = new LinkedList();
    private final Map<String, String> c = new LinkedHashMap();
    private final Object d = new Object();
    private String e;
    @Nullable
    private ana f;

    public ana(boolean z, String str, String str2) {
        this.a = z;
        this.c.put(c.jD, str);
        this.c.put("ad_format", str2);
    }

    public final amy a() {
        return a(au.l().elapsedRealtime());
    }

    @Nullable
    public final amy a(long j) {
        return !this.a ? null : new amy(j, null, null);
    }

    public final void a(@Nullable ana ana) {
        synchronized (this.d) {
            this.f = ana;
        }
    }

    public final void a(String str) {
        if (this.a) {
            synchronized (this.d) {
                this.e = str;
            }
        }
    }

    public final void a(String str, String str2) {
        if (this.a && !TextUtils.isEmpty(str2)) {
            amq b = au.i().b();
            if (b != null) {
                synchronized (this.d) {
                    amu a = b.a(str);
                    Map map = this.c;
                    map.put(str, a.a((String) map.get(str), str2));
                }
            }
        }
    }

    public final boolean a(amy amy, long j, String... strArr) {
        synchronized (this.d) {
            for (String amy2 : strArr) {
                this.b.add(new amy(j, amy2, amy));
            }
        }
        return true;
    }

    public final boolean a(@Nullable amy amy, String... strArr) {
        return (!this.a || amy == null) ? false : a(amy, au.l().elapsedRealtime(), strArr);
    }

    public final String b() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        synchronized (this.d) {
            for (amy amy : this.b) {
                long a = amy.a();
                String b = amy.b();
                amy amy2 = amy2.c();
                if (amy2 != null && a > 0) {
                    stringBuilder2.append(b).append('.').append(a - amy2.a()).append(',');
                }
            }
            this.b.clear();
            if (!TextUtils.isEmpty(this.e)) {
                stringBuilder2.append(this.e);
            } else if (stringBuilder2.length() > 0) {
                stringBuilder2.setLength(stringBuilder2.length() - 1);
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    @VisibleForTesting
    final Map<String, String> c() {
        Map<String, String> map;
        synchronized (this.d) {
            amq b = au.i().b();
            if (b == null || this.f == null) {
                map = this.c;
            } else {
                map = b.a(this.c, this.f.c());
            }
        }
        return map;
    }

    public final amy d() {
        synchronized (this.d) {
        }
        return null;
    }
}
