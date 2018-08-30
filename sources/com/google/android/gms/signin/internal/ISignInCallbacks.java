package com.google.android.gms.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public interface ISignInCallbacks extends IInterface {
    void onAuthAccountComplete(ConnectionResult connectionResult, AuthAccountResult authAccountResult);

    void onGetCurrentAccountComplete(Status status, GoogleSignInAccount googleSignInAccount);

    void onRecordConsentComplete(Status status);

    void onSaveAccountToSessionStoreComplete(Status status);

    void onSignInComplete(SignInResponse signInResponse);
}
