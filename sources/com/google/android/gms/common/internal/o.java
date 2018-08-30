package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.support.v4.util.b;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.c;
import java.util.Collection;
import java.util.Map;

public final class o {
    private Account a;
    private b<Scope> b;
    private Map<Api<?>, p> c;
    private int d = 0;
    private View e;
    private String f;
    private String g;
    private c h = c.a;

    public final n a() {
        return new n(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public final o a(Account account) {
        this.a = account;
        return this;
    }

    public final o a(String str) {
        this.f = str;
        return this;
    }

    public final o a(Collection<Scope> collection) {
        if (this.b == null) {
            this.b = new b();
        }
        this.b.addAll(collection);
        return this;
    }

    public final o b(String str) {
        this.g = str;
        return this;
    }
}
