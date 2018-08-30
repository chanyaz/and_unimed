package uk.co.senab.photoview.a;

import android.content.Context;
import android.os.Build.VERSION;

public abstract class d {
    public static d a(Context context) {
        return VERSION.SDK_INT < 9 ? new c(context) : VERSION.SDK_INT < 14 ? new a(context) : new b(context);
    }

    public abstract void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    public abstract void a(boolean z);

    public abstract boolean a();

    public abstract boolean b();

    public abstract int c();

    public abstract int d();
}
