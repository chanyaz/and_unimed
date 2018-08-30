package com.google.android.gms.analytics;

import android.content.BroadcastReceiver.PendingResult;

final class m implements Runnable {
    private final /* synthetic */ PendingResult a;

    m(CampaignTrackingReceiver campaignTrackingReceiver, PendingResult pendingResult) {
        this.a = pendingResult;
    }

    public final void run() {
        if (this.a != null) {
            this.a.finish();
        }
    }
}
