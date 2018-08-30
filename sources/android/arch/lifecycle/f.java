package android.arch.lifecycle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({Scope.LIBRARY_GROUP})
public class f {
    private static Map<Class, Integer> a = new HashMap();
    private static Map<Class, List<Constructor<? extends GeneratedAdapter>>> b = new HashMap();

    private static GeneratedAdapter a(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return (GeneratedAdapter) constructor.newInstance(new Object[]{obj});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        } catch (Throwable e22) {
            throw new RuntimeException(e22);
        }
    }

    @NonNull
    static GenericLifecycleObserver a(Object obj) {
        int i = 0;
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class cls = obj.getClass();
        if (b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = (List) b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
            }
            generatedAdapterArr[i2] = a((Constructor) list.get(i2), obj);
            i = i2 + 1;
        }
    }

    public static String a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    @Nullable
    private static Constructor<? extends GeneratedAdapter> a(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            canonicalName = a(canonicalName);
            if (!name.isEmpty()) {
                canonicalName = name + "." + canonicalName;
            }
            Constructor<? extends GeneratedAdapter> declaredConstructor = Class.forName(canonicalName).getDeclaredConstructor(new Class[]{cls});
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static int b(Class<?> cls) {
        if (a.containsKey(cls)) {
            return ((Integer) a.get(cls)).intValue();
        }
        int c = c(cls);
        a.put(cls, Integer.valueOf(c));
        return c;
    }

    private static int c(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor a = a((Class) cls);
        if (a != null) {
            b.put(cls, Collections.singletonList(a));
            return 2;
        } else if (a.a.a(cls)) {
            return 1;
        } else {
            Class superclass = cls.getSuperclass();
            List list = null;
            if (d(superclass)) {
                if (b(superclass) == 1) {
                    return 1;
                }
                list = new ArrayList((Collection) b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (d(cls2)) {
                    if (b(cls2) == 1) {
                        return 1;
                    }
                    List arrayList = list == null ? new ArrayList() : list;
                    arrayList.addAll((Collection) b.get(cls2));
                    list = arrayList;
                }
            }
            if (list == null) {
                return 1;
            }
            b.put(cls, list);
            return 2;
        }
    }

    private static boolean d(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }
}
