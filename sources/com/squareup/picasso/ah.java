package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.squareup.picasso.Picasso.LoadedFrom;

class ah extends af {
    private final Context a;

    ah(Context context) {
        this.a = context;
    }

    private static Bitmap a(Resources resources, int i, ac acVar) {
        Options c = af.c(acVar);
        if (af.a(c)) {
            BitmapFactory.decodeResource(resources, i, c);
            af.a(acVar.h, acVar.i, c, acVar);
        }
        return BitmapFactory.decodeResource(resources, i, c);
    }

    public ag a(ac acVar, int i) {
        Resources a = ao.a(this.a, acVar);
        return new ag(a(a, ao.a(a, acVar), acVar), LoadedFrom.DISK);
    }

    public boolean a(ac acVar) {
        return acVar.e != 0 ? true : "android.resource".equals(acVar.d.getScheme());
    }
}
