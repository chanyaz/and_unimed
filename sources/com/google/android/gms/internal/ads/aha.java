package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzadh
public final class aha {
    private final int a;
    private final int b;
    private final int c;
    private final agz d = new ahe();

    public aha(int i) {
        this.b = i;
        this.a = 6;
        this.c = 0;
    }

    @VisibleForTesting
    private final String a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        ahc ahc = new ahc();
        PriorityQueue priorityQueue = new PriorityQueue(this.b, new ahb(this));
        for (String a : split) {
            String[] a2 = ahd.a(a, false);
            if (a2.length != 0) {
                ahf.a(a2, this.b, this.a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                ahc.a(this.d.a(((ahg) it.next()).b));
            } catch (Throwable e) {
                kk.b("Error while writing hash to byteStream", e);
            }
        }
        return ahc.toString();
    }

    public final String a(ArrayList<String> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            stringBuilder.append(((String) obj).toLowerCase(Locale.US));
            stringBuilder.append(10);
        }
        return a(stringBuilder.toString());
    }
}
