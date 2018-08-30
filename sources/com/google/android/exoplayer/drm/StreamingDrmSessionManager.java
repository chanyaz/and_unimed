package com.google.android.exoplayer.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.exoplayer.extractor.a.j;
import com.google.android.exoplayer.util.m;
import java.util.HashMap;
import java.util.UUID;

@TargetApi(18)
public class StreamingDrmSessionManager implements DrmSessionManager {
    public static final UUID a = new UUID(-1301668207276963122L, -6645017420763422227L);
    public static final UUID b = new UUID(-7348484286925749626L, -6083546864340672619L);
    final d c;
    final MediaDrmCallback d;
    final f e;
    final UUID f;
    private final Handler g;
    private final EventListener h;
    private final MediaDrm i;
    private final HashMap<String, String> j;
    private HandlerThread k;
    private Handler l;
    private int m;
    private boolean n;
    private int o;
    private MediaCrypto p;
    private Exception q;
    private String r;
    private byte[] s;
    private byte[] t;

    public interface EventListener {
        void onDrmSessionManagerError(Exception exception);
    }

    private void a() {
        if (!this.n) {
            this.n = true;
            this.l.obtainMessage(0, this.i.getProvisionRequest()).sendToTarget();
        }
    }

    private void a(Exception exception) {
        if (exception instanceof NotProvisionedException) {
            a();
        } else {
            b(exception);
        }
    }

    private void a(Object obj) {
        this.n = false;
        if (this.o != 2 && this.o != 3 && this.o != 4) {
            return;
        }
        if (obj instanceof Exception) {
            b((Exception) obj);
            return;
        }
        try {
            this.i.provideProvisionResponse((byte[]) obj);
            if (this.o == 2) {
                a(false);
            } else {
                b();
            }
        } catch (Exception e) {
            b(e);
        }
    }

    private void a(boolean z) {
        try {
            this.t = this.i.openSession();
            this.p = new MediaCrypto(this.f, this.t);
            this.o = 3;
            b();
        } catch (Exception e) {
            if (z) {
                a();
            } else {
                b(e);
            }
        } catch (Exception e2) {
            b(e2);
        }
    }

    private void b() {
        try {
            this.l.obtainMessage(1, this.i.getKeyRequest(this.t, this.s, this.r, 1, this.j)).sendToTarget();
        } catch (Exception e) {
            a(e);
        }
    }

    private void b(final Exception exception) {
        this.q = exception;
        if (!(this.g == null || this.h == null)) {
            this.g.post(new Runnable() {
                public void run() {
                    StreamingDrmSessionManager.this.h.onDrmSessionManagerError(exception);
                }
            });
        }
        if (this.o != 4) {
            this.o = 0;
        }
    }

    private void b(Object obj) {
        if (this.o != 3 && this.o != 4) {
            return;
        }
        if (obj instanceof Exception) {
            a((Exception) obj);
            return;
        }
        try {
            this.i.provideKeyResponse(this.t, (byte[]) obj);
            this.o = 4;
        } catch (Exception e) {
            a(e);
        }
    }

    public final void close() {
        int i = this.m - 1;
        this.m = i;
        if (i == 0) {
            this.o = 1;
            this.n = false;
            this.c.removeCallbacksAndMessages(null);
            this.e.removeCallbacksAndMessages(null);
            this.l.removeCallbacksAndMessages(null);
            this.l = null;
            this.k.quit();
            this.k = null;
            this.s = null;
            this.p = null;
            this.q = null;
            if (this.t != null) {
                this.i.closeSession(this.t);
                this.t = null;
            }
        }
    }

    public final Exception getError() {
        return this.o == 0 ? this.q : null;
    }

    public final MediaCrypto getMediaCrypto() {
        if (this.o == 3 || this.o == 4) {
            return this.p;
        }
        throw new IllegalStateException();
    }

    public final int getState() {
        return this.o;
    }

    public final void open(a aVar) {
        int i = this.m + 1;
        this.m = i;
        if (i == 1) {
            if (this.l == null) {
                this.k = new HandlerThread("DrmRequestHandler");
                this.k.start();
                this.l = new e(this, this.k.getLooper());
            }
            if (this.s == null) {
                this.r = aVar.a;
                this.s = aVar.a(this.f);
                if (this.s == null) {
                    b(new IllegalStateException("Media does not support uuid: " + this.f));
                    return;
                } else if (m.a < 21) {
                    byte[] a = j.a(this.s, a);
                    if (a != null) {
                        this.s = a;
                    }
                }
            }
            this.o = 2;
            a(true);
        }
    }

    public boolean requiresSecureDecoderComponent(String str) {
        if (this.o == 3 || this.o == 4) {
            return this.p.requiresSecureDecoderComponent(str);
        }
        throw new IllegalStateException();
    }
}
