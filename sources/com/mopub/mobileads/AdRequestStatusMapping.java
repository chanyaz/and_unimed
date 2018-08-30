package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
import java.util.TreeMap;

public class AdRequestStatusMapping {
    @NonNull
    private final Map<String, b> a = new TreeMap();

    void a(@NonNull String str) {
        this.a.remove(str);
    }

    void a(@NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.a.put(str, new b(c.LOADED, str2, str3, str4));
    }

    void b(@NonNull String str) {
        this.a.put(str, new b(c.LOADING));
    }

    void c(@NonNull String str) {
        if (this.a.containsKey(str)) {
            ((b) this.a.get(str)).a(c.PLAYED);
        } else {
            this.a.put(str, new b(c.PLAYED));
        }
    }

    boolean d(@NonNull String str) {
        b bVar = (b) this.a.get(str);
        return bVar != null && c.LOADED.equals(bVar.a());
    }

    boolean e(@NonNull String str) {
        if (!this.a.containsKey(str)) {
            return false;
        }
        return ((b) this.a.get(str)).a() == c.LOADING;
    }

    @Nullable
    String f(@NonNull String str) {
        return !this.a.containsKey(str) ? null : ((b) this.a.get(str)).b();
    }

    @Nullable
    String g(@NonNull String str) {
        return !this.a.containsKey(str) ? null : ((b) this.a.get(str)).c();
    }

    @Nullable
    String h(@NonNull String str) {
        return !this.a.containsKey(str) ? null : ((b) this.a.get(str)).d();
    }

    void i(@NonNull String str) {
        if (this.a.containsKey(str)) {
            ((b) this.a.get(str)).a(null);
        }
    }

    void j(@NonNull String str) {
        if (this.a.containsKey(str)) {
            ((b) this.a.get(str)).b(null);
        }
    }
}
