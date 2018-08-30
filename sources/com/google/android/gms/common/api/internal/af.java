package com.google.android.gms.common.api.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class af extends am {
    final /* synthetic */ ac a;
    private final Map<Client, ae> b;

    public af(ac acVar, Map<Client, ae> map) {
        this.a = acVar;
        super(acVar, null);
        this.b = map;
    }

    @WorkerThread
    public final void a() {
        int i = 0;
        z zVar = new z(this.a.d);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (Client client : this.b.keySet()) {
            if (!client.requiresGooglePlayServices() || ((ae) this.b.get(client)).c) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i2 = -1;
        ArrayList arrayList3;
        int i3;
        Object obj;
        if (!arrayList.isEmpty()) {
            arrayList3 = (ArrayList) arrayList;
            int size = arrayList3.size();
            i3 = 0;
            while (i3 < size) {
                obj = arrayList3.get(i3);
                i3++;
                i2 = zVar.a(this.a.c, (Client) obj);
                if (i2 != 0) {
                    break;
                }
            }
        }
        arrayList3 = (ArrayList) arrayList2;
        i3 = arrayList3.size();
        while (i < i3) {
            obj = arrayList3.get(i);
            i++;
            i2 = zVar.a(this.a.c, (Client) obj);
            if (i2 == 0) {
                break;
            }
        }
        int i4 = i2;
        if (i4 != 0) {
            this.a.a.a(new ag(this, this.a, new ConnectionResult(i4, null)));
            return;
        }
        if (this.a.m) {
            this.a.k.connect();
        }
        for (Client client2 : this.b.keySet()) {
            ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (ConnectionProgressReportCallbacks) this.b.get(client2);
            if (!client2.requiresGooglePlayServices() || zVar.a(this.a.c, client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                this.a.a.a(new ah(this, this.a, connectionProgressReportCallbacks));
            }
        }
    }
}
