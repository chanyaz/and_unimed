package com.google.firebase.iid;

import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;

final class a implements FirebaseInstanceIdInternal {
    private final FirebaseInstanceId a;

    public a(FirebaseInstanceId firebaseInstanceId) {
        this.a = firebaseInstanceId;
    }

    public final String getId() {
        return this.a.c();
    }

    public final String getToken() {
        return this.a.e();
    }
}
