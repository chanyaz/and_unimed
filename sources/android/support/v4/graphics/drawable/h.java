package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class h extends c {
    h(@Nullable c cVar, @Nullable Resources resources) {
        super(cVar, resources);
    }

    @NonNull
    public Drawable newDrawable(@Nullable Resources resources) {
        return new g(this, resources);
    }
}
