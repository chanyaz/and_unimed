package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.annotation.RequiresApi;
import android.support.v4.app.h;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.util.Log;

@RequiresApi(21)
class x implements Callback {
    final /* synthetic */ v a;

    x(v vVar) {
        this.a = vVar;
    }

    public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        IBinder iBinder = null;
        try {
            aa aaVar;
            if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                aaVar = (aa) this.a.b.get();
                if (aaVar != null) {
                    Bundle bundle2 = new Bundle();
                    IMediaSession b = aaVar.getSessionToken().b();
                    String str2 = "android.support.v4.media.session.EXTRA_BINDER";
                    if (b != null) {
                        iBinder = b.asBinder();
                    }
                    h.a(bundle2, str2, iBinder);
                    resultReceiver.send(0, bundle2);
                }
            } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                bundle.setClassLoader(MediaDescriptionCompat.class.getClassLoader());
                this.a.a((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
            } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                bundle.setClassLoader(MediaDescriptionCompat.class.getClassLoader());
                this.a.a((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
            } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                bundle.setClassLoader(MediaDescriptionCompat.class.getClassLoader());
                this.a.b((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
            } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                aaVar = (aa) this.a.b.get();
                if (aaVar != null && aaVar.j != null) {
                    int i = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                    QueueItem queueItem = (i < 0 || i >= aaVar.j.size()) ? null : (QueueItem) aaVar.j.get(i);
                    if (queueItem != null) {
                        this.a.b(queueItem.a());
                    }
                }
            } else {
                this.a.a(str, bundle, resultReceiver);
            }
        } catch (BadParcelableException e) {
            Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
        }
    }

    public void onCustomAction(String str, Bundle bundle) {
        if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
            this.a.b((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), (Bundle) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
        } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
            this.a.a();
        } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
            this.a.a(bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID"), bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
        } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
            this.a.b(bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY"), bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
        } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
            this.a.a((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
        } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
            this.a.a(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
        } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
            this.a.a(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
        } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
            this.a.b(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
        } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
            bundle.setClassLoader(RatingCompat.class.getClassLoader());
            this.a.a((RatingCompat) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING"), bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
        } else {
            this.a.e(str, bundle);
        }
    }

    public void onFastForward() {
        this.a.f();
    }

    public boolean onMediaButtonEvent(Intent intent) {
        return this.a.a(intent);
    }

    public void onPause() {
        this.a.c();
    }

    public void onPlay() {
        this.a.b();
    }

    public void onPlayFromMediaId(String str, Bundle bundle) {
        this.a.c(str, bundle);
    }

    public void onPlayFromSearch(String str, Bundle bundle) {
        this.a.d(str, bundle);
    }

    public void onRewind() {
        this.a.g();
    }

    public void onSeekTo(long j) {
        this.a.b(j);
    }

    public void onSetRating(Object obj) {
        this.a.a(RatingCompat.a(obj));
    }

    public void onSetRating(Object obj, Bundle bundle) {
        this.a.a(RatingCompat.a(obj), bundle);
    }

    public void onSkipToNext() {
        this.a.d();
    }

    public void onSkipToPrevious() {
        this.a.e();
    }

    public void onSkipToQueueItem(long j) {
        this.a.a(j);
    }

    public void onStop() {
        this.a.h();
    }
}
