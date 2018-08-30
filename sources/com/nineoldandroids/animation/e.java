package com.nineoldandroids.animation;

import com.nineoldandroids.util.a;
import java.lang.reflect.Method;
import java.util.HashMap;

public class e implements Cloneable {
    private static final TypeEvaluator d = new b();
    private static final TypeEvaluator e = new a();
    private static Class[] f = new Class[]{Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};
    private static Class[] g = new Class[]{Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};
    private static Class[] h = new Class[]{Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
    private static final HashMap<Class, HashMap<String, Method>> i = new HashMap();
    private static final HashMap<Class, HashMap<String, Method>> j = new HashMap();
    String a;
    protected a b;
    d c;
    private TypeEvaluator k;

    /* renamed from: a */
    public e clone() {
        try {
            e eVar = (e) super.clone();
            eVar.a = this.a;
            eVar.b = this.b;
            eVar.c = this.c.clone();
            eVar.k = this.k;
            return eVar;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String b() {
        return this.a;
    }

    public String toString() {
        return this.a + ": " + this.c.toString();
    }
}
