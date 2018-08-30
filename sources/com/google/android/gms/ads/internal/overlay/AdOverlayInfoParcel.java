package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.zzaq;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzjd;

@zzadh
@Class(creator = "AdOverlayInfoCreator")
@Reserved({1})
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<AdOverlayInfoParcel> CREATOR = new l();
    @Field(id = 2)
    public final zzc a;
    @Field(getter = "getAdClickListenerAsBinder", id = 3, type = "android.os.IBinder")
    public final zzjd b;
    @Field(getter = "getAdOverlayListenerAsBinder", id = 4, type = "android.os.IBinder")
    public final zzn c;
    @Field(getter = "getAdWebViewAsBinder", id = 5, type = "android.os.IBinder")
    public final zzaqw d;
    @Field(getter = "getAppEventGmsgListenerAsBinder", id = 6, type = "android.os.IBinder")
    public final zzd e;
    @Field(id = 7)
    public final String f;
    @Field(id = 8)
    public final boolean g;
    @Field(id = 9)
    public final String h;
    @Field(getter = "getLeaveApplicationListenerAsBinder", id = 10, type = "android.os.IBinder")
    public final zzt i;
    @Field(id = 11)
    public final int j;
    @Field(id = 12)
    public final int k;
    @Field(id = 13)
    public final String l;
    @Field(id = 14)
    public final zzang m;
    @Field(id = 16)
    public final String n;
    @Field(id = 17)
    public final zzaq o;
    @Field(getter = "getAdMetadataGmsgListenerAsBinder", id = 18, type = "android.os.IBinder")
    public final zzb p;

    @Constructor
    AdOverlayInfoParcel(@Param(id = 2) zzc zzc, @Param(id = 3) IBinder iBinder, @Param(id = 4) IBinder iBinder2, @Param(id = 5) IBinder iBinder3, @Param(id = 6) IBinder iBinder4, @Param(id = 7) String str, @Param(id = 8) boolean z, @Param(id = 9) String str2, @Param(id = 10) IBinder iBinder5, @Param(id = 11) int i, @Param(id = 12) int i2, @Param(id = 13) String str3, @Param(id = 14) zzang zzang, @Param(id = 16) String str4, @Param(id = 17) zzaq zzaq, @Param(id = 18) IBinder iBinder6) {
        this.a = zzc;
        this.b = (zzjd) c.a(a.a(iBinder));
        this.c = (zzn) c.a(a.a(iBinder2));
        this.d = (zzaqw) c.a(a.a(iBinder3));
        this.p = (zzb) c.a(a.a(iBinder6));
        this.e = (zzd) c.a(a.a(iBinder4));
        this.f = str;
        this.g = z;
        this.h = str2;
        this.i = (zzt) c.a(a.a(iBinder5));
        this.j = i;
        this.k = i2;
        this.l = str3;
        this.m = zzang;
        this.n = str4;
        this.o = zzaq;
    }

    public AdOverlayInfoParcel(zzc zzc, zzjd zzjd, zzn zzn, zzt zzt, zzang zzang) {
        this.a = zzc;
        this.b = zzjd;
        this.c = zzn;
        this.d = null;
        this.p = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = null;
        this.i = zzt;
        this.j = -1;
        this.k = 4;
        this.l = null;
        this.m = zzang;
        this.n = null;
        this.o = null;
    }

    public AdOverlayInfoParcel(zzjd zzjd, zzn zzn, zzb zzb, zzd zzd, zzt zzt, zzaqw zzaqw, boolean z, int i, String str, zzang zzang) {
        this.a = null;
        this.b = zzjd;
        this.c = zzn;
        this.d = zzaqw;
        this.p = zzb;
        this.e = zzd;
        this.f = null;
        this.g = z;
        this.h = null;
        this.i = zzt;
        this.j = i;
        this.k = 3;
        this.l = str;
        this.m = zzang;
        this.n = null;
        this.o = null;
    }

    public AdOverlayInfoParcel(zzjd zzjd, zzn zzn, zzb zzb, zzd zzd, zzt zzt, zzaqw zzaqw, boolean z, int i, String str, String str2, zzang zzang) {
        this.a = null;
        this.b = zzjd;
        this.c = zzn;
        this.d = zzaqw;
        this.p = zzb;
        this.e = zzd;
        this.f = str2;
        this.g = z;
        this.h = str;
        this.i = zzt;
        this.j = i;
        this.k = 3;
        this.l = null;
        this.m = zzang;
        this.n = null;
        this.o = null;
    }

    public AdOverlayInfoParcel(zzjd zzjd, zzn zzn, zzt zzt, zzaqw zzaqw, int i, zzang zzang, String str, zzaq zzaq) {
        this.a = null;
        this.b = zzjd;
        this.c = zzn;
        this.d = zzaqw;
        this.p = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = null;
        this.i = zzt;
        this.j = i;
        this.k = 1;
        this.l = null;
        this.m = zzang;
        this.n = str;
        this.o = zzaq;
    }

    public AdOverlayInfoParcel(zzjd zzjd, zzn zzn, zzt zzt, zzaqw zzaqw, boolean z, int i, zzang zzang) {
        this.a = null;
        this.b = zzjd;
        this.c = zzn;
        this.d = zzaqw;
        this.p = null;
        this.e = null;
        this.f = null;
        this.g = z;
        this.h = null;
        this.i = zzt;
        this.j = i;
        this.k = 2;
        this.l = null;
        this.m = zzang;
        this.n = null;
        this.o = null;
    }

    public static AdOverlayInfoParcel a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void a(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 2, this.a, i, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 3, c.a(this.b).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 4, c.a(this.c).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 5, c.a(this.d).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 6, c.a(this.e).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 7, this.f, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 8, this.g);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 9, this.h, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 10, c.a(this.i).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 11, this.j);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 12, this.k);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 13, this.l, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 14, this.m, i, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 16, this.n, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 17, this.o, i, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 18, c.a(this.p).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, a);
    }
}
