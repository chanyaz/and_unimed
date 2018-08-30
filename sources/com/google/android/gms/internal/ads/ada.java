package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

public final class ada {
    private static final String[] e = new String[]{"/aclk", "/pcs/click"};
    private String a = "googleads.g.doubleclick.net";
    private String b = "/pagead/ads";
    private String c = "ad.doubleclick.net";
    private String[] d = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzce f;

    public ada(zzce zzce) {
        this.f = zzce;
    }

    private final Uri a(Uri uri, Context context, String str, boolean z, View view, Activity activity) {
        try {
            boolean c = c(uri);
            if (c) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzcj("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzcj("Query parameter already exists: ms");
            }
            String zza = z ? this.f.zza(context, str, view, activity) : this.f.zza(context);
            String uri2;
            String encodedPath;
            if (c) {
                String str2 = "dc_ms";
                uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                if (indexOf != -1) {
                    return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str2).append("=").append(zza).append(";").append(uri2.substring(indexOf + 1)).toString());
                }
                encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str2).append("=").append(zza).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
            }
            uri2 = "ms";
            encodedPath = uri.toString();
            int indexOf3 = encodedPath.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = encodedPath.indexOf("?adurl");
            }
            return indexOf3 != -1 ? Uri.parse(new StringBuilder(encodedPath.substring(0, indexOf3 + 1)).append(uri2).append("=").append(zza).append("&").append(encodedPath.substring(indexOf3 + 1)).toString()) : uri.buildUpon().appendQueryParameter(uri2, zza).build();
        } catch (UnsupportedOperationException e) {
            throw new zzcj("Provided Uri is not in a valid state");
        }
    }

    private final boolean c(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.c);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public final Uri a(Uri uri, Context context) {
        return a(uri, context, null, false, null, null);
    }

    public final Uri a(Uri uri, Context context, View view, Activity activity) {
        try {
            return a(uri, context, uri.getQueryParameter("ai"), true, view, activity);
        } catch (UnsupportedOperationException e) {
            throw new zzcj("Provided Uri is not in a valid state");
        }
    }

    public final zzce a() {
        return this.f;
    }

    public final void a(MotionEvent motionEvent) {
        this.f.zza(motionEvent);
    }

    public final boolean a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.d) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public final boolean b(Uri uri) {
        if (!a(uri)) {
            return false;
        }
        for (String endsWith : e) {
            if (uri.getPath().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }
}
