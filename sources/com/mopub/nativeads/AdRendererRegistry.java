package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;

public class AdRendererRegistry {
    @NonNull
    private final ArrayList<MoPubAdRenderer> a = new ArrayList();

    public int getAdRendererCount() {
        return this.a.size();
    }

    @Nullable
    public MoPubAdRenderer getRendererForAd(@NonNull BaseNativeAd baseNativeAd) {
        Preconditions.checkNotNull(baseNativeAd);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            MoPubAdRenderer moPubAdRenderer = (MoPubAdRenderer) it.next();
            if (moPubAdRenderer.supports(baseNativeAd)) {
                return moPubAdRenderer;
            }
        }
        return null;
    }

    @Nullable
    public MoPubAdRenderer getRendererForViewType(int i) {
        try {
            return (MoPubAdRenderer) this.a.get(i - 1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @NonNull
    public Iterable<MoPubAdRenderer> getRendererIterable() {
        return this.a;
    }

    public int getViewTypeForAd(@NonNull NativeAd nativeAd) {
        Preconditions.checkNotNull(nativeAd);
        for (int i = 0; i < this.a.size(); i++) {
            if (nativeAd.getMoPubAdRenderer() == this.a.get(i)) {
                return i + 1;
            }
        }
        return 0;
    }

    public void registerAdRenderer(@NonNull MoPubAdRenderer moPubAdRenderer) {
        this.a.add(moPubAdRenderer);
    }
}
