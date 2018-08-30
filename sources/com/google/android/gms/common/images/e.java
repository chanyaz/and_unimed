package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.internal.ap;
import java.lang.ref.WeakReference;

public final class e extends d {
    private WeakReference<OnImageLoadedListener> e;

    protected final void a(Drawable drawable, boolean z, boolean z2, boolean z3) {
        if (!z2) {
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.e.get();
            if (onImageLoadedListener != null) {
                onImageLoadedListener.onImageLoaded(this.a.a, drawable, z3);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        e eVar = (e) obj;
        OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.e.get();
        OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) eVar.e.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && ap.a(onImageLoadedListener2, onImageLoadedListener) && ap.a(eVar.a, this.a);
    }

    public final int hashCode() {
        return ap.a(this.a);
    }
}
