package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import com.mopub.mobileads.VastIconXmlManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public class anz implements zzoz {
    @VisibleForTesting
    boolean a;
    @VisibleForTesting
    boolean b;
    private final Object c = new Object();
    private final zzpa d;
    private final Context e;
    private final ank f;
    @Nullable
    private final JSONObject g;
    @Nullable
    private final zzacm h;
    @Nullable
    private final zzpb i;
    private final ada j;
    @Nullable
    private final zzang k;
    @Nullable
    private String l;
    @Nullable
    private gi m;
    private WeakReference<View> n = null;

    public anz(Context context, zzpa zzpa, @Nullable zzacm zzacm, ada ada, @Nullable JSONObject jSONObject, @Nullable zzpb zzpb, @Nullable zzang zzang, @Nullable String str) {
        this.e = context;
        this.d = zzpa;
        this.h = zzacm;
        this.j = ada;
        this.g = jSONObject;
        this.i = zzpb;
        this.k = zzang;
        this.l = str;
        this.f = new ank(this.h);
    }

    @VisibleForTesting
    private final int a(int i) {
        akc.a();
        return kb.b(this.e, i);
    }

    private final JSONObject a(Rect rect) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(VastIconXmlManager.WIDTH, a(rect.right - rect.left));
        jSONObject.put(VastIconXmlManager.HEIGHT, a(rect.bottom - rect.top));
        jSONObject.put("x", a(rect.left));
        jSONObject.put("y", a(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private final JSONObject a(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || view == null) {
            return jSONObject;
        }
        int[] c = c(view);
        synchronized (map) {
            for (Entry entry : map.entrySet()) {
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] c2 = c(view2);
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        Object a;
                        jSONObject3.put(VastIconXmlManager.WIDTH, a(view2.getMeasuredWidth()));
                        jSONObject3.put(VastIconXmlManager.HEIGHT, a(view2.getMeasuredHeight()));
                        jSONObject3.put("x", a(c2[0] - c[0]));
                        jSONObject3.put("y", a(c2[1] - c[1]));
                        jSONObject3.put("relative_to", "ad_view");
                        jSONObject2.put("frame", jSONObject3);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            a = a(rect);
                        } else {
                            a = new JSONObject();
                            a.put(VastIconXmlManager.WIDTH, 0);
                            a.put(VastIconXmlManager.HEIGHT, 0);
                            a.put("x", a(c2[0] - c[0]));
                            a.put("y", a(c2[1] - c[1]));
                            a.put("relative_to", "ad_view");
                        }
                        jSONObject2.put("visible_bounds", a);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject2.put("text_color", textView.getCurrentTextColor());
                            jSONObject2.put("font_size", (double) textView.getTextSize());
                            jSONObject2.put("text", textView.getText());
                        }
                        jSONObject.put((String) entry.getKey(), jSONObject2);
                    } catch (JSONException e) {
                        kk.e("Unable to get asset views information");
                    }
                }
            }
        }
        return jSONObject;
    }

    private final void a(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6) {
        ar.b("Invalid call from a non-UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.g);
            if (jSONObject2 != null) {
                jSONObject7.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject7.put("ad_view_signal", jSONObject);
            }
            if (jSONObject5 != null) {
                jSONObject7.put("click_signal", jSONObject5);
            }
            if (jSONObject3 != null) {
                jSONObject7.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject7.put("lock_screen_signal", jSONObject4);
            }
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.i.zzkb());
            au.g();
            jSONObject8.put("is_privileged_process", hz.e());
            if (((Boolean) akc.f().a(amn.ck)).booleanValue() && this.f.a() != null && this.g.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", au.l().currentTimeMillis());
            jSONObject8.put("has_custom_click_handler", this.d.zzr(this.i.getCustomTemplateId()) != null);
            jSONObject7.put("has_custom_click_handler", this.d.zzr(this.i.getCustomTemplateId()) != null);
            try {
                JSONObject optJSONObject = this.g.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                jSONObject8.put("click_signals", this.j.a().zza(this.e, optJSONObject.optString("click_string"), view));
            } catch (Throwable e) {
                kk.b("Exception obtaining click signals", e);
            }
            jSONObject7.put("click", jSONObject8);
            if (jSONObject6 != null) {
                jSONObject7.put("provided_signals", jSONObject6);
            }
            jSONObject7.put("ads_id", this.l);
            ko.a(this.h.zzi(jSONObject7), "NativeAdEngineImpl.performClick");
        } catch (Throwable e2) {
            kk.b("Unable to create click JSON.", e2);
        }
    }

    private final boolean a(String str) {
        JSONObject optJSONObject = this.g == null ? null : this.g.optJSONObject("allow_pub_event_reporting");
        return optJSONObject == null ? false : optJSONObject.optBoolean(str, false);
    }

    private final boolean a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        ar.b("Invalid call from a non-UI thread.");
        if (this.a) {
            return true;
        }
        this.a = true;
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.g);
            jSONObject6.put("ads_id", this.l);
            if (jSONObject2 != null) {
                jSONObject6.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject6.put("ad_view_signal", jSONObject);
            }
            if (jSONObject3 != null) {
                jSONObject6.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject6.put("lock_screen_signal", jSONObject4);
            }
            if (jSONObject5 != null) {
                jSONObject6.put("provided_signals", jSONObject5);
            }
            ko.a(this.h.zzj(jSONObject6), "NativeAdEngineImpl.recordImpression");
            this.d.zza((zzoz) this);
            this.d.zzbv();
            zzcr();
            return true;
        } catch (Throwable e) {
            kk.b("Unable to create impression JSON.", e);
            return false;
        }
    }

    private static boolean b(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    @VisibleForTesting
    private static int[] c(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    private final JSONObject d(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                Object a;
                int[] c = c(view);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(VastIconXmlManager.WIDTH, a(view.getMeasuredWidth()));
                jSONObject2.put(VastIconXmlManager.HEIGHT, a(view.getMeasuredHeight()));
                jSONObject2.put("x", a(c[0]));
                jSONObject2.put("y", a(c[1]));
                jSONObject2.put("relative_to", "window");
                jSONObject.put("frame", jSONObject2);
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    a = a(rect);
                } else {
                    a = new JSONObject();
                    a.put(VastIconXmlManager.WIDTH, 0);
                    a.put(VastIconXmlManager.HEIGHT, 0);
                    a.put("x", a(c[0]));
                    a.put("y", a(c[1]));
                    a.put("relative_to", "window");
                }
                jSONObject.put("visible_bounds", a);
            } catch (Exception e) {
                kk.e("Unable to get native ad view bounding box");
            }
        }
        return jSONObject;
    }

    private static JSONObject e(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                au.e();
                jSONObject.put("contained_in_scroll_view", ht.d(view) != -1);
            } catch (Exception e) {
            }
        }
        return jSONObject;
    }

    private final JSONObject f(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                au.e();
                jSONObject.put("can_show_on_lock_screen", ht.c(view));
                au.e();
                jSONObject.put("is_keyguard_locked", ht.j(this.e));
            } catch (JSONException e) {
                kk.e("Unable to get lock screen information");
            }
        }
        return jSONObject;
    }

    public final void a(View view) {
        this.d.zzi(view);
    }

    public void a(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        if (((Boolean) akc.f().a(amn.cb)).booleanValue()) {
            View view2;
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            if (map != null) {
                synchronized (map) {
                    for (Entry value : map.entrySet()) {
                        view2 = (View) ((WeakReference) value.getValue()).get();
                        if (view2 != null) {
                            view2.setOnTouchListener(onTouchListener);
                            view2.setClickable(true);
                            view2.setOnClickListener(onClickListener);
                        }
                    }
                }
            }
            if (map2 != null) {
                synchronized (map2) {
                    for (Entry value2 : map2.entrySet()) {
                        view2 = (View) ((WeakReference) value2.getValue()).get();
                        if (view2 != null) {
                            view2.setOnTouchListener(onTouchListener);
                        }
                    }
                }
            }
        }
    }

    public final void a(Map<String, WeakReference<View>> map) {
        if (this.i.zzkd() == null) {
            return;
        }
        if ("2".equals(this.i.zzkb())) {
            au.i().l().a(this.d.getAdUnitId(), this.i.zzkb(), map.containsKey("2011"));
        } else if ("1".equals(this.i.zzkb())) {
            au.i().l().a(this.d.getAdUnitId(), this.i.zzkb(), map.containsKey("1009"));
        }
    }

    public final boolean a(View view, zzox zzox) {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        View zzkd = this.i.zzkd();
        if (zzkd == null) {
            return false;
        }
        ViewParent parent = zzkd.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(zzkd);
        }
        ((FrameLayout) view).removeAllViews();
        ((FrameLayout) view).addView(zzkd, layoutParams);
        this.d.zza(zzox);
        return true;
    }

    public zzaqw c() {
        zzaqw zzaqw = null;
        if (!(this.g == null || this.g.optJSONObject("overlay") == null)) {
            au.f();
            Context context = this.e;
            zzjn a = zzjn.a(this.e);
            boolean z = false;
            zzaqw = nw.a(context, op.a(a), a.a, false, z, this.j, this.k, null, null, null, ahx.a());
            if (zzaqw != null) {
                zzaqw.getView().setVisibility(8);
                new aob(zzaqw).a(this.h);
            }
        }
        return zzaqw;
    }

    public void cancelUnconfirmedClick() {
        if (!((Boolean) akc.f().a(amn.ck)).booleanValue()) {
            return;
        }
        if (this.g.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.f.b();
        } else {
            kk.e("Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        }
    }

    @Nullable
    public final gi d() {
        if (!au.B().c(this.e)) {
            return null;
        }
        if (this.m == null) {
            this.m = new gi(this.e, this.d.getAdUnitId());
        }
        return this.m;
    }

    public final Context getContext() {
        return this.e;
    }

    public final void performClick(Bundle bundle) {
        if (bundle == null) {
            kk.b("Click data is null. No click is reported.");
        } else if (a("click_reporting")) {
            a(null, null, null, null, null, bundle.getBundle("click_signal").getString("asset_id"), null, au.e().a(bundle, null));
        } else {
            kk.c("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        if (a("impression_reporting")) {
            return a(null, null, null, null, au.e().a(bundle, null));
        }
        kk.c("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
        return false;
    }

    public final void reportTouchEvent(Bundle bundle) {
        if (bundle == null) {
            kk.b("Touch event data is null. No touch event is reported.");
        } else if (a("touch_reporting")) {
            this.j.a().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
        } else {
            kk.c("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        }
    }

    public void setClickConfirmingView(View view) {
        if (!((Boolean) akc.f().a(amn.ck)).booleanValue()) {
            return;
        }
        if (this.g.optBoolean("custom_one_point_five_click_enabled", false)) {
            Object obj = this.f;
            if (view != null) {
                view.setOnClickListener(obj);
                view.setClickable(true);
                obj.c = new WeakReference(view);
                return;
            }
            return;
        }
        kk.e("Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
    }

    @Nullable
    public View zza(OnClickListener onClickListener, boolean z) {
        anj zzkc = this.i.zzkc();
        if (zzkc == null) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!z) {
            switch (zzkc.f()) {
                case 0:
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    break;
                case 2:
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    break;
                case 3:
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    break;
                default:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    break;
            }
        }
        View anm = new anm(this.e, zzkc, layoutParams);
        anm.setOnClickListener(onClickListener);
        anm.setContentDescription((CharSequence) akc.f().a(amn.ce));
        return anm;
    }

    public final void zza(View view, zzox zzox) {
        if (!a(view, zzox)) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            ((FrameLayout) view).removeAllViews();
            if (this.i instanceof zzpc) {
                zzpc zzpc = (zzpc) this.i;
                if (zzpc.getImages() != null && zzpc.getImages().size() > 0) {
                    Object obj = zzpc.getImages().get(0);
                    zzpw a = obj instanceof IBinder ? aoq.a((IBinder) obj) : null;
                    if (a != null) {
                        try {
                            IObjectWrapper zzjy = a.zzjy();
                            if (zzjy != null) {
                                Drawable drawable = (Drawable) c.a(zzjy);
                                View imageView = new ImageView(this.e);
                                imageView.setImageDrawable(drawable);
                                imageView.setScaleType(ScaleType.CENTER_INSIDE);
                                ((FrameLayout) view).addView(imageView, layoutParams);
                            }
                        } catch (RemoteException e) {
                            kk.e("Could not get drawable from image");
                        }
                    }
                }
            }
        }
    }

    public final void zza(View view, String str, @Nullable Bundle bundle, Map<String, WeakReference<View>> map, View view2) {
        JSONObject jSONObject;
        Throwable e;
        JSONObject a = a((Map) map, view2);
        JSONObject d = d(view2);
        JSONObject e2 = e(view2);
        JSONObject f = f(view2);
        try {
            JSONObject a2 = au.e().a(bundle, null);
            jSONObject = new JSONObject();
            try {
                jSONObject.put("click_point", a2);
                jSONObject.put("asset_id", str);
            } catch (Exception e3) {
                e = e3;
                kk.b("Error occurred while grabbing click signals.", e);
                a(view, d, a, e2, f, str, jSONObject, null);
            }
        } catch (Exception e4) {
            e = e4;
            jSONObject = null;
            kk.b("Error occurred while grabbing click signals.", e);
            a(view, d, a, e2, f, str, jSONObject, null);
        }
        a(view, d, a, e2, f, str, jSONObject, null);
    }

    public void zza(View view, Map<String, WeakReference<View>> map) {
        a(d(view), a((Map) map, view), e(view), f(view), null);
    }

    public void zza(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        ar.b("Invalid call from a non-UI thread.");
        if (map != null) {
            synchronized (map) {
                for (Entry entry : map.entrySet()) {
                    if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                        zza(view, (String) entry.getKey(), bundle, map, view2);
                        return;
                    }
                }
            }
        }
        if ("6".equals(this.i.zzkb())) {
            zza(view, "3099", bundle, map, view2);
        } else if ("2".equals(this.i.zzkb())) {
            zza(view, "2099", bundle, map, view2);
        } else if ("1".equals(this.i.zzkb())) {
            zza(view, "1099", bundle, map, view2);
        }
    }

    public void zza(zzro zzro) {
        if (!((Boolean) akc.f().a(amn.ck)).booleanValue()) {
            return;
        }
        if (this.g.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.f.a(zzro);
        } else {
            kk.e("Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        }
    }

    public void zzb(View view, Map<String, WeakReference<View>> map) {
        if (!((Boolean) akc.f().a(amn.ca)).booleanValue()) {
            view.setOnTouchListener(null);
            view.setClickable(false);
            view.setOnClickListener(null);
            if (map != null) {
                synchronized (map) {
                    for (Entry value : map.entrySet()) {
                        View view2 = (View) ((WeakReference) value.getValue()).get();
                        if (view2 != null) {
                            view2.setOnTouchListener(null);
                            view2.setClickable(false);
                            view2.setOnClickListener(null);
                        }
                    }
                }
            }
        }
    }

    public final void zzc(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.c) {
            if (this.a) {
            } else if (b(view)) {
                zza(view, (Map) map);
            } else {
                if (((Boolean) akc.f().a(amn.cj)).booleanValue() && map != null) {
                    synchronized (map) {
                        for (Entry value : map.entrySet()) {
                            View view2 = (View) ((WeakReference) value.getValue()).get();
                            if (view2 != null && b(view2)) {
                                zza(view, (Map) map);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public void zzcr() {
        this.d.zzcr();
    }

    public void zzcs() {
        this.d.zzcs();
    }

    public final void zzd(MotionEvent motionEvent) {
        this.j.a(motionEvent);
    }

    public final void zzj(View view) {
        if (((Boolean) akc.f().a(amn.bG)).booleanValue() && this.j != null) {
            zzce a = this.j.a();
            if (a != null) {
                a.zzb(view);
            }
        }
    }

    public boolean zzkj() {
        anj zzkc = this.i.zzkc();
        return zzkc != null && zzkc.g();
    }

    public boolean zzkk() {
        return this.g != null && this.g.optBoolean("allow_pub_owned_ad_view", false);
    }

    public void zzkl() {
        ar.b("Invalid call from a non-UI thread.");
        if (!this.b) {
            this.b = true;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad", this.g);
                jSONObject.put("ads_id", this.l);
                ko.a(this.h.zzk(jSONObject), "NativeAdEngineImpl.recordDownloadedImpression");
            } catch (Throwable e) {
                kk.b("", e);
            }
        }
    }

    public void zzkp() {
        this.h.zzmc();
    }

    public void zzkq() {
        this.d.zzct();
    }

    public final View zzkr() {
        return this.n != null ? (View) this.n.get() : null;
    }

    public final void zzl(View view) {
        this.n = new WeakReference(view);
    }
}
