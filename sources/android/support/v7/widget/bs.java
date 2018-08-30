package android.support.v7.widget;

class bs implements ItemAnimatorListener {
    final /* synthetic */ RecyclerView a;

    bs(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void onAnimationFinished(ce ceVar) {
        ceVar.setIsRecyclable(true);
        if (ceVar.g != null && ceVar.h == null) {
            ceVar.g = null;
        }
        ceVar.h = null;
        if (!ceVar.t() && !this.a.a(ceVar.itemView) && ceVar.m()) {
            this.a.removeDetachedView(ceVar.itemView, false);
        }
    }
}
