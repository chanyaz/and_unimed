package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.stable.b;
import com.google.android.gms.internal.stable.c;

public abstract class d extends b implements ISignInCallbacks {
    public d() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    public static ISignInCallbacks a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
        return queryLocalInterface instanceof ISignInCallbacks ? (ISignInCallbacks) queryLocalInterface : new e(iBinder);
    }

    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 3:
                onAuthAccountComplete((ConnectionResult) c.a(parcel, ConnectionResult.CREATOR), (AuthAccountResult) c.a(parcel, AuthAccountResult.CREATOR));
                break;
            case 4:
                onSaveAccountToSessionStoreComplete((Status) c.a(parcel, Status.CREATOR));
                break;
            case 6:
                onRecordConsentComplete((Status) c.a(parcel, Status.CREATOR));
                break;
            case 7:
                onGetCurrentAccountComplete((Status) c.a(parcel, Status.CREATOR), (GoogleSignInAccount) c.a(parcel, GoogleSignInAccount.CREATOR));
                break;
            case 8:
                onSignInComplete((SignInResponse) c.a(parcel, SignInResponse.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
