package com.puzzlersworld.android.gcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.controller.a;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class AndroAppGcmListenerService$$InjectAdapter extends Binding<AndroAppGcmListenerService> implements MembersInjector<AndroAppGcmListenerService>, Provider<AndroAppGcmListenerService> {
    private Binding<a> e;
    private Binding<g> f;
    private Binding<RestServiceManager> g;
    private Binding<FirebaseMessagingService> h;

    public AndroAppGcmListenerService$$InjectAdapter() {
        super("com.puzzlersworld.android.gcm.AndroAppGcmListenerService", "members/com.puzzlersworld.android.gcm.AndroAppGcmListenerService", false, AndroAppGcmListenerService.class);
    }

    /* renamed from: a */
    public AndroAppGcmListenerService get() {
        AndroAppGcmListenerService androAppGcmListenerService = new AndroAppGcmListenerService();
        injectMembers(androAppGcmListenerService);
        return androAppGcmListenerService;
    }

    /* renamed from: a */
    public void injectMembers(AndroAppGcmListenerService androAppGcmListenerService) {
        androAppGcmListenerService.b = (a) this.e.get();
        androAppGcmListenerService.c = (g) this.f.get();
        androAppGcmListenerService.d = (RestServiceManager) this.g.get();
        this.h.injectMembers(androAppGcmListenerService);
    }

    public void a(Linker linker) {
        this.e = linker.a("com.puzzlersworld.wp.controller.FeedDataController", (Object) AndroAppGcmListenerService.class, getClass().getClassLoader());
        this.f = linker.a("com.puzzlersworld.android.util.FriopinPreferences", (Object) AndroAppGcmListenerService.class, getClass().getClassLoader());
        this.g = linker.a("com.puzzlersworld.wp.controller.RestServiceManager", (Object) AndroAppGcmListenerService.class, getClass().getClassLoader());
        Linker linker2 = linker;
        this.h = linker2.a("members/com.google.firebase.messaging.FirebaseMessagingService", AndroAppGcmListenerService.class, getClass().getClassLoader(), false, true);
    }
}
