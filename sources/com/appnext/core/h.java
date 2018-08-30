package com.appnext.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class h {

    public class a {
        private final Object lQ;
        private final String lR;
        private Class<?> lS;
        private List<Class<?>> lT = new ArrayList();
        private List<Object> lU = new ArrayList();
        private boolean lV;
        private boolean lW;

        public a(Object obj, String str) {
            this.lQ = obj;
            this.lR = str;
            this.lS = obj != null ? obj.getClass() : null;
        }

        public <T> a a(Class<T> cls, T t) {
            this.lT.add(cls);
            this.lU.add(t);
            return this;
        }

        public a b(Class<?> cls) {
            this.lW = true;
            this.lS = cls;
            return this;
        }

        public a de() {
            this.lV = true;
            return this;
        }

        public Object df() {
            Method a = h.a(this.lS, this.lR, (Class[]) this.lT.toArray(new Class[this.lT.size()]));
            if (this.lV) {
                a.setAccessible(true);
            }
            Object[] toArray = this.lU.toArray();
            return this.lW ? a.invoke(null, toArray) : a.invoke(this.lQ, toArray);
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
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

    public static boolean aQ(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
