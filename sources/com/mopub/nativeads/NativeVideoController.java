package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.extractor.ExtractorSampleSource;
import com.google.android.exoplayer.extractor.a.h;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.d;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent.Category;
import com.mopub.common.event.BaseEvent.Name;
import com.mopub.common.event.BaseEvent.SamplingRate;
import com.mopub.common.event.Event;
import com.mopub.common.event.EventDetails;
import com.mopub.common.event.MoPubEvents;
import com.mopub.mobileads.RepeatingHandlerRunnable;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.network.TrackingRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(16)
public class NativeVideoController implements OnAudioFocusChangeListener, com.google.android.exoplayer.ExoPlayer.Listener {
    public static final long RESUME_FINISHED_THRESHOLD = 750;
    public static final int STATE_BUFFERING = 3;
    public static final int STATE_CLEARED = 6;
    public static final int STATE_ENDED = 5;
    public static final int STATE_IDLE = 1;
    public static final int STATE_PREPARING = 2;
    public static final int STATE_READY = 4;
    @NonNull
    private static final Map<Long, NativeVideoController> a = new HashMap(4);
    @NonNull
    private final Context b;
    @NonNull
    private final Handler c;
    @NonNull
    private final p d;
    @NonNull
    private VastVideoConfig e;
    @NonNull
    private NativeVideoProgressRunnable f;
    @NonNull
    private AudioManager g;
    @Nullable
    private Listener h;
    @Nullable
    private OnAudioFocusChangeListener i;
    @Nullable
    private Surface j;
    @Nullable
    private TextureView k;
    @Nullable
    private WeakReference<Object> l;
    @Nullable
    private volatile ExoPlayer m;
    @Nullable
    private BitmapDrawable n;
    @Nullable
    private MediaCodecAudioTrackRenderer o;
    @Nullable
    private MediaCodecVideoTrackRenderer p;
    @Nullable
    private EventDetails q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private boolean v;

    public interface Listener {
        void onError(Exception exception);

        void onStateChanged(boolean z, int i);
    }

    class NativeVideoProgressRunnable extends RepeatingHandlerRunnable {
        @NonNull
        private final Context c;
        @NonNull
        private final y d;
        @NonNull
        private final List<VisibilityTrackingEvent> e;
        @NonNull
        private final VastVideoConfig f;
        @Nullable
        private ExoPlayer g;
        @Nullable
        private TextureView h;
        @Nullable
        private ProgressListener i;
        private long j;
        private long k;
        private boolean l;

        public interface ProgressListener {
            void updateProgress(int i);
        }

        NativeVideoProgressRunnable(@NonNull Context context, @NonNull Handler handler, @NonNull List<VisibilityTrackingEvent> list, @NonNull VastVideoConfig vastVideoConfig) {
            this(context, handler, list, new y(), vastVideoConfig);
        }

        @VisibleForTesting
        NativeVideoProgressRunnable(@NonNull Context context, @NonNull Handler handler, @NonNull List<VisibilityTrackingEvent> list, @NonNull y yVar, @NonNull VastVideoConfig vastVideoConfig) {
            super(handler);
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(handler);
            Preconditions.checkNotNull(list);
            Preconditions.checkNotNull(vastVideoConfig);
            this.c = context.getApplicationContext();
            this.e = list;
            this.d = yVar;
            this.f = vastVideoConfig;
            this.k = -1;
            this.l = false;
        }

        long a() {
            return this.j;
        }

        void a(long j) {
            this.j = j;
        }

        void a(@Nullable TextureView textureView) {
            this.h = textureView;
        }

        void a(@Nullable ExoPlayer exoPlayer) {
            this.g = exoPlayer;
        }

        void a(@Nullable ProgressListener progressListener) {
            this.i = progressListener;
        }

        void a(boolean z) {
            int i;
            int i2 = 0;
            Iterator it = this.e.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                VisibilityTrackingEvent visibilityTrackingEvent = (VisibilityTrackingEvent) it.next();
                if (visibilityTrackingEvent.e) {
                    i2 = i + 1;
                } else {
                    if (z || this.d.a(this.h, this.h, visibilityTrackingEvent.b)) {
                        visibilityTrackingEvent.d = (int) (((long) visibilityTrackingEvent.d) + this.b);
                        if (z || visibilityTrackingEvent.d >= visibilityTrackingEvent.c) {
                            visibilityTrackingEvent.a.execute();
                            visibilityTrackingEvent.e = true;
                            i++;
                        }
                    }
                    i2 = i;
                }
            }
            if (i == this.e.size() && this.l) {
                stop();
            }
        }

