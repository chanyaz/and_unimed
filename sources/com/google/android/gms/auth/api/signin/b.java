package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class b {
    private Set<Scope> a = new HashSet();
    private boolean b;
    private boolean c;
    private boolean d;
    private String e;
    private Account f;
    private String g;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> h = new HashMap();

    public final b a() {
        this.a.add(GoogleSignInOptions.c);
        return this;
    }

    public final b a(Scope scope, Scope... scopeArr) {
        this.a.add(scope);
        this.a.addAll(Arrays.asList(scopeArr));
        return this;
    }

    public final b b() {
        this.a.add(GoogleSignInOptions.a);
        return this;
    }

    public final GoogleSignInOptions c() {
        if (this.a.contains(GoogleSignInOptions.e) && this.a.contains(GoogleSignInOptions.d)) {
            this.a.remove(GoogleSignInOptions.d);
        }
        if (this.d && (this.f == null || !this.a.isEmpty())) {
            a();
        }
        return new GoogleSignInOptions(3, new ArrayList(this.a), this.f, this.d, this.b, this.c, this.e, this.g, this.h, null);
    }
}
