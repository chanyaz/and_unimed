package com.mikepenz.iconics.view;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.mikepenz.iconics.b;

public class IconicsCompatButton extends AppCompatButton {
    public IconicsCompatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IconicsCompatButton(Context context, AttributeSet attributeSet, int i) {
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
