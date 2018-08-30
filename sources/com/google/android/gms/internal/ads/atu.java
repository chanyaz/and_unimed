package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@zzadh
public final class atu implements zzuo, zzwc {
    private final zzwb a;
    private final HashSet<SimpleEntry<String, zzv<? super zzwb>>> b = new HashSet();

    public atu(zzwb zzwb) {
        this.a = zzwb;
    }

    public final void zza(String str, zzv<? super zzwb> zzv) {
        this.a.zza(str, zzv);
        this.b.add(new SimpleEntry(str, zzv));
    }

    public final void zza(String str, Map map) {
        asl.a((zzuo) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        asl.b(this, str, jSONObject);
    }

    public final void zzb(String str, zzv<? super zzwb> zzv) {
        this.a.zzb(str, zzv);
        this.b.remove(new SimpleEntry(str, zzv));
    }

    public final void zzb(String str, JSONObject jSONObject) {
        asl.a((zzuo) this, str, jSONObject);
    }

    public final void zzbe(String str) {
        this.a.zzbe(str);
    }

    public final void zzf(String str, String str2) {
        asl.a((zzuo) this, str, str2);
    }

    public final void zzmd() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            String str = "Unregistering eventhandler: ";
            String valueOf = String.valueOf(((zzv) simpleEntry.getValue()).toString());
            hl.a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.a.zzb((String) simpleEntry.getKey(), (zzv) simpleEntry.getValue());
        }
        this.b.clear();
    }
}
