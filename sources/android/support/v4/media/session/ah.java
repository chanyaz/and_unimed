package android.support.v4.media.session;

import android.media.session.PlaybackState.CustomAction;
import android.media.session.PlaybackState.CustomAction.Builder;
import android.os.Bundle;

final class ah {
    ah() {
    }

    public static Object a(String str, CharSequence charSequence, int i, Bundle bundle) {
        Builder builder = new Builder(str, charSequence, i);
        builder.setExtras(bundle);
        return builder.build();
    }

    public static String a(Object obj) {
        return ((CustomAction) obj).getAction();
    }

    public static CharSequence b(Object obj) {
        return ((CustomAction) obj).getName();
    }

    public static int c(Object obj) {
        return ((CustomAction) obj).getIcon();
    }

    public static Bundle d(Object obj) {
        return ((CustomAction) obj).getExtras();
    }
}
