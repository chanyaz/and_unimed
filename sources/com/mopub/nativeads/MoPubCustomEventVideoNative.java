package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent.Category;
import com.mopub.common.event.BaseEvent.Name;
import com.mopub.common.event.BaseEvent.SamplingRate;
import com.mopub.common.event.Event;
import com.mopub.common.event.EventDetails;
import com.mopub.common.event.MoPubEvents;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.BaseVideoPlayerActivity;
import com.mopub.mobileads.VastManager;
import com.mopub.mobileads.VastManager.VastManagerListener;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.mobileads.VideoViewabilityTracker;
import com.mopub.mobileads.factories.VastManagerFactory;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.nativeads.MediaLayout.Mode;
import com.mopub.nativeads.MediaLayout.MuteState;
import com.mopub.nativeads.NativeImageHelper.ImageListener;
import com.mopub.nativeads.NativeVideoController.NativeVideoProgressRunnable.ProgressListener;
import com.mopub.network.TrackingRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(16)
public class MoPubCustomEventVideoNative extends CustomEventNative {

    @TargetApi(16)
    public class MoPubVideoNativeAd extends VideoNativeAd implements OnAudioFocusChangeListener, VastManagerListener, ProgressListener {
        @Nullable
        VastVideoConfig a;
        @NonNull
        private final Context b;
        @NonNull
        private final JSONObject c;
        @NonNull
        private VideoState d;
        @NonNull
        private final VisibilityTracker e;
        @NonNull
        private final String f;
        @NonNull
        private final CustomEventNativeListener g;
        @NonNull
        private final k h;
        @NonNull
        private final i i;
        @Nullable
        private NativeVideoController j;
        @NonNull
        private final VastManager k;
        @Nullable
        private MediaLayout l;
        @Nullable
        private View m;
        @Nullable
        private final EventDetails n;
        private final long o;
        private boolean p;
        private boolean q;
        private boolean r;
        private boolean s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private boolean x;

        public enum VideoState {
            CREATED,
            LOADING,
            BUFFERING,
            PAUSED,
            PLAYING,
            PLAYING_MUTED,
            ENDED,
            FAILED_LOAD
        }

        public MoPubVideoNativeAd(@NonNull Activity activity, @NonNull JSONObject jSONObject, @NonNull CustomEventNativeListener customEventNativeListener, @NonNull k kVar, @Nullable EventDetails eventDetails, @NonNull String str) {
            this(activity, jSONObject, customEventNativeListener, kVar, new VisibilityTracker(activity), new i(), eventDetails, str, VastManagerFactory.create(activity.getApplicationContext(), false));
        }

