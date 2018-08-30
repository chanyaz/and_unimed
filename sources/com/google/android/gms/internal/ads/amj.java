package com.google.android.gms.internal.ads;

import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

@zzadh
public final class amj {
    private final Collection<amd<?>> a = new ArrayList();
    private final Collection<amd<String>> b = new ArrayList();
    private final Collection<amd<String>> c = new ArrayList();

    public final List<String> a() {
        List<String> arrayList = new ArrayList();
        for (amd a : this.b) {
            String str = (String) akc.f().a(a);
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final void a(Editor editor, int i, JSONObject jSONObject) {
        for (amd amd : this.a) {
            if (amd.c() == 1) {
                amd.a(editor, amd.a(jSONObject));
            }
        }
    }

    public final void a(amd amd) {
        this.a.add(amd);
    }

    public final List<String> b() {
        List<String> a = a();
        for (amd a2 : this.c) {
            String str = (String) akc.f().a(a2);
            if (str != null) {
                a.add(str);
            }
        }
        return a;
    }

    public final void b(amd<String> amd) {
        this.b.add(amd);
    }

    public final void c(amd<String> amd) {
        this.c.add(amd);
    }
}
