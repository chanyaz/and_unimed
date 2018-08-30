package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class ahf {
    @VisibleForTesting
    private static long a(long j, int i) {
        return i == 0 ? 1 : i != 1 ? i % 2 == 0 ? a((j * j) % 1073807359, i / 2) % 1073807359 : ((a((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    @VisibleForTesting
    private static String a(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            kk.c("Unable to construct shingle");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuilder.append(strArr[i3]);
            stringBuilder.append(' ');
        }
        stringBuilder.append(strArr[(i + i2) - 1]);
        return stringBuilder.toString();
    }

    @VisibleForTesting
    private static void a(int i, long j, String str, int i2, PriorityQueue<ahg> priorityQueue) {
        ahg ahg = new ahg(j, str, i2);
        if ((priorityQueue.size() != i || (((ahg) priorityQueue.peek()).c <= ahg.c && ((ahg) priorityQueue.peek()).a <= ahg.a)) && !priorityQueue.contains(ahg)) {
            priorityQueue.add(ahg);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void a(String[] strArr, int i, int i2, PriorityQueue<ahg> priorityQueue) {
        if (strArr.length < i2) {
            a(i, b(strArr, 0, strArr.length), a(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long b = b(strArr, 0, i2);
        a(i, b, a(strArr, 0, i2), i2, priorityQueue);
        long a = a(16785407, i2 - 1);
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            b += 1073807359;
            b = (((((b - ((((((long) ahd.a(strArr[i3 - 1])) + 2147483647L) % 1073807359) * a) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((((long) ahd.a(strArr[(i3 + i2) - 1])) + 2147483647L) % 1073807359)) % 1073807359;
            a(i, b, a(strArr, i3, i2), strArr.length, priorityQueue);
        }
    }

    private static long b(String[] strArr, int i, int i2) {
        long a = (((long) ahd.a(strArr[0])) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            a = (((a * 16785407) % 1073807359) + ((((long) ahd.a(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return a;
    }
}
