package com.google.android.exoplayer.smoothstreaming;

import com.google.android.exoplayer.util.c;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

class i extends e {
    private final List<byte[]> a = new LinkedList();
    private int b;
    private int c;
    private String d;
    private int e;
    private int f;
    private int g;
    private int h;

    public i(e eVar, String str) {
        super(eVar, str, "QualityLevel");
    }

    private static String c(String str) {
        return (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) ? "video/avc" : (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) ? "audio/mp4a-latm" : str.equalsIgnoreCase("TTML") ? "application/ttml+xml" : null;
    }

    private static byte[] d(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Character.digit(str.charAt(i2 + 1), 16) + (Character.digit(str.charAt(i2), 16) << 4));
        }
        return bArr;
    }

    public Object a() {
        byte[][] bArr;
        byte[][] bArr2 = (byte[][]) null;
        if (this.a.isEmpty()) {
            bArr = bArr2;
        } else {
            bArr = new byte[this.a.size()][];
            this.a.toArray(bArr);
        }
        return new d(this.b, this.c, this.d, bArr, this.e, this.f, this.g, this.h);
    }

    public void b(XmlPullParser xmlPullParser) {
        String attributeValue;
        int intValue = ((Integer) a("Type")).intValue();
        this.b = a(xmlPullParser, "Index", -1);
        this.c = b(xmlPullParser, "Bitrate");
        if (intValue == 1) {
            this.f = b(xmlPullParser, "MaxHeight");
            this.e = b(xmlPullParser, "MaxWidth");
            this.d = c(a(xmlPullParser, "FourCC"));
        } else {
            this.f = -1;
            this.e = -1;
            attributeValue = xmlPullParser.getAttributeValue(null, "FourCC");
            attributeValue = attributeValue != null ? c(attributeValue) : intValue == 0 ? "audio/mp4a-latm" : null;
            this.d = attributeValue;
        }
        if (intValue == 0) {
            this.g = b(xmlPullParser, "SamplingRate");
            this.h = b(xmlPullParser, "Channels");
        } else {
            this.g = -1;
            this.h = -1;
        }
        attributeValue = xmlPullParser.getAttributeValue(null, "CodecPrivateData");
        if (attributeValue != null && attributeValue.length() > 0) {
            Object d = d(attributeValue);
            byte[][] b = c.b(d);
            if (b == null) {
                this.a.add(d);
                return;
            }
            for (Object add : b) {
                this.a.add(add);
            }
        }
    }
}
