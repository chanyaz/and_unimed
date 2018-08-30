package android.support.v4.media.session;

import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession.Callback;
import android.os.Bundle;
import android.os.ResultReceiver;

class ab<T extends Callback> extends Callback {
    protected final T a;

    public ab(T t) {
        this.a = t;
    }

    public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.a.onCommand(str, bundle, resultReceiver);
    }

    public void onCustomAction(String str, Bundle bundle) {
        this.a.onCustomAction(str, bundle);
    }

    public void onFastForward() {
        this.a.onFastForward();
    }

    public boolean onMediaButtonEvent(Intent intent) {
        return this.a.onMediaButtonEvent(intent) || super.onMediaButtonEvent(intent);
    }

    public void onPause() {
        this.a.onPause();
    }

    public void onPlay() {
        this.a.onPlay();
    }

    public void onPlayFromMediaId(String str, Bundle bundle) {
        this.a.onPlayFromMediaId(str, bundle);
    }

    public void onPlayFromSearch(String str, Bundle bundle) {
        this.a.onPlayFromSearch(str, bundle);
    }

    public void onRewind() {
        this.a.onRewind();
    }

    public void onSeekTo(long j) {
        this.a.onSeekTo(j);
    }

    public void onSetRating(Rating rating) {
        this.a.onSetRating(rating);
    }

    public void onSkipToNext() {
        this.a.onSkipToNext();
    }

    public void onSkipToPrevious() {
        this.a.onSkipToPrevious();
    }

    public void onSkipToQueueItem(long j) {
        this.a.onSkipToQueueItem(j);
    }

    public void onStop() {
        this.a.onStop();
    }
}
