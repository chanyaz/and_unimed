package android.support.v4.widget;

import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@RequiresApi(16)
class aj extends ai {
    private Method a;
    private Field b;

    aj() {
        try {
            this.a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
        }
        try {
            this.b = View.class.getDeclaredField("mRecreateDisplayList");
            this.b.setAccessible(true);
        } catch (Throwable e2) {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
        }
    }

    public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
        if (this.a == null || this.b == null) {
            view.invalidate();
            return;
        }
        try {
            this.b.setBoolean(view, true);
            this.a.invoke(view, (Object[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
        }
        super.invalidateChildRegion(slidingPaneLayout, view);
    }
}
