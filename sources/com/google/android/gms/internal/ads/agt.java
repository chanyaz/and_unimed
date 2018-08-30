package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.p;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
@TargetApi(14)
@ParametersAreNonnullByDefault
public final class agt extends Thread {
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;
    private final Object d;
    private final agp e;
    private final zzadf f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final String o;
    private final boolean p;

    public agt(agp agp, zzadf zzadf) {
        this.e = agp;
        this.f = zzadf;
        this.d = new Object();
        this.h = ((Integer) akc.f().a(amn.R)).intValue();
        this.i = ((Integer) akc.f().a(amn.S)).intValue();
        this.j = ((Integer) akc.f().a(amn.T)).intValue();
        this.k = ((Integer) akc.f().a(amn.U)).intValue();
        this.l = ((Integer) akc.f().a(amn.X)).intValue();
        this.m = ((Integer) akc.f().a(amn.Z)).intValue();
        this.n = ((Integer) akc.f().a(amn.aa)).intValue();
        this.g = ((Integer) akc.f().a(amn.V)).intValue();
        this.o = (String) akc.f().a(amn.ac);
        this.p = ((Boolean) akc.f().a(amn.ae)).booleanValue();
        setName("ContentFetchTask");
    }

    @VisibleForTesting
    private final agx a(@Nullable View view, ago ago) {
        int i = 0;
        if (view == null) {
            return new agx(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        int i2;
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new agx(this, 0, 0);
            }
            ago.b(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new agx(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzaqw)) {
            ago.g();
            WebView webView = (WebView) view;
            if (p.g()) {
                ago.g();
                webView.post(new agv(this, ago, webView, globalVisibleRect));
                i2 = 1;
            } else {
                i2 = 0;
            }
            return i2 != 0 ? new agx(this, 0, 1) : new agx(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new agx(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i3 = 0;
            for (i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                agx a = a(viewGroup.getChildAt(i2), ago);
                i3 += a.a;
                i += a.b;
            }
            return new agx(this, i3, i);
        }
    }

    @VisibleForTesting
    private static boolean e() {
        try {
            Context b = au.h().b();
            if (b == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) b.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) b.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode()) {
                        PowerManager powerManager = (PowerManager) b.getSystemService("power");
                        if (powerManager == null ? false : powerManager.isScreenOn()) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            au.i().a(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void f() {
        synchronized (this.d) {
            this.b = true;
            kk.b("ContentFetchThread: paused, mPause = " + this.b);
        }
    }

    public final void a() {
        synchronized (this.d) {
            if (this.a) {
                kk.b("Content hash thread already started, quiting...");
                return;
            }
            this.a = true;
            start();
        }
    }

    @VisibleForTesting
    final void a(View view) {
        try {
            ago ago = new ago(this.h, this.i, this.j, this.k, this.l, this.m, this.n);
            Context b = au.h().b();
            if (!(b == null || TextUtils.isEmpty(this.o))) {
                String str = (String) view.getTag(b.getResources().getIdentifier((String) akc.f().a(amn.ab), "id", b.getPackageName()));
                if (str != null && str.equals(this.o)) {
                    return;
                }
            }
            agx a = a(view, ago);
            ago.h();
            if (a.a != 0 || a.b != 0) {
                if (a.b != 0 || ago.j() != 0) {
                    if (a.b != 0 || !this.e.a(ago)) {
                        this.e.c(ago);
                    }
                }
            }
        } catch (Throwable e) {
            kk.b("Exception in fetchContentOnUIThread", e);
            this.f.zza(e, "ContentFetchTask.fetchContent");
        }
    }

    @VisibleForTesting
    final void a(ago ago, WebView webView, String str, boolean z) {
        ago.f();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.p || TextUtils.isEmpty(webView.getTitle())) {
                    ago.a(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    ago.a(new StringBuilder((String.valueOf(title).length() + 1) + String.valueOf(optString).length()).append(title).append("\n").append(optString).toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (ago.a()) {
                this.e.b(ago);
            }
        } catch (JSONException e) {
            kk.b("Json string may be malformed.");
        } catch (Throwable th) {
            kk.a("Failed to get webview content.", th);
            this.f.zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final ago b() {
        return this.e.a();
    }

    public final void c() {
        synchronized (this.d) {
            this.b = false;
            this.d.notifyAll();
            kk.b("ContentFetchThread: wakeup");
        }
    }

    public final boolean d() {
        return this.b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063 A:{ExcHandler: java.lang.InterruptedException (r0_15 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063 A:{ExcHandler: java.lang.InterruptedException (r0_15 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:29:0x0063, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:30:0x0064, code:
            com.google.android.gms.internal.ads.kk.b("Error in ContentFetchTask", r0);
     */
    /* JADX WARNING: Missing block: B:34:0x007a, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:35:0x007b, code:
            com.google.android.gms.internal.ads.kk.b("Error in ContentFetchTask", r0);
            r4.f.zza(r0, "ContentFetchTask.run");
     */
    public final void run() {
        /*
        r4 = this;
    L_0x0000:
        r0 = e();	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        if (r0 == 0) goto L_0x0088;
    L_0x0006:
        r0 = com.google.android.gms.ads.internal.au.h();	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        r1 = r0.a();	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        if (r1 != 0) goto L_0x0034;
    L_0x0010:
        r0 = "ContentFetchThread: no activity. Sleeping.";
        com.google.android.gms.internal.ads.kk.b(r0);	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        r4.f();	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
    L_0x0018:
        r0 = r4.g;	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        r0 = r0 * 1000;
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
    L_0x0020:
        r1 = r4.d;
        monitor-enter(r1);
    L_0x0023:
        r0 = r4.b;	 Catch:{ all -> 0x0094 }
        if (r0 == 0) goto L_0x0091;
    L_0x0027:
        r0 = "ContentFetchTask: waiting";
        com.google.android.gms.internal.ads.kk.b(r0);	 Catch:{ InterruptedException -> 0x0032 }
        r0 = r4.d;	 Catch:{ InterruptedException -> 0x0032 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0032 }
        goto L_0x0023;
    L_0x0032:
        r0 = move-exception;
        goto L_0x0023;
    L_0x0034:
        if (r1 == 0) goto L_0x0018;
    L_0x0036:
        r0 = 0;
        r2 = r1.getWindow();	 Catch:{ Exception -> 0x006a, InterruptedException -> 0x0063 }
        if (r2 == 0) goto L_0x0056;
    L_0x003d:
        r2 = r1.getWindow();	 Catch:{ Exception -> 0x006a, InterruptedException -> 0x0063 }
        r2 = r2.getDecorView();	 Catch:{ Exception -> 0x006a, InterruptedException -> 0x0063 }
        if (r2 == 0) goto L_0x0056;
    L_0x0047:
        r1 = r1.getWindow();	 Catch:{ Exception -> 0x006a, InterruptedException -> 0x0063 }
        r1 = r1.getDecorView();	 Catch:{ Exception -> 0x006a, InterruptedException -> 0x0063 }
        r2 = 16908290; // 0x1020002 float:2.3877235E-38 double:8.353805E-317;
        r0 = r1.findViewById(r2);	 Catch:{ Exception -> 0x006a, InterruptedException -> 0x0063 }
    L_0x0056:
        if (r0 == 0) goto L_0x0018;
    L_0x0058:
        if (r0 == 0) goto L_0x0018;
    L_0x005a:
        r1 = new com.google.android.gms.internal.ads.agu;	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        r1.<init>(r4, r0);	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        r0.post(r1);	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        goto L_0x0018;
    L_0x0063:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.ads.kk.b(r1, r0);
        goto L_0x0020;
    L_0x006a:
        r1 = move-exception;
        r2 = com.google.android.gms.ads.internal.au.i();	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        r3 = "ContentFetchTask.extractContent";
        r2.a(r1, r3);	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        r1 = "Failed getting root view of activity. Content not extracted.";
        com.google.android.gms.internal.ads.kk.b(r1);	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        goto L_0x0056;
    L_0x007a:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.ads.kk.b(r1, r0);
        r1 = r4.f;
        r2 = "ContentFetchTask.run";
        r1.zza(r0, r2);
        goto L_0x0020;
    L_0x0088:
        r0 = "ContentFetchTask: sleeping";
        com.google.android.gms.internal.ads.kk.b(r0);	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        r4.f();	 Catch:{ InterruptedException -> 0x0063, Exception -> 0x007a }
        goto L_0x0018;
    L_0x0091:
        monitor-exit(r1);	 Catch:{ all -> 0x0094 }
        goto L_0x0000;
    L_0x0094:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0094 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agt.run():void");
    }
}
