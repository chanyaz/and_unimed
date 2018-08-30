package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.h;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class MediaControllerCompat {
    private final MediaControllerImpl a;
    private final Token b;
    private final HashSet<f> c = new HashSet();

    interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i);

        void adjustVolume(int i, int i2);

        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        n getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        PendingIntent getSessionActivity();

        int getShuffleMode();

        o getTransportControls();

        boolean isCaptioningEnabled();

        boolean isSessionReady();

        void registerCallback(f fVar, Handler handler);

        void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void setVolumeTo(int i, int i2);

        void unregisterCallback(f fVar);
    }

    @RequiresApi(21)
    class MediaControllerImplApi21 implements MediaControllerImpl {
        protected final Object a;
        private final List<f> b = new ArrayList();
        private IMediaSession c;
        private HashMap<f, j> d = new HashMap();

        class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> a;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21, Handler handler) {
                super(handler);
                this.a = new WeakReference(mediaControllerImplApi21);
            }

            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    mediaControllerImplApi21.c = c.a(h.a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                    mediaControllerImplApi21.b();
                }
            }
        }

        public MediaControllerImplApi21(Context context, Token token) {
            this.a = MediaControllerCompatApi21.a(context, token.a());
            if (this.a == null) {
                throw new RemoteException();
            }
            this.c = token.b();
            if (this.c == null) {
                a();
            }
        }

        private void a() {
            sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this, new Handler()));
        }

        private void b() {
            if (this.c != null) {
                synchronized (this.b) {
                    for (f fVar : this.b) {
                        IMediaControllerCallback jVar = new j(fVar);
                        this.d.put(fVar, jVar);
                        fVar.b = true;
                        try {
                            this.c.registerCallbackListener(jVar);
                            fVar.a();
                        } catch (Throwable e) {
                            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                        }
                    }
                    this.b.clear();
                }
            }
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat);
            sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM", bundle, null);
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if ((getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat);
            bundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", i);
            sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle, null);
        }

        public void adjustVolume(int i, int i2) {
            MediaControllerCompatApi21.b(this.a, i, i2);
        }

        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.a(this.a, keyEvent);
        }

        public Bundle getExtras() {
            return MediaControllerCompatApi21.f(this.a);
        }

        public long getFlags() {
            return MediaControllerCompatApi21.h(this.a);
        }

        public Object getMediaController() {
            return this.a;
        }

        public MediaMetadataCompat getMetadata() {
            Object c = MediaControllerCompatApi21.c(this.a);
            return c != null ? MediaMetadataCompat.a(c) : null;
        }

        public String getPackageName() {
            return MediaControllerCompatApi21.k(this.a);
        }

        public n getPlaybackInfo() {
            Object i = MediaControllerCompatApi21.i(this.a);
            return i != null ? new n(u.a(i), u.c(i), u.d(i), u.e(i), u.f(i)) : null;
        }

        public PlaybackStateCompat getPlaybackState() {
            if (this.c != null) {
                try {
                    return this.c.getPlaybackState();
                } catch (Throwable e) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e);
                }
            }
            Object b = MediaControllerCompatApi21.b(this.a);
            return b != null ? PlaybackStateCompat.a(b) : null;
        }

        public List<QueueItem> getQueue() {
            List d = MediaControllerCompatApi21.d(this.a);
            return d != null ? QueueItem.a(d) : null;
        }

        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.e(this.a);
        }

        public int getRatingType() {
            if (VERSION.SDK_INT < 22 && this.c != null) {
                try {
                    return this.c.getRatingType();
                } catch (Throwable e) {
                    Log.e("MediaControllerCompat", "Dead object in getRatingType.", e);
                }
            }
            return MediaControllerCompatApi21.g(this.a);
        }

        public int getRepeatMode() {
            if (this.c != null) {
                try {
                    return this.c.getRepeatMode();
                } catch (Throwable e) {
                    Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e);
                }
            }
            return -1;
        }

        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.j(this.a);
        }

        public int getShuffleMode() {
            if (this.c != null) {
                try {
                    return this.c.getShuffleMode();
                } catch (Throwable e) {
                    Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e);
                }
            }
            return -1;
        }

        public o getTransportControls() {
            Object a = MediaControllerCompatApi21.a(this.a);
            return a != null ? new p(a) : null;
        }

        public boolean isCaptioningEnabled() {
            if (this.c != null) {
                try {
                    return this.c.isCaptioningEnabled();
                } catch (Throwable e) {
                    Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e);
                }
            }
            return false;
        }

        public boolean isSessionReady() {
            return this.c != null;
        }

        public final void registerCallback(f fVar, Handler handler) {
            MediaControllerCompatApi21.a(this.a, fVar.c, handler);
            if (this.c != null) {
                IMediaControllerCallback jVar = new j(fVar);
                this.d.put(fVar, jVar);
                fVar.b = true;
                try {
                    this.c.registerCallbackListener(jVar);
                    return;
                } catch (Throwable e) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                    return;
                }
            }
            synchronized (this.b) {
                fVar.b = false;
                this.b.add(fVar);
            }
        }

        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat);
            sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle, null);
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.a(this.a, str, bundle, resultReceiver);
        }

        public void setVolumeTo(int i, int i2) {
            MediaControllerCompatApi21.a(this.a, i, i2);
        }

        public final void unregisterCallback(f fVar) {
            MediaControllerCompatApi21.a(this.a, fVar.c);
            if (this.c != null) {
                try {
                    j jVar = (j) this.d.remove(fVar);
                    if (jVar != null) {
                        fVar.b = false;
                        this.c.unregisterCallbackListener(jVar);
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e);
                    return;
                }
            }
            synchronized (this.b) {
                this.b.remove(fVar);
            }
        }
    }

    public MediaControllerCompat(Context context, @NonNull Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.b = token;
        if (VERSION.SDK_INT >= 24) {
            this.a = new l(context, token);
        } else if (VERSION.SDK_INT >= 23) {
            this.a = new k(context, token);
        } else if (VERSION.SDK_INT >= 21) {
            this.a = new MediaControllerImplApi21(context, token);
        } else {
            this.a = new m(this.b);
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.a.dispatchMediaButtonEvent(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }
}
