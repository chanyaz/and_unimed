package com.appnext.base.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.appnext.base.a.b.b;
import com.appnext.base.b.d;
import com.appnext.base.b.i;
import com.appnext.base.b.k;
import java.util.List;

public abstract class a extends BroadcastReceiver implements c {
    protected void a(String str, String str2, com.appnext.base.b.c.a aVar) {
        k.d(str, str2, aVar);
    }

    protected void a(String str, List<b> list) {
        k.b(str, (List) list);
    }

    /* renamed from: b */
    protected void a(String str, String str2, com.appnext.base.b.c.a aVar) {
        Object aG = k.aG(str);
        if (TextUtils.isEmpty(aG) || !aG.equalsIgnoreCase(str2)) {
            a(str, str2, aVar);
            k.j(str, str2);
        }
    }

    public abstract IntentFilter getBRFilter();

    public boolean hasPermission() {
        return false;
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            try {
                d.init(context);
                i.cE().init(d.getContext());
            } catch (Throwable th) {
                com.appnext.base.b.a(th);
            }
        }
    }

    public boolean register() {
        IntentFilter bRFilter = getBRFilter();
        if (bRFilter == null) {
            return false;
        }
        d.getContext().registerReceiver(this, bRFilter);
        return true;
    }

    public void unregister() {
        d.getContext().unregisterReceiver(this);
    }
}
