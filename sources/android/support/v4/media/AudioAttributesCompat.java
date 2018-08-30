package android.support.v4.media;

import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.util.SparseIntArray;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class AudioAttributesCompat {
    private static final SparseIntArray e = new SparseIntArray();
    private static boolean f;
    private static final int[] g = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    int a = 0;
    int b = 0;
    int c = 0;
    Integer d;
    private b h;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeContentType {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeUsage {
    }

    static {
        e.put(5, 1);
        e.put(6, 2);
        e.put(7, 2);
        e.put(8, 1);
        e.put(9, 1);
        e.put(10, 1);
    }

    private AudioAttributesCompat() {
    }

    static int a(boolean z, int i, int i2) {
        int i3 = 0;
        if ((i & 1) == 1) {
            return z ? 1 : 7;
        } else {
            if ((i & 4) == 4) {
                return z ? 0 : 6;
            } else {
                switch (i2) {
                    case 0:
                        return z ? Integer.MIN_VALUE : 3;
                    case 1:
                    case 12:
                    case 14:
                    case 16:
                        return 3;
                    case 2:
                        return 0;
                    case 3:
                        if (!z) {
                            i3 = 8;
                        }
                        return i3;
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
                    case 11:
                        return 10;
                    case 13:
                        return 1;
                    default:
                        if (!z) {
                            return 3;
                        }
                        throw new IllegalArgumentException("Unknown usage value " + i2 + " in audio attributes");
                }
            }
        }
    }

    static String a(int i) {
        switch (i) {
            case 0:
                return new String("USAGE_UNKNOWN");
            case 1:
                return new String("USAGE_MEDIA");
            case 2:
                return new String("USAGE_VOICE_COMMUNICATION");
            case 3:
                return new String("USAGE_VOICE_COMMUNICATION_SIGNALLING");
            case 4:
                return new String("USAGE_ALARM");
            case 5:
                return new String("USAGE_NOTIFICATION");
            case 6:
                return new String("USAGE_NOTIFICATION_RINGTONE");
            case 7:
                return new String("USAGE_NOTIFICATION_COMMUNICATION_REQUEST");
            case 8:
                return new String("USAGE_NOTIFICATION_COMMUNICATION_INSTANT");
            case 9:
                return new String("USAGE_NOTIFICATION_COMMUNICATION_DELAYED");
            case 10:
                return new String("USAGE_NOTIFICATION_EVENT");
            case 11:
                return new String("USAGE_ASSISTANCE_ACCESSIBILITY");
            case 12:
                return new String("USAGE_ASSISTANCE_NAVIGATION_GUIDANCE");
            case 13:
                return new String("USAGE_ASSISTANCE_SONIFICATION");
            case 14:
                return new String("USAGE_GAME");
            case 16:
                return new String("USAGE_ASSISTANT");
            default:
                return new String("unknown usage " + i);
        }
    }

    @Nullable
    public Object a() {
        return this.h != null ? this.h.a() : null;
    }

    public int b() {
        return this.d != null ? this.d.intValue() : (VERSION.SDK_INT < 21 || f) ? a(false, this.c, this.a) : a.a(this.h);
    }

    public int c() {
        return (VERSION.SDK_INT < 21 || f || this.h == null) ? this.b : this.h.a().getContentType();
    }

    public int d() {
        return (VERSION.SDK_INT < 21 || f || this.h == null) ? this.a : this.h.a().getUsage();
    }

    public int e() {
        if (VERSION.SDK_INT >= 21 && !f && this.h != null) {
            return this.h.a().getFlags();
        }
        int i = this.c;
        int b = b();
        if (b == 6) {
            i |= 4;
        } else if (b == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        if (VERSION.SDK_INT >= 21 && !f && this.h != null) {
            return this.h.a().equals(audioAttributesCompat.a());
        }
        if (this.b == audioAttributesCompat.c() && this.c == audioAttributesCompat.e() && this.a == audioAttributesCompat.d()) {
            if (this.d != null) {
                if (this.d.equals(audioAttributesCompat.d)) {
                    return true;
                }
            } else if (audioAttributesCompat.d == null) {
                return true;
            }
        }
        return false;
    }

    String f() {
        return a(this.a);
    }

    public int hashCode() {
        if (VERSION.SDK_INT >= 21 && !f && this.h != null) {
            return this.h.a().hashCode();
        }
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.a), this.d});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AudioAttributesCompat:");
        if (a() != null) {
            stringBuilder.append(" audioattributes=").append(a());
        } else {
            if (this.d != null) {
                stringBuilder.append(" stream=").append(this.d);
                stringBuilder.append(" derived");
            }
            stringBuilder.append(" usage=").append(f()).append(" content=").append(this.b).append(" flags=0x").append(Integer.toHexString(this.c).toUpperCase());
        }
        return stringBuilder.toString();
    }
}
