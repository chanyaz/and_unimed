package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.f;

final class ae extends f<LocationSettingsResult> {
    private final /* synthetic */ LocationSettingsRequest b;
    private final /* synthetic */ String c = null;

    ae(ad adVar, GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest, String str) {
        this.b = locationSettingsRequest;
        super(googleApiClient);
    }
}
