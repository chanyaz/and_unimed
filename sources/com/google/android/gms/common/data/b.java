package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.ar;
import java.util.ArrayList;
import java.util.HashMap;

public class b {
    private final String[] a;
    private final ArrayList<HashMap<String, Object>> b;
    private final String c;
    private final HashMap<Object, Integer> d;
    private boolean e;
    private String f;

    private b(String[] strArr, String str) {
        this.a = (String[]) ar.a((Object) strArr);
        this.b = new ArrayList();
        this.c = str;
        this.d = new HashMap();
        this.e = false;
        this.f = null;
    }

    /* synthetic */ b(String[] strArr, String str, d dVar) {
        this(strArr, str);
    }
}
