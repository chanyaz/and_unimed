package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.RemoteInput;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.NotificationCompat.Action;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestrictTo({Scope.LIBRARY_GROUP})
class ar implements NotificationBuilderWithBuilderAccessor {
    private final Builder a;
    private final ao b;
    private RemoteViews c;
    private RemoteViews d;
    private final List<Bundle> e = new ArrayList();
    private final Bundle f = new Bundle();
    private int g;
    private RemoteViews h;

    ar(ao aoVar) {
        this.b = aoVar;
        if (VERSION.SDK_INT >= 26) {
            this.a = new Builder(aoVar.a, aoVar.H);
        } else {
            this.a = new Builder(aoVar.a);
        }
        Notification notification = aoVar.M;
        this.a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, aoVar.g).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(aoVar.c).setContentText(aoVar.d).setContentInfo(aoVar.i).setContentIntent(aoVar.e).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(aoVar.f, (notification.flags & 128) != 0).setLargeIcon(aoVar.h).setNumber(aoVar.j).setProgress(aoVar.q, aoVar.r, aoVar.s);
        if (VERSION.SDK_INT < 21) {
            this.a.setSound(notification.sound, notification.audioStreamType);
        }
        if (VERSION.SDK_INT >= 16) {
            this.a.setSubText(aoVar.o).setUsesChronometer(aoVar.m).setPriority(aoVar.k);
            Iterator it = aoVar.b.iterator();
            while (it.hasNext()) {
                a((Action) it.next());
            }
            if (aoVar.A != null) {
                this.f.putAll(aoVar.A);
            }
            if (VERSION.SDK_INT < 20) {
                if (aoVar.w) {
                    this.f.putBoolean("android.support.localOnly", true);
                }
                if (aoVar.t != null) {
                    this.f.putString("android.support.groupKey", aoVar.t);
                    if (aoVar.u) {
                        this.f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (aoVar.v != null) {
                    this.f.putString("android.support.sortKey", aoVar.v);
                }
            }
            this.c = aoVar.E;
            this.d = aoVar.F;
        }
        if (VERSION.SDK_INT >= 19) {
            this.a.setShowWhen(aoVar.l);
            if (!(VERSION.SDK_INT >= 21 || aoVar.N == null || aoVar.N.isEmpty())) {
                this.f.putStringArray("android.people", (String[]) aoVar.N.toArray(new String[aoVar.N.size()]));
            }
        }
        if (VERSION.SDK_INT >= 20) {
            this.a.setLocalOnly(aoVar.w).setGroup(aoVar.t).setGroupSummary(aoVar.u).setSortKey(aoVar.v);
            this.g = aoVar.L;
        }
        if (VERSION.SDK_INT >= 21) {
            this.a.setCategory(aoVar.z).setColor(aoVar.B).setVisibility(aoVar.C).setPublicVersion(aoVar.D).setSound(notification.sound, notification.audioAttributes);
            Iterator it2 = aoVar.N.iterator();
            while (it2.hasNext()) {
                this.a.addPerson((String) it2.next());
            }
            this.h = aoVar.G;
        }
        if (VERSION.SDK_INT >= 24) {
            this.a.setExtras(aoVar.A).setRemoteInputHistory(aoVar.p);
            if (aoVar.E != null) {
                this.a.setCustomContentView(aoVar.E);
            }
            if (aoVar.F != null) {
                this.a.setCustomBigContentView(aoVar.F);
            }
            if (aoVar.G != null) {
                this.a.setCustomHeadsUpContentView(aoVar.G);
            }
        }
        if (VERSION.SDK_INT >= 26) {
            this.a.setBadgeIconType(aoVar.I).setShortcutId(aoVar.J).setTimeoutAfter(aoVar.K).setGroupAlertBehavior(aoVar.L);
            if (aoVar.y) {
                this.a.setColorized(aoVar.x);
            }
            if (!TextUtils.isEmpty(aoVar.H)) {
                this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }

    private void a(Action action) {
        if (VERSION.SDK_INT >= 20) {
            Notification.Action.Builder builder = new Notification.Action.Builder(action.a(), action.b(), action.c());
            if (action.f() != null) {
                for (RemoteInput addRemoteInput : au.a(action.f())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            Bundle bundle = action.d() != null ? new Bundle(action.d()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", action.e());
            if (VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(action.e());
            }
            builder.addExtras(bundle);
            this.a.addAction(builder.build());
        } else if (VERSION.SDK_INT >= 16) {
            this.e.add(as.a(this.a, action));
        }
    }

    public Notification a() {
        aq aqVar = this.b.n;
        if (aqVar != null) {
            aqVar.a((NotificationBuilderWithBuilderAccessor) this);
        }
        RemoteViews b = aqVar != null ? aqVar.b(this) : null;
        Notification b2 = b();
        if (b != null) {
            b2.contentView = b;
        } else if (this.b.E != null) {
            b2.contentView = this.b.E;
        }
        if (VERSION.SDK_INT >= 16 && aqVar != null) {
            b = aqVar.c(this);
            if (b != null) {
                b2.bigContentView = b;
            }
        }
        if (VERSION.SDK_INT >= 21 && aqVar != null) {
            b = this.b.n.d(this);
            if (b != null) {
                b2.headsUpContentView = b;
            }
        }
        if (VERSION.SDK_INT >= 16 && aqVar != null) {
            Bundle a = NotificationCompat.a(b2);
            if (a != null) {
                aqVar.a(a);
            }
        }
        return b2;
    }

    protected Notification b() {
        if (VERSION.SDK_INT >= 26) {
            return this.a.build();
        }
        Notification build;
        SparseArray a;
        if (VERSION.SDK_INT >= 24) {
            build = this.a.build();
            if (this.g == 0) {
                return build;
            }
            if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.g != 2)) {
                a(build);
            }
            if (build.getGroup() == null || (build.flags & 512) != 0 || this.g != 1) {
                return build;
            }
            a(build);
            return build;
        } else if (VERSION.SDK_INT >= 21) {
            this.a.setExtras(this.f);
            build = this.a.build();
            if (this.c != null) {
                build.contentView = this.c;
            }
            if (this.d != null) {
                build.bigContentView = this.d;
            }
            if (this.h != null) {
                build.headsUpContentView = this.h;
            }
            if (this.g == 0) {
                return build;
            }
            if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.g != 2)) {
                a(build);
            }
            if (build.getGroup() == null || (build.flags & 512) != 0 || this.g != 1) {
                return build;
            }
            a(build);
            return build;
        } else if (VERSION.SDK_INT >= 20) {
            this.a.setExtras(this.f);
            build = this.a.build();
            if (this.c != null) {
                build.contentView = this.c;
            }
            if (this.d != null) {
                build.bigContentView = this.d;
            }
            if (this.g == 0) {
                return build;
            }
            if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.g != 2)) {
                a(build);
            }
            if (build.getGroup() == null || (build.flags & 512) != 0 || this.g != 1) {
                return build;
            }
            a(build);
            return build;
        } else if (VERSION.SDK_INT >= 19) {
            a = as.a(this.e);
            if (a != null) {
                this.f.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.a.setExtras(this.f);
            build = this.a.build();
            if (this.c != null) {
                build.contentView = this.c;
            }
            if (this.d == null) {
                return build;
            }
            build.bigContentView = this.d;
            return build;
        } else if (VERSION.SDK_INT < 16) {
            return this.a.getNotification();
        } else {
            Notification build2 = this.a.build();
            Bundle a2 = NotificationCompat.a(build2);
            Bundle bundle = new Bundle(this.f);
            for (String str : this.f.keySet()) {
                if (a2.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a2.putAll(bundle);
            a = as.a(this.e);
            if (a != null) {
                NotificationCompat.a(build2).putSparseParcelableArray("android.support.actionExtras", a);
            }
            if (this.c != null) {
                build2.contentView = this.c;
            }
            if (this.d != null) {
                build2.bigContentView = this.d;
            }
            return build2;
        }
    }

    public Builder getBuilder() {
        return this.a;
    }
}
