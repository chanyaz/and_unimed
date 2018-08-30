package com.google.android.exoplayer.upstream.cache;

import java.io.File;
import java.util.regex.Pattern;

public final class a implements Comparable<a> {
    private static final Pattern f = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)(\\.v1\\.exo)$");
    public final String a;
    public final long b;
    public final long c;
    public final boolean d;
    public final File e;

    /* renamed from: a */
    public int compareTo(a aVar) {
        if (!this.a.equals(aVar.a)) {
            return this.a.compareTo(aVar.a);
        }
        long j = this.b - aVar.b;
        return j == 0 ? 0 : j < 0 ? -1 : 1;
    }

    public boolean a() {
        return this.c == -1;
    }
}
