package com.google.android.exoplayer.smoothstreaming;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.smoothstreaming.SmoothStreamingManifestParser.MissingFieldException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

class h extends e {
    private final String a;
    private final List<d> b = new LinkedList();
    private int c;
    private String d;
    private long e;
    private String f;
    private int g;
    private String h;
    private int i;
    private int j;
    private int k;
    private int l;
    private String m;
    private ArrayList<Long> n;
    private long o;

    public h(e eVar, String str) {
        super(eVar, str, "StreamIndex");
        this.a = str;
    }

    private void e(XmlPullParser xmlPullParser) {
        int size = this.n.size();
        long a = a(xmlPullParser, "t", -1);
        if (a == -1) {
            if (size == 0) {
                a = 0;
            } else if (this.o != -1) {
                a = ((Long) this.n.get(size - 1)).longValue() + this.o;
            } else {
                throw new ParserException("Unable to infer start time");
            }
        }
        int i = size + 1;
        this.n.add(Long.valueOf(a));
        this.o = a(xmlPullParser, "d", -1);
        long a2 = a(xmlPullParser, "r", 1);
        if (a2 <= 1 || this.o != -1) {
            for (size = 1; ((long) size) < a2; size++) {
                i++;
                this.n.add(Long.valueOf((this.o * ((long) size)) + a));
            }
            return;
        }
        throw new ParserException("Repeated chunk with unspecified duration");
    }

    private void f(XmlPullParser xmlPullParser) {
        this.c = g(xmlPullParser);
        a("Type", (Object) Integer.valueOf(this.c));
        if (this.c == 2) {
            this.d = a(xmlPullParser, "Subtype");
        } else {
            this.d = xmlPullParser.getAttributeValue(null, "Subtype");
        }
        this.f = xmlPullParser.getAttributeValue(null, "Name");
        this.g = a(xmlPullParser, "QualityLevels", -1);
        this.h = a(xmlPullParser, "Url");
        this.i = a(xmlPullParser, "MaxWidth", -1);
        this.j = a(xmlPullParser, "MaxHeight", -1);
        this.k = a(xmlPullParser, "DisplayWidth", -1);
        this.l = a(xmlPullParser, "DisplayHeight", -1);
        this.m = xmlPullParser.getAttributeValue(null, "Language");
        this.e = (long) a(xmlPullParser, "TimeScale", -1);
        if (this.e == -1) {
            this.e = ((Long) a("TimeScale")).longValue();
        }
        this.n = new ArrayList();
    }

    private int g(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
        if (attributeValue == null) {
            throw new MissingFieldException("Type");
        } else if ("audio".equalsIgnoreCase(attributeValue)) {
            return 0;
        } else {
            if ("video".equalsIgnoreCase(attributeValue)) {
                return 1;
            }
            if ("text".equalsIgnoreCase(attributeValue)) {
                return 2;
            }
            throw new ParserException("Invalid key value[" + attributeValue + "]");
        }
    }

    public Object a() {
        d[] dVarArr = new d[this.b.size()];
        this.b.toArray(dVarArr);
        return new c(this.a, this.h, this.c, this.d, this.e, this.f, this.g, this.i, this.j, this.k, this.l, this.m, dVarArr, this.n, this.o);
    }

    public void a(Object obj) {
        if (obj instanceof d) {
            this.b.add((d) obj);
        }
    }

    public void b(XmlPullParser xmlPullParser) {
        if ("c".equals(xmlPullParser.getName())) {
            e(xmlPullParser);
        } else {
            f(xmlPullParser);
        }
    }

    public boolean b(String str) {
        return "c".equals(str);
    }
}
