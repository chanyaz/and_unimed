package com.puzzlersworld.android.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
import com.puzzlersworld.android.util.annotations.EditTextImeBackListener;

public class EditTextBackEvent extends EditText {
    private EditTextImeBackListener a;

    public EditTextBackEvent(Context context) {
        super(context);
    }

    public EditTextBackEvent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EditTextBackEvent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && this.a != null) {
            this.a.onImeBack(this, getText().toString());
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setOnEditTextImeBackListener(EditTextImeBackListener editTextImeBackListener) {
        this.a = editTextImeBackListener;
    }
}
