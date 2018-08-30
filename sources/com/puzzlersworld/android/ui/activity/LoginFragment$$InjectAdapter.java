package com.puzzlersworld.android.ui.activity;

import com.puzzlersworld.android.util.g;
import com.puzzlersworld.wp.controller.RestServiceManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class LoginFragment$$InjectAdapter extends Binding<LoginFragment> implements MembersInjector<LoginFragment>, Provider<LoginFragment> {
    private Binding<RestServiceManager> e;
    private Binding<g> f;

    public LoginFragment$$InjectAdapter() {
        super("com.puzzlersworld.android.ui.activity.LoginFragment", "members/com.puzzlersworld.android.ui.activity.LoginFragment", false, LoginFragment.class);
    }

    /* renamed from: a */
    public LoginFragment get() {
        LoginFragment loginFragment = new LoginFragment();
        injectMembers(loginFragment);
        return loginFragment;
    }

    /* renamed from: a */
    public void injectMembers(LoginFragment loginFragment) {
        loginFragment.a = (RestServiceManager) this.e.get();
        loginFragment.b = (g) this.f.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("com.puzzlersworld.wp.controller.RestServiceManager", (Object) LoginFragment.class, getClass().getClassLoader());
        this.f = linker.a("com.puzzlersworld.android.util.FriopinPreferences", (Object) LoginFragment.class, getClass().getClassLoader());
    }
}
