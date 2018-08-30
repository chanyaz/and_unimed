package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(21)
class ah implements CardViewImpl {
    ah() {
    }

    private ci a(CardViewDelegate cardViewDelegate) {
        return (ci) cardViewDelegate.getCardBackground();
    }

    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).c();
    }

    public float getElevation(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.getCardView().getElevation();
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).a();
    }

    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return getRadius(cardViewDelegate) * 2.0f;
    }

    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return getRadius(cardViewDelegate) * 2.0f;
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate).b();
    }

    public void initStatic() {
    }

    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        cardViewDelegate.setCardBackground(new ci(colorStateList, f));
        View cardView = cardViewDelegate.getCardView();
        cardView.setClipToOutline(true);
        cardView.setElevation(f2);
        setMaxElevation(cardViewDelegate, f3);
    }

    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
        setMaxElevation(cardViewDelegate, getMaxElevation(cardViewDelegate));
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        setMaxElevation(cardViewDelegate, getMaxElevation(cardViewDelegate));
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        a(cardViewDelegate).a(colorStateList);
    }

    public void setElevation(CardViewDelegate cardViewDelegate, float f) {
        cardViewDelegate.getCardView().setElevation(f);
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f) {
        a(cardViewDelegate).a(f, cardViewDelegate.getUseCompatPadding(), cardViewDelegate.getPreventCornerOverlap());
        updatePadding(cardViewDelegate);
    }

    public void setRadius(CardViewDelegate cardViewDelegate, float f) {
        a(cardViewDelegate).a(f);
    }

    public void updatePadding(CardViewDelegate cardViewDelegate) {
        if (cardViewDelegate.getUseCompatPadding()) {
            float maxElevation = getMaxElevation(cardViewDelegate);
            float radius = getRadius(cardViewDelegate);
            int ceil = (int) Math.ceil((double) RoundRectDrawableWithShadow.b(maxElevation, radius, cardViewDelegate.getPreventCornerOverlap()));
            int ceil2 = (int) Math.ceil((double) RoundRectDrawableWithShadow.a(maxElevation, radius, cardViewDelegate.getPreventCornerOverlap()));
            cardViewDelegate.setShadowPadding(ceil, ceil2, ceil, ceil2);
            return;
        }
        cardViewDelegate.setShadowPadding(0, 0, 0, 0);
    }
}
