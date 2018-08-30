package com.appnext.core.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnext.core.g;
import com.mopub.common.Constants;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AppnextWebView {
    public static final int mE = 1;
    public static final int mF = 2;
    private static AppnextWebView mG;
    private WebAppInterface eS;
    private final HashMap<String, b> mH = new HashMap();
    private HashMap<String, WebView> mI;

    public interface c {
        void c(String str);

        void error(String str);
    }

    class WebInterface extends WebAppInterface {
        @JavascriptInterface
        public void destroy(String str) {
            super.destroy(str);
            if (AppnextWebView.mG.eS != null) {
                AppnextWebView.mG.eS.destroy(str);
            }
        }

        @JavascriptInterface
        public String filterAds(String str) {
            super.filterAds(str);
            return AppnextWebView.mG.eS != null ? AppnextWebView.mG.eS.filterAds(str) : str;
        }

        @JavascriptInterface
        public void gotoAppWall() {
            super.gotoAppWall();
            if (AppnextWebView.mG.eS != null) {
                AppnextWebView.mG.eS.gotoAppWall();
            }
        }

        @JavascriptInterface
        public void jsError(String str) {
            super.jsError(str);
            if (AppnextWebView.mG.eS != null) {
                AppnextWebView.mG.eS.jsError(str);
            }
        }

        @JavascriptInterface
        public String loadAds() {
            super.loadAds();
            return AppnextWebView.mG.eS != null ? AppnextWebView.mG.eS.loadAds() : "";
        }

        @JavascriptInterface
        public void notifyImpression(String str) {
            super.notifyImpression(str);
            if (AppnextWebView.mG.eS != null) {
                AppnextWebView.mG.eS.notifyImpression(str);
            }
        }

        @JavascriptInterface
        public void openLink(String str) {
            super.openLink(str);
            if (AppnextWebView.mG.eS != null) {
                AppnextWebView.mG.eS.openLink(str);
            }
        }

        @JavascriptInterface
        public void openStore(String str) {
            super.openStore(str);
            if (AppnextWebView.mG.eS != null) {
                AppnextWebView.mG.eS.openStore(str);
            }
        }

        @JavascriptInterface
        public void play() {
            super.play();
            if (AppnextWebView.mG.eS != null) {
                AppnextWebView.mG.eS.play();
            }
        }

        @JavascriptInterface
        public void postView(String str) {
            super.postView(str);
            if (AppnextWebView.mG.eS != null) {
                AppnextWebView.mG.eS.postView(str);
            }
        }

        @JavascriptInterface
        public void videoPlayed() {
            super.videoPlayed();
            if (AppnextWebView.mG.eS != null) {
                AppnextWebView.mG.eS.videoPlayed();
            }
        }
    }

    class a extends AsyncTask<String, Void, String> {
        b mK;

        public a(b bVar) {
            this.mK = bVar;
        }

        /* renamed from: aU */
        protected void onPostExecute(String str) {
            super.onPostExecute(str);
            if (str.startsWith("error:")) {
                this.mK.state = 0;
                AppnextWebView.this.mH.put(this.mK.bW, this.mK);
                AppnextWebView.this.a(this.mK, str.substring("error: ".length()));
                return;
            }
            this.mK.state = 2;
            AppnextWebView.this.mH.put(this.mK.bW, this.mK);
            AppnextWebView.this.b(this.mK, str);
        }

        /* renamed from: d */
        protected String doInBackground(String... strArr) {
            try {
                b bVar = (b) AppnextWebView.this.mH.get(strArr[0]);
                bVar.mL = g.a(strArr[0], null, 10000);
                AppnextWebView.this.mH.put(strArr[0], bVar);
                return strArr[0];
            } catch (HttpRetryException e) {
                return "error: " + e.getReason();
            } catch (IOException e2) {
                return "error: network problem";
            } catch (Throwable th) {
                return "error: unknown error";
            }
        }
    }

    class b {
        public String bW;
        public String mL;
        public ArrayList<c> mr;
        public int state;

        private b() {
            this.state = 0;
            this.mL = "";
            this.mr = new ArrayList();
        }

        /* synthetic */ b(AppnextWebView appnextWebView, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private AppnextWebView() {
    }

    @SuppressLint({"NewApi"})
    public static AppnextWebView D(Context context) {
        if (mG == null) {
            mG = new AppnextWebView();
            mG.mI = new HashMap();
        }
        return mG;
    }

    @SuppressLint({"SetJavaScriptEnabled", "NewApi", "InlinedApi"})
    private WebView E(Context context) {
        WebView webView = new WebView(context.getApplicationContext());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        if (VERSION.SDK_INT >= 21) {
            webView.getSettings().setMixedContentMode(0);
        }
        if (VERSION.SDK_INT >= 17) {
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str == null) {
                    return false;
                }
                if (!str.startsWith(Constants.HTTP)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                webView.loadUrl(str);
                return true;
            }
        });
        return webView;
    }

    private void a(b bVar, String str) {
        g.X("webview error: " + str);
        synchronized (this.mH) {
            Iterator it = bVar.mr.iterator();
            while (it.hasNext()) {
                ((c) it.next()).error(str);
            }
            bVar.mr.clear();
            this.mH.remove(bVar.bW);
        }
    }

    private void b(b bVar, String str) {
        g.X("downloaded " + str);
        synchronized (this.mH) {
            Iterator it = bVar.mr.iterator();
            while (it.hasNext()) {
                ((c) it.next()).c(str);
            }
            bVar.mr.clear();
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public WebView a(Context context, String str, WebAppInterface webAppInterface, a aVar, String str2) {
        try {
            mG.eS = webAppInterface;
            WebView webView = (WebView) this.mI.get(str2);
            if (!(webView == null || webView.getParent() == null)) {
                ((ViewGroup) webView.getParent()).removeView(webView);
            }
            URL url = new URL(str);
            String str3 = url.getProtocol() + "://" + url.getHost();
            webView = E(context);
            r2 = (this.mH.containsKey(str) && ((b) this.mH.get(str)).state == 2 && !((b) this.mH.get(str)).mL.equals("")) ? "<script>" + ((b) this.mH.get(str)).mL + "</script>" : aVar != null ? "<script>" + aVar.g() + "</script>" : "<script src='" + str + "'></script>";
            webView.loadDataWithBaseURL(str3, "<html><body>" + r2 + "</body></html>", null, "UTF-8", null);
            this.mI.put(str2, webView);
            webView.addJavascriptInterface(new WebInterface(), "Appnext");
            return webView;
        } catch (Throwable th) {
            return null;
        }
    }

    public void a(WebAppInterface webAppInterface) {
        if (this.eS == webAppInterface) {
            this.eS = null;
        }
    }

    public synchronized void a(String str, c cVar) {
        b bVar;
        if (this.mH.containsKey(str)) {
            bVar = (b) this.mH.get(str);
        } else {
            bVar = new b(this, null);
            bVar.bW = str;
        }
        if (bVar.state != 2) {
            if (bVar.state == 0) {
                bVar.state = 1;
                g.X("start loading config");
                new a(bVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str, null});
            }
            if (cVar != null) {
                bVar.mr.add(cVar);
            }
            this.mH.put(str, bVar);
        } else if (cVar != null) {
            cVar.c(str);
        }
    }

    public boolean aV(String str) {
        return this.mI.get(str) != null;
    }

    public WebView aW(String str) {
        WebView webView = (WebView) this.mI.get(str);
        if (!(webView == null || webView.getParent() == null)) {
            ((ViewGroup) webView.getParent()).removeView(webView);
        }
        return webView;
    }

    public String aX(String str) {
        b bVar = (b) this.mH.get(str);
        return (bVar == null || bVar.state != 2) ? null : bVar.mL;
    }

    public void b(WebAppInterface webAppInterface) {
        mG.eS = webAppInterface;
    }
}
