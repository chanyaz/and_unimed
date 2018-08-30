package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@VisibleForTesting
public final class o implements zzo {
    private static final Uri a;
    private final LogPrinter b = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("local");
        a = builder.build();
    }

    public final void zzb(q qVar) {
        List arrayList = new ArrayList(qVar.b());
        Collections.sort(arrayList, new p(this));
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            obj = ((r) obj).toString();
            if (!TextUtils.isEmpty(obj)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(obj);
            }
        }
        this.b.println(stringBuilder.toString());
    }

    public final Uri zzk() {
        return a;
    }
}
