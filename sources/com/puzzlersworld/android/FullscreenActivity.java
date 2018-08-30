package com.puzzlersworld.android;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.ah;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Layout.Alignment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.appnext.ads.fullscreen.FullScreenVideo;
import com.appnext.ads.interstitial.Interstitial;
import com.appnext.base.Appnext;
import com.appnext.core.Ad;
import com.appnext.core.callbacks.OnAdClicked;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.h;
import com.google.common.base.ab;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.gson.Gson;
import com.mikepenz.fontawesome_typeface_library.FontAwesome.Icon;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.Drawer.OnDrawerItemClickListener;
import com.mikepenz.materialdrawer.Drawer.OnDrawerNavigationListener;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubInterstitial.InterstitialAdListener;
import com.puzzlersworld.android.common.AndroAppFragmentType;
import com.puzzlersworld.android.data.b;
import com.puzzlersworld.android.exception.UiErrorHandler;
import com.puzzlersworld.android.ui.a.d;
import com.puzzlersworld.android.ui.activity.AndroAppFragment;
import com.puzzlersworld.android.ui.activity.CartActivity;
import com.puzzlersworld.android.ui.activity.CheckoutActivity;
import com.puzzlersworld.android.ui.activity.FeedActivity;
import com.puzzlersworld.android.ui.activity.FeedDetailActivity;
import com.puzzlersworld.android.ui.activity.ImageViewFragment;
import com.puzzlersworld.android.ui.activity.ViewPagerFragement;
import com.puzzlersworld.android.ui.activity.util.VideoEnabledWebChromeClient;
import com.puzzlersworld.android.ui.activity.util.VideoEnabledWebChromeClient.ToggledFullscreenCallback;
import com.puzzlersworld.android.ui.worker.ShareButtonHandler;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.annotations.ForBackground;
import com.puzzlersworld.android.util.annotations.ForUi;
import com.puzzlersworld.android.util.c;
import com.puzzlersworld.android.util.f;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.android.util.i;
import com.puzzlersworld.android.util.j;
import com.puzzlersworld.android.util.k;
import com.puzzlersworld.android.util.m;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.controller.a;
import com.puzzlersworld.wp.dto.AndroAdProvider;
import com.puzzlersworld.wp.dto.AndroAppAdUnit;
import com.puzzlersworld.wp.dto.AppnextAdType;
import com.puzzlersworld.wp.dto.Cart;
import com.puzzlersworld.wp.dto.Config;
import com.puzzlersworld.wp.dto.CreateOrderRequest;
import com.puzzlersworld.wp.dto.Customer;
import com.puzzlersworld.wp.dto.Layout;
import com.puzzlersworld.wp.dto.Menu;
import com.puzzlersworld.wp.dto.MenuItemType;
import com.puzzlersworld.wp.dto.Monetise;
import com.puzzlersworld.wp.dto.Post;
import com.puzzlersworld.wp.dto.PostContentType;
import com.puzzlersworld.wp.dto.StringConstants;
import com.puzzlersworld.wp.dto.ThemeColors;
import com.puzzlersworld.wp.dto.X;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;

public class FullscreenActivity extends AppCompatActivity implements InterstitialAdListener, UiErrorHandler, ToggledFullscreenCallback {
    public static String D = null;
    public static String E = null;
    private static int J = 0;
    private static Layout P = null;
    private static ThemeColors Q = null;
    private static Config R = null;
    private static String ak = "";
    private static X al;
    public static Monetise o = new Monetise();
    public static String p = "category";
    public static String q = "author";
    public static String r = "tag";
    public static String s = "";
    @Inject
    @ForBackground
    ListeningScheduledExecutorService A;
    @ForUi
    @Inject
    ListeningExecutorService B;
    @Inject
    a C;
    private CharSequence F = "Main Title";
    private String G = "Select Category";
    private String H = "Home";
    private h I = null;
    private boolean K = true;
    private ViewGroup L = null;
    private RelativeLayout M = null;
    private VideoEnabledWebChromeClient N = null;
    private WebView O = null;
    private RelativeLayout S = null;
    private LinearLayout T = null;
    private TextView U = null;
    private ProgressBar V = null;
    private com.puzzlersworld.android.exception.a W = new com.puzzlersworld.android.exception.a(this);
    private ProgressDialog X;
    private boolean Y = false;
    private boolean Z = false;
    private boolean aa = false;
    private boolean ab = false;
    private MoPubInterstitial ac = null;
    private boolean ad = false;
    private Intent ae = null;
    private Drawer af = null;
    private Ad ag = null;
    private TabLayout ah = null;
    private LinearLayout ai = null;
    private boolean aj = false;
    private m am;
    private Pattern an;
    private Pattern ao;
    private Toolbar ap;
    ShareButtonHandler n;
    @Inject
    RestServiceManager t;
    @Inject
    i u;
    @Inject
    c v;
    @Inject
    ObjectMapper w;
    @Inject
    b x;
    @Inject
    g y;
    Gson z;

    public static Config A() {
        return R;
    }

    public static X E() {
        return al;
    }

    public static String H() {
        return ak;
    }

