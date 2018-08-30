package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import com.squareup.picasso.Picasso.LoadedFrom;

class s extends g {
    private static final String[] b = new String[]{"orientation"};

    s(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034  */
    static int a(android.content.ContentResolver r8, android.net.Uri r9) {
        /*
        r6 = 0;
        r7 = 0;
        r2 = b;	 Catch:{ RuntimeException -> 0x0027, all -> 0x0030 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r0 = r8;
        r1 = r9;
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x0027, all -> 0x0030 }
        if (r1 == 0) goto L_0x0015;
    L_0x000f:
        r0 = r1.moveToFirst();	 Catch:{ RuntimeException -> 0x003a, all -> 0x0038 }
        if (r0 != 0) goto L_0x001c;
    L_0x0015:
        if (r1 == 0) goto L_0x001a;
    L_0x0017:
        r1.close();
    L_0x001a:
        r0 = r6;
    L_0x001b:
        return r0;
    L_0x001c:
        r0 = 0;
        r0 = r1.getInt(r0);	 Catch:{ RuntimeException -> 0x003a, all -> 0x0038 }
        if (r1 == 0) goto L_0x001b;
    L_0x0023:
        r1.close();
        goto L_0x001b;
    L_0x0027:
        r0 = move-exception;
        r0 = r7;
    L_0x0029:
        if (r0 == 0) goto L_0x002e;
    L_0x002b:
        r0.close();
    L_0x002e:
        r0 = r6;
        goto L_0x001b;
    L_0x0030:
        r0 = move-exception;
        r1 = r7;
    L_0x0032:
        if (r1 == 0) goto L_0x0037;
    L_0x0034:
        r1.close();
    L_0x0037:
        throw r0;
    L_0x0038:
        r0 = move-exception;
        goto L_0x0032;
    L_0x003a:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.s.a(android.content.ContentResolver, android.net.Uri):int");
    }

    static t a(int i, int i2) {
        return (i > t.MICRO.e || i2 > t.MICRO.f) ? (i > t.MINI.e || i2 > t.MINI.f) ? t.FULL : t.MINI : t.MICRO;
    }

    public ag a(ac acVar, int i) {
        ContentResolver contentResolver = this.a.getContentResolver();
        int a = a(contentResolver, acVar.d);
        String type = contentResolver.getType(acVar.d);
        Object obj = (type == null || !type.startsWith("video/")) ? null : 1;
        if (acVar.d()) {
            t a2 = a(acVar.h, acVar.i);
            if (obj == null && a2 == t.FULL) {
                return new ag(null, b(acVar), LoadedFrom.DISK, a);
            }
            Bitmap thumbnail;
            long parseId = ContentUris.parseId(acVar.d);
            Options c = af.c(acVar);
            c.inJustDecodeBounds = true;
            af.a(acVar.h, acVar.i, a2.e, a2.f, c, acVar);
            if (obj != null) {
                thumbnail = Thumbnails.getThumbnail(contentResolver, parseId, a2 == t.FULL ? 1 : a2.d, c);
            } else {
                thumbnail = Images.Thumbnails.getThumbnail(contentResolver, parseId, a2.d, c);
            }
            if (thumbnail != null) {
                return new ag(thumbnail, null, LoadedFrom.DISK, a);
            }
        }
        return new ag(null, b(acVar), LoadedFrom.DISK, a);
    }

    public boolean a(ac acVar) {
        Uri uri = acVar.d;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }
}
