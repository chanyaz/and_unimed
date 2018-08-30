package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.Picasso.LoadedFrom;

class c extends af {
    private static final int a = "file:///android_asset/".length();
    private final AssetManager b;

    public c(Context context) {
        this.b = context.getAssets();
    }

    static String b(ac acVar) {
        return acVar.d.toString().substring(a);
    }

    public ag a(ac acVar, int i) {
        return new ag(this.b.open(b(acVar)), LoadedFrom.DISK);
    }

    public boolean a(ac acVar) {
        Uri uri = acVar.d;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
