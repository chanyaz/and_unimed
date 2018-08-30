package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.o;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;

@zzadh
@Class(creator = "AdSizeParcelCreator")
@Reserved({1})
public class zzjn extends AbstractSafeParcelable {
    public static final Creator<zzjn> CREATOR = new ajr();
    @Field(id = 2)
    public final String a;
    @Field(id = 3)
    public final int b;
    @Field(id = 4)
    public final int c;
    @Field(id = 5)
    public final boolean d;
    @Field(id = 6)
    public final int e;
    @Field(id = 7)
    public final int f;
    @Field(id = 8)
    public final zzjn[] g;
    @Field(id = 9)
    public final boolean h;
    @Field(id = 10)
    public final boolean i;
    @Field(id = 11)
    public boolean j;

    public zzjn() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public zzjn(Context context, f fVar) {
        this(context, new f[]{fVar});
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    public zzjn(android.content.Context r13, com.google.android.gms.ads.f[] r14) {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        r12.<init>();
        r6 = r14[r2];
        r12.d = r2;
        r0 = r6.c();
        r12.i = r0;
        r0 = r12.i;
        if (r0 == 0) goto L_0x00bc;
    L_0x0013:
        r0 = com.google.android.gms.ads.f.a;
        r0 = r0.b();
        r12.e = r0;
        r0 = com.google.android.gms.ads.f.a;
        r0 = r0.a();
        r12.b = r0;
    L_0x0023:
        r0 = r12.e;
        r3 = -1;
        if (r0 != r3) goto L_0x00ca;
    L_0x0028:
        r0 = r1;
    L_0x0029:
        r3 = r12.b;
        r4 = -2;
        if (r3 != r4) goto L_0x00cd;
    L_0x002e:
        r3 = r1;
    L_0x002f:
        r4 = r13.getResources();
        r7 = r4.getDisplayMetrics();
        if (r0 == 0) goto L_0x00d5;
    L_0x0039:
        com.google.android.gms.internal.ads.akc.a();
        r4 = com.google.android.gms.internal.ads.kb.g(r13);
        if (r4 == 0) goto L_0x00d0;
    L_0x0042:
        com.google.android.gms.internal.ads.akc.a();
        r4 = com.google.android.gms.internal.ads.kb.h(r13);
        if (r4 == 0) goto L_0x00d0;
    L_0x004b:
        r4 = r7.widthPixels;
        com.google.android.gms.internal.ads.akc.a();
        r5 = com.google.android.gms.internal.ads.kb.i(r13);
        r4 = r4 - r5;
        r12.f = r4;
    L_0x0057:
        r4 = r12.f;
        r4 = (float) r4;
        r5 = r7.density;
        r4 = r4 / r5;
        r8 = (double) r4;
        r4 = (int) r8;
        r5 = (int) r8;
        r10 = (double) r5;
        r8 = r8 - r10;
        r10 = 4576918229304087675; // 0x3f847ae147ae147b float:89128.96 double:0.01;
        r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r5 < 0) goto L_0x006d;
    L_0x006b:
        r4 = r4 + 1;
    L_0x006d:
        r5 = r4;
    L_0x006e:
        if (r3 == 0) goto L_0x00e4;
    L_0x0070:
        r4 = c(r7);
    L_0x0074:
        com.google.android.gms.internal.ads.akc.a();
        r7 = com.google.android.gms.internal.ads.kb.a(r7, r4);
        r12.c = r7;
        if (r0 != 0) goto L_0x0081;
    L_0x007f:
        if (r3 == 0) goto L_0x00e7;
    L_0x0081:
        r0 = 26;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r0);
        r0 = r3.append(r5);
        r3 = "x";
        r0 = r0.append(r3);
        r0 = r0.append(r4);
        r3 = "_as";
        r0 = r0.append(r3);
        r0 = r0.toString();
        r12.a = r0;
    L_0x00a2:
        r0 = r14.length;
        if (r0 <= r1) goto L_0x00f7;
    L_0x00a5:
        r0 = r14.length;
        r0 = new com.google.android.gms.internal.ads.zzjn[r0];
        r12.g = r0;
        r0 = r2;
    L_0x00ab:
        r1 = r14.length;
        if (r0 >= r1) goto L_0x00fa;
    L_0x00ae:
        r1 = r12.g;
        r3 = new com.google.android.gms.internal.ads.zzjn;
        r4 = r14[r0];
        r3.<init>(r13, r4);
        r1[r0] = r3;
        r0 = r0 + 1;
        goto L_0x00ab;
    L_0x00bc:
        r0 = r6.b();
        r12.e = r0;
        r0 = r6.a();
        r12.b = r0;
        goto L_0x0023;
    L_0x00ca:
        r0 = r2;
        goto L_0x0029;
    L_0x00cd:
        r3 = r2;
        goto L_0x002f;
    L_0x00d0:
        r4 = r7.widthPixels;
        r12.f = r4;
        goto L_0x0057;
    L_0x00d5:
        r4 = r12.e;
        com.google.android.gms.internal.ads.akc.a();
        r5 = r12.e;
        r5 = com.google.android.gms.internal.ads.kb.a(r7, r5);
        r12.f = r5;
        r5 = r4;
        goto L_0x006e;
    L_0x00e4:
        r4 = r12.b;
        goto L_0x0074;
    L_0x00e7:
        r0 = r12.i;
        if (r0 == 0) goto L_0x00f0;
    L_0x00eb:
        r0 = "320x50_mb";
        r12.a = r0;
        goto L_0x00a2;
    L_0x00f0:
        r0 = r6.toString();
        r12.a = r0;
        goto L_0x00a2;
    L_0x00f7:
        r0 = 0;
        r12.g = r0;
    L_0x00fa:
        r12.h = r2;
        r12.j = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjn.<init>(android.content.Context, com.google.android.gms.ads.f[]):void");
    }

    public zzjn(zzjn zzjn, zzjn[] zzjnArr) {
        this(zzjn.a, zzjn.b, zzjn.c, zzjn.d, zzjn.e, zzjn.f, zzjnArr, zzjn.h, zzjn.i, zzjn.j);
    }

    @Constructor
    zzjn(@Param(id = 2) String str, @Param(id = 3) int i, @Param(id = 4) int i2, @Param(id = 5) boolean z, @Param(id = 6) int i3, @Param(id = 7) int i4, @Param(id = 8) zzjn[] zzjnArr, @Param(id = 9) boolean z2, @Param(id = 10) boolean z3, @Param(id = 11) boolean z4) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = i3;
        this.f = i4;
        this.g = zzjnArr;
        this.h = z2;
        this.i = z3;
        this.j = z4;
    }

    public static int a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static zzjn a() {
        return new zzjn("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public static zzjn a(Context context) {
        return new zzjn("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public static int b(DisplayMetrics displayMetrics) {
        return (int) (((float) c(displayMetrics)) * displayMetrics.density);
    }

    private static int c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public final f b() {
        return o.a(this.e, this.b, this.a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, this.a, false);
        a.a(parcel, 3, this.b);
        a.a(parcel, 4, this.c);
        a.a(parcel, 5, this.d);
        a.a(parcel, 6, this.e);
        a.a(parcel, 7, this.f);
        a.a(parcel, 8, this.g, i, false);
        a.a(parcel, 9, this.h);
        a.a(parcel, 10, this.i);
        a.a(parcel, 11, this.j);
        a.a(parcel, a);
    }
}
