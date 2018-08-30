package com.mopub.mraid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.appnext.base.b.c;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.CloseableLayout.ClosePosition;
import com.mopub.common.CloseableLayout.OnCloseListener;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.common.util.Views;
import com.mopub.mobileads.BaseVideoPlayerActivity;
import com.mopub.mobileads.util.WebViews;
import com.mopub.mraid.MraidBridge.MraidBridgeListener;
import com.mopub.mraid.MraidBridge.MraidWebView;
import java.lang.ref.WeakReference;
import java.net.URI;

public class MraidController {
    private final AdReport a;
    @NonNull
    private final WeakReference<Activity> b;
    @NonNull
    private final Context c;
    @NonNull
    private final PlacementType d;
    @NonNull
    private final FrameLayout e;
    @NonNull
    private final CloseableLayout f;
    @Nullable
    private ViewGroup g;
    @NonNull
    private final c h;
    @NonNull
    private final g i;
    @NonNull
    private ViewState j;
    @Nullable
    private MraidListener k;
    @Nullable
    private UseCustomCloseListener l;
    @Nullable
    private MraidWebViewDebugListener m;
    @Nullable
    private MraidWebView n;
    @Nullable
    private MraidWebView o;
    @NonNull
    private final MraidBridge p;
    @NonNull
    private final MraidBridge q;
    @NonNull
    private b r;
    @Nullable
    private Integer s;
    private boolean t;
    private f u;
    private final MraidNativeCommandHandler v;
    private boolean w;
    private final MraidBridgeListener x;
    private final MraidBridgeListener y;

    public interface MraidListener {
        void onClose();

        void onExpand();

        void onFailedToLoad();

        void onLoaded(View view);

        void onOpen();
    }

    public interface UseCustomCloseListener {
        void useCustomCloseChanged(boolean z);
    }

    public MraidController(@NonNull Context context, @Nullable AdReport adReport, @NonNull PlacementType placementType) {
        this(context, adReport, placementType, new MraidBridge(adReport, placementType), new MraidBridge(adReport, PlacementType.INTERSTITIAL), new c());
    }

