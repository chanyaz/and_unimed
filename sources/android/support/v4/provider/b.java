package android.support.v4.provider;

import android.net.Uri;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.util.r;

public class b {
    private final Uri a;
    private final int b;
    private final int c;
    private final boolean d;
    private final int e;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public b(@NonNull Uri uri, @IntRange(from = 0) int i, @IntRange(from = 1, to = 1000) int i2, boolean z, int i3) {
        this.a = (Uri) r.a(uri);
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = i3;
    }

    @NonNull
    public Uri a() {
        return this.a;
    }

    @IntRange(from = 0)
    public int b() {
        return this.b;
    }

    @IntRange(from = 1, to = 1000)
    public int c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }
}
