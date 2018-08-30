package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.measurement.a;
import com.google.android.gms.measurement.b;
import com.google.android.gms.measurement.c;
import java.util.concurrent.atomic.AtomicReference;

public final class dn extends fo {
    private static final AtomicReference<String[]> a = new AtomicReference();
    private static final AtomicReference<String[]> b = new AtomicReference();
    private static final AtomicReference<String[]> c = new AtomicReference();

    dn(es esVar) {
        super(esVar);
    }

    @Nullable
    private final String a(zzer zzer) {
        return zzer == null ? null : !r() ? zzer.toString() : a(zzer.b());
    }

    @Nullable
    private static String a(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        int i = 0;
        ar.a((Object) strArr);
        ar.a((Object) strArr2);
        ar.a((Object) atomicReference);
        ar.b(strArr.length == strArr2.length);
        while (i < strArr.length) {
            if (ie.b(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = (String[]) atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(strArr2[i]);
                        stringBuilder.append("(");
                        stringBuilder.append(strArr[i]);
                        stringBuilder.append(")");
                        strArr3[i] = stringBuilder.toString();
                    }
                    str = strArr3[i];
                }
                return str;
            }
            i++;
        }
        return str;
    }

    private static void a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private final void a(StringBuilder stringBuilder, int i, ij ijVar) {
        if (ijVar != null) {
            a(stringBuilder, i);
            stringBuilder.append("filter {\n");
            a(stringBuilder, i, "complement", ijVar.e);
            a(stringBuilder, i, "param_name", b(ijVar.f));
            int i2 = i + 1;
            String str = "string_filter";
            im imVar = ijVar.c;
            if (imVar != null) {
                a(stringBuilder, i2);
                stringBuilder.append(str);
                stringBuilder.append(" {\n");
                if (imVar.c != null) {
                    Object obj = "UNKNOWN_MATCH_TYPE";
                    switch (imVar.c.intValue()) {
                        case 1:
                            obj = "REGEXP";
                            break;
                        case 2:
                            obj = "BEGINS_WITH";
                            break;
                        case 3:
                            obj = "ENDS_WITH";
                            break;
                        case 4:
                            obj = "PARTIAL";
                            break;
                        case 5:
                            obj = "EXACT";
                            break;
                        case 6:
                            obj = "IN_LIST";
                            break;
                    }
                    a(stringBuilder, i2, "match_type", obj);
                }
                a(stringBuilder, i2, "expression", imVar.d);
                a(stringBuilder, i2, "case_sensitive", imVar.e);
                if (imVar.f.length > 0) {
                    a(stringBuilder, i2 + 1);
                    stringBuilder.append("expression_list {\n");
                    for (String str2 : imVar.f) {
                        a(stringBuilder, i2 + 2);
                        stringBuilder.append(str2);
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append("}\n");
                }
                a(stringBuilder, i2);
                stringBuilder.append("}\n");
            }
            a(stringBuilder, i + 1, "number_filter", ijVar.d);
            a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private final void a(StringBuilder stringBuilder, int i, String str, ik ikVar) {
        if (ikVar != null) {
            a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (ikVar.c != null) {
                Object obj = "UNKNOWN_COMPARISON_TYPE";
                switch (ikVar.c.intValue()) {
                    case 1:
                        obj = "LESS_THAN";
                        break;
                    case 2:
                        obj = "GREATER_THAN";
                        break;
                    case 3:
                        obj = "EQUAL";
                        break;
                    case 4:
                        obj = "BETWEEN";
                        break;
                }
                a(stringBuilder, i, "comparison_type", obj);
            }
            a(stringBuilder, i, "match_as_float", ikVar.d);
            a(stringBuilder, i, "comparison_value", ikVar.e);
            a(stringBuilder, i, "min_comparison_value", ikVar.f);
            a(stringBuilder, i, "max_comparison_value", ikVar.g);
            a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, String str, iv ivVar) {
        int i2 = 0;
        if (ivVar != null) {
            int i3;
            int i4;
            a(stringBuilder, 3);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (ivVar.d != null) {
                a(stringBuilder, 4);
                stringBuilder.append("results: ");
                long[] jArr = ivVar.d;
                int length = jArr.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i3++;
                    i4 = i5;
                }
                stringBuilder.append(10);
            }
            if (ivVar.c != null) {
                a(stringBuilder, 4);
                stringBuilder.append("status: ");
                long[] jArr2 = ivVar.c;
                int length2 = jArr2.length;
                i3 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    i4 = i3 + 1;
                    if (i3 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf2);
                    i2++;
                    i3 = i4;
                }
                stringBuilder.append(10);
            }
            a(stringBuilder, 3);
            stringBuilder.append("}\n");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            a(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append(10);
        }
    }

    private final boolean r() {
        return this.q.zzge().a(3);
    }

    @Nullable
    protected final String a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!r()) {
            return bundle.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("Bundle[{");
            }
            stringBuilder.append(b(str));
            stringBuilder.append("=");
            stringBuilder.append(bundle.get(str));
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    @Nullable
    protected final String a(db dbVar) {
        if (dbVar == null) {
            return null;
        }
        if (!r()) {
            return dbVar.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{appId='");
        stringBuilder.append(dbVar.a);
        stringBuilder.append("', name='");
        stringBuilder.append(a(dbVar.b));
        stringBuilder.append("', params=");
        stringBuilder.append(a(dbVar.e));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected final String a(ii iiVar) {
        int i = 0;
        if (iiVar == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        a(stringBuilder, 0, "filter_id", iiVar.c);
        a(stringBuilder, 0, "event_name", a(iiVar.d));
        a(stringBuilder, 1, "event_count_filter", iiVar.f);
        stringBuilder.append("  filters {\n");
        ij[] ijVarArr = iiVar.e;
        int length = ijVarArr.length;
        while (i < length) {
            a(stringBuilder, 2, ijVarArr[i]);
            i++;
        }
        a(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    protected final String a(il ilVar) {
        if (ilVar == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        a(stringBuilder, 0, "filter_id", ilVar.c);
        a(stringBuilder, 0, "property_name", c(ilVar.d));
        a(stringBuilder, 1, ilVar.e);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    protected final String a(it itVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (itVar.c != null) {
            for (iu iuVar : itVar.c) {
                if (!(iuVar == null || iuVar == null)) {
                    a(stringBuilder, 1);
                    stringBuilder.append("bundle {\n");
                    a(stringBuilder, 1, "protocol_version", iuVar.c);
                    a(stringBuilder, 1, "platform", iuVar.k);
                    a(stringBuilder, 1, "gmp_version", iuVar.s);
                    a(stringBuilder, 1, "uploading_gmp_version", iuVar.t);
                    a(stringBuilder, 1, "config_version", iuVar.G);
                    a(stringBuilder, 1, "gmp_app_id", iuVar.A);
                    a(stringBuilder, 1, "app_id", iuVar.q);
                    a(stringBuilder, 1, "app_version", iuVar.r);
                    a(stringBuilder, 1, "app_version_major", iuVar.E);
                    a(stringBuilder, 1, "firebase_instance_id", iuVar.D);
                    a(stringBuilder, 1, "dev_cert_hash", iuVar.x);
                    a(stringBuilder, 1, "app_store", iuVar.p);
                    a(stringBuilder, 1, "upload_timestamp_millis", iuVar.f);
                    a(stringBuilder, 1, "start_timestamp_millis", iuVar.g);
                    a(stringBuilder, 1, "end_timestamp_millis", iuVar.h);
                    a(stringBuilder, 1, "previous_bundle_start_timestamp_millis", iuVar.i);
                    a(stringBuilder, 1, "previous_bundle_end_timestamp_millis", iuVar.j);
                    a(stringBuilder, 1, "app_instance_id", iuVar.w);
                    a(stringBuilder, 1, "resettable_device_id", iuVar.u);
                    a(stringBuilder, 1, "device_id", iuVar.F);
                    a(stringBuilder, 1, "limited_ad_tracking", iuVar.v);
                    a(stringBuilder, 1, "os_version", iuVar.l);
                    a(stringBuilder, 1, "device_model", iuVar.m);
                    a(stringBuilder, 1, "user_default_language", iuVar.n);
                    a(stringBuilder, 1, "time_zone_offset_minutes", iuVar.o);
                    a(stringBuilder, 1, "bundle_sequential_index", iuVar.y);
                    a(stringBuilder, 1, "service_upload", iuVar.B);
                    a(stringBuilder, 1, "health_monitor", iuVar.z);
                    if (!(iuVar.H == null || iuVar.H.longValue() == 0)) {
                        a(stringBuilder, 1, "android_id", iuVar.H);
                    }
                    if (iuVar.J != null) {
                        a(stringBuilder, 1, "retry_counter", iuVar.J);
                    }
                    iw[] iwVarArr = iuVar.e;
                    if (iwVarArr != null) {
                        for (iw iwVar : iwVarArr) {
                            if (iwVar != null) {
                                a(stringBuilder, 2);
                                stringBuilder.append("user_property {\n");
                                a(stringBuilder, 2, "set_timestamp_millis", iwVar.c);
                                a(stringBuilder, 2, "name", c(iwVar.d));
                                a(stringBuilder, 2, "string_value", iwVar.e);
                                a(stringBuilder, 2, "int_value", iwVar.f);
                                a(stringBuilder, 2, "double_value", iwVar.g);
                                a(stringBuilder, 2);
                                stringBuilder.append("}\n");
                            }
                        }
                    }
                    iq[] iqVarArr = iuVar.C;
                    if (iqVarArr != null) {
                        for (iq iqVar : iqVarArr) {
                            if (iqVar != null) {
                                a(stringBuilder, 2);
                                stringBuilder.append("audience_membership {\n");
                                a(stringBuilder, 2, "audience_id", iqVar.c);
                                a(stringBuilder, 2, "new_audience", iqVar.f);
                                a(stringBuilder, 2, "current_data", iqVar.d);
                                a(stringBuilder, 2, "previous_data", iqVar.e);
                                a(stringBuilder, 2);
                                stringBuilder.append("}\n");
                            }
                        }
                    }
                    ir[] irVarArr = iuVar.d;
                    if (irVarArr != null) {
                        for (ir irVar : irVarArr) {
                            if (irVar != null) {
                                a(stringBuilder, 2);
                                stringBuilder.append("event {\n");
                                a(stringBuilder, 2, "name", a(irVar.d));
                                a(stringBuilder, 2, "timestamp_millis", irVar.e);
                                a(stringBuilder, 2, "previous_timestamp_millis", irVar.f);
                                a(stringBuilder, 2, "count", irVar.g);
                                is[] isVarArr = irVar.c;
                                if (isVarArr != null) {
                                    for (is isVar : isVarArr) {
                                        if (isVar != null) {
                                            a(stringBuilder, 3);
                                            stringBuilder.append("param {\n");
                                            a(stringBuilder, 3, "name", b(isVar.c));
                                            a(stringBuilder, 3, "string_value", isVar.d);
                                            a(stringBuilder, 3, "int_value", isVar.e);
                                            a(stringBuilder, 3, "double_value", isVar.f);
                                            a(stringBuilder, 3);
                                            stringBuilder.append("}\n");
                                        }
                                    }
                                }
                                a(stringBuilder, 2);
                                stringBuilder.append("}\n");
                            }
                        }
                    }
                    a(stringBuilder, 1);
                    stringBuilder.append("}\n");
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    @Nullable
    protected final String a(zzeu zzeu) {
        if (zzeu == null) {
            return null;
        }
        if (!r()) {
            return zzeu.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("origin=");
        stringBuilder.append(zzeu.c);
        stringBuilder.append(",name=");
        stringBuilder.append(a(zzeu.a));
        stringBuilder.append(",params=");
        stringBuilder.append(a(zzeu.b));
        return stringBuilder.toString();
    }

    @Nullable
    protected final String a(String str) {
        return str == null ? null : r() ? a(str, a.b, a.a, a) : str;
    }

    @Nullable
    protected final String b(String str) {
        return str == null ? null : r() ? a(str, b.b, b.a, b) : str;
    }

    @Nullable
    protected final String c(String str) {
        if (str == null) {
            return null;
        }
        if (!r()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return a(str, c.b, c.a, c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("experiment_id");
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    protected final boolean p() {
        return false;
    }
}
