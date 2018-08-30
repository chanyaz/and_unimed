package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.a.c;
import android.support.annotation.ArrayRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.provider.a;
import android.util.Base64;
import android.util.Xml;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({Scope.LIBRARY_GROUP})
public class FontResourcesParserCompat {

    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    @Nullable
    public static FamilyResourceEntry a(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> a(Resources resources, @ArrayRes int i) {
        List<List<byte[]>> list = null;
        if (i != 0) {
            TypedArray obtainTypedArray = resources.obtainTypedArray(i);
            if (obtainTypedArray.length() > 0) {
                List<List<byte[]>> arrayList = new ArrayList();
                if ((obtainTypedArray.getResourceId(0, 0) != 0 ? 1 : 0) != 0) {
                    for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                        arrayList.add(a(resources.getStringArray(obtainTypedArray.getResourceId(i2, 0))));
                    }
                    list = arrayList;
                } else {
                    arrayList.add(a(resources.getStringArray(i)));
                    list = arrayList;
                }
            }
            obtainTypedArray.recycle();
        }
        return list != null ? list : Collections.emptyList();
    }

    private static List<byte[]> a(String[] strArr) {
        List<byte[]> arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    private static void a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
                default:
                    break;
            }
        }
    }

    @Nullable
    private static FamilyResourceEntry b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    @Nullable
    private static FamilyResourceEntry c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), c.FontFamily);
        String string = obtainAttributes.getString(c.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(c.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(c.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(c.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(c.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(c.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            List arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(d(xmlPullParser, resources));
                    } else {
                        a(xmlPullParser);
                    }
                }
            }
            return arrayList.isEmpty() ? null : new a((b[]) arrayList.toArray(new b[arrayList.size()]));
        } else {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new c(new a(string, string2, string3, a(resources, resourceId)), integer, integer2);
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), c.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(c.FontFamilyFont_fontWeight) ? c.FontFamilyFont_fontWeight : c.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(c.FontFamilyFont_fontStyle) ? c.FontFamilyFont_fontStyle : c.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(c.FontFamilyFont_font) ? c.FontFamilyFont_font : c.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i2, 0);
        String string = obtainAttributes.getString(i2);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new b(string, i, z, resourceId);
    }
}
