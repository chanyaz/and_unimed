package android.support.transition;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;

@RequiresApi(14)
class at extends ay implements ViewGroupOverlayImpl {
    at(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    static at a(ViewGroup viewGroup) {
        return (at) ay.b(viewGroup);
    }

    public void add(@NonNull View view) {
        this.a.a(view);
    }

    public void remove(@NonNull View view) {
        this.a.b(view);
    }
}
