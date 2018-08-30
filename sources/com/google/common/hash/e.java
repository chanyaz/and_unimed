package com.google.common.hash;

enum e implements Strategy {
    MURMUR128_MITZ_32 {
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, f fVar) {
            long c = i.a().hashObject(t, funnel).c();
            int i2 = (int) c;
            int i3 = (int) (c >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 ^= -1;
                }
                if (!fVar.b(i5 % fVar.a())) {
                    return false;
                }
            }
            return true;
        }

        public <T> boolean put(T t, Funnel<? super T> funnel, int i, f fVar) {
            long c = i.a().hashObject(t, funnel).c();
            int i2 = (int) c;
            int i3 = (int) (c >>> 32);
            boolean z = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 ^= -1;
                }
                z |= fVar.a(i5 % fVar.a());
            }
            return z;
        }
    }
}
