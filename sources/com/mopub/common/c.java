package com.mopub.common;

import android.os.AsyncTask;

class c extends AsyncTask<Void, Void, Void> {
    private final String a;
    private final byte[] b;

    c(String str, byte[] bArr) {
        this.a = str;
        this.b = bArr;
    }

    /* renamed from: a */
    protected Void doInBackground(Void... voidArr) {
        CacheService.putToDiskCache(this.a, this.b);
        return null;
    }
}
