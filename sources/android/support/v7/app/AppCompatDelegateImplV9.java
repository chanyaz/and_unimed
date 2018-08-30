package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ak;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ap;
import android.support.v4.view.ar;
import android.support.v4.view.as;
import android.support.v4.view.e;
import android.support.v4.widget.z;
import android.support.v7.a.b;
import android.support.v7.a.d;
import android.support.v7.a.g;
import android.support.v7.a.j;
import android.support.v7.a.k;
import android.support.v7.view.ActionMode;
import android.support.v7.view.c;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.OnAttachListener;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.dh;
import android.support.v7.widget.dk;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;

@RequiresApi(14)
class AppCompatDelegateImplV9 extends k implements Callback, Factory2 {
    private static final boolean t = (VERSION.SDK_INT < 21);
    private View A;
    private boolean B;
    private boolean C;
    private boolean D;
    private PanelFeatureState[] E;
    private PanelFeatureState F;
    private boolean G;
    private final Runnable H = new Runnable() {
        public void run() {
            if ((AppCompatDelegateImplV9.this.s & 1) != 0) {
                AppCompatDelegateImplV9.this.f(0);
            }
            if ((AppCompatDelegateImplV9.this.s & 4096) != 0) {
                AppCompatDelegateImplV9.this.f(108);
            }
            AppCompatDelegateImplV9.this.r = false;
            AppCompatDelegateImplV9.this.s = 0;
        }
    };
    private boolean I;
    private Rect J;
    private Rect K;
    private AppCompatViewInflater L;
    ActionMode m;
    ActionBarContextView n;
    PopupWindow o;
    Runnable p;
    ap q = null;
    boolean r;
    int s;
    private DecorContentParent u;
    private u v;
    private x w;
    private boolean x;
    private ViewGroup y;
    private TextView z;

