package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.appnext.base.b.c;

public final class hs extends hv {
    private final AlarmManager b = ((AlarmManager) getContext().getSystemService("alarm"));
    private final cy c;
    private Integer d;

    protected hs(hw hwVar) {
        super(hwVar);
        this.c = new ht(this, hwVar.F(), hwVar);
    }

    @TargetApi(24)
    private final void t() {
        JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
        zzge().y().a("Cancelling job. JobID", Integer.valueOf(u()));
        jobScheduler.cancel(u());
    }

    private final int u() {
        if (this.d == null) {
            String str = "measurement";
            String valueOf = String.valueOf(getContext().getPackageName());
            this.d = Integer.valueOf((valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).hashCode());
        }
        return this.d.intValue();
    }

    private final PendingIntent v() {
        Intent className = new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(getContext(), 0, className, 0);
    }

    public final void a(long j) {
        J();
        if (!ej.a(getContext())) {
            zzge().x().a("Receiver not registered/enabled");
        }
        if (!hi.a(getContext(), false)) {
            zzge().x().a("Service not registered/enabled");
        }
        q();
        long elapsedRealtime = zzbt().elapsedRealtime() + j;
        if (j < Math.max(0, ((Long) dg.y.b()).longValue()) && !this.c.b()) {
            zzge().y().a("Scheduling upload with DelayedRunnable");
            this.c.a(j);
        }
        if (VERSION.SDK_INT >= 24) {
            zzge().y().a("Scheduling upload with JobScheduler");
            JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
            Builder builder = new Builder(u(), new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementJobService"));
            builder.setMinimumLatency(j);
            builder.setOverrideDeadline(j << 1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString(c.jD, "com.google.android.gms.measurement.UPLOAD");
            builder.setExtras(persistableBundle);
            JobInfo build = builder.build();
            zzge().y().a("Scheduling job. JobID", Integer.valueOf(u()));
            jobScheduler.schedule(build);
            return;
        }
        zzge().y().a("Scheduling upload with AlarmManager");
        this.b.setInexactRepeating(2, elapsedRealtime, Math.max(((Long) dg.t.b()).longValue(), j), v());
    }

    protected final boolean p() {
        this.b.cancel(v());
        if (VERSION.SDK_INT >= 24) {
            t();
        }
        return false;
    }

    public final void q() {
        J();
        this.b.cancel(v());
        this.c.c();
        if (VERSION.SDK_INT >= 24) {
            t();
        }
    }
}
