package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;

public class h implements ConnectionProgressReportCallbacks {
    private final /* synthetic */ BaseGmsClient a;

    public h(BaseGmsClient baseGmsClient) {
        this.a = baseGmsClient;
    }

    public void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
        if (connectionResult.b()) {
            this.a.getRemoteService(null, this.a.q());
        } else if (this.a.x != null) {
            this.a.x.onConnectionFailed(connectionResult);
        }
    }
}
