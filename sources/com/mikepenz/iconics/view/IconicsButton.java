package com.mikepenz.iconics.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView.BufferType;
import com.mikepenz.iconics.b;

public class IconicsButton extends Button {
    public IconicsButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IconicsButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        setAllCaps(false);
        if (isInEditMode()) {
            super.setText(charSequence, bufferType);
        } else {
            super.setText(new b().a(getContext()).a(charSequence).a(), bufferType);
        }
    }
}
