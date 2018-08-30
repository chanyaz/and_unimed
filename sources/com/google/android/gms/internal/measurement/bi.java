package com.google.android.gms.internal.measurement;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.appnext.base.b.c;
import com.google.android.gms.common.internal.ar;

public final class bi extends af {
    private boolean a;
    private boolean b;
    private final AlarmManager c = ((AlarmManager) j().getSystemService("alarm"));
    private Integer d;

    protected bi(ah ahVar) {
        super(ahVar);
    }

    private final PendingIntent f() {
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(j(), "com.google.android.gms.analytics.AnalyticsReceiver"));
        return PendingIntent.getBroadcast(j(), 0, intent, 0);
    }

    private final int g() {
        if (this.d == null) {
            String str = "analytics";
            String valueOf = String.valueOf(j().getPackageName());
            this.d = Integer.valueOf((valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).hashCode());
        }
        return this.d.intValue();
    }

    protected final void a() {
        try {
            e();
            if (bd.e() > 0) {
                ActivityInfo receiverInfo = j().getPackageManager().getReceiverInfo(new ComponentName(j(), "com.google.android.gms.analytics.AnalyticsReceiver"), 2);
                if (receiverInfo != null && receiverInfo.enabled) {
                    b("Receiver registered for local dispatch.");
                    this.a = true;
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    public final boolean b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    public final void d() {
        y();
        ar.a(this.a, (Object) "Receiver not registered");
        long e = bd.e();
        if (e > 0) {
            e();
            long elapsedRealtime = i().elapsedRealtime() + e;
            this.b = true;
            if (VERSION.SDK_INT >= 24) {
                b("Scheduling upload with JobScheduler");
                JobScheduler jobScheduler = (JobScheduler) j().getSystemService("jobscheduler");
                Builder builder = new Builder(g(), new ComponentName(j(), "com.google.android.gms.analytics.AnalyticsJobService"));
                builder.setMinimumLatency(e);
                builder.setOverrideDeadline(e << 1);
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putString(c.jD, "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
                builder.setExtras(persistableBundle);
                JobInfo build = builder.build();
                a("Scheduling job. JobID", Integer.valueOf(g()));
                jobScheduler.schedule(build);
                return;
            }
            b("Scheduling upload with AlarmManager");
            this.c.setInexactRepeating(2, elapsedRealtime, e, f());
        }
    }

    public final void e() {
        this.b = false;
        this.c.cancel(f());
        if (VERSION.SDK_INT >= 24) {
            JobScheduler jobScheduler = (JobScheduler) j().getSystemService("jobscheduler");
            a("Cancelling job. JobID", Integer.valueOf(g()));
            jobScheduler.cancel(g());
        }
    }
}
