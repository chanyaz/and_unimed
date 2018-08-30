package com.google.android.gms.internal.ads;

final class aus implements Runnable {
    private final /* synthetic */ zzanz a;
    private final /* synthetic */ auq b;

    aus(auq auq, zzanz zzanz) {
        this.b = auq;
        this.a = zzanz;
    }

    public final void run() {
        for (zzanz zzanz : this.b.k.keySet()) {
            if (zzanz != this.a) {
                ((aul) this.b.k.get(zzanz)).a();
            }
        }
    }
}
