package com.google.android.exoplayer.smoothstreaming;

import android.util.Base64;
import com.google.android.exoplayer.extractor.a.j;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

class f extends e {
    private boolean a;
    private UUID b;
    private byte[] c;

    public f(e eVar, String str) {
        super(eVar, str, "Protection");
    }

    public Object a() {
        return new b(this.b, j.a(this.b, this.c));
    }

    public void b(XmlPullParser xmlPullParser) {
        if ("ProtectionHeader".equals(xmlPullParser.getName())) {
            this.a = true;
            this.b = UUID.fromString(xmlPullParser.getAttributeValue(null, "SystemID"));
        }
    }

    public boolean b(String str) {
        return "ProtectionHeader".equals(str);
    }

    public void c(XmlPullParser xmlPullParser) {
        if (this.a) {
            this.c = Base64.decode(xmlPullParser.getText(), 0);
        }
    }

    public void d(XmlPullParser xmlPullParser) {
        if ("ProtectionHeader".equals(xmlPullParser.getName())) {
            this.a = false;
        }
    }
}
