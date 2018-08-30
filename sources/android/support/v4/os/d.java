package android.support.v4.os;

import android.os.Parcelable.Creator;

@Deprecated
public final class d {
    private d() {
    }

    @Deprecated
    public static <T> Creator<T> a(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return new e(parcelableCompatCreatorCallbacks);
    }
}
