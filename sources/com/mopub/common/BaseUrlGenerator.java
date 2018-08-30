package com.mopub.common;

import android.graphics.Point;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.mopub.network.Networking;
import com.mopub.network.PlayServicesUrlRewriter;

public abstract class BaseUrlGenerator {
    private StringBuilder a;
    private boolean b;

    private String c() {
        if (!this.b) {
            return "&";
        }
        this.b = false;
        return "?";
    }

    protected String a() {
        return this.a.toString();
    }

    protected void a(@NonNull Point point) {
        b("w", "" + point.x);
        b("h", "" + point.y);
    }

    protected void a(String str, String str2) {
        this.a = new StringBuilder(Networking.getScheme()).append("://").append(str).append(str2);
        this.b = true;
    }

    protected void a(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (strArr != null && strArr.length >= 1) {
            for (int i = 0; i < strArr.length - 1; i++) {
                stringBuilder.append(strArr[i]).append(",");
            }
            stringBuilder.append(strArr[strArr.length - 1]);
            b("dn", stringBuilder.toString());
        }
    }

    protected void b() {
        b("udid", PlayServicesUrlRewriter.UDID_TEMPLATE);
        b("dnt", PlayServicesUrlRewriter.DO_NOT_TRACK_TEMPLATE);
    }

    protected void b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.a.append(c());
            this.a.append(str);
            this.a.append("=");
            this.a.append(Uri.encode(str2));
        }
    }

    protected void b(boolean z) {
        b("android_perms_ext_storage", z ? "1" : "0");
    }

    public abstract String generateUrlString(String str);

    protected void k(String str) {
        b("v", str);
    }

    protected void l(String str) {
        b("av", str);
    }
}
