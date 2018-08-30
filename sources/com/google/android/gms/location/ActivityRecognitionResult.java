package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

@Class(creator = "ActivityRecognitionResultCreator")
@Reserved({1000})
public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<ActivityRecognitionResult> CREATOR = new t();
    @Field(id = 1)
    private List<DetectedActivity> a;
    @Field(id = 2)
    private long b;
    @Field(id = 3)
    private long c;
    @Field(id = 4)
    private int d;
    @Field(id = 5)
    private Bundle e;

    @Constructor
    public ActivityRecognitionResult(@Param(id = 1) List<DetectedActivity> list, @Param(id = 2) long j, @Param(id = 3) long j2, @Param(id = 4) int i, @Param(id = 5) Bundle bundle) {
        boolean z = true;
        boolean z2 = list != null && list.size() > 0;
        ar.b(z2, "Must have at least 1 detected activity");
        if (j <= 0 || j2 <= 0) {
            z = false;
        }
        ar.b(z, "Must set times");
        this.a = list;
        this.b = j;
        this.c = j2;
        this.d = i;
        this.e = bundle;
    }

    public static boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        if (intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")) {
            return true;
        }
        List c = c(intent);
        return (c == null || c.isEmpty()) ? false : true;
    }

    private static boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle == null && bundle2 != null) || (bundle != null && bundle2 == null)) {
            return false;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!a(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    public static com.google.android.gms.location.ActivityRecognitionResult b(android.content.Intent r3) {
        /*
        r1 = 0;
        r0 = a(r3);
        if (r0 == 0) goto L_0x0029;
    L_0x0007:
        r0 = r3.getExtras();
        r2 = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";
        r0 = r0.get(r2);
        r2 = r0 instanceof byte[];
        if (r2 == 0) goto L_0x0022;
    L_0x0015:
        r0 = (byte[]) r0;
        r2 = CREATOR;
        r0 = com.google.android.gms.common.internal.safeparcel.b.a(r0, r2);
        r0 = (com.google.android.gms.location.ActivityRecognitionResult) r0;
    L_0x001f:
        if (r0 == 0) goto L_0x002b;
    L_0x0021:
        return r0;
    L_0x0022:
        r2 = r0 instanceof com.google.android.gms.location.ActivityRecognitionResult;
        if (r2 == 0) goto L_0x0029;
    L_0x0026:
        r0 = (com.google.android.gms.location.ActivityRecognitionResult) r0;
        goto L_0x001f;
    L_0x0029:
        r0 = r1;
        goto L_0x001f;
    L_0x002b:
        r0 = c(r3);
        if (r0 == 0) goto L_0x0037;
    L_0x0031:
        r2 = r0.isEmpty();
        if (r2 == 0) goto L_0x0039;
    L_0x0037:
        r0 = r1;
        goto L_0x0021;
    L_0x0039:
        r1 = r0.size();
        r1 = r1 + -1;
        r0 = r0.get(r1);
        r0 = (com.google.android.gms.location.ActivityRecognitionResult) r0;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.ActivityRecognitionResult.b(android.content.Intent):com.google.android.gms.location.ActivityRecognitionResult");
    }

    @Nullable
    private static List<ActivityRecognitionResult> c(Intent intent) {
        return !(intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST")) ? null : b.a(intent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
    }

    public List<DetectedActivity> a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
        return this.b == activityRecognitionResult.b && this.c == activityRecognitionResult.c && this.d == activityRecognitionResult.d && ap.a(this.a, activityRecognitionResult.a) && a(this.e, activityRecognitionResult.e);
    }

    public int hashCode() {
        return ap.a(Long.valueOf(this.b), Long.valueOf(this.c), Integer.valueOf(this.d), this.a, this.e);
    }

    public String toString() {
        String valueOf = String.valueOf(this.a);
        long j = this.b;
        return new StringBuilder(String.valueOf(valueOf).length() + 124).append("ActivityRecognitionResult [probableActivities=").append(valueOf).append(", timeMillis=").append(j).append(", elapsedRealtimeMillis=").append(this.c).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.c(parcel, 1, this.a, false);
        a.a(parcel, 2, this.b);
        a.a(parcel, 3, this.c);
        a.a(parcel, 4, this.d);
        a.a(parcel, 5, this.e, false);
        a.a(parcel, a);
    }
}
