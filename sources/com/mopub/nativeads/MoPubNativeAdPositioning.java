package com.mopub.nativeads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MoPubNativeAdPositioning {

    public class MoPubClientPositioning {
        public static final int NO_REPEAT = Integer.MAX_VALUE;
        @NonNull
        private final ArrayList<Integer> a = new ArrayList();
        private int b = NO_REPEAT;

        @NonNull
        List<Integer> a() {
            return this.a;
        }

        @NonNull
        public MoPubClientPositioning addFixedPosition(int i) {
            if (NoThrow.checkArgument(i >= 0)) {
                int binarySearch = Collections.binarySearch(this.a, Integer.valueOf(i));
                if (binarySearch < 0) {
                    this.a.add(binarySearch ^ -1, Integer.valueOf(i));
                }
            }
            return this;
        }

        int b() {
            return this.b;
        }

        @NonNull
        public MoPubClientPositioning enableRepeatingPositions(int i) {
            boolean z = true;
            if (i <= 1) {
                z = false;
            }
            if (NoThrow.checkArgument(z, "Repeating interval must be greater than 1")) {
                this.b = i;
            } else {
                this.b = NO_REPEAT;
            }
            return this;
        }
    }

    public class MoPubServerPositioning {
    }

    @NonNull
    static MoPubClientPositioning a(@NonNull MoPubClientPositioning moPubClientPositioning) {
        Preconditions.checkNotNull(moPubClientPositioning);
        MoPubClientPositioning moPubClientPositioning2 = new MoPubClientPositioning();
        moPubClientPositioning2.a.addAll(moPubClientPositioning.a);
        moPubClientPositioning2.b = moPubClientPositioning.b;
        return moPubClientPositioning2;
    }

    @NonNull
    public static MoPubClientPositioning clientPositioning() {
        return new MoPubClientPositioning();
    }

    @NonNull
    public static MoPubServerPositioning serverPositioning() {
        return new MoPubServerPositioning();
    }
}
