package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@VisibleForTesting
public final class n {
    private final Account a;
    private final Set<Scope> b;
    private final Set<Scope> c;
    private final Map<Api<?>, p> d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final c i;
    private Integer j;

    public n(Account account, Set<Scope> set, Map<Api<?>, p> map, int i, View view, String str, String str2, c cVar) {
        Map map2;
        this.a = account;
        this.b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map2 == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.d = map2;
        this.f = view;
        this.e = i;
        this.g = str;
        this.h = str2;
        this.i = cVar;
        Set hashSet = new HashSet(this.b);
        for (p pVar : this.d.values()) {
            hashSet.addAll(pVar.a);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }

    public static n a(Context context) {
        return new i(context).a();
    }

    @Nullable
    public final Account a() {
        return this.a;
    }

    public final void a(Integer num) {
        this.j = num;
    }

    public final Account b() {
        return this.a != null ? this.a : new Account("<<default account>>", "com.google");
    }

    public final Set<Scope> c() {
        return this.b;
    }

    public final Set<Scope> d() {
        return this.c;
    }

    public final Map<Api<?>, p> e() {
        return this.d;
    }

    @Nullable
    public final String f() {
        return this.g;
    }

    @Nullable
    public final String g() {
        return this.h;
    }

    @Nullable
    public final c h() {
        return this.i;
    }

    @Nullable
    public final Integer i() {
        return this.j;
    }
}
