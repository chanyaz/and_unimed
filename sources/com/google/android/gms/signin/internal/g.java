package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IResolveAccountCallbacks;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.internal.stable.a;
import com.google.android.gms.internal.stable.c;

public class g extends a implements ISignInService {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public void authAccount(AuthAccountRequest authAccountRequest, ISignInCallbacks iSignInCallbacks) {
        Parcel a = a();
        c.a(a, (Parcelable) authAccountRequest);
        c.a(a, (IInterface) iSignInCallbacks);
        b(2, a);
    }

    public void clearAccountFromSessionStore(int i) {
        Parcel a = a();
        a.writeInt(i);
        b(7, a);
    }

    public void getCurrentAccount(ISignInCallbacks iSignInCallbacks) {
        Parcel a = a();
        c.a(a, (IInterface) iSignInCallbacks);
        b(11, a);
    }

    public void onCheckServerAuthorization(CheckServerAuthResult checkServerAuthResult) {
        Parcel a = a();
        c.a(a, (Parcelable) checkServerAuthResult);
        b(3, a);
    }

    public void onUploadServerAuthCode(boolean z) {
        Parcel a = a();
        c.a(a, z);
        b(4, a);
    }

    public void recordConsent(RecordConsentRequest recordConsentRequest, ISignInCallbacks iSignInCallbacks) {
        Parcel a = a();
        c.a(a, (Parcelable) recordConsentRequest);
        c.a(a, (IInterface) iSignInCallbacks);
        b(10, a);
    }

    public void resolveAccount(ResolveAccountRequest resolveAccountRequest, IResolveAccountCallbacks iResolveAccountCallbacks) {
        Parcel a = a();
        c.a(a, (Parcelable) resolveAccountRequest);
        c.a(a, (IInterface) iResolveAccountCallbacks);
        b(5, a);
    }

    public void saveAccountToSessionStore(int i, Account account, ISignInCallbacks iSignInCallbacks) {
        Parcel a = a();
        a.writeInt(i);
        c.a(a, (Parcelable) account);
        c.a(a, (IInterface) iSignInCallbacks);
        b(8, a);
    }

    public void saveDefaultAccountToSharedPref(IAccountAccessor iAccountAccessor, int i, boolean z) {
        Parcel a = a();
        c.a(a, (IInterface) iAccountAccessor);
        a.writeInt(i);
        c.a(a, z);
        b(9, a);
    }

    public void setGamesHasBeenGreeted(boolean z) {
        Parcel a = a();
        c.a(a, z);
        b(13, a);
    }

    public void signIn(SignInRequest signInRequest, ISignInCallbacks iSignInCallbacks) {
        Parcel a = a();
        c.a(a, (Parcelable) signInRequest);
        c.a(a, (IInterface) iSignInCallbacks);
        b(12, a);
    }
}
