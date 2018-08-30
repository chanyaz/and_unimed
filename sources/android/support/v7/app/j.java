package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertController.AlertParams;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ListAdapter;

public class j {
    private final AlertParams a;
    private final int b;

    public j(@NonNull Context context) {
        this(context, i.a(context, 0));
    }

    public j(@NonNull Context context, @StyleRes int i) {
        this.a = new AlertParams(new ContextThemeWrapper(context, i.a(context, i)));
        this.b = i;
    }

    @NonNull
    public Context a() {
        return this.a.a;
    }

    public j a(OnKeyListener onKeyListener) {
        this.a.u = onKeyListener;
        return this;
    }

    public j a(@Nullable Drawable drawable) {
        this.a.d = drawable;
        return this;
    }

    public j a(@Nullable View view) {
        this.a.g = view;
        return this;
    }

    public j a(ListAdapter listAdapter, OnClickListener onClickListener) {
        this.a.w = listAdapter;
        this.a.x = onClickListener;
        return this;
    }

    public j a(@Nullable CharSequence charSequence) {
        this.a.f = charSequence;
        return this;
    }

    public i b() {
        i iVar = new i(this.a.a, this.b);
        this.a.a(iVar.a);
        iVar.setCancelable(this.a.r);
        if (this.a.r) {
            iVar.setCanceledOnTouchOutside(true);
        }
        iVar.setOnCancelListener(this.a.s);
        iVar.setOnDismissListener(this.a.t);
        if (this.a.u != null) {
            iVar.setOnKeyListener(this.a.u);
        }
        return iVar;
    }
}
