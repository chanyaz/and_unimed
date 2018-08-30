package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.support.v4.util.g;

final class a extends g<f, Bitmap> {
    protected final /* synthetic */ int a(Object obj, Object obj2) {
        Bitmap bitmap = (Bitmap) obj2;
        return bitmap.getHeight() * bitmap.getRowBytes();
    }
}
