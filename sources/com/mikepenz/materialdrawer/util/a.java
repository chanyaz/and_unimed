package com.mikepenz.materialdrawer.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import com.mikepenz.materialdrawer.util.DrawerImageLoader.IDrawerImageLoader;

public abstract class a implements IDrawerImageLoader {
    public void cancel(ImageView imageView) {
    }

    public Drawable placeholder(Context context) {
        return b.b(context);
    }

    public Drawable placeholder(Context context, String str) {
        return placeholder(context);
    }

    public void set(ImageView imageView, Uri uri, Drawable drawable) {
        Log.i("MaterialDrawer", "you have not specified a ImageLoader implementation through the DrawerImageLoader.init(IDrawerImageLoader) method");
    }
}
