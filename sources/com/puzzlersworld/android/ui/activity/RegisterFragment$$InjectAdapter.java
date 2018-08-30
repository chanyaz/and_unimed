package com.puzzlersworld.android.ui.activity;

import com.puzzlersworld.android.util.g;
import com.puzzlersworld.wp.controller.RestServiceManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class RegisterFragment$$InjectAdapter extends Binding<RegisterFragment> implements MembersInjector<RegisterFragment>, Provider<RegisterFragment> {
    private Binding<RestServiceManager> e;
    private Binding<g> f;

    public RegisterFragment$$InjectAdapter() {
        super("com.puzzlersworld.android.ui.activity.RegisterFragment", "members/com.puzzlersworld.android.ui.activity.RegisterFragment", false, RegisterFragment.class);
    }

    /* renamed from: a */
    public RegisterFragment get() {
        RegisterFragment registerFragment = new RegisterFragment();
        injectMembers(registerFragment);
        return registerFragment;
    }

    /* renamed from: a */
    public void injectMembers(RegisterFragment registerFragment) {
        registerFragment.a = (RestServiceManager) this.e.get();
        registerFragment.b = (g) this.f.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("com.puzzlersworld.wp.controller.RestServiceManager", (Object) RegisterFragment.class, getClass().getClassLoader());
        this.f = linker.a("com.puzzlersworld.android.util.FriopinPreferences", (Object) RegisterFragment.class, getClass().getClassLoader());
    }
}
