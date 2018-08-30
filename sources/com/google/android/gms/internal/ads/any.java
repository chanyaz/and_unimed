package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class any {
    public final int a;
    public final byte[] b;
    public final Map<String, String> c;
    public final List<akt> d;
    public final boolean e;
    private final long f;

    private any(int i, byte[] bArr, Map<String, String> map, List<akt> list, boolean z, long j) {
        this.a = i;
        this.b = bArr;
        this.c = map;
        if (list == null) {
            this.d = null;
        } else {
            this.d = Collections.unmodifiableList(list);
        }
        this.e = z;
        this.f = j;
    }

    @Deprecated
    public any(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        List list;
        if (map == null) {
            list = null;
        } else if (map.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList(map.size());
            for (Entry entry : map.entrySet()) {
                list.add(new akt((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(i, bArr, map, list, z, j);
    }

    public any(int i, byte[] bArr, boolean z, long j, List<akt> list) {
        Map map;
        if (list == null) {
            map = null;
        } else if (list.isEmpty()) {
            map = Collections.emptyMap();
        } else {
            map = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (akt akt : list) {
                map.put(akt.a(), akt.b());
            }
        }
        this(i, bArr, map, list, z, j);
    }

    @Deprecated
    public any(byte[] bArr, Map<String, String> map) {
        this(200, bArr, (Map) map, false, 0);
    }
}
