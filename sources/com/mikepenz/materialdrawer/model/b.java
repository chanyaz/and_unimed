package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.StringRes;
import android.support.v7.widget.ce;
import android.util.Pair;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.a.d;
import com.mikepenz.materialdrawer.a.e;
import com.mikepenz.materialdrawer.f;
import com.mikepenz.materialdrawer.model.interfaces.Iconable;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.model.interfaces.Tagable;
import com.mikepenz.materialdrawer.model.interfaces.Typefaceable;
import com.mikepenz.materialize.b.a;

public abstract class b<T, VH extends ce> extends a<T, VH> implements Iconable<T>, Nameable<T>, Tagable<T>, Typefaceable<T> {
    protected d i;
    protected d j;
    protected e k;
    protected boolean l = false;
    protected com.mikepenz.materialdrawer.a.b m;
    protected com.mikepenz.materialdrawer.a.b n;
    protected com.mikepenz.materialdrawer.a.b o;
    protected com.mikepenz.materialdrawer.a.b p;
    protected com.mikepenz.materialdrawer.a.b q;
    protected com.mikepenz.materialdrawer.a.b r;
    protected com.mikepenz.materialdrawer.a.b s;
    protected Typeface t = null;
    protected Pair<Integer, ColorStateList> u;
    protected int v = 1;

    protected int a(Context context) {
        return a.a(c(), context, com.mikepenz.materialdrawer.e.material_drawer_selected, f.material_drawer_selected);
    }

    protected ColorStateList a(@ColorInt int i, @ColorInt int i2) {
        if (this.u == null || i + i2 != ((Integer) this.u.first).intValue()) {
            this.u = new Pair(Integer.valueOf(i + i2), com.mikepenz.materialdrawer.util.b.a(i, i2));
        }
        return (ColorStateList) this.u.second;
    }

    public T a(@ColorInt int i) {
        this.m = com.mikepenz.materialdrawer.a.b.a(i);
        return this;
    }

    public T a(boolean z) {
        this.l = z;
        return this;
    }

    protected int b(Context context) {
        return isEnabled() ? a.a(d(), context, com.mikepenz.materialdrawer.e.material_drawer_primary_text, f.material_drawer_primary_text) : a.a(f(), context, com.mikepenz.materialdrawer.e.material_drawer_hint_text, f.material_drawer_hint_text);
    }

    public T b(@ColorInt int i) {
        this.n = com.mikepenz.materialdrawer.a.b.a(i);
        return this;
    }

    protected int c(Context context) {
        return a.a(e(), context, com.mikepenz.materialdrawer.e.material_drawer_selected_text, f.material_drawer_selected_text);
    }

    public com.mikepenz.materialdrawer.a.b c() {
        return this.m;
    }

    public T c(@ColorInt int i) {
        this.o = com.mikepenz.materialdrawer.a.b.a(i);
        return this;
    }

    public int d(Context context) {
        return isEnabled() ? a.a(k(), context, com.mikepenz.materialdrawer.e.material_drawer_primary_icon, f.material_drawer_primary_icon) : a.a(i(), context, com.mikepenz.materialdrawer.e.material_drawer_hint_icon, f.material_drawer_hint_icon);
    }

    public com.mikepenz.materialdrawer.a.b d() {
        return this.n;
    }

    public T d(@ColorInt int i) {
        this.q = com.mikepenz.materialdrawer.a.b.a(i);
        return this;
    }

    protected int e(Context context) {
        return a.a(j(), context, com.mikepenz.materialdrawer.e.material_drawer_selected_text, f.material_drawer_selected_text);
    }

    public com.mikepenz.materialdrawer.a.b e() {
        return this.o;
    }

    public T e(int i) {
        this.v = i;
        return this;
    }

    public com.mikepenz.materialdrawer.a.b f() {
        return this.p;
    }

    public boolean g() {
        return this.l;
    }

    public d getIcon() {
        return this.i;
    }

    public e getName() {
        return this.k;
    }

    public Typeface getTypeface() {
        return this.t;
    }

    public d h() {
        return this.j;
    }

    public com.mikepenz.materialdrawer.a.b i() {
        return this.s;
    }

    public com.mikepenz.materialdrawer.a.b j() {
        return this.r;
    }

    public com.mikepenz.materialdrawer.a.b k() {
        return this.q;
    }

    public int l() {
        return this.v;
    }

    public T withIcon(Drawable drawable) {
        this.i = new d(drawable);
        return this;
    }

    public T withIcon(IIcon iIcon) {
        this.i = new d(iIcon);
        if (VERSION.SDK_INT >= 21) {
            this.j = new d(iIcon);
        } else {
            a(true);
        }
        return this;
    }

    public T withIcon(d dVar) {
        this.i = dVar;
        return this;
    }

    public T withName(@StringRes int i) {
        this.k = new e(i);
        return this;
    }

    public T withName(e eVar) {
        this.k = eVar;
        return this;
    }

    public T withName(String str) {
        this.k = new e(str);
        return this;
    }

    public T withTypeface(Typeface typeface) {
        this.t = typeface;
        return this;
    }
}
