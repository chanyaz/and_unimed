package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class e<T> implements ClassLoaderCreator<T> {
    private final ParcelableCompatCreatorCallbacks<T> a;

    e(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        this.a = parcelableCompatCreatorCallbacks;
    }

    public T createFromParcel(Parcel parcel) {
        return this.a.createFromParcel(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.a.createFromParcel(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.a.newArray(i);
    }
}
