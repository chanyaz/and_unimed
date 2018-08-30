package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import android.support.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class a {
    static a a = new a();
    private final Map<Class, b> b = new HashMap();
    private final Map<Class, Boolean> c = new HashMap();

    a() {
    }

    private b a(Class cls, @Nullable Method[] methodArr) {
        b b;
        Class superclass = cls.getSuperclass();
        Map hashMap = new HashMap();
        if (superclass != null) {
            b = b(superclass);
            if (b != null) {
                hashMap.putAll(b.b);
            }
        }
        for (Class b2 : cls.getInterfaces()) {
            for (Entry entry : b(b2).b.entrySet()) {
                a(hashMap, (c) entry.getKey(), (Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        int length = methodArr.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            boolean z2;
            Method method = methodArr[i];
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent == null) {
                z2 = z;
            } else {
                int i2;
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else if (parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    i2 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value != Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    } else {
                        i2 = 2;
                    }
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(hashMap, new c(i2, method), value, cls);
                z2 = true;
            }
            i++;
            z = z2;
        }
        b = new b(hashMap);
        this.b.put(cls, b);
        this.c.put(cls, Boolean.valueOf(z));
        return b;
    }

    private void a(Map<c, Event> map, c cVar, Event event, Class cls) {
        Event event2 = (Event) map.get(cVar);
        if (event2 != null && event != event2) {
            throw new IllegalArgumentException("Method " + cVar.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous" + " value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(cVar, event);
        }
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (Throwable e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    boolean a(Class cls) {
        if (this.c.containsKey(cls)) {
            return ((Boolean) this.c.get(cls)).booleanValue();
        }
        Method[] c = c(cls);
        for (Method annotation : c) {
            if (((OnLifecycleEvent) annotation.getAnnotation(OnLifecycleEvent.class)) != null) {
                a(cls, c);
                return true;
            }
        }
        this.c.put(cls, Boolean.valueOf(false));
        return false;
    }

    b b(Class cls) {
        b bVar = (b) this.b.get(cls);
        return bVar != null ? bVar : a(cls, null);
    }
}
