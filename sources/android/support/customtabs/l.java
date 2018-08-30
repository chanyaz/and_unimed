package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public abstract class l extends Binder implements IPostMessageService {
    public l() {
        attachInterface(this, "android.support.customtabs.IPostMessageService");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle bundle = null;
        ICustomTabsCallback a;
        switch (i) {
            case 2:
                parcel.enforceInterface("android.support.customtabs.IPostMessageService");
                a = h.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                onMessageChannelReady(a, bundle);
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("android.support.customtabs.IPostMessageService");
                a = h.a(parcel.readStrongBinder());
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                onPostMessage(a, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("android.support.customtabs.IPostMessageService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
