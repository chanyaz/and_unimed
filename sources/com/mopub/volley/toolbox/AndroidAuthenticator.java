package com.mopub.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mopub.volley.AuthFailureError;

public class AndroidAuthenticator implements Authenticator {
    private final Context a;
    private final Account b;
    private final String c;
    private final boolean d;

    public AndroidAuthenticator(Context context, Account account, String str) {
        this(context, account, str, false);
    }

    public AndroidAuthenticator(Context context, Account account, String str, boolean z) {
        this.a = context;
        this.b = account;
        this.c = str;
        this.d = z;
    }

    public Account getAccount() {
        return this.b;
    }

    public String getAuthToken() {
        String str = null;
        AccountManagerFuture authToken = AccountManager.get(this.a).getAuthToken(this.b, this.c, this.d, null, null);
        try {
            Bundle bundle = (Bundle) authToken.getResult();
            if (authToken.isDone() && !authToken.isCancelled()) {
                if (bundle.containsKey("intent")) {
                    throw new AuthFailureError((Intent) bundle.getParcelable("intent"));
                }
                str = bundle.getString("authtoken");
            }
            if (str != null) {
                return str;
            }
            throw new AuthFailureError("Got null auth token for type: " + this.c);
        } catch (Exception e) {
            throw new AuthFailureError("Error while retrieving auth token", e);
        }
    }

    public void invalidateAuthToken(String str) {
        AccountManager.get(this.a).invalidateAuthToken(this.b.type, str);
    }
}
