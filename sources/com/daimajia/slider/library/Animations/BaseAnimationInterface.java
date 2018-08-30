package com.daimajia.slider.library.Animations;

import android.view.View;

public interface BaseAnimationInterface {
    void onCurrentItemDisappear(View view);

    void onNextItemAppear(View view);

    void onPrepareCurrentItemLeaveScreen(View view);

    void onPrepareNextItemShowInScreen(View view);
}
