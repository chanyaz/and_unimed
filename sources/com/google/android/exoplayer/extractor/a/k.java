package com.google.android.exoplayer.extractor.a;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.i;
import com.google.android.exoplayer.util.m;

final class k {
    private static final int[] a = new int[]{m.c("isom"), m.c("iso2"), m.c("avc1"), m.c("hvc1"), m.c("hev1"), m.c("mp41"), m.c("mp42"), m.c("3g2a"), m.c("3g2b"), m.c("3gr6"), m.c("3gs6"), m.c("3ge6"), m.c("3gg6"), m.c("M4V "), m.c("M4A "), m.c("f4v "), m.c("kddi"), m.c("M4VP"), m.c("qt  "), m.c("MSNV")};

    private k() {
    }

    private static boolean a(int i) {
        if ((i >>> 8) == m.c("3gp")) {
            return true;
        }
        for (int i2 : a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(ExtractorInput extractorInput) {
        return a(extractorInput, 4096, true);
    }

    private static boolean a(ExtractorInput extractorInput, int i, boolean z) {
        long length = extractorInput.getLength();
        if (length == -1 || length > ((long) i)) {
            length = (long) i;
        }
        int i2 = (int) length;
        i iVar = new i(64);
        Object obj = null;
        boolean z2 = false;
        long k;
        for (int i3 = 0; i3 < i2; i3 = (int) (((long) i3) + k)) {
            int i4;
            extractorInput.peekFully(iVar.a, 0, 8);
            iVar.b(0);
            long i5 = iVar.i();
            int j = iVar.j();
            if (i5 == 1) {
                extractorInput.peekFully(iVar.a, 8, 8);
                i4 = 16;
                k = iVar.k();
            } else {
                long j2 = i5;
                i4 = 8;
                k = j2;
            }
            if (k < ((long) i4) || k > 2147483647L) {
                return false;
            }
            if (((long) i3) + k > ((long) i2)) {
                break;
            }
            i4 = ((int) k) - i4;
            if (j == a.a) {
                if (i4 < 8) {
                    return false;
                }
                int i6 = (i4 - 8) / 4;
                extractorInput.peekFully(iVar.a, 0, (i6 + 2) * 4);
                for (i4 = 0; i4 < i6 + 2; i4++) {
                    if (i4 != 1 && a(iVar.j())) {
                        obj = 1;
                        break;
                    }
                }
            } else if (j == a.B) {
                z2 = true;
                break;
            } else if (i4 != 0) {
                extractorInput.advancePeekPosition(i4);
            }
        }
        return obj != null && z == z2;
    }

    public static boolean b(ExtractorInput extractorInput) {
        return a(extractorInput, 128, false);
    }
}
