package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

final class d implements Comparator<Scope> {
    d() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((Scope) obj).a().compareTo(((Scope) obj2).a());
    }
}
