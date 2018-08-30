package com.mikepenz.materialdrawer.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v4.content.a;
import android.widget.ImageView;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialize.b.c;
import java.io.FileNotFoundException;

public class d extends c {
    private IIcon a;

    public d(@DrawableRes int i) {
        super(i);
    }

    public d(Bitmap bitmap) {
        super(bitmap);
    }

    public d(Drawable drawable) {
        super(drawable);
    }

    public d(Uri uri) {
        super(uri);
    }

    public d(IIcon iIcon) {
        super((Bitmap) null);
        this.a = iIcon;
    }

    public d(String str) {
        super(str);
    }

    public static Drawable a(d dVar, Context context, int i, boolean z, int i2) {
        return dVar == null ? null : dVar.a(context, i, z, i2);
    }

    public static void a(d dVar, ImageView imageView, int i, boolean z, int i2) {
        if (dVar != null && imageView != null) {
            Drawable a = a(dVar, imageView.getContext(), i, z, i2);
            if (a != null) {
                imageView.setImageDrawable(a);
                imageView.setVisibility(0);
            } else if (dVar.c() != null) {
                imageView.setImageBitmap(dVar.c());
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        } else if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public Drawable a(Context context, int i, boolean z, int i2) {
        Drawable b = b();
        if (this.a != null) {
            b = new com.mikepenz.iconics.d(context, this.a).a(i).i(24).f(i2);
        } else if (d() != -1) {
            b = a.a(context, d());
        } else if (a() != null) {
            try {
                b = Drawable.createFromStream(context.getContentResolver().openInputStream(a()), a().toString());
            } catch (FileNotFoundException e) {
            }
        }
        if (b == null || !z || this.a != null) {
            return b;
        }
        b = b.mutate();
        b.setColorFilter(i, Mode.SRC_IN);
        return b;
    }

    public boolean a(ImageView imageView, String str) {
        if (a() != null) {
            if (!DrawerImageLoader.a().a(imageView, a(), str)) {
                imageView.setImageURI(a());
            }
        } else if (b() != null) {
            imageView.setImageDrawable(b());
        } else if (c() != null) {
            imageView.setImageBitmap(c());
        } else if (d() != -1) {
            imageView.setImageResource(d());
        } else if (this.a != null) {
            imageView.setImageDrawable(new com.mikepenz.iconics.d(imageView.getContext(), this.a).a());
        } else {
            imageView.setImageBitmap(null);
            return false;
        }
        return true;
    }
}
