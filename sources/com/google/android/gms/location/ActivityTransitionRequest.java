package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

@Class(creator = "ActivityTransitionRequestCreator")
@Reserved({1000})
public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Creator<ActivityTransitionRequest> CREATOR = new x();
    public static final Comparator<ActivityTransition> a = new w();
    @Field(getter = "getActivityTransitions", id = 1)
    private final List<ActivityTransition> b;
    @Nullable
    @Field(getter = "getTag", id = 2)
    private final String c;
    @Field(getter = "getClients", id = 3)
    private final List<ClientIdentity> d;

    @Constructor
    public ActivityTransitionRequest(@Param(id = 1) List<ActivityTransition> list, @Nullable @Param(id = 2) String str, @Nullable @Param(id = 3) List<ClientIdentity> list2) {
        ar.a((Object) list, (Object) "transitions can't be null");
        ar.b(list.size() > 0, "transitions can't be empty.");
        TreeSet treeSet = new TreeSet(a);
        for (ActivityTransition add : list) {
            ar.b(treeSet.add(add), String.format("Found duplicated transition: %s.", new Object[]{(ActivityTransition) r4.next()}));
        }
        this.b = Collections.unmodifiableList(list);
        this.c = str;
        this.d = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
        return ap.a(this.b, activityTransitionRequest.b) && ap.a(this.c, activityTransitionRequest.c) && ap.a(this.d, activityTransitionRequest.d);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.c != null ? this.c.hashCode() : 0) + (this.b.hashCode() * 31)) * 31;
        if (this.d != null) {
            i = this.d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        String valueOf = String.valueOf(this.b);
        String str = this.c;
        String valueOf2 = String.valueOf(this.d);
        return new StringBuilder(((String.valueOf(valueOf).length() + 61) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append("ActivityTransitionRequest [mTransitions=").append(valueOf).append(", mTag='").append(str).append('\'').append(", mClients=").append(valueOf2).append(']').toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.c(parcel, 1, this.b, false);
        a.a(parcel, 2, this.c, false);
        a.c(parcel, 3, this.d, false);
        a.a(parcel, a);
    }
}
