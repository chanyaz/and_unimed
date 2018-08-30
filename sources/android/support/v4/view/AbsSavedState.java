package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class AbsSavedState implements Parcelable {
    public static final Creator<AbsSavedState> CREATOR = new ClassLoaderCreator<AbsSavedState>() {
        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.d;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: a */
        public AbsSavedState[] newArray(int i) {
            return new AbsSavedState[i];
        }
    };
    public static final AbsSavedState d = new AbsSavedState() {
    };
    private final Parcelable a;

    private AbsSavedState() {
        this.a = null;
    }

    protected AbsSavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = d;
        }
        this.a = readParcelable;
    }

    protected AbsSavedState(@NonNull Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == d) {
            parcelable = null;
        }
        this.a = parcelable;
    }

    @Nullable
    public final Parcelable a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
    }
}
