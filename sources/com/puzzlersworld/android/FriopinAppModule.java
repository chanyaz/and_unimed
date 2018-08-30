package com.puzzlersworld.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.SoundPool;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.p;
import com.puzzlersworld.android.data.a;
import com.puzzlersworld.android.gcm.AndroAppGcmListenerService;
import com.puzzlersworld.android.ui.activity.CartActivity;
import com.puzzlersworld.android.ui.activity.CheckoutActivity;
import com.puzzlersworld.android.ui.activity.CommentsActivity;
import com.puzzlersworld.android.ui.activity.FeedActivity;
import com.puzzlersworld.android.ui.activity.FeedDetailActivity;
import com.puzzlersworld.android.ui.activity.ImageViewFragment;
import com.puzzlersworld.android.ui.activity.LoginActivity;
import com.puzzlersworld.android.ui.activity.LoginFragment;
import com.puzzlersworld.android.ui.activity.RegisterFragment;
import com.puzzlersworld.android.ui.activity.ViewPagerFragement;
import com.puzzlersworld.android.ui.worker.ShareButtonHandler;
import com.puzzlersworld.android.util.FileSave;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.annotations.ForBackground;
import com.puzzlersworld.android.util.annotations.ForUi;
import com.puzzlersworld.android.util.c;
import com.puzzlersworld.android.util.i;
import com.puzzlersworld.android.util.l;
import com.puzzlersworld.android.util.v;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.squareup.otto.ThreadEnforcer;
import com.squareup.otto.b;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.inject.Singleton;
import mobi.androapp.ac.c8700.R;

@Module(injects = {FeedActivity.class, FeedDetailActivity.class, FullscreenActivity.class, AndroAppGcmListenerService.class, CommentsActivity.class, ViewPagerFragement.class, CartActivity.class, CheckoutActivity.class, LoginFragment.class, ImageViewFragment.class, LoginActivity.class, RegisterFragment.class, RestServiceManager.class, i.class, FileSave.class, ShareButtonHandler.class}, library = true)
public class FriopinAppModule {
    public static int SELECT_SOUND_ID;
    private static ObjectMapper mapper;
    private a androAppDbHelper;
    private final Application application;
    private c cookieManager;
    private RestServiceManager restServiceManager = null;
    private SoundPool soundPool;

    static {
        mapper = null;
        mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    public FriopinAppModule(Application application) {
        this.application = application;
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }

    private void initCookieManager() {
        if (this.cookieManager == null) {
            this.cookieManager = new c();
        }
    }

    private void initSoundPool() {
        this.soundPool = new SoundPool(6, 3, 1);
        SELECT_SOUND_ID = this.soundPool.load(this.application, R.raw.select, 1);
    }

    @Provides
    public a provideAndroAppDbHelper() {
        if (this.androAppDbHelper == null) {
            this.androAppDbHelper = new a(this.application);
        }
        return this.androAppDbHelper;
    }

    @Singleton
    @ForBackground
    @Provides
    public ListeningScheduledExecutorService provideBackgroundExecutorService() {
        return p.a(p.a(new ScheduledThreadPoolExecutor(1)));
    }

    @ForBackground
    @Provides
    public ExecutorService provideBackgroundExecutorService(@ForBackground ListeningScheduledExecutorService listeningScheduledExecutorService) {
        return listeningScheduledExecutorService;
    }

    @Provides
    public Context provideContext() {
        return this.application.getApplicationContext();
    }

    @Singleton
    @Provides
    public b provideEventBus() {
        return new b(ThreadEnforcer.a);
    }

    @Provides
    public ObjectMapper provideObjectMapper() {
        return mapper;
    }

    @Singleton
    @Provides
    public i providePermissionCall() {
        return new i();
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences(application.getString(R.string.user_details_file), 0);
    }

    @Provides
    public SoundPool provideSoundPool() {
        if (this.soundPool == null) {
            initSoundPool();
        }
        return this.soundPool;
    }

    @Singleton
    @Provides
    public l provideThreadUtil() {
        return new l();
    }

    @ForUi
    @Singleton
    @Provides
    public ListeningExecutorService provideUiExecutorService(@ForUi ExecutorService executorService) {
        return p.a(executorService);
    }

    @ForUi
    @Singleton
    @Provides
    public ExecutorService provideUiExecutorService(Application application) {
        return new v(application);
    }

    @Provides
    public Activity providesActivity() {
        return InjectibleApplication.j();
    }

    @Provides
    public Application providesApplication() {
        return this.application;
    }

    @Provides
    public c providesCookieManager() {
        initCookieManager();
        return this.cookieManager;
    }

    @Singleton
    @Provides
    public FileSave providesFileSave() {
        return new FileSave();
    }

    @Provides
    public RestServiceManager providesRestServiceManager() {
        if (this.restServiceManager == null) {
            this.restServiceManager = new RestServiceManager(this.application, provideObjectMapper(), providesActivity());
        }
        return this.restServiceManager;
    }
}
