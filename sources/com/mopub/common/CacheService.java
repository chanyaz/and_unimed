package com.mopub.common;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.DiskLruCache.Editor;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Utils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CacheService {
    private static DiskLruCache a;

    public interface DiskLruCacheGetListener {
        void onComplete(String str, byte[] bArr);
    }

    @Deprecated
    @VisibleForTesting
    public static void clearAndNullCaches() {
        if (a != null) {
            try {
                a.delete();
                a = null;
            } catch (IOException e) {
                a = null;
            }
        }
    }

    public static boolean containsKeyDiskCache(String str) {
        if (a == null) {
            return false;
        }
        try {
            return a.get(createValidDiskCacheKey(str)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static String createValidDiskCacheKey(String str) {
        return Utils.sha1(str);
    }

    @Nullable
    public static File getDiskCacheDirectory(@NonNull Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        return new File(cacheDir.getPath() + File.separator + "mopub-cache");
    }

    @Deprecated
    @VisibleForTesting
    public static DiskLruCache getDiskLruCache() {
        return a;
    }

    public static String getFilePathDiskCache(String str) {
        return a == null ? null : a.getDirectory() + File.separator + createValidDiskCacheKey(str) + "." + 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0049  */
    public static byte[] getFromDiskCache(java.lang.String r7) {
        /*
        r0 = 0;
        r1 = a;
        if (r1 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r1 = a;	 Catch:{ Exception -> 0x0058, all -> 0x004d }
        r2 = createValidDiskCacheKey(r7);	 Catch:{ Exception -> 0x0058, all -> 0x004d }
        r2 = r1.get(r2);	 Catch:{ Exception -> 0x0058, all -> 0x004d }
        if (r2 != 0) goto L_0x0018;
    L_0x0012:
        if (r2 == 0) goto L_0x0005;
    L_0x0014:
        r2.close();
        goto L_0x0005;
    L_0x0018:
        r1 = 0;
        r3 = r2.getInputStream(r1);	 Catch:{ Exception -> 0x005b }
        if (r3 == 0) goto L_0x0033;
    L_0x001f:
        r1 = 0;
        r4 = r2.getLength(r1);	 Catch:{ Exception -> 0x005b }
        r1 = (int) r4;	 Catch:{ Exception -> 0x005b }
        r1 = new byte[r1];	 Catch:{ Exception -> 0x005b }
        r0 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x003e }
        r0.<init>(r3);	 Catch:{ Exception -> 0x003e }
        com.mopub.common.util.Streams.readStream(r0, r1);	 Catch:{ all -> 0x0039 }
        com.mopub.common.util.Streams.closeStream(r0);	 Catch:{ Exception -> 0x003e }
        r0 = r1;
    L_0x0033:
        if (r2 == 0) goto L_0x0005;
    L_0x0035:
        r2.close();
        goto L_0x0005;
    L_0x0039:
        r3 = move-exception;
        com.mopub.common.util.Streams.closeStream(r0);	 Catch:{ Exception -> 0x003e }
        throw r3;	 Catch:{ Exception -> 0x003e }
    L_0x003e:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
    L_0x0042:
        r3 = "Unable to get from DiskLruCache";
        com.mopub.common.logging.MoPubLog.d(r3, r1);	 Catch:{ all -> 0x0056 }
        if (r2 == 0) goto L_0x0005;
    L_0x0049:
        r2.close();
        goto L_0x0005;
    L_0x004d:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x0050:
        if (r2 == 0) goto L_0x0055;
    L_0x0052:
        r2.close();
    L_0x0055:
        throw r0;
    L_0x0056:
        r0 = move-exception;
        goto L_0x0050;
    L_0x0058:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0042;
    L_0x005b:
        r1 = move-exception;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.CacheService.getFromDiskCache(java.lang.String):byte[]");
    }

    public static void getFromDiskCacheAsync(String str, DiskLruCacheGetListener diskLruCacheGetListener) {
        new b(str, diskLruCacheGetListener).execute(new Void[0]);
    }

    public static void initialize(Context context) {
        initializeDiskCache(context);
    }

    public static boolean initializeDiskCache(Context context) {
        if (context == null) {
            return false;
        }
        if (a == null) {
            File diskCacheDirectory = getDiskCacheDirectory(context);
            if (diskCacheDirectory == null) {
                return false;
            }
            try {
                a = DiskLruCache.open(diskCacheDirectory, 1, 1, DeviceUtils.diskCacheSizeBytes(diskCacheDirectory));
            } catch (Throwable e) {
                MoPubLog.d("Unable to create DiskLruCache", e);
                return false;
            }
        }
        return true;
    }

    public static boolean putToDiskCache(String str, InputStream inputStream) {
        if (a == null) {
            return false;
        }
        Editor editor = null;
        try {
            editor = a.edit(createValidDiskCacheKey(str));
            if (editor == null) {
                return false;
            }
            OutputStream bufferedOutputStream = new BufferedOutputStream(editor.newOutputStream(0));
            Streams.copyContent(inputStream, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            a.flush();
            editor.commit();
            return true;
        } catch (Throwable e) {
            MoPubLog.d("Unable to put to DiskLruCache", e);
            if (editor == null) {
                return false;
            }
            try {
                editor.abort();
                return false;
            } catch (IOException e2) {
                return false;
            }
        }
    }

    public static boolean putToDiskCache(String str, byte[] bArr) {
        return putToDiskCache(str, new ByteArrayInputStream(bArr));
    }

    public static void putToDiskCacheAsync(String str, byte[] bArr) {
        new c(str, bArr).execute(new Void[0]);
    }
}
