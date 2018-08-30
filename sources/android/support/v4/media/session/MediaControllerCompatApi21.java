package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiresApi(21)
class MediaControllerCompatApi21 {

    public interface Callback {
        void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5);

        void onExtrasChanged(Bundle bundle);

        void onMetadataChanged(Object obj);

        void onPlaybackStateChanged(Object obj);

        void onQueueChanged(List<?> list);

        void onQueueTitleChanged(CharSequence charSequence);

        void onSessionDestroyed();

        void onSessionEvent(String str, Bundle bundle);
    }

    MediaControllerCompatApi21() {
    }

    public static Object a(Context context, Object obj) {
        return new MediaController(context, (Token) obj);
    }

    public static Object a(Callback callback) {
        return new t(callback);
    }

    public static Object a(Object obj) {
        return ((MediaController) obj).getTransportControls();
    }

    public static void a(Object obj, int i, int i2) {
        ((MediaController) obj).setVolumeTo(i, i2);
    }

    public static void a(Object obj, Object obj2) {
        ((MediaController) obj).unregisterCallback((android.media.session.MediaController.Callback) obj2);
    }

    public static void a(Object obj, Object obj2, Handler handler) {
        ((MediaController) obj).registerCallback((android.media.session.MediaController.Callback) obj2, handler);
    }

    public static void a(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }

    public static boolean a(Object obj, KeyEvent keyEvent) {
        return ((MediaController) obj).dispatchMediaButtonEvent(keyEvent);
    }

    public static Object b(Object obj) {
        return ((MediaController) obj).getPlaybackState();
    }

    public static void b(Object obj, int i, int i2) {
        ((MediaController) obj).adjustVolume(i, i2);
    }

    public static Object c(Object obj) {
        return ((MediaController) obj).getMetadata();
    }

    public static List<Object> d(Object obj) {
        Collection queue = ((MediaController) obj).getQueue();
        return queue == null ? null : new ArrayList(queue);
    }

    public static CharSequence e(Object obj) {
        return ((MediaController) obj).getQueueTitle();
    }

    public static Bundle f(Object obj) {
        return ((MediaController) obj).getExtras();
    }

    public static int g(Object obj) {
        return ((MediaController) obj).getRatingType();
    }

    public static long h(Object obj) {
        return ((MediaController) obj).getFlags();
    }

    public static Object i(Object obj) {
        return ((MediaController) obj).getPlaybackInfo();
    }

    public static PendingIntent j(Object obj) {
        return ((MediaController) obj).getSessionActivity();
    }

    public static String k(Object obj) {
        return ((MediaController) obj).getPackageName();
    }
}
