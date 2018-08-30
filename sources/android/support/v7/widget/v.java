package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.util.g;

class v extends g<Integer, PorterDuffColorFilter> {
    public v(int i) {
        super(i);
    }

    private static int b(int i, Mode mode) {
        return ((i + 31) * 31) + mode.hashCode();
    }

    PorterDuffColorFilter a(int i, Mode mode) {
        return (PorterDuffColorFilter) get(Integer.valueOf(b(i, mode)));
    }

    PorterDuffColorFilter a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
        return (PorterDuffColorFilter) put(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
    }
}
