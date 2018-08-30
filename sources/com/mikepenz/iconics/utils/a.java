package com.mikepenz.iconics.utils;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class a {
    private static Class a(String str) {
        while (true) {
            try {
                return Class.forName(str + ".R$string");
            } catch (ClassNotFoundException e) {
                CharSequence substring = str.contains(".") ? str.substring(0, str.lastIndexOf(46)) : "";
                if (TextUtils.isEmpty(substring)) {
                    return null;
                }
                CharSequence str2 = substring;
            }
        }
    }

    private static String a(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        return identifier == 0 ? "" : context.getString(identifier);
    }

    public static String[] a(Context context) {
        Class a = a(context.getPackageName());
        return a != null ? a(context, a.getFields()) : new String[0];
    }

    private static String[] a(Context context, Field[] fieldArr) {
        ArrayList arrayList = new ArrayList();
        for (Field field : fieldArr) {
            if (field.getName().contains("define_font_")) {
                arrayList.add(a(context, field.getName()));
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
