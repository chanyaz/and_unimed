package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;

@zzadh
@TargetApi(14)
public final class mv implements OnAudioFocusChangeListener {
    private final AudioManager a;
    private final zzaqa b;
    private boolean c;
    private boolean d;
    private boolean e;
    private float f = 1.0f;

    public mv(Context context, zzaqa zzaqa) {
        this.a = (AudioManager) context.getSystemService("audio");
        this.b = zzaqa;
    }

    private final void d() {
        boolean z = true;
        boolean z2 = this.d && !this.e && this.f > 0.0f;
        if (z2 && !this.c) {
            if (!(this.a == null || this.c)) {
                if (this.a.requestAudioFocus(this, 3, 2) != 1) {
                    z = false;
                }
                this.c = z;
            }
            this.b.zzst();
        } else if (!z2 && this.c) {
            if (this.a != null && this.c) {
                if (this.a.abandonAudioFocus(this) != 0) {
                    z = false;
                }
                this.c = z;
            }
            this.b.zzst();
        }
    }

    public final float a() {
        return this.c ? this.e ? 0.0f : this.f : 0.0f;
    }

    public final void a(float f) {
        this.f = f;
        d();
    }

    public final void a(boolean z) {
        this.e = z;
        d();
    }

    public final void b() {
        this.d = true;
        d();
    }

    public final void c() {
        this.d = false;
        d();
    }

    public final void onAudioFocusChange(int i) {
        this.c = i > 0;
        this.b.zzst();
    }
}
