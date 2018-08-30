package com.mopub.common;

import com.appnext.base.b.c;
import com.mopub.common.DiskLruCache.AnonymousClass1;
import com.mopub.common.DiskLruCache.Editor;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class f {
    final /* synthetic */ DiskLruCache a;
    private final String b;
    private final long[] c;
    private boolean d;
    private Editor e;
    private long f;

    private f(DiskLruCache diskLruCache, String str) {
        this.a = diskLruCache;
        this.b = str;
        this.c = new long[diskLruCache.i];
    }

    /* synthetic */ f(DiskLruCache diskLruCache, String str, AnonymousClass1 anonymousClass1) {
        this(diskLruCache, str);
    }

    private void a(String[] strArr) {
        if (strArr.length != this.a.i) {
            throw b(strArr);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                this.c[i] = Long.parseLong(strArr[i]);
                i++;
            } catch (NumberFormatException e) {
                throw b(strArr);
            }
        }
    }

    private IOException b(String[] strArr) {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    public File getCleanFile(int i) {
        return new File(this.a.c, this.b + "." + i);
    }

    public File getDirtyFile(int i) {
        return new File(this.a.c, this.b + "." + i + c.jh);
    }

    public String getLengths() {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : this.c) {
            stringBuilder.append(' ').append(append);
        }
        return stringBuilder.toString();
    }
}
