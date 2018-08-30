package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.dynamic.c;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class anm extends RelativeLayout {
    private static final float[] a = new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    @Nullable
    private AnimationDrawable b;

    public anm(Context context, anj anj, LayoutParams layoutParams) {
        super(context);
        ar.a((Object) anj);
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(a, null, null));
        shapeDrawable.getPaint().setColor(anj.b());
        setLayoutParams(layoutParams);
        au.g().a((View) this, shapeDrawable);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(anj.getText())) {
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-2, -2);
            View textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(anj.getText());
            textView.setTextColor(anj.c());
            textView.setTextSize((float) anj.d());
            akc.a();
            int a = kb.a(context, 4);
            akc.a();
            textView.setPadding(a, 0, kb.a(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        View imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<ann> a2 = anj.a();
        if (a2 != null && a2.size() > 1) {
            this.b = new AnimationDrawable();
            for (ann zzjy : a2) {
                try {
                    this.b.addFrame((Drawable) c.a(zzjy.zzjy()), anj.e());
                } catch (Throwable e) {
                    kk.b("Error while getting drawable.", e);
                }
            }
            au.g().a(imageView, this.b);
        } else if (a2.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) c.a(((ann) a2.get(0)).zzjy()));
            } catch (Throwable e2) {
                kk.b("Error while getting drawable.", e2);
            }
        }
        addView(imageView);
    }

    public final void onAttachedToWindow() {
        if (this.b != null) {
            this.b.start();
        }
        super.onAttachedToWindow();
    }
}
