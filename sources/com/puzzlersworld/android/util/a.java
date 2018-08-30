package com.puzzlersworld.android.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;
import mobi.androapp.ac.c8700.R;

public class a extends BaseSliderView {
    private ImageView b = null;

    public a(Context context) {
        super(context);
    }

    public View g() {
        View inflate = LayoutInflater.from(f()).inflate(R.layout.androapp_slider_view, null);
        this.b = (ImageView) inflate.findViewById(R.id.daimajia_slider_image);
        TextView textView = (TextView) inflate.findViewById(R.id.description);
        final View findViewById = inflate.findViewById(R.id.loading_bar);
        textView.setText(c());
        textView = (TextView) inflate.findViewById(R.id.info_text);
        if (d() != 0) {
            textView.setText(d() + "/" + e());
        }
        Picasso.a(f()).a(a()).a((int) R.drawable.progress_animation).a(new Target() {
            public void onBitmapFailed(Drawable drawable) {
                Log.d("AndroApp", "Image load Failed");
                a.this.b.setVisibility(4);
                findViewById.setVisibility(4);
            }

            public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
                a.this.b.setImageBitmap(bitmap);
                findViewById.setVisibility(4);
            }

            public void onPrepareLoad(Drawable drawable) {
                a.this.b.setImageDrawable(drawable);
                findViewById.setVisibility(4);
            }
        });
        return inflate;
    }

    public ImageView h() {
        return this.b;
    }
}