        long b() {
            return this.k;
        }

        void c() {
            this.l = true;
        }

        public void doWork() {
            if (this.g != null && this.g.getPlayWhenReady()) {
                this.j = this.g.getCurrentPosition();
                this.k = this.g.getDuration();
                a(false);
                if (this.i != null) {
                    this.i.updateProgress((int) ((((float) this.j) / ((float) this.k)) * 1000.0f));
                }
                List<VastTracker> untriggeredTrackersBefore = this.f.getUntriggeredTrackersBefore((int) this.j, (int) this.k);
                if (!untriggeredTrackersBefore.isEmpty()) {
                    Iterable arrayList = new ArrayList();
                    for (VastTracker vastTracker : untriggeredTrackersBefore) {
                        if (!vastTracker.isTracked()) {
                            arrayList.add(vastTracker.getTrackingUrl());
                            vastTracker.setTracked();
                        }
                    }
                    TrackingRequest.makeTrackingHttpRequest(arrayList, this.c);
                }
            }
        }
    }

    class VisibilityTrackingEvent {
        OnTrackedStrategy a;
        int b;
        int c;
        int d;
        boolean e;

        interface OnTrackedStrategy {
            void execute();
        }

        VisibilityTrackingEvent() {
        }
    }

    private NativeVideoController(@NonNull Context context, @NonNull VastVideoConfig vastVideoConfig, @NonNull NativeVideoProgressRunnable nativeVideoProgressRunnable, @NonNull p pVar, @Nullable EventDetails eventDetails, @NonNull AudioManager audioManager) {
        this.u = 1;
        this.v = true;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastVideoConfig);
        Preconditions.checkNotNull(pVar);
        Preconditions.checkNotNull(audioManager);
        this.b = context.getApplicationContext();
        this.c = new Handler(Looper.getMainLooper());
        this.e = vastVideoConfig;
        this.f = nativeVideoProgressRunnable;
        this.d = pVar;
        this.q = eventDetails;
        this.g = audioManager;
    }

    private NativeVideoController(@NonNull Context context, @NonNull List<VisibilityTrackingEvent> list, @NonNull VastVideoConfig vastVideoConfig, @Nullable EventDetails eventDetails) {
        this(context, vastVideoConfig, new NativeVideoProgressRunnable(context, new Handler(Looper.getMainLooper()), list, vastVideoConfig), new p(), eventDetails, (AudioManager) context.getSystemService("audio"));
    }

    private void a(float f) {
        boolean z = f >= 0.0f && f <= 1.0f;
        Preconditions.checkArgument(z);
        if (this.m != null) {
            this.m.sendMessage(this.o, 1, Float.valueOf(f));
        }
    }

    private void a(@Nullable Surface surface) {
        if (this.m != null) {
            this.m.sendMessage(this.p, 1, surface);
        }
    }

    private void b() {
        if (this.m != null) {
            a(null);
            this.m.stop();
            this.m.release();
            this.m = null;
            this.f.stop();
            this.f.a(null);
        }
    }

    private void c() {
        if (this.m == null) {
            this.m = this.d.newInstance(2, 1000, 5000);
            this.f.a(this.m);
            this.m.addListener(this);
            Allocator dVar = new d(65536);
            h hVar = new h();
            DataSource httpDiskCompositeDataSource = new HttpDiskCompositeDataSource(this.b, "exo_demo", this.q);
            SampleSource extractorSampleSource = new ExtractorSampleSource(Uri.parse(this.e.getNetworkMediaFileUrl()), httpDiskCompositeDataSource, dVar, 2097152, hVar);
            this.p = new MediaCodecVideoTrackRenderer(extractorSampleSource, 2, 0, this.c, null, 10);
            this.o = new MediaCodecAudioTrackRenderer(extractorSampleSource);
            this.m.prepare(this.o, this.p);
            this.f.startRepeating(50);
        }
        e();
        d();
    }

    @NonNull
    @VisibleForTesting
    public static NativeVideoController createForId(long j, @NonNull Context context, @NonNull VastVideoConfig vastVideoConfig, @NonNull NativeVideoProgressRunnable nativeVideoProgressRunnable, @NonNull p pVar, @Nullable EventDetails eventDetails, @NonNull AudioManager audioManager) {
        NativeVideoController nativeVideoController = new NativeVideoController(context, vastVideoConfig, nativeVideoProgressRunnable, pVar, eventDetails, audioManager);
        a.put(Long.valueOf(j), nativeVideoController);
        return nativeVideoController;
    }

    @NonNull
    public static NativeVideoController createForId(long j, @NonNull Context context, @NonNull List<VisibilityTrackingEvent> list, @NonNull VastVideoConfig vastVideoConfig, @Nullable EventDetails eventDetails) {
        NativeVideoController nativeVideoController = new NativeVideoController(context, list, vastVideoConfig, eventDetails);
        a.put(Long.valueOf(j), nativeVideoController);
        return nativeVideoController;
    }

    private void d() {
        if (this.m != null) {
            this.m.setPlayWhenReady(this.r);
        }
    }

    private void e() {
        a(this.s ? 1.0f : 0.0f);
    }

    @Nullable
    public static NativeVideoController getForId(long j) {
        return (NativeVideoController) a.get(Long.valueOf(j));
    }

    @Nullable
    public static NativeVideoController remove(long j) {
        return (NativeVideoController) a.remove(Long.valueOf(j));
    }

    void a() {
        this.f.a(true);
    }

    public void clear() {
        setPlayWhenReady(false);
        this.j = null;
        b();
    }

    public long getCurrentPosition() {
        return this.f.a();
    }

    public long getDuration() {
        return this.f.b();
    }

    @Nullable
    public Drawable getFinalFrame() {
        return this.n;
    }

    public int getPlaybackState() {
        return this.m == null ? 6 : this.m.getPlaybackState();
    }

    public void handleCtaClick(@NonNull Context context) {
        a();
        this.e.handleClickWithoutResult(context, 0);
    }

    public boolean hasFinalFrame() {
        return this.n != null;
    }

    public void onAudioFocusChange(int i) {
        if (this.i != null) {
            this.i.onAudioFocusChange(i);
        }
    }

    public void onPlayWhenReadyCommitted() {
    }

    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        if (this.h != null) {
            MoPubEvents.log(Event.createEventFromDetails(Name.ERROR_DURING_PLAYBACK, Category.NATIVE_VIDEO, SamplingRate.NATIVE_VIDEO, this.q));
            this.h.onError(exoPlaybackException);
            this.f.c();
        }
    }

    public void onPlayerStateChanged(boolean z, int i) {
        if (i == 5 && this.n == null) {
            this.n = new BitmapDrawable(this.b.getResources(), this.k.getBitmap());
            this.f.c();
        }
        if (this.u == 4 && i == 3) {
            MoPubEvents.log(Event.createEventFromDetails(Name.DOWNLOAD_BUFFERING, Category.NATIVE_VIDEO, SamplingRate.NATIVE_VIDEO, this.q));
        }
        if (this.v && this.u == 3 && i == 4) {
            MoPubEvents.log(Event.createEventFromDetails(Name.DOWNLOAD_VIDEO_READY, Category.NATIVE_VIDEO, SamplingRate.NATIVE_VIDEO, this.q));
        }
        this.u = i;
        if (i == 4) {
            this.v = false;
        } else if (i == 1) {
            this.v = true;
        }
        if (this.h != null) {
            this.h.onStateChanged(z, i);
        }
    }

    public void prepare(@NonNull Object obj) {
        Preconditions.checkNotNull(obj);
        this.l = new WeakReference(obj);
        b();
        c();
        a(this.j);
    }

    public void release(@NonNull Object obj) {
        Preconditions.checkNotNull(obj);
        if ((this.l == null ? null : this.l.get()) == obj) {
            b();
        }
    }

    public void seekTo(long j) {
        if (this.m != null) {
            this.m.seekTo(j);
            this.f.a(j);
        }
    }

    public void setAppAudioEnabled(boolean z) {
        if (this.t != z) {
            this.t = z;
            if (this.t) {
                this.g.requestAudioFocus(this, 3, 1);
            } else {
                this.g.abandonAudioFocus(this);
            }
        }
    }

    public void setAudioEnabled(boolean z) {
        this.s = z;
        e();
    }

    public void setAudioVolume(float f) {
        if (this.s) {
            a(f);
        }
    }

    public void setListener(@Nullable Listener listener) {
        this.h = listener;
    }

    public void setOnAudioFocusChangeListener(@Nullable OnAudioFocusChangeListener onAudioFocusChangeListener) {
        this.i = onAudioFocusChangeListener;
    }

    public void setPlayWhenReady(boolean z) {
        if (this.r != z) {
            this.r = z;
            d();
        }
    }

    public void setProgressListener(@Nullable ProgressListener progressListener) {
        this.f.a(progressListener);
    }

    public void setTextureView(@NonNull TextureView textureView) {
        Preconditions.checkNotNull(textureView);
        this.j = new Surface(textureView.getSurfaceTexture());
        this.k = textureView;
        this.f.a(this.k);
        a(this.j);
    }
}
