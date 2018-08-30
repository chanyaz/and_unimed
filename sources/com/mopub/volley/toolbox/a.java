package com.mopub.volley.toolbox;

import com.mopub.volley.Cache.Entry;
import com.mopub.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

class a {
    public String etag;
    public String key;
    public Map<String, String> responseHeaders;
    public long serverDate;
    public long size;
    public long softTtl;
    public long ttl;

    private a() {
    }

    public a(String str, Entry entry) {
        this.key = str;
        this.size = (long) entry.data.length;
        this.etag = entry.etag;
        this.serverDate = entry.serverDate;
        this.ttl = entry.ttl;
        this.softTtl = entry.softTtl;
        this.responseHeaders = entry.responseHeaders;
    }

    public static a readHeader(InputStream inputStream) {
        a aVar = new a();
        if (DiskBasedCache.a(inputStream) != 538183203) {
            throw new IOException();
        }
        aVar.key = DiskBasedCache.c(inputStream);
        aVar.etag = DiskBasedCache.c(inputStream);
        if (aVar.etag.equals("")) {
            aVar.etag = null;
        }
        aVar.serverDate = DiskBasedCache.b(inputStream);
        aVar.ttl = DiskBasedCache.b(inputStream);
        aVar.softTtl = DiskBasedCache.b(inputStream);
        aVar.responseHeaders = DiskBasedCache.d(inputStream);
        return aVar;
    }

    public Entry toCacheEntry(byte[] bArr) {
        Entry entry = new Entry();
        entry.data = bArr;
        entry.etag = this.etag;
        entry.serverDate = this.serverDate;
        entry.ttl = this.ttl;
        entry.softTtl = this.softTtl;
        entry.responseHeaders = this.responseHeaders;
        return entry;
    }

    public boolean writeHeader(OutputStream outputStream) {
        try {
            DiskBasedCache.a(outputStream, 538183203);
            DiskBasedCache.a(outputStream, this.key);
            DiskBasedCache.a(outputStream, this.etag == null ? "" : this.etag);
            DiskBasedCache.a(outputStream, this.serverDate);
            DiskBasedCache.a(outputStream, this.ttl);
            DiskBasedCache.a(outputStream, this.softTtl);
            DiskBasedCache.a(this.responseHeaders, outputStream);
            outputStream.flush();
            return true;
        } catch (IOException e) {
            VolleyLog.d("%s", e.toString());
            return false;
        }
    }
}
