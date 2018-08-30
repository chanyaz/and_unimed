package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.util.Pair;
import com.mikepenz.fastadapter.utils.ViewHolderFactory;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.a.b;
import com.mikepenz.materialdrawer.a.d;
import com.mikepenz.materialdrawer.a.e;
import com.mikepenz.materialdrawer.f;
import com.mikepenz.materialdrawer.i;
import com.mikepenz.materialdrawer.j;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Tagable;
import com.mikepenz.materialdrawer.model.interfaces.Typefaceable;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader.Tags;
import com.mikepenz.materialize.b.a;
import com.mikepenz.materialize.b.c;

public class p extends a<p, r> implements IProfile<p>, Tagable<p>, Typefaceable<p> {
    protected boolean i = false;
    protected d j;
    protected e k;
    protected e l;
    protected b m;
    protected b n;
    protected b o;
    protected b p;
    protected Typeface q = null;
    protected Pair<Integer, ColorStateList> r;

    protected int a(Context context) {
        return isEnabled() ? a.a(d(), context, com.mikepenz.materialdrawer.e.material_drawer_primary_text, f.material_drawer_primary_text) : a.a(f(), context, com.mikepenz.materialdrawer.e.material_drawer_hint_text, f.material_drawer_hint_text);
    }

    protected ColorStateList a(@ColorInt int i, @ColorInt int i2) {
        if (this.r == null || i + i2 != ((Integer) this.r.first).intValue()) {
            this.r = new Pair(Integer.valueOf(i + i2), com.mikepenz.materialdrawer.util.b.a(i, i2));
        }
        return (ColorStateList) this.r.second;
    }

    /* renamed from: a */
    public p withIcon(@DrawableRes int i) {
        this.j = new d(i);
        return this;
    }

    /* renamed from: a */
    public p withIcon(Bitmap bitmap) {
        this.j = new d(bitmap);
        return this;
    }

    /* renamed from: a */
    public p withTypeface(Typeface typeface) {
        this.q = typeface;
        return this;
    }

    /* renamed from: a */
    public p withIcon(Drawable drawable) {
        this.j = new d(drawable);
        return this;
    }

    /* renamed from: a */
    public p withIcon(Uri uri) {
        this.j = new d(uri);
        return this;
    }

    /* renamed from: a */
    public p withIcon(IIcon iIcon) {
        this.j = new d(iIcon);
        return this;
    }

    /* renamed from: a */
    public p withIcon(String str) {
        this.j = new d(str);
        return this;
    }

    /* renamed from: a */
    public void bindView(r rVar) {
        Context context = rVar.itemView.getContext();
        rVar.itemView.setId(hashCode());
        rVar.itemView.setEnabled(isEnabled());
        rVar.itemView.setSelected(isSelected());
        int a = a.a(c(), context, com.mikepenz.materialdrawer.e.material_drawer_selected, f.material_drawer_selected);
        int a2 = a(context);
        int b = b(context);
        com.mikepenz.materialize.c.b.a(rVar.m, com.mikepenz.materialize.c.b.a(context, a, true));
        if (this.i) {
            rVar.o.setVisibility(0);
            com.mikepenz.materialize.b.d.a(getName(), rVar.o);
        } else {
            rVar.o.setVisibility(8);
        }
        if (this.i || getEmail() != null || getName() == null) {
            com.mikepenz.materialize.b.d.a(getEmail(), rVar.p);
        } else {
            com.mikepenz.materialize.b.d.a(getName(), rVar.p);
        }
        if (getTypeface() != null) {
            rVar.o.setTypeface(getTypeface());
            rVar.p.setTypeface(getTypeface());
        }
        if (this.i) {
            rVar.o.setTextColor(a(a2, b));
        }
        rVar.p.setTextColor(a(a2, b));
        DrawerImageLoader.a().a(rVar.n);
        c.b(getIcon(), rVar.n, Tags.PROFILE_DRAWER_ITEM.name());
        com.mikepenz.materialdrawer.util.b.a(rVar.m);
        a(this, rVar.itemView);
    }

    protected int b(Context context) {
        return a.a(e(), context, com.mikepenz.materialdrawer.e.material_drawer_selected_text, f.material_drawer_selected_text);
    }

    public ViewHolderFactory<r> b() {
        return new q();
    }

    /* renamed from: b */
    public p withName(String str) {
        this.k = new e(str);
        return this;
    }

    public b c() {
        return this.m;
    }

    /* renamed from: c */
    public p withEmail(String str) {
        this.l = new e(str);
        return this;
    }

    public b d() {
        return this.n;
    }

    public b e() {
        return this.o;
    }

    public b f() {
        return this.p;
    }

    public e getEmail() {
        return this.l;
    }

    public d getIcon() {
        return this.j;
    }

    @LayoutRes
    public int getLayoutRes() {
        return j.material_drawer_item_profile;
    }

    public e getName() {
        return this.k;
    }

    public int getType() {
        return i.material_drawer_item_profile;
    }

    public Typeface getTypeface() {
        return this.q;
    }
}