    @VisibleForTesting
    MraidController(@NonNull Context context, @Nullable AdReport adReport, @NonNull PlacementType placementType, @NonNull MraidBridge mraidBridge, @NonNull MraidBridge mraidBridge2, @NonNull c cVar) {
        this.j = ViewState.LOADING;
        this.r = new b(this);
        this.t = true;
        this.u = f.NONE;
        this.x = new MraidBridgeListener() {
            public void onClose() {
                MraidController.this.c();
            }

            public boolean onConsoleMessage(@NonNull ConsoleMessage consoleMessage) {
                return MraidController.this.a(consoleMessage);
            }

            public void onExpand(@Nullable URI uri, boolean z) {
                MraidController.this.a(uri, z);
            }

            public boolean onJsAlert(@NonNull String str, @NonNull JsResult jsResult) {
                return MraidController.this.a(str, jsResult);
            }

            public void onOpen(@NonNull URI uri) {
                MraidController.this.b(uri.toString());
            }

            public void onPageFailedToLoad() {
                if (MraidController.this.k != null) {
                    MraidController.this.k.onFailedToLoad();
                }
            }

            public void onPageLoaded() {
                MraidController.this.a();
            }

            public void onPlayVideo(@NonNull URI uri) {
                MraidController.this.a(uri.toString());
            }

            public void onResize(int i, int i2, int i3, int i4, @NonNull ClosePosition closePosition, boolean z) {
                MraidController.this.a(i, i2, i3, i4, closePosition, z);
            }

            public void onSetOrientationProperties(boolean z, f fVar) {
                MraidController.this.a(z, fVar);
            }

            public void onUseCustomClose(boolean z) {
                MraidController.this.a(z);
            }

            public void onVisibilityChanged(boolean z) {
                if (!MraidController.this.q.d()) {
                    MraidController.this.p.a(z);
                }
            }
        };
        this.y = new MraidBridgeListener() {
            public void onClose() {
                MraidController.this.c();
            }

            public boolean onConsoleMessage(@NonNull ConsoleMessage consoleMessage) {
                return MraidController.this.a(consoleMessage);
            }

            public void onExpand(@Nullable URI uri, boolean z) {
            }

            public boolean onJsAlert(@NonNull String str, @NonNull JsResult jsResult) {
                return MraidController.this.a(str, jsResult);
            }

            public void onOpen(URI uri) {
                MraidController.this.b(uri.toString());
            }

            public void onPageFailedToLoad() {
            }

            public void onPageLoaded() {
                MraidController.this.b();
            }

            public void onPlayVideo(@NonNull URI uri) {
                MraidController.this.a(uri.toString());
            }

            public void onResize(int i, int i2, int i3, int i4, @NonNull ClosePosition closePosition, boolean z) {
                throw new a("Not allowed to resize from an expanded state");
            }

            public void onSetOrientationProperties(boolean z, f fVar) {
                MraidController.this.a(z, fVar);
            }

            public void onUseCustomClose(boolean z) {
                MraidController.this.a(z);
            }

            public void onVisibilityChanged(boolean z) {
                MraidController.this.p.a(z);
                MraidController.this.q.a(z);
            }
        };
        this.c = context.getApplicationContext();
        Preconditions.checkNotNull(this.c);
        this.a = adReport;
        if (context instanceof Activity) {
            this.b = new WeakReference((Activity) context);
        } else {
            this.b = new WeakReference(null);
        }
        this.d = placementType;
        this.p = mraidBridge;
        this.q = mraidBridge2;
        this.h = cVar;
        this.j = ViewState.LOADING;
        this.i = new g(this.c, this.c.getResources().getDisplayMetrics().density);
        this.e = new FrameLayout(this.c);
        this.f = new CloseableLayout(this.c);
        this.f.setOnCloseListener(new OnCloseListener() {
            public void onClose() {
                MraidController.this.c();
            }
        });
        View view = new View(this.c);
        view.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f.addView(view, new LayoutParams(-1, -1));
        this.r.register(this.c);
        this.p.a(this.x);
        this.q.a(this.y);
        this.v = new MraidNativeCommandHandler();
    }

    private void a(@NonNull ViewState viewState) {
        a(viewState, null);
    }

    private void a(@NonNull ViewState viewState, @Nullable Runnable runnable) {
        MoPubLog.d("MRAID state set to " + viewState);
        this.j = viewState;
        this.p.a(viewState);
        if (this.q.e()) {
            this.q.a(viewState);
        }
        if (this.k != null) {
            if (viewState == ViewState.EXPANDED) {
                this.k.onExpand();
            } else if (viewState == ViewState.HIDDEN) {
                this.k.onClose();
            }
        }
        a(runnable);
    }

