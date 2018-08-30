package com.google.android.gms.internal.ads;

import android.content.SharedPreferences.Editor;

final class ame extends amd<Boolean> {
    ame(int i, String str, Boolean bool) {
        super(i, str, bool, null);
    }

    public final /* synthetic */ void a(Editor editor, Object obj) {
        editor.putBoolean(a(), ((Boolean) obj).booleanValue());
    }
}
