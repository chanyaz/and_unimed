package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

public class b<TResult> {
    private final r<TResult> a = new r();

    @NonNull
    public a<TResult> a() {
        return this.a;
    }

    public void a(@NonNull Exception exception) {
        this.a.a(exception);
    }

    public void a(TResult tResult) {
        this.a.a((Object) tResult);
    }

    public boolean b(@NonNull Exception exception) {
        return this.a.b(exception);
    }

    public boolean b(TResult tResult) {
        return this.a.b((Object) tResult);
    }
}
