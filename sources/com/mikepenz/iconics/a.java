package com.mikepenz.iconics;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.util.Log;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.b;
import com.mikepenz.iconics.utils.d;
import java.util.HashMap;
import java.util.List;

public final class a {
    public static final String a = a.class.getSimpleName();
    private static boolean b = false;
    private static HashMap<String, ITypeface> c = new HashMap();

    private a() {
    }

    public static Spanned a(Context context, HashMap<String, ITypeface> hashMap, Spanned spanned, List<CharacterStyle> list, HashMap<String, List<CharacterStyle>> hashMap2) {
        d a = b.a(spanned, a(context, (HashMap) hashMap));
        Spanned valueOf = SpannableString.valueOf(a.a);
        b.a(context, valueOf, a.b, list, hashMap2);
        return valueOf;
    }

    public static ITypeface a(Context context, String str) {
        a(context);
        return (ITypeface) c.get(str);
    }

    private static HashMap<String, ITypeface> a(Context context, HashMap<String, ITypeface> hashMap) {
        a(context);
        return (hashMap == null || hashMap.size() == 0) ? c : hashMap;
    }

    public static void a(Context context) {
        if (!b) {
            for (String str : com.mikepenz.iconics.utils.a.a(context)) {
                try {
                    ITypeface iTypeface = (ITypeface) Class.forName(str).newInstance();
                    c.put(iTypeface.getMappingPrefix(), iTypeface);
                } catch (Exception e) {
                    Log.e("Android-Iconics", "Can't init: " + str);
                }
            }
            b = true;
        }
    }
}
