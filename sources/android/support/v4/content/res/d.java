package android.support.v4.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.annotation.FontRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry;
import android.support.v4.graphics.TypefaceCompat;
import android.util.Log;
import android.util.TypedValue;

public final class d {
    private d() {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static Typeface a(@NonNull Context context, @FontRes int i, TypedValue typedValue, int i2, @Nullable e eVar) {
        return context.isRestricted() ? null : a(context, i, typedValue, i2, eVar, null, true);
    }

    private static Typeface a(@NonNull Context context, int i, TypedValue typedValue, int i2, @Nullable e eVar, @Nullable Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a = a(context, resources, typedValue, i, i2, eVar, handler, z);
        if (a != null || eVar != null) {
            return a;
        }
        throw new NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    private static Typeface a(@NonNull Context context, Resources resources, TypedValue typedValue, int i, int i2, @Nullable e eVar, @Nullable Handler handler, boolean z) {
        if (typedValue.string == null) {
            throw new NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String charSequence = typedValue.string.toString();
        if (charSequence.startsWith("res/")) {
            Typeface a = TypefaceCompat.a(resources, i, i2);
            if (a == null) {
                try {
                    if (charSequence.toLowerCase().endsWith(".xml")) {
                        FamilyResourceEntry a2 = FontResourcesParserCompat.a(resources.getXml(i), resources);
                        if (a2 != null) {
                            return TypefaceCompat.a(context, a2, resources, i, i2, eVar, handler, z);
                        }
                        Log.e("ResourcesCompat", "Failed to find font-family tag");
                        if (eVar != null) {
                            eVar.a(-3, handler);
                        }
                        return null;
                    }
                    a = TypefaceCompat.a(context, resources, i, charSequence, i2);
                    if (eVar == null) {
                        return a;
                    }
                    if (a != null) {
                        eVar.a(a, handler);
                        return a;
                    }
                    eVar.a(-3, handler);
                    return a;
                } catch (Throwable e) {
                    Log.e("ResourcesCompat", "Failed to parse xml resource " + charSequence, e);
                } catch (Throwable e2) {
                    Log.e("ResourcesCompat", "Failed to read xml resource " + charSequence, e2);
                }
            } else if (eVar == null) {
                return a;
            } else {
                eVar.a(a, handler);
                return a;
            }
        }
        if (eVar != null) {
            eVar.a(-3, handler);
        }
        return null;
        if (eVar != null) {
            eVar.a(-3, handler);
        }
        return null;
    }

    @Nullable
    public static Drawable a(@NonNull Resources resources, @DrawableRes int i, @Nullable Theme theme) {
        return VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }
}
