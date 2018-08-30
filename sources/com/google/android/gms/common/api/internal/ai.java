package com.google.android.gms.common.api.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.Api.Client;
import java.util.ArrayList;

final class ai extends am {
    private final ArrayList<Client> a;
    private final /* synthetic */ ac b;

    public ai(ac acVar, ArrayList<Client> arrayList) {
        this.b = acVar;
        super(acVar, null);
        this.a = arrayList;
    }

    @WorkerThread
    public final void a() {
        this.b.a.d.c = this.b.f();
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Client) obj).getRemoteService(this.b.o, this.b.a.d.c);
        }
    }
}
