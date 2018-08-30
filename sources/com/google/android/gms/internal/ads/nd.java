package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public abstract class nd implements Releasable {
    protected Context a;
    private String b;
    private WeakReference<zzapw> c;

    public nd(zzapw zzapw) {
        this.a = zzapw.getContext();
        this.b = au.e().b(this.a, zzapw.zztq().a);
        this.c = new WeakReference(zzapw);
    }

    private final void a(String str, Map<String, String> map) {
        zzapw zzapw = (zzapw) this.c.get();
        if (zzapw != null) {
            zzapw.zza(str, (Map) map);
        }
    }

    private static String b(String str) {
        String str2 = "internal";
        Object obj = -1;
        switch (str.hashCode()) {
            case -1947652542:
                if (str.equals("interrupted")) {
                    obj = 3;
                    break;
                }
                break;
            case -1396664534:
                if (str.equals("badUrl")) {
                    obj = 8;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    obj = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    obj = 9;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    obj = null;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    obj = 5;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    obj = 11;
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    obj = 10;
                    break;
                }
                break;
            case 3387234:
                if (str.equals("noop")) {
                    obj = 4;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    obj = 1;
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    obj = 6;
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    obj = 7;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return "internal";
            case 6:
            case 7:
                return "io";
            case 8:
            case 9:
                return "network";
            case 10:
            case 11:
                return "policy";
            default:
                return str2;
        }
    }

    public abstract void a();

    protected final void a(String str, String str2, int i) {
        kb.a.post(new nf(this, str, str2, i));
    }

    @VisibleForTesting
    public final void a(String str, String str2, String str3, @Nullable String str4) {
        kb.a.post(new ng(this, str, str2, str3, str4));
    }

    public abstract boolean a(String str);

    public void release() {
    }
}
