package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.e;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.measurement.AppMeasurement.EventInterceptor;
import com.google.android.gms.measurement.AppMeasurement.OnEventListener;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class fq extends fo {
    @VisibleForTesting
    protected gj a;
    @VisibleForTesting
    protected boolean b = true;
    private EventInterceptor c;
    private final Set<OnEventListener> d = new CopyOnWriteArraySet();
    private boolean e;
    private final AtomicReference<String> f = new AtomicReference();

    protected fq(es esVar) {
        super(esVar);
    }

    private final void a(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
            for (String str4 : bundle2.keySet()) {
                Object obj = bundle2.get(str4);
                int i;
                int i2;
                if (obj instanceof Bundle) {
                    bundle2.putBundle(str4, new Bundle((Bundle) obj));
                } else if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    i = 0;
                    while (true) {
                        i2 = i;
                        if (i2 >= parcelableArr.length) {
                            break;
                        }
                        if (parcelableArr[i2] instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelableArr[i2]);
                        }
                        i = i2 + 1;
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    i = 0;
                    while (true) {
                        i2 = i;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        Object obj2 = arrayList.get(i2);
                        if (obj2 instanceof Bundle) {
                            arrayList.set(i2, new Bundle((Bundle) obj2));
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
        zzgd().a(new gi(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    private final void a(String str, String str2, long j, Object obj) {
        zzgd().a(new fs(this, str, str2, obj, j));
    }

    private final void a(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        a(str, str2, zzbt().currentTimeMillis(), bundle, true, z2, z3, null);
    }

    @WorkerThread
    private final void a(String str, String str2, Object obj, long j) {
        ar.a(str);
        ar.a(str2);
        c();
        B();
        if (!this.q.t()) {
            zzge().x().a("User property not set since app measurement is disabled");
        } else if (this.q.x()) {
            zzge().x().a("Setting user property (FE)", k().a(str2), obj);
            h().a(new zzjx(str2, j, obj, str));
        }
    }

    @VisibleForTesting
    private final List<ConditionalUserProperty> b(String str, String str2, String str3) {
        if (zzgd().s()) {
            zzge().r().a("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        }
        zzgd();
        if (en.r()) {
            zzge().r().a("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.q.zzgd().a(new fz(this, atomicReference, str, str2, str3));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzge().u().a("Interrupted waiting for get conditional user properties", str, e);
            }
        }
        List<zzed> list = (List) atomicReference.get();
        if (list == null) {
            zzge().u().a("Timed out waiting for get conditional user properties", str);
            return Collections.emptyList();
        }
        List<ConditionalUserProperty> arrayList = new ArrayList(list.size());
        for (zzed zzed : list) {
            ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
            conditionalUserProperty.mAppId = str;
            conditionalUserProperty.mOrigin = str2;
            conditionalUserProperty.mCreationTimestamp = zzed.d;
            conditionalUserProperty.mName = zzed.c.a;
            conditionalUserProperty.mValue = zzed.c.a();
            conditionalUserProperty.mActive = zzed.e;
            conditionalUserProperty.mTriggerEventName = zzed.f;
            if (zzed.g != null) {
                conditionalUserProperty.mTimedOutEventName = zzed.g.a;
                if (zzed.g.b != null) {
                    conditionalUserProperty.mTimedOutEventParams = zzed.g.b.b();
                }
            }
            conditionalUserProperty.mTriggerTimeout = zzed.h;
            if (zzed.i != null) {
                conditionalUserProperty.mTriggeredEventName = zzed.i.a;
                if (zzed.i.b != null) {
                    conditionalUserProperty.mTriggeredEventParams = zzed.i.b.b();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = zzed.c.b;
            conditionalUserProperty.mTimeToLive = zzed.j;
            if (zzed.k != null) {
                conditionalUserProperty.mExpiredEventName = zzed.k.a;
                if (zzed.k.b != null) {
                    conditionalUserProperty.mExpiredEventParams = zzed.k.b.b();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    @VisibleForTesting
    private final Map<String, Object> b(String str, String str2, String str3, boolean z) {
        if (zzgd().s()) {
            zzge().r().a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        zzgd();
        if (en.r()) {
            zzge().r().a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.q.zzgd().a(new ga(this, atomicReference, str, str2, str3, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzge().u().a("Interrupted waiting for get user properties", e);
            }
        }
        List<zzjx> list = (List) atomicReference.get();
        if (list == null) {
            zzge().u().a("Timed out waiting for get user properties");
            return Collections.emptyMap();
        }
        Map<String, Object> aVar = new a(list.size());
        for (zzjx zzjx : list) {
            aVar.put(zzjx.a, zzjx.a());
        }
        return aVar;
    }

    @WorkerThread
    private final void b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        ar.a(str);
        ar.a(str2);
        ar.a((Object) bundle);
        c();
        B();
        if (this.q.t()) {
            if (!this.e) {
                this.e = true;
                try {
                    try {
                        Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
                    } catch (Exception e) {
                        zzge().u().a("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException e2) {
                    zzge().w().a("Tag Manager is not found and thus will not be used");
                }
            }
            if (z3 && !"_iap".equals(str2)) {
                ie k = this.q.k();
                int i = !k.a("event", str2) ? 2 : !k.a("event", com.google.android.gms.measurement.a.a, str2) ? 13 : !k.a("event", 40, str2) ? 2 : 0;
                if (i != 0) {
                    zzge().t().a("Invalid public event name. Event will not be logged (FE)", k().a(str2));
                    this.q.k();
                    this.q.k().a(i, "_ev", ie.a(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
            gk r = i().r();
            if (r != null) {
                if (!bundle.containsKey("_sc")) {
                    r.d = true;
                }
            }
            boolean z4 = z && z3;
            gl.a(r, bundle, z4);
            boolean equals = "am".equals(str);
            z4 = ie.h(str2);
            if (z && this.c != null && !z4 && !equals) {
                zzge().x().a("Passing event to registered event handler (FE)", k().a(str2), k().a(bundle));
                this.c.interceptEvent(str, str2, bundle, j);
                return;
            } else if (this.q.x()) {
                int b = l().b(str2);
                if (b != 0) {
                    zzge().t().a("Invalid event name. Event will not be logged (FE)", k().a(str2));
                    l();
                    this.q.k().a(str3, b, "_ev", ie.a(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
                Bundle a;
                List a2 = e.a("_o", "_sn", "_sc", "_si");
                Bundle a3 = l().a(str2, bundle, a2, z3, true);
                gk gkVar = (a3 != null && a3.containsKey("_sc") && a3.containsKey("_si")) ? new gk(a3.getString("_sn"), a3.getString("_sc"), Long.valueOf(a3.getLong("_si")).longValue()) : null;
                gk gkVar2 = gkVar == null ? r : gkVar;
                List arrayList = new ArrayList();
                arrayList.add(a3);
                long nextLong = l().s().nextLong();
                String[] strArr = (String[]) a3.keySet().toArray(new String[bundle.size()]);
                Arrays.sort(strArr);
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    String str4 = strArr[i3];
                    Object obj = a3.get(str4);
                    l();
                    Bundle[] a4 = ie.a(obj);
                    if (a4 != null) {
                        a3.putInt(str4, a4.length);
                        i2 = 0;
                        while (true) {
                            int i4 = i2;
                            if (i4 >= a4.length) {
                                break;
                            }
                            Bundle bundle2 = a4[i4];
                            gl.a(gkVar2, bundle2, true);
                            a = l().a("_ep", bundle2, a2, z3, false);
                            a.putString("_en", str2);
                            a.putLong("_eid", nextLong);
                            a.putString("_gn", str4);
                            a.putInt("_ll", a4.length);
                            a.putInt("_i", i4);
                            arrayList.add(a);
                            i2 = i4 + 1;
                        }
                        i2 = a4.length + 0;
                    } else {
                        i2 = 0;
                    }
                    i3++;
                }
                if (null != null) {
                    a3.putLong("_eid", nextLong);
                    a3.putInt("_epc", 0);
                }
                i2 = 0;
                while (true) {
                    int i5 = i2;
                    if (i5 >= arrayList.size()) {
                        break;
                    }
                    a = (Bundle) arrayList.get(i5);
                    String str5 = (i5 != 0 ? 1 : null) != null ? "_ep" : str2;
                    a.putString("_o", str);
                    Bundle a5 = z2 ? l().a(a) : a;
                    zzge().x().a("Logging event (FE)", k().a(str2), k().a(a5));
                    h().a(new zzeu(str5, new zzer(a5), str, j), str3);
                    if (!equals) {
                        for (OnEventListener onEvent : this.d) {
                            onEvent.onEvent(str, str2, new Bundle(a5), j);
                        }
                    }
                    i2 = i5 + 1;
                }
                if (i().r() != null && "_ae".equals(str2)) {
                    m().a(true);
                    return;
                }
                return;
            } else {
                return;
            }
        }
        zzge().x().a("Event not sent since app measurement is disabled");
    }

    private final void b(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzbt().currentTimeMillis();
        ar.a(str2);
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzgd().a(new fy(this, conditionalUserProperty));
    }

    private final void c(ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zzbt().currentTimeMillis();
        ar.a((Object) conditionalUserProperty);
        ar.a(conditionalUserProperty.mName);
        ar.a(conditionalUserProperty.mOrigin);
        ar.a(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (l().d(str) != 0) {
            zzge().r().a("Invalid conditional user property name", k().c(str));
        } else if (l().b(str, obj) != 0) {
            zzge().r().a("Invalid conditional user property value", k().c(str), obj);
        } else {
            Object c = l().c(str, obj);
            if (c == null) {
                zzge().r().a("Unable to normalize conditional user property value", k().c(str), obj);
                return;
            }
            conditionalUserProperty.mValue = c;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                j = conditionalUserProperty.mTimeToLive;
                if (j > 15552000000L || j < 1) {
                    zzge().r().a("Invalid conditional user property time to live", k().c(str), Long.valueOf(j));
                    return;
                } else {
                    zzgd().a(new fx(this, conditionalUserProperty));
                    return;
                }
            }
            zzge().r().a("Invalid conditional user property timeout", k().c(str), Long.valueOf(j));
        }
    }

    @WorkerThread
    private final void c(boolean z) {
        c();
        B();
        zzge().x().a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        n().b(z);
        if (!o().i(f().s())) {
            h().s();
        } else if (this.q.t() && this.b) {
            zzge().x().a("Recording app launch after enabling measurement for the first time (FE)");
            z();
        } else {
            h().s();
        }
    }

    @WorkerThread
    private final void d(ConditionalUserProperty conditionalUserProperty) {
        c();
        B();
        ar.a((Object) conditionalUserProperty);
        ar.a(conditionalUserProperty.mName);
        ar.a(conditionalUserProperty.mOrigin);
        ar.a(conditionalUserProperty.mValue);
        if (this.q.t()) {
            zzjx zzjx = new zzjx(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
            try {
                zzeu a = l().a(conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0, true, false);
                h().a(new zzed(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzjx, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, l().a(conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0, true, false), conditionalUserProperty.mTriggerTimeout, a, conditionalUserProperty.mTimeToLive, l().a(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0, true, false)));
                return;
            } catch (IllegalArgumentException e) {
                return;
            }
        }
        zzge().x().a("Conditional property not sent since Firebase Analytics is disabled");
    }

    @WorkerThread
    private final void e(ConditionalUserProperty conditionalUserProperty) {
        c();
        B();
        ar.a((Object) conditionalUserProperty);
        ar.a(conditionalUserProperty.mName);
        if (this.q.t()) {
            zzjx zzjx = new zzjx(conditionalUserProperty.mName, 0, null, null);
            try {
                h().a(new zzed(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzjx, conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, l().a(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
                return;
            } catch (IllegalArgumentException e) {
                return;
            }
        }
        zzge().x().a("Conditional property not cleared since Firebase Analytics is disabled");
    }

    public final List<ConditionalUserProperty> a(String str, String str2) {
        return b(null, str, str2);
    }

    public final List<ConditionalUserProperty> a(String str, String str2, String str3) {
        ar.a(str);
        a();
        return b(str, str2, str3);
    }

    public final Map<String, Object> a(String str, String str2, String str3, boolean z) {
        ar.a(str);
        a();
        return b(str, str2, str3, z);
    }

    public final Map<String, Object> a(String str, String str2, boolean z) {
        return b(null, str, str2, z);
    }

    public final void a(long j) {
        zzgd().a(new gg(this, j));
    }

    public final void a(ConditionalUserProperty conditionalUserProperty) {
        ar.a((Object) conditionalUserProperty);
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzge().u().a("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        c(conditionalUserProperty2);
    }

    @WorkerThread
    public final void a(EventInterceptor eventInterceptor) {
        c();
        B();
        if (!(eventInterceptor == null || eventInterceptor == this.c)) {
            ar.a(this.c == null, (Object) "EventInterceptor already set.");
        }
        this.c = eventInterceptor;
    }

    public final void a(OnEventListener onEventListener) {
        B();
        ar.a((Object) onEventListener);
        if (!this.d.add(onEventListener)) {
            zzge().u().a("OnEventListener already registered");
        }
    }

    final void a(@Nullable String str) {
        this.f.set(str);
    }

    public final void a(String str, String str2, Bundle bundle) {
        boolean z = this.c == null || ie.h(str2);
        a(str, str2, bundle, true, z, false, null);
    }

    public final void a(String str, String str2, Bundle bundle, long j) {
        a(str, str2, j, bundle, false, true, true, null);
    }

    public final void a(String str, String str2, Bundle bundle, boolean z) {
        boolean z2 = this.c == null || ie.h(str2);
        a(str, str2, bundle, true, z2, true, null);
    }

    public final void a(String str, String str2, Object obj) {
        int i = 0;
        ar.a(str);
        long currentTimeMillis = zzbt().currentTimeMillis();
        int d = l().d(str2);
        String a;
        if (d != 0) {
            l();
            a = ie.a(str2, 24, true);
            if (str2 != null) {
                i = str2.length();
            }
            this.q.k().a(d, "_ev", a, i);
        } else if (obj != null) {
            d = l().b(str2, obj);
            if (d != 0) {
                l();
                a = ie.a(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.q.k().a(d, "_ev", a, i);
                return;
            }
            Object c = l().c(str2, obj);
            if (c != null) {
                a(str, str2, currentTimeMillis, c);
            }
        } else {
            a(str, str2, currentTimeMillis, null);
        }
    }

    public final void a(String str, String str2, String str3, Bundle bundle) {
        ar.a(str);
        a();
        b(str, str2, str3, bundle);
    }

    public final void a(boolean z) {
        B();
        zzgd().a(new gf(this, z));
    }

    public final List<zzjx> b(boolean z) {
        B();
        zzge().x().a("Fetching user attributes (FE)");
        if (zzgd().s()) {
            zzge().r().a("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        zzgd();
        if (en.r()) {
            zzge().r().a("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.q.zzgd().a(new ft(this, atomicReference, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzge().u().a("Interrupted waiting for get user properties", e);
            }
        }
        List<zzjx> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzge().u().a("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    public final void b(long j) {
        zzgd().a(new gh(this, j));
    }

    public final void b(ConditionalUserProperty conditionalUserProperty) {
        ar.a((Object) conditionalUserProperty);
        ar.a(conditionalUserProperty.mAppId);
        a();
        c(new ConditionalUserProperty(conditionalUserProperty));
    }

    public final void b(OnEventListener onEventListener) {
        B();
        ar.a((Object) onEventListener);
        if (!this.d.remove(onEventListener)) {
            zzge().u().a("OnEventListener had not been registered");
        }
    }

    @WorkerThread
    final void b(String str, String str2, Bundle bundle) {
        c();
        boolean z = this.c == null || ie.h(str2);
        b(str, str2, zzbt().currentTimeMillis(), bundle, true, z, false, null);
    }

    @Nullable
    final String c(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzgd().a(new fv(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                zzge().u().a("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    public final void c(String str, String str2, Bundle bundle) {
        b(null, str, str2, bundle);
    }

    protected final boolean p() {
        return false;
    }

    public final Boolean r() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzgd().a(atomicReference, 15000, "boolean test flag value", new fr(this, atomicReference));
    }

    public final String s() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzgd().a(atomicReference, 15000, "String test flag value", new gb(this, atomicReference));
    }

    public final Long t() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzgd().a(atomicReference, 15000, "long test flag value", new gc(this, atomicReference));
    }

    public final Integer u() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzgd().a(atomicReference, 15000, "int test flag value", new gd(this, atomicReference));
    }

    public final Double v() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzgd().a(atomicReference, 15000, "double test flag value", new ge(this, atomicReference));
    }

    public final com.google.android.gms.tasks.a<String> w() {
        try {
            Object s = n().s();
            return s != null ? Tasks.a(s) : Tasks.a(zzgd().t(), new fu(this));
        } catch (Exception e) {
            zzge().u().a("Failed to schedule task for getAppInstanceId");
            return Tasks.a(e);
        }
    }

    @Nullable
    public final String x() {
        return (String) this.f.get();
    }

    public final void y() {
        zzgd().a(new fw(this, zzbt().currentTimeMillis()));
    }

    @WorkerThread
    public final void z() {
        c();
        B();
        if (this.q.x()) {
            h().u();
            this.b = false;
            String v = n().v();
            if (!TextUtils.isEmpty(v)) {
                g().B();
                if (!v.equals(VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", v);
                    a("auto", "_ou", bundle);
                }
            }
        }
    }
}
