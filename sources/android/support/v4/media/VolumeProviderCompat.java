package android.support.v4.media;

import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.media.VolumeProviderCompatApi21.Delegate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {
    private final int a;
    private final int b;
    private int c;
    private Object d;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public Object a() {
        if (this.d == null && VERSION.SDK_INT >= 21) {
            this.d = VolumeProviderCompatApi21.a(this.a, this.b, this.c, new Delegate() {
                public void onAdjustVolume(int i) {
                    VolumeProviderCompat.this.b(i);
                }

                public void onSetVolumeTo(int i) {
                    VolumeProviderCompat.this.a(i);
                }
            });
        }
        return this.d;
    }

    public void a(int i) {
    }

    public void b(int i) {
    }
}
