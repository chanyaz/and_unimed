package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class j extends Binder implements ICustomTabsService {
    public j() {
        attachInterface(this, "android.support.customtabs.ICustomTabsService");
    }

    public static ICustomTabsService a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ICustomTabsService)) ? new k(iBinder) : (ICustomTabsService) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        boolean warmup;
        switch (i) {
            case 2:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                warmup = warmup(parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeInt(warmup ? 1 : 0);
                return true;
            case 3:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                warmup = newSession(h.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (warmup) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 4:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                warmup = mayLaunchUrl(h.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.createTypedArrayList(Bundle.CREATOR));
                parcel2.writeNoException();
                if (warmup) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 5:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                Bundle extraCommand = extraCommand(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (extraCommand != null) {
                    parcel2.writeInt(1);
                    extraCommand.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 6:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                warmup = updateVisuals(h.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (warmup) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 7:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                warmup = requestPostMessageChannel(h.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (warmup) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 8:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                int postMessage = postMessage(h.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(postMessage);
                return true;
            case 1598968902:
                parcel2.writeString("android.support.customtabs.ICustomTabsService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
