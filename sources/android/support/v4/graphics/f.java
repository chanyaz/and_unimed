package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.a;
import android.support.v4.content.res.b;
import android.support.v4.util.s;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

@RequiresApi(24)
@RestrictTo({Scope.LIBRARY_GROUP})
class f extends TypefaceCompatBaseImpl {
    private static final Class a;
    private static final Constructor b;
    private static final Method c;
    private static final Method d;

    static {
        Method method;
        Constructor constructor;
        Class cls;
        Throwable e;
        Method method2 = null;
        try {
            Class cls2 = Class.forName("android.graphics.FontFamily");
            Constructor constructor2 = cls2.getConstructor(new Class[0]);
            Method method3 = cls2.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls2, 1).getClass()});
            method2 = method3;
            constructor = constructor2;
            cls = cls2;
        } catch (ClassNotFoundException e2) {
            e = e2;
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            method = null;
            constructor = null;
            cls = null;
            b = constructor;
            a = cls;
            c = method2;
            d = method;
        } catch (NoSuchMethodException e3) {
            e = e3;
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            method = null;
            constructor = null;
            cls = null;
            b = constructor;
            a = cls;
            c = method2;
            d = method;
        }
        b = constructor;
        a = cls;
        c = method2;
        d = method;
    }

    f() {
    }

    private static Typeface a(Object obj) {
        Throwable e;
        try {
            Array.set(Array.newInstance(a, 1), 0, obj);
            return (Typeface) d.invoke(null, new Object[]{r0});
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    public static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        Throwable e;
        try {
            return ((Boolean) c.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (InvocationTargetException e3) {
            e = e3;
        }
        throw new RuntimeException(e);
    }

    private static Object b() {
        Throwable e;
        try {
            return b.newInstance(new Object[0]);
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (InstantiationException e3) {
            e = e3;
        } catch (InvocationTargetException e4) {
            e = e4;
        }
        throw new RuntimeException(e);
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, a aVar, Resources resources, int i) {
        Object b = b();
        for (b bVar : aVar.a()) {
            ByteBuffer a = h.a(context, resources, bVar.d());
            if (a == null || !a(b, a, 0, bVar.b(), bVar.c())) {
                return null;
            }
        }
        return a(b);
    }

    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull android.support.v4.provider.b[] bVarArr, int i) {
        Object b = b();
        s sVar = new s();
        for (android.support.v4.provider.b bVar : bVarArr) {
            Uri a = bVar.a();
            ByteBuffer byteBuffer = (ByteBuffer) sVar.get(a);
            if (byteBuffer == null) {
                byteBuffer = h.a(context, cancellationSignal, a);
                sVar.put(a, byteBuffer);
            }
            if (!a(b, byteBuffer, bVar.b(), bVar.c(), bVar.d())) {
                return null;
            }
        }
        return Typeface.create(a(b), i);
    }
}
