package android.support.v4.media.session;

import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.v4.media.session.MediaControllerCompatApi21.Callback;
import java.util.List;

class t<T extends Callback> extends MediaController.Callback {
    protected final T a;

    public t(T t) {
        this.a = t;
    }

    public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        this.a.onAudioInfoChanged(playbackInfo.getPlaybackType(), u.c(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
    }

    public void onExtrasChanged(Bundle bundle) {
        this.a.onExtrasChanged(bundle);
    }

    public void onMetadataChanged(MediaMetadata mediaMetadata) {
        this.a.onMetadataChanged(mediaMetadata);
    }

    public void onPlaybackStateChanged(PlaybackState playbackState) {
        this.a.onPlaybackStateChanged(playbackState);
    }

    public void onQueueChanged(List<QueueItem> list) {
        this.a.onQueueChanged(list);
    }

    public void onQueueTitleChanged(CharSequence charSequence) {
        this.a.onQueueTitleChanged(charSequence);
    }

    public void onSessionDestroyed() {
        this.a.onSessionDestroyed();
    }

    public void onSessionEvent(String str, Bundle bundle) {
        this.a.onSessionEvent(str, bundle);
    }
}
