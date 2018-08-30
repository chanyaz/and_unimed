package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.util.Log;
import com.appnext.base.b.c;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

@RestrictTo({Scope.LIBRARY_GROUP})
public class h {
    private h() {
    }

    @Nullable
    public static File a(Context context) {
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                return null;
            }
            File file = new File(context.getCacheDir(), str + i2);
            try {
                if (file.createNewFile()) {
                    return file;
                }
                i = i2 + 1;
            } catch (IOException e) {
            }
        }
    }

    @Nullable
    @RequiresApi(19)
    public static ByteBuffer a(Context context, Resources resources, int i) {
        ByteBuffer byteBuffer = null;
        File a = a(context);
        if (a != null) {
            try {
                if (a(a, resources, i)) {
                    byteBuffer = a(a);
                    a.delete();
                }
            } finally {
                a.delete();
            }
        }
        return byteBuffer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0068 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:16:0x0023} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0068 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:16:0x0023} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0068 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:16:0x0023} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:38:0x0058, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:39:0x0059, code:
            r11 = r1;
            r1 = r0;
            r0 = r11;
     */
    /* JADX WARNING: Missing block: B:48:0x0068, code:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:49:0x0069, code:
            r1 = null;
     */
    /* JADX WARNING: Missing block: B:63:0x007d, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:64:0x007e, code:
            r1.addSuppressed(r2);
     */
    @android.support.annotation.Nullable
    @android.support.annotation.RequiresApi(19)
    public static java.nio.ByteBuffer a(android.content.Context r12, android.os.CancellationSignal r13, android.net.Uri r14) {
        /*
        r6 = 0;
        r0 = r12.getContentResolver();
        r1 = "r";
        r7 = r0.openFileDescriptor(r14, r1, r13);	 Catch:{ IOException -> 0x001c }
        r8 = 0;
        if (r7 != 0) goto L_0x0023;
    L_0x000e:
        if (r7 == 0) goto L_0x0015;
    L_0x0010:
        if (r6 == 0) goto L_0x001f;
    L_0x0012:
        r7.close();	 Catch:{ Throwable -> 0x0017 }
    L_0x0015:
        r0 = r6;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = move-exception;
        r8.addSuppressed(r0);	 Catch:{ IOException -> 0x001c }
        goto L_0x0015;
    L_0x001c:
        r0 = move-exception;
        r0 = r6;
        goto L_0x0016;
    L_0x001f:
        r7.close();	 Catch:{ IOException -> 0x001c }
        goto L_0x0015;
    L_0x0023:
        r9 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0056, all -> 0x0068 }
        r0 = r7.getFileDescriptor();	 Catch:{ Throwable -> 0x0056, all -> 0x0068 }
        r9.<init>(r0);	 Catch:{ Throwable -> 0x0056, all -> 0x0068 }
        r10 = 0;
        r0 = r9.getChannel();	 Catch:{ Throwable -> 0x006f, all -> 0x008f }
        r4 = r0.size();	 Catch:{ Throwable -> 0x006f, all -> 0x008f }
        r1 = java.nio.channels.FileChannel.MapMode.READ_ONLY;	 Catch:{ Throwable -> 0x006f, all -> 0x008f }
        r2 = 0;
        r0 = r0.map(r1, r2, r4);	 Catch:{ Throwable -> 0x006f, all -> 0x008f }
        if (r9 == 0) goto L_0x0044;
    L_0x003f:
        if (r6 == 0) goto L_0x0064;
    L_0x0041:
        r9.close();	 Catch:{ Throwable -> 0x0051, all -> 0x0068 }
    L_0x0044:
        if (r7 == 0) goto L_0x0016;
    L_0x0046:
        if (r6 == 0) goto L_0x006b;
    L_0x0048:
        r7.close();	 Catch:{ Throwable -> 0x004c }
        goto L_0x0016;
    L_0x004c:
        r1 = move-exception;
        r8.addSuppressed(r1);	 Catch:{ IOException -> 0x001c }
        goto L_0x0016;
    L_0x0051:
        r1 = move-exception;
        r10.addSuppressed(r1);	 Catch:{ Throwable -> 0x0056, all -> 0x0068 }
        goto L_0x0044;
    L_0x0056:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0058 }
    L_0x0058:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
    L_0x005c:
        if (r7 == 0) goto L_0x0063;
    L_0x005e:
        if (r1 == 0) goto L_0x008b;
    L_0x0060:
        r7.close();	 Catch:{ Throwable -> 0x0086 }
    L_0x0063:
        throw r0;	 Catch:{ IOException -> 0x001c }
    L_0x0064:
        r9.close();	 Catch:{ Throwable -> 0x0056, all -> 0x0068 }
        goto L_0x0044;
    L_0x0068:
        r0 = move-exception;
        r1 = r6;
        goto L_0x005c;
    L_0x006b:
        r7.close();	 Catch:{ IOException -> 0x001c }
        goto L_0x0016;
    L_0x006f:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0071 }
    L_0x0071:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
    L_0x0075:
        if (r9 == 0) goto L_0x007c;
    L_0x0077:
        if (r1 == 0) goto L_0x0082;
    L_0x0079:
        r9.close();	 Catch:{ Throwable -> 0x007d, all -> 0x0068 }
    L_0x007c:
        throw r0;	 Catch:{ Throwable -> 0x0056, all -> 0x0068 }
    L_0x007d:
        r2 = move-exception;
        r1.addSuppressed(r2);	 Catch:{ Throwable -> 0x0056, all -> 0x0068 }
        goto L_0x007c;
    L_0x0082:
        r9.close();	 Catch:{ Throwable -> 0x0056, all -> 0x0068 }
        goto L_0x007c;
    L_0x0086:
        r2 = move-exception;
        r1.addSuppressed(r2);	 Catch:{ IOException -> 0x001c }
        goto L_0x0063;
    L_0x008b:
        r7.close();	 Catch:{ IOException -> 0x001c }
        goto L_0x0063;
    L_0x008f:
        r0 = move-exception;
        r1 = r6;
        goto L_0x0075;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.h.a(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    @Nullable
    @RequiresApi(19)
    private static ByteBuffer a(File file) {
        Throwable th;
        Throwable th2;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Throwable th3 = null;
            try {
                FileChannel channel = fileInputStream.getChannel();
                ByteBuffer map = channel.map(MapMode.READ_ONLY, 0, channel.size());
                if (fileInputStream == null) {
                    return map;
                }
                if (null != null) {
                    try {
                        fileInputStream.close();
                        return map;
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                        return map;
                    }
                }
                fileInputStream.close();
                return map;
            } catch (Throwable th42) {
                Throwable th5 = th42;
                th42 = th2;
                th2 = th5;
            }
            if (fileInputStream != null) {
                if (th42 != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th6) {
                        th42.addSuppressed(th6);
                    }
                } else {
                    fileInputStream.close();
                }
            }
            throw th2;
            throw th2;
        } catch (IOException e) {
            return null;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static boolean a(File file, Resources resources, int i) {
        Closeable closeable = null;
        try {
            closeable = resources.openRawResource(i);
            boolean a = a(file, closeable);
            return a;
        } finally {
            a(closeable);
        }
    }

    public static boolean a(File file, InputStream inputStream) {
        IOException e;
        Throwable th;
        Closeable fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, false);
            try {
                byte[] bArr = new byte[c.jk];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        a(fileOutputStream);
                        return true;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                    a(fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    a(fileOutputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            a(fileOutputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            a(fileOutputStream);
            throw th;
        }
    }
}
