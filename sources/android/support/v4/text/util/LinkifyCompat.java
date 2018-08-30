package android.support.v4.text.util;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Comparator;

public final class LinkifyCompat {
    private static final String[] a = new String[0];
    private static final Comparator<a> b = new Comparator<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.a < aVar2.a ? -1 : aVar.a > aVar2.a ? 1 : aVar.b < aVar2.b ? 1 : aVar.b <= aVar2.b ? 0 : -1;
        }
    };

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkifyMask {
    }

    private LinkifyCompat() {
    }
}
