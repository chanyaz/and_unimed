package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

class a {
    private static final AnimatorUtilsImpl a;

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new b();
        } else {
            a = new AnimatorUtilsApi14();
        }
    }

    a() {
    }

    static void a(@NonNull Animator animator) {
        a.pause(animator);
    }

    static void a(@NonNull Animator animator, @NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        a.addPauseListener(animator, animatorListenerAdapter);
    }

    static void b(@NonNull Animator animator) {
        a.resume(animator);
    }
}
