package com.google.android.exoplayer.smoothstreaming;

import android.util.Pair;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.smoothstreaming.SmoothStreamingManifestParser.MissingFieldException;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

abstract class e {
    private final String a;
    private final String b;
    private final e c;
    private final List<Pair<String, Object>> d = new LinkedList();

    public e(e eVar, String str, String str2) {
        this.c = eVar;
        this.a = str;
        this.b = str2;
    }

    private e a(e eVar, String str, String str2) {
        return "QualityLevel".equals(str) ? new i(eVar, str2) : "Protection".equals(str) ? new f(eVar, str2) : "StreamIndex".equals(str) ? new h(eVar, str2) : null;
    }

    protected final int a(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return i;
        }
        try {
            return Integer.parseInt(attributeValue);
        } catch (Throwable e) {
            throw new ParserException(e);
        }
    }

    protected final long a(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j;
        }
        try {
            return Long.parseLong(attributeValue);
        } catch (Throwable e) {
            throw new ParserException(e);
        }
    }

    protected abstract Object a();

    protected final Object a(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                return this.c == null ? null : this.c.a(str);
            } else {
                Pair pair = (Pair) this.d.get(i2);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
                i = i2 + 1;
            }
        }
    }

    public final Object a(XmlPullParser xmlPullParser) {
        int i = 0;
        int i2 = 0;
        while (true) {
            String name;
            switch (xmlPullParser.getEventType()) {
                case 1:
                    return null;
                case 2:
                    name = xmlPullParser.getName();
                    if (!this.b.equals(name)) {
                        if (i2 != 0) {
                            if (i <= 0) {
                                if (!b(name)) {
                                    e a = a(this, name, this.a);
                                    if (a != null) {
                                        a(a.a(xmlPullParser));
                                        break;
                                    }
                                    i = 1;
                                    break;
                                }
                                b(xmlPullParser);
                                break;
                            }
                            i++;
                            break;
                        }
                        break;
                    }
                    b(xmlPullParser);
                    i2 = 1;
                    break;
                case 3:
                    if (i2 != 0) {
                        if (i <= 0) {
                            name = xmlPullParser.getName();
                            d(xmlPullParser);
                            if (b(name)) {
                                break;
                            }
                            return a();
                        }
                        i--;
                        break;
                    }
                    continue;
                case 4:
                    if (i2 != 0 && i == 0) {
                        c(xmlPullParser);
                        break;
                    }
                default:
                    break;
            }
            xmlPullParser.next();
        }
    }

    protected final String a(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return attributeValue;
        }
        throw new MissingFieldException(str);
    }

    protected void a(Object obj) {
    }

    protected final void a(String str, Object obj) {
        this.d.add(Pair.create(str, obj));
    }

    protected final boolean a(XmlPullParser xmlPullParser, String str, boolean z) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z;
    }

    protected final int b(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            try {
                return Integer.parseInt(attributeValue);
            } catch (Throwable e) {
                throw new ParserException(e);
            }
        }
        throw new MissingFieldException(str);
    }

    protected void b(XmlPullParser xmlPullParser) {
    }

    protected boolean b(String str) {
        return false;
    }

    protected final long c(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            try {
                return Long.parseLong(attributeValue);
            } catch (Throwable e) {
                throw new ParserException(e);
            }
        }
        throw new MissingFieldException(str);
    }

    protected void c(XmlPullParser xmlPullParser) {
    }

    protected void d(XmlPullParser xmlPullParser) {
    }
}
