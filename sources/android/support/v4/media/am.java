package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class am {
    am() {
    }

    public static Object a(Parcel parcel) {
        return MediaMetadata.CREATOR.createFromParcel(parcel);
    }

    public static void a(Object obj, Parcel parcel, int i) {
        ((MediaMetadata) obj).writeToParcel(parcel, i);
    }
}
