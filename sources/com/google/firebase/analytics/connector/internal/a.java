package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.google.firebase.analytics.connector.b;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

final /* synthetic */ class a implements ComponentFactory {
    static final ComponentFactory a = new a();

    private a() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return b.a((Context) componentContainer.get(Context.class));
    }
}
