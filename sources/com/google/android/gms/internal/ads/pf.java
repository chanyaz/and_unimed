package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
final class pf {
    private static final String[] a = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] b = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};

    pf() {
    }

    private static void a(String str, String str2, String str3) {
        if (((Boolean) akc.f().a(amn.bs)).booleanValue()) {
            String host;
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            String str4 = "host";
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    host = parse.getHost();
                    bundle.putString(str4, host);
                }
            }
            host = "";
            bundle.putString(str4, host);
        }
    }

    final void a(int i, String str) {
        String valueOf = (i >= 0 || (-i) - 1 >= a.length) ? String.valueOf(i) : a[(-i) - 1];
        a("http_err", valueOf, str);
    }

    final void a(@Nullable SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= b.length) ? String.valueOf(primaryError) : b[primaryError];
            a("ssl_err", valueOf, sslError.getUrl());
        }
    }
}
