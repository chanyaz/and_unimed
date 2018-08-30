package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import java.util.Set;

public final class au {
    private final String a;
    private final CharSequence b;
    private final CharSequence[] c;
    private final boolean d;
    private final Bundle e;
    private final Set<String> f;

    @RequiresApi(20)
    static RemoteInput a(au auVar) {
        return new Builder(auVar.a()).setLabel(auVar.b()).setChoices(auVar.c()).setAllowFreeFormInput(auVar.e()).addExtras(auVar.f()).build();
    }

    @RequiresApi(20)
    static RemoteInput[] a(au[] auVarArr) {
        if (auVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[auVarArr.length];
        for (int i = 0; i < auVarArr.length; i++) {
            remoteInputArr[i] = a(auVarArr[i]);
        }
        return remoteInputArr;
    }

    public String a() {
        return this.a;
    }

    public CharSequence b() {
        return this.b;
    }

    public CharSequence[] c() {
        return this.c;
    }

    public Set<String> d() {
        return this.f;
    }

    public boolean e() {
        return this.d;
    }

    public Bundle f() {
        return this.e;
    }
}
