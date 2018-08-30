package android.support.v4.media.session;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

class m implements MediaControllerImpl {
    private IMediaSession a;
    private o b;

    public m(Token token) {
        this.a = c.a((IBinder) token.a());
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        try {
            if ((this.a.getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            this.a.addQueueItem(mediaDescriptionCompat);
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in addQueueItem.", e);
        }
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        try {
            if ((this.a.getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            this.a.addQueueItemAt(mediaDescriptionCompat, i);
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in addQueueItemAt.", e);
        }
    }

    public void adjustVolume(int i, int i2) {
        try {
            this.a.adjustVolume(i, i2, null);
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in adjustVolume.", e);
        }
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("event may not be null.");
        }
        try {
            this.a.sendMediaButton(keyEvent);
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e);
        }
        return false;
    }

    public Bundle getExtras() {
        try {
            return this.a.getExtras();
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in getExtras.", e);
            return null;
        }
    }

    public long getFlags() {
        try {
            return this.a.getFlags();
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in getFlags.", e);
            return 0;
        }
    }

    public Object getMediaController() {
        return null;
    }

    public MediaMetadataCompat getMetadata() {
        try {
            return this.a.getMetadata();
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in getMetadata.", e);
            return null;
        }
    }

    public String getPackageName() {
        try {
            return this.a.getPackageName();
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in getPackageName.", e);
            return null;
        }
    }

    public n getPlaybackInfo() {
        try {
            ParcelableVolumeInfo volumeAttributes = this.a.getVolumeAttributes();
            return new n(volumeAttributes.a, volumeAttributes.b, volumeAttributes.c, volumeAttributes.d, volumeAttributes.e);
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo.", e);
            return null;
        }
    }

    public PlaybackStateCompat getPlaybackState() {
        try {
            return this.a.getPlaybackState();
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e);
            return null;
        }
    }

    public List<QueueItem> getQueue() {
        try {
            return this.a.getQueue();
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in getQueue.", e);
            return null;
        }
    }

    public CharSequence getQueueTitle() {
        try {
            return this.a.getQueueTitle();
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in getQueueTitle.", e);
            return null;
        }
    }

    public int getRatingType() {
        try {
            return this.a.getRatingType();
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in getRatingType.", e);
            return 0;
        }
    }

    public int getRepeatMode() {
        try {
            return this.a.getRepeatMode();
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e);
            return -1;
        }
    }

    public PendingIntent getSessionActivity() {
        try {
            return this.a.getLaunchPendingIntent();
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in getSessionActivity.", e);
            return null;
        }
    }

    public int getShuffleMode() {
        try {
            return this.a.getShuffleMode();
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e);
            return -1;
        }
    }

    public o getTransportControls() {
        if (this.b == null) {
            this.b = new s(this.a);
        }
        return this.b;
    }

    public boolean isCaptioningEnabled() {
        try {
            return this.a.isCaptioningEnabled();
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e);
            return false;
        }
    }

    public boolean isSessionReady() {
        return true;
    }

    public void registerCallback(f fVar, Handler handler) {
        if (fVar == null) {
            throw new IllegalArgumentException("callback may not be null.");
        }
        try {
            this.a.asBinder().linkToDeath(fVar, 0);
            this.a.registerCallbackListener((IMediaControllerCallback) fVar.c);
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
            fVar.b();
        }
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        try {
            if ((this.a.getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            this.a.removeQueueItem(mediaDescriptionCompat);
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in removeQueueItem.", e);
        }
    }

    public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        try {
            this.a.sendCommand(str, bundle, new ResultReceiverWrapper(resultReceiver));
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in sendCommand.", e);
        }
    }

    public void setVolumeTo(int i, int i2) {
        try {
            this.a.setVolumeTo(i, i2, null);
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in setVolumeTo.", e);
        }
    }

    public void unregisterCallback(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("callback may not be null.");
        }
        try {
            this.a.unregisterCallbackListener((IMediaControllerCallback) fVar.c);
            this.a.asBinder().unlinkToDeath(fVar, 0);
        } catch (Throwable e) {
            Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e);
        }
    }
}
