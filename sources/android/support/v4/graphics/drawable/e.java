package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@RequiresApi(19)
class e extends b {
    e(Drawable drawable) {
        super(drawable);
    }

    e(c cVar, Resources resources) {
        super(cVar, resources);
    }

    @NonNull
    c a() {
        return new f(this.b, null);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }
}
