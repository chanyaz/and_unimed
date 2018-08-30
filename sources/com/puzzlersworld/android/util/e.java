package com.puzzlersworld.android.util;

import android.content.Context;
import android.graphics.Typeface;
import com.puzzlersworld.android.FullscreenActivity;
import java.util.HashMap;

public class e {
    private static HashMap<String, Typeface> a = new HashMap();

    public static Typeface a(String str, Context context) {
        if (str == null && FullscreenActivity.A() != null) {
            String fontName = FullscreenActivity.A().getFontName();
            if (!w.f(fontName)) {
                str = "fonts/" + fontName + ".ttf";
            }
        }
        if (str == null) {
            return null;
        }
        Typeface typeface = (Typeface) a.get(str);
        if (typeface != null) {
            return typeface;
        }
        try {
            typeface = Typeface.createFromAsset(context.getAssets(), str);
            a.put(str, typeface);
            return typeface;
        } catch (Exception e) {
            return null;
        }
    }
}
