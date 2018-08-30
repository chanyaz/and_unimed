package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v7.a.k;
import android.util.AttributeSet;
import android.widget.TextView;

@RequiresApi(17)
class ae extends ad {
    private cz b;
    private cz c;

    ae(TextView textView) {
        super(textView);
    }

    void a() {
        super.a();
        if (this.b != null || this.c != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.b);
            a(compoundDrawablesRelative[2], this.c);
        }
    }

    void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        Context context = this.a.getContext();
        AppCompatDrawableManager a = AppCompatDrawableManager.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.AppCompatTextHelper, i, 0);
        if (obtainStyledAttributes.hasValue(k.AppCompatTextHelper_android_drawableStart)) {
            this.b = ad.a(context, a, obtainStyledAttributes.getResourceId(k.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (obtainStyledAttributes.hasValue(k.AppCompatTextHelper_android_drawableEnd)) {
            this.c = ad.a(context, a, obtainStyledAttributes.getResourceId(k.AppCompatTextHelper_android_drawableEnd, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
