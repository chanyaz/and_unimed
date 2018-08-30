package com.google.android.exoplayer.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.exoplayer.upstream.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;

public final class m {
    public static final int a = VERSION.SDK_INT;
    public static final String b = Build.DEVICE;
    public static final String c = Build.MANUFACTURER;
    private static final Pattern d = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");
    private static final Pattern e = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");

    private m() {
    }

    public static int a(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static <T> int a(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 2);
        } else if (!z) {
            binarySearch--;
        }
        return z2 ? Math.max(0, binarySearch) : binarySearch;
    }

    public static int a(long[] jArr, long j, boolean z, boolean z2) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 2);
        } else if (!z) {
            binarySearch--;
        }
        return z2 ? Math.max(0, binarySearch) : binarySearch;
    }

    public static long a(long j, long j2, long j3) {
        return (j3 < j2 || j3 % j2 != 0) ? (j3 >= j2 || j2 % j3 != 0) ? (long) ((((double) j2) / ((double) j3)) * ((double) j)) : (j2 / j3) * j : j / (j3 / j2);
    }

    public static c a(c cVar, int i) {
        long j = -1;
        if (i == 0) {
            return cVar;
        }
        if (cVar.e != -1) {
            j = cVar.e - ((long) i);
        }
        return new c(cVar.a, cVar.d + ((long) i), j, cVar.f, cVar.g);
    }

    public static <T> String a(T[] tArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tArr.length; i++) {
            stringBuilder.append(tArr[i].getClass().getSimpleName());
            if (i < tArr.length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    public static ExecutorService a(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, str);
            }
        });
    }

    public static void a(OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e) {
        }
    }

    public static void a(HttpURLConnection httpURLConnection, long j) {
        if (a == 19 || a == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (IOException e) {
            } catch (Exception e2) {
            }
        }
    }

    public static void a(long[] jArr, long j, long j2) {
        int i = 0;
        long j3;
        if (j2 >= j && j2 % j == 0) {
            j3 = j2 / j;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j3;
                i++;
            }
        } else if (j2 >= j || j % j2 != 0) {
            double d = ((double) j) / ((double) j2);
            while (i < jArr.length) {
                jArr[i] = (long) (((double) jArr[i]) * d);
                i++;
            }
        } else {
            j3 = j / j2;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j3;
                i++;
            }
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static long[] a(List<Long> list, long j, long j2) {
        int i = 0;
        long[] jArr = new long[list.size()];
        long j3;
        int i2;
        if (j2 < j || j2 % j != 0) {
            if (j2 < j && j % j2 == 0) {
                j3 = j / j2;
                while (true) {
                    i2 = i;
                    if (i2 >= jArr.length) {
                        break;
                    }
                    jArr[i2] = ((Long) list.get(i2)).longValue() * j3;
                    i = i2 + 1;
                }
            } else {
                double d = ((double) j) / ((double) j2);
                while (true) {
                    i2 = i;
                    if (i2 >= jArr.length) {
                        break;
                    }
                    jArr[i2] = (long) (((double) ((Long) list.get(i2)).longValue()) * d);
                    i = i2 + 1;
                }
            }
        } else {
            j3 = j2 / j;
            while (true) {
                i2 = i;
                if (i2 >= jArr.length) {
                    break;
                }
                jArr[i2] = ((Long) list.get(i2)).longValue() / j3;
                i = i2 + 1;
            }
        }
        return jArr;
    }

    public static int b(long[] jArr, long j, boolean z, boolean z2) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            binarySearch ^= -1;
        } else if (!z) {
            binarySearch++;
        }
        return z2 ? Math.min(jArr.length - 1, binarySearch) : binarySearch;
    }

    public static String b(String str) {
        return str == null ? null : str.toLowerCase(Locale.US);
    }

    public static int c(String str) {
        int i = 0;
        int length = str.length();
        b.a(length <= 4);
        int i2 = 0;
        while (i < length) {
            i2 = (i2 << 8) | str.charAt(i);
            i++;
        }
        return i2;
    }
}
