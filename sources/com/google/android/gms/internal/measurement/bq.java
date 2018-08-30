package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
import java.util.Map;

public final class bq extends ix implements zzci {
    bq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    public final void zza(Map map, long j, String str, List<zzbo> list) {
        Parcel a = a();
        a.writeMap(map);
        a.writeLong(j);
        a.writeString(str);
        a.writeTypedList(list);
        b(1, a);
    }

    public final void zzbn() {
        b(2, a());
    }
}
