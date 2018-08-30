package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.HttpDataSource;
import com.google.android.exoplayer.upstream.c;
import com.google.android.exoplayer.upstream.e;
import com.mopub.common.CacheService;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent.Category;
import com.mopub.common.event.BaseEvent.Name;
import com.mopub.common.event.BaseEvent.SamplingRate;
import com.mopub.common.event.Event;
import com.mopub.common.event.EventDetails;
import com.mopub.common.event.MoPubEvents;
import com.mopub.common.logging.MoPubLog;
import java.util.Iterator;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class HttpDiskCompositeDataSource implements DataSource {
    @NonNull
    private final HttpDataSource a;
    @Nullable
    private byte[] b;
    @Nullable
    private String c;
    @NonNull
    private final TreeSet<IntInterval> d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    @Nullable
    private Integer j;
    @Nullable
    private c k;
    private boolean l;
    @Nullable
    private final EventDetails m;
    private boolean n;

    public HttpDiskCompositeDataSource(@NonNull Context context, @NonNull String str, @Nullable EventDetails eventDetails) {
        this(context, str, eventDetails, new e(str, null, null, 8000, 8000, false));
    }

    @VisibleForTesting
    HttpDiskCompositeDataSource(@NonNull Context context, @NonNull String str, @Nullable EventDetails eventDetails, @NonNull HttpDataSource httpDataSource) {
        this.j = null;
        this.a = httpDataSource;
        CacheService.initialize(context);
        this.d = new TreeSet();
        this.m = eventDetails;
    }

    @VisibleForTesting
    static int a(int i, @NonNull TreeSet<IntInterval> treeSet) {
        Preconditions.checkNotNull(treeSet);
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            IntInterval intInterval = (IntInterval) it.next();
            if (intInterval.getStart() <= i) {
                i = Math.max(i, intInterval.getLength() + intInterval.getStart());
            }
        }
        return i;
    }

    private static Integer a(@NonNull String str) {
        Integer num = null;
        Preconditions.checkNotNull(str);
        byte[] fromDiskCache = CacheService.getFromDiskCache("expectedsize-" + str);
        if (fromDiskCache == null) {
            return num;
        }
        try {
            return Integer.valueOf(Integer.parseInt(new String(fromDiskCache)));
        } catch (NumberFormatException e) {
            return num;
        }
    }

    private void a() {
        CacheService.putToDiskCache(this.g + this.c, this.b);
        a(this.d, this.e, this.f);
        this.h = 0;
        this.e += this.f;
        this.f = 0;
        this.g = this.e / 512000;
    }

    private static void a(@NonNull String str, @NonNull TreeSet<IntInterval> treeSet) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(treeSet);
        treeSet.clear();
        byte[] fromDiskCache = CacheService.getFromDiskCache("intervals-sorted-" + str);
        if (fromDiskCache != null) {
            try {
                JSONArray jSONArray = new JSONArray(new String(fromDiskCache));
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < jSONArray.length()) {
                        JSONObject jSONObject = new JSONObject((String) jSONArray.get(i2));
                        treeSet.add(new IntInterval(jSONObject.getInt("start"), jSONObject.getInt("length")));
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            } catch (Throwable e) {
                MoPubLog.d("clearing cache since invalid json intervals found", e);
                treeSet.clear();
            } catch (ClassCastException e2) {
                MoPubLog.d("clearing cache since unable to read json data");
                treeSet.clear();
            }
        }
    }

    @VisibleForTesting
    static void a(@NonNull TreeSet<IntInterval> treeSet, int i, int i2) {
        Preconditions.checkNotNull(treeSet);
        if (a(i, (TreeSet) treeSet) < i + i2) {
            treeSet.add(new IntInterval(i, i2));
        }
    }

    private static void a(@NonNull TreeSet<IntInterval> treeSet, @NonNull String str) {
        Preconditions.checkNotNull(treeSet);
        Preconditions.checkNotNull(str);
        JSONArray jSONArray = new JSONArray();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jSONArray.put((IntInterval) it.next());
        }
        CacheService.putToDiskCache("intervals-sorted-" + str, jSONArray.toString().getBytes());
    }

    private static boolean a(int i, int i2, int i3) {
        return i > i2 + i3;
    }

    public void close() {
        if (!(TextUtils.isEmpty(this.c) || this.b == null)) {
            CacheService.putToDiskCache(this.g + this.c, this.b);
            a(this.d, this.e, this.f);
            a(this.d, this.c);
            if (this.l && this.j != null && a(0, this.d) == this.j.intValue()) {
                MoPubEvents.log(Event.createEventFromDetails(Name.DOWNLOAD_FINISHED, Category.NATIVE_VIDEO, SamplingRate.NATIVE_VIDEO, this.m));
            }
        }
        this.b = null;
        this.a.close();
        this.i = false;
        this.e = 0;
        this.f = 0;
        this.h = 0;
        this.j = null;
        this.l = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f7 A:{Catch:{ InvalidResponseCodeException -> 0x0118 }} */
    public long open(@android.support.annotation.NonNull com.google.android.exoplayer.upstream.c r13) {
        /*
        r12 = this;
        r2 = 512000; // 0x7d000 float:7.17465E-40 double:2.529616E-318;
        r9 = 0;
        r10 = -1;
        com.mopub.common.Preconditions.checkNotNull(r13);
        r0 = r13.a;
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        return r10;
    L_0x000e:
        r12.l = r9;
        r12.k = r13;
        r0 = r13.a;
        r0 = r0.toString();
        r12.c = r0;
        r0 = r12.c;
        if (r0 == 0) goto L_0x000d;
    L_0x001e:
        r0 = r13.c;
        r0 = (int) r0;
        r12.e = r0;
        r0 = r12.e;
        r0 = r0 / r2;
        r12.g = r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r12.g;
        r0 = r0.append(r1);
        r1 = r12.c;
        r0 = r0.append(r1);
        r0 = r0.toString();
        r0 = com.mopub.common.CacheService.getFromDiskCache(r0);
        r12.b = r0;
        r0 = r12.e;
        r0 = r0 % r2;
        r12.h = r0;
        r12.f = r9;
        r0 = r12.c;
        r0 = a(r0);
        r12.j = r0;
        r0 = r12.c;
        r1 = r12.d;
        a(r0, r1);
        r0 = r12.e;
        r1 = r12.d;
        r0 = a(r0, r1);
        r1 = r12.b;
        if (r1 != 0) goto L_0x014b;
    L_0x0065:
        r1 = new byte[r2];
        r12.b = r1;
        r1 = r12.e;
        if (r0 <= r1) goto L_0x014b;
    L_0x006d:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Cache segment ";
        r0 = r0.append(r1);
        r1 = r12.g;
        r0 = r0.append(r1);
        r1 = " was evicted. Invalidating cache";
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.mopub.common.logging.MoPubLog.d(r0);
        r0 = r12.d;
        r0.clear();
        r0 = r13.c;
        r0 = (int) r0;
        r8 = r0;
    L_0x0094:
        r0 = r12.j;
        if (r0 == 0) goto L_0x00a0;
    L_0x0098:
        r0 = r12.j;
        r0 = r0.intValue();
        if (r8 == r0) goto L_0x0137;
    L_0x00a0:
        r0 = r12.k;
        r0 = r0.e;
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 != 0) goto L_0x010c;
    L_0x00a8:
        r4 = r10;
    L_0x00a9:
        r0 = new com.google.android.exoplayer.upstream.c;
        r1 = r13.a;
        r2 = (long) r8;
        r6 = r13.f;
        r7 = r13.g;
        r0.<init>(r1, r2, r4, r6, r7);
        r1 = r12.a;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r0 = r1.open(r0);	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r2 = r12.j;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        if (r2 != 0) goto L_0x00f0;
    L_0x00bf:
        r2 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r2 != 0) goto L_0x00f0;
    L_0x00c3:
        r2 = r12.e;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r2 = (long) r2;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r2 = r2 + r0;
        r2 = (int) r2;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r12.j = r2;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r2 = new java.lang.StringBuilder;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r2.<init>();	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r3 = "expectedsize-";
        r2 = r2.append(r3);	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r3 = r12.c;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r2 = r2.append(r3);	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r2 = r2.toString();	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r3 = r12.j;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r3 = r3.getBytes();	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        com.mopub.common.CacheService.putToDiskCache(r2, r3);	 Catch:{ InvalidResponseCodeException -> 0x0118 }
    L_0x00f0:
        r2 = 1;
        r12.i = r2;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r2 = r12.n;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        if (r2 != 0) goto L_0x0109;
    L_0x00f7:
        r2 = com.mopub.common.event.BaseEvent.Name.DOWNLOAD_START;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r3 = com.mopub.common.event.BaseEvent.Category.NATIVE_VIDEO;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r4 = com.mopub.common.event.BaseEvent.SamplingRate.NATIVE_VIDEO;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r5 = r12.m;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r2 = com.mopub.common.event.Event.createEventFromDetails(r2, r3, r4, r5);	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        com.mopub.common.event.MoPubEvents.log(r2);	 Catch:{ InvalidResponseCodeException -> 0x0118 }
        r2 = 1;
        r12.n = r2;	 Catch:{ InvalidResponseCodeException -> 0x0118 }
    L_0x0109:
        r10 = r0;
        goto L_0x000d;
    L_0x010c:
        r0 = r12.k;
        r0 = r0.e;
        r2 = r12.e;
        r2 = r8 - r2;
        r2 = (long) r2;
        r4 = r0 - r2;
        goto L_0x00a9;
    L_0x0118:
        r0 = move-exception;
        r1 = r0.b;
        r2 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;
        if (r1 != r2) goto L_0x0136;
    L_0x011f:
        r0 = r12.j;
        if (r0 != 0) goto L_0x012b;
    L_0x0123:
        r0 = r12.e;
        r0 = r8 - r0;
        r0 = (long) r0;
    L_0x0128:
        r12.i = r9;
        goto L_0x0109;
    L_0x012b:
        r0 = r12.j;
        r0 = r0.intValue();
        r1 = r12.e;
        r0 = r0 - r1;
        r0 = (long) r0;
        goto L_0x0128;
    L_0x0136:
        throw r0;
    L_0x0137:
        r0 = r13.e;
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 != 0) goto L_0x0148;
    L_0x013d:
        r0 = r12.j;
        r0 = r0.intValue();
        r1 = r12.e;
        r0 = r0 - r1;
        r0 = (long) r0;
        goto L_0x0109;
    L_0x0148:
        r0 = r13.e;
        goto L_0x0109;
    L_0x014b:
        r8 = r0;
        goto L_0x0094;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.nativeads.HttpDiskCompositeDataSource.open(com.google.android.exoplayer.upstream.c):long");
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 > 512000) {
            MoPubLog.d("Reading more than the block size (512000 bytes) at once is not possible. length = " + i2);
            return -1;
        } else if (this.k == null) {
            MoPubLog.d("Unable to read from data source when no spec provided");
            return -1;
        } else if (this.b == null) {
            MoPubLog.d("No cache set up. Call open before read.");
            return -1;
        } else {
            int i3 = (512000 - this.h) - this.f;
            int a = a(this.e + this.f, this.d);
            int min = Math.min((a - this.e) - this.f, i2);
            if (!a(a, this.e, this.f)) {
                min = 0;
            } else if (min <= i3) {
                System.arraycopy(this.b, this.h + this.f, bArr, i, min);
                this.f += min;
                min += 0;
            } else {
                System.arraycopy(this.b, this.h + this.f, bArr, i, i3);
                this.f += i3;
                int i4 = 0 + i3;
                a();
                this.b = CacheService.getFromDiskCache(this.g + this.c);
                if (this.b == null) {
                    MoPubLog.d("Unexpected cache miss. Invalidating cache");
                    this.d.clear();
                    this.b = new byte[512000];
                    this.a.close();
                    this.a.open(new c(this.k.a, (long) (this.e + this.f), -1, this.k.f, this.k.g));
                    this.i = true;
                    min = i4;
                } else {
                    System.arraycopy(this.b, this.h + this.f, bArr, i + i4, min - i4);
                    this.f += min - i4;
                }
            }
            int i5 = i2 - min;
            if (i5 <= 0) {
                return min;
            }
            this.l = true;
            if (this.i) {
                i5 = this.a.read(bArr, i + min, i5);
                i3 = (512000 - this.h) - this.f;
                if (i3 < i5) {
                    System.arraycopy(bArr, i + min, this.b, this.h + this.f, i3);
                    this.f += i3;
                    a();
                    this.b = CacheService.getFromDiskCache(this.g + this.c);
                    if (this.b == null) {
                        this.b = new byte[512000];
                    }
                    System.arraycopy(bArr, (i + i3) + min, this.b, this.h + this.f, i5 - i3);
                    this.f = (i5 - i3) + this.f;
                } else {
                    System.arraycopy(bArr, i + min, this.b, this.h + this.f, i5);
                    this.f += i5;
                }
                return min + i5;
            }
            MoPubLog.d("end of cache reached. No http source open");
            return -1;
        }
    }
}
