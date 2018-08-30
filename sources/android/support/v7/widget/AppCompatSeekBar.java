package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.RequiresApi;
import android.support.v7.a.b;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar extends SeekBar {
    private final aa a;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new aa(this);
        this.a.a(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.c();
    }

    @RequiresApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.a.b();
    }

    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.a(canvas);
    }
}
