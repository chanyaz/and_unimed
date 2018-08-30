package android.support.v4.view;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

class p extends SingleLineTransformationMethod {
    private Locale a;

    p(Context context) {
        this.a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        CharSequence transformation = super.getTransformation(charSequence, view);
        return transformation != null ? transformation.toString().toUpperCase(this.a) : null;
    }
}
