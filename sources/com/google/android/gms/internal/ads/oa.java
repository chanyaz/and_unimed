package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.a.b;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.br;
import com.google.android.gms.ads.internal.gmsg.zzv;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import org.json.JSONObject;

@zzadh
public final class oa extends FrameLayout implements zzaqw {
    private final zzaqw a;
    private final ml b;

    public oa(zzaqw zzaqw) {
        super(zzaqw.getContext());
        this.a = zzaqw;
        this.b = new ml(zzaqw.zzua(), this, this);
        addView(this.a.getView());
    }

    public final void destroy() {
        this.a.zzh();
    }

    public final OnClickListener getOnClickListener() {
        return this.a.getOnClickListener();
    }

    public final int getRequestedOrientation() {
        return this.a.getRequestedOrientation();
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this.a.getWebView();
    }

    public final boolean isDestroyed() {
        return this.a.isDestroyed();
    }

    public final void loadData(String str, String str2, String str3) {
        this.a.loadData(str, str2, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final void loadUrl(String str) {
        this.a.loadUrl(str);
    }

    public final void onPause() {
        this.b.b();
        this.a.onPause();
    }

    public final void onResume() {
        this.a.onResume();
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(OnTouchListener onTouchListener) {
        this.a.setOnTouchListener(onTouchListener);
    }

    public final void setRequestedOrientation(int i) {
        this.a.setRequestedOrientation(i);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.a.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.a.setWebViewClient(webViewClient);
    }

    public final void stopLoading() {
        this.a.stopLoading();
    }

    public final void zza(c cVar) {
        this.a.zza(cVar);
    }

    public final void zza(zzc zzc) {
        this.a.zza(zzc);
    }

    public final void zza(agf agf) {
        this.a.zza(agf);
    }

    public final void zza(oe oeVar) {
        this.a.zza(oeVar);
    }

    public final void zza(op opVar) {
        this.a.zza(opVar);
    }

    public final void zza(String str, zzv<? super zzaqw> zzv) {
        this.a.zza(str, (zzv) zzv);
    }

    public final void zza(String str, Predicate<zzv<? super zzaqw>> predicate) {
        this.a.zza(str, (Predicate) predicate);
    }

    public final void zza(String str, Map<String, ?> map) {
        this.a.zza(str, (Map) map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        this.a.zza(str, jSONObject);
    }

    public final void zza(boolean z, int i) {
        this.a.zza(z, i);
    }

    public final void zza(boolean z, int i, String str) {
        this.a.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.a.zza(z, i, str, str2);
    }

    public final void zzah(boolean z) {
        this.a.zzah(z);
    }

    public final void zzai(int i) {
        this.a.zzai(i);
    }

    public final void zzai(boolean z) {
        this.a.zzai(z);
    }

    public final void zzaj(boolean z) {
        this.a.zzaj(z);
    }

    public final void zzak(boolean z) {
        this.a.zzak(z);
    }

    public final void zzb(c cVar) {
        this.a.zzb(cVar);
    }

    public final void zzb(@Nullable zzox zzox) {
        this.a.zzb(zzox);
    }

    public final void zzb(String str, zzv<? super zzaqw> zzv) {
        this.a.zzb(str, zzv);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        this.a.zzb(str, jSONObject);
    }

    public final void zzbe(String str) {
        this.a.zzbe(str);
    }

    public final br zzbi() {
        return this.a.zzbi();
    }

    public final void zzbm(Context context) {
        this.a.zzbm(context);
    }

    public final void zzc(String str, String str2, @Nullable String str3) {
        this.a.zzc(str, str2, str3);
    }

    public final void zzcl() {
        this.a.zzcl();
    }

    public final void zzcm() {
        this.a.zzcm();
    }

    public final void zzdr(String str) {
        this.a.zzdr(str);
    }

    public final void zzno() {
        this.a.zzno();
    }

    public final void zznp() {
        this.a.zznp();
    }

    public final String zzol() {
        return this.a.zzol();
    }

    public final ml zztl() {
        return this.b;
    }

    public final oe zztm() {
        return this.a.zztm();
    }

    public final amy zztn() {
        return this.a.zztn();
    }

    public final Activity zzto() {
        return this.a.zzto();
    }

    public final amz zztp() {
        return this.a.zztp();
    }

    public final zzang zztq() {
        return this.a.zztq();
    }

    public final int zztr() {
        return getMeasuredHeight();
    }

    public final int zzts() {
        return getMeasuredWidth();
    }

    public final void zzty() {
        this.a.zzty();
    }

    public final void zztz() {
        this.a.zztz();
    }

    public final void zzu(boolean z) {
        this.a.zzu(z);
    }

    public final Context zzua() {
        return this.a.zzua();
    }

    public final c zzub() {
        return this.a.zzub();
    }

    public final c zzuc() {
        return this.a.zzuc();
    }

    public final op zzud() {
        return this.a.zzud();
    }

    public final String zzue() {
        return this.a.zzue();
    }

    public final zzasc zzuf() {
        return this.a.zzuf();
    }

    public final WebViewClient zzug() {
        return this.a.zzug();
    }

    public final boolean zzuh() {
        return this.a.zzuh();
    }

    public final ada zzui() {
        return this.a.zzui();
    }

    public final boolean zzuj() {
        return this.a.zzuj();
    }

    public final void zzuk() {
        this.b.c();
        this.a.zzuk();
    }

    public final boolean zzul() {
        return this.a.zzul();
    }

    public final boolean zzum() {
        return this.a.zzum();
    }

    public final boolean zzun() {
        return this.a.zzun();
    }

    public final void zzuo() {
        this.a.zzuo();
    }

    public final void zzup() {
        this.a.zzup();
    }

    @Nullable
    public final zzox zzuq() {
        return this.a.zzuq();
    }

    public final void zzur() {
        setBackgroundColor(0);
        this.a.setBackgroundColor(0);
    }

    public final void zzus() {
        View textView = new TextView(getContext());
        Resources h = au.i().h();
        textView.setText(h != null ? h.getString(b.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        if (VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        addView(textView, new LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }
}
