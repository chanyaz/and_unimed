package com.puzzlersworld.wp.controller;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.annotations.ForUi;
import com.puzzlersworld.android.util.c;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.a.b;
import com.puzzlersworld.wp.a.d;
import com.puzzlersworld.wp.a.e;
import com.puzzlersworld.wp.service.AndroAppService;
import com.puzzlersworld.wp.service.CartService;
import com.puzzlersworld.wp.service.WooSecureService;
import com.puzzlersworld.wp.service.WpApiService;
import com.puzzlersworld.wp.service.WpCoreService;
import com.puzzlersworld.wp.service.WpJsonService;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;
import okhttp3.aa;
import retrofit2.ak;
import retrofit2.converter.jackson.a;

public class RestServiceManager {
    public static String hostName = null;
    private Activity activity;
    private AndroAppService androAppService = null;
    private String androappNamespace = null;
    private Application application = null;
    private CartService cartService = null;
    @Inject
    public c cookieManager;
    private ObjectMapper mapper = null;
    private String namespace = null;
    @Inject
    g preferences;
    @ForUi
    @Inject
    ListeningExecutorService uiExecutor;
    private WooSecureService wooSecureService = null;
    private WpApiService wpApiService = null;
    private WpCoreService wpCoreService = null;
    private WpJsonService wpJsonService = null;

    public RestServiceManager(Application application, ObjectMapper objectMapper, Activity activity) {
        this.application = application;
        this.mapper = objectMapper;
        this.activity = activity;
        hostName = application.getString(R.string.wp_server_base_path);
        if (!hostName.endsWith("/")) {
            hostName += "/";
        }
        InjectibleApplication.a((Object) this);
        initNameSpace();
    }

    private void initAndroAppService() {
        this.androAppService = (AndroAppService) new ak().a(this.application.getString(R.string.androapp_host)).a(a.a(this.mapper)).a().a(AndroAppService.class);
    }

    private void initCartService() {
        String str = hostName + this.androappNamespace;
        if (str == null || str.length() <= 0) {
            this.cartService = null;
            return;
        }
        this.cartService = (CartService) new ak().a(str).a(new aa().a(new b(this.cookieManager)).a(new d(this.uiExecutor)).a(new e(this.activity)).a()).a(a.a(this.mapper)).a().a(CartService.class);
    }

    private void initNameSpace() {
        this.namespace = this.preferences.a("wp_core_namespace", "");
        this.androappNamespace = this.preferences.a("androapp_namespace", "");
    }

    private void initWpApiService() {
        String str = hostName + this.androappNamespace;
        if (str == null || str.length() <= 0) {
            this.wpApiService = null;
            this.wooSecureService = null;
            return;
        }
        w.c();
        if (this.wpJsonService == null) {
            initWpJsonService();
        }
        this.wpApiService = (WpApiService) new ak().a(str).a(com.puzzlersworld.a.a.a.a(this.mapper)).a().a(WpApiService.class);
        this.wooSecureService = (WooSecureService) new ak().a(str).a(new aa().a(new com.puzzlersworld.wp.a.c()).a(new d(this.uiExecutor)).a()).a(com.puzzlersworld.a.a.a.a(this.mapper)).a().a(WooSecureService.class);
    }

    private void initWpCoreService() {
        String str = hostName + this.namespace;
        if (str != null && str.length() > 0) {
            w.c();
            this.wpCoreService = (WpCoreService) new ak().a(str).a(com.puzzlersworld.a.a.a.a(this.mapper)).a().a(WpCoreService.class);
        }
    }

    private void initWpJsonService() {
        String str = hostName;
        if (str != null && str.length() > 0) {
            w.c();
            this.wpJsonService = (WpJsonService) new ak().a(str).a(com.puzzlersworld.a.a.a.a(this.mapper)).a().a(WpJsonService.class);
        }
    }

    public AndroAppService getAndroAppService() {
        if (this.androAppService == null) {
            initAndroAppService();
        }
        return this.androAppService;
    }

    public String getAndroappNamespace() {
        return this.androappNamespace;
    }

    public CartService getCartService() {
        if (this.cartService == null) {
            initCartService();
        }
        return this.cartService;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public WooSecureService getWooSecureService() {
        if (this.wooSecureService == null) {
            initWpApiService();
        }
        return this.wooSecureService;
    }

    public WpApiService getWpApiService() {
        if (this.wpApiService == null) {
            initWpApiService();
        }
        return this.wpApiService;
    }

    public WpCoreService getWpCoreService() {
        if (this.wpCoreService == null) {
            initWpCoreService();
        }
        return this.wpCoreService;
    }

    public WpJsonService getWpJsonService() {
        if (this.wpJsonService == null) {
            initWpJsonService();
        }
        return this.wpJsonService;
    }

    public void resetNameSpace(String str) {
        setNamespace(str);
        if (str.equals("wp-json/")) {
            setAndroappNamespace(str);
        } else {
            setAndroappNamespace("wp-json/androapp/v2/");
        }
        setWpApiService(null);
        setWpCoreService(null);
        setWooSecureService(null);
        setCartService(null);
        this.preferences.b("wp_core_namespace", this.namespace);
        this.preferences.b("androapp_namespace", this.androappNamespace);
        Log.d("AndroApp", " WP Core NameSpace" + this.preferences.a("wp_core_namespace", ""));
    }

    public void setAndroAppService(AndroAppService androAppService) {
        this.androAppService = androAppService;
    }

    public void setAndroappNamespace(String str) {
        this.androappNamespace = str;
    }

    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public void setWooSecureService(WooSecureService wooSecureService) {
        this.wooSecureService = wooSecureService;
    }

    public void setWpApiService(WpApiService wpApiService) {
        this.wpApiService = wpApiService;
    }

    public void setWpCoreService(WpCoreService wpCoreService) {
        this.wpCoreService = wpCoreService;
    }

    public void setWpJsonService(WpJsonService wpJsonService) {
        this.wpJsonService = wpJsonService;
    }
}
