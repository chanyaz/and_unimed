package com.puzzlersworld.android;

import dagger.internal.Binding;
import dagger.internal.i;
import java.util.Map;

public final class FriopinAppModule$$ModuleAdapter extends i<FriopinAppModule> {
    private static final String[] h = new String[]{"members/com.puzzlersworld.android.ui.activity.FeedActivity", "members/com.puzzlersworld.android.ui.activity.FeedDetailActivity", "members/com.puzzlersworld.android.FullscreenActivity", "members/com.puzzlersworld.android.gcm.AndroAppGcmListenerService", "members/com.puzzlersworld.android.ui.activity.CommentsActivity", "members/com.puzzlersworld.android.ui.activity.ViewPagerFragement", "members/com.puzzlersworld.android.ui.activity.CartActivity", "members/com.puzzlersworld.android.ui.activity.CheckoutActivity", "members/com.puzzlersworld.android.ui.activity.LoginFragment", "members/com.puzzlersworld.android.ui.activity.ImageViewFragment", "members/com.puzzlersworld.android.ui.activity.LoginActivity", "members/com.puzzlersworld.android.ui.activity.RegisterFragment", "members/com.puzzlersworld.wp.controller.RestServiceManager", "members/com.puzzlersworld.android.util.PermissionCall", "members/com.puzzlersworld.android.util.FileSave", "members/com.puzzlersworld.android.ui.worker.ShareButtonHandler"};
    private static final Class<?>[] i = new Class[0];
    private static final Class<?>[] j = new Class[0];

    public FriopinAppModule$$ModuleAdapter() {
        super(FriopinAppModule.class, h, i, false, j, true, true);
    }

    public void a(Map<String, Binding<?>> map, FriopinAppModule friopinAppModule) {
        map.put("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", new b(friopinAppModule));
        map.put("@com.puzzlersworld.android.util.annotations.ForBackground()/java.util.concurrent.ExecutorService", new c(friopinAppModule));
        map.put("@com.puzzlersworld.android.util.annotations.ForUi()/com.google.common.util.concurrent.ListeningExecutorService", new k(friopinAppModule));
        map.put("com.puzzlersworld.wp.controller.RestServiceManager", new q(friopinAppModule));
        map.put("com.puzzlersworld.android.util.CookieManager", new o(friopinAppModule));
        map.put("@com.puzzlersworld.android.util.annotations.ForUi()/java.util.concurrent.ExecutorService", new l(friopinAppModule));
        map.put("android.app.Activity", new m(friopinAppModule));
        map.put("android.content.Context", new d(friopinAppModule));
        map.put("android.app.Application", new n(friopinAppModule));
        map.put("com.puzzlersworld.android.util.FileSave", new p(friopinAppModule));
        map.put("android.content.SharedPreferences", new h(friopinAppModule));
        map.put("com.fasterxml.jackson.databind.ObjectMapper", new f(friopinAppModule));
        map.put("com.puzzlersworld.android.util.ThreadUtil", new j(friopinAppModule));
        map.put("com.puzzlersworld.android.util.PermissionCall", new g(friopinAppModule));
        map.put("com.squareup.otto.Bus", new e(friopinAppModule));
        map.put("com.puzzlersworld.android.data.AndroAppDbHelper", new a(friopinAppModule));
        map.put("android.media.SoundPool", new i(friopinAppModule));
    }
}
