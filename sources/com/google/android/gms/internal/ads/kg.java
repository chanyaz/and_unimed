package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class kg {
    long a;
    final String b;
    final String c;
    final long d;
    final long e;
    final long f;
    final long g;
    final List<akt> h;

    kg(String str, acs acs) {
        List list;
        String str2 = acs.b;
        long j = acs.c;
        long j2 = acs.d;
        long j3 = acs.e;
        long j4 = acs.f;
        if (acs.h != null) {
            list = acs.h;
        } else {
            Map map = acs.g;
            list = new ArrayList(map.size());
            for (Entry entry : map.entrySet()) {
                list.add(new akt((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j, j2, j3, j4, list);
        this.a = (long) acs.a.length;
    }

    private kg(String str, String str2, long j, long j2, long j3, long j4, List<akt> list) {
        this.b = str;
        if ("".equals(str2)) {
            str2 = null;
        }
        this.c = str2;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = j4;
        this.h = list;
    }

    static kg a(lb lbVar) {
        if (jh.a((InputStream) lbVar) == 538247942) {
            return new kg(jh.a(lbVar), jh.a(lbVar), jh.b((InputStream) lbVar), jh.b((InputStream) lbVar), jh.b((InputStream) lbVar), jh.b((InputStream) lbVar), jh.b(lbVar));
        }
        throw new IOException();
    }

    final boolean a(OutputStream outputStream) {
        try {
            jh.a(outputStream, 538247942);
            jh.a(outputStream, this.b);
            jh.a(outputStream, this.c == null ? "" : this.c);
            jh.a(outputStream, this.d);
            jh.a(outputStream, this.e);
            jh.a(outputStream, this.f);
            jh.a(outputStream, this.g);
            List<akt> list = this.h;
            if (list != null) {
                jh.a(outputStream, list.size());
                for (akt akt : list) {
                    jh.a(outputStream, akt.a());
                    jh.a(outputStream, akt.b());
                }
            } else {
                jh.a(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            dc.b("%s", e.toString());
            return false;
        }
    }
}
