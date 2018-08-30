package com.squareup.picasso;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.provider.Settings.System;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

final class ao {
    static final StringBuilder a = new StringBuilder();

    private ao() {
    }

    static int a(Resources resources, ac acVar) {
        if (acVar.e != 0 || acVar.d == null) {
            return acVar.e;
        }
        String authority = acVar.d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + acVar.d);
        }
        List pathSegments = acVar.d.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + acVar.d);
        } else if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt((String) pathSegments.get(0));
            } catch (NumberFormatException e) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + acVar.d);
            }
        } else if (pathSegments.size() == 2) {
            return resources.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
        } else {
            throw new FileNotFoundException("More than two path segments: " + acVar.d);
        }
    }

    static int a(Bitmap bitmap) {
        int a = VERSION.SDK_INT >= 12 ? aq.a(bitmap) : bitmap.getRowBytes() * bitmap.getHeight();
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static long a(File file) {
        long blockSize;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockSize = (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 50;
        } catch (IllegalArgumentException e) {
            blockSize = 5242880;
        }
        return Math.max(Math.min(blockSize, 52428800), 5242880);
    }

    static Resources a(Context context, ac acVar) {
        if (acVar.e != 0 || acVar.d == null) {
            return context.getResources();
        }
        String authority = acVar.d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + acVar.d);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (NameNotFoundException e) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + acVar.d);
        }
    }

    static Downloader a(Context context) {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            return ar.a(context);
        } catch (ClassNotFoundException e) {
            return new am(context);
        }
    }

    static <T> T a(Context context, String str) {
        return context.getSystemService(str);
    }

    static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static String a(ac acVar) {
        String a = a(acVar, a);
        a.setLength(0);
        return a;
    }

    static String a(ac acVar, StringBuilder stringBuilder) {
        if (acVar.f != null) {
            stringBuilder.ensureCapacity(acVar.f.length() + 50);
            stringBuilder.append(acVar.f);
        } else if (acVar.d != null) {
            String uri = acVar.d.toString();
            stringBuilder.ensureCapacity(uri.length() + 50);
            stringBuilder.append(uri);
        } else {
            stringBuilder.ensureCapacity(50);
            stringBuilder.append(acVar.e);
        }
        stringBuilder.append(10);
        if (acVar.m != 0.0f) {
            stringBuilder.append("rotation:").append(acVar.m);
            if (acVar.p) {
                stringBuilder.append('@').append(acVar.n).append('x').append(acVar.o);
            }
            stringBuilder.append(10);
        }
        if (acVar.d()) {
            stringBuilder.append("resize:").append(acVar.h).append('x').append(acVar.i);
            stringBuilder.append(10);
        }
        if (acVar.j) {
            stringBuilder.append("centerCrop").append(10);
        } else if (acVar.k) {
            stringBuilder.append("centerInside").append(10);
        }
        if (acVar.g != null) {
            int size = acVar.g.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(((Transformation) acVar.g.get(i)).key());
                stringBuilder.append(10);
            }
        }
        return stringBuilder.toString();
    }

    static String a(d dVar) {
        return a(dVar, "");
    }

    static String a(d dVar, String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        a i = dVar.i();
        if (i != null) {
            stringBuilder.append(i.b.a());
        }
        List k = dVar.k();
        if (k != null) {
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0 || i != null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((a) k.get(i2)).b.a());
            }
        }
        return stringBuilder.toString();
    }

    static void a() {
        if (c()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    static void a(Looper looper) {
        Handler anonymousClass1 = new Handler(looper) {
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000);
            }
        };
        anonymousClass1.sendMessageDelayed(anonymousClass1.obtainMessage(), 1000);
    }

    static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    static void a(String str, String str2, String str3) {
        a(str, str2, str3, "");
    }

    static void a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    static boolean a(String str) {
        boolean z = true;
        if (str == null) {
            return false;
        }
        String[] split = str.split(" ", 2);
        if ("CACHE".equals(split[0])) {
            return true;
        }
        if (split.length == 1) {
            return false;
        }
        try {
            if (!("CONDITIONAL_CACHE".equals(split[0]) && Integer.parseInt(split[1]) == 304)) {
                z = false;
            }
            return z;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static File b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static void b() {
        if (!c()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static boolean b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    static int c(Context context) {
        ActivityManager activityManager = (ActivityManager) a(context, "activity");
        int memoryClass = (((context.getApplicationInfo().flags & 1048576) != 0 ? 1 : null) == null || VERSION.SDK_INT < 11) ? activityManager.getMemoryClass() : ap.a(activityManager);
        return (memoryClass * 1048576) / 7;
    }

    static boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static boolean c(InputStream inputStream) {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) && "WEBP".equals(new String(bArr, 8, 4, "US-ASCII"));
    }

    static boolean d(Context context) {
        try {
            return System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
