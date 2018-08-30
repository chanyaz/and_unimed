package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.a;
import android.support.v4.content.res.b;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RequiresApi(14)
@RestrictTo({Scope.LIBRARY_GROUP})
class TypefaceCompatBaseImpl implements TypefaceCompatImpl {

    interface StyleExtractor<T> {
        int getWeight(T t);

        boolean isItalic(T t);
    }

    TypefaceCompatBaseImpl() {
    }

    private b a(a aVar, int i) {
        return (b) a(aVar.a(), i, new StyleExtractor<b>() {
            /* renamed from: a */
            public int getWeight(b bVar) {
                return bVar.b();
            }

            /* renamed from: b */
            public boolean isItalic(b bVar) {
                return bVar.c();
            }
        });
    }

    private static <T> T a(T[] tArr, int i, StyleExtractor<T> styleExtractor) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = MoPubClientPositioning.NO_REPEAT;
        int length = tArr.length;
        int i4 = 0;
        while (i4 < length) {
            T t2;
            T t3 = tArr[i4];
            int abs = (styleExtractor.isItalic(t3) == z ? 0 : 1) + (Math.abs(styleExtractor.getWeight(t3) - i2) * 2);
            if (t == null || i3 > abs) {
                i3 = abs;
                t2 = t3;
            } else {
                t2 = t;
            }
            i4++;
            t = t2;
        }
        return t;
    }

    protected Typeface a(Context context, InputStream inputStream) {
        Typeface typeface = null;
        File a = h.a(context);
        if (a != null) {
            try {
                if (h.a(a, inputStream)) {
                    typeface = Typeface.createFromFile(a.getPath());
                    a.delete();
                }
            } catch (RuntimeException e) {
            } finally {
                a.delete();
            }
        }
        return typeface;
    }

    protected android.support.v4.provider.b a(android.support.v4.provider.b[] bVarArr, int i) {
        return (android.support.v4.provider.b) a(bVarArr, i, new StyleExtractor<android.support.v4.provider.b>() {
            /* renamed from: a */
            public int getWeight(android.support.v4.provider.b bVar) {
                return bVar.c();
            }

            /* renamed from: b */
            public boolean isItalic(android.support.v4.provider.b bVar) {
                return bVar.d();
            }
        });
    }

    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, a aVar, Resources resources, int i) {
        b a = a(aVar, i);
        return a == null ? null : TypefaceCompat.a(context, resources, a.d(), a.a(), i);
    }

    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull android.support.v4.provider.b[] bVarArr, int i) {
        Throwable th;
        Typeface typeface = null;
        if (bVarArr.length >= 1) {
            Closeable openInputStream;
            try {
                openInputStream = context.getContentResolver().openInputStream(a(bVarArr, i).a());
                try {
                    typeface = a(context, (InputStream) openInputStream);
                    h.a(openInputStream);
                } catch (IOException e) {
                    h.a(openInputStream);
                    return typeface;
                } catch (Throwable th2) {
                    th = th2;
                    h.a(openInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                openInputStream = typeface;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                openInputStream = typeface;
                th = th4;
                h.a(openInputStream);
                throw th;
            }
        }
        return typeface;
    }

    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        Typeface typeface = null;
        File a = h.a(context);
        if (a != null) {
            try {
                if (h.a(a, resources, i)) {
                    typeface = Typeface.createFromFile(a.getPath());
                    a.delete();
                }
            } catch (RuntimeException e) {
            } finally {
                a.delete();
            }
        }
        return typeface;
    }
}
