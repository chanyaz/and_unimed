package com.google.android.gms.signin.internal;

import android.os.IInterface;
import com.google.android.gms.common.api.Scope;
import java.util.List;

public interface IOfflineAccessCallbacks extends IInterface {
    void checkServerAuthorization(String str, List<Scope> list, ISignInService iSignInService);

    void uploadServerAuthCode(String str, String str2, ISignInService iSignInService);
}
