package com.mopub.nativeads;

import android.app.Activity;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubServerPositioning;
import java.util.List;
import java.util.WeakHashMap;

public class MoPubAdAdapter extends BaseAdapter {
    @NonNull
    private final WeakHashMap<View, Integer> a;
    @NonNull
    private final Adapter b;
    @NonNull
    private final MoPubStreamAdPlacer c;
    @NonNull
    private final VisibilityTracker d;
    @Nullable
    private MoPubNativeAdLoadedListener e;

    public MoPubAdAdapter(@NonNull Activity activity, @NonNull Adapter adapter) {
        this(activity, adapter, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubAdAdapter(@NonNull Activity activity, @NonNull Adapter adapter, @NonNull MoPubClientPositioning moPubClientPositioning) {
        this(new MoPubStreamAdPlacer(activity, moPubClientPositioning), adapter, new VisibilityTracker(activity));
    }

    public MoPubAdAdapter(@NonNull Activity activity, @NonNull Adapter adapter, @NonNull MoPubServerPositioning moPubServerPositioning) {
        this(new MoPubStreamAdPlacer(activity, moPubServerPositioning), adapter, new VisibilityTracker(activity));
    }

    @VisibleForTesting
    MoPubAdAdapter(@NonNull MoPubStreamAdPlacer moPubStreamAdPlacer, @NonNull Adapter adapter, @NonNull VisibilityTracker visibilityTracker) {
        this.b = adapter;
        this.c = moPubStreamAdPlacer;
        this.a = new WeakHashMap();
        this.d = visibilityTracker;
        this.d.a(new VisibilityTrackerListener() {
            public void onVisibilityChanged(@NonNull List<View> list, List<View> list2) {
                MoPubAdAdapter.this.a((List) list);
            }
        });
        this.b.registerDataSetObserver(new DataSetObserver() {
            public void onChanged() {
                MoPubAdAdapter.this.c.setItemCount(MoPubAdAdapter.this.b.getCount());
                MoPubAdAdapter.this.notifyDataSetChanged();
            }

            public void onInvalidated() {
                MoPubAdAdapter.this.notifyDataSetInvalidated();
            }
        });
        this.c.setAdLoadedListener(new MoPubNativeAdLoadedListener() {
            public void onAdLoaded(int i) {
                MoPubAdAdapter.this.a(i);
            }

            public void onAdRemoved(int i) {
                MoPubAdAdapter.this.b(i);
            }
        });
        this.c.setItemCount(this.b.getCount());
    }

    private void a(@NonNull List<View> list) {
        int i = MoPubClientPositioning.NO_REPEAT;
        int i2 = 0;
        for (View view : list) {
            Integer num = (Integer) this.a.get(view);
            if (num != null) {
                i = Math.min(num.intValue(), i);
                i2 = Math.max(num.intValue(), i2);
            }
        }
        this.c.placeAdsInRange(i, i2 + 1);
    }

    @VisibleForTesting
    void a(int i) {
        if (this.e != null) {
            this.e.onAdLoaded(i);
        }
        notifyDataSetChanged();
    }

    public boolean areAllItemsEnabled() {
        return (this.b instanceof ListAdapter) && ((ListAdapter) this.b).areAllItemsEnabled();
    }

    @VisibleForTesting
    void b(int i) {
        if (this.e != null) {
            this.e.onAdRemoved(i);
        }
        notifyDataSetChanged();
    }

    public void clearAds() {
        this.c.clearAds();
    }

    public void destroy() {
        this.c.destroy();
        this.d.b();
    }

    public int getAdjustedPosition(int i) {
        return this.c.getAdjustedPosition(i);
    }

    public int getCount() {
        return this.c.getAdjustedCount(this.b.getCount());
    }

    @Nullable
    public Object getItem(int i) {
        Object adData = this.c.getAdData(i);
        return adData != null ? adData : this.b.getItem(this.c.getOriginalPosition(i));
    }

    public long getItemId(int i) {
        Object adData = this.c.getAdData(i);
        return adData != null ? (long) (-System.identityHashCode(adData)) : this.b.getItemId(this.c.getOriginalPosition(i));
    }

    public int getItemViewType(int i) {
        int adViewType = this.c.getAdViewType(i);
        return adViewType != 0 ? (adViewType + this.b.getViewTypeCount()) - 1 : this.b.getItemViewType(this.c.getOriginalPosition(i));
    }

    public int getOriginalPosition(int i) {
        return this.c.getOriginalPosition(i);
    }

    @Nullable
    public View getView(int i, View view, ViewGroup viewGroup) {
        View adView = this.c.getAdView(i, view, viewGroup);
        if (adView == null) {
            adView = this.b.getView(this.c.getOriginalPosition(i), view, viewGroup);
        }
        this.a.put(adView, Integer.valueOf(i));
        this.d.a(adView, 0);
        return adView;
    }

    public int getViewTypeCount() {
        return this.b.getViewTypeCount() + this.c.getAdViewTypeCount();
    }

    public boolean hasStableIds() {
        return this.b.hasStableIds();
    }

    public void insertItem(int i) {
        this.c.insertItem(i);
    }

    public boolean isAd(int i) {
        return this.c.isAd(i);
    }

    public boolean isEmpty() {
        return this.b.isEmpty() && this.c.getAdjustedCount(0) == 0;
    }

    public boolean isEnabled(int i) {
        return isAd(i) || ((this.b instanceof ListAdapter) && ((ListAdapter) this.b).isEnabled(this.c.getOriginalPosition(i)));
    }

    public void loadAds(@NonNull String str) {
        this.c.loadAds(str);
    }

    public void loadAds(@NonNull String str, @Nullable RequestParameters requestParameters) {
        this.c.loadAds(str, requestParameters);
    }

    public void refreshAds(@NonNull ListView listView, @NonNull String str) {
        refreshAds(listView, str, null);
    }

    public void refreshAds(@NonNull ListView listView, @NonNull String str, @Nullable RequestParameters requestParameters) {
        if (NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.refreshAds with a null ListView")) {
            View childAt = listView.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int max = Math.max(firstVisiblePosition - 1, 0);
            while (this.c.isAd(max) && max > 0) {
                max--;
            }
            int lastVisiblePosition = listView.getLastVisiblePosition();
            while (this.c.isAd(lastVisiblePosition) && lastVisiblePosition < getCount() - 1) {
                lastVisiblePosition++;
            }
            max = this.c.getOriginalPosition(max);
            this.c.removeAdsInRange(this.c.getOriginalCount(lastVisiblePosition + 1), this.c.getOriginalCount(getCount()));
            int removeAdsInRange = this.c.removeAdsInRange(0, max);
            if (removeAdsInRange > 0) {
                listView.setSelectionFromTop(firstVisiblePosition - removeAdsInRange, top);
            }
            loadAds(str, requestParameters);
        }
    }

    public final void registerAdRenderer(@NonNull MoPubAdRenderer moPubAdRenderer) {
        if (NoThrow.checkNotNull(moPubAdRenderer, "Tried to set a null ad renderer on the placer.")) {
            this.c.registerAdRenderer(moPubAdRenderer);
        }
    }

    public void removeItem(int i) {
        this.c.removeItem(i);
    }

    public final void setAdLoadedListener(@Nullable MoPubNativeAdLoadedListener moPubNativeAdLoadedListener) {
        this.e = moPubNativeAdLoadedListener;
    }

    public void setOnClickListener(@NonNull ListView listView, @Nullable final OnItemClickListener onItemClickListener) {
        if (!NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setOnClickListener with a null ListView")) {
            return;
        }
        if (onItemClickListener == null) {
            listView.setOnItemClickListener(null);
        } else {
            listView.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (!MoPubAdAdapter.this.c.isAd(i)) {
                        onItemClickListener.onItemClick(adapterView, view, MoPubAdAdapter.this.c.getOriginalPosition(i), j);
                    }
                }
            });
        }
    }

    public void setOnItemLongClickListener(@NonNull ListView listView, @Nullable final OnItemLongClickListener onItemLongClickListener) {
        if (!NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setOnItemLongClickListener with a null ListView")) {
            return;
        }
        if (onItemLongClickListener == null) {
            listView.setOnItemLongClickListener(null);
        } else {
            listView.setOnItemLongClickListener(new OnItemLongClickListener() {
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (!MoPubAdAdapter.this.isAd(i)) {
                        if (!onItemLongClickListener.onItemLongClick(adapterView, view, MoPubAdAdapter.this.c.getOriginalPosition(i), j)) {
                            return false;
                        }
                    }
                    return true;
                }
            });
        }
    }

    public void setOnItemSelectedListener(@NonNull ListView listView, @Nullable final OnItemSelectedListener onItemSelectedListener) {
        if (!NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setOnItemSelectedListener with a null ListView")) {
            return;
        }
        if (onItemSelectedListener == null) {
            listView.setOnItemSelectedListener(null);
        } else {
            listView.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (!MoPubAdAdapter.this.isAd(i)) {
                        onItemSelectedListener.onItemSelected(adapterView, view, MoPubAdAdapter.this.c.getOriginalPosition(i), j);
                    }
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                    onItemSelectedListener.onNothingSelected(adapterView);
                }
            });
        }
    }

    public void setSelection(@NonNull ListView listView, int i) {
        if (NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setSelection with a null ListView")) {
            listView.setSelection(this.c.getAdjustedPosition(i));
        }
    }

    public void smoothScrollToPosition(@NonNull ListView listView, int i) {
        if (NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.smoothScrollToPosition with a null ListView")) {
            listView.smoothScrollToPosition(this.c.getAdjustedPosition(i));
        }
    }
}
