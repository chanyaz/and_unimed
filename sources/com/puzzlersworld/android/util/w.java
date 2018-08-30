package com.puzzlersworld.android.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.net.MailTo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.appnext.banners.BannerAdRequest;
import com.appnext.banners.BannerSize;
import com.appnext.banners.BannerView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.f;
import com.google.common.base.ab;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.mikepenz.fontawesome_typeface_library.FontAwesome.Icon;
import com.mikepenz.materialdrawer.model.m;
import com.mopub.common.Constants;
import com.mopub.mobileads.MoPubView;
import com.mopub.volley.BuildConfig;
import com.puzzlersworld.a.a;
import com.puzzlersworld.android.FriopinApplication;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.dto.AdLocation;
import com.puzzlersworld.wp.dto.AdType;
import com.puzzlersworld.wp.dto.AndroAdProvider;
import com.puzzlersworld.wp.dto.AndroAppAdUnit;
import com.puzzlersworld.wp.dto.Category;
import com.puzzlersworld.wp.dto.ErrorResponse;
import com.puzzlersworld.wp.dto.Menu;
import com.puzzlersworld.wp.dto.MenuItemType;
import com.puzzlersworld.wp.dto.Post;
import com.puzzlersworld.wp.dto.Term;
import com.puzzlersworld.wp.dto.Terms;
import com.puzzlersworld.wp.dto.WpJson;
import com.puzzlersworld.wp.dto.X;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import mobi.androapp.ac.c8700.R;
import retrofit2.ai;

public class w {
    private w() {
    }

    public static int a(Menu menu, Map<Long, m> map) {
        return menu.getParentId() != null ? ((m) map.get(menu.getParentId())).l() + 1 : 1;
    }

    private static Intent a(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.TEXT", str3);
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.CC", str4);
        intent.setType("message/rfc822");
        return intent;
    }

