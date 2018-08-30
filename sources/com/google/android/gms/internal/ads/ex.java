package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

final class ex extends fr {
    private final zzar a;

    ex(zzar zzar) {
        this.a = zzar;
    }

    public final mw a(apk<?> apk, Map<String, String> map) {
        try {
            HttpResponse zzb = this.a.zzb(apk, map);
            int statusCode = zzb.getStatusLine().getStatusCode();
            Header[] allHeaders = zzb.getAllHeaders();
            List arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new akt(header.getName(), header.getValue()));
            }
            if (zzb.getEntity() == null) {
                return new mw(statusCode, arrayList);
            }
            long contentLength = zzb.getEntity().getContentLength();
            if (((long) ((int) contentLength)) == contentLength) {
                return new mw(statusCode, arrayList, (int) zzb.getEntity().getContentLength(), zzb.getEntity().getContent());
            }
            throw new IOException("Response too large: " + contentLength);
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
