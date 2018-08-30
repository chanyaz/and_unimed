package com.google.android.gms.internal.ads;

import android.content.SharedPreferences.Editor;

final class amh extends amd<Float> {
    amh(int i, String str, Float f) {
        super(i, str, f, null);
    }

    public final /* synthetic */ void a(Editor editor, Object obj) {
        editor.putFloat(a(), ((Float) obj).floatValue());
    }
}
