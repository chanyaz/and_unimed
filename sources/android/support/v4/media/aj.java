package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;

class aj {
    aj() {
    }

    public static Object a() {
        return new Builder();
    }

    public static Object a(Object obj) {
        return ((Builder) obj).build();
    }

    public static void a(Object obj, Bitmap bitmap) {
        ((Builder) obj).setIconBitmap(bitmap);
    }

    public static void a(Object obj, Uri uri) {
        ((Builder) obj).setIconUri(uri);
    }

    public static void a(Object obj, Bundle bundle) {
        ((Builder) obj).setExtras(bundle);
    }

    public static void a(Object obj, CharSequence charSequence) {
        ((Builder) obj).setTitle(charSequence);
    }

    public static void a(Object obj, String str) {
        ((Builder) obj).setMediaId(str);
    }

    public static void b(Object obj, CharSequence charSequence) {
        ((Builder) obj).setSubtitle(charSequence);
    }

    public static void c(Object obj, CharSequence charSequence) {
        ((Builder) obj).setDescription(charSequence);
    }
}
