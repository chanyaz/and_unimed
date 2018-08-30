package android.support.v4.content.res;

import android.support.annotation.NonNull;

public final class b {
    @NonNull
    private final String a;
    private int b;
    private boolean c;
    private int d;

    public b(@NonNull String str, int i, boolean z, int i2) {
        this.a = str;
        this.b = i;
        this.c = z;
        this.d = i2;
    }

    @NonNull
    public String a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }
}
