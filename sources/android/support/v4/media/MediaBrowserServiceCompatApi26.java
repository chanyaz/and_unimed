package android.support.v4.media;

import android.os.Bundle;
import android.service.media.MediaBrowserService.Result;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.Field;

@RequiresApi(26)
class MediaBrowserServiceCompatApi26 {
    private static Field a;

    public interface ServiceCompatProxy extends android.support.v4.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String str, ag agVar, Bundle bundle);
    }

    static {
        try {
            a = Result.class.getDeclaredField("mFlags");
            a.setAccessible(true);
        } catch (Throwable e) {
            Log.w("MBSCompatApi26", e);
        }
    }

    MediaBrowserServiceCompatApi26() {
    }
}
