package com.google.android.exoplayer.text;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public final class SubtitleLayout extends View {
    private final List<c> a = new ArrayList();
    private List<b> b;
    private float c = 1.0f;
    private a d = a.a;

    public SubtitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void dispatchDraw(Canvas canvas) {
        int size = this.b == null ? 0 : this.b.size();
        for (int i = 0; i < size; i++) {
            ((c) this.a.get(i)).a((b) this.b.get(i), this.d, this.c, canvas, getLeft(), getTop(), getRight(), getBottom());
        }
    }

    public void setCues(List<b> list) {
        if (this.b != list) {
            this.b = list;
            int size = list == null ? 0 : list.size();
            while (this.a.size() < size) {
                this.a.add(new c(getContext()));
            }
            invalidate();
        }
    }

    public void setFontScale(float f) {
        if (this.c != f) {
            this.c = f;
            invalidate();
        }
    }

    public void setStyle(a aVar) {
        if (this.d != aVar) {
            this.d = aVar;
            invalidate();
        }
    }
}
