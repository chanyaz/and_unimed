package android.support.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.support.annotation.NonNull;

public interface Animatable2Compat extends Animatable {
    void clearAnimationCallbacks();

    void registerAnimationCallback(@NonNull b bVar);

    boolean unregisterAnimationCallback(@NonNull b bVar);
}
