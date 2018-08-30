package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

@zzadh
final class asb {
    private static final ary a = ary.a();
    private static final float b = ((Float) akc.f().a(amn.bf)).floatValue();
    private static final long c = ((Long) akc.f().a(amn.bd)).longValue();
    private static final float d = ((Float) akc.f().a(amn.bg)).floatValue();
    private static final long e = ((Long) akc.f().a(amn.be)).longValue();

    @VisibleForTesting
    private static int a(long j, int i) {
        return (int) ((j >>> ((i % 16) * 4)) & 15);
    }

    static boolean a() {
        int i = MoPubClientPositioning.NO_REPEAT;
        int h = a.h();
        int i2 = a.i();
        int f = a.f() + a.g();
        int a = (h >= 16 || e == 0) ? d != 0.0f ? ((int) (d * ((float) h))) + 1 : MoPubClientPositioning.NO_REPEAT : a(e, h);
        if (i2 <= a) {
            if (h < 16 && c != 0) {
                i = a(c, h);
            } else if (b != 0.0f) {
                i = (int) (b * ((float) h));
            }
            if (f <= i) {
                return true;
            }
        }
        return false;
    }
}
