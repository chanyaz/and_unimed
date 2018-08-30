package android.support.transition;

import android.view.View;
import android.view.ViewGroup;

public class ac {
    private ViewGroup a;
    private Runnable b;

    static ac a(View view) {
        return (ac) view.getTag(aa.transition_current_scene);
    }

    static void a(View view, ac acVar) {
        view.setTag(aa.transition_current_scene, acVar);
    }

    public void a() {
        if (a(this.a) == this && this.b != null) {
            this.b.run();
        }
    }
}
