package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.k;

public class a extends aa {
    private Account a;
    private Context b;
    private int c;

    public static Account a(IAccountAccessor iAccountAccessor) {
        Account account = null;
        if (iAccountAccessor != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = iAccountAccessor.getAccount();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof a) ? false : this.a.equals(((a) obj).a);
    }

    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.c) {
            return this.a;
        }
        if (k.isGooglePlayServicesUid(this.b, callingUid)) {
            this.c = callingUid;
            return this.a;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
