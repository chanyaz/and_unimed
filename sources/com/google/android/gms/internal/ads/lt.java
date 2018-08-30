package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.au;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzadh
@TargetApi(14)
public final class lt extends me implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, SurfaceTextureListener {
    private static final Map<Integer, String> c = new HashMap();
    private final mt d;
    private final boolean e;
    private int f = 0;
    private int g = 0;
    private MediaPlayer h;
    private Uri i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private mr o;
    private boolean p;
    private int q;
    private zzapf r;

    static {
        if (VERSION.SDK_INT >= 17) {
            c.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
            c.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
            c.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
            c.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
            c.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        c.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        c.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        c.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        c.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        c.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        c.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        c.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        c.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        c.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        if (VERSION.SDK_INT >= 19) {
            c.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            c.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public lt(Context context, boolean z, boolean z2, ms msVar, mt mtVar) {
        super(context);
        setSurfaceTextureListener(this);
        this.d = mtVar;
        this.p = z;
        this.e = z2;
        this.d.a(this);
    }

    private final void a(float f) {
        if (this.h != null) {
            try {
                this.h.setVolume(f, f);
                return;
            } catch (IllegalStateException e) {
                return;
            }
        }
        kk.e("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    }

    private final void a(boolean z) {
        hl.a("AdMediaPlayerView release");
        if (this.o != null) {
            this.o.a();
            this.o = null;
        }
        if (this.h != null) {
            this.h.reset();
            this.h.release();
            this.h = null;
            c(0);
            if (z) {
                this.g = 0;
                this.g = 0;
            }
        }
    }

    private final void c(int i) {
        if (i == 3) {
            this.d.c();
            this.b.b();
        } else if (this.f == 3) {
            this.d.d();
            this.b.c();
        }
        this.f = i;
    }

    private final void e() {
        Throwable e;
        String valueOf;
        hl.a("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.i != null && surfaceTexture != null) {
            a(false);
            try {
                SurfaceTexture b;
                au.v();
                this.h = new MediaPlayer();
                this.h.setOnBufferingUpdateListener(this);
                this.h.setOnCompletionListener(this);
                this.h.setOnErrorListener(this);
                this.h.setOnInfoListener(this);
                this.h.setOnPreparedListener(this);
                this.h.setOnVideoSizeChangedListener(this);
                this.l = 0;
                if (this.p) {
                    this.o = new mr(getContext());
                    this.o.a(surfaceTexture, getWidth(), getHeight());
                    this.o.start();
                    b = this.o.b();
                    if (b == null) {
                        this.o.a();
                        this.o = null;
                    }
                    this.h.setDataSource(getContext(), this.i);
                    au.w();
                    this.h.setSurface(new Surface(b));
                    this.h.setAudioStreamType(3);
                    this.h.setScreenOnWhilePlaying(true);
                    this.h.prepareAsync();
                    c(1);
                }
                b = surfaceTexture;
                this.h.setDataSource(getContext(), this.i);
                au.w();
                this.h.setSurface(new Surface(b));
                this.h.setAudioStreamType(3);
                this.h.setScreenOnWhilePlaying(true);
                this.h.prepareAsync();
                c(1);
            } catch (IOException e2) {
                e = e2;
                valueOf = String.valueOf(this.i);
                kk.c(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.h, 1, 0);
            } catch (IllegalArgumentException e3) {
                e = e3;
                valueOf = String.valueOf(this.i);
                kk.c(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.h, 1, 0);
            } catch (IllegalStateException e4) {
                e = e4;
                valueOf = String.valueOf(this.i);
                kk.c(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.h, 1, 0);
            }
        }
    }

    private final void f() {
        if (this.e && g() && this.h.getCurrentPosition() > 0 && this.g != 3) {
            hl.a("AdMediaPlayerView nudging MediaPlayer");
            a(0.0f);
            this.h.start();
            int currentPosition = this.h.getCurrentPosition();
            long currentTimeMillis = au.l().currentTimeMillis();
            while (g() && this.h.getCurrentPosition() == currentPosition) {
                if (au.l().currentTimeMillis() - currentTimeMillis > 250) {
                    break;
                }
            }
            this.h.pause();
            zzst();
        }
    }

    private final boolean g() {
        return (this.h == null || this.f == -1 || this.f == 0 || this.f == 1) ? false : true;
    }

    public final String a() {
        String str = "MediaPlayer";
        String valueOf = String.valueOf(this.p ? " spherical" : "");
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    public final void a(float f, float f2) {
        if (this.o != null) {
            this.o.a(f, f2);
        }
    }

    public final void a(int i) {
        hl.a("AdMediaPlayerView seek " + i);
        if (g()) {
            this.h.seekTo(i);
            this.q = 0;
            return;
        }
        this.q = i;
    }

    public final void a(zzapf zzapf) {
        this.r = zzapf;
    }

    public final void b() {
        hl.a("AdMediaPlayerView stop");
        if (this.h != null) {
            this.h.stop();
            this.h.release();
            this.h = null;
            c(0);
            this.g = 0;
        }
        this.d.b();
    }

    final /* synthetic */ void b(int i) {
        if (this.r != null) {
            this.r.onWindowVisibilityChanged(i);
        }
    }

    public final void c() {
        hl.a("AdMediaPlayerView play");
        if (g()) {
            this.h.start();
            c(3);
            this.a.a();
            ht.a.post(new mc(this));
        }
        this.g = 3;
    }

    public final void d() {
        hl.a("AdMediaPlayerView pause");
        if (g() && this.h.isPlaying()) {
            this.h.pause();
            c(4);
            ht.a.post(new md(this));
        }
        this.g = 4;
    }

    public final int getCurrentPosition() {
        return g() ? this.h.getCurrentPosition() : 0;
    }

    public final int getDuration() {
        return g() ? this.h.getDuration() : -1;
    }

    public final int getVideoHeight() {
        return this.h != null ? this.h.getVideoHeight() : 0;
    }

    public final int getVideoWidth() {
        return this.h != null ? this.h.getVideoWidth() : 0;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.l = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        hl.a("AdMediaPlayerView completion");
        c(5);
        this.g = 5;
        ht.a.post(new lw(this));
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) c.get(Integer.valueOf(i));
        String str2 = (String) c.get(Integer.valueOf(i2));
        kk.e(new StringBuilder((String.valueOf(str).length() + 38) + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer error: ").append(str).append(":").append(str2).toString());
        c(-1);
        this.g = -1;
        ht.a.post(new lx(this, str, str2));
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) c.get(Integer.valueOf(i));
        String str2 = (String) c.get(Integer.valueOf(i2));
        hl.a(new StringBuilder((String.valueOf(str).length() + 37) + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer info: ").append(str).append(":").append(str2).toString());
        return true;
    }

    protected final void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.j, i);
        int defaultSize2 = getDefaultSize(this.k, i2);
        if (this.j > 0 && this.k > 0 && this.o == null) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            defaultSize2 = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.j * defaultSize2 < this.k * size) {
                    defaultSize = (this.j * defaultSize2) / this.k;
                } else if (this.j * defaultSize2 > this.k * size) {
                    defaultSize2 = (this.k * size) / this.j;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.k * size) / this.j;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.j * defaultSize2) / this.k;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i3 = this.j;
                defaultSize = this.k;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i3;
                } else {
                    defaultSize = (this.j * defaultSize2) / this.k;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (this.k * size) / this.j;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (this.o != null) {
            this.o.a(defaultSize, defaultSize2);
        }
        if (VERSION.SDK_INT == 16) {
            if ((this.m > 0 && this.m != defaultSize) || (this.n > 0 && this.n != defaultSize2)) {
                f();
            }
            this.m = defaultSize;
            this.n = defaultSize2;
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        hl.a("AdMediaPlayerView prepared");
        c(2);
        this.d.a();
        ht.a.post(new lv(this));
        this.j = mediaPlayer.getVideoWidth();
        this.k = mediaPlayer.getVideoHeight();
        if (this.q != 0) {
            a(this.q);
        }
        f();
        int i = this.j;
        kk.d("AdMediaPlayerView stream dimensions: " + i + " x " + this.k);
        if (this.g == 3) {
            c();
        }
        zzst();
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        hl.a("AdMediaPlayerView surface created");
        e();
        ht.a.post(new lz(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        hl.a("AdMediaPlayerView surface destroyed");
        if (this.h != null && this.q == 0) {
            this.q = this.h.getCurrentPosition();
        }
        if (this.o != null) {
            this.o.a();
        }
        ht.a.post(new mb(this));
        a(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Object obj = 1;
        hl.a("AdMediaPlayerView surface changed");
        Object obj2 = this.g == 3 ? 1 : null;
        if (!(this.j == i && this.k == i2)) {
            obj = null;
        }
        if (!(this.h == null || obj2 == null || obj == null)) {
            if (this.q != 0) {
                a(this.q);
            }
            c();
        }
        if (this.o != null) {
            this.o.a(i, i2);
        }
        ht.a.post(new ma(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.d.b(this);
        this.a.a(surfaceTexture, this.r);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        hl.a("AdMediaPlayerView size changed: " + i + " x " + i2);
        this.j = mediaPlayer.getVideoWidth();
        this.k = mediaPlayer.getVideoHeight();
        if (this.j != 0 && this.k != 0) {
            requestLayout();
        }
    }

    protected final void onWindowVisibilityChanged(int i) {
        hl.a("AdMediaPlayerView window visibility changed to " + i);
        ht.a.post(new lu(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzhl a = zzhl.a(parse);
        if (a != null) {
            parse = Uri.parse(a.a);
        }
        this.i = parse;
        this.q = 0;
        e();
        requestLayout();
        invalidate();
    }

    public final String toString() {
        String name = getClass().getName();
        String toHexString = Integer.toHexString(hashCode());
        return new StringBuilder((String.valueOf(name).length() + 1) + String.valueOf(toHexString).length()).append(name).append("@").append(toHexString).toString();
    }

    public final void zzst() {
        a(this.b.a());
    }
}