    public static Bitmap a(Drawable drawable) {
        int i = 1;
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap a(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static View a(RelativeLayout relativeLayout, int i, int i2, List<AndroAppAdUnit> list, AdLocation adLocation) {
        for (AndroAppAdUnit androAppAdUnit : list) {
            if (!(androAppAdUnit == null || ab.a(androAppAdUnit.getAdId()) || !androAppAdUnit.showOnLocation(adLocation))) {
                if (androAppAdUnit.getAdProvider() == AndroAdProvider.ADMOB) {
                    return a(androAppAdUnit.getAdId(), relativeLayout, i, i2, a.a(androAppAdUnit.getAdType()));
                }
                if (androAppAdUnit.getAdProvider() == AndroAdProvider.MOPUB) {
                    return a(androAppAdUnit.getAdId(), relativeLayout, i, i2);
                }
                if (androAppAdUnit.getAdProvider() == AndroAdProvider.APPNEXT) {
                    return a(androAppAdUnit.getAdId(), relativeLayout, i, i2, InjectibleApplication.j(), androAppAdUnit.getAdType());
                }
            }
        }
        return null;
    }

    public static View a(String str, RelativeLayout relativeLayout, int i, int i2, Activity activity, AdType adType) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    View bannerView = new BannerView(activity);
                    bannerView.setPlacementId(str);
                    bannerView.setBannerSize(a(adType));
                    bannerView.setId(i2);
                    if (relativeLayout != null) {
                        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        if (i != -1) {
                            layoutParams.addRule(i);
                        }
                        layoutParams.addRule(14);
                        relativeLayout.addView(bannerView, layoutParams);
                    }
                    bannerView.loadAd(new BannerAdRequest());
                    return bannerView;
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("AndroApp", "failed to initialze AppNext Ad");
            }
        }
        return null;
    }

    private static BannerSize a(AdType adType) {
        return adType == AdType.MEDIUM_RECTANGLE ? BannerSize.MEDIUM_RECTANGLE : adType == AdType.LARGE_BANNER ? BannerSize.LARGE_BANNER : BannerSize.BANNER;
    }

    public static AdView a(String str, RelativeLayout relativeLayout, int i, int i2, f fVar) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        View adView = new AdView(FriopinApplication.e());
        adView.setAdSize(fVar);
        adView.setAdUnitId(str);
        adView.setId(i2);
        if (relativeLayout != null) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (i != -1) {
                layoutParams.addRule(i);
            }
            layoutParams.addRule(14);
            relativeLayout.addView(adView, layoutParams);
        }
        Bundle bundle = new Bundle();
        bundle.putString("npa", FullscreenActivity.H());
        d a = new e().b("B3EEABB8EE11C2BE770B684D95219ECB").b("45BC4D849BAEB77D6E28014DE82AECD5").a(AdMobAdapter.class, bundle).a();
        if (adView.getAdSize() == null && adView.getAdUnitId() == null) {
            return adView;
        }
        adView.a(a);
        return adView;
    }

    public static MoPubView a(String str, RelativeLayout relativeLayout, int i, int i2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        View moPubView = new MoPubView(FriopinApplication.e());
        moPubView.setAdUnitId(str);
        moPubView.setId(i2);
        if (relativeLayout != null) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (i != -1) {
                layoutParams.addRule(i);
            }
            layoutParams.addRule(14);
            relativeLayout.addView(moPubView, layoutParams);
        }
        if (moPubView.getAdUnitId() == null) {
            return moPubView;
        }
        moPubView.loadAd();
        return moPubView;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d0  */
    private static com.puzzlersworld.wp.dto.Menu a(java.lang.String r4, java.lang.String r5) {
        /*
        r1 = 0;
        com.puzzlersworld.android.util.InjectibleApplication.j();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = com.puzzlersworld.android.FullscreenActivity.r;
        r0 = r0.append(r2);
        r2 = "/";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r2 = "tag";
        r0 = com.puzzlersworld.wp.a.f.a(r4, r5, r0, r2);
        if (r0 == 0) goto L_0x00ad;
    L_0x0021:
        r2 = com.puzzlersworld.wp.dto.MenuItemType.tag;
    L_0x0023:
        if (r0 != 0) goto L_0x0044;
    L_0x0025:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = com.puzzlersworld.android.FullscreenActivity.q;
        r0 = r0.append(r3);
        r3 = "/";
        r0 = r0.append(r3);
        r0 = r0.toString();
        r3 = "author";
        r0 = com.puzzlersworld.wp.a.f.a(r4, r5, r0, r3);
        if (r0 == 0) goto L_0x0044;
    L_0x0042:
        r2 = com.puzzlersworld.wp.dto.MenuItemType.author;
    L_0x0044:
        if (r0 != 0) goto L_0x006f;
    L_0x0046:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = com.puzzlersworld.android.FullscreenActivity.A();
        r3 = r3.getUrlHandle();
        r3 = r3.getProductCategoryHandle();
        r0 = r0.append(r3);
        r3 = "/";
        r0 = r0.append(r3);
        r0 = r0.toString();
        r3 = "product_cat";
        r0 = com.puzzlersworld.wp.a.f.a(r4, r5, r0, r3);
        if (r0 == 0) goto L_0x006f;
    L_0x006d:
        r2 = com.puzzlersworld.wp.dto.MenuItemType.product_cat;
    L_0x006f:
        if (r0 != 0) goto L_0x00ec;
    L_0x0071:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = com.puzzlersworld.android.FullscreenActivity.A();
        r3 = r3.getUrlHandle();
        r3 = r3.getProductTagHandle();
        r0 = r0.append(r3);
        r3 = "/";
        r0 = r0.append(r3);
        r0 = r0.toString();
        r3 = "product_tag";
        r0 = com.puzzlersworld.wp.a.f.a(r4, r5, r0, r3);
        if (r0 == 0) goto L_0x00ec;
    L_0x0098:
        r2 = com.puzzlersworld.wp.dto.MenuItemType.product_tag;
        r3 = r2;
        r2 = r0;
    L_0x009c:
        if (r3 != 0) goto L_0x00ce;
    L_0x009e:
        r0 = com.puzzlersworld.android.FullscreenActivity.A();
        r0 = r0.getCustomTaxonomies();
        r0 = com.puzzlersworld.wp.a.f.a(r4, r5, r0);
        if (r0 == 0) goto L_0x00ce;
    L_0x00ac:
        return r0;
    L_0x00ad:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = com.puzzlersworld.android.FullscreenActivity.p;
        r0 = r0.append(r2);
        r2 = "/";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r2 = "cat";
        r0 = com.puzzlersworld.wp.a.f.a(r4, r5, r0, r2);
        if (r0 == 0) goto L_0x00ef;
    L_0x00ca:
        r2 = com.puzzlersworld.wp.dto.MenuItemType.category;
        goto L_0x0023;
    L_0x00ce:
        if (r3 == 0) goto L_0x00ea;
    L_0x00d0:
        r0 = new com.puzzlersworld.wp.dto.Menu;
        r0.<init>();
        r0.setMenuItemType(r3);
        r0.setSlug(r2);
        r1 = "";
        r0.setName(r1);
        r2 = -1;
        r1 = java.lang.Long.valueOf(r2);
        r0.setID(r1);
        goto L_0x00ac;
    L_0x00ea:
        r0 = r1;
        goto L_0x00ac;
    L_0x00ec:
        r3 = r2;
        r2 = r0;
        goto L_0x009c;
    L_0x00ef:
        r2 = r1;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.puzzlersworld.android.util.w.a(java.lang.String, java.lang.String):com.puzzlersworld.wp.dto.Menu");
    }

    public static Term a(Terms terms) {
        if (terms.getTaxonomies() != null && terms.getTaxonomies().size() > 0) {
            for (String str : terms.getTaxonomies().keySet()) {
                Term term = (Term) terms.getTaxonomies().get(str);
                if (!ab.a(term.getName())) {
                    return term;
                }
            }
        }
        return null;
    }

    private static CharSequence a(CharSequence charSequence) {
        while (charSequence.length() > 0 && charSequence.charAt(charSequence.length() - 1) == 10) {
            charSequence = charSequence.subSequence(0, charSequence.length() - 1);
        }
        return charSequence;
    }

    public static String a() {
        return "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".JPG";
    }

    public static String a(Context context) {
        String str = "";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return str;
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static String a(Post post) {
        if (post.getFeaturedImageObject() == null || post.getFeaturedImageObject().getSource() == null || post.getFeaturedImageObject().getSource().isEmpty()) {
            return "";
        }
        String str = "<div class='androappfimage'><img src='" + post.getFeaturedImageObject().getSource() + "' width='100%' height='auto' /></div>";
        return (post.getFeaturedImageObject().getExcerpt() == null || post.getFeaturedImageObject().getExcerpt().isEmpty()) ? str : str + "<div class='androappfimagedesc' style='width:95%'> <center>" + post.getFeaturedImageObject().getExcerpt() + "</center></div>";
    }

    public static String a(Terms terms, TextView textView) {
        if (terms == null) {
            return null;
        }
        if (terms.getCategories() == null || terms.getCategories().size() <= 0) {
            if (terms.getTaxonomies().size() > 0) {
                for (String str : terms.getTaxonomies().keySet()) {
                    Term term = (Term) terms.getTaxonomies().get(str);
                    if (!ab.a(term.getName())) {
                        if (textView != null) {
                            textView.setTag(term);
                        }
                        return term.getName();
                    }
                }
            }
            return null;
        }
        Category category = (Category) terms.getCategories().get(0);
        if (textView != null) {
            textView.setTag(category);
        }
        return category.getName();
    }

    private static String a(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return str;
        }
        int indexOf2 = str.indexOf(str3);
        if (indexOf2 == -1 || indexOf2 <= indexOf) {
            return str;
        }
        return str.substring(0, indexOf) + str.substring(indexOf2 + str3.length());
    }

    public static String a(Map<String, String> map, String str) {
        for (String str2 : map.keySet()) {
            if (((String) map.get(str2)).equals(str)) {
                return str2;
            }
        }
        return null;
    }

    public static Date a(Date date, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, i);
        return instance.getTime();
    }

    public static List<String> a(Map<String, String> map) {
        List<String> arrayList = new ArrayList();
        for (String str : map.keySet()) {
            arrayList.add(map.get(str));
        }
        return arrayList;
    }

    public static void a(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public static void a(Activity activity, ai aiVar) {
        try {
            Toast.makeText(activity, d(e(aiVar.c().f()).getMessage()), 1).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(SoundPool soundPool, int i) {
        if (soundPool != null) {
            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }

    public static void a(ListeningExecutorService listeningExecutorService, final String str, final Context context) {
        if (context != null && str != null) {
            listeningExecutorService.execute(new Runnable() {
                public void run() {
                    Toast.makeText(context, "Error: " + str, 1).show();
                }
            });
        }
    }

    public static void a(m mVar, Menu menu, Activity activity) {
        if (menu.getMenuItemType() == MenuItemType.product_cat || menu.getMenuItemType() == MenuItemType.category) {
            mVar.withIcon(Icon.faw_folder);
        } else if (menu.getMenuItemType() == MenuItemType.product_tag || menu.getMenuItemType() == MenuItemType.tag) {
            mVar.withIcon(Icon.faw_tag);
        } else if (menu.getMenuItemType() == MenuItemType.author) {
            mVar.withIcon(Icon.faw_user);
        } else if (menu.getMenuItemType() == MenuItemType.home) {
            mVar.withIcon(Icon.faw_home);
        } else if (menu.getMenuItemType() == MenuItemType.page || menu.getMenuItemType() == MenuItemType.post) {
            mVar.withIcon(Icon.faw_sticky_note);
        } else if (menu.getMenuItemType() == MenuItemType.custom) {
            Uri parse = Uri.parse(activity.getString(R.string.wp_server_base_path));
            try {
                String link = menu.getLink();
                Uri parse2 = Uri.parse(link);
                if (parse2.getScheme() == null) {
                    parse2 = Uri.parse(activity.getString(R.string.wp_server_base_path) + (link.startsWith("/") ? link : "/" + link));
                }
                if (com.puzzlersworld.wp.a.f.b(parse2, parse.getHost())) {
                    mVar.withIcon(Icon.faw_home);
                } else if (com.puzzlersworld.wp.a.f.a(parse2, parse.getHost())) {
                    mVar.withIcon(Icon.faw_link);
                } else {
                    mVar.withIcon(Icon.faw_external_link);
                }
            } catch (Exception e) {
                mVar.withIcon(Icon.faw_link);
            }
        } else {
            mVar.withIcon(Icon.faw_link);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A:{SYNTHETIC, RETURN} */
    private static void a(com.puzzlersworld.android.FullscreenActivity r10, java.lang.Object r11, java.lang.String r12) {
        /*
        r8 = -1;
        r6 = 0;
        r1 = 1;
        r2 = 0;
        r0 = r11 instanceof com.puzzlersworld.wp.dto.Post;
        if (r0 == 0) goto L_0x003c;
    L_0x0009:
        r0 = r11;
        r0 = (com.puzzlersworld.wp.dto.Post) r0;
        r3 = r0.getID();
        if (r3 == 0) goto L_0x0068;
    L_0x0012:
        r3 = r0.getID();
        r4 = r3.longValue();
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 == 0) goto L_0x0068;
    L_0x001e:
        r0 = r0.getLink();
        r0 = r0.equals(r12);
        if (r0 == 0) goto L_0x0068;
    L_0x0028:
        r0 = r10.getApplicationContext();
        r11 = (com.puzzlersworld.wp.dto.Post) r11;
        com.puzzlersworld.android.ui.a.d.a(r0, r11, r6, r6);
    L_0x0031:
        r0 = r1;
    L_0x0032:
        if (r0 != 0) goto L_0x003b;
    L_0x0034:
        r0 = r10.getApplicationContext();
        com.puzzlersworld.android.ui.a.d.a(r0, r12, r2);
    L_0x003b:
        return;
    L_0x003c:
        r0 = r11 instanceof com.puzzlersworld.wp.dto.Menu;
        if (r0 == 0) goto L_0x0068;
    L_0x0040:
        r0 = r11;
        r0 = (com.puzzlersworld.wp.dto.Menu) r0;
        r3 = r0.getID();
        if (r3 == 0) goto L_0x0055;
    L_0x0049:
        r3 = r0.getID();
        r4 = r3.longValue();
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 != 0) goto L_0x005d;
    L_0x0055:
        r0 = r0.getMenuItemType();
        r3 = com.puzzlersworld.wp.dto.MenuItemType.home;
        if (r0 != r3) goto L_0x0068;
    L_0x005d:
        r0 = r10 instanceof com.puzzlersworld.android.FullscreenActivity;
        if (r0 == 0) goto L_0x0068;
    L_0x0061:
        r11 = (com.puzzlersworld.wp.dto.Menu) r11;
        r0 = -1;
        r10.a(r11, r0);
        goto L_0x0031;
    L_0x0068:
        r0 = r2;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.puzzlersworld.android.util.w.a(com.puzzlersworld.android.FullscreenActivity, java.lang.Object, java.lang.String):void");
    }

    private static void a(com.puzzlersworld.wp.controller.a aVar, FullscreenActivity fullscreenActivity, Object obj, String str, Uri uri) {
        com.puzzlersworld.android.ui.a.d.a(fullscreenActivity.getApplicationContext(), str, true);
    }

    public static void a(com.puzzlersworld.wp.controller.a aVar, String str) {
        Object obj = null;
        Activity j = InjectibleApplication.j();
        FullscreenActivity fullscreenActivity = j instanceof FullscreenActivity ? (FullscreenActivity) j : null;
        if (!a(j, str)) {
            Uri parse = Uri.parse(str);
            if (parse.getScheme() == null) {
                StringBuilder append = new StringBuilder().append(j.getString(R.string.wp_server_base_path));
                if (!str.startsWith("/")) {
                    str = "/" + str;
                }
                str = append.append(str).toString();
                parse = Uri.parse(str);
            }
            Uri parse2 = Uri.parse(j.getString(R.string.wp_server_base_path));
            if (fullscreenActivity == null || !com.puzzlersworld.wp.a.f.a(parse, parse2.getHost()) || fullscreenActivity.a(str)) {
                if (com.puzzlersworld.wp.a.f.b(parse, parse2.getHost())) {
                    Log.d("FeedDetailActivity", "Opening HomeMenu");
                    obj = new Menu();
                    obj.setMenuItemType(MenuItemType.home);
                    obj.setName("Home");
                } else if (!com.puzzlersworld.wp.a.f.a(parse, parse2.getHost())) {
                    a((FullscreenActivity) j, null, str);
                    return;
                } else if (((FullscreenActivity) j).D()) {
                    a((FullscreenActivity) j, null, str);
                    return;
                } else {
                    Menu a = a(str, j.getString(R.string.wp_server_base_path));
                    if (a == null) {
                        com.puzzlersworld.wp.dto.Config A = FullscreenActivity.A();
                        if (!(A == null || f(A.getBlogurl()))) {
                            a = a(str, A.getBlogurl());
                        }
                    }
                    if (a != null) {
                        if (j instanceof FullscreenActivity) {
                            ((FullscreenActivity) j).a(a, -1);
                            return;
                        }
                        return;
                    }
                }
                if (obj == null) {
                    a(aVar, (FullscreenActivity) j, obj, str, parse);
                    return;
                } else {
                    a((FullscreenActivity) j, obj, str);
                    return;
                }
            }
            j.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    public static void a(String str, Context context) {
        if (context != null && str != null) {
            try {
                Toast.makeText(context, "Error: " + str, 1).show();
            } catch (Exception e) {
            }
        }
    }

    public static void a(ExecutorService executorService, final String str, final Context context) {
        if (context != null && str != null) {
            if (executorService != null) {
                executorService.execute(new Runnable() {
                    public void run() {
                        Toast.makeText(context, str, 1).show();
                    }
                });
            } else {
                Toast.makeText(context, str, 1).show();
            }
        }
    }

    public static boolean a(int i) {
        return VERSION.RELEASE.startsWith(BuildConfig.VERSION_NAME) ? i == 1 : VERSION.RELEASE.startsWith("1.1") ? i <= 2 : VERSION.RELEASE.startsWith("1.5") ? i <= 3 : VERSION.SDK_INT >= i;
    }

    public static boolean a(Activity activity, String str) {
        if (str.startsWith("tel:")) {
            activity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
            return true;
        } else if (str.startsWith("mailto:")) {
            MailTo parse = MailTo.parse(str);
            activity.startActivity(a((Context) activity, parse.getTo(), parse.getSubject(), parse.getBody(), parse.getCc()));
            return true;
        } else if (!c(str)) {
            return false;
        } else {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
    }

    public static boolean a(RestServiceManager restServiceManager) {
        return !"wp-json/".equals(restServiceManager.getNamespace());
    }

    public static boolean a(com.puzzlersworld.wp.dto.Config config) {
        return config == null || config.getDisableImageClick() == null || !config.getDisableImageClick().equalsIgnoreCase("yes");
    }

    public static boolean a(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static Spanned b(String str) {
        return str == null ? null : Html.fromHtml(str);
    }

    public static String b() {
        com.puzzlersworld.wp.dto.Config A = FullscreenActivity.A();
        return (A == null || f(A.getFontName())) ? "" : "<style> @font-face {font-family: 'MyFont';src: url('file:///android_asset/fonts/" + A.getFontName() + ".ttf');}body { font-family:'MyFont'}</style>";
    }

    public static String b(RestServiceManager restServiceManager) {
        String str = "wp-json/";
        WpJson wpJson = (WpJson) restServiceManager.getWpJsonService().getWpJson().execute().b();
        if (wpJson.getNamespaces() == null) {
            return "wp-json/";
        }
        for (String str2 : wpJson.getNamespaces()) {
            str = str2.startsWith("wp/v") ? "wp-json/" + str2 + "/" : str;
        }
        return str;
    }

    public static String b(com.puzzlersworld.wp.dto.Config config) {
        return a(config) ? "<script type=\"text/javascript\">var images = document.getElementsByTagName(\"img\");for (var i=0, len=images.length, img; i<len; i++) {  img = images[i];  img.addEventListener(\"click\", function(e) {var p = this.parentNode; while(p){ if(p.nodeName == 'A'){ break; } p = p.parentNode; } if(p != null && p.nodeName == 'A'){if(checkIfEqual(this.src, p.href, this.getAttribute('width'), this.getAttribute('height'))){ e.preventDefault(); window.androImageClick.clickImage(this.src);}}else{ window.androImageClick.clickImage(this.src); } });}function checkIfEqual(imgsrc, link, width, height){if(imgsrc == link){ return true;}imgsrc = imgsrc.replace('-'+width+'x'+height, '');if(imgsrc == link){ return true;}return false;}</script>" : "";
    }

    public static String b(Post post) {
        return "<div id=\"fb-root\"></div> <script>(function(d, s, id) { var js, fjs = d.getElementsByTagName(s)[0]; if (d.getElementById(id)) return; js = d.createElement(s); js.id = id; js.src = \"//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.6\"; fjs.parentNode.insertBefore(js, fjs); }(document, 'script', 'facebook-jssdk'));</script> <div class=\"fb-comments\" data-href=\"" + post.getLink() + "\" data-numposts=\"" + 5 + "\" data-order-by=\"reverse_time\"></div>";
    }

    public static void b(String str, Context context) {
        if (context != null && str != null) {
            try {
                Toast.makeText(context, str, 1).show();
            } catch (Exception e) {
            }
        }
    }

    public static void b(ExecutorService executorService, final String str, final Context context) {
        if (context != null && str != null) {
            executorService.execute(new Runnable() {
                public void run() {
                    Toast.makeText(context, "Error: " + str, 1).show();
                }
            });
        }
    }

    public static String c(Post post) {
        if (!d()) {
            X E = FullscreenActivity.E();
            if (!(E == null || E.getHeaderScript() == null)) {
                return E.getHeaderScript();
            }
        } else if (post.getHeader() != null) {
            return post.getHeader();
        }
        return "";
    }

    public static void c() {
    }

    public static boolean c(String str) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            int lastIndexOf = trim.toLowerCase().lastIndexOf(".pdf");
            if (lastIndexOf != -1) {
                return trim.substring(lastIndexOf).equalsIgnoreCase(".pdf");
            }
        }
        return false;
    }

    public static CharSequence d(String str) {
        return str != null ? a(Html.fromHtml(str)) : str;
    }

    public static boolean d() {
        X E = FullscreenActivity.E();
        return E != null && E.getV().booleanValue();
    }

    public static ErrorResponse e(String str) {
        JsonArray asJsonArray = new JsonParser().parse(str).getAsJsonArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= asJsonArray.size()) {
                return null;
            }
            try {
                return (ErrorResponse) new Gson().fromJson(asJsonArray.get(i2), ErrorResponse.class);
            } catch (Exception e) {
                e.printStackTrace();
                i = i2 + 1;
            }
        }
    }

    public static String e() {
        if (!d()) {
            X E = FullscreenActivity.E();
            if (!(E == null || E.getTopMostAd() == null)) {
                return E.getTopMostAd();
            }
        }
        return "";
    }

    public static String f() {
        if (!d()) {
            X E = FullscreenActivity.E();
            if (!(E == null || E.getAfterContentAd() == null)) {
                return E.getAfterContentAd();
            }
        }
        return "";
    }

    public static boolean f(String str) {
        return ab.a(str);
    }

    public static String g() {
        if (!d()) {
            X E = FullscreenActivity.E();
            if (!(E == null || E.getBeforeContentAd() == null)) {
                return E.getBeforeContentAd();
            }
        }
        return "";
    }

    public static String g(String str) {
        if (d()) {
            return str;
        }
        X E = FullscreenActivity.E();
        if (E == null || E.getStripTags() == null) {
            return str;
        }
        String[] split = E.getStripTags().split("#SEP#");
        int i = 0;
        int length = split.length;
        String str2 = str;
        while (i < length) {
            String str3 = split[i];
            int i2 = i + 1;
            if (i2 >= length) {
                return str2;
            }
            String str4 = split[i2];
            String a = a(str2, str3, str4);
            while (a.length() != str2.length()) {
                str2 = a;
                a = a(a, str3, str4);
            }
            str2 = a;
            i = i2;
        }
        return str2;
    }

    public static String h(String str) {
        if (str == null) {
            return str;
        }
        try {
            return (new URL(str).getHost() != null || str.startsWith(Constants.HTTP)) ? str : FriopinApplication.e().getString(R.string.wp_server_base_path) + "/" + str;
        } catch (Exception e) {
            if (str.startsWith(Constants.HTTP)) {
                return str;
            }
            if (!str.startsWith("//")) {
                return FriopinApplication.e().getString(R.string.wp_server_base_path) + "/" + str;
            }
            try {
                return new URL(FriopinApplication.e().getString(R.string.wp_server_base_path)).getProtocol() + ":" + str;
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                return str;
            }
        }
    }

    public static boolean i(String str) {
        try {
            if (ab.a(str)) {
                return false;
            }
            Color.parseColor(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
