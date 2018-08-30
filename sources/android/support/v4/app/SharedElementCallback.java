package android.support.v4.app;

import android.view.View;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback {
    private static int a = 1048576;

    public interface OnSharedElementsReadyListener {
        void onSharedElementsReady();
    }

    public void a(List<String> list, List<View> list2, List<View> list3) {
    }

    public void a(List<String> list, Map<String, View> map) {
    }

    public void b(List<String> list, List<View> list2, List<View> list3) {
    }
}
