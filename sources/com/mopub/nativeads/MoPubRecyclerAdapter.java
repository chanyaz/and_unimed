package com.mopub.nativeads;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.bo;
import android.support.v7.widget.bq;
import android.support.v7.widget.ce;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubServerPositioning;
import java.util.List;
import java.util.WeakHashMap;

public final class MoPubRecyclerAdapter extends bo<ce> {
    @NonNull
    private final bq a;
    @Nullable
    private RecyclerView b;
    @NonNull
    private final MoPubStreamAdPlacer c;
    @NonNull
    private final bo d;
    @NonNull
    private final VisibilityTracker e;
    @NonNull
    private final WeakHashMap<View, Integer> f;
    @NonNull
    private ContentChangeStrategy g;
    @Nullable
    private MoPubNativeAdLoadedListener h;

    public enum ContentChangeStrategy {
        INSERT_AT_END,
        MOVE_ALL_ADS_WITH_CONTENT,
        KEEP_ADS_FIXED
    }

    public MoPubRecyclerAdapter(@NonNull Activity activity, @NonNull bo boVar) {
        this(activity, boVar, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubRecyclerAdapter(@NonNull Activity activity, @NonNull bo boVar, @NonNull MoPubClientPositioning moPubClientPositioning) {
        this(new MoPubStreamAdPlacer(activity, moPubClientPositioning), boVar, new VisibilityTracker(activity));
    }

    public MoPubRecyclerAdapter(@NonNull Activity activity, @NonNull bo boVar, @NonNull MoPubServerPositioning moPubServerPositioning) {
        this(new MoPubStreamAdPlacer(activity, moPubServerPositioning), boVar, new VisibilityTracker(activity));
    }

    @VisibleForTesting
    MoPubRecyclerAdapter(@NonNull MoPubStreamAdPlacer moPubStreamAdPlacer, @NonNull bo boVar, @NonNull VisibilityTracker visibilityTracker) {
        this.g = ContentChangeStrategy.INSERT_AT_END;
        this.f = new WeakHashMap();
        this.d = boVar;
        this.e = visibilityTracker;
        this.e.a(new VisibilityTrackerListener() {
            public void onVisibilityChanged(List<View> list, List<View> list2) {
                MoPubRecyclerAdapter.this.a(list, list2);
            }
        });
        a(this.d.hasStableIds());
        this.c = moPubStreamAdPlacer;
        this.c.setAdLoadedListener(new MoPubNativeAdLoadedListener() {
            public void onAdLoaded(int i) {
                MoPubRecyclerAdapter.this.a(i);
            }

            public void onAdRemoved(int i) {
                MoPubRecyclerAdapter.this.b(i);
            }
        });
        this.c.setItemCount(this.d.getItemCount());
        this.a = new bq() {
            public void onChanged() {
                MoPubRecyclerAdapter.this.c.setItemCount(MoPubRecyclerAdapter.this.d.getItemCount());
                MoPubRecyclerAdapter.this.notifyDataSetChanged();
            }

            public void onItemRangeChanged(int i, int i2) {
                int adjustedPosition = MoPubRecyclerAdapter.this.c.getAdjustedPosition((i + i2) - 1);
                int adjustedPosition2 = MoPubRecyclerAdapter.this.c.getAdjustedPosition(i);
                MoPubRecyclerAdapter.this.notifyItemRangeChanged(adjustedPosition2, (adjustedPosition - adjustedPosition2) + 1);
            }

            public void onItemRangeInserted(int i, int i2) {
                int i3 = 0;
                int adjustedPosition = MoPubRecyclerAdapter.this.c.getAdjustedPosition(i);
                int itemCount = MoPubRecyclerAdapter.this.d.getItemCount();
                MoPubRecyclerAdapter.this.c.setItemCount(itemCount);
                itemCount = i + i2 >= itemCount ? 1 : 0;
                if (ContentChangeStrategy.KEEP_ADS_FIXED == MoPubRecyclerAdapter.this.g || (ContentChangeStrategy.INSERT_AT_END == MoPubRecyclerAdapter.this.g && itemCount != 0)) {
                    MoPubRecyclerAdapter.this.notifyDataSetChanged();
                    return;
                }
                while (i3 < i2) {
                    MoPubRecyclerAdapter.this.c.insertItem(i);
                    i3++;
                }
                MoPubRecyclerAdapter.this.notifyItemRangeInserted(adjustedPosition, i2);
            }

            public void onItemRangeMoved(int i, int i2, int i3) {
                MoPubRecyclerAdapter.this.notifyDataSetChanged();
            }

            public void onItemRangeRemoved(int i, int i2) {
                int i3 = 0;
                int adjustedPosition = MoPubRecyclerAdapter.this.c.getAdjustedPosition(i);
                int itemCount = MoPubRecyclerAdapter.this.d.getItemCount();
                MoPubRecyclerAdapter.this.c.setItemCount(itemCount);
                int i4 = i + i2 >= itemCount ? 1 : 0;
                if (ContentChangeStrategy.KEEP_ADS_FIXED == MoPubRecyclerAdapter.this.g || (ContentChangeStrategy.INSERT_AT_END == MoPubRecyclerAdapter.this.g && i4 != 0)) {
                    MoPubRecyclerAdapter.this.notifyDataSetChanged();
                    return;
                }
                i4 = MoPubRecyclerAdapter.this.c.getAdjustedCount(itemCount + i2);
                while (i3 < i2) {
                    MoPubRecyclerAdapter.this.c.removeItem(i);
                    i3++;
                }
                i4 -= MoPubRecyclerAdapter.this.c.getAdjustedCount(itemCount);
                MoPubRecyclerAdapter.this.notifyItemRangeRemoved(adjustedPosition - (i4 - i2), i4);
            }
        };
        this.d.registerAdapterDataObserver(this.a);
    }

    private void a(List<View> list, List<View> list2) {
        int i = MoPubClientPositioning.NO_REPEAT;
        int i2 = 0;
        for (View view : list) {
            Integer num = (Integer) this.f.get(view);
            if (num != null) {
                i = Math.min(num.intValue(), i);
                i2 = Math.max(num.intValue(), i2);
            }
        }
        this.c.placeAdsInRange(i, i2 + 1);
    }

    private void a(boolean z) {
        super.setHasStableIds(z);
    }

    public static int computeScrollOffset(@NonNull LinearLayoutManager linearLayoutManager, @Nullable ce ceVar) {
        if (ceVar == null) {
            return 0;
        }
        View view = ceVar.itemView;
        return linearLayoutManager.f() ? linearLayoutManager.g() ? view.getBottom() : view.getTop() : linearLayoutManager.e() ? linearLayoutManager.g() ? view.getRight() : view.getLeft() : 0;
    }

    @VisibleForTesting
    void a(int i) {
        if (this.h != null) {
            this.h.onAdLoaded(i);
        }
        notifyItemInserted(i);
    }

    @VisibleForTesting
    void b(int i) {
        if (this.h != null) {
            this.h.onAdRemoved(i);
        }
        notifyItemRemoved(i);
    }

    public void clearAds() {
        this.c.clearAds();
    }

    public void destroy() {
        this.d.unregisterAdapterDataObserver(this.a);
        this.c.destroy();
        this.e.b();
    }

    public int getAdjustedPosition(int i) {
        return this.c.getAdjustedPosition(i);
    }

    public int getItemCount() {
        return this.c.getAdjustedCount(this.d.getItemCount());
    }

    public long getItemId(int i) {
        if (!this.d.hasStableIds()) {
            return -1;
        }
        Object adData = this.c.getAdData(i);
        return adData != null ? (long) (-System.identityHashCode(adData)) : this.d.getItemId(this.c.getOriginalPosition(i));
    }

    public int getItemViewType(int i) {
        int adViewType = this.c.getAdViewType(i);
        return adViewType != 0 ? adViewType - 56 : this.d.getItemViewType(this.c.getOriginalPosition(i));
    }

    public int getOriginalPosition(int i) {
        return this.c.getOriginalPosition(i);
    }

    public boolean isAd(int i) {
        return this.c.isAd(i);
    }

    public void loadAds(@NonNull String str) {
        this.c.loadAds(str);
    }

    public void loadAds(@NonNull String str, @Nullable RequestParameters requestParameters) {
        this.c.loadAds(str, requestParameters);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.b = recyclerView;
    }

    public void onBindViewHolder(ce ceVar, int i) {
        Object adData = this.c.getAdData(i);
        if (adData != null) {
            this.c.bindAdView((NativeAd) adData, ceVar.itemView);
            return;
        }
        this.f.put(ceVar.itemView, Integer.valueOf(i));
        this.e.a(ceVar.itemView, 0);
        this.d.onBindViewHolder(ceVar, this.c.getOriginalPosition(i));
    }

    public ce onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i < -56 || i > this.c.getAdViewTypeCount() - 56) {
            return this.d.onCreateViewHolder(viewGroup, i);
        }
        MoPubAdRenderer adRendererForViewType = this.c.getAdRendererForViewType(i + 56);
        if (adRendererForViewType != null) {
            return new MoPubRecyclerViewHolder(adRendererForViewType.createAdView((Activity) viewGroup.getContext(), viewGroup));
        }
        MoPubLog.w("No view binder was registered for ads in MoPubRecyclerAdapter.");
        return null;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.b = null;
    }

