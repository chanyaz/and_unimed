package com.puzzlersworld.android.ui.activity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puzzlersworld.android.util.g;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class LoginActivity$$InjectAdapter extends Binding<LoginActivity> implements MembersInjector<LoginActivity>, Provider<LoginActivity> {
    private Binding<g> e;
    private Binding<ObjectMapper> f;

    public LoginActivity$$InjectAdapter() {
        super("com.puzzlersworld.android.ui.activity.LoginActivity", "members/com.puzzlersworld.android.ui.activity.LoginActivity", false, LoginActivity.class);
    }

    /* renamed from: a */
    public LoginActivity get() {
        LoginActivity loginActivity = new LoginActivity();
        injectMembers(loginActivity);
        return loginActivity;
    }

    /* renamed from: a */
    public void injectMembers(LoginActivity loginActivity) {
        loginActivity.n = (g) this.e.get();
        loginActivity.o = (ObjectMapper) this.f.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("com.puzzlersworld.android.util.FriopinPreferences", (Object) LoginActivity.class, getClass().getClassLoader());
        this.f = linker.a("com.fasterxml.jackson.databind.ObjectMapper", (Object) LoginActivity.class, getClass().getClassLoader());
    }
}
