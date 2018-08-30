package com.puzzlersworld.android.util;

public abstract class SystemUiHider {
    private static OnVisibilityChangeListener a = new OnVisibilityChangeListener() {
        public void onVisibilityChange(boolean z) {
        }
    };

    public interface OnVisibilityChangeListener {
        void onVisibilityChange(boolean z);
    }
}