    public boolean onFailedToRecycleView(ce ceVar) {
        return ceVar instanceof MoPubRecyclerViewHolder ? super.onFailedToRecycleView(ceVar) : this.d.onFailedToRecycleView(ceVar);
    }

    public void onViewAttachedToWindow(ce ceVar) {
        if (ceVar instanceof MoPubRecyclerViewHolder) {
            super.onViewAttachedToWindow(ceVar);
        } else {
            this.d.onViewAttachedToWindow(ceVar);
        }
    }

    public void onViewDetachedFromWindow(ce ceVar) {
        if (ceVar instanceof MoPubRecyclerViewHolder) {
            super.onViewDetachedFromWindow(ceVar);
        } else {
            this.d.onViewDetachedFromWindow(ceVar);
        }
    }

    public void onViewRecycled(ce ceVar) {
        if (ceVar instanceof MoPubRecyclerViewHolder) {
            super.onViewRecycled(ceVar);
        } else {
            this.d.onViewRecycled(ceVar);
        }
    }

    public void refreshAds(@NonNull String str) {
        refreshAds(str, null);
    }

    public void refreshAds(@NonNull String str, @Nullable RequestParameters requestParameters) {
        if (this.b == null) {
            MoPubLog.w("This adapter is not attached to a RecyclerView and cannot be refreshed.");
            return;
        }
        LayoutManager layoutManager = this.b.getLayoutManager();
        if (layoutManager == null) {
            MoPubLog.w("Can't refresh ads when there is no layout manager on a RecyclerView.");
        } else if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int n = linearLayoutManager.n();
            int computeScrollOffset = computeScrollOffset(linearLayoutManager, this.b.d(n));
            int max = Math.max(0, n - 1);
            while (this.c.isAd(max) && max > 0) {
                max--;
            }
            int itemCount = getItemCount();
            int o = linearLayoutManager.o();
            while (this.c.isAd(o) && o < itemCount - 1) {
                o++;
            }
            max = this.c.getOriginalPosition(max);
            this.c.removeAdsInRange(this.c.getOriginalPosition(o), this.d.getItemCount());
            max = this.c.removeAdsInRange(0, max);
            if (max > 0) {
                linearLayoutManager.b(n - max, computeScrollOffset);
            }
            loadAds(str, requestParameters);
        } else {
            MoPubLog.w("This LayoutManager can't be refreshed.");
        }
    }

    public void registerAdRenderer(@NonNull MoPubAdRenderer moPubAdRenderer) {
        if (NoThrow.checkNotNull(moPubAdRenderer, "Cannot register a null adRenderer")) {
            this.c.registerAdRenderer(moPubAdRenderer);
        }
    }

    public void setAdLoadedListener(@Nullable MoPubNativeAdLoadedListener moPubNativeAdLoadedListener) {
        this.h = moPubNativeAdLoadedListener;
    }

    public void setContentChangeStrategy(@NonNull ContentChangeStrategy contentChangeStrategy) {
        if (NoThrow.checkNotNull(contentChangeStrategy)) {
            this.g = contentChangeStrategy;
        }
    }

    public void setHasStableIds(boolean z) {
        a(z);
        this.d.unregisterAdapterDataObserver(this.a);
        this.d.setHasStableIds(z);
        this.d.registerAdapterDataObserver(this.a);
    }
}
