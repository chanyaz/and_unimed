package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class avk extends ald {
    private final Object a = new Object();
    private volatile zzlr b;

    public final float getAspectRatio() {
        throw new RemoteException();
    }

    public final int getPlaybackState() {
        throw new RemoteException();
    }

    public final boolean isClickToExpandEnabled() {
        throw new RemoteException();
    }

    public final boolean isCustomControlsEnabled() {
        throw new RemoteException();
    }

    public final boolean isMuted() {
        throw new RemoteException();
    }

    public final void mute(boolean z) {
        throw new RemoteException();
    }

    public final void pause() {
        throw new RemoteException();
    }

    public final void play() {
        throw new RemoteException();
    }

    public final void zza(zzlr zzlr) {
        synchronized (this.a) {
            this.b = zzlr;
        }
    }

    public final float zzim() {
        throw new RemoteException();
    }

    public final float zzin() {
        throw new RemoteException();
    }

    public final zzlr zzio() {
        zzlr zzlr;
        synchronized (this.a) {
            zzlr = this.b;
        }
        return zzlr;
    }
}
