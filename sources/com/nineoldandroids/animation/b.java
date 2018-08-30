package com.nineoldandroids.animation;

public class b implements TypeEvaluator<Integer> {
    /* renamed from: a */
    public Integer evaluate(float f, Integer num, Integer num2) {
        int intValue = num.intValue();
        return Integer.valueOf((int) ((((float) (num2.intValue() - intValue)) * f) + ((float) intValue)));
    }
}
