package com.appnext.core;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class e {
    private static final long ld = 8000;
    private static final long le = 15000;
    @SuppressLint({"StaticFieldLeak"})
    private static e lm;
    private Context context;
    private Handler handler = new Handler(Looper.getMainLooper());
    private WebView lf;
    private WebView lg;
    private a lh = new a() {
        public void error(String str) {
            if (e.this.lk.size() != 0) {
                if (((b) e.this.lk.get(0)).lh != null) {
                    ((b) e.this.lk.get(0)).lh.error(str);
                }
                e.this.cX();
            }
        }

        public void onMarket(String str) {
            if (e.this.lk.size() != 0) {
                if (((b) e.this.lk.get(0)).lh != null) {
                    ((b) e.this.lk.get(0)).lh.onMarket(str);
                }
                try {
                    String str2 = "https://admin.appnext.com/tools/navtac.html?bid=" + ((b) e.this.lk.get(0)).lt + "&guid=" + g.p("admin.appnext.com", "applink") + "&url=" + URLEncoder.encode(str, "UTF-8");
                    if (e.this.lg == null) {
                        e.this.lg = new WebView(e.this.context);
                        e.this.lg.getSettings().setJavaScriptEnabled(true);
                        e.this.lg.getSettings().setDomStorageEnabled(true);
                        if (VERSION.SDK_INT >= 21) {
                            e.this.lg.getSettings().setMixedContentMode(0);
                        }
                        e.this.lg.setWebViewClient(new WebViewClient() {
                            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                                if (str == null || str.contains("about:blank")) {
                                    return false;
                                }
                                webView.loadUrl(str);
                                return true;
                            }
                        });
                    }
                    e.this.lg.loadUrl("about:blank");
                    e.this.lg.loadUrl(str2);
                    if (e.this.handler != null) {
                        e.this.handler.removeCallbacksAndMessages(null);
                    }
                    e.this.cX();
                } catch (UnsupportedEncodingException e) {
                    e.this.cX();
                }
            }
        }
    };
    private Runnable li = new Runnable() {
        public void run() {
            if (e.this.lh == null || e.this.lf == null) {
                e.this.cX();
                return;
            }
            e.this.lh.error(e.this.lf.getUrl());
            e.this.lf.stopLoading();
        }
    };
    private Intent lj;
    private final ArrayList<b> lk = new ArrayList();
    private int ll = 0;

    public interface a {
        void error(String str);

        void onMarket(String str);
    }

    class b {
        String bW;
        a lh;
        String lt;
        long lu;

        b(String str, String str2, a aVar, long j) {
            this.bW = str;
            this.lh = aVar;
            this.lt = str2;
            this.lu = j;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private e(Context context) {
        this.context = context.getApplicationContext();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void a(b bVar) {
        try {
            this.handler.removeCallbacksAndMessages(null);
            if (this.lf == null) {
                this.lf = new WebView(this.context);
                this.lf.getSettings().setJavaScriptEnabled(true);
                this.lf.getSettings().setDomStorageEnabled(true);
                if (VERSION.SDK_INT >= 21) {
                    this.lf.getSettings().setMixedContentMode(0);
                }
                this.lf.setWebViewClient(new WebViewClient() {
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (str == null) {
                            return false;
                        }
                        g.X("redirect url: " + str);
                        if (str.startsWith("https://play.google.com/store/apps/")) {
                            str = str.replace("https://play.google.com/store/apps/", "market://");
                        }
                        if (str.contains("about:blank")) {
                            return false;
                        }
                        Intent parseUri;
                        if (str.startsWith("http://") || str.startsWith("https://")) {
                            if (e.this.hasNewResolver(e.this.aJ(str).setComponent(null))) {
                                e.this.handler.removeCallbacksAndMessages(null);
                                if (e.this.lh != null) {
                                    e.this.lh.onMarket(str);
                                }
                                e.this.handler.removeCallbacks(e.this.li);
                                return true;
                            }
                            webView.loadUrl(str);
                            return true;
                        } else if (str.startsWith("intent://")) {
                            try {
                                parseUri = Intent.parseUri(str, 1);
                                if (e.this.context.getPackageManager().resolveActivity(parseUri, 65536) != null) {
                                    e.this.handler.removeCallbacksAndMessages(null);
                                    if (e.this.lh != null) {
                                        e.this.lh.onMarket(parseUri.getData().toString());
                                    }
                                    e.this.handler.removeCallbacks(e.this.li);
                                    return true;
                                }
                                String string;
                                if (parseUri.getExtras() != null && parseUri.getExtras().containsKey("browser_fallback_url") && !parseUri.getExtras().getString("browser_fallback_url").equals("")) {
                                    string = parseUri.getExtras().getString("browser_fallback_url");
                                } else if (!parseUri.getExtras().containsKey("market_referrer") || parseUri.getExtras().getString("market_referrer").equals("")) {
                                    e.this.handler.removeCallbacksAndMessages(null);
                                    if (e.this.lh != null) {
                                        e.this.lh.error(str);
                                    }
                                    return true;
                                } else {
                                    string = "market://details?id=" + parseUri.getPackage() + "&referrer=" + parseUri.getExtras().getString("market_referrer");
                                }
                                e.this.handler.removeCallbacksAndMessages(null);
                                if (e.this.lh != null) {
                                    e.this.lh.onMarket(string);
                                }
                                return true;
                            } catch (Throwable th) {
                                g.c(th);
                                return false;
                            }
                        } else {
                            parseUri = new Intent("android.intent.action.VIEW");
                            parseUri.setData(Uri.parse(str));
                            try {
                                if (e.this.context.getPackageManager().queryIntentActivities(parseUri, 0).size() > 0) {
                                    e.this.handler.removeCallbacksAndMessages(null);
                                    if (e.this.lh != null) {
                                        e.this.lh.onMarket(str);
                                    }
                                    e.this.handler.removeCallbacks(e.this.li);
                                    return true;
                                }
                                webView.loadUrl(str);
                                return false;
                            } catch (Throwable th2) {
                                g.c(th2);
                                return false;
                            }
                        }
                    }
                });
            }
            this.lf.stopLoading();
            this.lf.loadUrl("about:blank");
            this.lj = new Intent(aJ(bVar.bW)).setComponent(null);
            if (VERSION.SDK_INT >= 15) {
                Intent selector = this.lj.getSelector();
                if (selector != null) {
                    selector.setComponent(null);
                }
            }
            this.lf.loadUrl(bVar.bW);
            g.X("appurl: " + bVar.bW);
            this.handler.postDelayed(this.li, bVar.bW.endsWith("&ox=0") ? le : bVar.lu);
        } catch (Throwable th) {
            if (this.lh != null) {
                this.lh.error(bVar.bW);
            }
            cX();
        }
    }

    private Intent aJ(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        return intent;
    }

    private List b(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        List arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            arrayList.add(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
        }
        return arrayList;
    }

    private void cX() {
        this.ll = 0;
        if (this.lk.size() != 0) {
            ((b) this.lk.get(0)).lh = null;
            this.lk.remove(0);
            a(null, null, null);
        }
    }

    public static e s(Context context) {
        if (lm == null) {
            lm = new e(context);
        }
        return lm;
    }

    public void a(String str, String str2, a aVar) {
        a(str, str2, aVar, ld);
    }

    /* JADX WARNING: Missing block: B:35:?, code:
            return;
     */
    public void a(java.lang.String r11, java.lang.String r12, com.appnext.core.e.a r13, long r14) {
        /*
        r10 = this;
        r8 = r10.lk;
        monitor-enter(r8);
        r0 = r10.context;	 Catch:{ all -> 0x0027 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r8);	 Catch:{ all -> 0x0027 }
    L_0x0008:
        return;
    L_0x0009:
        if (r11 == 0) goto L_0x0041;
    L_0x000b:
        r0 = r10.lk;	 Catch:{ all -> 0x0027 }
        r1 = r0.iterator();	 Catch:{ all -> 0x0027 }
    L_0x0011:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x002a;
    L_0x0017:
        r0 = r1.next();	 Catch:{ all -> 0x0027 }
        r0 = (com.appnext.core.e.b) r0;	 Catch:{ all -> 0x0027 }
        r0 = r0.bW;	 Catch:{ all -> 0x0027 }
        r0 = r0.equals(r11);	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x0011;
    L_0x0025:
        monitor-exit(r8);	 Catch:{ all -> 0x0027 }
        goto L_0x0008;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r0 = "&ox=0";
        r0 = r11.endsWith(r0);	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x005f;
    L_0x0032:
        r0 = r10.lk;	 Catch:{ all -> 0x0027 }
        r1 = new com.appnext.core.e$b;	 Catch:{ all -> 0x0027 }
        r2 = r10;
        r3 = r11;
        r4 = r12;
        r5 = r13;
        r6 = r14;
        r1.<init>(r3, r4, r5, r6);	 Catch:{ all -> 0x0027 }
        r0.add(r1);	 Catch:{ all -> 0x0027 }
    L_0x0041:
        r0 = r10.lk;	 Catch:{ all -> 0x0027 }
        r0 = r0.size();	 Catch:{ all -> 0x0027 }
        if (r0 <= 0) goto L_0x005d;
    L_0x0049:
        r0 = r10.ll;	 Catch:{ all -> 0x0027 }
        r1 = 1;
        if (r0 == r1) goto L_0x005d;
    L_0x004e:
        r0 = 1;
        r10.ll = r0;	 Catch:{ all -> 0x0027 }
        r0 = r10.lk;	 Catch:{ all -> 0x0027 }
        r1 = 0;
        r0 = r0.get(r1);	 Catch:{ all -> 0x0027 }
        r0 = (com.appnext.core.e.b) r0;	 Catch:{ all -> 0x0027 }
        r10.a(r0);	 Catch:{ all -> 0x0027 }
    L_0x005d:
        monitor-exit(r8);	 Catch:{ all -> 0x0027 }
        goto L_0x0008;
    L_0x005f:
        r0 = 0;
        r10.ll = r0;	 Catch:{ all -> 0x0027 }
        r0 = r10.lk;	 Catch:{ all -> 0x0027 }
        r0 = r0.size();	 Catch:{ all -> 0x0027 }
        if (r0 <= 0) goto L_0x0083;
    L_0x006a:
        r0 = r10.lk;	 Catch:{ all -> 0x0027 }
        r1 = 0;
        r0 = r0.get(r1);	 Catch:{ all -> 0x0027 }
        r0 = (com.appnext.core.e.b) r0;	 Catch:{ all -> 0x0027 }
        r0 = r0.bW;	 Catch:{ all -> 0x0027 }
        r1 = "&ox=0";
        r0 = r0.endsWith(r1);	 Catch:{ all -> 0x0027 }
        if (r0 != 0) goto L_0x0083;
    L_0x007d:
        r0 = r10.lk;	 Catch:{ all -> 0x0027 }
        r1 = 0;
        r0.remove(r1);	 Catch:{ all -> 0x0027 }
    L_0x0083:
        r0 = r10.lk;	 Catch:{ all -> 0x0027 }
        r9 = 0;
        r1 = new com.appnext.core.e$b;	 Catch:{ all -> 0x0027 }
        r2 = r10;
        r3 = r11;
        r4 = r12;
        r5 = r13;
        r6 = r14;
        r1.<init>(r3, r4, r5, r6);	 Catch:{ all -> 0x0027 }
        r0.add(r9, r1);	 Catch:{ all -> 0x0027 }
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.e.a(java.lang.String, java.lang.String, com.appnext.core.e$a, long):void");
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        final String str7 = str;
        final String str8 = str2;
        final String str9 = str3;
        final String str10 = str4;
        final String str11 = str5;
        final String str12 = str6;
        new Thread(new Runnable() {
            public void run() {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("guid", str7);
                    hashMap.put("bannerId", str8);
                    hashMap.put("placementId", str9);
                    hashMap.put("vid", str10);
                    hashMap.put("url", str11);
                    g.a("https://admin.appnext.com/AdminService.asmx/" + str12, hashMap);
                } catch (Throwable th) {
                }
            }
        }).start();
    }

    public void destroy() {
    }

    public void e(final AppnextAd appnextAd) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    g.a(appnextAd.getImpressionURL(), null);
                } catch (Throwable th) {
                }
            }
        }).start();
    }

    protected void finalize() {
        super.finalize();
        destroy();
    }

    public final boolean hasNewResolver(Intent intent) {
        if (this.lj == null) {
            return intent != null;
        } else if (intent == null) {
            return false;
        } else {
            List<ComponentName> b = b(this.context, intent);
            HashSet hashSet = new HashSet();
            hashSet.addAll(b(this.context, this.lj));
            for (ComponentName contains : b) {
                if (!hashSet.contains(contains)) {
                    return true;
                }
            }
            return false;
        }
    }
}
