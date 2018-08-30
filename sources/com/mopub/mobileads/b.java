package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;

class b {
    @NonNull
    private c a;
    @Nullable
    private String b;
    @Nullable
    private String c;
    @Nullable
    private String d;

    public b(@NonNull c cVar) {
        this(cVar, null, null, null);
    }

    public b(@NonNull c cVar, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Preconditions.checkNotNull(cVar);
        this.a = cVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @NonNull
    private c a() {
        return this.a;
    }

    private void a(@NonNull c cVar) {
        this.a = cVar;
    }

    private void a(@Nullable String str) {
        this.c = str;
    }

    @Nullable
    private String b() {
        return this.b;
    }

    private void b(@Nullable String str) {
        this.d = str;
    }

    @Nullable
    private String c() {
        return this.c;
    }

    @Nullable
    private String d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!(this.a.equals(bVar.a) && TextUtils.equals(this.b, bVar.b) && TextUtils.equals(this.c, bVar.c) && TextUtils.equals(this.d, bVar.d))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.c != null ? this.c.hashCode() : 0) + (((this.b != null ? this.b.hashCode() : 0) + ((this.a.ordinal() + 899) * 31)) * 31)) * 31;
        if (this.d != null) {
            i = this.d.hashCode();
        }
        return hashCode + i;
    }
}
