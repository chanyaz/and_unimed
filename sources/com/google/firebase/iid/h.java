package com.google.firebase.iid;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

final /* synthetic */ class h implements ComponentFactory {
    static final ComponentFactory a = new h();

    private h() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new a((FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class));
    }
}
