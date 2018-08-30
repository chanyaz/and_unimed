package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.Picasso.LoadedFrom;
import java.io.InputStream;

class g extends af {
    final Context a;

    g(Context context) {
        this.a = context;
    }

    public ag a(ac acVar, int i) {
        return new ag(b(acVar), LoadedFrom.DISK);
    }

    public boolean a(ac acVar) {
        return "content".equals(acVar.d.getScheme());
    }

    InputStream b(ac acVar) {
        return this.a.getContentResolver().openInputStream(acVar.d);
    }
}
