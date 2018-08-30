package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Class(creator = "ActivityTransitionCreator")
@Reserved({1000})
public class ActivityTransition extends AbstractSafeParcelable {
    public static final Creator<ActivityTransition> CREATOR = new u();
    @Field(getter = "getActivityType", id = 1)
    private final int a;
    @Field(getter = "getTransitionType", id = 2)
    private final int b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedActivityTransition {
    }

    @Constructor
    ActivityTransition(@Param(id = 1) int i, @Param(id = 2) int i2) {
        this.a = i;
        this.b = i2;
    }

    public static void a(int i) {
        boolean z = true;
        if (i < 0 || i > 1) {
            z = false;
        }
        ar.b(z, "Transition type " + i + " is not valid.");
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        return this.a == activityTransition.a && this.b == activityTransition.b;
    }

    public int hashCode() {
        return ap.a(Integer.valueOf(this.a), Integer.valueOf(this.b));
    }

    public String toString() {
        int i = this.a;
        return "ActivityTransition [mActivityType=" + i + ", mTransitionType=" + this.b + ']';
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, a());
        a.a(parcel, 2, b());
        a.a(parcel, a);
    }
}
