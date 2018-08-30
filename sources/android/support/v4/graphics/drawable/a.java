package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class a {
    private static Method a;
    private static boolean b;
    private static Method c;
    private static boolean d;

    private a() {
    }

    @Deprecated
    public static void a(@NonNull Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void a(@NonNull Drawable drawable, float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f, f2);
        }
    }

    public static void a(@NonNull Drawable drawable, @ColorInt int i) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTint(i);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTint(i);
        }
    }

    public static void a(@NonNull Drawable drawable, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    public static void a(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintList(colorStateList);
        }
    }

    public static void a(@NonNull Drawable drawable, @NonNull Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static void a(@NonNull Drawable drawable, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static void a(@NonNull Drawable drawable, @NonNull Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintMode(mode);
        }
    }

    public static void a(@NonNull Drawable drawable, boolean z) {
        if (VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    public static boolean b(@NonNull Drawable drawable) {
        return VERSION.SDK_INT >= 19 ? drawable.isAutoMirrored() : false;
    }

    public static boolean b(@NonNull Drawable drawable, int i) {
        if (VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (!b) {
            try {
                a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            b = true;
        }
        if (a != null) {
            try {
                a.invoke(drawable, new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Throwable e2) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                a = null;
            }
        }
        return false;
    }

    public static int c(@NonNull Drawable drawable) {
        return VERSION.SDK_INT >= 19 ? drawable.getAlpha() : 0;
    }

    public static boolean d(@NonNull Drawable drawable) {
        return VERSION.SDK_INT >= 21 ? drawable.canApplyTheme() : false;
    }

    public static ColorFilter e(@NonNull Drawable drawable) {
        return VERSION.SDK_INT >= 21 ? drawable.getColorFilter() : null;
    }

    public static void f(@NonNull Drawable drawable) {
        if (VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
        } else if (VERSION.SDK_INT >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                f(((InsetDrawable) drawable).getDrawable());
            } else if (drawable instanceof WrappedDrawable) {
                f(((WrappedDrawable) drawable).getWrappedDrawable());
            } else if (drawable instanceof DrawableContainer) {
                DrawableContainerState drawableContainerState = (DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
                if (drawableContainerState != null) {
                    int childCount = drawableContainerState.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        Drawable child = drawableContainerState.getChild(i);
                        if (child != null) {
                            f(child);
                        }
                    }
                }
            }
        } else {
            drawable.clearColorFilter();
        }
    }

    public static Drawable g(@NonNull Drawable drawable) {
        return VERSION.SDK_INT >= 23 ? drawable : VERSION.SDK_INT >= 21 ? !(drawable instanceof TintAwareDrawable) ? new g(drawable) : drawable : VERSION.SDK_INT >= 19 ? !(drawable instanceof TintAwareDrawable) ? new e(drawable) : drawable : !(drawable instanceof TintAwareDrawable) ? new b(drawable) : drawable;
    }

    public static <T extends Drawable> T h(@NonNull Drawable drawable) {
        return drawable instanceof WrappedDrawable ? ((WrappedDrawable) drawable).getWrappedDrawable() : drawable;
    }

    public static int i(@NonNull Drawable drawable) {
        if (VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (VERSION.SDK_INT < 17) {
            return 0;
        }
        if (!d) {
            try {
                c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e);
            }
            d = true;
        }
        if (c != null) {
            try {
                return ((Integer) c.invoke(drawable, new Object[0])).intValue();
            } catch (Throwable e2) {
                Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e2);
                c = null;
            }
        }
        return 0;
    }
}
