package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.graphics.drawable.l;
import android.support.v4.util.a;
import android.support.v4.util.t;
import android.support.v7.a.b;
import android.support.v7.a.d;
import android.support.v7.a.f;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({Scope.LIBRARY_GROUP})
public final class AppCompatDrawableManager {
    private static final Mode a = Mode.SRC_IN;
    private static AppCompatDrawableManager b;
    private static final v c = new v(6);
    private static final int[] d = new int[]{f.abc_textfield_search_default_mtrl_alpha, f.abc_textfield_default_mtrl_alpha, f.abc_ab_share_pack_mtrl_alpha};
    private static final int[] e = new int[]{f.abc_ic_commit_search_api_mtrl_alpha, f.abc_seekbar_tick_mark_material, f.abc_ic_menu_share_mtrl_alpha, f.abc_ic_menu_copy_mtrl_am_alpha, f.abc_ic_menu_cut_mtrl_alpha, f.abc_ic_menu_selectall_mtrl_alpha, f.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f = new int[]{f.abc_textfield_activated_mtrl_alpha, f.abc_textfield_search_activated_mtrl_alpha, f.abc_cab_background_top_mtrl_alpha, f.abc_text_cursor_material, f.abc_text_select_handle_left_mtrl_dark, f.abc_text_select_handle_middle_mtrl_dark, f.abc_text_select_handle_right_mtrl_dark, f.abc_text_select_handle_left_mtrl_light, f.abc_text_select_handle_middle_mtrl_light, f.abc_text_select_handle_right_mtrl_light};
    private static final int[] g = new int[]{f.abc_popup_background_mtrl_mult, f.abc_cab_background_internal_bg, f.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = new int[]{f.abc_tab_indicator_material, f.abc_textfield_search_material};
    private static final int[] i = new int[]{f.abc_btn_check_material, f.abc_btn_radio_material};
    private WeakHashMap<Context, t<ColorStateList>> j;
    private a<String, InflateDelegate> k;
    private t<String> l;
    private final Object m = new Object();
    private final WeakHashMap<Context, android.support.v4.util.f<WeakReference<ConstantState>>> n = new WeakHashMap(0);
    private TypedValue o;
    private boolean p;

    interface InflateDelegate {
        Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Theme theme);
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    static Mode a(int i) {
        return i == f.abc_switch_thumb_material ? Mode.MULTIPLY : null;
    }

    public static PorterDuffColorFilter a(int i, Mode mode) {
        PorterDuffColorFilter a = c.a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        c.a(i, mode, a);
        return a;
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        return (colorStateList == null || mode == null) ? null : a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable a(@NonNull Context context, @DrawableRes int i, boolean z, @NonNull Drawable drawable) {
        ColorStateList b = b(context, i);
        LayerDrawable layerDrawable;
        if (b != null) {
            if (an.c(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = android.support.v4.graphics.drawable.a.g(drawable);
            android.support.v4.graphics.drawable.a.a(drawable, b);
            Mode a = a(i);
            if (a == null) {
                return drawable;
            }
            android.support.v4.graphics.drawable.a.a(drawable, a);
            return drawable;
        } else if (i == f.abc_seekbar_track_material) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), cx.a(context, b.colorControlNormal), a);
            a(layerDrawable.findDrawableByLayerId(16908303), cx.a(context, b.colorControlNormal), a);
            a(layerDrawable.findDrawableByLayerId(16908301), cx.a(context, b.colorControlActivated), a);
            return drawable;
        } else if (i != f.abc_ratingbar_material && i != f.abc_ratingbar_indicator_material && i != f.abc_ratingbar_small_material) {
            return (a(context, i, drawable) || !z) ? drawable : null;
        } else {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), cx.c(context, b.colorControlNormal), a);
            a(layerDrawable.findDrawableByLayerId(16908303), cx.a(context, b.colorControlActivated), a);
            a(layerDrawable.findDrawableByLayerId(16908301), cx.a(context, b.colorControlActivated), a);
            return drawable;
        }
    }

