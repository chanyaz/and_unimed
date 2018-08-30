package com.mopub.common;

import android.os.AsyncTask;
import com.mopub.common.CacheService.DiskLruCacheGetListener;

class b extends AsyncTask<Void, Void, byte[]> {
    private final DiskLruCacheGetListener a;
    private final String b;

    b(String str, DiskLruCacheGetListener diskLruCacheGetListener) {
        this.a = diskLruCacheGetListener;
        this.b = str;
    }

    /* renamed from: a */
    protected void onPostExecute(byte[] bArr) {
        if (isCancelled()) {
            onCancelled();
        } else if (this.a != null) {
            this.a.onComplete(this.b, bArr);
        }
    }

    /* renamed from: a */
    protected byte[] doInBackground(Void... voidArr) {
        return CacheService.getFromDiskCache(this.b);
    }

    protected void onCancelled() {
        if (this.a != null) {
            this.a.onComplete(this.b, null);
        }
    }
}
