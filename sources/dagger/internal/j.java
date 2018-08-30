package dagger.internal;

import java.util.LinkedHashMap;
import java.util.Map;

public final class j {
    private j() {
    }

    public static Map<i<?>, Object> a(g gVar, Object[] objArr) {
        i a;
        Map linkedHashMap = new LinkedHashMap(objArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                break;
            }
            if (objArr[i2] instanceof Class) {
                a = gVar.a((Class) objArr[i2]);
                linkedHashMap.put(a, a.a());
            } else {
                linkedHashMap.put(gVar.a(objArr[i2].getClass()), objArr[i2]);
            }
            i = i2 + 1;
        }
        Map<i<?>, Object> linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        Map linkedHashMap3 = new LinkedHashMap();
        for (i a2 : linkedHashMap.keySet()) {
            a(gVar, a2, linkedHashMap3);
        }
        for (i a22 : linkedHashMap3.values()) {
            if (!linkedHashMap2.containsKey(a22)) {
                linkedHashMap2.put(a22, a22.a());
            }
        }
        return linkedHashMap2;
    }

    private static void a(g gVar, i<?> iVar, Map<Class<?>, i<?>> map) {
        for (Class cls : iVar.e) {
            if (!map.containsKey(cls)) {
                i a = gVar.a(cls);
                map.put(cls, a);
                a(gVar, a, map);
            }
        }
    }
}
