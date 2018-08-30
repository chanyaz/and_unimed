package uk.co.senab.photoview.gestures;

import android.content.Context;
import android.os.Build.VERSION;

public final class d {
    public static GestureDetector a(Context context, OnGestureListener onGestureListener) {
        int i = VERSION.SDK_INT;
        GestureDetector aVar = i < 5 ? new a(context) : i < 8 ? new b(context) : new c(context);
        aVar.setOnGestureListener(onGestureListener);
        return aVar;
    }
}
