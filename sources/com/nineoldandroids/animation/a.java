package com.nineoldandroids.animation;

public class a implements TypeEvaluator<Number> {
    /* renamed from: a */
    public Float evaluate(float f, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + ((number2.floatValue() - floatValue) * f));
    }
}
