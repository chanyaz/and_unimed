package com.mopub.common.util;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Reflection {

    public class MethodBuilder {
        private final Object a;
        private final String b;
        private Class<?> c;
        private List<Class<?>> d = new ArrayList();
        private List<Object> e = new ArrayList();
        private boolean f;
        private boolean g;

        public MethodBuilder(Object obj, String str) {
            this.a = obj;
            this.b = str;
            this.c = obj != null ? obj.getClass() : null;
        }

        public <T> MethodBuilder addParam(Class<T> cls, T t) {
            this.d.add(cls);
            this.e.add(t);
            return this;
        }

        public Object execute() {
            Method declaredMethodWithTraversal = Reflection.getDeclaredMethodWithTraversal(this.c, this.b, (Class[]) this.d.toArray(new Class[this.d.size()]));
            if (this.f) {
                declaredMethodWithTraversal.setAccessible(true);
            }
            Object[] toArray = this.e.toArray();
            return this.g ? declaredMethodWithTraversal.invoke(null, toArray) : declaredMethodWithTraversal.invoke(this.a, toArray);
        }

        public MethodBuilder setAccessible() {
            this.f = true;
            return this;
        }

        public MethodBuilder setStatic(Class<?> cls) {
            this.g = true;
            this.c = cls;
            return this;
        }
    }

    public static boolean classFound(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static Method getDeclaredMethodWithTraversal(Class<?> cls, String str, Class<?>... clsArr) {
        Class cls2;
        while (cls2 != null) {
            try {
                return cls2.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e) {
                cls2 = cls2.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static <T> T instantiateClassWithEmptyConstructor(@NonNull String str, @NonNull Class<? extends T> cls) {
        Preconditions.checkNotNull(str);
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor((Class[]) null);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }
}
