package com.google.android.exoplayer.upstream;

import android.net.Uri;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import java.io.InputStream;

public final class UriLoadable<T> implements Loadable {
    private final c a;
    private final UriDataSource b;
    private final Parser<T> c;
    private volatile T d;
    private volatile boolean e;

    public interface Parser<T> {
        T parse(String str, InputStream inputStream);
    }

    public UriLoadable(String str, UriDataSource uriDataSource, Parser<T> parser) {
        this.b = uriDataSource;
        this.c = parser;
        this.a = new c(Uri.parse(str), 1);
    }

    public final T a() {
        return this.d;
    }

    public final void cancelLoad() {
        this.e = true;
    }

    public final boolean isLoadCanceled() {
        return this.e;
    }

    public final void load() {
        InputStream bVar = new b(this.b, this.a);
        try {
            bVar.a();
            this.d = this.c.parse(this.b.getUri(), bVar);
        } finally {
            bVar.close();
        }
    }
}
