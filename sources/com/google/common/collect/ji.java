package com.google.common.collect;

import javax.annotation.Nullable;

enum ji {
    SIZE {
        int a(jj<?> jjVar) {
            return jjVar.b;
        }

        long b(@Nullable jj<?> jjVar) {
            return jjVar == null ? 0 : jjVar.d;
        }
    },
    DISTINCT {
        int a(jj<?> jjVar) {
            return 1;
        }

        long b(@Nullable jj<?> jjVar) {
            return jjVar == null ? 0 : (long) jjVar.c;
        }
    };

    abstract int a(jj<?> jjVar);

    abstract long b(@Nullable jj<?> jjVar);
}
