package com.google.android.gms.internal.ads;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.a.b;
import com.google.android.gms.ads.internal.au;
import java.util.Map;

@zzadh
public final class e extends l {
    private final Map<String, String> a;
    private final Context b;

    public e(zzaqw zzaqw, Map<String, String> map) {
        super(zzaqw, "storePicture");
        this.a = map;
        this.b = zzaqw.zzto();
    }

    public final void a() {
        if (this.b == null) {
            a("Activity context is not available");
            return;
        }
        au.e();
        if (ht.f(this.b).c()) {
            String str = (String) this.a.get("iurl");
            String str2;
            if (TextUtils.isEmpty(str)) {
                a("Image url cannot be empty.");
                return;
            } else if (URLUtil.isValidUrl(str)) {
                String lastPathSegment = Uri.parse(str).getLastPathSegment();
                au.e();
                if (ht.c(lastPathSegment)) {
                    Resources h = au.i().h();
                    au.e();
                    Builder e = ht.e(this.b);
                    e.setTitle(h != null ? h.getString(b.s1) : "Save image");
                    e.setMessage(h != null ? h.getString(b.s2) : "Allow Ad to store image in Picture gallery?");
                    e.setPositiveButton(h != null ? h.getString(b.s3) : "Accept", new f(this, str, lastPathSegment));
                    e.setNegativeButton(h != null ? h.getString(b.s4) : "Decline", new g(this));
                    e.create().show();
                    return;
                }
                str2 = "Image type not recognized: ";
                str = String.valueOf(lastPathSegment);
                a(str.length() != 0 ? str2.concat(str) : new String(str2));
                return;
            } else {
                str2 = "Invalid image url: ";
                str = String.valueOf(str);
                a(str.length() != 0 ? str2.concat(str) : new String(str2));
                return;
            }
        }
        a("Feature is not supported by the device.");
    }
}
