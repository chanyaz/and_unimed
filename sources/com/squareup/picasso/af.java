package com.squareup.picasso;

import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;

public abstract class af {
    static void a(int i, int i2, int i3, int i4, Options options, ac acVar) {
        int i5 = 1;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                i5 = (int) Math.floor((double) (((float) i3) / ((float) i)));
            } else if (i == 0) {
                i5 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
            } else {
                i5 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                int floor = (int) Math.floor((double) (((float) i3) / ((float) i)));
                i5 = acVar.k ? Math.max(i5, floor) : Math.min(i5, floor);
            }
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }

    static void a(int i, int i2, Options options, ac acVar) {
        a(i, i2, options.outWidth, options.outHeight, options, acVar);
    }

    static boolean a(Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static Options c(ac acVar) {
        boolean d = acVar.d();
        Object obj = acVar.q != null ? 1 : null;
        Options options = null;
        if (d || obj != null) {
            options = new Options();
            options.inJustDecodeBounds = d;
            if (obj != null) {
                options.inPreferredConfig = acVar.q;
            }
        }
        return options;
    }

    int a() {
        return 0;
    }

    public abstract ag a(ac acVar, int i);

    public abstract boolean a(ac acVar);

    boolean a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    boolean b() {
        return false;
    }
}
