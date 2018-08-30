package com.google.android.exoplayer.extractor.webm;

import android.util.Pair;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class g {
    public String a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public byte[] f;
    public byte[] g;
    public byte[] h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public long n;
    public long o;
    public TrackOutput p;

    private g() {
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.o = -1;
    }

    private static Pair<List<byte[]>, Integer> a(i iVar) {
        int i = 0;
        try {
            int i2;
            iVar.b(4);
            int f = (iVar.f() & 3) + 1;
            b.b(f != 3);
            List arrayList = new ArrayList();
            int f2 = iVar.f() & 31;
            for (i2 = 0; i2 < f2; i2++) {
                arrayList.add(com.google.android.exoplayer.util.g.a(iVar));
            }
            i2 = iVar.f();
            while (i < i2) {
                arrayList.add(com.google.android.exoplayer.util.g.a(iVar));
                i++;
            }
            return Pair.create(arrayList, Integer.valueOf(f));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error parsing AVC codec private");
        }
    }

    private static List<byte[]> a(byte[] bArr) {
        int i = 0;
        try {
            if (bArr[0] != (byte) 2) {
                throw new ParserException("Error parsing vorbis codec private");
            }
            int i2 = 0;
            int i3 = 1;
            while (bArr[i3] == (byte) -1) {
                i3++;
                i2 += 255;
            }
            int i4 = i3 + 1;
            i2 += bArr[i3];
            while (bArr[i4] == (byte) -1) {
                i += 255;
                i4++;
            }
            i3 = i4 + 1;
            i += bArr[i4];
            if (bArr[i3] != (byte) 1) {
                throw new ParserException("Error parsing vorbis codec private");
            }
            Object obj = new byte[i2];
            System.arraycopy(bArr, i3, obj, 0, i2);
            i2 += i3;
            if (bArr[i2] != (byte) 3) {
                throw new ParserException("Error parsing vorbis codec private");
            }
            i += i2;
            if (bArr[i] != (byte) 5) {
                throw new ParserException("Error parsing vorbis codec private");
            }
            Object obj2 = new byte[(bArr.length - i)];
            System.arraycopy(bArr, i, obj2, 0, bArr.length - i);
            List<byte[]> arrayList = new ArrayList(2);
            arrayList.add(obj);
            arrayList.add(obj2);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error parsing vorbis codec private");
        }
    }

    private static Pair<List<byte[]>, Integer> b(i iVar) {
        try {
            int g;
            int i;
            int i2;
            iVar.b(21);
            int f = iVar.f() & 3;
            int f2 = iVar.f();
            int d = iVar.d();
            int i3 = 0;
            int i4 = 0;
            while (i3 < f2) {
                iVar.c(1);
                g = iVar.g();
                i = i4;
                for (i2 = 0; i2 < g; i2++) {
                    i4 = iVar.g();
                    i += i4 + 4;
                    iVar.c(i4);
                }
                i3++;
                i4 = i;
            }
            iVar.b(d);
            Object obj = new byte[i4];
            i3 = 0;
            i2 = 0;
            while (i3 < f2) {
                iVar.c(1);
                g = iVar.g();
                i = i2;
                for (i2 = 0; i2 < g; i2++) {
                    int g2 = iVar.g();
                    System.arraycopy(com.google.android.exoplayer.util.g.a, 0, obj, i, com.google.android.exoplayer.util.g.a.length);
                    i += com.google.android.exoplayer.util.g.a.length;
                    System.arraycopy(iVar.a, iVar.d(), obj, i, g2);
                    i += g2;
                    iVar.c(g2);
                }
                i3++;
                i2 = i;
            }
            return Pair.create(i4 == 0 ? null : Collections.singletonList(obj), Integer.valueOf(f + 1));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error parsing HEVC codec private");
        }
    }

    public com.google.android.exoplayer.k a(long r8) {
        /*
        r7 = this;
        r0 = 0;
        r6 = 64;
        r3 = 3;
        r2 = -1;
        r1 = r7.a;
        r4 = r1.hashCode();
        switch(r4) {
            case -2095576542: goto L_0x0042;
            case -2095575984: goto L_0x002e;
            case -1730367663: goto L_0x0060;
            case -1482641357: goto L_0x0080;
            case -538363189: goto L_0x0038;
            case -538363109: goto L_0x004c;
            case 62923557: goto L_0x0075;
            case 62923603: goto L_0x008b;
            case 82338133: goto L_0x001a;
            case 82338134: goto L_0x0024;
            case 855502857: goto L_0x0056;
            case 1951062397: goto L_0x006a;
            default: goto L_0x000e;
        };
    L_0x000e:
        r1 = r2;
    L_0x000f:
        switch(r1) {
            case 0: goto L_0x0097;
            case 1: goto L_0x00ac;
            case 2: goto L_0x00b2;
            case 3: goto L_0x00b2;
            case 4: goto L_0x00b2;
            case 5: goto L_0x00c3;
            case 6: goto L_0x00e2;
            case 7: goto L_0x0101;
            case 8: goto L_0x010e;
            case 9: goto L_0x0142;
            case 10: goto L_0x014f;
            case 11: goto L_0x0157;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = new com.google.android.exoplayer.ParserException;
        r1 = "Unrecognized codec identifier.";
        r0.<init>(r1);
        throw r0;
    L_0x001a:
        r4 = "V_VP8";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x000e;
    L_0x0022:
        r1 = 0;
        goto L_0x000f;
    L_0x0024:
        r4 = "V_VP9";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x000e;
    L_0x002c:
        r1 = 1;
        goto L_0x000f;
    L_0x002e:
        r4 = "V_MPEG4/ISO/SP";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x000e;
    L_0x0036:
        r1 = 2;
        goto L_0x000f;
    L_0x0038:
        r4 = "V_MPEG4/ISO/ASP";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x000e;
    L_0x0040:
        r1 = r3;
        goto L_0x000f;
    L_0x0042:
        r4 = "V_MPEG4/ISO/AP";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x000e;
    L_0x004a:
        r1 = 4;
        goto L_0x000f;
    L_0x004c:
        r4 = "V_MPEG4/ISO/AVC";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x000e;
    L_0x0054:
        r1 = 5;
        goto L_0x000f;
    L_0x0056:
        r4 = "V_MPEGH/ISO/HEVC";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x000e;
    L_0x005e:
        r1 = 6;
        goto L_0x000f;
    L_0x0060:
        r4 = "A_VORBIS";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x000e;
    L_0x0068:
        r1 = 7;
        goto L_0x000f;
    L_0x006a:
        r4 = "A_OPUS";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x000e;
    L_0x0072:
        r1 = 8;
        goto L_0x000f;
    L_0x0075:
        r4 = "A_AAC";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x000e;
    L_0x007d:
        r1 = 9;
        goto L_0x000f;
    L_0x0080:
        r4 = "A_MPEG/L3";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x000e;
    L_0x0088:
        r1 = 10;
        goto L_0x000f;
    L_0x008b:
        r4 = "A_AC3";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x000e;
    L_0x0093:
        r1 = 11;
        goto L_0x000f;
    L_0x0097:
        r1 = "video/x-vnd.on2.vp8";
        r6 = r0;
        r0 = r1;
        r1 = r2;
    L_0x009c:
        r2 = com.google.android.exoplayer.util.e.b(r0);
        if (r2 == 0) goto L_0x015e;
    L_0x00a2:
        r4 = r7.l;
        r5 = r7.m;
        r2 = r8;
        r0 = com.google.android.exoplayer.k.b(r0, r1, r2, r4, r5, r6);
    L_0x00ab:
        return r0;
    L_0x00ac:
        r1 = "video/x-vnd.on2.vp9";
        r6 = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x009c;
    L_0x00b2:
        r1 = "video/mp4v-es";
        r3 = r7.h;
        if (r3 != 0) goto L_0x00bc;
    L_0x00b8:
        r6 = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x009c;
    L_0x00bc:
        r0 = r7.h;
        r0 = java.util.Collections.singletonList(r0);
        goto L_0x00b8;
    L_0x00c3:
        r3 = "video/avc";
        r0 = new com.google.android.exoplayer.util.i;
        r1 = r7.h;
        r0.<init>(r1);
        r1 = a(r0);
        r0 = r1.first;
        r0 = (java.util.List) r0;
        r1 = r1.second;
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r7.k = r1;
        r1 = r2;
        r6 = r0;
        r0 = r3;
        goto L_0x009c;
    L_0x00e2:
        r3 = "video/hevc";
        r0 = new com.google.android.exoplayer.util.i;
        r1 = r7.h;
        r0.<init>(r1);
        r1 = b(r0);
        r0 = r1.first;
        r0 = (java.util.List) r0;
        r1 = r1.second;
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r7.k = r1;
        r1 = r2;
        r6 = r0;
        r0 = r3;
        goto L_0x009c;
    L_0x0101:
        r2 = "audio/vorbis";
        r1 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = r7.h;
        r0 = a(r0);
        r6 = r0;
        r0 = r2;
        goto L_0x009c;
    L_0x010e:
        r2 = "audio/opus";
        r1 = 5760; // 0x1680 float:8.071E-42 double:2.846E-320;
        r0 = new java.util.ArrayList;
        r0.<init>(r3);
        r3 = r7.h;
        r0.add(r3);
        r3 = java.nio.ByteBuffer.allocate(r6);
        r4 = r7.n;
        r3 = r3.putLong(r4);
        r3 = r3.array();
        r0.add(r3);
        r3 = java.nio.ByteBuffer.allocate(r6);
        r4 = r7.o;
        r3 = r3.putLong(r4);
        r3 = r3.array();
        r0.add(r3);
        r6 = r0;
        r0 = r2;
        goto L_0x009c;
    L_0x0142:
        r1 = "audio/mp4a-latm";
        r0 = r7.h;
        r0 = java.util.Collections.singletonList(r0);
        r6 = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x009c;
    L_0x014f:
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r2 = "audio/mpeg";
        r6 = r0;
        r0 = r2;
        goto L_0x009c;
    L_0x0157:
        r1 = "audio/ac3";
        r6 = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x009c;
    L_0x015e:
        r2 = com.google.android.exoplayer.util.e.c(r0);
        if (r2 == 0) goto L_0x016f;
    L_0x0164:
        r4 = r7.i;
        r5 = r7.j;
        r2 = r8;
        r0 = com.google.android.exoplayer.k.a(r0, r1, r2, r4, r5, r6);
        goto L_0x00ab;
    L_0x016f:
        r0 = new com.google.android.exoplayer.ParserException;
        r1 = "Unexpected MIME type.";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer.extractor.webm.g.a(long):com.google.android.exoplayer.k");
    }
}
