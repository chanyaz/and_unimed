package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.d;
import com.google.android.gms.signin.internal.i;

public final class a {
    public static final d<i> a = new d();
    public static final d<i> b = new d();
    public static final com.google.android.gms.common.api.a<i, c> c = new e();
    public static final Scope d = new Scope("profile");
    public static final Scope e = new Scope("email");
    public static final Api<c> f = new Api("SignIn.API", c, a);
    public static final Api<b> g = new Api("SignIn.INTERNAL_API", h, b);
    private static final com.google.android.gms.common.api.a<i, b> h = new f();

    private a() {
    }
}
