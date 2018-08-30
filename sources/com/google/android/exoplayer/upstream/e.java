package com.google.android.exoplayer.upstream;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer.upstream.HttpDataSource.HttpDataSourceException;
import com.google.android.exoplayer.upstream.HttpDataSource.InvalidContentTypeException;
import com.google.android.exoplayer.upstream.HttpDataSource.InvalidResponseCodeException;
import com.google.android.exoplayer.util.Predicate;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.m;
import com.mopub.common.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e implements HttpDataSource {
    private static final Pattern b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> c = new AtomicReference();
    private final boolean d;
    private final int e;
    private final int f;
    private final String g;
    private final Predicate<String> h;
    private final HashMap<String, String> i = new HashMap();
    private final TransferListener j;
    private c k;
    private HttpURLConnection l;
    private InputStream m;
    private boolean n;
    private long o;
    private long p;
    private long q;
    private long r;

    public e(String str, Predicate<String> predicate, TransferListener transferListener, int i, int i2, boolean z) {
        this.g = b.a(str);
        this.h = predicate;
        this.j = transferListener;
        this.e = i;
        this.f = i2;
        this.d = z;
    }

    private int a(byte[] bArr, int i, int i2) {
        if (this.p != -1) {
            i2 = (int) Math.min((long) i2, this.p - this.r);
        }
        if (i2 == 0) {
            return -1;
        }
        int read = this.m.read(bArr, i, i2);
        if (read != -1) {
            this.r += (long) read;
            if (this.j != null) {
                this.j.onBytesTransferred(read);
            }
            return read;
        } else if (this.p == -1 || this.p == this.r) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    private static long a(HttpURLConnection httpURLConnection) {
        long j = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException e) {
                Log.e("HttpDataSource", "Unexpected Content-Length [" + headerField + "]");
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = b.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return parseLong;
            }
            if (j == parseLong) {
                return j;
            }
            Log.w("HttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
            return Math.max(j, parseLong);
        } catch (NumberFormatException e2) {
            Log.e("HttpDataSource", "Unexpected Content-Range [" + headerField2 + "]");
            return j;
        }
    }

    private HttpURLConnection a(c cVar) {
        URL url = new URL(cVar.a.toString());
        byte[] bArr = cVar.b;
        long j = cVar.d;
        long j2 = cVar.e;
        boolean z = (cVar.g & 1) != 0;
        if (!this.d) {
            return a(url, bArr, j, j2, z, true);
        }
        HttpURLConnection a;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i <= 20) {
                a = a(url, bArr, j, j2, z, false);
                int responseCode = a.getResponseCode();
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                    bArr = null;
                    String headerField = a.getHeaderField("Location");
                    a.disconnect();
                    url = a(url, headerField);
                    i = i2;
                }
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i2);
            }
        }
        return a;
    }

    private HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.e);
        httpURLConnection.setReadTimeout(this.f);
        synchronized (this.i) {
            for (Entry entry : this.i.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (!(j == 0 && j2 == -1)) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.g);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static URL a(URL url, String str) {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if (Constants.HTTPS.equals(protocol) || Constants.HTTP.equals(protocol)) {
            return url2;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + protocol);
    }

    private void b() {
        if (this.q != this.o) {
            Object obj = (byte[]) c.getAndSet(null);
            if (obj == null) {
                obj = new byte[4096];
            }
            while (this.q != this.o) {
                int read = this.m.read(obj, 0, (int) Math.min(this.o - this.q, (long) obj.length));
                if (Thread.interrupted()) {
                    throw new InterruptedIOException();
                } else if (read == -1) {
                    throw new EOFException();
                } else {
                    this.q += (long) read;
                    if (this.j != null) {
                        this.j.onBytesTransferred(read);
                    }
                }
            }
            c.set(obj);
        }
    }

    private void c() {
        if (this.l != null) {
            this.l.disconnect();
            this.l = null;
        }
    }

    protected final long a() {
        return this.p == -1 ? this.p : this.p - this.r;
    }

    public void clearAllRequestProperties() {
        synchronized (this.i) {
            this.i.clear();
        }
    }

    public void clearRequestProperty(String str) {
        b.a((Object) str);
        synchronized (this.i) {
            this.i.remove(str);
        }
    }

    public void close() {
        try {
            if (this.m != null) {
                m.a(this.l, a());
                this.m.close();
            }
            this.m = null;
            c();
            if (this.n) {
                this.n = false;
                if (this.j != null) {
                    this.j.onTransferEnd();
                }
            }
        } catch (IOException e) {
            throw new HttpDataSourceException(e, this.k);
        } catch (Throwable th) {
            this.m = null;
            c();
            if (this.n) {
                this.n = false;
                if (this.j != null) {
                    this.j.onTransferEnd();
                }
            }
        }
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.l == null ? null : this.l.getHeaderFields();
    }

    public String getUri() {
        return this.l == null ? null : this.l.getURL().toString();
    }

    public long open(c cVar) {
        long j = 0;
        this.k = cVar;
        this.r = 0;
        this.q = 0;
        try {
            this.l = a(cVar);
            try {
                int responseCode = this.l.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map headerFields = this.l.getHeaderFields();
                    c();
                    throw new InvalidResponseCodeException(responseCode, headerFields, cVar);
                }
                String contentType = this.l.getContentType();
                if (this.h == null || this.h.evaluate(contentType)) {
                    if (responseCode == 200 && cVar.d != 0) {
                        j = cVar.d;
                    }
                    this.o = j;
                    if ((cVar.g & 1) == 0) {
                        j = a(this.l);
                        j = cVar.e != -1 ? cVar.e : j != -1 ? j - this.o : -1;
                        this.p = j;
                    } else {
                        this.p = cVar.e;
                    }
                    try {
                        this.m = this.l.getInputStream();
                        this.n = true;
                        if (this.j != null) {
                            this.j.onTransferStart();
                        }
                        return this.p;
                    } catch (IOException e) {
                        c();
                        throw new HttpDataSourceException(e, cVar);
                    }
                }
                c();
                throw new InvalidContentTypeException(contentType, cVar);
            } catch (IOException e2) {
                c();
                throw new HttpDataSourceException("Unable to connect to " + cVar.a.toString(), e2, cVar);
            }
        } catch (IOException e22) {
            throw new HttpDataSourceException("Unable to connect to " + cVar.a.toString(), e22, cVar);
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            b();
            return a(bArr, i, i2);
        } catch (IOException e) {
            throw new HttpDataSourceException(e, this.k);
        }
    }

    public void setRequestProperty(String str, String str2) {
        b.a((Object) str);
        b.a((Object) str2);
        synchronized (this.i) {
            this.i.put(str, str2);
        }
    }
}
