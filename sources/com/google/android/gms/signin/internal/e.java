package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.stable.a;
import com.google.android.gms.internal.stable.c;

public class e extends a implements ISignInCallbacks {
    e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    public void onAuthAccountComplete(ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
        Parcel a = a();
        c.a(a, (Parcelable) connectionResult);
        c.a(a, (Parcelable) authAccountResult);
        b(3, a);
    }

    public void onGetCurrentAccountComplete(Status status, GoogleSignInAccount googleSignInAccount) {
        Parcel a = a();
        c.a(a, (Parcelable) status);
        c.a(a, (Parcelable) googleSignInAccount);
        b(7, a);
    }

    public void onRecordConsentComplete(Status status) {
        Parcel a = a();
        c.a(a, (Parcelable) status);
        b(6, a);
    }

    public void onSaveAccountToSessionStoreComplete(Status status) {
        Parcel a = a();
        c.a(a, (Parcelable) status);
        b(4, a);
    }

    public void onSignInComplete(SignInResponse signInResponse) {
        Parcel a = a();
        c.a(a, (Parcelable) signInResponse);
        b(8, a);
    }
}
