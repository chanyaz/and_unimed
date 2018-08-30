package com.mopub.mobileads;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;

@VisibleForTesting
class ah extends AsyncTask<String, Void, Boolean> {
    @NonNull
    private final VideoDownloaderListener a;
    @NonNull
    private final WeakReference<ah> b = new WeakReference(this);

    @VisibleForTesting
    ah(@NonNull VideoDownloaderListener videoDownloaderListener) {
        this.a = videoDownloaderListener;
        VideoDownloader.a.add(this.b);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5  */
    /* renamed from: a */
    protected java.lang.Boolean doInBackground(java.lang.String... r7) {
        /*
        r6 = this;
        r2 = 0;
        r5 = 26214400; // 0x1900000 float:5.2897246E-38 double:1.29516345E-316;
        r1 = 0;
        if (r7 == 0) goto L_0x000d;
    L_0x0006:
        r0 = r7.length;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r7[r1];
        if (r0 != 0) goto L_0x0017;
    L_0x000d:
        r0 = "VideoDownloader task tried to execute null or empty url.";
        com.mopub.common.logging.MoPubLog.d(r0);
        r0 = java.lang.Boolean.valueOf(r1);
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = r7[r1];
        r3 = com.mopub.common.MoPubHttpUrlConnection.getHttpUrlConnection(r0);	 Catch:{ Exception -> 0x0097, all -> 0x00ad }
        r1 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x00c1, all -> 0x00b9 }
        r4 = r3.getInputStream();	 Catch:{ Exception -> 0x00c1, all -> 0x00b9 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x00c1, all -> 0x00b9 }
        r2 = r3.getResponseCode();	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 < r4) goto L_0x0032;
    L_0x002e:
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r2 < r4) goto L_0x0056;
    L_0x0032:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r0.<init>();	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r4 = "VideoDownloader encountered unexpected statusCode: ";
        r0 = r0.append(r4);	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        com.mopub.common.logging.MoPubLog.d(r0);	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        com.mopub.common.util.Streams.closeStream(r1);
        if (r3 == 0) goto L_0x0016;
    L_0x0052:
        r3.disconnect();
        goto L_0x0016;
    L_0x0056:
        r2 = r3.getContentLength();	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        if (r2 <= r5) goto L_0x0086;
    L_0x005c:
        r0 = "VideoDownloader encountered video larger than disk cap. (%d bytes / %d maximum).";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r5 = 0;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r4[r5] = r2;	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r2 = 1;
        r5 = 26214400; // 0x1900000 float:5.2897246E-38 double:1.29516345E-316;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r4[r2] = r5;	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r0 = java.lang.String.format(r0, r4);	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        com.mopub.common.logging.MoPubLog.d(r0);	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        com.mopub.common.util.Streams.closeStream(r1);
        if (r3 == 0) goto L_0x0016;
    L_0x0082:
        r3.disconnect();
        goto L_0x0016;
    L_0x0086:
        r0 = com.mopub.common.CacheService.putToDiskCache(r0, r1);	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00c5, all -> 0x00bc }
        com.mopub.common.util.Streams.closeStream(r1);
        if (r3 == 0) goto L_0x0016;
    L_0x0093:
        r3.disconnect();
        goto L_0x0016;
    L_0x0097:
        r0 = move-exception;
        r1 = r2;
    L_0x0099:
        r3 = "VideoDownloader task threw an internal exception.";
        com.mopub.common.logging.MoPubLog.d(r3, r0);	 Catch:{ all -> 0x00be }
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x00be }
        com.mopub.common.util.Streams.closeStream(r1);
        if (r2 == 0) goto L_0x0016;
    L_0x00a8:
        r2.disconnect();
        goto L_0x0016;
    L_0x00ad:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
    L_0x00b0:
        com.mopub.common.util.Streams.closeStream(r1);
        if (r3 == 0) goto L_0x00b8;
    L_0x00b5:
        r3.disconnect();
    L_0x00b8:
        throw r0;
    L_0x00b9:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00b0;
    L_0x00bc:
        r0 = move-exception;
        goto L_0x00b0;
    L_0x00be:
        r0 = move-exception;
        r3 = r2;
        goto L_0x00b0;
    L_0x00c1:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x0099;
    L_0x00c5:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.ah.a(java.lang.String[]):java.lang.Boolean");
    }

    /* renamed from: a */
    protected void onPostExecute(Boolean bool) {
        if (isCancelled()) {
            onCancelled();
            return;
        }
        VideoDownloader.a.remove(this.b);
        if (bool == null) {
            this.a.onComplete(false);
        } else {
            this.a.onComplete(bool.booleanValue());
        }
    }

    protected void onCancelled() {
        MoPubLog.d("VideoDownloader task was cancelled.");
        VideoDownloader.a.remove(this.b);
        this.a.onComplete(false);
    }
}
