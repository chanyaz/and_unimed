package com.appnext.core;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.mopub.common.Constants;
import java.io.IOException;

public class s {
    private static final String cD = "error_no_market";
    private String banner = "";
    private e click;
    private Context context;
    private String guid = "";
    private String kS = "";
    private j mt;
    private a mu;
    private com.appnext.core.e.a mv = new com.appnext.core.e.a() {
        public void error(String str) {
            try {
                s.this.b(g.p("admin.appnext.com", "applink"), s.this.mu.ad().getBannerID(), s.this.mu.ac().getPlacementID(), s.this.mu.ac().getTID(), str, "SetDOpenV1");
            } catch (Throwable th) {
            }
            try {
                if (Boolean.parseBoolean(s.this.mu.ae().get("urlApp_protection"))) {
                    s.this.openLink("market://details?id=" + s.this.mu.ad().getAdPackage());
                } else if (str != null) {
                    try {
                        s.this.openLink(str);
                    } catch (Throwable th2) {
                        s.this.mu.report("error_no_market");
                    }
                }
            } catch (Throwable th3) {
            }
        }

        public void onMarket(String str) {
            AppnextAd ad = s.this.mu.ad();
            Ad ac = s.this.mu.ac();
            if (ac != null) {
                Context context = ac.getContext();
                if (ad != null && context != null) {
                    if (!g.h(context, ad.getAdPackage())) {
                        try {
                            if (!(str.startsWith("market://details?id=" + ad.getAdPackage()) || str.startsWith(Constants.HTTP))) {
                                s.this.b(g.p("admin.appnext.com", "applink"), ad.getBannerID(), ac.getPlacementID(), ac.getTID(), str, "SetROpenV1");
                            }
                        } catch (Throwable th) {
                        }
                        if (s.this.mt == null) {
                            s.this.mt = new j();
                        }
                        s.this.mt.a(ad.getAdPackage(), str, g.p("admin.appnext.com", "applink"), ad.getBannerID(), ac.getPlacementID(), ac.getTID(), ac.getVID(), ac.getAUID(), null);
                        s.this.mt.C(context);
                        try {
                            s.this.openLink(str);
                        } catch (Throwable th2) {
                            s.this.mu.report("error_no_market");
                        }
                    } else if (str.startsWith("market://")) {
                        try {
                            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(ad.getAdPackage());
                            launchIntentForPackage.addFlags(268435456);
                            context.startActivity(launchIntentForPackage);
                        } catch (Throwable th3) {
                            s.this.mu.report("error_no_market");
                        }
                    } else {
                        try {
                            s.this.openLink(str);
                        } catch (Throwable th4) {
                            s.this.mu.report("error_no_market");
                        }
                    }
                }
            }
        }
    };

    public interface a {
        Ad ac();

        AppnextAd ad();

        r ae();

        void report(String str);
    }

    public s(Context context, a aVar) {
        this.context = context;
        this.click = e.s(context);
        this.mu = aVar;
    }

    private void openLink(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        this.mu.ac().getContext().startActivity(intent);
    }

    public void a(final AppnextAd appnextAd, final String str, final com.appnext.core.e.a aVar) {
        if (this.click != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    try {
                        s.this.click.a(str + "&device=" + g.da() + "&ox=0", appnextAd.getBannerID(), new com.appnext.core.e.a() {
                            public void error(String str) {
                                s.this.kS = "";
                                s.this.guid = "";
                                s.this.banner = "";
                                if (aVar != null) {
                                    aVar.error(str);
                                }
                            }

                            public void onMarket(String str) {
                                s.this.kS = str;
                                s.this.guid = g.p("admin.appnext.com", "applink");
                                s.this.banner = appnextAd.getBannerID();
                                if (aVar != null) {
                                    aVar.onMarket(str);
                                }
                            }
                        });
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    public void a(AppnextAd appnextAd, String str, String str2, com.appnext.core.e.a aVar) {
        final String str3 = str;
        final com.appnext.core.e.a aVar2 = aVar;
        final AppnextAd appnextAd2 = appnextAd;
        final String str4 = str2;
        new Thread(new Runnable() {
            public void run() {
                if (!s.this.dk()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            s.this.mv.error(str3 + "&device=" + g.da());
                            if (aVar2 != null) {
                                aVar2.error(str3 + "&device=" + g.da());
                            }
                        }
                    });
                } else if (appnextAd2 != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            if (s.this.kS.equals("") || !s.this.kS.contains(appnextAd2.getAdPackage())) {
                                g.X("click url " + str3);
                                String str = str3 + "&device=" + g.da();
                                String webview = appnextAd2.getWebview();
                                Object obj = -1;
                                switch (webview.hashCode()) {
                                    case 48:
                                        if (webview.equals("0")) {
                                            obj = 2;
                                            break;
                                        }
                                        break;
                                    case 49:
                                        if (webview.equals("1")) {
                                            obj = 1;
                                            break;
                                        }
                                        break;
                                    case 50:
                                        if (webview.equals("2")) {
                                            obj = null;
                                            break;
                                        }
                                        break;
                                }
                                switch (obj) {
                                    case null:
                                        try {
                                            s.this.mv.onMarket(str);
                                            if (aVar2 != null) {
                                                aVar2.onMarket(str);
                                                return;
                                            }
                                            return;
                                        } catch (Throwable th) {
                                            return;
                                        }
                                    case 1:
                                        Intent intent = new Intent(s.this.context, ResultActivity.class);
                                        intent.putExtra("url", str);
                                        intent.putExtra("title", appnextAd2.getAdTitle());
                                        intent.addFlags(268435456);
                                        s.this.mu.ac().getContext().startActivity(intent);
                                        if (aVar2 != null) {
                                            aVar2.onMarket(str);
                                            return;
                                        }
                                        return;
                                    default:
                                        s.this.click.a(str, appnextAd2.getBannerID(), new com.appnext.core.e.a() {
                                            public void error(String str) {
                                                s.this.mv.error(str);
                                                if (aVar2 != null) {
                                                    aVar2.error(str);
                                                }
                                            }

                                            public void onMarket(String str) {
                                                s.this.mv.onMarket(str);
                                                if (aVar2 != null) {
                                                    aVar2.onMarket(str);
                                                }
                                            }
                                        }, Long.parseLong(s.this.mu.ae().get("resolve_timeout")) * 1000);
                                        return;
                                }
                            }
                            new Thread(new Runnable() {
                                public void run() {
                                    try {
                                        g.a("https://admin.appnext.com/AdminService.asmx/SetRL?guid=" + s.this.guid + "&bid=" + s.this.banner + "&pid=" + str4, null);
                                    } catch (Throwable th) {
                                        g.c(th);
                                    }
                                }
                            }).start();
                            s.this.mv.onMarket(s.this.kS);
                            if (aVar2 != null) {
                                aVar2.onMarket(s.this.kS);
                            }
                        }
                    });
                }
            }
        }).start();
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.click.a(str, str2, str3, str4, str5, str6);
    }

    public void destroy() {
        try {
            if (this.mt != null) {
                this.mt.d(this.context);
            }
            this.mt = null;
        } catch (Throwable th) {
        }
        this.context = null;
        this.click.destroy();
    }

    protected boolean dk() {
        try {
            if (this.context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
                g.a("http://www.appnext.com/myid.html", null);
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    throw new IOException();
                }
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public void e(AppnextAd appnextAd) {
        this.click.e(appnextAd);
    }
}
