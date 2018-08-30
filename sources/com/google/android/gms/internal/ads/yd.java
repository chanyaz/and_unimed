package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class yd<MessageType extends yd<MessageType, BuilderType>, BuilderType extends ye<MessageType, BuilderType>> extends wp<MessageType, BuilderType> {
    private static Map<Object, yd<?, ?>> zzdtv = new ConcurrentHashMap();
    protected aag zzdtt = aag.a();
    private int zzdtu = -1;

    private static <T extends yd<T, ?>> T a(T t, xg xgVar, xs xsVar) {
        Object obj = (yd) t.a(yi.d, null, null);
        try {
            zl.a().a(obj).zza(obj, xj.a(xgVar), xsVar);
            zl.a().a(obj).zzo(obj);
            return obj;
        } catch (IOException e) {
            if (e.getCause() instanceof zzbbu) {
                throw ((zzbbu) e.getCause());
            }
            throw new zzbbu(e.getMessage()).a(obj);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzbbu) {
                throw ((zzbbu) e2.getCause());
            }
            throw e2;
        }
    }

    protected static <T extends yd<T, ?>> T a(T t, zzbah zzbah) {
        byte byteValue;
        boolean z;
        boolean zzaa;
        Object a = a((yd) t, zzbah, xs.a());
        if (a != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byteValue = ((Byte) a.a(yi.a, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                z = true;
            } else if (byteValue == (byte) 0) {
                z = false;
            } else {
                zzaa = zl.a().a(a).zzaa(a);
                if (booleanValue) {
                    a.a(yi.b, zzaa ? a : null, null);
                }
                z = zzaa;
            }
            if (!z) {
                throw new zzbed(a).a().a(a);
            }
        }
        if (a != null) {
            zzaa = Boolean.TRUE.booleanValue();
            byteValue = ((Byte) a.a(yi.a, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                z = true;
            } else if (byteValue == (byte) 0) {
                z = false;
            } else {
                boolean zzaa2 = zl.a().a(a).zzaa(a);
                if (zzaa) {
                    a.a(yi.b, zzaa2 ? a : null, null);
                }
                z = zzaa2;
            }
            if (!z) {
                throw new zzbed(a).a().a(a);
            }
        }
        return a;
    }

    private static <T extends yd<T, ?>> T a(T t, zzbah zzbah, xs xsVar) {
        T a;
        try {
            xg e = zzbah.e();
            a = a((yd) t, e, xsVar);
            e.a(0);
            return a;
        } catch (zzbbu e2) {
            throw e2.a(a);
        } catch (zzbbu e22) {
            throw e22;
        }
    }

    protected static <T extends yd<T, ?>> T a(T t, byte[] bArr) {
        Object b = b(t, bArr);
        if (b != null) {
            boolean z;
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) b.a(yi.a, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                z = true;
            } else if (byteValue == (byte) 0) {
                z = false;
            } else {
                boolean zzaa = zl.a().a(b).zzaa(b);
                if (booleanValue) {
                    b.a(yi.b, zzaa ? b : null, null);
                }
                z = zzaa;
            }
            if (!z) {
                throw new zzbed(b).a().a(b);
            }
        }
        return b;
    }

    static <T extends yd<?, ?>> T a(Class<T> cls) {
        T t = (yd) zzdtv.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (yd) zzdtv.get(cls);
            } catch (Throwable e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        String str = "Unable to get default instance for: ";
        String valueOf = String.valueOf(cls.getName());
        throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    protected static Object a(zzbcu zzbcu, String str, Object[] objArr) {
        return new zn(zzbcu, str, objArr);
    }

    static Object a(Method method, Object obj, Object... objArr) {
        Throwable e;
        try {
            return method.invoke(obj, objArr);
        } catch (Throwable e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            e2 = e3.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", e2);
            }
        }
    }

    protected static <T extends yd<?, ?>> void a(Class<T> cls, T t) {
        zzdtv.put(cls, t);
    }

    protected static final <T extends yd<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(yi.a, null, null)).byteValue();
        return byteValue == (byte) 1 ? true : byteValue == (byte) 0 ? false : zl.a().a((Object) t).zzaa(t);
    }

    private static <T extends yd<T, ?>> T b(T t, byte[] bArr) {
        Object obj = (yd) t.a(yi.d, null, null);
        try {
            zl.a().a(obj).zza(obj, bArr, 0, bArr.length, new ww());
            zl.a().a(obj).zzo(obj);
            if (obj.zzdpf == 0) {
                return obj;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzbbu) {
                throw ((zzbbu) e.getCause());
            }
            throw new zzbbu(e.getMessage()).a(obj);
        } catch (IndexOutOfBoundsException e2) {
            throw zzbbu.a().a(obj);
        }
    }

    protected static <E> zzbbt<E> i() {
        return zm.b();
    }

    protected abstract Object a(int i, Object obj, Object obj2);

    final void a(int i) {
        this.zzdtu = i;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !((yd) a(yi.f, null, null)).getClass().isInstance(obj) ? false : zl.a().a((Object) this).equals(this, (yd) obj);
    }

    final int h() {
        return this.zzdtu;
    }

    public int hashCode() {
        if (this.zzdpf != 0) {
            return this.zzdpf;
        }
        this.zzdpf = zl.a().a((Object) this).hashCode(this);
        return this.zzdpf;
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) a(yi.a, null, null)).byteValue();
        if (byteValue == (byte) 1) {
            return true;
        }
        if (byteValue == (byte) 0) {
            return false;
        }
        boolean zzaa = zl.a().a((Object) this).zzaa(this);
        if (booleanValue) {
            a(yi.b, zzaa ? this : null, null);
        }
        return zzaa;
    }

    public String toString() {
        return ze.a(this, super.toString());
    }

    public final int zzacw() {
        if (this.zzdtu == -1) {
            this.zzdtu = zl.a().a((Object) this).zzy(this);
        }
        return this.zzdtu;
    }

    public final /* synthetic */ zzbcv zzade() {
        ye yeVar = (ye) a(yi.e, null, null);
        yeVar.a(this);
        return yeVar;
    }

    public final /* synthetic */ zzbcv zzadf() {
        return (ye) a(yi.e, null, null);
    }

    public final /* synthetic */ zzbcu zzadg() {
        return (yd) a(yi.f, null, null);
    }

    public final void zzb(zzbav zzbav) {
        zl.a().a(getClass()).zza(this, xn.a(zzbav));
    }
}
