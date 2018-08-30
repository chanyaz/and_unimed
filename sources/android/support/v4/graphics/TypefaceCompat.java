package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry;
import android.support.v4.content.res.a;
import android.support.v4.content.res.c;
import android.support.v4.content.res.e;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.provider.b;
import android.support.v4.util.g;

@RestrictTo({Scope.LIBRARY_GROUP})
public class TypefaceCompat {
    private static final TypefaceCompatImpl a;
    private static final g<String, Typeface> b = new g(16);

    interface TypefaceCompatImpl {
        Typeface createFromFontFamilyFilesResourceEntry(Context context, a aVar, Resources resources, int i);

        Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull b[] bVarArr, int i);

        Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2);
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            a = new g();
        } else if (VERSION.SDK_INT >= 24 && f.a()) {
            a = new f();
        } else if (VERSION.SDK_INT >= 21) {
            a = new e();
        } else {
            a = new TypefaceCompatBaseImpl();
        }
    }

    private TypefaceCompat() {
    }

    @Nullable
    public static Typeface a(@NonNull Context context, @NonNull Resources resources, int i, String str, int i2) {
        Typeface createFromResourcesFontFile = a.createFromResourcesFontFile(context, resources, i, str, i2);
        if (createFromResourcesFontFile != null) {
            b.put(b(resources, i, i2), createFromResourcesFontFile);
        }
        return createFromResourcesFontFile;
    }

    @Nullable
    public static Typeface a(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull b[] bVarArr, int i) {
        return a.createFromFontInfo(context, cancellationSignal, bVarArr, i);
    }

    @Nullable
    public static Typeface a(@NonNull Context context, @NonNull FamilyResourceEntry familyResourceEntry, @NonNull Resources resources, int i, int i2, @Nullable e eVar, @Nullable Handler handler, boolean z) {
        Typeface a;
        boolean z2 = true;
        if (familyResourceEntry instanceof c) {
            c cVar = (c) familyResourceEntry;
            if (z) {
                if (cVar.b() != 0) {
                    z2 = false;
                }
            } else if (eVar != null) {
                z2 = false;
            }
            a = FontsContractCompat.a(context, cVar.a(), eVar, handler, z2, z ? cVar.c() : -1, i2);
        } else {
            a = a.createFromFontFamilyFilesResourceEntry(context, (a) familyResourceEntry, resources, i2);
            if (eVar != null) {
                if (a != null) {
                    eVar.a(a, handler);
                } else {
                    eVar.a(-3, handler);
                }
            }
        }
        if (a != null) {
            b.put(b(resources, i, i2), a);
        }
        return a;
    }

    @Nullable
    public static Typeface a(@NonNull Resources resources, int i, int i2) {
        return (Typeface) b.get(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
