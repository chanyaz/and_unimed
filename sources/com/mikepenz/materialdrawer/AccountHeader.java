package com.mikepenz.materialdrawer;

import android.content.Context;
import android.view.View;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class AccountHeader {
    protected final a a;

    public interface OnAccountHeaderItemLongClickListener {
        boolean onProfileLongClick(View view, IProfile iProfile, boolean z);
    }

    public interface OnAccountHeaderListener {
        boolean onProfileChanged(View view, IProfile iProfile, boolean z);
    }

    public interface OnAccountHeaderProfileImageListener {
        boolean onProfileImageClick(View view, IProfile iProfile, boolean z);

        boolean onProfileImageLongClick(View view, IProfile iProfile, boolean z);
    }

    public interface OnAccountHeaderSelectionViewClickListener {
        boolean onClick(View view, IProfile iProfile);
    }

    protected AccountHeader(a aVar) {
        this.a = aVar;
    }

    public View a() {
        return this.a.U;
    }

    public void a(Context context) {
        this.a.a(context);
    }

    public void a(Drawer drawer) {
        this.a.Y = drawer;
    }

    public IProfile b() {
        return this.a.k;
    }
}