    /* JADX WARNING: Missing block: B:21:?, code:
            return null;
     */
    private android.graphics.drawable.Drawable a(@android.support.annotation.NonNull android.content.Context r5, long r6) {
        /*
        r4 = this;
        r2 = 0;
        r3 = r4.m;
        monitor-enter(r3);
        r0 = r4.n;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002b }
        r0 = (android.support.v4.util.f) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.a(r6);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0031;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r5.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0.b(r6);	 Catch:{ all -> 0x002b }
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatDrawableManager.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static AppCompatDrawableManager a() {
        if (b == null) {
            b = new AppCompatDrawableManager();
            a(b);
        }
        return b;
    }

    private void a(@NonNull Context context, @DrawableRes int i, @NonNull ColorStateList colorStateList) {
        if (this.j == null) {
            this.j = new WeakHashMap();
        }
        t tVar = (t) this.j.get(context);
        if (tVar == null) {
            tVar = new t();
            this.j.put(context, tVar);
        }
        tVar.c(i, colorStateList);
    }

    private static void a(Drawable drawable, int i, Mode mode) {
        if (an.c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = a;
        }
        drawable.setColorFilter(a(i, mode));
    }

    static void a(Drawable drawable, cz czVar, int[] iArr) {
        if (!an.c(drawable) || drawable.mutate() == drawable) {
            if (czVar.d || czVar.c) {
                drawable.setColorFilter(a(czVar.d ? czVar.a : null, czVar.c ? czVar.b : a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
    }

    private static void a(@NonNull AppCompatDrawableManager appCompatDrawableManager) {
        if (VERSION.SDK_INT < 24) {
            appCompatDrawableManager.a("vector", new w());
            appCompatDrawableManager.a("animated-vector", new u());
        }
    }

    private void a(@NonNull String str, @NonNull InflateDelegate inflateDelegate) {
        if (this.k == null) {
            this.k = new a();
        }
        this.k.put(str, inflateDelegate);
    }

    static boolean a(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = a;
        if (a(d, i)) {
            i2 = b.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (a(f, i)) {
            i2 = b.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (a(g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == f.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else if (i == f.abc_dialog_material_background) {
            i2 = 16842801;
            mode = mode2;
            z = true;
            i3 = -1;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (an.c(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(a(cx.a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private boolean a(@NonNull Context context, long j, @NonNull Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.m) {
            android.support.v4.util.f fVar = (android.support.v4.util.f) this.n.get(context);
            if (fVar == null) {
                fVar = new android.support.v4.util.f();
                this.n.put(context, fVar);
            }
            fVar.b(j, new WeakReference(constantState));
        }
        return true;
    }

    private static boolean a(@NonNull Drawable drawable) {
        return (drawable instanceof l) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList b(@NonNull Context context) {
        return f(context, cx.a(context, b.colorButtonNormal));
    }

    private ColorStateList c(@NonNull Context context) {
        return f(context, 0);
    }

    private Drawable c(@NonNull Context context, @DrawableRes int i) {
        if (this.o == null) {
            this.o = new TypedValue();
        }
        TypedValue typedValue = this.o;
        context.getResources().getValue(i, typedValue, true);
        long a = a(typedValue);
        Drawable a2 = a(context, a);
        if (a2 == null) {
            if (i == f.abc_cab_background_top_material) {
                a2 = new LayerDrawable(new Drawable[]{a(context, f.abc_cab_background_internal_bg), a(context, f.abc_cab_background_top_mtrl_alpha)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                a(context, a, a2);
            }
        }
        return a2;
    }

    private ColorStateList d(@NonNull Context context) {
        return f(context, cx.a(context, b.colorAccent));
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d  */
    private android.graphics.drawable.Drawable d(@android.support.annotation.NonNull android.content.Context r10, @android.support.annotation.DrawableRes int r11) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 2;
        r7 = 1;
        r0 = r9.k;
        if (r0 == 0) goto L_0x00bf;
    L_0x0007:
        r0 = r9.k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00bf;
    L_0x000f:
        r0 = r9.l;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r9.l;
        r0 = r0.a(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r9.k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new android.support.v4.util.t;
        r0.<init>();
        r9.l = r0;
    L_0x0036:
        r0 = r9.o;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.o = r0;
    L_0x0041:
        r2 = r9.o;
        r0 = r10.getResources();
        r0.getValue(r11, r2, r7);
        r4 = a(r2);
        r1 = r9.a(r10, r4);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = r1;
        goto L_0x002e;
    L_0x0056:
        r3 = r2.string;
        if (r3 == 0) goto L_0x008a;
    L_0x005a:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x008a;
    L_0x0068:
        r3 = r0.getXml(r11);	 Catch:{ Exception -> 0x0082 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0082 }
    L_0x0070:
        r0 = r3.next();	 Catch:{ Exception -> 0x0082 }
        if (r0 == r8) goto L_0x0078;
    L_0x0076:
        if (r0 != r7) goto L_0x0070;
    L_0x0078:
        if (r0 == r8) goto L_0x0095;
    L_0x007a:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0082 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0082 }
        throw r0;	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        r0 = move-exception;
        r2 = "AppCompatDrawableManag";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x008a:
        r0 = r1;
    L_0x008b:
        if (r0 != 0) goto L_0x002e;
    L_0x008d:
        r1 = r9.l;
        r2 = "appcompat_skip_skip";
        r1.c(r11, r2);
        goto L_0x002e;
    L_0x0095:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0082 }
        r7 = r9.l;	 Catch:{ Exception -> 0x0082 }
        r7.c(r11, r0);	 Catch:{ Exception -> 0x0082 }
        r7 = r9.k;	 Catch:{ Exception -> 0x0082 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = (android.support.v7.widget.AppCompatDrawableManager.InflateDelegate) r0;	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00a8:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x0082 }
        r1 = r0.createFromXmlInner(r10, r3, r6, r7);	 Catch:{ Exception -> 0x0082 }
    L_0x00b0:
        if (r1 == 0) goto L_0x00bd;
    L_0x00b2:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0082 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = r9.a(r10, r4, r1);	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00bd:
        r0 = r1;
        goto L_0x008b;
    L_0x00bf:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatDrawableManager.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private ColorStateList e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = cx.b(context, b.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = cx.a;
            iArr2[0] = cx.c(context, b.colorSwitchThumbNormal);
            iArr[1] = cx.e;
            iArr2[1] = cx.a(context, b.colorControlActivated);
            iArr[2] = cx.h;
            iArr2[2] = cx.a(context, b.colorSwitchThumbNormal);
        } else {
            iArr[0] = cx.a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = cx.e;
            iArr2[1] = cx.a(context, b.colorControlActivated);
            iArr[2] = cx.h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList e(@NonNull Context context, @DrawableRes int i) {
        if (this.j == null) {
            return null;
        }
        t tVar = (t) this.j.get(context);
        return tVar != null ? (ColorStateList) tVar.a(i) : null;
    }

    private ColorStateList f(@NonNull Context context, @ColorInt int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = cx.a(context, b.colorControlHighlight);
        int c = cx.c(context, b.colorButtonNormal);
        r0[0] = cx.a;
        r1[0] = c;
        r0[1] = cx.d;
        r1[1] = android.support.v4.graphics.a.a(a, i);
        r0[2] = cx.b;
        r1[2] = android.support.v4.graphics.a.a(a, i);
        r0[3] = cx.h;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    private void f(@NonNull Context context) {
        if (!this.p) {
            this.p = true;
            Drawable a = a(context, f.abc_vector_test);
            if (a == null || !a(a)) {
                this.p = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    public Drawable a(@NonNull Context context, @DrawableRes int i) {
        return a(context, i, false);
    }

    Drawable a(@NonNull Context context, @DrawableRes int i, boolean z) {
        f(context);
        Drawable d = d(context, i);
        if (d == null) {
            d = c(context, i);
        }
        if (d == null) {
            d = android.support.v4.content.a.a(context, i);
        }
        if (d != null) {
            d = a(context, i, z, d);
        }
        if (d != null) {
            an.b(d);
        }
        return d;
    }

    Drawable a(@NonNull Context context, @NonNull dh dhVar, @DrawableRes int i) {
        Drawable d = d(context, i);
        if (d == null) {
            d = dhVar.a(i);
        }
        return d != null ? a(context, i, false, d) : null;
    }

    public void a(@NonNull Context context) {
        synchronized (this.m) {
            android.support.v4.util.f fVar = (android.support.v4.util.f) this.n.get(context);
            if (fVar != null) {
                fVar.c();
            }
        }
    }

    ColorStateList b(@NonNull Context context, @DrawableRes int i) {
        ColorStateList e = e(context, i);
        if (e == null) {
            if (i == f.abc_edit_text_material) {
                e = android.support.v7.c.a.b.a(context, d.abc_tint_edittext);
            } else if (i == f.abc_switch_track_mtrl_alpha) {
                e = android.support.v7.c.a.b.a(context, d.abc_tint_switch_track);
            } else if (i == f.abc_switch_thumb_material) {
                e = e(context);
            } else if (i == f.abc_btn_default_mtrl_shape) {
                e = b(context);
            } else if (i == f.abc_btn_borderless_material) {
                e = c(context);
            } else if (i == f.abc_btn_colored_material) {
                e = d(context);
            } else if (i == f.abc_spinner_mtrl_am_alpha || i == f.abc_spinner_textfield_background_material) {
                e = android.support.v7.c.a.b.a(context, d.abc_tint_spinner);
            } else if (a(e, i)) {
                e = cx.b(context, b.colorControlNormal);
            } else if (a(h, i)) {
                e = android.support.v7.c.a.b.a(context, d.abc_tint_default);
            } else if (a(i, i)) {
                e = android.support.v7.c.a.b.a(context, d.abc_tint_btn_checkable);
            } else if (i == f.abc_seekbar_thumb_material) {
                e = android.support.v7.c.a.b.a(context, d.abc_tint_seek_thumb);
            }
            if (e != null) {
                a(context, i, e);
            }
        }
        return e;
    }
}
