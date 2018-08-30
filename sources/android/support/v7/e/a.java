package android.support.v7.e;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

@RestrictTo({Scope.LIBRARY_GROUP})
public class a implements TransformationMethod {
    private Locale a;

    public a(Context context) {
        this.a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return charSequence != null ? charSequence.toString().toUpperCase(this.a) : null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
