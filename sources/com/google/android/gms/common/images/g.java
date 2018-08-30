package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class g implements Creator<WebImage> {
    /* renamed from: a */
    public WebImage createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    uri = (Uri) SafeParcelReader.a(parcel, a, Uri.CREATOR);
                    break;
                case 3:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 4:
                    i3 = SafeParcelReader.e(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new WebImage(i2, uri, i, i3);
    }

    /* renamed from: a */
    public WebImage[] newArray(int i) {
        return new WebImage[i];
    }
}