    public final class PanelFeatureState {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        MenuBuilder j;
        h k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                /* renamed from: a */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            int a;
            boolean b;
            Bundle c;

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.a = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.b = z;
                if (savedState.b) {
                    savedState.c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b ? 1 : 0);
                if (this.b) {
                    parcel.writeBundle(this.c);
                }
            }
        }

        PanelFeatureState(int i) {
            this.a = i;
        }

        MenuView a(MenuPresenter.Callback callback) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new h(this.l, android.support.v7.a.h.abc_list_menu_item_layout);
                this.k.setCallback(callback);
                this.j.a(this.k);
            }
            return this.k.getMenuView(this.g);
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(b.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(b.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(j.Theme_AppCompat_CompactMenu, true);
            }
            Context bVar = new android.support.v7.view.b(context, 0);
            bVar.getTheme().setTo(newTheme);
            this.l = bVar;
            TypedArray obtainStyledAttributes = bVar.obtainStyledAttributes(k.AppCompatTheme);
            this.b = obtainStyledAttributes.getResourceId(k.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(k.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void a(MenuBuilder menuBuilder) {
            if (menuBuilder != this.j) {
                if (this.j != null) {
                    this.j.b(this.k);
                }
                this.j = menuBuilder;
                if (menuBuilder != null && this.k != null) {
                    menuBuilder.a(this.k);
                }
            }
        }

        public boolean a() {
            return this.h == null ? false : this.i != null || this.k.a().getCount() > 0;
        }
    }

    AppCompatDelegateImplV9(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    private void A() {
        if (this.x) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX WARNING: Missing block: B:57:0x00f0, code:
            if (r0.width == -1) goto L_0x00af;
     */
    private void a(android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r3 = 0;
        r1 = -1;
        r9 = 1;
        r2 = -2;
        r0 = r11.o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.q();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.a;
        if (r0 != 0) goto L_0x0027;
    L_0x0013:
        r0 = r10.a;
        r0 = r0.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r4 = 4;
        if (r0 != r4) goto L_0x003b;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        if (r0 != 0) goto L_0x000e;
    L_0x0027:
        r0 = r10.r();
        if (r0 == 0) goto L_0x003d;
    L_0x002d:
        r4 = r11.a;
        r5 = r11.j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x003d;
    L_0x0037:
        r10.a(r11, r9);
        goto L_0x000e;
    L_0x003b:
        r0 = r3;
        goto L_0x0025;
    L_0x003d:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x004a:
        r0 = r10.b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x0050:
        r0 = r11.g;
        if (r0 == 0) goto L_0x0058;
    L_0x0054:
        r0 = r11.q;
        if (r0 == 0) goto L_0x00e2;
    L_0x0058:
        r0 = r11.g;
        if (r0 != 0) goto L_0x00d0;
    L_0x005c:
        r0 = r10.a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0062:
        r0 = r11.g;
        if (r0 == 0) goto L_0x000e;
    L_0x0066:
        r0 = r10.c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x006c:
        r0 = r11.a();
        if (r0 == 0) goto L_0x000e;
    L_0x0072:
        r0 = r11.h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x00f4;
    L_0x007a:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x0080:
        r0 = r11.b;
        r4 = r11.g;
        r4.setBackgroundResource(r0);
        r0 = r11.h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x009a;
    L_0x008f:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x009a;
    L_0x0093:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.h;
        r0.removeView(r4);
    L_0x009a:
        r0 = r11.g;
        r4 = r11.h;
        r0.addView(r4, r1);
        r0 = r11.h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00ae;
    L_0x00a9:
        r0 = r11.h;
        r0.requestFocus();
    L_0x00ae:
        r1 = r2;
    L_0x00af:
        r11.n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.d;
        r4 = r11.e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.c;
        r0.gravity = r1;
        r1 = r11.f;
        r0.windowAnimations = r1;
        r1 = r11.g;
        r8.addView(r1, r0);
        r11.o = r9;
        goto L_0x000e;
    L_0x00d0:
        r0 = r11.q;
        if (r0 == 0) goto L_0x0066;
    L_0x00d4:
        r0 = r11.g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0066;
    L_0x00dc:
        r0 = r11.g;
        r0.removeAllViews();
        goto L_0x0066;
    L_0x00e2:
        r0 = r11.i;
        if (r0 == 0) goto L_0x00f2;
    L_0x00e6:
        r0 = r11.i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x00f2;
    L_0x00ee:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00af;
    L_0x00f2:
        r1 = r2;
        goto L_0x00af;
    L_0x00f4:
        r1 = r0;
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV9.a(android.support.v7.app.AppCompatDelegateImplV9$PanelFeatureState, android.view.KeyEvent):void");
    }

    private void a(MenuBuilder menuBuilder, boolean z) {
        if (this.u == null || !this.u.canShowOverflowMenu() || (ViewConfiguration.get(this.a).hasPermanentMenuKey() && !this.u.isOverflowMenuShowPending())) {
            PanelFeatureState a = a(0, true);
            a.q = true;
            a(a, false);
            a(a, null);
            return;
        }
        Window.Callback r = r();
        if (this.u.isOverflowMenuShowing() && z) {
            this.u.hideOverflowMenu();
            if (!q()) {
                r.onPanelClosed(108, a(0, true).j);
            }
        } else if (r != null && !q()) {
            if (this.r && (this.s & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.H);
                this.H.run();
            }
            PanelFeatureState a2 = a(0, true);
            if (a2.j != null && !a2.r && r.onPreparePanel(0, a2.i, a2.j)) {
                r.onMenuOpened(108, a2.j);
                this.u.showOverflowMenu();
            }
        }
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.a(o());
        panelFeatureState.g = new w(this, panelFeatureState.l);
        panelFeatureState.c = 81;
        return true;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((panelFeatureState.m || b(panelFeatureState, keyEvent)) && panelFeatureState.j != null) {
                z = panelFeatureState.j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.u == null) {
                a(panelFeatureState, true);
            }
        }
        return z;
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.b.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || ViewCompat.B((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context bVar;
        MenuBuilder menuBuilder;
        Context context = this.a;
        if ((panelFeatureState.a == 0 || panelFeatureState.a == 108) && this.u != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(b.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(b.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(b.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                bVar = new android.support.v7.view.b(context, 0);
                bVar.getTheme().setTo(theme3);
                menuBuilder = new MenuBuilder(bVar);
                menuBuilder.a((Callback) this);
                panelFeatureState.a(menuBuilder);
                return true;
            }
        }
        bVar = context;
        menuBuilder = new MenuBuilder(bVar);
        menuBuilder.a((Callback) this);
        panelFeatureState.a(menuBuilder);
        return true;
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (q()) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        if (!(this.F == null || this.F == panelFeatureState)) {
            a(this.F, false);
        }
        Window.Callback r = r();
        if (r != null) {
            panelFeatureState.i = r.onCreatePanelView(panelFeatureState.a);
        }
        boolean z = panelFeatureState.a == 0 || panelFeatureState.a == 108;
        if (z && this.u != null) {
            this.u.setMenuPrepared();
        }
        if (panelFeatureState.i == null && !(z && (n() instanceof ab))) {
            if (panelFeatureState.j == null || panelFeatureState.r) {
                if (panelFeatureState.j == null && (!b(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z && this.u != null) {
                    if (this.v == null) {
                        this.v = new u(this);
                    }
                    this.u.setMenu(panelFeatureState.j, this.v);
                }
                panelFeatureState.j.g();
                if (r.onCreatePanelMenu(panelFeatureState.a, panelFeatureState.j)) {
                    panelFeatureState.r = false;
                } else {
                    panelFeatureState.a(null);
                    if (!z || this.u == null) {
                        return false;
                    }
                    this.u.setMenu(null, this.v);
                    return false;
                }
            }
            panelFeatureState.j.g();
            if (panelFeatureState.s != null) {
                panelFeatureState.j.d(panelFeatureState.s);
                panelFeatureState.s = null;
            }
            if (r.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                panelFeatureState.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
                panelFeatureState.j.setQwertyMode(panelFeatureState.p);
                panelFeatureState.j.h();
            } else {
                if (z && this.u != null) {
                    this.u.setMenu(null, this.v);
                }
                panelFeatureState.j.h();
                return false;
            }
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.F = panelFeatureState;
        return true;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.i != null) {
            panelFeatureState.h = panelFeatureState.i;
            return true;
        } else if (panelFeatureState.j == null) {
            return false;
        } else {
            if (this.w == null) {
                this.w = new x(this);
            }
            panelFeatureState.h = (View) panelFeatureState.a(this.w);
            return panelFeatureState.h != null;
        }
    }

    private void d(int i) {
        this.s |= 1 << i;
        if (!this.r) {
            ViewCompat.a(this.b.getDecorView(), this.H);
            this.r = true;
        }
    }

    private boolean d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState a = a(i, true);
            if (!a.o) {
                return b(a, keyEvent);
            }
        }
        return false;
    }

    private boolean e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.m != null) {
            return false;
        }
        PanelFeatureState a = a(i, true);
        if (i != 0 || this.u == null || !this.u.canShowOverflowMenu() || ViewConfiguration.get(this.a).hasPermanentMenuKey()) {
            boolean z2;
            if (a.o || a.n) {
                z2 = a.o;
                a(a, true);
                z = z2;
            } else {
                if (a.m) {
                    if (a.r) {
                        a.m = false;
                        z2 = b(a, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        a(a, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.u.isOverflowMenuShowing()) {
            z = this.u.hideOverflowMenu();
        } else {
            if (!q() && b(a, keyEvent)) {
                z = this.u.showOverflowMenu();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private int h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private void x() {
        if (!this.x) {
            this.y = y();
            CharSequence s = s();
            if (!TextUtils.isEmpty(s)) {
                b(s);
            }
            z();
            a(this.y);
            this.x = true;
            PanelFeatureState a = a(0, false);
            if (!q()) {
                if (a == null || a.j == null) {
                    d(108);
                }
            }
        }
    }

    private ViewGroup y() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(k.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(k.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(k.AppCompatTheme_windowNoTitle, false)) {
                c(1);
            } else if (obtainStyledAttributes.getBoolean(k.AppCompatTheme_windowActionBar, false)) {
                c(108);
            }
            if (obtainStyledAttributes.getBoolean(k.AppCompatTheme_windowActionBarOverlay, false)) {
                c(109);
            }
            if (obtainStyledAttributes.getBoolean(k.AppCompatTheme_windowActionModeOverlay, false)) {
                c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(k.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.a);
            View view2;
            if (this.l) {
                View view3 = this.j ? (ViewGroup) from.inflate(android.support.v7.a.h.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(android.support.v7.a.h.abc_screen_simple, null);
                if (VERSION.SDK_INT >= 21) {
                    ViewCompat.a(view3, new OnApplyWindowInsetsListener() {
                        public as onApplyWindowInsets(View view, as asVar) {
                            int b = asVar.b();
                            int g = AppCompatDelegateImplV9.this.g(b);
                            if (b != g) {
                                asVar = asVar.a(asVar.a(), g, asVar.c(), asVar.d());
                            }
                            return ViewCompat.a(view, asVar);
                        }
                    });
                    view = view3;
                } else {
                    ((FitWindowsViewGroup) view3).setOnFitSystemWindowsListener(new OnFitSystemWindowsListener() {
                        public void onFitSystemWindows(Rect rect) {
                            rect.top = AppCompatDelegateImplV9.this.g(rect.top);
                        }
                    });
                    view = view3;
                }
            } else if (this.k) {
                view2 = (ViewGroup) from.inflate(android.support.v7.a.h.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
                view = view2;
            } else if (this.h) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(b.actionBarTheme, typedValue, true);
                view2 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.view.b(this.a, typedValue.resourceId) : this.a).inflate(android.support.v7.a.h.abc_screen_toolbar, null);
                this.u = (DecorContentParent) view2.findViewById(g.decor_content_parent);
                this.u.setWindowCallback(r());
                if (this.i) {
                    this.u.initFeature(109);
                }
                if (this.B) {
                    this.u.initFeature(2);
                }
                if (this.C) {
                    this.u.initFeature(5);
                }
                view = view2;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
            }
            if (this.u == null) {
                this.z = (TextView) view.findViewById(g.title);
            }
            dk.b(view);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(g.action_bar_activity_content);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            if (viewGroup != null) {
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
            }
            this.b.setContentView(view);
            contentFrameLayout.setAttachListener(new OnAttachListener() {
                public void onAttachedFromWindow() {
                }

                public void onDetachedFromWindow() {
                    AppCompatDelegateImplV9.this.w();
                }
            });
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void z() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.y.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(k.AppCompatTheme);
        obtainStyledAttributes.getValue(k.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(k.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(k.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(k.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(k.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(k.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(k.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(k.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(k.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(k.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    protected PanelFeatureState a(int i, boolean z) {
        Object obj = this.E;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.E = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.E;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    ActionMode a(@NonNull ActionMode.Callback callback) {
        ActionMode actionMode;
        u();
        if (this.m != null) {
            this.m.c();
        }
        if (!(callback instanceof v)) {
            callback = new v(this, callback);
        }
        if (this.e == null || q()) {
            actionMode = null;
        } else {
            try {
                actionMode = this.e.onWindowStartingSupportActionMode(callback);
            } catch (AbstractMethodError e) {
                actionMode = null;
            }
        }
        if (actionMode != null) {
            this.m = actionMode;
        } else {
            if (this.n == null) {
                if (this.k) {
                    Context bVar;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(b.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        bVar = new android.support.v7.view.b(this.a, 0);
                        bVar.getTheme().setTo(newTheme);
                    } else {
                        bVar = this.a;
                    }
                    this.n = new ActionBarContextView(bVar);
                    this.o = new PopupWindow(bVar, null, b.actionModePopupWindowStyle);
                    z.a(this.o, 2);
                    this.o.setContentView(this.n);
                    this.o.setWidth(-1);
                    bVar.getTheme().resolveAttribute(b.actionBarSize, typedValue, true);
                    this.n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, bVar.getResources().getDisplayMetrics()));
                    this.o.setHeight(-2);
                    this.p = new Runnable() {
                        public void run() {
                            AppCompatDelegateImplV9.this.o.showAtLocation(AppCompatDelegateImplV9.this.n, 55, 0, 0);
                            AppCompatDelegateImplV9.this.u();
                            if (AppCompatDelegateImplV9.this.t()) {
                                AppCompatDelegateImplV9.this.n.setAlpha(0.0f);
                                AppCompatDelegateImplV9.this.q = ViewCompat.l(AppCompatDelegateImplV9.this.n).a(1.0f);
                                AppCompatDelegateImplV9.this.q.a(new ar() {
                                    public void onAnimationEnd(View view) {
                                        AppCompatDelegateImplV9.this.n.setAlpha(1.0f);
                                        AppCompatDelegateImplV9.this.q.a(null);
                                        AppCompatDelegateImplV9.this.q = null;
                                    }

                                    public void onAnimationStart(View view) {
                                        AppCompatDelegateImplV9.this.n.setVisibility(0);
                                    }
                                });
                                return;
                            }
                            AppCompatDelegateImplV9.this.n.setAlpha(1.0f);
                            AppCompatDelegateImplV9.this.n.setVisibility(0);
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.y.findViewById(g.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(o()));
                        this.n = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.n != null) {
                u();
                this.n.c();
                ActionMode cVar = new c(this.n.getContext(), this.n, callback, this.o == null);
                if (callback.onCreateActionMode(cVar, cVar.b())) {
                    cVar.d();
                    this.n.a(cVar);
                    this.m = cVar;
                    if (t()) {
                        this.n.setAlpha(0.0f);
                        this.q = ViewCompat.l(this.n).a(1.0f);
                        this.q.a(new ar() {
                            public void onAnimationEnd(View view) {
                                AppCompatDelegateImplV9.this.n.setAlpha(1.0f);
                                AppCompatDelegateImplV9.this.q.a(null);
                                AppCompatDelegateImplV9.this.q = null;
                            }

                            public void onAnimationStart(View view) {
                                AppCompatDelegateImplV9.this.n.setVisibility(0);
                                AppCompatDelegateImplV9.this.n.sendAccessibilityEvent(32);
                                if (AppCompatDelegateImplV9.this.n.getParent() instanceof View) {
                                    ViewCompat.q((View) AppCompatDelegateImplV9.this.n.getParent());
                                }
                            }
                        });
                    } else {
                        this.n.setAlpha(1.0f);
                        this.n.setVisibility(0);
                        this.n.sendAccessibilityEvent(32);
                        if (this.n.getParent() instanceof View) {
                            ViewCompat.q((View) this.n.getParent());
                        }
                    }
                    if (this.o != null) {
                        this.b.getDecorView().post(this.p);
                    }
                } else {
                    this.m = null;
                }
            }
        }
        if (!(this.m == null || this.e == null)) {
            this.e.onSupportActionModeStarted(this.m);
        }
        return this.m;
    }

    @Nullable
    public <T extends View> T a(@IdRes int i) {
        x();
        return this.b.findViewById(i);
    }

    View a(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.E.length) {
                panelFeatureState = this.E[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !q()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    void a(int i, Menu menu) {
        if (i == 108) {
            ActionBar a = a();
            if (a != null) {
                a.f(false);
            }
        } else if (i == 0) {
            PanelFeatureState a2 = a(i, true);
            if (a2.o) {
                a(a2, false);
            }
        }
    }

    public void a(Configuration configuration) {
        if (this.h && this.x) {
            ActionBar a = a();
            if (a != null) {
                a.a(configuration);
            }
        }
        AppCompatDrawableManager.a().a(this.a);
        j();
    }

    public void a(Bundle bundle) {
        if ((this.c instanceof Activity) && ak.b((Activity) this.c) != null) {
            ActionBar n = n();
            if (n == null) {
                this.I = true;
            } else {
                n.d(true);
            }
        }
    }

    void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.a == 0 && this.u != null && this.u.isOverflowMenuShowing()) {
            a(panelFeatureState.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.o || panelFeatureState.g == null)) {
            windowManager.removeView(panelFeatureState.g);
            if (z) {
                a(panelFeatureState.a, panelFeatureState, null);
            }
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        panelFeatureState.h = null;
        panelFeatureState.q = true;
        if (this.F == panelFeatureState) {
            this.F = null;
        }
    }

    void a(MenuBuilder menuBuilder) {
        if (!this.D) {
            this.D = true;
            this.u.dismissPopups();
            Window.Callback r = r();
            if (!(r == null || q())) {
                r.onPanelClosed(108, menuBuilder);
            }
            this.D = false;
        }
    }

    public void a(Toolbar toolbar) {
        if (this.c instanceof Activity) {
            ActionBar a = a();
            if (a instanceof ai) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.g = null;
            if (a != null) {
                a.j();
            }
            if (toolbar != null) {
                ActionBar abVar = new ab(toolbar, ((Activity) this.c).getTitle(), this.d);
                this.f = abVar;
                this.b.setCallback(abVar.k());
            } else {
                this.f = null;
                this.b.setCallback(this.d);
            }
            f();
        }
    }

    public void a(View view) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void a(View view, LayoutParams layoutParams) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void a(ViewGroup viewGroup) {
    }

    boolean a(int i, KeyEvent keyEvent) {
        ActionBar a = a();
        if (a != null && a.a(i, keyEvent)) {
            return true;
        }
        if (this.F == null || !a(this.F, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.F == null) {
                PanelFeatureState a2 = a(0, true);
                b(a2, keyEvent);
                boolean a3 = a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.F == null) {
            return true;
        } else {
            this.F.n = true;
            return true;
        }
    }

    boolean a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    public ActionMode b(@NonNull ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.m != null) {
            this.m.c();
        }
        ActionMode.Callback vVar = new v(this, callback);
        ActionBar a = a();
        if (a != null) {
            this.m = a.a(vVar);
            if (!(this.m == null || this.e == null)) {
                this.e.onSupportActionModeStarted(this.m);
            }
        }
        if (this.m == null) {
            this.m = a(vVar);
        }
        return this.m;
    }

    public View b(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z;
        if (this.L == null) {
            String string = this.a.obtainStyledAttributes(k.AppCompatTheme).getString(k.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.L = new AppCompatViewInflater();
            } else {
                try {
                    this.L = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.L = new AppCompatViewInflater();
                }
            }
        }
        if (t) {
            boolean a = attributeSet instanceof XmlPullParser ? ((XmlPullParser) attributeSet).getDepth() > 1 : a((ViewParent) view);
            z = a;
        } else {
            z = false;
        }
        return this.L.a(view, str, context, attributeSet, z, t, true, dh.a());
    }

    public void b(int i) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void b(Bundle bundle) {
        x();
    }

    public void b(View view, LayoutParams layoutParams) {
        x();
        ((ViewGroup) this.y.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void b(CharSequence charSequence) {
        if (this.u != null) {
            this.u.setWindowTitle(charSequence);
        } else if (n() != null) {
            n().b(charSequence);
        } else if (this.z != null) {
            this.z.setText(charSequence);
        }
    }

    boolean b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.G;
                this.G = false;
                PanelFeatureState a = a(0, false);
                if (a == null || !a.o) {
                    if (v()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    a(a, true);
                    return true;
                }
                break;
            case 82:
                e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        ActionBar a = a();
        if (a == null) {
            return true;
        }
        a.f(true);
        return true;
    }

    public boolean c(int i) {
        int h = h(i);
        if (this.l && h == 108) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case 1:
                A();
                this.l = true;
                return true;
            case 2:
                A();
                this.B = true;
                return true;
            case 5:
                A();
                this.C = true;
                return true;
            case 10:
                A();
                this.j = true;
                return true;
            case 108:
                A();
                this.h = true;
                return true;
            case 109:
                A();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    boolean c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case 4:
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.G = z;
                break;
            case 82:
                d(0, keyEvent);
                return true;
        }
        return false;
    }

    public void d() {
        ActionBar a = a();
        if (a != null) {
            a.e(false);
        }
    }

    public void e() {
        ActionBar a = a();
        if (a != null) {
            a.e(true);
        }
    }

    void e(int i) {
        a(a(i, true), true);
    }

    public void f() {
        ActionBar a = a();
        if (a == null || !a.h()) {
            d(0);
        }
    }

    void f(int i) {
        PanelFeatureState a = a(i, true);
        if (a.j != null) {
            Bundle bundle = new Bundle();
            a.j.c(bundle);
            if (bundle.size() > 0) {
                a.s = bundle;
            }
            a.j.g();
            a.j.clear();
        }
        a.r = true;
        a.q = true;
        if ((i == 108 || i == 0) && this.u != null) {
            a = a(0, false);
            if (a != null) {
                a.m = false;
                b(a, null);
            }
        }
    }

    int g(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.n == null || !(this.n.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.n.getLayoutParams();
            if (this.n.isShown()) {
                if (this.J == null) {
                    this.J = new Rect();
                    this.K = new Rect();
                }
                Rect rect = this.J;
                Rect rect2 = this.K;
                rect.set(0, i, 0, 0);
                dk.a(this.y, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.A == null) {
                        this.A = new View(this.a);
                        this.A.setBackgroundColor(this.a.getResources().getColor(d.abc_input_method_navigation_guard));
                        this.y.addView(this.A, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.A.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.A.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.A == null) {
                    i3 = 0;
                }
                if (!(this.j || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.n.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.A != null) {
            View view = this.A;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    public void g() {
        if (this.r) {
            this.b.getDecorView().removeCallbacks(this.H);
        }
        super.g();
        if (this.f != null) {
            this.f.j();
        }
    }

    public void i() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            e.b(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImplV9)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void m() {
        x();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new ai((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new ai((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.d(this.I);
            }
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = a(view, str, context, attributeSet);
        return a != null ? a : b(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        Window.Callback r = r();
        if (!(r == null || q())) {
            PanelFeatureState a = a(menuBuilder.p());
            if (a != null) {
                return r.onMenuItemSelected(a.a, menuItem);
            }
        }
        return false;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        a(menuBuilder, true);
    }

    final boolean t() {
        return this.x && this.y != null && ViewCompat.y(this.y);
    }

    void u() {
        if (this.q != null) {
            this.q.b();
        }
    }

    boolean v() {
        if (this.m != null) {
            this.m.c();
            return true;
        }
        ActionBar a = a();
        return a != null && a.i();
    }

    void w() {
        if (this.u != null) {
            this.u.dismissPopups();
        }
        if (this.o != null) {
            this.b.getDecorView().removeCallbacks(this.p);
            if (this.o.isShowing()) {
                try {
                    this.o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.o = null;
        }
        u();
        PanelFeatureState a = a(0, false);
        if (a != null && a.j != null) {
            a.j.close();
        }
    }
}
