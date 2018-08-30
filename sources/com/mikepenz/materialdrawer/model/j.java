package com.mikepenz.materialdrawer.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView.LayoutParams;
import com.mikepenz.fastadapter.utils.ViewHolderFactory;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.a.c;
import com.mikepenz.materialdrawer.a.d;
import com.mikepenz.materialdrawer.a.e;
import com.mikepenz.materialdrawer.i;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class j extends a<j, l> implements IProfile<j> {
    protected d i;
    protected c j;

    public j() {
        withSelectable(false);
    }

    public j(p pVar) {
        this.i = pVar.j;
        this.c = pVar.c;
        withSelectable(false);
    }

    /* renamed from: a */
    public j withIcon(@DrawableRes int i) {
        this.i = new d(i);
        return this;
    }

    /* renamed from: a */
    public j withIcon(Bitmap bitmap) {
        this.i = new d(bitmap);
        return this;
    }

    /* renamed from: a */
    public j withIcon(Drawable drawable) {
        this.i = new d(drawable);
        return this;
    }

    /* renamed from: a */
    public j withIcon(Uri uri) {
        this.i = new d(uri);
        return this;
    }

    /* renamed from: a */
    public j withIcon(IIcon iIcon) {
        this.i = new d(iIcon);
        return this;
    }

    /* renamed from: a */
    public j withName(String str) {
        return null;
    }

    /* renamed from: a */
    public void bindView(l lVar) {
        if (this.j != null) {
            LayoutParams layoutParams = (LayoutParams) lVar.itemView.getLayoutParams();
            layoutParams.height = this.j.a(lVar.itemView.getContext());
            lVar.itemView.setLayoutParams(layoutParams);
        }
        lVar.itemView.setId(hashCode());
        lVar.itemView.setEnabled(isEnabled());
        com.mikepenz.materialize.b.c.a(getIcon(), lVar.m);
        a(this, lVar.itemView);
    }

    public ViewHolderFactory<l> b() {
        return new k();
    }

    /* renamed from: b */
    public j withEmail(String str) {
        return null;
    }

    /* renamed from: c */
    public j withIcon(String str) {
        this.i = new d(str);
        return this;
    }

    public e getEmail() {
        return null;
    }

    public d getIcon() {
        return this.i;
    }

    @LayoutRes
    public int getLayoutRes() {
        return com.mikepenz.materialdrawer.j.material_drawer_item_mini_profile;
    }

    public e getName() {
        return null;
    }

    public int getType() {
        return i.material_drawer_item_mini_profile;
    }
}
