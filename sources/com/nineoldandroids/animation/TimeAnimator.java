package com.nineoldandroids.animation;

public class TimeAnimator extends ValueAnimator {
    private long g = -1;

    public interface TimeListener {
        void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2);
    }
}
