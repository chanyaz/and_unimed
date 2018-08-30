package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;
import com.google.android.gms.location.ActivityTransitionRequest;

public final class ah implements ActivityRecognitionApi {
    public final PendingResult<Status> removeActivityUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.b(new aj(this, googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> requestActivityUpdates(GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        return googleApiClient.b(new ai(this, googleApiClient, j, pendingIntent));
    }

    public final PendingResult<Status> zza(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.b(new al(this, googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> zza(GoogleApiClient googleApiClient, ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent) {
        return googleApiClient.b(new ak(this, googleApiClient, activityTransitionRequest, pendingIntent));
    }
}