    private void J() {
        D = this.y.j();
        E = this.y.k();
        if (D == null || D.isEmpty()) {
            String g = this.y.g();
            if (g != null && !g.isEmpty()) {
                try {
                    Customer customer = (Customer) this.w.readValue(g, Customer.class);
                    if (customer != null) {
                        D = customer.getUsername();
                        E = customer.getEmail();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void K() {
        if (ak.isEmpty()) {
            if (ConsentInformation.a((Context) this).d()) {
                ak = "1";
            } else {
                ak = "0";
            }
            this.y.b("npa_key", ak);
        }
    }

    private void L() {
        for (AndroAppAdUnit androAppAdUnit : o.getInterstitialdUnitList()) {
            if (androAppAdUnit.getAdProvider() == AndroAdProvider.ADMOB) {
                if (this.I == null) {
                    this.I = new h(this);
                    this.I.a(androAppAdUnit.getAdId());
                    Bundle bundle = new Bundle();
                    bundle.putString("npa", H());
                    this.I.a(new e().b("45BC4D849BAEB77D6E28014DE82AECD5").a(AdMobAdapter.class, bundle).a());
                    this.I.a(new com.google.android.gms.ads.a() {
                        public void onAdClosed() {
                            FullscreenActivity.this.I.a(new e().b("B3EEABB8EE11C2BE770B684D95219ECB").a());
                        }
                    });
                }
            } else if (androAppAdUnit.getAdProvider() == AndroAdProvider.APPNEXT) {
                if (!ab.a(androAppAdUnit.getAdId())) {
                    a(A().getMonetise().getAppNextInterstitialAdType(), androAppAdUnit.getAdId());
                }
            } else if (androAppAdUnit.getAdProvider() == AndroAdProvider.MOPUB && this.ac == null) {
                a(androAppAdUnit);
            }
        }
    }

    private boolean M() {
        if (this.I == null) {
            L();
        }
        for (AndroAppAdUnit androAppAdUnit : o.getInterstitialdUnitList()) {
            boolean z;
            if (androAppAdUnit.getAdProvider() == AndroAdProvider.ADMOB) {
                if (this.I != null) {
                    this.I.b();
                    z = true;
                    continue;
                }
                z = false;
                continue;
            } else if (androAppAdUnit.getAdProvider() == AndroAdProvider.MOPUB) {
                if (this.ac != null && this.ad) {
                    this.ac.show();
                    z = true;
                    continue;
                }
                z = false;
                continue;
            } else {
                if (androAppAdUnit.getAdProvider() == AndroAdProvider.APPNEXT && k()) {
                    z = true;
                    continue;
                }
                z = false;
                continue;
            }
            if (z) {
                J = 0;
                this.K = false;
                return true;
            }
        }
        return false;
    }

    private void N() {
        if (VERSION.SDK_INT >= 11 && f() != null) {
            n();
        }
    }

    private void O() {
        if (al != null) {
            if (al.getD() == null) {
                al.setD(w.a(new Date(), -5));
            }
            Log.d("FullScreenActivity", "Date compare " + new Date().compareTo(al.getD()));
        }
        if (al == null || new Date().compareTo(al.getD()) > 0) {
            String a = w.a((Context) this);
            Log.d("AndroApp", "Version name = " + a);
            Object obj = (X) this.t.getAndroAppService().fetchInfo(getString(R.string.client_id), a).execute().b();
            obj.setD(w.a(new Date(), 4));
            al = obj;
            this.y.c(this.z.toJson(obj));
            a(o);
            Log.d("FullScreenActivity", "Info = " + obj.getV());
        }
    }

    private void P() {
        Drawable layerDrawable;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_launcher)).setGravity(17);
        if (VERSION.SDK_INT >= 23) {
            k kVar = new k(this);
            CharSequence string = getResources().getString(R.string.app_name);
            kVar.a(string);
            kVar.a(Color.parseColor(Q.getActionBarTitleColor()));
            kVar.a(30.0f);
            if (string.length() > 28) {
                kVar.a(15.0f);
            } else if (string.length() > 18) {
                kVar.a(20.0f);
            }
            kVar.a(Alignment.ALIGN_CENTER);
            layerDrawable = new LayerDrawable(new Drawable[]{r1, kVar});
            layerDrawable.setLayerGravity(1, 17);
            layerDrawable.setLayerInsetTop(1, 280);
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{r1});
        }
        this.af = new com.mikepenz.materialdrawer.b().a(new com.mikepenz.materialdrawer.a().a((Activity) this).a(layerDrawable).a(true).a()).a((Activity) this).a(toolbar).b(true).e(true).d(true).b(Color.parseColor(Q.getActionBarBgColor())).a(new OnDrawerNavigationListener() {
            public boolean onNavigationClickListener(View view) {
                AndroAppFragment androAppFragment = (AndroAppFragment) f.b(FullscreenActivity.this.e());
                if (androAppFragment == null || ((!(androAppFragment instanceof ViewPagerFragement) || ((ViewPagerFragement) androAppFragment).a()) && androAppFragment.getFragmentType() != AndroAppFragmentType.CART_ACTIVITY && androAppFragment.getFragmentType() != AndroAppFragmentType.CHECKOUT_ACTIVITY && androAppFragment.getFragmentType() != AndroAppFragmentType.FEED_ACTIVITY && androAppFragment.getFragmentType() != AndroAppFragmentType.IMAGE_VIEW_FRAGMENT)) {
                    return false;
                }
                FullscreenActivity.this.onBackPressed();
                return true;
            }
        }).a(new OnDrawerItemClickListener() {
            /* JADX WARNING: Missing block: B:5:0x0016, code:
            if (r0.getSubItems().size() > 0) goto L_0x0018;
     */
            public boolean onItemClick(android.view.View r4, int r5, com.mikepenz.materialdrawer.model.interfaces.IDrawerItem r6) {
                /*
                r3 = this;
                r2 = 0;
                r0 = r6 instanceof com.mikepenz.materialdrawer.model.m;
                if (r0 == 0) goto L_0x0019;
            L_0x0005:
                r0 = r6;
                r0 = (com.mikepenz.materialdrawer.model.m) r0;
                r1 = r0.getSubItems();
                if (r1 == 0) goto L_0x0019;
            L_0x000e:
                r0 = r0.getSubItems();
                r0 = r0.size();
                if (r0 <= 0) goto L_0x0019;
            L_0x0018:
                return r2;
            L_0x0019:
                r0 = r6.getTag();
                r0 = (com.puzzlersworld.wp.dto.Menu) r0;
                if (r0 == 0) goto L_0x0018;
            L_0x0021:
                r1 = com.puzzlersworld.android.FullscreenActivity.this;
                r1.Q();
                r1 = com.puzzlersworld.android.FullscreenActivity.this;
                r1.a(r0, r5);
                goto L_0x0018;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.puzzlersworld.android.FullscreenActivity.13.onItemClick(android.view.View, int, com.mikepenz.materialdrawer.model.interfaces.IDrawerItem):boolean");
            }
        }).e();
    }

    private void Q() {
        this.ah.setSelectedTabIndicatorColor(Color.parseColor(Q.getActionBarBgColor()));
        LinearLayout linearLayout = (LinearLayout) this.ah.getChildAt(0);
        if (linearLayout != null && linearLayout.getChildAt(this.ah.getSelectedTabPosition()) != null) {
            linearLayout.getChildAt(this.ah.getSelectedTabPosition()).setBackgroundColor(Color.parseColor(Q.getActionBarBgColor()));
        }
    }

    private void R() {
        try {
            String a = this.y.a("wp_core_namespace", "");
            String a2 = this.y.a("androapp_namespace", "");
            if (ab.a(a) || ab.a(a2)) {
                this.t.resetNameSpace(w.b(this.t));
            }
            Object obj = (Config) this.t.getWpApiService().fetchConfig().execute().b();
            if (obj == null) {
                Log.d("AndroApp", "NameSpace switch...");
                this.t.resetNameSpace(w.b(this.t));
                obj = (Config) this.t.getWpApiService().fetchConfig().execute().b();
            }
            a = this.z.toJson(obj);
            this.y.b(a);
            this.y.b();
            Log.d("FullScreenActivity", "Saved config " + this.y.e());
            final Config config = (Config) this.z.fromJson(a, Config.class);
            if (config != null) {
                R = config;
                if (P == null) {
                    a(config);
                    P = config.getLayout();
                    this.B.execute(new Runnable() {
                        public void run() {
                            FullscreenActivity.this.b(config.getMenuList(), true);
                            FullscreenActivity.this.a(config.getSliderMenu(), true);
                            FullscreenActivity.this.r();
                            FullscreenActivity.this.p();
                            Menu menu = new Menu();
                            menu.setMenuItemType(MenuItemType.home);
                            menu.setName(FullscreenActivity.this.H);
                            menu.setIsHome(Boolean.valueOf(true));
                            FullscreenActivity.this.a(menu, -1);
                            FullscreenActivity.this.aj = true;
                        }
                    });
                    return;
                }
                a(config);
                this.B.execute(new Runnable() {
                    public void run() {
                        FullscreenActivity.this.a(config.getSliderMenu(), true);
                        FullscreenActivity.this.b(config.getMenuList(), true);
                        FullscreenActivity.this.r();
                        FullscreenActivity.this.p();
                        FullscreenActivity.this.aj = true;
                    }
                });
                return;
            }
            throw new Exception("Config Parse ErrorResponse");
        } catch (final Exception e) {
            this.B.execute(new Runnable() {
                public void run() {
                    FullscreenActivity.this.W.a(e);
                }
            });
            Log.d("FullScreenActivity", "Exception while fetching menu " + e.getMessage());
            e.printStackTrace();
            FriopinApplication.a().a(e);
        }
    }

    private void S() {
        String e = this.y.e();
        ak = this.y.a("npa_key", "");
        Log.d("FullScreenActivity", "configdata " + e);
        Config config = (Config) this.z.fromJson(e, Config.class);
        R = config;
        if (config != null) {
            a(config);
            p();
            b(config.getMenuList(), true);
            a(config.getSliderMenu(), true);
            r();
        }
        e = this.y.h();
        Log.d("AndroApp", "CARTSESSION OnStart cookie " + e);
        Log.d("AndroApp", "XKEY OnStart " + this.y.f());
        Log.d("AndroApp", "COMMENT NAME" + this.y.j());
        Log.d("AndroApp", "COMMENT EMAIL" + this.y.k());
        s = this.y.i();
        try {
            if (!w.f(e)) {
                HashMap hashMap = (HashMap) this.w.readValue(e, HashMap.class);
                if (hashMap != null) {
                    this.v.a(hashMap);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void T() {
        s = "";
        this.y.d("");
        this.y.e(null);
        r();
        Toast.makeText(this, StringConstants.LOGGED_OUT.getMessage(), 1).show();
    }

    private MenuItemType U() {
        if (A() != null) {
            String homepage = A().getHomepage();
            if (homepage != null) {
                String[] split = homepage.split("_", 3);
                if (split.length == 3) {
                    return MenuItemType.fromValue2(split[1]);
                }
            }
        }
        return null;
    }

    private void V() {
    }

    private void a(Bundle bundle) {
        Menu menu = null;
        S();
        if (bundle == null) {
            this.A.execute(new Runnable() {
                public void run() {
                    Log.d("FullScreenActivity", "Fetching Menu data from network");
                    try {
                        FullscreenActivity.this.R();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Log.d("FullScreenActivity", "Fetching Androapp info data from network");
                    try {
                        FullscreenActivity.this.O();
                    } catch (IOException e2) {
                        Log.e("AndroApp", "ErrorResponse in fetching info from androapp server ");
                        e2.printStackTrace();
                    }
                }
            });
        } else {
            Log.d("AndroApp:", "Load Screen saved instance loading");
        }
        String string = (getIntent() == null || getIntent().getExtras() == null) ? null : getIntent().getExtras().getString("menuitem");
        if (string != null) {
            menu = (Menu) ((FriopinApplication) getApplication()).f().fromJson(string, Menu.class);
        }
        if (menu == null || menu.getMenuItemType() == null) {
            menu = new Menu();
            menu.setMenuItemType(MenuItemType.home);
            menu.setIsHome(Boolean.valueOf(true));
            menu.setName(this.H);
        }
        MenuItemType U = U();
        if (bundle == null && P != null) {
            a(menu, -1);
        }
        if (getIntent() != null) {
            if (U == MenuItemType.page || U == MenuItemType.post) {
                this.ae = getIntent();
            } else {
                d(getIntent());
            }
        }
        L();
    }

    private void a(com.mikepenz.materialdrawer.model.m mVar, Menu menu) {
        try {
            if (ab.a(menu.getIcon())) {
                w.a(mVar, menu, (Activity) this);
            } else {
                mVar.withIcon(Icon.valueOf(menu.getIcon()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(AndroAppAdUnit androAppAdUnit) {
        this.ac = new MoPubInterstitial(this, androAppAdUnit.getAdId());
        this.ac.setInterstitialAdListener(this);
        this.ac.load();
    }

    private void a(AppnextAdType appnextAdType, String str) {
        if (appnextAdType == AppnextAdType.FULL_SCREEN_VIDEO) {
            this.ag = new FullScreenVideo((Context) this, str);
            ((FullScreenVideo) this.ag).setShowClose(true);
        } else {
            this.ag = new Interstitial(this, str);
        }
        this.ag.setOnAdLoadedCallback(new OnAdLoaded() {
            public void adLoaded(String str) {
                FullscreenActivity.this.aa = true;
            }
        });
        this.ag.setOnAdClickedCallback(new OnAdClicked() {
            public void adClicked() {
                FullscreenActivity.this.j();
            }
        });
        this.ag.setOnAdClosedCallback(new OnAdClosed() {
            public void onAdClosed() {
                FullscreenActivity.this.j();
            }
        });
        this.ag.setOnAdErrorCallback(new OnAdError() {
            public void adError(String str) {
                FullscreenActivity.this.ab = true;
            }
        });
        j();
    }

    private void a(Config config) {
        P = config.getLayout();
        Q = config.getColors();
        o = config.getMonetise();
        a(o);
        FriopinApplication.h().setStringMap(config.getStringMap());
        this.H = StringConstants.HOME.getMessage();
        this.G = StringConstants.SELECT_CATEGORY.getMessage();
        if (!ab.a(config.getTag_base())) {
            r = config.getTag_base();
        }
        if (!ab.a(config.getCategory_base())) {
            p = config.getCategory_base();
        }
        if (ab.a(config.getRegexOpenInWebview())) {
            this.an = null;
        } else {
            this.an = Pattern.compile(config.getRegexOpenInWebview());
        }
        if (ab.a(config.getRegexOpenInBrowser())) {
            this.ao = null;
        } else {
            this.ao = Pattern.compile(config.getRegexOpenInBrowser());
        }
    }

    private void a(Monetise monetise) {
        if (!(al == null || al.getV().booleanValue())) {
            Monetise monetise2 = al.getMonetise();
            if (monetise2 != null) {
                monetise.setListViewAdFreq(monetise2.getListViewAdFreq());
                monetise.setInterstitialAdFreq(monetise2.getInterstitialAdFreq());
                monetise.setAppNextInterstitialAdType(monetise2.getAppNextInterstitialAdType());
                monetise.setAppNextInterstitialAdType(monetise2.getAppNextInterstitialAdType());
                monetise.setBottomAdUnitList(monetise2.getBottomAdUnitList());
                monetise.setTopAdUnitList(monetise2.getTopAdUnitList());
                monetise.setMiddleAdUnitList(monetise2.getMiddleAdUnitList());
                monetise.setInterstitialdUnitList(monetise2.getInterstitialdUnitList());
            }
        }
        if (monetise.getMiddleAdUnitList().size() == 0) {
            monetise.setListViewAdFreq(10000);
        }
        if (monetise.getInterstitialdUnitList().size() == 0) {
            monetise.setInterstitialAdFreq(1000);
        }
    }

    private void a(List<Menu> list, boolean z) {
        if (z) {
            this.ah.b();
        }
        for (Object obj : list) {
            ah a = this.ah.a().a(obj.getName());
            a.a(obj);
            this.ah.a(a);
        }
        if (list != null && list.size() > 0) {
            LinearLayout linearLayout = (LinearLayout) this.ah.getChildAt(0);
            if (!(linearLayout == null || linearLayout.getChildAt(this.ah.getSelectedTabPosition()) == null)) {
                linearLayout.getChildAt(this.ah.getSelectedTabPosition()).setSelected(false);
            }
        }
        Fragment c = f.c(e());
        if (c == null || !(c instanceof AndroAppFragment)) {
            a(AndroAppFragmentType.FEED_ACTIVITY);
        } else {
            a(((AndroAppFragment) c).getFragmentType());
        }
    }

    private void b(String str) {
        if (!str.isEmpty()) {
            Menu menu = new Menu();
            menu.setName(str);
            menu.setMenuItemType(MenuItemType.search);
            menu.setSlug(str);
            a(menu, -1);
        }
    }

    private void b(List<Menu> list, boolean z) {
        if (this.af == null) {
            P();
        }
        int parseColor = Color.parseColor(Q.getActionBarTitleColor());
        int parseColor2 = Color.parseColor(Q.getStatusBarBgColor());
        List<IDrawerItem> arrayList = new ArrayList();
        Map hashMap = new HashMap();
        for (Menu menu : list) {
            com.mikepenz.materialdrawer.model.m mVar = (com.mikepenz.materialdrawer.model.m) ((com.mikepenz.materialdrawer.model.m) new com.mikepenz.materialdrawer.model.m().withName(menu.getName())).withTag(menu);
            if (menu.getID() != null) {
                mVar.withIdentifier(menu.getID().longValue());
            }
            mVar.b(parseColor);
            mVar.d(parseColor);
            mVar.a(parseColor2);
            mVar.c(parseColor);
            mVar.e(1);
            hashMap.put(menu.getID(), mVar);
            if (menu.getParentId() == null || hashMap.get(menu.getParentId()) == null) {
                arrayList.add(mVar);
                a(mVar, menu);
            } else {
                com.mikepenz.materialdrawer.model.m mVar2 = (com.mikepenz.materialdrawer.model.m) hashMap.get(menu.getParentId());
                List subItems = mVar2.getSubItems();
                if (subItems == null) {
                    subItems = new ArrayList();
                    mVar2.withSubItems(subItems);
                    mVar2.withBadge("⇅");
                }
                List list2 = subItems;
                mVar.e(w.a(menu, hashMap));
                a(mVar, menu);
                list2.add(mVar);
            }
        }
        if (z) {
            this.af.a((List) arrayList);
            return;
        }
        for (IDrawerItem iDrawerItem : arrayList) {
            this.af.a(iDrawerItem);
        }
    }

    private void c(Intent intent) {
        if ("android.intent.action.SEARCH".equals(intent.getAction())) {
            b(intent.getStringExtra("query"));
        } else {
            e(intent);
        }
    }

    private void c(String str) {
        this.V.setVisibility(8);
        this.T.setVisibility(0);
        this.U.setText(str + "\n" + StringConstants.RETRY.getMessage());
    }

    private void d(Intent intent) {
        if (intent.getExtras() != null) {
            e(intent);
        }
        if (intent.getData() != null) {
            String action = intent.getAction();
            Uri data = intent.getData();
            Log.d("FullScreenActivity", "Action " + action + " Uri " + data);
            w.a(this.C, data.toString());
        }
    }

    private void e(Intent intent) {
        String stringExtra = intent.getStringExtra("entity");
        if (stringExtra != null) {
            d.a(getApplicationContext(), stringExtra);
        } else {
            try {
                Long valueOf = Long.valueOf(intent.getLongExtra("notificationPostId", -1));
                stringExtra = intent.getStringExtra("postType");
                if (stringExtra == null || stringExtra.isEmpty()) {
                    stringExtra = "post";
                }
                if (valueOf.longValue() != -1) {
                    Menu menu = new Menu();
                    if (A().getCustomPostTypes().contains(stringExtra)) {
                        menu.setMenuItemType(MenuItemType.custom_post_type);
                    } else {
                        menu.setMenuItemType(MenuItemType.valueOf(stringExtra));
                    }
                    menu.setTaxonomy_name(stringExtra);
                    menu.setObjectId(valueOf);
                    a(menu);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (intent.getExtras().getInt("requestCode") == 12426) {
            com.puzzlersworld.android.gcm.a.c.clear();
        }
    }

    public static Layout y() {
        return P;
    }

    public static ThemeColors z() {
        return Q;
    }

    public ShareButtonHandler B() {
        return this.n;
    }

    public void C() {
        this.X.dismiss();
    }

    public boolean D() {
        return this.Z;
    }

    public Toolbar F() {
        return this.ap;
    }

    public LinearLayout G() {
        return this.ai;
    }

    public void a(Fragment fragment, String str, boolean z, int i, boolean z2) {
        if (fragment != null) {
            try {
                FragmentManager e = e();
                if (z) {
                    f.a(e);
                }
                FragmentTransaction a = e.a();
                if (fragment instanceof FeedActivity) {
                    a.a((int) R.anim.abc_slide_in_bottom, (int) R.anim.abc_slide_out_bottom);
                } else {
                    a.a((int) R.anim.slide_in_left, (int) R.anim.slide_out_right);
                }
                if (z) {
                    a.a(R.id.content_frame, fragment, null);
                } else {
                    a.b(R.id.content_frame, fragment, null);
                }
                if (!(z || ((fragment instanceof FeedDetailActivity) && this.Z && ((FeedDetailActivity) fragment).af() != null))) {
                    a = a.a(null);
                }
                if ((fragment instanceof FeedDetailActivity) && ((FeedDetailActivity) fragment).af() != null && ((FeedDetailActivity) fragment).af().startsWith(CheckoutActivity.a())) {
                    this.Z = true;
                }
                if (i == -1) {
                    this.af.a(-1);
                }
                this.F = Html.fromHtml(str);
                setTitle(this.F);
                if (z2) {
                    a.d();
                } else {
                    a.c();
                }
                s();
                return;
            } catch (Exception e2) {
                Log.e("AndroApp:", e2.getMessage());
                return;
            }
        }
        Log.e("MainActivity", "ErrorResponse in creating fragment");
    }

    public void a(WebView webView) {
        this.O = webView;
    }

    public void a(AndroAppFragmentType androAppFragmentType) {
        if (androAppFragmentType != AndroAppFragmentType.FEED_ACTIVITY) {
            this.ah.setVisibility(8);
        } else if (R.getSliderMenu() == null || R.getSliderMenu().size() == 0) {
            this.ah.setVisibility(8);
        } else {
            this.ah.setVisibility(0);
        }
    }

    public void a(VideoEnabledWebChromeClient videoEnabledWebChromeClient) {
        this.N = videoEnabledWebChromeClient;
    }

    public void a(CreateOrderRequest createOrderRequest, Cart cart) {
        N();
        Fragment checkoutActivity = new CheckoutActivity();
        checkoutActivity.a(createOrderRequest);
        checkoutActivity.a(cart);
        a(checkoutActivity, StringConstants.CHECKOUT.getMessage(), false, -1, false);
    }

    public void a(Menu menu) {
        Fragment viewPagerFragement = new ViewPagerFragement();
        List arrayList = new ArrayList();
        Post post = new Post();
        post.setTitle("");
        post.setPostType(menu.getTaxonomy_name());
        post.setMenuItem(menu);
        arrayList.add(post);
        viewPagerFragement.a(arrayList);
        viewPagerFragement.a(false);
        a(viewPagerFragement, post.getTitle(), menu.getIsHome().booleanValue(), -1, false);
    }

    public void a(Menu menu, int i) {
        N();
        if (menu.getMenuItemType() == MenuItemType.custom) {
            w.a(this.C, menu.getLink());
        } else if (menu.getMenuItemType() == MenuItemType.log_out) {
            T();
        } else if (menu.getMenuItemType() == MenuItemType.post || menu.getMenuItemType() == MenuItemType.page) {
            a(menu);
        } else {
            if (menu.getMenuItemType() == MenuItemType.home && A().getHomepage() != null && A().getHomepage().startsWith("single")) {
                try {
                    String[] split = A().getHomepage().split("_", 3);
                    if (split.length == 3) {
                        MenuItemType fromValue2 = MenuItemType.fromValue2(split[1]);
                        if (fromValue2 != null) {
                            menu.setMenuItemType(fromValue2);
                            try {
                                long parseLong = Long.parseLong(split[2]);
                                if (fromValue2 == MenuItemType.tag || fromValue2 == MenuItemType.author || fromValue2 == MenuItemType.product_cat || fromValue2 == MenuItemType.product_tag) {
                                    menu.setSlug(split[2]);
                                    menu.setIsHome(Boolean.valueOf(true));
                                    a(menu, i);
                                    return;
                                }
                                menu.setObjectId(Long.valueOf(parseLong));
                                menu.setIsHome(Boolean.valueOf(true));
                                a(menu, i);
                                return;
                            } catch (NumberFormatException e) {
                                menu.setSlug(split[2]);
                            }
                        }
                    }
                } catch (Exception e2) {
                }
            }
            Fragment feedActivity = new FeedActivity();
            ((FeedActivity) feedActivity).a(menu);
            a(feedActivity, menu.getName(), menu.getIsHome().booleanValue(), i, false);
        }
    }

    public void a(Post post, String str) {
        Fragment imageViewFragment = new ImageViewFragment();
        imageViewFragment.a(post);
        imageViewFragment.b(str);
        a(imageViewFragment, post.getTitle(), false, -1, false);
    }

    public void a(Post post, List<Post> list, Menu menu, boolean z) {
        N();
        if (post.getPostContentType() == PostContentType.loadimages) {
            a(post, null);
            return;
        }
        List list2;
        Fragment viewPagerFragement = new ViewPagerFragement();
        if (list2 == null) {
            list2 = new ArrayList();
            list2.add(post);
        }
        Iterator it = list2.iterator();
        int i = 0;
        while (it.hasNext() && ((Post) it.next()) != post) {
            i++;
        }
        viewPagerFragement.a(menu);
        viewPagerFragement.d(i);
        viewPagerFragement.a(list2);
        viewPagerFragement.a(z);
        a(viewPagerFragement, post.getTitle(), z, -1, false);
    }

    public void a(CharSequence charSequence) {
        this.F = charSequence;
        setTitle(this.F);
    }

    public void a(String str, String str2) {
        this.X.setMessage(str2);
        this.X.show();
    }

    public void a(String str, boolean z) {
        N();
        Fragment viewPagerFragement = new ViewPagerFragement();
        List arrayList = new ArrayList();
        Post post = new Post();
        post.setLink(str);
        post.setFetchUrl(Boolean.valueOf(z));
        arrayList.add(post);
        post.setTitle(str);
        viewPagerFragement.a(arrayList);
        viewPagerFragement.a(false);
        a(viewPagerFragement, post.getTitle(), false, -1, false);
    }

    public boolean a(Uri uri, String str) {
        return ((this.an == null || !this.an.matcher(str).matches()) && uri.getHost().indexOf("disqus.com") <= -1 && uri.getHost().indexOf("facebook.com") <= -1) ? this.Y : true;
    }

    public boolean a(String str) {
        return (this.ao == null || !this.ao.matcher(str).matches()) ? (this.Z && CheckoutActivity.ac() != null && "native".equals(CheckoutActivity.ac().getBrowser())) ? false : true : false;
    }

    public void b(boolean z) {
        if (VERSION.SDK_INT >= 11 && f() != null) {
            t().f().a(false);
            f().a(true);
            if (z) {
                f().a((int) R.drawable.cross);
            } else {
                f().b(null);
            }
            invalidateOptionsMenu();
        }
    }

    public void j() {
        if (this.ag != null) {
            this.ag.loadAd();
        }
    }

    public boolean k() {
        if (this.ag != null && this.ag.isAdLoaded()) {
            this.aa = false;
            this.ag.showAd();
            return true;
        } else if (!this.ab) {
            return false;
        } else {
            this.ab = false;
            j();
            return false;
        }
    }

    public void l() {
        this.V.setVisibility(0);
        this.T.setVisibility(8);
    }

    public void m() {
        if (VERSION.SDK_INT >= 11 && f() != null) {
            f().a(false);
            if (t() != null) {
                t().f().a(true);
            }
            invalidateOptionsMenu();
        }
    }

    public void n() {
        if (f() != null) {
            if (!(Q == null || f() == null)) {
                f().a(new ColorDrawable(com.github.ksoichiro.android.observablescrollview.c.a(1.0f, Color.parseColor(Q.getActionBarBgColor()))));
            }
            f().c();
            this.ap.setTranslationY(0.0f);
            this.ai.setTranslationY(0.0f);
        }
    }

    public int o() {
        return f() != null ? f().b() : 0;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        InjectibleApplication.a((Activity) this);
        Log.d("FullScreenActivity", "Req code " + i + " res code " + i2);
        switch (i) {
            case 12424:
                if (i2 == 101) {
                    e(intent);
                    return;
                } else if (i2 == 102) {
                    String stringExtra = intent.getStringExtra("menuitem");
                    if (stringExtra != null) {
                        a((Menu) ((FriopinApplication) getApplication()).f().fromJson(stringExtra, Menu.class), -1);
                        return;
                    }
                    return;
                } else if (i2 == 103) {
                    String stringExtra2 = intent.getStringExtra("url");
                    if (stringExtra2 != null) {
                        d.a(getApplicationContext(), stringExtra2, false);
                        return;
                    }
                    return;
                } else if (i2 == 104) {
                    InjectibleApplication.a((Activity) this);
                    a(null);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void onBackPressed() {
        if (this.O != null && VERSION.SDK_INT >= 11) {
            this.O.onPause();
        }
        if (this.N != null) {
            if (!this.N.a()) {
                if (!(this.O == null || this.O.isDirty() || !this.O.canGoBack())) {
                    this.O.goBack();
                    return;
                }
            }
            return;
        }
        AndroAppFragment androAppFragment = (AndroAppFragment) f.c(e());
        if (androAppFragment != null && androAppFragment.getFragmentType() == AndroAppFragmentType.FEED_DETAIL_ACTIVITY && (androAppFragment instanceof ViewPagerFragement)) {
            FeedDetailActivity feedDetailActivity = (FeedDetailActivity) ((ViewPagerFragement) androAppFragment).ac();
            if (feedDetailActivity != null && feedDetailActivity.ag()) {
                feedDetailActivity.ah();
                return;
            }
        }
        androAppFragment = (AndroAppFragment) f.b(e());
        if (!(androAppFragment == null || androAppFragment.getTitle() == null)) {
            Log.d("ANDROAPP", "Current Fragment " + androAppFragment.getTitle());
            this.F = Html.fromHtml(androAppFragment.getTitle());
            setTitle(this.F);
        }
        super.onBackPressed();
        if (androAppFragment == null || !(((androAppFragment instanceof ViewPagerFragement) && !((ViewPagerFragement) androAppFragment).a()) || androAppFragment.getFragmentType() == AndroAppFragmentType.CART_ACTIVITY || androAppFragment.getFragmentType() == AndroAppFragmentType.CHECKOUT_ACTIVITY)) {
            m();
        } else {
            if (androAppFragment.getFragmentType() == AndroAppFragmentType.CHECKOUT_ACTIVITY) {
                this.Z = false;
            }
            b(false);
        }
        c();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onConnectionTimeout() {
        c(StringConstants.CONNECTION_TIMEOUT.getMessage());
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(9);
        b(9);
        super.onCreate(bundle);
        InjectibleApplication.a((Activity) this);
        Appnext.init(this);
        this.X = new ProgressDialog(this);
        this.X.setTitle("Please Wait!!");
        this.X.setMessage("Wait!!");
        this.X.setCancelable(false);
        this.X.setProgressStyle(0);
        p = getString(R.string.category_base);
        r = getString(R.string.tag_base);
        q = getString(R.string.author_base);
        setContentView((int) R.layout.activity_fullscreen);
        this.ai = (LinearLayout) findViewById(R.id.appbarLayout);
        this.ap = (Toolbar) findViewById(R.id.toolbar);
        a(this.ap);
        this.am = new m(this.ap, this);
        m();
        if (VERSION.SDK_INT >= 11 && f() != null) {
            f().d();
        }
        this.S = (RelativeLayout) findViewById(R.id.loadingPanel);
        this.T = (LinearLayout) findViewById(R.id.retryLayout);
        this.U = (TextView) findViewById(R.id.retry);
        this.V = (ProgressBar) findViewById(R.id.progressbar);
        this.T.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FullscreenActivity.this.l();
                FullscreenActivity.this.A.execute(new Runnable() {
                    public void run() {
                        FullscreenActivity.this.R();
                    }
                });
            }
        });
        l();
        this.L = (ViewGroup) findViewById(R.id.target_view);
        this.M = (RelativeLayout) findViewById(R.id.drawer_layout);
        this.z = new Gson();
        this.n = new ShareButtonHandler(this.A);
        this.y.a();
        String f = this.y.f();
        if (f != null) {
            try {
                al = (X) this.z.fromJson(f, X.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.ah = (TabLayout) findViewById(R.id.tabs);
        this.ah.setTabMode(0);
        this.ah.setVisibility(8);
        this.ah.a(new OnTabSelectedListener() {
            public void onTabReselected(ah ahVar) {
                FullscreenActivity.this.ah.setSelectedTabIndicatorColor(Color.parseColor(FullscreenActivity.Q.getStatusBarBgColor()));
                FullscreenActivity.this.a((Menu) ahVar.a(), -1);
            }

            public void onTabSelected(ah ahVar) {
                if (FullscreenActivity.this.aj) {
                    FullscreenActivity.this.ah.setSelectedTabIndicatorColor(Color.parseColor(FullscreenActivity.Q.getStatusBarBgColor()));
                    FullscreenActivity.this.a((Menu) ahVar.a(), -1);
                }
            }

            public void onTabUnselected(ah ahVar) {
                LinearLayout linearLayout = (LinearLayout) FullscreenActivity.this.ah.getChildAt(0);
                if (linearLayout != null && linearLayout.getChildAt(FullscreenActivity.this.ah.getSelectedTabPosition()) != null) {
                    linearLayout.getChildAt(FullscreenActivity.this.ah.getSelectedTabPosition()).setBackgroundColor(Color.parseColor(FullscreenActivity.Q.getActionBarBgColor()));
                }
            }
        });
        J();
        try {
            K();
            a(bundle);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        Log.d("AndroApp:", "OnCreateOptionsMenu Called");
        getMenuInflater().inflate(R.menu.main, menu);
        com.puzzlersworld.android.util.b.a(menu, this.x);
        j.a(menu, this);
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.O != null) {
            this.O.destroy();
            this.O = null;
        }
    }

    public void onError(Exception exception) {
        c(StringConstants.UNKNOWN_ERROR.getMessage());
    }

    public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {
        this.ad = false;
        this.ac.load();
    }

    public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {
        this.ad = false;
        this.ac.load();
    }

    public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode) {
    }

    public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial) {
        this.ad = true;
    }

    public void onInterstitialShown(MoPubInterstitial moPubInterstitial) {
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c(intent);
    }

    public void onNoNetwork() {
        c(StringConstants.CANT_CONNECT.getMessage());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        AndroAppFragment androAppFragment = (AndroAppFragment) f.c(e());
        if (menuItem.getItemId() == R.id.cart) {
            Log.d("AndroApp", "Opening Cart Details page");
            q();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super.onPause();
        if (this.O != null && VERSION.SDK_INT >= 11) {
            this.O.onPause();
        }
        try {
            this.y.f(s);
            this.y.e(this.w.writeValueAsString(this.v.a()));
            this.y.b();
            Log.d("AndroApp", "XKEY " + this.y.f());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    public boolean onPrepareOptionsMenu(android.view.Menu menu) {
        com.puzzlersworld.android.util.b.a(menu, this.x);
        return super.onPrepareOptionsMenu(menu);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (iArr.length <= 0 || iArr[0] != 0) {
            this.u.b(i);
        } else {
            this.u.a(i);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.O != null && VERSION.SDK_INT >= 11) {
            try {
                this.O.onResume();
            } catch (Exception e) {
            }
        }
        InjectibleApplication.a((Activity) this);
        V();
        m();
        if (!(VERSION.SDK_INT < 11 || f() == null || P == null)) {
            f().c();
        }
        r();
        Log.d("AndroApp", "On resume FullScreenActivity");
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (!(this.O == null || this.O.isDirty())) {
            this.O.saveState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onShareButtonClick(View view) {
        Post post;
        Post post2 = null;
        AndroAppFragment androAppFragment = (AndroAppFragment) f.c(e());
        if (androAppFragment != null && androAppFragment.getFragmentType() == AndroAppFragmentType.FEED_DETAIL_ACTIVITY && (androAppFragment.getTriggerObject() instanceof Post)) {
            post = (Post) androAppFragment.getTriggerObject();
            FriopinApplication.a().a("Share", "Share from Post Page", "postId=" + post.getID());
            post2 = post;
        }
        if (post2 == null && (view.getParent() instanceof LinearLayout) && ((LinearLayout) view.getParent()).getTag() != null && (((LinearLayout) view.getParent()).getTag() instanceof Post)) {
            post = (Post) ((LinearLayout) view.getParent()).getTag();
            FriopinApplication.a().a("Share", "Share from List Page", "postId=" + post.getID());
        } else {
            post = post2;
        }
        if (post != null && view.getId() == R.id.share) {
            this.n.onShareButtonClick(view.getId(), this, post);
        }
    }

    public void p() {
        if (Q != null) {
            if (VERSION.SDK_INT >= 11 && f() != null) {
                f().a(new ColorDrawable(Color.parseColor(Q.getActionBarBgColor())));
            }
            if (VERSION.SDK_INT >= 21) {
                setTaskDescription(new TaskDescription(Html.fromHtml("<font color=\"" + Q.getActionBarTitleColor() + "\">" + getString(R.string.app_name) + "</font>").toString(), null, Color.parseColor(Q.getActionBarBgColor())));
                if (Q.getStatusBarBgColor() != null) {
                    Window window = getWindow();
                    window.clearFlags(67108864);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(Color.parseColor(Q.getStatusBarBgColor()));
                }
            }
            this.ah.a(Color.parseColor(Q.getActionBarTitleColor()), Color.parseColor(Q.getActionBarTitleColor()));
            this.ah.setBackgroundColor(Color.parseColor(Q.getActionBarBgColor()));
            this.ah.setSelectedTabIndicatorColor(Color.parseColor(Q.getActionBarBgColor()));
        }
        this.S.setVisibility(8);
    }

    public void q() {
        N();
        a(new CartActivity(), StringConstants.CART.getMessage(), false, -1, false);
    }

    public void r() {
        if (R != null) {
            List list;
            Menu menu;
            List menuList = R.getMenuList();
            if (menuList == null) {
                menuList = new ArrayList();
                R.setMenuList(menuList);
                list = menuList;
            } else {
                list = menuList;
            }
            boolean z = false;
            boolean z2 = false;
            for (Menu menu2 : list) {
                boolean z3;
                if (menu2.getMenuItemType() == MenuItemType.log_out) {
                    z3 = z;
                    z = true;
                } else if (menu2.getMenuItemType() == MenuItemType.save_for_later) {
                    z3 = true;
                    z = z2;
                } else {
                    z3 = z;
                    z = z2;
                }
                z2 = z;
                z = z3;
            }
            if (!(R.getShowSaveOption() == null || R.getShowSaveOption().intValue() != 1 || z)) {
                Menu menu3 = new Menu();
                menu3.setMenuItemType(MenuItemType.save_for_later);
                menu3.setName(StringConstants.OFFLINE_POSTS.getMessage());
                menu3.setIcon("faw_bookmark");
                int i = 0;
                for (Menu menu22 : list) {
                    i++;
                    if ((menu22.getMenuItemType() == MenuItemType.home || menu22.getMenuItemType() == MenuItemType.custom) && menu22.getLink().equalsIgnoreCase(getString(R.string.wp_server_base_path))) {
                        list.add(i, menu3);
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    list.add(0, menu3);
                }
                this.y.b(this.z.toJson(R));
                this.y.b();
                b((List) list, true);
            }
            if (s == null || s.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((Menu) it.next()).getMenuItemType() == MenuItemType.log_out) {
                        it.remove();
                        this.y.b(this.z.toJson(R));
                        this.y.b();
                        b((List) list, true);
                        return;
                    }
                }
            } else if (!z2) {
                menu22 = new Menu();
                menu22.setMenuItemType(MenuItemType.log_out);
                menu22.setName("Logout");
                menu22.setIcon("faw_sign_out");
                list.add(menu22);
                this.y.b(this.z.toJson(R));
                this.y.b();
                list = new ArrayList();
                list.add(menu22);
                b(list, false);
            }
        }
    }

    public boolean s() {
        J++;
        return D() ? false : (!this.K || J <= 2 || al == null || al.getV() == null || al.getV().booleanValue()) ? J > o.getInterstitialAdFreq() ? M() : false : M();
    }

    public void setTitle(CharSequence charSequence) {
        if (VERSION.SDK_INT >= 11 && f() != null) {
            if (Q != null) {
                f().a(Html.fromHtml("<font color=\"" + Q.getActionBarTitleColor() + "\">" + charSequence + "</font>"));
            } else {
                f().a(Html.fromHtml("" + charSequence));
            }
        }
    }

    public Drawer t() {
        return this.af;
    }

    public void toggledFullscreen(boolean z) {
        LayoutParams attributes;
        if (z) {
            attributes = getWindow().getAttributes();
            attributes.flags |= com.appnext.base.b.c.jk;
            attributes.flags |= 128;
            getWindow().setAttributes(attributes);
            if (VERSION.SDK_INT >= 14) {
                getWindow().getDecorView().setSystemUiVisibility(1);
                return;
            }
            return;
        }
        attributes = getWindow().getAttributes();
        attributes.flags &= -1025;
        attributes.flags &= -129;
        getWindow().setAttributes(attributes);
        if (VERSION.SDK_INT >= 14) {
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    public void u() {
        e().d();
    }

    public ViewGroup v() {
        return this.L;
    }

    public RelativeLayout w() {
        return this.M;
    }

    public ListeningExecutorService x() {
        return this.B;
    }
}
