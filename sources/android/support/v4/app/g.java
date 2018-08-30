package android.support.v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
abstract class g extends f {
    boolean b;

    g() {
    }

    @RequiresApi(16)
    public void startActivityForResult(Intent intent, int i, @Nullable Bundle bundle) {
        if (!(this.b || i == -1)) {
            f.a(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @RequiresApi(16)
    public void startIntentSenderForResult(IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!(this.a || i == -1)) {
            f.a(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
