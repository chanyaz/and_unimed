package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class h {
    private h() {
    }

    @Nullable
    public static IBinder a(@NonNull Bundle bundle, @Nullable String str) {
        return VERSION.SDK_INT >= 18 ? bundle.getBinder(str) : i.a(bundle, str);
    }

    public static void a(@NonNull Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        if (VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            i.a(bundle, str, iBinder);
        }
    }
}
