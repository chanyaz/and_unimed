package com.mikepenz.materialdrawer.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.mopub.common.Constants;

public class DrawerImageLoader {
    private static DrawerImageLoader a = null;
    private IDrawerImageLoader b;
    private boolean c = false;

    public interface IDrawerImageLoader {
        void cancel(ImageView imageView);

        Drawable placeholder(Context context);

        Drawable placeholder(Context context, String str);

        void set(ImageView imageView, Uri uri, Drawable drawable);
    }

    public enum Tags {
        PROFILE,
        PROFILE_DRAWER_ITEM,
        ACCOUNT_HEADER
    }

    private DrawerImageLoader(IDrawerImageLoader iDrawerImageLoader) {
        this.b = iDrawerImageLoader;
    }

    public static DrawerImageLoader a() {
        if (a == null) {
            a = new DrawerImageLoader(new a() {
            });
        }
        return a;
    }

    public void a(ImageView imageView) {
        if (this.b != null) {
            this.b.cancel(imageView);
        }
    }

    public boolean a(ImageView imageView, Uri uri, String str) {
        if (!this.c && !Constants.HTTP.equals(uri.getScheme()) && !Constants.HTTPS.equals(uri.getScheme())) {
            return false;
        }
        if (this.b != null) {
            this.b.set(imageView, uri, this.b.placeholder(imageView.getContext(), str));
        }
        return true;
    }

    public IDrawerImageLoader b() {
        return this.b;
    }
}
