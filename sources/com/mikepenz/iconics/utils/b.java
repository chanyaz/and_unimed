package com.mikepenz.iconics.utils;

import android.content.Context;
import android.text.ParcelableSpan;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.util.Log;
import com.mikepenz.iconics.a;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b {
    private static c a(SpannableStringBuilder spannableStringBuilder, SpannableStringBuilder spannableStringBuilder2, HashMap<String, ITypeface> hashMap) {
        if (spannableStringBuilder2.length() >= 6) {
            String replace = spannableStringBuilder2.subSequence(1, spannableStringBuilder2.length() - 1).toString().replace("-", "_");
            String charSequence = spannableStringBuilder2.subSequence(1, 4).toString();
            try {
                ITypeface iTypeface = (ITypeface) hashMap.get(charSequence);
                if (iTypeface != null) {
                    IIcon icon = iTypeface.getIcon(replace);
                    if (icon != null) {
                        spannableStringBuilder.append(icon.getCharacter());
                        return new c(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), replace, (ITypeface) hashMap.get(charSequence));
                    }
                    Log.e(a.a, "Wrong icon name: " + replace);
                } else {
                    Log.e(a.a, "Wrong fontId: " + replace);
                }
            } catch (IllegalArgumentException e) {
                Log.e(a.a, "Wrong icon name: " + replace);
            }
        }
        spannableStringBuilder.append(spannableStringBuilder2);
        return null;
    }

    public static d a(Spanned spanned, HashMap<String, ITypeface> hashMap) {
        int i = 0;
        LinkedList linkedList = new LinkedList();
        Collection linkedList2 = new LinkedList();
        for (ParcelableSpan parcelableSpan : (ParcelableSpan[]) spanned.getSpans(0, spanned.length(), ParcelableSpan.class)) {
            linkedList2.add(new c(spanned.getSpanStart(parcelableSpan), spanned.getSpanEnd(parcelableSpan), parcelableSpan, spanned.getSpanFlags(parcelableSpan)));
        }
        for (CharacterStyle characterStyle : (CharacterStyle[]) spanned.getSpans(0, spanned.length(), CharacterStyle.class)) {
            linkedList2.add(new c(spanned.getSpanStart(characterStyle), spanned.getSpanEnd(characterStyle), characterStyle, spanned.getSpanFlags(characterStyle)));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i2 = 0;
        CharSequence spannableStringBuilder2 = new SpannableStringBuilder();
        while (i < spanned.length()) {
            Character valueOf = Character.valueOf(spanned.charAt(i));
            if (valueOf.charValue() == '{') {
                spannableStringBuilder.append(spannableStringBuilder2);
                spannableStringBuilder2 = new SpannableStringBuilder();
                spannableStringBuilder2.append(valueOf.charValue());
            } else if (valueOf.charValue() == '}') {
                spannableStringBuilder2.append(valueOf.charValue());
                if (spannableStringBuilder2.length() > 5) {
                    c a = a(spannableStringBuilder, spannableStringBuilder2, hashMap);
                    if (a != null) {
                        linkedList.add(a);
                        Iterator it = linkedList2.iterator();
                        while (it.hasNext()) {
                            a = (c) it.next();
                            if (a.a > i - i2) {
                                a.a = (a.a - spannableStringBuilder2.length()) + 1;
                            }
                            if (a.b > i - i2) {
                                a.b = (a.b - spannableStringBuilder2.length()) + 1;
                            }
                        }
                        i2 += spannableStringBuilder2.length() - 1;
                    }
                } else {
                    spannableStringBuilder.append(spannableStringBuilder2);
                }
                spannableStringBuilder2 = new SpannableStringBuilder();
            } else if (spannableStringBuilder2.length() == 0) {
                spannableStringBuilder.append(valueOf.charValue());
            } else {
                spannableStringBuilder2.append(valueOf.charValue());
            }
            i++;
        }
        spannableStringBuilder.append(spannableStringBuilder2);
        linkedList.addAll(linkedList2);
        return new d(spannableStringBuilder, linkedList);
    }

    public static void a(Context context, Spannable spannable, List<c> list, List<CharacterStyle> list2, HashMap<String, List<CharacterStyle>> hashMap) {
        for (c cVar : list) {
            if (cVar.f != null) {
                spannable.setSpan(cVar.f, cVar.a, cVar.b, cVar.g);
            } else if (cVar.e != null) {
                spannable.setSpan(cVar.e, cVar.a, cVar.b, cVar.g);
            } else {
                spannable.setSpan(new IconicsTypefaceSpan("sans-serif", cVar.d.getTypeface(context)), cVar.a, cVar.b, 33);
            }
            if (hashMap != null && hashMap.containsKey(cVar.c)) {
                for (CharacterStyle wrap : (List) hashMap.get(cVar.c)) {
                    spannable.setSpan(CharacterStyle.wrap(wrap), cVar.a, cVar.b, cVar.g);
                }
            } else if (list2 != null) {
                for (CharacterStyle wrap2 : list2) {
                    spannable.setSpan(CharacterStyle.wrap(wrap2), cVar.a, cVar.b, cVar.g);
                }
            }
        }
    }
}
