package com.google.firebase.iid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.a;
import java.io.IOException;

final class ad implements Continuation<Bundle, String> {
    private final /* synthetic */ ab a;

    ad(ab abVar) {
        this.a = abVar;
    }

    public final /* synthetic */ Object then(@NonNull a aVar) {
        return this.a.a((Bundle) aVar.a(IOException.class));
    }
}
