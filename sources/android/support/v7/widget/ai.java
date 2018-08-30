package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

class ai implements CardViewImpl {
    private final RectF a = new RectF();

    ai() {
    }

    private RoundRectDrawableWithShadow a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f, f2, f3);
    }

    private RoundRectDrawableWithShadow a(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.getCardBackground();
    }

    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).f();
    }

    public float getElevation(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).b();
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).c();
    }

    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).e();
    }

    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).d();
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).a();
    }

    public void initStatic() {
        RoundRectDrawableWithShadow.a = new RoundRectHelper() {
            public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
                float f2 = 2.0f * f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    ai.this.a.set(-f3, -f3, f3, f3);
                    int save = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(ai.this.a, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(ai.this.a, 180.0f, 90.0f, true, paint);
                    canvas.translate(height, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(ai.this.a, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(ai.this.a, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(save);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, 1.0f + (rectF.right - f3), rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
            }
        };
    }

    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        Drawable a = a(context, colorStateList, f, f2, f3);
        a.a(cardViewDelegate.getPreventCornerOverlap());
        cardViewDelegate.setCardBackground(a);
        updatePadding(cardViewDelegate);
    }

    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        a(cardViewDelegate).a(cardViewDelegate.getPreventCornerOverlap());
        updatePadding(cardViewDelegate);
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        a(cardViewDelegate).a(colorStateList);
    }

    public void setElevation(CardViewDelegate cardViewDelegate, float f) {
        a(cardViewDelegate).b(f);
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f) {
        a(cardViewDelegate).c(f);
        updatePadding(cardViewDelegate);
    }

    public void setRadius(CardViewDelegate cardViewDelegate, float f) {
        a(cardViewDelegate).a(f);
        updatePadding(cardViewDelegate);
    }

    public void updatePadding(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        a(cardViewDelegate).a(rect);
        cardViewDelegate.setMinWidthHeightInternal((int) Math.ceil((double) getMinWidth(cardViewDelegate)), (int) Math.ceil((double) getMinHeight(cardViewDelegate)));
        cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
