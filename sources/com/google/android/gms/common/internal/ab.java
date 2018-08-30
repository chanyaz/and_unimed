package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.stable.a;
import com.google.android.gms.internal.stable.c;

public class ab extends a implements IAccountAccessor {
    ab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    public Account getAccount() {
        Parcel a = a(2, a());
        Account account = (Account) c.a(a, Account.CREATOR);
        a.recycle();
        return account;
    }
}
