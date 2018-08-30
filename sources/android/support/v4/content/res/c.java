package android.support.v4.content.res;

import android.support.annotation.NonNull;
import android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry;
import android.support.v4.provider.a;

public final class c implements FamilyResourceEntry {
    @NonNull
    private final a a;
    private final int b;
    private final int c;

    public c(@NonNull a aVar, int i, int i2) {
        this.a = aVar;
        this.c = i;
        this.b = i2;
    }

    @NonNull
    public a a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }
}
