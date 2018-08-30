package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.Builder;
import android.media.session.PlaybackState.CustomAction;
import android.support.annotation.RequiresApi;
import java.util.Iterator;
import java.util.List;

@RequiresApi(21)
class ag {
    ag() {
    }

    public static int a(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static Object a(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<Object> list, long j5) {
        Builder builder = new Builder();
        builder.setState(i, j, f, j4);
        builder.setBufferedPosition(j2);
        builder.setActions(j3);
        builder.setErrorMessage(charSequence);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            builder.addCustomAction((CustomAction) it.next());
        }
        builder.setActiveQueueItemId(j5);
        return builder.build();
    }

    public static long b(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static long c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static float d(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long e(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static CharSequence f(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long g(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static List<Object> h(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static long i(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }
}
