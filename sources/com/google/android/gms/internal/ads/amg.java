package com.google.android.gms.internal.ads;

import android.content.SharedPreferences.Editor;

final class amg extends amd<Long> {
    amg(int i, String str, Long l) {
        super(i, str, l, null);
    }

    public final /* synthetic */ void a(Editor editor, Object obj) {
        editor.putLong(a(), ((Long) obj).longValue());
    }
}
