package com.google.android.exoplayer.smoothstreaming;

import com.google.android.exoplayer.util.b;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

class g extends e {
    private int a;
    private int b;
    private long c;
    private long d;
    private long e;
    private int f = -1;
    private boolean g;
    private b h = null;
    private List<c> i = new LinkedList();

    public g(e eVar, String str) {
        super(eVar, str, "SmoothStreamingMedia");
    }

    public Object a() {
        c[] cVarArr = new c[this.i.size()];
        this.i.toArray(cVarArr);
        return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, cVarArr);
    }

    public void a(Object obj) {
        if (obj instanceof c) {
            this.i.add((c) obj);
        } else if (obj instanceof b) {
            b.b(this.h == null);
            this.h = (b) obj;
        }
    }

    public void b(XmlPullParser xmlPullParser) {
        this.a = b(xmlPullParser, "MajorVersion");
        this.b = b(xmlPullParser, "MinorVersion");
        this.c = a(xmlPullParser, "TimeScale", 10000000);
        this.d = c(xmlPullParser, "Duration");
        this.e = a(xmlPullParser, "DVRWindowLength", 0);
        this.f = a(xmlPullParser, "LookaheadCount", -1);
        this.g = a(xmlPullParser, "IsLive", false);
        a("TimeScale", (Object) Long.valueOf(this.c));
    }
}
