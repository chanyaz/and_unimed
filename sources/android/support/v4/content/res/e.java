package android.support.v4.content.res;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

public abstract class e {
    public abstract void a(int i);

    @RestrictTo({Scope.LIBRARY_GROUP})
    public final void a(final int i, @Nullable Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable() {
            public void run() {
                e.this.a(i);
            }
        });
    }

    public abstract void a(@NonNull Typeface typeface);

    @RestrictTo({Scope.LIBRARY_GROUP})
    public final void a(final Typeface typeface, @Nullable Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable() {
            public void run() {
                e.this.a(typeface);
            }
        });
    }
}
