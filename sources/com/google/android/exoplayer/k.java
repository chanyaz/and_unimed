package com.google.android.exoplayer;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.google.android.exoplayer.util.m;
import com.mopub.mobileads.VastIconXmlManager;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class k {
    public final String a;
    public final int b;
    public final long c;
    public final int d;
    public final int e;
    public final float f;
    public final int g;
    public final int h;
    public final List<byte[]> i;
    private int j;
    private int k;
    private int l;
    private MediaFormat m;

    private k(String str, int i, long j, int i2, int i3, float f, int i4, int i5, List<byte[]> list) {
        List list2;
        this.a = str;
        this.b = i;
        this.c = j;
        this.d = i2;
        this.e = i3;
        this.f = f;
        this.g = i4;
        this.h = i5;
        if (list2 == null) {
            list2 = Collections.emptyList();
        }
        this.i = list2;
        this.j = -1;
        this.k = -1;
    }

    public static k a(String str) {
        return a(str, -1);
    }

    public static k a(String str, int i, int i2, int i3, List<byte[]> list) {
        return b(str, i, -1, i2, i3, list);
    }

    public static k a(String str, int i, long j, int i2, int i3, float f, List<byte[]> list) {
        return new k(str, i, j, i2, i3, f, -1, -1, list);
    }

    public static k a(String str, int i, long j, int i2, int i3, List<byte[]> list) {
        return a(str, i, j, i2, i3, 1.0f, list);
    }

    public static k a(String str, long j) {
        return b(str, j);
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    private final void a(MediaFormat mediaFormat) {
        a(mediaFormat, "max-width", this.j);
        a(mediaFormat, "max-height", this.k);
    }

    @TargetApi(16)
    private static final void a(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    @TargetApi(16)
    private static final void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static k b(String str, int i, long j, int i2, int i3, List<byte[]> list) {
        return new k(str, i, j, -1, -1, -1.0f, i2, i3, list);
    }

    public static k b(String str, long j) {
        return new k(str, -1, j, -1, -1, -1.0f, -1, -1, null);
    }

    private boolean b(k kVar, boolean z) {
        if (this.b != kVar.b || this.d != kVar.d || this.e != kVar.e || this.f != kVar.f) {
            return false;
        }
        if ((!z && (this.j != kVar.j || this.k != kVar.k)) || this.g != kVar.g || this.h != kVar.h || !m.a(this.a, kVar.a) || this.i.size() != kVar.i.size()) {
            return false;
        }
        for (int i = 0; i < this.i.size(); i++) {
            if (!Arrays.equals((byte[]) this.i.get(i), (byte[]) kVar.i.get(i))) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(16)
    public final MediaFormat a() {
        if (this.m == null) {
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", this.a);
            a(mediaFormat, "max-input-size", this.b);
            a(mediaFormat, VastIconXmlManager.WIDTH, this.d);
            a(mediaFormat, VastIconXmlManager.HEIGHT, this.e);
            a(mediaFormat, "channel-count", this.g);
            a(mediaFormat, "sample-rate", this.h);
            a(mediaFormat, "com.google.android.videos.pixelWidthHeightRatio", this.f);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.i.size()) {
                    break;
                }
                mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap((byte[]) this.i.get(i2)));
                i = i2 + 1;
            }
            if (this.c != -1) {
                mediaFormat.setLong("durationUs", this.c);
            }
            a(mediaFormat);
            this.m = mediaFormat;
        }
        return this.m;
    }

    public void a(int i, int i2) {
        this.j = i;
        this.k = i2;
        if (this.m != null) {
            a(this.m);
        }
    }

    public boolean a(k kVar, boolean z) {
        return this == kVar ? true : kVar == null ? false : b(kVar, z);
    }

    public boolean equals(Object obj) {
        return this == obj ? true : (obj == null || getClass() != obj.getClass()) ? false : b((k) obj, false);
    }

    public int hashCode() {
        int i = 0;
        if (this.l == 0) {
            int hashCode = (((((((((((((((((((this.a == null ? 0 : this.a.hashCode()) + 527) * 31) + this.b) * 31) + this.d) * 31) + this.e) * 31) + Float.floatToRawIntBits(this.f)) * 31) + ((int) this.c)) * 31) + this.j) * 31) + this.k) * 31) + this.g) * 31) + this.h;
            while (i < this.i.size()) {
                hashCode = Arrays.hashCode((byte[]) this.i.get(i)) + (hashCode * 31);
                i++;
            }
            this.l = hashCode;
        }
        return this.l;
    }

    public String toString() {
        return "MediaFormat(" + this.a + ", " + this.b + ", " + this.d + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h + ", " + this.c + ", " + this.j + ", " + this.k + ")";
    }
}
