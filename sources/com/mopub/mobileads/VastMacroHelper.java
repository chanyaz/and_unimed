package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VastMacroHelper {
    @NonNull
    private final List<String> a;
    @NonNull
    private final Map<y, String> b = new HashMap();

    public VastMacroHelper(@NonNull List<String> list) {
        Preconditions.checkNotNull(list, "uris cannot be null");
        this.a = list;
        this.b.put(y.CACHEBUSTING, a());
    }

    @NonNull
    private String a() {
        return String.format(Locale.US, "%08d", new Object[]{Long.valueOf(Math.round(Math.random() * 1.0E8d))});
    }

    @NonNull
    private String a(int i) {
        return String.format("%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toHours((long) i)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes((long) i) % TimeUnit.HOURS.toMinutes(1)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds((long) i) % TimeUnit.MINUTES.toSeconds(1)), Integer.valueOf(i % 1000)});
    }

    @NonNull
    public List<String> getUris() {
        List<String> arrayList = new ArrayList();
        for (String str : this.a) {
            String str2;
            if (!TextUtils.isEmpty(str2)) {
                String str3 = str2;
                for (y yVar : y.values()) {
                    str2 = (String) this.b.get(yVar);
                    if (str2 == null) {
                        str2 = "";
                    }
                    str3 = str3.replaceAll("\\[" + yVar.name() + "\\]", str2);
                }
                arrayList.add(str3);
            }
        }
        return arrayList;
    }

    @NonNull
    public VastMacroHelper withAssetUri(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            Object str2;
            try {
                str2 = URLEncoder.encode(str2, "UTF-8");
            } catch (Throwable e) {
                MoPubLog.w("Failed to encode url", e);
            }
            this.b.put(y.ASSETURI, str2);
        }
        return this;
    }

    @NonNull
    public VastMacroHelper withContentPlayHead(@Nullable Integer num) {
        if (num != null) {
            CharSequence a = a(num.intValue());
            if (!TextUtils.isEmpty(a)) {
                this.b.put(y.CONTENTPLAYHEAD, a);
            }
        }
        return this;
    }

    @NonNull
    public VastMacroHelper withErrorCode(@Nullable VastErrorCode vastErrorCode) {
        if (vastErrorCode != null) {
            this.b.put(y.ERRORCODE, vastErrorCode.a());
        }
        return this;
    }
}
