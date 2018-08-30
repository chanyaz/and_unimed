package com.puzzlersworld.android.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.z;
import java.util.ArrayList;
import java.util.List;

class g extends z {
    final /* synthetic */ LoginActivity a;
    private final List<Fragment> b = new ArrayList();
    private final List<String> c = new ArrayList();

    public g(LoginActivity loginActivity, FragmentManager fragmentManager) {
        this.a = loginActivity;
        super(fragmentManager);
    }

    public Fragment a(int i) {
        return (Fragment) this.b.get(i);
    }

    public void a(Fragment fragment, String str) {
        this.b.add(fragment);
        this.c.add(str);
    }

    public int b() {
        return this.b.size();
    }

    public CharSequence c(int i) {
        return (CharSequence) this.c.get(i);
    }
}
