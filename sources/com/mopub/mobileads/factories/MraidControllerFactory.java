package com.mopub.mobileads.factories;

import android.content.Context;
import android.support.annotation.NonNull;
import com.mopub.common.AdReport;
import com.mopub.common.VisibleForTesting;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.PlacementType;

public class MraidControllerFactory {
    protected static MraidControllerFactory a = new MraidControllerFactory();

    public static MraidController create(@NonNull Context context, @NonNull AdReport adReport, @NonNull PlacementType placementType) {
        return a.a(context, adReport, placementType);
    }

    @VisibleForTesting
    public static void setInstance(MraidControllerFactory mraidControllerFactory) {
        a = mraidControllerFactory;
    }

    protected MraidController a(@NonNull Context context, @NonNull AdReport adReport, @NonNull PlacementType placementType) {
        return new MraidController(context, adReport, placementType);
    }
}
