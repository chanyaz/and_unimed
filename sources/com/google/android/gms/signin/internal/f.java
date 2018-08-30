package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.aa;
import com.google.android.gms.common.internal.ak;
import com.google.android.gms.internal.stable.b;
import com.google.android.gms.internal.stable.c;

public abstract class f extends b implements ISignInService {
    public f() {
        super("com.google.android.gms.signin.internal.ISignInService");
    }

    public static ISignInService a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof ISignInService ? (ISignInService) queryLocalInterface : new g(iBinder);
    }

    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                authAccount((AuthAccountRequest) c.a(parcel, AuthAccountRequest.CREATOR), d.a(parcel.readStrongBinder()));
                break;
            case 3:
                onCheckServerAuthorization((CheckServerAuthResult) c.a(parcel, CheckServerAuthResult.CREATOR));
                break;
            case 4:
                onUploadServerAuthCode(c.a(parcel));
                break;
            case 5:
                resolveAccount((ResolveAccountRequest) c.a(parcel, ResolveAccountRequest.CREATOR), ak.a(parcel.readStrongBinder()));
                break;
            case 7:
                clearAccountFromSessionStore(parcel.readInt());
                break;
            case 8:
                saveAccountToSessionStore(parcel.readInt(), (Account) c.a(parcel, Account.CREATOR), d.a(parcel.readStrongBinder()));
                break;
            case 9:
                saveDefaultAccountToSharedPref(aa.a(parcel.readStrongBinder()), parcel.readInt(), c.a(parcel));
                break;
            case 10:
                recordConsent((RecordConsentRequest) c.a(parcel, RecordConsentRequest.CREATOR), d.a(parcel.readStrongBinder()));
                break;
            case 11:
                getCurrentAccount(d.a(parcel.readStrongBinder()));
                break;
            case 12:
                signIn((SignInRequest) c.a(parcel, SignInRequest.CREATOR), d.a(parcel.readStrongBinder()));
                break;
            case 13:
                setGamesHasBeenGreeted(c.a(parcel));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
