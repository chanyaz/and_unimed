package com.mikepenz.iconics;

import android.content.Context;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import com.mikepenz.iconics.typeface.ITypeface;
import java.util.HashMap;
import java.util.List;

public class c {
    private Context a;
    private Spanned b;
    private List<CharacterStyle> c;
    private HashMap<String, List<CharacterStyle>> d;
    private List<ITypeface> e;

    public c(Context context, List<ITypeface> list, Spanned spanned, List<CharacterStyle> list2, HashMap<String, List<CharacterStyle>> hashMap) {
        this.a = context;
        this.e = list;
        this.b = spanned;
        this.c = list2;
        this.d = hashMap;
    }

    public Spanned a() {
        HashMap hashMap = new HashMap();
        for (ITypeface iTypeface : this.e) {
            hashMap.put(iTypeface.getMappingPrefix(), iTypeface);
        }
        return a.a(this.a, hashMap, this.b, this.c, this.d);
    }
}