    private void a(@Nullable final Runnable runnable) {
        this.h.a();
        final View g = g();
        if (g != null) {
            this.h.a(this.e, g).a(new Runnable() {
                public void run() {
                    DisplayMetrics displayMetrics = MraidController.this.c.getResources().getDisplayMetrics();
                    MraidController.this.i.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
                    int[] iArr = new int[2];
                    View j = MraidController.this.i();
                    j.getLocationOnScreen(iArr);
                    MraidController.this.i.a(iArr[0], iArr[1], j.getWidth(), j.getHeight());
                    MraidController.this.e.getLocationOnScreen(iArr);
                    MraidController.this.i.c(iArr[0], iArr[1], MraidController.this.e.getWidth(), MraidController.this.e.getHeight());
                    g.getLocationOnScreen(iArr);
                    MraidController.this.i.b(iArr[0], iArr[1], g.getWidth(), g.getHeight());
                    MraidController.this.p.notifyScreenMetrics(MraidController.this.i);
                    if (MraidController.this.q.d()) {
                        MraidController.this.q.notifyScreenMetrics(MraidController.this.i);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    private int f() {
        return ((WindowManager) this.c.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    @Nullable
    private View g() {
        return this.q.d() ? this.o : this.n;
    }

    private boolean h() {
        Activity activity = (Activity) this.b.get();
        return (activity == null || g() == null) ? false : this.v.a(activity, g());
    }

    @TargetApi(19)
    @NonNull
    private ViewGroup i() {
        if (this.g == null) {
            if (VERSION.SDK_INT >= 19) {
                Preconditions.checkState(this.e.isAttachedToWindow());
            }
            this.g = (ViewGroup) this.e.getRootView().findViewById(16908290);
        }
        return this.g;
    }

    int a(int i, int i2, int i3) {
        return Math.max(i, Math.min(i2, i3));
    }

    @VisibleForTesting
    void a() {
        a(ViewState.DEFAULT, new Runnable() {
            public void run() {
                MraidController.this.p.a(MraidController.this.v.b(MraidController.this.c), MraidController.this.v.a(MraidController.this.c), MraidNativeCommandHandler.c(MraidController.this.c), MraidNativeCommandHandler.isStorePictureSupported(MraidController.this.c), MraidController.this.h());
                MraidController.this.p.a(MraidController.this.d);
                MraidController.this.p.a(MraidController.this.p.c());
                MraidController.this.p.b();
            }
        });
        if (this.k != null) {
            this.k.onLoaded(this.e);
        }
    }

    void a(int i) {
        a(null);
    }

    @VisibleForTesting
    void a(int i, int i2, int i3, int i4, @NonNull ClosePosition closePosition, boolean z) {
        if (this.n == null) {
            throw new a("Unable to resize after the WebView is destroyed");
        } else if (this.j != ViewState.LOADING && this.j != ViewState.HIDDEN) {
            if (this.j == ViewState.EXPANDED) {
                throw new a("Not allowed to resize from an already expanded ad");
            } else if (this.d == PlacementType.INTERSTITIAL) {
                throw new a("Not allowed to resize from an interstitial ad");
            } else {
                Rect b;
                int dipsToIntPixels = Dips.dipsToIntPixels((float) i, this.c);
                int dipsToIntPixels2 = Dips.dipsToIntPixels((float) i2, this.c);
                int dipsToIntPixels3 = Dips.dipsToIntPixels((float) i3, this.c);
                dipsToIntPixels3 += this.i.f().left;
                int dipsToIntPixels4 = Dips.dipsToIntPixels((float) i4, this.c) + this.i.f().top;
                Rect rect = new Rect(dipsToIntPixels3, dipsToIntPixels4, dipsToIntPixels + dipsToIntPixels3, dipsToIntPixels4 + dipsToIntPixels2);
                if (!z) {
                    b = this.i.b();
                    if (rect.width() > b.width() || rect.height() > b.height()) {
                        throw new a("resizeProperties specified a size (" + i + ", " + i2 + ") and offset (" + i3 + ", " + i4 + ") that doesn't allow the ad to" + " appear within the max allowed size (" + this.i.c().width() + ", " + this.i.c().height() + ")");
                    }
                    rect.offsetTo(a(b.left, rect.left, b.right - rect.width()), a(b.top, rect.top, b.bottom - rect.height()));
                }
                b = new Rect();
                this.f.applyCloseRegionBounds(closePosition, rect, b);
                if (!this.i.b().contains(b)) {
                    throw new a("resizeProperties specified a size (" + i + ", " + i2 + ") and offset (" + i3 + ", " + i4 + ") that doesn't allow the close" + " region to appear within the max allowed size (" + this.i.c().width() + ", " + this.i.c().height() + ")");
                } else if (rect.contains(b)) {
                    this.f.setCloseVisible(false);
                    this.f.setClosePosition(closePosition);
                    ViewGroup.LayoutParams layoutParams = new LayoutParams(rect.width(), rect.height());
                    layoutParams.leftMargin = rect.left - this.i.b().left;
                    layoutParams.topMargin = rect.top - this.i.b().top;
                    if (this.j == ViewState.DEFAULT) {
                        this.e.removeView(this.n);
                        this.e.setVisibility(4);
                        this.f.addView(this.n, new LayoutParams(-1, -1));
                        i().addView(this.f, layoutParams);
                    } else if (this.j == ViewState.RESIZED) {
                        this.f.setLayoutParams(layoutParams);
                    }
                    this.f.setClosePosition(closePosition);
                    a(ViewState.RESIZED);
                } else {
                    throw new a("resizeProperties specified a size (" + i + ", " + dipsToIntPixels2 + ") and offset (" + i3 + ", " + i4 + ") that don't allow the close region to appear " + "within the resized ad.");
                }
            }
        }
    }

    @VisibleForTesting
    void a(@NonNull String str) {
        BaseVideoPlayerActivity.startMraid(this.c, str);
    }

    void a(@Nullable URI uri, boolean z) {
        if (this.n == null) {
            throw new a("Unable to expand after the WebView is destroyed");
        } else if (this.d != PlacementType.INTERSTITIAL) {
            if (this.j == ViewState.DEFAULT || this.j == ViewState.RESIZED) {
                d();
                Object obj = uri != null ? 1 : null;
                if (obj != null) {
                    this.o = new MraidWebView(this.c);
                    this.q.a(this.o);
                    this.q.setContentUrl(uri.toString());
                }
                ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
                if (this.j == ViewState.DEFAULT) {
                    if (obj != null) {
                        this.f.addView(this.o, layoutParams);
                    } else {
                        this.e.removeView(this.n);
                        this.e.setVisibility(4);
                        this.f.addView(this.n, layoutParams);
                    }
                    i().addView(this.f, new LayoutParams(-1, -1));
                } else if (this.j == ViewState.RESIZED && obj != null) {
                    this.f.removeView(this.n);
                    this.e.addView(this.n, layoutParams);
                    this.e.setVisibility(4);
                    this.f.addView(this.o, layoutParams);
                }
                this.f.setLayoutParams(layoutParams);
                a(z);
                a(ViewState.EXPANDED);
            }
        }
    }

    @VisibleForTesting
    void a(boolean z) {
        boolean z2 = true;
        if (z != (!this.f.isCloseVisible())) {
            CloseableLayout closeableLayout = this.f;
            if (z) {
                z2 = false;
            }
            closeableLayout.setCloseVisible(z2);
            if (this.l != null) {
                this.l.useCustomCloseChanged(z);
            }
        }
    }

    @VisibleForTesting
    void a(boolean z, f fVar) {
        if (a(fVar)) {
            this.t = z;
            this.u = fVar;
            if (this.j == ViewState.EXPANDED || this.d == PlacementType.INTERSTITIAL) {
                d();
                return;
            }
            return;
        }
        throw new a("Unable to force orientation to " + fVar);
    }

    @VisibleForTesting
    boolean a(@NonNull ConsoleMessage consoleMessage) {
        return this.m != null ? this.m.onConsoleMessage(consoleMessage) : true;
    }

    @TargetApi(13)
    @VisibleForTesting
    boolean a(f fVar) {
        if (fVar == f.NONE) {
            return true;
        }
        Activity activity = (Activity) this.b.get();
        if (activity == null) {
            return false;
        }
        try {
            ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0);
            int i = activityInfo.screenOrientation;
            if (i != -1) {
                return i == fVar.a();
            }
            boolean bitMaskContainsFlag = Utils.bitMaskContainsFlag(activityInfo.configChanges, 128);
            return VERSION.SDK_INT >= 13 ? bitMaskContainsFlag && Utils.bitMaskContainsFlag(activityInfo.configChanges, c.jk) : bitMaskContainsFlag;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    @VisibleForTesting
    boolean a(@NonNull String str, @NonNull JsResult jsResult) {
        if (this.m != null) {
            return this.m.onJsAlert(str, jsResult);
        }
        jsResult.confirm();
        return true;
    }

    @VisibleForTesting
    void b() {
        a(new Runnable() {
            public void run() {
                MraidBridge b = MraidController.this.q;
                boolean b2 = MraidController.this.v.b(MraidController.this.c);
                boolean a = MraidController.this.v.a(MraidController.this.c);
                MraidController.this.v;
                boolean c = MraidNativeCommandHandler.c(MraidController.this.c);
                MraidController.this.v;
                b.a(b2, a, c, MraidNativeCommandHandler.isStorePictureSupported(MraidController.this.c), MraidController.this.h());
                MraidController.this.q.a(MraidController.this.j);
                MraidController.this.q.a(MraidController.this.d);
                MraidController.this.q.a(MraidController.this.q.c());
                MraidController.this.q.b();
            }
        });
    }

    @VisibleForTesting
    void b(int i) {
        Activity activity = (Activity) this.b.get();
        if (activity == null || !a(this.u)) {
            throw new a("Attempted to lock orientation to unsupported value: " + this.u.name());
        }
        if (this.s == null) {
            this.s = Integer.valueOf(activity.getRequestedOrientation());
        }
        activity.setRequestedOrientation(i);
    }

    @VisibleForTesting
    void b(@NonNull String str) {
        if (this.k != null) {
            this.k.onOpen();
        }
        Builder builder = new Builder();
        if (this.a != null) {
            builder.withDspCreativeId(this.a.getDspCreativeId());
        }
        builder.withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).build().handleUrl(this.c, str);
    }

    @VisibleForTesting
    void c() {
        if (this.n != null && this.j != ViewState.LOADING && this.j != ViewState.HIDDEN) {
            if (this.j == ViewState.EXPANDED || this.d == PlacementType.INTERSTITIAL) {
                e();
            }
            if (this.j == ViewState.RESIZED || this.j == ViewState.EXPANDED) {
                if (!this.q.d() || this.o == null) {
                    this.f.removeView(this.n);
                    this.e.addView(this.n, new LayoutParams(-1, -1));
                    this.e.setVisibility(0);
                } else {
                    this.f.removeView(this.o);
                    this.q.a();
                }
                i().removeView(this.f);
                a(ViewState.DEFAULT);
            } else if (this.j == ViewState.DEFAULT) {
                this.e.setVisibility(4);
                a(ViewState.HIDDEN);
            }
        }
    }

    @VisibleForTesting
    void d() {
        if (this.u != f.NONE) {
            b(this.u.a());
        } else if (this.t) {
            e();
        } else {
            Activity activity = (Activity) this.b.get();
            if (activity == null) {
                throw new a("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
            }
            b(DeviceUtils.getScreenOrientation(activity));
        }
    }

    public void destroy() {
        this.h.a();
        try {
            this.r.unregister();
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
        if (!this.w) {
            pause(true);
        }
        Views.removeFromParent(this.f);
        this.p.a();
        if (this.n != null) {
            this.n.destroy();
            this.n = null;
        }
        this.q.a();
        if (this.o != null) {
            this.o.destroy();
            this.o = null;
        }
    }

    @VisibleForTesting
    void e() {
        Activity activity = (Activity) this.b.get();
        if (!(activity == null || this.s == null)) {
            activity.setRequestedOrientation(this.s.intValue());
        }
        this.s = null;
    }

    @NonNull
    public FrameLayout getAdContainer() {
        return this.e;
    }

    @NonNull
    public Context getContext() {
        return this.c;
    }

    public void loadContent(@NonNull String str) {
        Preconditions.checkState(this.n == null, "loadContent should only be called once");
        this.n = new MraidWebView(this.c);
        this.p.a(this.n);
        this.e.addView(this.n, new LayoutParams(-1, -1));
        this.p.setContentHtml(str);
    }

    public void loadJavascript(@NonNull String str) {
        this.p.a(str);
    }

    public void pause(boolean z) {
        this.w = true;
        if (this.n != null) {
            WebViews.onPause(this.n, z);
        }
        if (this.o != null) {
            WebViews.onPause(this.o, z);
        }
    }

    public void resume() {
        this.w = false;
        if (this.n != null) {
            WebViews.onResume(this.n);
        }
        if (this.o != null) {
            WebViews.onResume(this.o);
        }
    }

    public void setDebugListener(@Nullable MraidWebViewDebugListener mraidWebViewDebugListener) {
        this.m = mraidWebViewDebugListener;
    }

    public void setMraidListener(@Nullable MraidListener mraidListener) {
        this.k = mraidListener;
    }

    public void setUseCustomCloseListener(@Nullable UseCustomCloseListener useCustomCloseListener) {
        this.l = useCustomCloseListener;
    }
}
