package android.support.transition;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;

@RequiresApi(14)
class ay implements ViewOverlayImpl {
    protected az a;

    ay(Context context, ViewGroup viewGroup, View view) {
        this.a = new az(context, viewGroup, view, this);
    }

    static ViewGroup a(View view) {
        View view2 = view;
        while (view2 != null) {
            if (view2.getId() == 16908290 && (view2 instanceof ViewGroup)) {
                return (ViewGroup) view2;
            }
            if (view2.getParent() instanceof ViewGroup) {
                view2 = (ViewGroup) view2.getParent();
            }
        }
        return null;
    }

    static ay b(View view) {
        ViewGroup a = a(view);
        if (a == null) {
            return null;
        }
        int childCount = a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = a.getChildAt(i);
            if (childAt instanceof az) {
                return ((az) childAt).e;
            }
        }
        return new at(a.getContext(), a, view);
    }

    public void add(@NonNull Drawable drawable) {
        this.a.a(drawable);
    }

    public void clear() {
        this.a.a();
    }

    public void remove(@NonNull Drawable drawable) {
        this.a.b(drawable);
    }
}
