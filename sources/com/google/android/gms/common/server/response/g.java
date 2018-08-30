package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

final class g implements zza<Long> {
    g() {
    }

    public final /* synthetic */ Object zzh(FastParser fastParser, BufferedReader bufferedReader) {
        return Long.valueOf(fastParser.c(bufferedReader));
    }
}
