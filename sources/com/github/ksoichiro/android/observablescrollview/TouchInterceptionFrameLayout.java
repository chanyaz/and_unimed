package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class TouchInterceptionFrameLayout extends FrameLayout {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private PointF e;
    private MotionEvent f;
    private TouchInterceptionListener g;

    public interface TouchInterceptionListener {
        void onDownMotionEvent(MotionEvent motionEvent);

        void onMoveMotionEvent(MotionEvent motionEvent, float f, float f2);

        void onUpOrCancelMotionEvent(MotionEvent motionEvent);

        boolean shouldInterceptTouchEvent(MotionEvent motionEvent, boolean z, float f, float f2);
    }

    public TouchInterceptionFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TouchInterceptionFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private MotionEvent a(MotionEvent motionEvent, int i) {
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        obtainNoHistory.setAction(i);
        return obtainNoHistory;
    }

    private void a(MotionEvent motionEvent, MotionEvent... motionEventArr) {
        if (motionEvent != null) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt != null) {
                    Rect rect = new Rect();
                    childAt.getHitRect(rect);
                    MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                    if (rect.contains((int) obtainNoHistory.getX(), (int) obtainNoHistory.getY())) {
                        int i;
                        float f = (float) (-childAt.getLeft());
                        float f2 = (float) (-childAt.getTop());
                        if (motionEventArr != null) {
                            i = 0;
                            for (MotionEvent motionEvent2 : motionEventArr) {
                                MotionEvent motionEvent22;
                                if (motionEvent22 != null) {
                                    motionEvent22 = MotionEvent.obtainNoHistory(motionEvent22);
                                    motionEvent22.offsetLocation(f, f2);
                                    i |= childAt.dispatchTouchEvent(motionEvent22);
                                }
                            }
                        } else {
                            i = 0;
                        }
                        obtainNoHistory.offsetLocation(f, f2);
                        if ((i | childAt.dispatchTouchEvent(obtainNoHistory)) != 0) {
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.g == null) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.e = new PointF(motionEvent.getX(), motionEvent.getY());
                this.f = MotionEvent.obtainNoHistory(motionEvent);
                this.b = true;
                this.a = this.g.shouldInterceptTouchEvent(motionEvent, false, 0.0f, 0.0f);
                this.c = this.a;
                this.d = false;
                return this.a;
            case 2:
                if (this.e == null) {
                    this.e = new PointF(motionEvent.getX(), motionEvent.getY());
                }
                this.a = this.g.shouldInterceptTouchEvent(motionEvent, true, motionEvent.getX() - this.e.x, motionEvent.getY() - this.e.y);
                return this.a;
            default:
                return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g != null) {
            MotionEvent obtainNoHistory;
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (this.a) {
                        this.g.onDownMotionEvent(motionEvent);
                        a(motionEvent, new MotionEvent[0]);
                        return true;
                    }
                    break;
                case 1:
                case 3:
                    this.c = false;
                    if (this.a) {
                        this.g.onUpOrCancelMotionEvent(motionEvent);
                    }
                    if (!this.d) {
                        this.d = true;
                        if (this.b) {
                            this.b = false;
                            MotionEvent.obtainNoHistory(this.f).setLocation(motionEvent.getX(), motionEvent.getY());
                            a(motionEvent, obtainNoHistory);
                        } else {
                            a(motionEvent, new MotionEvent[0]);
                        }
                    }
                    return true;
                case 2:
                    if (this.e == null) {
                        this.e = new PointF(motionEvent.getX(), motionEvent.getY());
                    }
                    float x = motionEvent.getX() - this.e.x;
                    float y = motionEvent.getY() - this.e.y;
                    this.a = this.g.shouldInterceptTouchEvent(motionEvent, true, x, y);
                    if (!this.a) {
                        if (this.b) {
                            this.b = false;
                            MotionEvent.obtainNoHistory(this.f).setLocation(motionEvent.getX(), motionEvent.getY());
                            a(motionEvent, obtainNoHistory);
                        } else {
                            a(motionEvent, new MotionEvent[0]);
                        }
                        this.c = false;
                        this.d = false;
                        break;
                    }
                    if (!this.c) {
                        this.c = true;
                        obtainNoHistory = MotionEvent.obtainNoHistory(this.f);
                        obtainNoHistory.setLocation(motionEvent.getX(), motionEvent.getY());
                        this.g.onDownMotionEvent(obtainNoHistory);
                        this.e = new PointF(motionEvent.getX(), motionEvent.getY());
                        y = 0.0f;
                        x = 0.0f;
                    }
                    if (!this.d) {
                        this.d = true;
                        a(a(motionEvent, 3), new MotionEvent[0]);
                    }
                    this.g.onMoveMotionEvent(motionEvent, x, y);
                    this.b = true;
                    return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setScrollInterceptionListener(TouchInterceptionListener touchInterceptionListener) {
        this.g = touchInterceptionListener;
    }
}
