package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IInterface;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IResolveAccountCallbacks;
import com.google.android.gms.common.internal.ResolveAccountRequest;

public interface ISignInService extends IInterface {
    void authAccount(AuthAccountRequest authAccountRequest, ISignInCallbacks iSignInCallbacks);

    void clearAccountFromSessionStore(int i);

    void getCurrentAccount(ISignInCallbacks iSignInCallbacks);

    void onCheckServerAuthorization(CheckServerAuthResult checkServerAuthResult);

    void onUploadServerAuthCode(boolean z);

    void recordConsent(RecordConsentRequest recordConsentRequest, ISignInCallbacks iSignInCallbacks);

    void resolveAccount(ResolveAccountRequest resolveAccountRequest, IResolveAccountCallbacks iResolveAccountCallbacks);

    void saveAccountToSessionStore(int i, Account account, ISignInCallbacks iSignInCallbacks);

    void saveDefaultAccountToSharedPref(IAccountAccessor iAccountAccessor, int i, boolean z);

    void setGamesHasBeenGreeted(boolean z);

    void signIn(SignInRequest signInRequest, ISignInCallbacks iSignInCallbacks);
}
