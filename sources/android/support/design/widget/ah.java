package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

public final class ah {
    TabLayout a;
    aj b;
    private Object c;
    private Drawable d;
    private CharSequence e;
    private CharSequence f;
    private int g = -1;
    private View h;

    ah() {
    }

    @NonNull
    public ah a(@LayoutRes int i) {
        return a(LayoutInflater.from(this.b.getContext()).inflate(i, this.b, false));
    }

    @NonNull
    public ah a(@Nullable Drawable drawable) {
        this.d = drawable;
        i();
        return this;
    }

    @NonNull
    public ah a(@Nullable View view) {
        this.h = view;
        i();
        return this;
    }

    @NonNull
    public ah a(@Nullable CharSequence charSequence) {
        this.e = charSequence;
        i();
        return this;
    }

    @NonNull
    public ah a(@Nullable Object obj) {
        this.c = obj;
        return this;
    }

    @Nullable
    public Object a() {
        return this.c;
    }

    @NonNull
    public ah b(@Nullable CharSequence charSequence) {
        this.f = charSequence;
        i();
        return this;
    }

    @Nullable
    public View b() {
        return this.h;
    }

    void b(int i) {
        this.g = i;
    }

    @Nullable
    public Drawable c() {
        return this.d;
    }

    public int d() {
        return this.g;
    }

    @Nullable
    public CharSequence e() {
        return this.e;
    }

    public void f() {
        if (this.a == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        this.a.b(this);
    }

    public boolean g() {
        if (this.a != null) {
            return this.a.getSelectedTabPosition() == this.g;
        } else {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    @Nullable
    public CharSequence h() {
        return this.f;
    }

    void i() {
        if (this.b != null) {
            this.b.b();
        }
    }

    void j() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = -1;
        this.h = null;
    }
}
