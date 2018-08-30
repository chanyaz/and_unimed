package com.appnext.base.receivers.imp;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.appnext.base.a.b.c;
import com.appnext.base.b;
import com.appnext.base.b.d;
import com.appnext.base.b.e;
import com.appnext.base.b.f;
import com.appnext.base.b.k;
import com.appnext.base.b.l;
import com.appnext.base.receivers.a;
import java.util.ArrayList;
import java.util.List;

public class ctype extends a {
    private static final String KEY = ctype.class.getSimpleName();

    protected String a(NetworkInfo networkInfo) {
        return networkInfo.getTypeName();
    }

    public IntentFilter getBRFilter() {
        try {
            return !hasPermission() ? null : new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public boolean hasPermission() {
        return f.g(d.getContext().getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE");
    }

    public void onReceive(Context context, Intent intent) {
        try {
            super.onReceive(context, intent);
            l.k("Receiver", KEY);
            if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction()) && hasPermission()) {
                c av = e.cy().av(KEY);
                if (av == null || com.appnext.base.b.c.jy.equalsIgnoreCase(av.ba())) {
                    k.j(KEY, "");
                    return;
                }
                NetworkInfo j = f.j(d.getContext());
                if (j != null && j.isConnected()) {
                    List arrayList = new ArrayList();
                    String str = "";
                    String typeName = j.getTypeName();
                    if (!typeName.isEmpty()) {
                        arrayList.add(new com.appnext.base.a.b.b(KEY, "ctype", typeName, com.appnext.base.b.c.a.String.getType()));
                        str = str + typeName;
                    }
                    String subtypeName = j.getSubtypeName();
                    if (!subtypeName.isEmpty()) {
                        arrayList.add(new com.appnext.base.a.b.b(KEY, "mctype", subtypeName, com.appnext.base.b.c.a.String.getType()));
                        str = str + subtypeName;
                    }
                    subtypeName = k.aG(KEY);
                    k.j(KEY, str);
                    if (!arrayList.isEmpty()) {
                        if ((subtypeName != null && !str.equals(subtypeName)) || subtypeName == null) {
                            a(KEY, arrayList);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b.a(th);
        }
    }
}
