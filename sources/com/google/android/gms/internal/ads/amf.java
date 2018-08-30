package com.google.android.gms.internal.ads;

import android.content.SharedPreferences.Editor;

final class amf extends amd<Integer> {
    amf(int i, String str, Integer num) {
        super(i, str, num, null);
    }

    public final /* synthetic */ void a(Editor editor, Object obj) {
        editor.putInt(a(), ((Integer) obj).intValue());
    }
}
