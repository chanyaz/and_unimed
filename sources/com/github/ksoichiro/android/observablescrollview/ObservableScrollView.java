package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.widget.ScrollView;

public class ObservableScrollView extends ScrollView implements Scrollable {
    private int a;
    private int b;
    private ObservableScrollViewCallbacks c;
    private ScrollState d;
    private boolean e;
    private boolean f;
    private boolean g;
    private MotionEvent h;
    private ViewGroup i;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int a;
        int b;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            this.b = parcel.readInt();
        }

        /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
        }
    }

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getCurrentScrollY() {
        return this.b;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.c != null) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.f = true;
                    this.e = true;
                    this.c.onDownMotionEvent();
                    break;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.a = savedState.a;
        this.b = savedState.b;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.a;
        savedState.b = this.b;
        return savedState;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.c != null) {
            this.b = i2;
            this.c.onScrollChanged(i2, this.e, this.f);
            if (this.e) {
                this.e = false;
            }
            if (this.a < i2) {
                this.d = ScrollState.UP;
            } else if (i2 < this.a) {
                this.d = ScrollState.DOWN;
            }
            this.a = i2;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        if (this.c != null) {
            switch (motionEvent.getActionMasked()) {
                case 1:
                case 3:
                    this.g = false;
                    this.f = false;
                    this.c.onUpOrCancelMotionEvent(this.d);
                    break;
                case 2:
                    if (this.h == null) {
                        this.h = motionEvent;
                    }
                    float y = motionEvent.getY() - this.h.getY();
                    this.h = MotionEvent.obtainNoHistory(motionEvent);
                    if (((float) getCurrentScrollY()) - y <= 0.0f) {
                        if (this.g) {
                            return false;
                        }
                        final View view = this.i == null ? (ViewGroup) getParent() : this.i;
                        View view2 = this;
                        float f2 = 0.0f;
                        while (view2 != null && view2 != view) {
                            f2 += (float) (view2.getLeft() - view2.getScrollX());
                            f += (float) (view2.getTop() - view2.getScrollY());
                            view2 = (View) view2.getParent();
                        }
                        final MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                        obtainNoHistory.offsetLocation(f2, f);
                        if (!view.onInterceptTouchEvent(obtainNoHistory)) {
                            return super.onTouchEvent(motionEvent);
                        }
                        this.g = true;
                        obtainNoHistory.setAction(0);
                        post(new Runnable() {
                            public void run() {
                                view.dispatchTouchEvent(obtainNoHistory);
                            }
                        });
                        return false;
                    }
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scrollVerticallyTo(int i) {
        scrollTo(0, i);
    }

    public void setScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks) {
        this.c = observableScrollViewCallbacks;
    }

    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.i = viewGroup;
    }
}
