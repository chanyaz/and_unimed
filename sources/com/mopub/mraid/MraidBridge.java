package com.mopub.mraid;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnext.core.Ad;
import com.mopub.common.AdReport;
import com.mopub.common.AdType;
import com.mopub.common.CloseableLayout.ClosePosition;
import com.mopub.common.Constants;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.VastIconXmlManager;
import com.mopub.mobileads.ViewGestureDetector;
import com.mopub.mobileads.ViewGestureDetector.UserClickListener;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.mobileads.resource.MraidJavascript;
import com.mopub.network.Networking;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONObject;

public class MraidBridge {
    private final AdReport a;
    private final String b;
    @NonNull
    private final PlacementType c;
    @NonNull
    private final MraidNativeCommandHandler d;
    @Nullable
    private MraidBridgeListener e;
    @Nullable
    private MraidWebView f;
    private boolean g;
    private boolean h;
    private final WebViewClient i;

    public interface MraidBridgeListener {
        void onClose();

        boolean onConsoleMessage(@NonNull ConsoleMessage consoleMessage);

        void onExpand(URI uri, boolean z);

        boolean onJsAlert(@NonNull String str, @NonNull JsResult jsResult);

        void onOpen(URI uri);

        void onPageFailedToLoad();

        void onPageLoaded();

        void onPlayVideo(URI uri);

        void onResize(int i, int i2, int i3, int i4, @NonNull ClosePosition closePosition, boolean z);

        void onSetOrientationProperties(boolean z, f fVar);

        void onUseCustomClose(boolean z);

        void onVisibilityChanged(boolean z);
    }

    public class MraidWebView extends BaseWebView {
        @Nullable
        private OnVisibilityChangedListener b;
        private boolean c;

        public interface OnVisibilityChangedListener {
            void onVisibilityChanged(boolean z);
        }

        public MraidWebView(Context context) {
            super(context);
            this.c = getVisibility() == 0;
        }

        public boolean isVisible() {
            return this.c;
        }

        protected void onVisibilityChanged(@NonNull View view, int i) {
            super.onVisibilityChanged(view, i);
            boolean z = i == 0;
            if (z != this.c) {
                this.c = z;
                if (this.b != null) {
                    this.b.onVisibilityChanged(this.c);
                }
            }
        }

        void setVisibilityChangedListener(@Nullable OnVisibilityChangedListener onVisibilityChangedListener) {
            this.b = onVisibilityChangedListener;
        }
    }

    MraidBridge(@Nullable AdReport adReport, @NonNull PlacementType placementType) {
        this(adReport, placementType, new MraidNativeCommandHandler());
    }

