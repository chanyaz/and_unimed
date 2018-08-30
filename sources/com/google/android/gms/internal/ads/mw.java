package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class mw {
    private final int a;
    private final List<akt> b;
    private final int c;
    private final InputStream d;

    public mw(int i, List<akt> list) {
        this(i, list, -1, null);
    }

    public mw(int i, List<akt> list, int i2, InputStream inputStream) {
        this.a = i;
        this.b = list;
        this.c = i2;
        this.d = inputStream;
    }

    public final int a() {
        return this.a;
    }

    public final List<akt> b() {
        return Collections.unmodifiableList(this.b);
    }

    public final int c() {
        return this.c;
    }

    public final InputStream d() {
        return this.d;
    }
}
