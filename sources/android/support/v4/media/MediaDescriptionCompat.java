package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new Creator<MediaDescriptionCompat>() {
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.a(ai.a(parcel));
        }

        /* renamed from: a */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    private final String a;
    private final CharSequence b;
    private final CharSequence c;
    private final CharSequence d;
    private final Bitmap e;
    private final Uri f;
    private final Bundle g;
    private final Uri h;
    private Object i;

    MediaDescriptionCompat(Parcel parcel) {
        this.a = parcel.readString();
        this.b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.e = (Bitmap) parcel.readParcelable(null);
        this.f = (Uri) parcel.readParcelable(null);
        this.g = parcel.readBundle();
        this.h = (Uri) parcel.readParcelable(null);
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.a = str;
        this.b = charSequence;
        this.c = charSequence2;
        this.d = charSequence3;
        this.e = bitmap;
        this.f = uri;
        this.g = bundle;
        this.h = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r6) {
        /*
        r1 = 0;
        if (r6 == 0) goto L_0x005f;
    L_0x0003:
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 21;
        if (r0 < r2) goto L_0x005f;
    L_0x0009:
        r4 = new android.support.v4.media.ah;
        r4.<init>();
        r0 = android.support.v4.media.ai.a(r6);
        r4.a(r0);
        r0 = android.support.v4.media.ai.b(r6);
        r4.a(r0);
        r0 = android.support.v4.media.ai.c(r6);
        r4.b(r0);
        r0 = android.support.v4.media.ai.d(r6);
        r4.c(r0);
        r0 = android.support.v4.media.ai.e(r6);
        r4.a(r0);
        r0 = android.support.v4.media.ai.f(r6);
        r4.a(r0);
        r2 = android.support.v4.media.ai.g(r6);
        if (r2 != 0) goto L_0x0060;
    L_0x003e:
        r3 = r1;
    L_0x003f:
        if (r3 == 0) goto L_0x0074;
    L_0x0041:
        r0 = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
        r0 = r2.containsKey(r0);
        if (r0 == 0) goto L_0x006a;
    L_0x0049:
        r0 = r2.size();
        r5 = 2;
        if (r0 != r5) goto L_0x006a;
    L_0x0050:
        r0 = r1;
    L_0x0051:
        r4.a(r0);
        if (r3 == 0) goto L_0x0076;
    L_0x0056:
        r4.b(r3);
    L_0x0059:
        r1 = r4.a();
        r1.i = r6;
    L_0x005f:
        return r1;
    L_0x0060:
        r0 = "android.support.v4.media.description.MEDIA_URI";
        r0 = r2.getParcelable(r0);
        r0 = (android.net.Uri) r0;
        r3 = r0;
        goto L_0x003f;
    L_0x006a:
        r0 = "android.support.v4.media.description.MEDIA_URI";
        r2.remove(r0);
        r0 = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
        r2.remove(r0);
    L_0x0074:
        r0 = r2;
        goto L_0x0051;
    L_0x0076:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 23;
        if (r0 < r1) goto L_0x0059;
    L_0x007c:
        r0 = android.support.v4.media.ak.h(r6);
        r4.b(r0);
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    @Nullable
    public String a() {
        return this.a;
    }

    public Object b() {
        if (this.i != null || VERSION.SDK_INT < 21) {
            return this.i;
        }
        Object a = aj.a();
        aj.a(a, this.a);
        aj.a(a, this.b);
        aj.b(a, this.c);
        aj.c(a, this.d);
        aj.a(a, this.e);
        aj.a(a, this.f);
        Bundle bundle = this.g;
        if (VERSION.SDK_INT < 23 && this.h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.h);
        }
        aj.a(a, bundle);
        if (VERSION.SDK_INT >= 23) {
            al.b(a, this.h);
        }
        this.i = aj.a(a);
        return this.i;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.b + ", " + this.c + ", " + this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.a);
            TextUtils.writeToParcel(this.b, parcel, i);
            TextUtils.writeToParcel(this.c, parcel, i);
            TextUtils.writeToParcel(this.d, parcel, i);
            parcel.writeParcelable(this.e, i);
            parcel.writeParcelable(this.f, i);
            parcel.writeBundle(this.g);
            parcel.writeParcelable(this.h, i);
            return;
        }
        ai.a(b(), parcel, i);
    }
}
