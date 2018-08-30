package com.puzzlersworld.a.a;

import com.fasterxml.jackson.databind.ObjectReader;
import okhttp3.ai;
import retrofit2.Converter;

public class c<T> implements Converter<ai, T> {
    private final ObjectReader a;

    c(ObjectReader objectReader) {
        this.a = objectReader;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0051 A:{SYNTHETIC, Splitter: B:28:0x0051} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A:{Catch:{ IOException -> 0x005f }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005b A:{Catch:{ IOException -> 0x005f }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0051 A:{SYNTHETIC, Splitter: B:28:0x0051} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A:{Catch:{ IOException -> 0x005f }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005b A:{Catch:{ IOException -> 0x005f }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0051 A:{SYNTHETIC, Splitter: B:28:0x0051} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A:{Catch:{ IOException -> 0x005f }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005b A:{Catch:{ IOException -> 0x005f }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0051 A:{SYNTHETIC, Splitter: B:28:0x0051} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A:{Catch:{ IOException -> 0x005f }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005b A:{Catch:{ IOException -> 0x005f }} */
    /* renamed from: a */
    public T convert(okhttp3.ai r7) {
        /*
        r6 = this;
        r1 = 0;
        r3 = "UTF-8";
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x0045, all -> 0x0061 }
        r2 = r7.d();	 Catch:{ Exception -> 0x0045, all -> 0x0061 }
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x0045, all -> 0x0061 }
        r2 = "﻿";
        r2 = r0.startsWith(r2);	 Catch:{ Exception -> 0x0045, all -> 0x0061 }
        if (r2 == 0) goto L_0x001c;
    L_0x0014:
        r2 = "﻿";
        r4 = "";
        r0 = r0.replace(r2, r4);	 Catch:{ Exception -> 0x0045, all -> 0x0061 }
    L_0x001c:
        r4 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0045, all -> 0x0061 }
        r0 = r0.getBytes(r3);	 Catch:{ Exception -> 0x0045, all -> 0x0061 }
        r4.<init>(r0);	 Catch:{ Exception -> 0x0045, all -> 0x0061 }
        r2 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x006f, all -> 0x0065 }
        r2.<init>(r4, r3);	 Catch:{ Exception -> 0x006f, all -> 0x0065 }
        r3 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0073, all -> 0x0068 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0073, all -> 0x0068 }
        r0 = r6.a;	 Catch:{ Exception -> 0x0079, all -> 0x006c }
        r0 = r0.readValue(r3);	 Catch:{ Exception -> 0x0079, all -> 0x006c }
        if (r3 == 0) goto L_0x003a;
    L_0x0037:
        r3.close();	 Catch:{ IOException -> 0x007e }
    L_0x003a:
        if (r2 == 0) goto L_0x003f;
    L_0x003c:
        r2.close();	 Catch:{ IOException -> 0x007e }
    L_0x003f:
        if (r4 == 0) goto L_0x0044;
    L_0x0041:
        r4.close();	 Catch:{ IOException -> 0x007e }
    L_0x0044:
        return r0;
    L_0x0045:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
    L_0x0048:
        r0.printStackTrace();	 Catch:{ all -> 0x004c }
        throw r0;	 Catch:{ all -> 0x004c }
    L_0x004c:
        r0 = move-exception;
        r4 = r3;
        r3 = r2;
    L_0x004f:
        if (r3 == 0) goto L_0x0054;
    L_0x0051:
        r3.close();	 Catch:{ IOException -> 0x005f }
    L_0x0054:
        if (r1 == 0) goto L_0x0059;
    L_0x0056:
        r1.close();	 Catch:{ IOException -> 0x005f }
    L_0x0059:
        if (r4 == 0) goto L_0x005e;
    L_0x005b:
        r4.close();	 Catch:{ IOException -> 0x005f }
    L_0x005e:
        throw r0;
    L_0x005f:
        r1 = move-exception;
        goto L_0x005e;
    L_0x0061:
        r0 = move-exception;
        r3 = r1;
        r4 = r1;
        goto L_0x004f;
    L_0x0065:
        r0 = move-exception;
        r3 = r1;
        goto L_0x004f;
    L_0x0068:
        r0 = move-exception;
        r3 = r1;
        r1 = r2;
        goto L_0x004f;
    L_0x006c:
        r0 = move-exception;
        r1 = r2;
        goto L_0x004f;
    L_0x006f:
        r0 = move-exception;
        r2 = r1;
        r3 = r4;
        goto L_0x0048;
    L_0x0073:
        r0 = move-exception;
        r3 = r4;
        r5 = r1;
        r1 = r2;
        r2 = r5;
        goto L_0x0048;
    L_0x0079:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x0048;
    L_0x007e:
        r1 = move-exception;
        goto L_0x0044;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.puzzlersworld.a.a.c.a(okhttp3.ai):T");
    }
}
