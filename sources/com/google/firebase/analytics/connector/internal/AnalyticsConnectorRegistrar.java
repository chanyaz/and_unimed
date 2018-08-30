package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.a;
import com.google.firebase.components.d;
import java.util.Collections;
import java.util.List;

@Keep
@KeepForSdk
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Keep
    @SuppressLint({"MissingPermission"})
    @KeepForSdk
    public List<a<?>> getComponents() {
        return Collections.singletonList(a.a(AnalyticsConnector.class).a(d.a(FirebaseApp.class)).a(d.a(Context.class)).a(a.a).b());
    }
}
