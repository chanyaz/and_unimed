package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.ads.a.b;
import com.google.android.gms.ads.internal.au;
import java.util.Map;

@zzadh
public final class awu extends l {
    private final Map<String, String> a;
    private final Context b;
    private String c = d("description");
    private long d = e("start_ticks");
    private long e = e("end_ticks");
    private String f = d("summary");
    private String g = d("location");

    public awu(zzaqw zzaqw, Map<String, String> map) {
        super(zzaqw, "createCalendarEvent");
        this.a = map;
        this.b = zzaqw.zzto();
    }

    private final String d(String str) {
        return TextUtils.isEmpty((CharSequence) this.a.get(str)) ? "" : (String) this.a.get(str);
    }

    private final long e(String str) {
        String str2 = (String) this.a.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public final void a() {
        if (this.b == null) {
            a("Activity context is not available.");
            return;
        }
        au.e();
        if (ht.f(this.b).d()) {
            au.e();
            Builder e = ht.e(this.b);
            Resources h = au.i().h();
            e.setTitle(h != null ? h.getString(b.s5) : "Create calendar event");
            e.setMessage(h != null ? h.getString(b.s6) : "Allow Ad to create a calendar event?");
            e.setPositiveButton(h != null ? h.getString(b.s3) : "Accept", new awv(this));
            e.setNegativeButton(h != null ? h.getString(b.s4) : "Decline", new a(this));
            e.create().show();
            return;
        }
        a("This feature is not available on the device.");
    }

    @TargetApi(14)
    final Intent b() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", this.c);
        data.putExtra("eventLocation", this.g);
        data.putExtra("description", this.f);
        if (this.d > -1) {
            data.putExtra("beginTime", this.d);
        }
        if (this.e > -1) {
            data.putExtra("endTime", this.e);
        }
        data.setFlags(268435456);
        return data;
    }
}
