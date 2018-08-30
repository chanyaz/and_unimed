package android.support.v4.media;

import android.media.AudioAttributes;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
class a {
    private static Method a;

    a() {
    }

    public static int a(b bVar) {
        Throwable e;
        AudioAttributes a = bVar.a();
        try {
            if (a == null) {
                a = AudioAttributes.class.getMethod("toLegacyStreamType", new Class[]{AudioAttributes.class});
            }
            return ((Integer) a.invoke(null, new Object[]{a})).intValue();
        } catch (NoSuchMethodException e2) {
            e = e2;
            Log.w("AudioAttributesCompat", "getLegacyStreamType() failed on API21+", e);
            return -1;
        } catch (InvocationTargetException e3) {
            e = e3;
            Log.w("AudioAttributesCompat", "getLegacyStreamType() failed on API21+", e);
            return -1;
        } catch (IllegalAccessException e4) {
            e = e4;
            Log.w("AudioAttributesCompat", "getLegacyStreamType() failed on API21+", e);
            return -1;
        } catch (ClassCastException e5) {
            e = e5;
            Log.w("AudioAttributesCompat", "getLegacyStreamType() failed on API21+", e);
            return -1;
        }
    }
}