    @VisibleForTesting
    MraidBridge(@Nullable AdReport adReport, @NonNull PlacementType placementType, @NonNull MraidNativeCommandHandler mraidNativeCommandHandler) {
        this.b = MraidJavascript.JAVASCRIPT_SOURCE.replaceAll("(?m)^\\s+", "").replaceAll("(?m)^//.*(?=\\n)", "");
        this.i = new WebViewClient() {
            public void onPageFinished(@NonNull WebView webView, @NonNull String str) {
                MraidBridge.this.f();
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                MoPubLog.d("Error: " + str);
                super.onReceivedError(webView, i, str, str2);
            }

            public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull String str) {
                return MraidBridge.this.b(str);
            }
        };
        this.a = adReport;
        this.c = placementType;
        this.d = mraidNativeCommandHandler;
    }

    private int a(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            return i;
        }
        throw new a("Integer parameter out of range: " + i);
    }

    private ClosePosition a(@NonNull String str, @NonNull ClosePosition closePosition) {
        if (TextUtils.isEmpty(str)) {
            return closePosition;
        }
        if (str.equals("top-left")) {
            return ClosePosition.TOP_LEFT;
        }
        if (str.equals("top-right")) {
            return ClosePosition.TOP_RIGHT;
        }
        if (str.equals("center")) {
            return ClosePosition.CENTER;
        }
        if (str.equals("bottom-left")) {
            return ClosePosition.BOTTOM_LEFT;
        }
        if (str.equals("bottom-right")) {
            return ClosePosition.BOTTOM_RIGHT;
        }
        if (str.equals("top-center")) {
            return ClosePosition.TOP_CENTER;
        }
        if (str.equals("bottom-center")) {
            return ClosePosition.BOTTOM_CENTER;
        }
        throw new a("Invalid close position: " + str);
    }

    @NonNull
    private String a(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }

    @NonNull
    private URI a(@Nullable String str, URI uri) {
        return str == null ? uri : f(str);
    }

    private void a(@NonNull MraidJavascriptCommand mraidJavascriptCommand) {
        a("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(mraidJavascriptCommand.a()) + ")");
    }

    private void a(@NonNull MraidJavascriptCommand mraidJavascriptCommand, @NonNull String str) {
        a("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(mraidJavascriptCommand.a()) + ", " + JSONObject.quote(str) + ")");
    }

    private boolean a(@Nullable String str, boolean z) {
        return str == null ? z : e(str);
    }

    @NonNull
    private String b(Rect rect) {
        return rect.width() + "," + rect.height();
    }

    private int c(@NonNull String str) {
        try {
            return Integer.parseInt(str, 10);
        } catch (NumberFormatException e) {
            throw new a("Invalid numeric parameter: " + str);
        }
    }

    private f d(String str) {
        if (Ad.ORIENTATION_PORTRAIT.equals(str)) {
            return f.PORTRAIT;
        }
        if (Ad.ORIENTATION_LANDSCAPE.equals(str)) {
            return f.LANDSCAPE;
        }
        if ("none".equals(str)) {
            return f.NONE;
        }
        throw new a("Invalid orientation: " + str);
    }

    private boolean e(String str) {
        if ("true".equals(str)) {
            return true;
        }
        if ("false".equals(str)) {
            return false;
        }
        throw new a("Invalid boolean parameter: " + str);
    }

    @NonNull
    private URI f(@Nullable String str) {
        if (str == null) {
            throw new a("Parameter cannot be null");
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new a("Invalid URL parameter: " + str);
        }
    }

    @VisibleForTesting
    private void f() {
        if (!this.h) {
            this.h = true;
            if (this.e != null) {
                this.e.onPageLoaded();
            }
        }
    }

    void a() {
        this.f = null;
    }

    void a(@Nullable MraidBridgeListener mraidBridgeListener) {
        this.e = mraidBridgeListener;
    }

    void a(@NonNull MraidWebView mraidWebView) {
        this.f = mraidWebView;
        this.f.getSettings().setJavaScriptEnabled(true);
        if (VERSION.SDK_INT >= 17 && this.c == PlacementType.INTERSTITIAL) {
            mraidWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.f.loadUrl("javascript:" + this.b);
        this.f.setScrollContainer(false);
        this.f.setVerticalScrollBarEnabled(false);
        this.f.setHorizontalScrollBarEnabled(false);
        this.f.setBackgroundColor(CtaButton.BACKGROUND_COLOR);
        this.f.setWebViewClient(this.i);
        this.f.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(@NonNull ConsoleMessage consoleMessage) {
                return MraidBridge.this.e != null ? MraidBridge.this.e.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
            }

            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return MraidBridge.this.e != null ? MraidBridge.this.e.onJsAlert(str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
            }

            public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }
        });
        final ViewGestureDetector viewGestureDetector = new ViewGestureDetector(this.f.getContext(), this.f, this.a);
        viewGestureDetector.setUserClickListener(new UserClickListener() {
            public void onResetUserClick() {
                MraidBridge.this.g = false;
            }

            public void onUserClick() {
                MraidBridge.this.g = true;
            }

            public boolean wasClicked() {
                return MraidBridge.this.g;
            }
        });
        this.f.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                viewGestureDetector.sendTouchEvent(motionEvent);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (!view.hasFocus()) {
                            view.requestFocus();
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        this.f.setVisibilityChangedListener(new OnVisibilityChangedListener() {
            public void onVisibilityChanged(boolean z) {
                if (MraidBridge.this.e != null) {
                    MraidBridge.this.e.onVisibilityChanged(z);
                }
            }
        });
    }

    @VisibleForTesting
    void a(@NonNull final MraidJavascriptCommand mraidJavascriptCommand, @NonNull Map<String, String> map) {
        if (mraidJavascriptCommand.a(this.c) && !this.g) {
            throw new a("Cannot execute this command unless the user clicks");
        } else if (this.e == null) {
            throw new a("Invalid state to execute this command");
        } else if (this.f == null) {
            throw new a("The current WebView is being destroyed");
        } else {
            switch (mraidJavascriptCommand) {
                case CLOSE:
                    this.e.onClose();
                    return;
                case RESIZE:
                    this.e.onResize(a(c((String) map.get(VastIconXmlManager.WIDTH)), 0, 100000), a(c((String) map.get(VastIconXmlManager.HEIGHT)), 0, 100000), a(c((String) map.get("offsetX")), -100000, 100000), a(c((String) map.get("offsetY")), -100000, 100000), a((String) map.get("customClosePosition"), ClosePosition.TOP_RIGHT), a((String) map.get("allowOffscreen"), true));
                    return;
                case EXPAND:
                    this.e.onExpand(a((String) map.get("url"), null), a((String) map.get("shouldUseCustomClose"), false));
                    return;
                case USE_CUSTOM_CLOSE:
                    this.e.onUseCustomClose(a((String) map.get("shouldUseCustomClose"), false));
                    return;
                case OPEN:
                    this.e.onOpen(f((String) map.get("url")));
                    return;
                case SET_ORIENTATION_PROPERTIES:
                    this.e.onSetOrientationProperties(e((String) map.get("allowOrientationChange")), d((String) map.get("forceOrientation")));
                    return;
                case PLAY_VIDEO:
                    this.e.onPlayVideo(f((String) map.get("uri")));
                    return;
                case STORE_PICTURE:
                    this.d.a(this.f.getContext(), f((String) map.get("uri")).toString(), new MraidCommandFailureListener() {
                        public void onFailure(a aVar) {
                            MraidBridge.this.a(mraidJavascriptCommand, aVar.getMessage());
                        }
                    });
                    return;
                case CREATE_CALENDAR_EVENT:
                    this.d.a(this.f.getContext(), (Map) map);
                    return;
                case UNSPECIFIED:
                    throw new a("Unspecified MRAID Javascript command");
                default:
                    return;
            }
        }
    }

    void a(PlacementType placementType) {
        a("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.a()) + ")");
    }

    void a(ViewState viewState) {
        a("mraidbridge.setState(" + JSONObject.quote(viewState.toJavascriptString()) + ")");
    }

    void a(@NonNull String str) {
        if (this.f == null) {
            MoPubLog.d("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
            return;
        }
        MoPubLog.v("Injecting Javascript into MRAID WebView:\n\t" + str);
        this.f.loadUrl("javascript:" + str);
    }

    void a(boolean z) {
        a("mraidbridge.setIsViewable(" + z + ")");
    }

    void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        a("mraidbridge.setSupports(" + z + "," + z2 + "," + z3 + "," + z4 + "," + z5 + ")");
    }

    void b() {
        a("mraidbridge.notifyReadyEvent();");
    }

    @VisibleForTesting
    boolean b(@NonNull String str) {
        try {
            URI uri = new URI(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if ("mopub".equals(scheme)) {
                if ("failLoad".equals(host) && this.c == PlacementType.INLINE && this.e != null) {
                    this.e.onPageFailedToLoad();
                }
                return true;
            } else if (AdType.MRAID.equals(scheme)) {
                Map hashMap = new HashMap();
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(uri, "UTF-8")) {
                    hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
                }
                MraidJavascriptCommand a = MraidJavascriptCommand.a(host);
                try {
                    a(a, hashMap);
                } catch (a e) {
                    a(a, e.getMessage());
                }
                a(a);
                return true;
            } else if (!this.g) {
                return false;
            } else {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.addFlags(268435456);
                try {
                    if (this.f == null) {
                        MoPubLog.d("WebView was detached. Unable to load a URL");
                        return true;
                    }
                    this.f.getContext().startActivity(intent);
                    return true;
                } catch (ActivityNotFoundException e2) {
                    MoPubLog.d("No activity found to handle this URL " + str);
                    return false;
                }
            }
        } catch (URISyntaxException e3) {
            MoPubLog.w("Invalid MRAID URL: " + str);
            a(MraidJavascriptCommand.UNSPECIFIED, "Mraid command sent an invalid URL");
            return true;
        }
    }

    boolean c() {
        return this.f != null && this.f.isVisible();
    }

    boolean d() {
        return this.f != null;
    }

    boolean e() {
        return this.h;
    }

    public void notifyScreenMetrics(@NonNull g gVar) {
        a("mraidbridge.setScreenSize(" + b(gVar.a()) + ");mraidbridge.setMaxSize(" + b(gVar.c()) + ");mraidbridge.setCurrentPosition(" + a(gVar.e()) + ");mraidbridge.setDefaultPosition(" + a(gVar.g()) + ")");
        a("mraidbridge.notifySizeChangeEvent(" + b(gVar.d()) + ")");
    }

    public void setContentHtml(@NonNull String str) {
        if (this.f == null) {
            MoPubLog.d("MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        this.h = false;
        this.f.loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://" + Constants.HOST + "/", str, "text/html", "UTF-8", null);
    }

    public void setContentUrl(String str) {
        if (this.f == null) {
            MoPubLog.d("MRAID bridge called setContentHtml while WebView was not attached");
            return;
        }
        this.h = false;
        this.f.loadUrl(str);
    }
}
