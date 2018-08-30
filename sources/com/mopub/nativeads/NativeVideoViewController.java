package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.nativeads.NativeFullScreenVideoView.Mode;
import com.mopub.nativeads.NativeVideoController.Listener;
import com.mopub.nativeads.NativeVideoController.NativeVideoProgressRunnable.ProgressListener;

@TargetApi(16)
public class NativeVideoViewController extends BaseVideoViewController implements OnAudioFocusChangeListener, SurfaceTextureListener, Listener {
    @NonNull
    public static final String NATIVE_VAST_VIDEO_CONFIG = "native_vast_video_config";
    @NonNull
    public static final String NATIVE_VIDEO_ID = "native_video_id";
    @NonNull
    private q a;
    @NonNull
    private VastVideoConfig b;
    @NonNull
    private final NativeFullScreenVideoView c;
    @NonNull
    private final NativeVideoController d;
    @Nullable
    private Bitmap e;
    private boolean f;
    private boolean g;
    private int h;

    public NativeVideoViewController(@NonNull Context context, @NonNull Bundle bundle, @NonNull Bundle bundle2, @NonNull BaseVideoViewControllerListener baseVideoViewControllerListener) {
        this(context, bundle, bundle2, baseVideoViewControllerListener, new NativeFullScreenVideoView(context, context.getResources().getConfiguration().orientation, ((VastVideoConfig) bundle.get(NATIVE_VAST_VIDEO_CONFIG)).getCustomCtaText()));
    }

    @VisibleForTesting
    NativeVideoViewController(@NonNull Context context, @NonNull Bundle bundle, @NonNull Bundle bundle2, @NonNull BaseVideoViewControllerListener baseVideoViewControllerListener, @NonNull NativeFullScreenVideoView nativeFullScreenVideoView) {
        super(context, null, baseVideoViewControllerListener);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotNull(baseVideoViewControllerListener);
        Preconditions.checkNotNull(nativeFullScreenVideoView);
        this.a = q.NONE;
        this.b = (VastVideoConfig) bundle.get(NATIVE_VAST_VIDEO_CONFIG);
        this.c = nativeFullScreenVideoView;
        this.d = NativeVideoController.getForId(((Long) bundle.get(NATIVE_VIDEO_ID)).longValue());
        Preconditions.checkNotNull(this.b);
        Preconditions.checkNotNull(this.d);
    }

    private void i() {
        q qVar = this.a;
        if (this.g) {
            qVar = q.FAILED_LOAD;
        } else if (this.f) {
            qVar = q.ENDED;
        } else if (this.h == 2 || this.h == 1) {
            qVar = q.LOADING;
        } else if (this.h == 3) {
            qVar = q.BUFFERING;
        } else if (this.h == 4) {
            qVar = q.PLAYING;
        } else if (this.h == 5 || this.h == 6) {
            qVar = q.ENDED;
        }
        a(qVar);
    }

    protected void a() {
        this.c.setSurfaceTextureListener(this);
        this.c.setMode(Mode.LOADING);
        this.c.setPlayControlClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (NativeVideoViewController.this.f) {
                    NativeVideoViewController.this.f = false;
                    NativeVideoViewController.this.c.resetProgress();
                    NativeVideoViewController.this.d.seekTo(0);
                }
                NativeVideoViewController.this.a(q.PLAYING);
            }
        });
        this.c.setCloseControlListener(new OnClickListener() {
            public void onClick(View view) {
                NativeVideoViewController.this.a(q.PAUSED, true);
                NativeVideoViewController.this.b().onFinish();
            }
        });
        this.c.setCtaClickListener(new OnClickListener() {
            public void onClick(View view) {
                NativeVideoViewController.this.d.setPlayWhenReady(false);
                NativeVideoViewController.this.e = NativeVideoViewController.this.c.getTextureView().getBitmap();
                NativeVideoViewController.this.d.handleCtaClick((Activity) NativeVideoViewController.this.f());
            }
        });
        this.c.setPrivacyInformationClickListener(new OnClickListener() {
            public void onClick(View view) {
                NativeVideoViewController.this.d.setPlayWhenReady(false);
                NativeVideoViewController.this.e = NativeVideoViewController.this.c.getTextureView().getBitmap();
                new Builder().withSupportedUrlActions(UrlAction.OPEN_IN_APP_BROWSER, new UrlAction[0]).build().handleUrl(NativeVideoViewController.this.f(), "https://www.mopub.com/optout/");
            }
        });
        this.c.setLayoutParams(new LayoutParams(-1, -1));
        b().onSetContentView(this.c);
        this.d.setProgressListener(new ProgressListener() {
            public void updateProgress(int i) {
                NativeVideoViewController.this.c.updateProgress(i);
            }
        });
    }

    protected void a(Configuration configuration) {
        this.c.setOrientation(configuration.orientation);
    }

    protected void a(@NonNull Bundle bundle) {
    }

    @VisibleForTesting
    void a(@NonNull q qVar) {
        a(qVar, false);
    }

    @VisibleForTesting
    void a(@NonNull q qVar, boolean z) {
        Preconditions.checkNotNull(qVar);
        if (this.a != qVar) {
            switch (qVar) {
                case FAILED_LOAD:
                    this.d.setPlayWhenReady(false);
                    this.d.setAudioEnabled(false);
                    this.d.setAppAudioEnabled(false);
                    this.c.setMode(Mode.LOADING);
                    this.b.handleError(f(), null, 0);
                    break;
                case LOADING:
                case BUFFERING:
                    this.d.setPlayWhenReady(true);
                    this.c.setMode(Mode.LOADING);
                    break;
                case PLAYING:
                    this.d.setPlayWhenReady(true);
                    this.d.setAudioEnabled(true);
                    this.d.setAppAudioEnabled(true);
                    this.c.setMode(Mode.PLAYING);
                    break;
                case PAUSED:
                    if (!z) {
                        this.d.setAppAudioEnabled(false);
                    }
                    this.d.setPlayWhenReady(false);
                    this.c.setMode(Mode.PAUSED);
                    break;
                case ENDED:
                    this.f = true;
                    this.d.setAppAudioEnabled(false);
                    this.c.updateProgress(1000);
                    this.c.setMode(Mode.FINISHED);
                    this.b.handleComplete(f(), 0);
                    break;
            }
            this.a = qVar;
        }
    }

    protected VideoView b() {
        return null;
    }

    protected void c() {
    }

    protected void d() {
        if (this.e != null) {
            this.c.setCachedVideoFrame(this.e);
        }
        this.d.prepare(this);
        this.d.setListener(this);
        this.d.setOnAudioFocusChangeListener(this);
    }

    protected void e() {
    }

    protected void f() {
        a(q.PAUSED, true);
    }

    public void onAudioFocusChange(int i) {
        if (i == -1 || i == -2) {
            a(q.PAUSED);
        } else if (i == -3) {
            this.d.setAudioVolume(0.3f);
        } else if (i == 1) {
            this.d.setAudioVolume(1.0f);
            i();
        }
    }

    public void onError(Exception exception) {
        MoPubLog.w("Error playing back video.", exception);
        this.g = true;
        i();
    }

    public void onStateChanged(boolean z, int i) {
        this.h = i;
        i();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.d.setTextureView(this.c.getTextureView());
        if (!this.f) {
            this.d.seekTo(this.d.getCurrentPosition());
        }
        this.d.setPlayWhenReady(!this.f);
        if (this.d.getDuration() - this.d.getCurrentPosition() < 750) {
            this.f = true;
            i();
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.d.release(this);
        a(q.PAUSED);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