        @VisibleForTesting
        MoPubVideoNativeAd(@NonNull Activity activity, @NonNull JSONObject jSONObject, @NonNull CustomEventNativeListener customEventNativeListener, @NonNull k kVar, @NonNull VisibilityTracker visibilityTracker, @NonNull i iVar, @Nullable EventDetails eventDetails, @NonNull String str, @NonNull VastManager vastManager) {
            this.r = false;
            this.s = false;
            Preconditions.checkNotNull(activity);
            Preconditions.checkNotNull(jSONObject);
            Preconditions.checkNotNull(customEventNativeListener);
            Preconditions.checkNotNull(kVar);
            Preconditions.checkNotNull(visibilityTracker);
            Preconditions.checkNotNull(iVar);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(vastManager);
            this.b = activity.getApplicationContext();
            this.c = jSONObject;
            this.g = customEventNativeListener;
            this.h = kVar;
            this.i = iVar;
            this.f = str;
            this.n = eventDetails;
            this.o = Utils.generateUniqueId();
            this.p = true;
            this.d = VideoState.CREATED;
            this.q = true;
            this.t = 1;
            this.w = true;
            this.e = visibilityTracker;
            this.e.a(new VisibilityTrackerListener() {
                public void onVisibilityChanged(List<View> list, List<View> list2) {
                    if (!list.isEmpty() && !MoPubVideoNativeAd.this.v) {
                        MoPubVideoNativeAd.this.v = true;
                        MoPubVideoNativeAd.this.h();
                    } else if (!list2.isEmpty() && MoPubVideoNativeAd.this.v) {
                        MoPubVideoNativeAd.this.v = false;
                        MoPubVideoNativeAd.this.h();
                    }
                }
            });
            this.k = vastManager;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0033  */
        private void a(@android.support.annotation.NonNull com.mopub.nativeads.h r3, @android.support.annotation.Nullable java.lang.Object r4) {
            /*
            r2 = this;
            com.mopub.common.Preconditions.checkNotNull(r3);
            com.mopub.common.Preconditions.checkNotNull(r4);
            r0 = com.mopub.nativeads.MoPubCustomEventVideoNative.AnonymousClass1.a;	 Catch:{ ClassCastException -> 0x002e }
            r1 = r3.ordinal();	 Catch:{ ClassCastException -> 0x002e }
            r0 = r0[r1];	 Catch:{ ClassCastException -> 0x002e }
            switch(r0) {
                case 1: goto L_0x002a;
                case 2: goto L_0x004c;
                case 3: goto L_0x0052;
                case 4: goto L_0x0058;
                case 5: goto L_0x005e;
                case 6: goto L_0x0064;
                case 7: goto L_0x006a;
                case 8: goto L_0x006e;
                case 9: goto L_0x0074;
                default: goto L_0x0011;
            };	 Catch:{ ClassCastException -> 0x002e }
        L_0x0011:
            r0 = new java.lang.StringBuilder;	 Catch:{ ClassCastException -> 0x002e }
            r0.<init>();	 Catch:{ ClassCastException -> 0x002e }
            r1 = "Unable to add JSON key to internal mapping: ";
            r0 = r0.append(r1);	 Catch:{ ClassCastException -> 0x002e }
            r1 = r3.a;	 Catch:{ ClassCastException -> 0x002e }
            r0 = r0.append(r1);	 Catch:{ ClassCastException -> 0x002e }
            r0 = r0.toString();	 Catch:{ ClassCastException -> 0x002e }
            com.mopub.common.logging.MoPubLog.d(r0);	 Catch:{ ClassCastException -> 0x002e }
        L_0x0029:
            return;
        L_0x002a:
            r2.a(r4);	 Catch:{ ClassCastException -> 0x002e }
            goto L_0x0029;
        L_0x002e:
            r0 = move-exception;
            r1 = r3.b;
            if (r1 != 0) goto L_0x007a;
        L_0x0033:
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = "Ignoring class cast exception for optional key: ";
            r0 = r0.append(r1);
            r1 = r3.a;
            r0 = r0.append(r1);
            r0 = r0.toString();
            com.mopub.common.logging.MoPubLog.d(r0);
            goto L_0x0029;
        L_0x004c:
            r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002e }
            r2.setTitle(r4);	 Catch:{ ClassCastException -> 0x002e }
            goto L_0x0029;
        L_0x0052:
            r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002e }
            r2.setText(r4);	 Catch:{ ClassCastException -> 0x002e }
            goto L_0x0029;
        L_0x0058:
            r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002e }
            r2.setMainImageUrl(r4);	 Catch:{ ClassCastException -> 0x002e }
            goto L_0x0029;
        L_0x005e:
            r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002e }
            r2.setIconImageUrl(r4);	 Catch:{ ClassCastException -> 0x002e }
            goto L_0x0029;
        L_0x0064:
            r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002e }
            r2.setClickDestinationUrl(r4);	 Catch:{ ClassCastException -> 0x002e }
            goto L_0x0029;
        L_0x006a:
            r2.c(r4);	 Catch:{ ClassCastException -> 0x002e }
            goto L_0x0029;
        L_0x006e:
            r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002e }
            r2.setCallToAction(r4);	 Catch:{ ClassCastException -> 0x002e }
            goto L_0x0029;
        L_0x0074:
            r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002e }
            r2.setVastVideo(r4);	 Catch:{ ClassCastException -> 0x002e }
            goto L_0x0029;
        L_0x007a:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd.a(com.mopub.nativeads.h, java.lang.Object):void");
        }

        private boolean a(@Nullable String str) {
            return str != null && str.toLowerCase(Locale.US).endsWith("image");
        }

        private boolean a(@NonNull JSONObject jSONObject) {
            Preconditions.checkNotNull(jSONObject);
            Set hashSet = new HashSet();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                hashSet.add(keys.next());
            }
            return hashSet.containsAll(h.c);
        }

        private void b(VideoState videoState) {
            if (!(!this.s || videoState == VideoState.PLAYING || videoState == VideoState.PLAYING_MUTED)) {
                TrackingRequest.makeVastTrackingHttpRequest(this.a.getResumeTrackers(), null, Integer.valueOf((int) this.j.getCurrentPosition()), null, this.b);
                this.s = false;
            }
            this.r = true;
            if (this.p) {
                this.p = false;
                this.j.seekTo(this.j.getCurrentPosition());
            }
        }

        private void c(@NonNull Object obj) {
            if (obj instanceof JSONArray) {
                b(obj);
            } else {
                addClickTracker((String) obj);
            }
        }

        private void f() {
            if (this.l != null) {
                this.l.setMode(Mode.IMAGE);
                this.l.setSurfaceTextureListener(null);
                this.l.setPlayButtonClickListener(null);
                this.l.setMuteControlClickListener(null);
                this.l.setOnClickListener(null);
                this.e.a(this.l);
                this.l = null;
            }
        }

        private void g() {
            this.p = true;
            this.q = true;
            this.j.setListener(null);
            this.j.setOnAudioFocusChangeListener(null);
            this.j.setProgressListener(null);
            this.j.clear();
            a(VideoState.PAUSED, true);
        }

        private void h() {
            VideoState videoState = this.d;
            if (this.u) {
                videoState = VideoState.FAILED_LOAD;
            } else if (this.x) {
                videoState = VideoState.ENDED;
            } else if (this.t == 2 || this.t == 1) {
                videoState = VideoState.LOADING;
            } else if (this.t == 3) {
                videoState = VideoState.BUFFERING;
            } else if (this.t == 5) {
                this.x = true;
                videoState = VideoState.ENDED;
            } else if (this.t == 4) {
                videoState = this.v ? this.w ? VideoState.PLAYING_MUTED : VideoState.PLAYING : VideoState.PAUSED;
            }
            a(videoState);
        }

        @NonNull
        private List<String> i() {
            List<String> arrayList = new ArrayList(getExtras().size());
            for (Entry entry : getExtras().entrySet()) {
                if (a((String) entry.getKey()) && (entry.getValue() instanceof String)) {
                    arrayList.add((String) entry.getValue());
                }
            }
            return arrayList;
        }

        @NonNull
        private List<String> j() {
            List<String> arrayList = new ArrayList();
            if (getMainImageUrl() != null) {
                arrayList.add(getMainImageUrl());
            }
            if (getIconImageUrl() != null) {
                arrayList.add(getIconImageUrl());
            }
            arrayList.addAll(i());
            return arrayList;
        }

        @VisibleForTesting
        void a(@NonNull VideoState videoState) {
            a(videoState, false);
        }

        @VisibleForTesting
        void a(@NonNull VideoState videoState, boolean z) {
            Preconditions.checkNotNull(videoState);
            if (this.a != null && this.j != null && this.l != null && this.d != videoState) {
                VideoState videoState2 = this.d;
                this.d = videoState;
                switch (videoState) {
                    case FAILED_LOAD:
                        this.a.handleError(this.b, null, 0);
                        this.j.setAppAudioEnabled(false);
                        this.l.setMode(Mode.IMAGE);
                        if (videoState2 != VideoState.PLAYING && videoState2 != VideoState.PLAYING_MUTED) {
                            MoPubEvents.log(Event.createEventFromDetails(Name.ERROR_FAILED_TO_PLAY, Category.NATIVE_VIDEO, SamplingRate.NATIVE_VIDEO, this.n));
                            return;
                        }
                        return;
                    case CREATED:
                    case LOADING:
                        this.j.setPlayWhenReady(true);
                        this.l.setMode(Mode.LOADING);
                        return;
                    case BUFFERING:
                        this.j.setPlayWhenReady(true);
                        this.l.setMode(Mode.BUFFERING);
                        return;
                    case PAUSED:
                        if (z) {
                            this.s = false;
                        }
                        if (!z) {
                            this.j.setAppAudioEnabled(false);
                            if (this.r) {
                                TrackingRequest.makeVastTrackingHttpRequest(this.a.getPauseTrackers(), null, Integer.valueOf((int) this.j.getCurrentPosition()), null, this.b);
                                this.r = false;
                                this.s = true;
                            }
                        }
                        this.j.setPlayWhenReady(false);
                        this.l.setMode(Mode.PAUSED);
                        return;
                    case PLAYING:
                        b(videoState2);
                        this.j.setPlayWhenReady(true);
                        this.j.setAudioEnabled(true);
                        this.j.setAppAudioEnabled(true);
                        this.l.setMode(Mode.PLAYING);
                        this.l.setMuteState(MuteState.UNMUTED);
                        return;
                    case PLAYING_MUTED:
                        b(videoState2);
                        this.j.setPlayWhenReady(true);
                        this.j.setAudioEnabled(false);
                        this.j.setAppAudioEnabled(false);
                        this.l.setMode(Mode.PLAYING);
                        this.l.setMuteState(MuteState.MUTED);
                        return;
                    case ENDED:
                        if (this.j.hasFinalFrame()) {
                            this.l.setMainImageDrawable(this.j.getFinalFrame());
                        }
                        this.r = false;
                        this.s = false;
                        this.a.handleComplete(this.b, 0);
                        this.j.setAppAudioEnabled(false);
                        this.l.setMode(Mode.FINISHED);
                        this.l.updateProgress(1000);
                        return;
                    default:
                        return;
                }
            }
        }

        public void clear(@NonNull View view) {
            Preconditions.checkNotNull(view);
            this.j.clear();
            f();
        }

        public void destroy() {
            f();
            this.j.setPlayWhenReady(false);
            this.j.release(this);
            NativeVideoController.remove(this.o);
            this.e.b();
        }

        void e() {
            if (a(this.c)) {
                Iterator keys = this.c.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    h a = h.a(str);
                    if (a != null) {
                        try {
                            a(a, this.c.opt(str));
                        } catch (ClassCastException e) {
                            throw new IllegalArgumentException("JSONObject key (" + str + ") contained unexpected value.");
                        }
                    }
                    addExtra(str, this.c.opt(str));
                }
                setPrivacyInformationIconClickThroughUrl("https://www.mopub.com/optout/");
                NativeImageHelper.preCacheImages(this.b, j(), new ImageListener() {
                    public void onImagesCached() {
                        MoPubVideoNativeAd.this.k.prepareVastVideoConfiguration(MoPubVideoNativeAd.this.getVastVideo(), MoPubVideoNativeAd.this, MoPubVideoNativeAd.this.n == null ? null : MoPubVideoNativeAd.this.n.getDspCreativeId(), MoPubVideoNativeAd.this.b);
                    }

                    public void onImagesFailedToCache(NativeErrorCode nativeErrorCode) {
                        MoPubVideoNativeAd.this.g.onNativeAdFailed(nativeErrorCode);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("JSONObject did not contain required keys.");
        }

        public void onAudioFocusChange(int i) {
            if (i == -1 || i == -2) {
                this.w = true;
                h();
            } else if (i == -3) {
                this.j.setAudioVolume(0.3f);
            } else if (i == 1) {
                this.j.setAudioVolume(1.0f);
                h();
            }
        }

        public void onError(Exception exception) {
            MoPubLog.w("Error playing back video.", exception);
            this.u = true;
            h();
        }

        public void onStateChanged(boolean z, int i) {
            this.t = i;
            h();
        }

        public void onVastVideoConfigurationPrepared(@Nullable VastVideoConfig vastVideoConfig) {
            if (vastVideoConfig == null) {
                this.g.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
                return;
            }
            List arrayList = new ArrayList();
            VisibilityTrackingEvent visibilityTrackingEvent = new VisibilityTrackingEvent();
            visibilityTrackingEvent.a = new g(this);
            visibilityTrackingEvent.b = this.h.d();
            visibilityTrackingEvent.c = this.h.e();
            arrayList.add(visibilityTrackingEvent);
            this.a = vastVideoConfig;
            VideoViewabilityTracker videoViewabilityTracker = this.a.getVideoViewabilityTracker();
            if (videoViewabilityTracker != null) {
                VisibilityTrackingEvent visibilityTrackingEvent2 = new VisibilityTrackingEvent();
                visibilityTrackingEvent2.a = new j(this.b, videoViewabilityTracker.getTrackingUrl());
                visibilityTrackingEvent2.b = videoViewabilityTracker.getPercentViewable();
                visibilityTrackingEvent2.c = videoViewabilityTracker.getViewablePlaytimeMS();
                arrayList.add(visibilityTrackingEvent2);
            }
            Set<String> hashSet = new HashSet();
            hashSet.add(this.f);
            hashSet.addAll(d());
            List arrayList2 = new ArrayList();
            for (String vastTracker : hashSet) {
                arrayList2.add(new VastTracker(vastTracker, false));
            }
            this.a.addClickTrackers(arrayList2);
            this.a.setClickThroughUrl(getClickDestinationUrl());
            this.j = this.i.createForId(this.o, this.b, arrayList, this.a, this.n);
            this.g.onNativeAdLoaded(this);
        }

        public void prepare(@NonNull View view) {
            Preconditions.checkNotNull(view);
            this.m = view;
            this.m.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    MoPubVideoNativeAd.this.g();
                    MoPubVideoNativeAd.this.j.a();
                    MoPubVideoNativeAd.this.j.handleCtaClick(MoPubVideoNativeAd.this.b);
                }
            });
        }

        public void render(@NonNull MediaLayout mediaLayout) {
            Preconditions.checkNotNull(mediaLayout);
            this.e.a(this.m, mediaLayout, this.h.b(), this.h.c());
            this.l = mediaLayout;
            this.l.initForVideo();
            this.l.setSurfaceTextureListener(new SurfaceTextureListener() {
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    MoPubVideoNativeAd.this.j.setListener(MoPubVideoNativeAd.this);
                    MoPubVideoNativeAd.this.j.setOnAudioFocusChangeListener(MoPubVideoNativeAd.this);
                    MoPubVideoNativeAd.this.j.setProgressListener(MoPubVideoNativeAd.this);
                    MoPubVideoNativeAd.this.j.setTextureView(MoPubVideoNativeAd.this.l.getTextureView());
                    MoPubVideoNativeAd.this.l.resetProgress();
                    long duration = MoPubVideoNativeAd.this.j.getDuration();
                    long currentPosition = MoPubVideoNativeAd.this.j.getCurrentPosition();
                    if (MoPubVideoNativeAd.this.t == 5 || (duration > 0 && duration - currentPosition < 750)) {
                        MoPubVideoNativeAd.this.x = true;
                    }
                    if (MoPubVideoNativeAd.this.q) {
                        MoPubVideoNativeAd.this.q = false;
                        MoPubVideoNativeAd.this.j.prepare(MoPubVideoNativeAd.this);
                    }
                    MoPubVideoNativeAd.this.p = true;
                    MoPubVideoNativeAd.this.h();
                }

                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    MoPubVideoNativeAd.this.q = true;
                    MoPubVideoNativeAd.this.j.release(MoPubVideoNativeAd.this);
                    MoPubVideoNativeAd.this.a(VideoState.PAUSED);
                    return true;
                }

                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                }

                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }
            });
            this.l.setPlayButtonClickListener(new OnClickListener() {
                public void onClick(View view) {
                    MoPubVideoNativeAd.this.l.resetProgress();
                    MoPubVideoNativeAd.this.j.seekTo(0);
                    MoPubVideoNativeAd.this.x = false;
                    MoPubVideoNativeAd.this.p = false;
                }
            });
            this.l.setMuteControlClickListener(new OnClickListener() {
                public void onClick(View view) {
                    MoPubVideoNativeAd.this.w = !MoPubVideoNativeAd.this.w;
                    MoPubVideoNativeAd.this.h();
                }
            });
            this.l.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    MoPubVideoNativeAd.this.g();
                    MoPubVideoNativeAd.this.j.a();
                    BaseVideoPlayerActivity.startNativeVideo(MoPubVideoNativeAd.this.b, MoPubVideoNativeAd.this.o, MoPubVideoNativeAd.this.a);
                }
            });
            if (this.j.getPlaybackState() == 6) {
                this.j.prepare(this);
            }
            a(VideoState.PAUSED);
        }

        public void updateProgress(int i) {
            this.l.updateProgress(i);
        }
    }

    protected void a(@NonNull Activity activity, @NonNull CustomEventNativeListener customEventNativeListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) {
        Object obj = map.get(DataKeys.JSON_BODY_KEY);
        if (obj instanceof JSONObject) {
            Object obj2 = map.get(DataKeys.EVENT_DETAILS);
            EventDetails eventDetails = obj2 instanceof EventDetails ? (EventDetails) obj2 : null;
            k kVar = new k(map2);
            if (kVar.a()) {
                Object obj3 = map.get(DataKeys.CLICK_TRACKING_URL_KEY);
                if (!(obj3 instanceof String) || TextUtils.isEmpty((String) obj3)) {
                    customEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                    return;
                }
                try {
                    new MoPubVideoNativeAd(activity, (JSONObject) obj, customEventNativeListener, kVar, eventDetails, (String) obj3).e();
                    return;
                } catch (IllegalArgumentException e) {
                    customEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                    return;
                }
            }
            customEventNativeListener.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
            return;
        }
        customEventNativeListener.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
    }
}
