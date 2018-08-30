package com.google.android.gms.internal.ads;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.au;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public class oz extends WebView implements zzasx, zzasz, zzata, zzatb {
    protected final WebViewClient a;
    private final List<zzasx> b = new CopyOnWriteArrayList();
    private final List<zzatb> c = new CopyOnWriteArrayList();
    private final List<zzasz> d = new CopyOnWriteArrayList();
    private final List<zzata> e = new CopyOnWriteArrayList();
    private final oo f;

    public oz(oo ooVar) {
        super(ooVar);
        this.f = ooVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        au.g().a(getContext(), settings);
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        try {
            getSettings().setJavaScriptEnabled(true);
        } catch (Throwable e) {
            kk.b("Unable to enable Javascript.", e);
        }
        setLayerType(1, null);
        this.a = new pa(this, this, this, this);
        super.setWebViewClient(this.a);
    }

    protected final oo a() {
        return this.f;
    }

    public final void a(zzasx zzasx) {
        this.b.add(zzasx);
    }

    public final void a(zzasz zzasz) {
        this.d.add(zzasz);
    }

    public final void a(zzata zzata) {
        this.e.add(zzata);
    }

    public final void a(zzatb zzatb) {
        this.c.add(zzatb);
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (VERSION.SDK_INT >= 17) {
            super.addJavascriptInterface(obj, str);
        } else {
            hl.a("Ignore addJavascriptInterface due to low Android version.");
        }
    }

    public void loadUrl(String str) {
        Throwable e;
        try {
            super.loadUrl(str);
            return;
        } catch (Exception e2) {
            e = e2;
        } catch (NoClassDefFoundError e3) {
            e = e3;
        } catch (IncompatibleClassChangeError e4) {
            e = e4;
        }
        au.i().a(e, "CoreWebView.loadUrl");
        kk.d("#007 Could not call remote method.", e);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
    }

    public final boolean zza(pb pbVar) {
        for (zzasx zza : this.b) {
            if (zza.zza(pbVar)) {
                return true;
            }
        }
        return false;
    }

    public final void zzb(pb pbVar) {
        for (zzasz zzb : this.d) {
            zzb.zzb(pbVar);
        }
    }

    public void zzbe(String str) {
        pe.a(this, str);
    }

    public void zzc(pb pbVar) {
        for (zzata zzc : this.e) {
            zzc.zzc(pbVar);
        }
    }

    public final WebResourceResponse zzd(pb pbVar) {
        for (zzatb zzd : this.c) {
            WebResourceResponse zzd2 = zzd.zzd(pbVar);
            if (zzd2 != null) {
                return zzd2;
            }
        }
        return null;
    }
}
