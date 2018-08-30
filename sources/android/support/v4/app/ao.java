package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.NotificationCompat.Action;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class ao {
    Bundle A;
    int B;
    int C;
    Notification D;
    RemoteViews E;
    RemoteViews F;
    RemoteViews G;
    String H;
    int I;
    String J;
    long K;
    int L;
    Notification M;
    @Deprecated
    public ArrayList<String> N;
    @RestrictTo({Scope.LIBRARY_GROUP})
    public Context a;
    @RestrictTo({Scope.LIBRARY_GROUP})
    public ArrayList<Action> b;
    CharSequence c;
    CharSequence d;
    PendingIntent e;
    PendingIntent f;
    RemoteViews g;
    Bitmap h;
    CharSequence i;
    int j;
    int k;
    boolean l;
    boolean m;
    aq n;
    CharSequence o;
    CharSequence[] p;
    int q;
    int r;
    boolean s;
    String t;
    boolean u;
    String v;
    boolean w;
    boolean x;
    boolean y;
    String z;

    @Deprecated
    public ao(Context context) {
        this(context, null);
    }

    public ao(@NonNull Context context, @NonNull String str) {
        this.b = new ArrayList();
        this.l = true;
        this.w = false;
        this.B = 0;
        this.C = 0;
        this.I = 0;
        this.L = 0;
        this.M = new Notification();
        this.a = context;
        this.H = str;
        this.M.when = System.currentTimeMillis();
        this.M.audioStreamType = -1;
        this.k = 0;
        this.N = new ArrayList();
    }

    private void a(int i, boolean z) {
        Notification notification;
        if (z) {
            notification = this.M;
            notification.flags |= i;
            return;
        }
        notification = this.M;
        notification.flags &= i ^ -1;
    }

    protected static CharSequence d(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public Notification a() {
        return new ar(this).a();
    }

    public ao a(int i) {
        this.M.icon = i;
        return this;
    }

    public ao a(long j) {
        this.M.when = j;
        return this;
    }

    public ao a(PendingIntent pendingIntent) {
        this.e = pendingIntent;
        return this;
    }

    public ao a(Bitmap bitmap) {
        this.h = bitmap;
        return this;
    }

    public ao a(Uri uri) {
        this.M.sound = uri;
        this.M.audioStreamType = -1;
        if (VERSION.SDK_INT >= 21) {
            this.M.audioAttributes = new Builder().setContentType(4).setUsage(5).build();
        }
        return this;
    }

    public ao a(aq aqVar) {
        if (this.n != aqVar) {
            this.n = aqVar;
            if (this.n != null) {
                this.n.a(this);
            }
        }
        return this;
    }

    public ao a(CharSequence charSequence) {
        this.c = d(charSequence);
        return this;
    }

    public ao a(String str) {
        this.t = str;
        return this;
    }

    public ao a(boolean z) {
        a(16, z);
        return this;
    }

    public ao b(@ColorInt int i) {
        this.B = i;
        return this;
    }

    public ao b(PendingIntent pendingIntent) {
        this.M.deleteIntent = pendingIntent;
        return this;
    }

    public ao b(CharSequence charSequence) {
        this.d = d(charSequence);
        return this;
    }

    public ao b(@NonNull String str) {
        this.H = str;
        return this;
    }

    public ao b(boolean z) {
        this.w = z;
        return this;
    }

    public ao c(CharSequence charSequence) {
        this.M.tickerText = d(charSequence);
        return this;
    }

    public ao c(boolean z) {
        this.u = z;
        return this;
    }
}
