package android.support.v4.media.session;

import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.annotation.RequiresApi;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
class aa implements MediaSessionImpl {
    int a;
    boolean b;
    int c;
    int d;
    private final Object e;
    private final Token f;
    private boolean g;
    private final RemoteCallbackList<IMediaControllerCallback> h;
    private PlaybackStateCompat i;
    private List<QueueItem> j;
    private MediaMetadataCompat k;

    public String getCallingPackage() {
        return VERSION.SDK_INT < 24 ? null : MediaSessionCompatApi24.a(this.e);
    }

    public Object getMediaSession() {
        return this.e;
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.i;
    }

    public Object getRemoteControlClient() {
        return null;
    }

    public Token getSessionToken() {
        return this.f;
    }

    public boolean isActive() {
        return MediaSessionCompatApi21.b(this.e);
    }

    public void release() {
        this.g = true;
        MediaSessionCompatApi21.c(this.e);
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (VERSION.SDK_INT < 23) {
            for (int beginBroadcast = this.h.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.h.getBroadcastItem(beginBroadcast)).onEvent(str, bundle);
                } catch (RemoteException e) {
                }
            }
            this.h.finishBroadcast();
        }
        MediaSessionCompatApi21.a(this.e, str, bundle);
    }

    public void setActive(boolean z) {
        MediaSessionCompatApi21.a(this.e, z);
    }

    public void setCallback(v vVar, Handler handler) {
        MediaSessionCompatApi21.a(this.e, vVar == null ? null : vVar.a, handler);
        if (vVar != null) {
            vVar.a((MediaSessionImpl) this, handler);
        }
    }

    public void setCaptioningEnabled(boolean z) {
        if (this.b != z) {
            this.b = z;
            for (int beginBroadcast = this.h.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.h.getBroadcastItem(beginBroadcast)).onCaptioningEnabledChanged(z);
                } catch (RemoteException e) {
                }
            }
            this.h.finishBroadcast();
        }
    }

    public void setExtras(Bundle bundle) {
        MediaSessionCompatApi21.a(this.e, bundle);
    }

    public void setFlags(int i) {
        MediaSessionCompatApi21.a(this.e, i);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        MediaSessionCompatApi21.b(this.e, pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.k = mediaMetadataCompat;
        MediaSessionCompatApi21.c(this.e, mediaMetadataCompat == null ? null : mediaMetadataCompat.a());
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.i = playbackStateCompat;
        for (int beginBroadcast = this.h.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
            try {
                ((IMediaControllerCallback) this.h.getBroadcastItem(beginBroadcast)).onPlaybackStateChanged(playbackStateCompat);
            } catch (RemoteException e) {
            }
        }
        this.h.finishBroadcast();
        MediaSessionCompatApi21.b(this.e, playbackStateCompat == null ? null : playbackStateCompat.c());
    }

    public void setPlaybackToLocal(int i) {
        MediaSessionCompatApi21.b(this.e, i);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        MediaSessionCompatApi21.a(this.e, volumeProviderCompat.a());
    }

    public void setQueue(List<QueueItem> list) {
        this.j = list;
        List list2 = null;
        if (list != null) {
            List arrayList = new ArrayList();
            for (QueueItem b : list) {
                arrayList.add(b.b());
            }
            list2 = arrayList;
        }
        MediaSessionCompatApi21.a(this.e, list2);
    }

    public void setQueueTitle(CharSequence charSequence) {
        MediaSessionCompatApi21.a(this.e, charSequence);
    }

    public void setRatingType(int i) {
        if (VERSION.SDK_INT < 22) {
            this.a = i;
        } else {
            ad.a(this.e, i);
        }
    }

    public void setRepeatMode(int i) {
        if (this.c != i) {
            this.c = i;
            for (int beginBroadcast = this.h.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.h.getBroadcastItem(beginBroadcast)).onRepeatModeChanged(i);
                } catch (RemoteException e) {
                }
            }
            this.h.finishBroadcast();
        }
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        MediaSessionCompatApi21.a(this.e, pendingIntent);
    }

    public void setShuffleMode(int i) {
        if (this.d != i) {
            this.d = i;
            for (int beginBroadcast = this.h.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.h.getBroadcastItem(beginBroadcast)).onShuffleModeChanged(i);
                } catch (RemoteException e) {
                }
            }
            this.h.finishBroadcast();
        }
    }
}
