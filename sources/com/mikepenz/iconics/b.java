package com.mikepenz.iconics;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import com.mikepenz.iconics.typeface.ITypeface;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class b {
    private List<CharacterStyle> a = new LinkedList();
    private HashMap<String, List<CharacterStyle>> b = new HashMap();
    private List<ITypeface> c = new LinkedList();
    private Context d;

    public b a(Context context) {
        this.d = context;
        return this;
    }

    public c a(Spanned spanned) {
        return new c(this.d, this.c, spanned, this.a, this.b);
    }

    public c a(CharSequence charSequence) {
        return a(charSequence.toString());
    }

    public c a(String str) {
        return a(new SpannableString(str));
    }
}
