package com.google.android.gms.common.api;

import android.support.v4.util.a;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.bz;
import com.google.android.gms.common.internal.ar;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final a<bz<?>, ConnectionResult> a;

    public AvailabilityException(a<bz<?>, ConnectionResult> aVar) {
        this.a = aVar;
    }

    public final a<bz<?>, ConnectionResult> a() {
        return this.a;
    }

    public ConnectionResult a(h<? extends ApiOptions> hVar) {
        bz b = hVar.b();
        ar.b(this.a.get(b) != null, "The given API was not part of the availability request.");
        return (ConnectionResult) this.a.get(b);
    }

    public String getMessage() {
        Iterable arrayList = new ArrayList();
        Object obj = 1;
        for (bz bzVar : this.a.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) this.a.get(bzVar);
            if (connectionResult.b()) {
                obj = null;
            }
            String a = bzVar.a();
            String valueOf = String.valueOf(connectionResult);
            arrayList.add(new StringBuilder((String.valueOf(a).length() + 2) + String.valueOf(valueOf).length()).append(a).append(": ").append(valueOf).toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (obj != null) {
            stringBuilder.append("None of the queried APIs are available. ");
        } else {
            stringBuilder.append("Some of the queried APIs are unavailable. ");
        }
        stringBuilder.append(TextUtils.join("; ", arrayList));
        return stringBuilder.toString();
    }
}
