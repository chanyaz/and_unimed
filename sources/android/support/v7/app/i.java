package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.a.b;
import android.util.TypedValue;
import android.view.KeyEvent;

public class i extends y implements DialogInterface {
    final AlertController a = new AlertController(getContext(), this, getWindow());

    protected i(@NonNull Context context, @StyleRes int i) {
        super(context, a(context, i));
    }

    static int a(@NonNull Context context, @StyleRes int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.a.a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.a.b(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.a(charSequence);
    }
}
