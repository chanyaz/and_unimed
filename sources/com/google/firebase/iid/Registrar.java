package com.google.firebase.iid;

import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.a;
import com.google.firebase.components.d;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
public final class Registrar implements ComponentRegistrar {
    @Keep
    public final List<a<?>> getComponents() {
        a b = a.a(FirebaseInstanceId.class).a(d.a(FirebaseApp.class)).a(g.a).a().b();
        a b2 = a.a(FirebaseInstanceIdInternal.class).a(d.a(FirebaseInstanceId.class)).a(h.a).b();
        return Arrays.asList(new a[]{b, b2});
    }
}
