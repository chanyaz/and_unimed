package com.squareup.picasso;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.squareup.picasso.Picasso.LoadedFrom;

class n extends g {
    n(Context context) {
        super(context);
    }

    static int a(Uri uri) {
        switch (new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1)) {
            case 3:
                return 180;
            case 6:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public ag a(ac acVar, int i) {
        return new ag(null, b(acVar), LoadedFrom.DISK, a(acVar.d));
    }

    public boolean a(ac acVar) {
        return "file".equals(acVar.d.getScheme());
    }
}
