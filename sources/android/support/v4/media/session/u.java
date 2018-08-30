package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.session.MediaController.PlaybackInfo;

public class u {
    private static int a(AudioAttributes audioAttributes) {
        if ((audioAttributes.getFlags() & 1) == 1) {
            return 7;
        }
        if ((audioAttributes.getFlags() & 4) == 4) {
            return 6;
        }
        switch (audioAttributes.getUsage()) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 13:
                return 1;
            default:
                return 3;
        }
    }

    public static int a(Object obj) {
        return ((PlaybackInfo) obj).getPlaybackType();
    }

    public static AudioAttributes b(Object obj) {
        return ((PlaybackInfo) obj).getAudioAttributes();
    }

    public static int c(Object obj) {
        return a(b(obj));
    }

    public static int d(Object obj) {
        return ((PlaybackInfo) obj).getVolumeControl();
    }

    public static int e(Object obj) {
        return ((PlaybackInfo) obj).getMaxVolume();
    }

    public static int f(Object obj) {
        return ((PlaybackInfo) obj).getCurrentVolume();
    }
}
