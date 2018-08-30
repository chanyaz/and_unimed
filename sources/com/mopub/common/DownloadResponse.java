package com.mopub.common;

import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Streams;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class DownloadResponse {
    private byte[] a = new byte[0];
    private final int b;
    private final long c;
    private final Header[] d;

    public DownloadResponse(HttpResponse httpResponse) {
        Throwable th;
        Closeable byteArrayOutputStream = new ByteArrayOutputStream();
        Closeable closeable = null;
        try {
            Closeable bufferedInputStream;
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                bufferedInputStream = new BufferedInputStream(entity.getContent());
                try {
                    Streams.copyContent(bufferedInputStream, byteArrayOutputStream);
                    this.a = byteArrayOutputStream.toByteArray();
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    closeable = bufferedInputStream;
                    th = th3;
                    Streams.closeStream(closeable);
                    Streams.closeStream(byteArrayOutputStream);
                    throw th;
                }
            }
            bufferedInputStream = null;
            Streams.closeStream(bufferedInputStream);
            Streams.closeStream(byteArrayOutputStream);
            this.b = httpResponse.getStatusLine().getStatusCode();
            this.c = (long) this.a.length;
            this.d = httpResponse.getAllHeaders();
        } catch (Throwable th4) {
            th = th4;
            Streams.closeStream(closeable);
            Streams.closeStream(byteArrayOutputStream);
            throw th;
        }
    }

    public byte[] getByteArray() {
        return this.a;
    }

    public long getContentLength() {
        return this.c;
    }

    public String getFirstHeader(ResponseHeader responseHeader) {
        for (Header header : this.d) {
            if (header.getName().equalsIgnoreCase(responseHeader.getKey())) {
                return header.getValue();
            }
        }
        return null;
    }

    public int getStatusCode() {
        return this.b;
    }
}
