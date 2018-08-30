package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.h;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

public abstract class bo<VH extends ce> {
    private final bp a = new bp();
    private boolean b = false;

    public final void bindViewHolder(@NonNull VH vh, int i) {
        vh.b = i;
        if (hasStableIds()) {
            vh.d = getItemId(i);
        }
        vh.a(1, 519);
        h.a("RV OnBindView");
        onBindViewHolder(vh, i, vh.p());
        vh.o();
        LayoutParams layoutParams = vh.itemView.getLayoutParams();
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            ((RecyclerView.LayoutParams) layoutParams).e = true;
        }
        h.a();
    }

    public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i) {
        try {
            h.a("RV CreateView");
            VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
            if (onCreateViewHolder.itemView.getParent() != null) {
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            }
            onCreateViewHolder.e = i;
            return onCreateViewHolder;
        } finally {
            h.a();
        }
    }

    public abstract int getItemCount();

    public long getItemId(int i) {
        return -1;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public final boolean hasObservers() {
        return this.a.a();
    }

    public final boolean hasStableIds() {
        return this.b;
    }

    public final void notifyDataSetChanged() {
        this.a.b();
    }

    public final void notifyItemChanged(int i) {
        this.a.a(i, 1);
    }

    public final void notifyItemChanged(int i, @Nullable Object obj) {
        this.a.a(i, 1, obj);
    }

    public final void notifyItemInserted(int i) {
        this.a.b(i, 1);
    }

    public final void notifyItemMoved(int i, int i2) {
        this.a.d(i, i2);
    }

    public final void notifyItemRangeChanged(int i, int i2) {
        this.a.a(i, i2);
    }

    public final void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
        this.a.a(i, i2, obj);
    }

    public final void notifyItemRangeInserted(int i, int i2) {
        this.a.b(i, i2);
    }

    public final void notifyItemRangeRemoved(int i, int i2) {
        this.a.c(i, i2);
    }

    public final void notifyItemRemoved(int i) {
        this.a.c(i, 1);
    }

    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
    }

    public abstract void onBindViewHolder(@NonNull VH vh, int i);

    public void onBindViewHolder(@NonNull VH vh, int i, @NonNull List<Object> list) {
        onBindViewHolder(vh, i);
    }

    @NonNull
    public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);

    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
    }

    public boolean onFailedToRecycleView(@NonNull VH vh) {
        return false;
    }

    public void onViewAttachedToWindow(@NonNull VH vh) {
    }

    public void onViewDetachedFromWindow(@NonNull VH vh) {
    }

    public void onViewRecycled(@NonNull VH vh) {
    }

    public void registerAdapterDataObserver(@NonNull bq bqVar) {
        this.a.registerObserver(bqVar);
    }

    public void setHasStableIds(boolean z) {
        if (hasObservers()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.b = z;
    }

    public void unregisterAdapterDataObserver(@NonNull bq bqVar) {
        this.a.unregisterObserver(bqVar);
    }
}
