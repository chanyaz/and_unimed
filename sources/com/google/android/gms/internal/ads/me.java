package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@zzadh
@TargetApi(14)
public abstract class me extends TextureView implements zzaqa {
    protected final mn a = new mn();
    protected final mv b;

    public me(Context context) {
        super(context);
        this.b = new mv(context, this);
    }

    public abstract String a();

    public abstract void a(float f, float f2);

    public abstract void a(int i);

    public abstract void a(zzapf zzapf);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void setVideoPath(String str);

    public abstract void zzst();
}
