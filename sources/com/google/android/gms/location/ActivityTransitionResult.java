package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Collections;
import java.util.List;

@Class(creator = "ActivityTransitionResultCreator")
@Reserved({1000})
public class ActivityTransitionResult extends AbstractSafeParcelable {
    public static final Creator<ActivityTransitionResult> CREATOR = new y();
    @Field(getter = "getTransitionEvents", id = 1)
    private final List<ActivityTransitionEvent> a;

    @Constructor
    public ActivityTransitionResult(@Param(id = 1) List<ActivityTransitionEvent> list) {
        ar.a((Object) list, (Object) "transitionEvents list can't be null.");
        if (!list.isEmpty()) {
            for (int i = 1; i < list.size(); i++) {
                ar.b(((ActivityTransitionEvent) list.get(i)).c() >= ((ActivityTransitionEvent) list.get(i + -1)).c());
            }
        }
        this.a = Collections.unmodifiableList(list);
    }

    public List<ActivityTransitionEvent> a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : (obj == null || getClass() != obj.getClass()) ? false : this.a.equals(((ActivityTransitionResult) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.c(parcel, 1, a(), false);
        a.a(parcel, a);
    }
}
