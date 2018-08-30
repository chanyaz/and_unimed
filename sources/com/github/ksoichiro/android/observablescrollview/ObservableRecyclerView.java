package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class ObservableRecyclerView extends RecyclerView implements Scrollable {
    private static int J = 22;
    private int K;
    private int L = -1;
    private int M;
    private int N;
    private int O;
    private SparseIntArray P;
    private ObservableScrollViewCallbacks Q;
    private ScrollState R;
    private boolean S;
    private boolean T;
    private boolean U;
    private MotionEvent V;
    private ViewGroup W;

    class SavedState implements Parcelable {
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
        public static final SavedState a = new SavedState() {
        };
        int b;
        int c;
        int d;
        int e;
        int f;
        SparseIntArray g;
        Parcelable h;

        private SavedState() {
            this.c = -1;
            this.h = null;
        }

        private SavedState(Parcel parcel) {
            this.c = -1;
            Parcelable readParcelable = parcel.readParcelable(RecyclerView.class.getClassLoader());
            if (readParcelable == null) {
                readParcelable = a;
            }
            this.h = readParcelable;
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = new SparseIntArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                for (int i = 0; i < readInt; i++) {
                    this.g.put(parcel.readInt(), parcel.readInt());
                }
            }
        }

        /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            this.c = -1;
            if (parcelable == a) {
                parcelable = null;
            }
            this.h = parcelable;
        }

        public Parcelable a() {
            return this.h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            parcel.writeParcelable(this.h, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            int size = this.g == null ? 0 : this.g.size();
            parcel.writeInt(size);
            if (size > 0) {
                while (i2 < size) {
                    parcel.writeInt(this.g.keyAt(i2));
                    parcel.writeInt(this.g.valueAt(i2));
                    i2++;
                }
            }
        }
    }

    public ObservableRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        z();
    }

    public ObservableRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        z();
    }

    private void A() {
        try {
            super.g(null);
        } catch (NoSuchMethodError e) {
            J = 21;
        }
    }

    private void z() {
        this.P = new SparseIntArray();
        A();
    }

    public int g(View view) {
        return 22 <= J ? super.g(view) : f(view);
    }

    public int getCurrentScrollY() {
        return this.O;
    }

    public void j(int i) {
        LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null || !(layoutManager instanceof LinearLayoutManager)) {
            a(i);
        } else {
            ((LinearLayoutManager) layoutManager).b(i, 0);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Q != null) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.T = true;
                    this.S = true;
                    this.Q.onDownMotionEvent();
                    break;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.K = savedState.b;
        this.L = savedState.c;
        this.M = savedState.d;
        this.N = savedState.e;
        this.O = savedState.f;
        this.P = savedState.g;
        super.onRestoreInstanceState(savedState.a());
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.b = this.K;
        savedState.c = this.L;
        savedState.d = this.M;
        savedState.e = this.N;
        savedState.f = this.O;
        savedState.g = this.P;
        return savedState;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.Q != null && getChildCount() > 0) {
            int height;
            int g = g(getChildAt(0));
            int g2 = g(getChildAt(getChildCount() - 1));
            int i5 = 0;
            int i6 = g;
            while (i6 <= g2) {
                View childAt = getChildAt(i5);
                height = (childAt == null || (this.P.indexOfKey(i6) >= 0 && childAt.getHeight() == this.P.get(i6))) ? 0 : childAt.getHeight();
                this.P.put(i6, height);
                i6++;
                i5++;
            }
            View childAt2 = getChildAt(0);
            if (childAt2 != null) {
                if (this.K < g) {
                    if (g - this.K != 1) {
                        height = g - 1;
                        i5 = 0;
                        while (height > this.K) {
                            i5 += this.P.indexOfKey(height) > 0 ? this.P.get(height) : childAt2.getHeight();
                            height--;
                        }
                    } else {
                        i5 = 0;
                    }
                    this.M += i5 + this.L;
                    this.L = childAt2.getHeight();
                } else if (g < this.K) {
                    if (this.K - g != 1) {
                        i5 = this.K - 1;
                        height = 0;
                        while (i5 > g) {
                            height += this.P.indexOfKey(i5) > 0 ? this.P.get(i5) : childAt2.getHeight();
                            i5--;
                        }
                    } else {
                        height = 0;
                    }
                    this.M -= height + childAt2.getHeight();
                    this.L = childAt2.getHeight();
                } else if (g == 0) {
                    this.L = childAt2.getHeight();
                    this.M = 0;
                }
                if (this.L < 0) {
                    this.L = 0;
                }
                this.O = this.M - childAt2.getTop();
                this.K = g;
                this.Q.onScrollChanged(this.O, this.S, this.T);
                if (this.S) {
                    this.S = false;
                }
                if (this.N < this.O) {
                    this.R = ScrollState.UP;
                } else if (this.O < this.N) {
                    this.R = ScrollState.DOWN;
                } else {
                    this.R = ScrollState.STOP;
                }
                this.N = this.O;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        if (this.Q != null) {
            switch (motionEvent.getActionMasked()) {
                case 1:
                case 3:
                    this.U = false;
                    this.T = false;
                    this.Q.onUpOrCancelMotionEvent(this.R);
                    break;
                case 2:
                    if (this.V == null) {
                        this.V = motionEvent;
                    }
                    float y = motionEvent.getY() - this.V.getY();
                    this.V = MotionEvent.obtainNoHistory(motionEvent);
                    if (((float) getCurrentScrollY()) - y <= 0.0f) {
                        if (this.U) {
                            return false;
                        }
                        final View view = this.W == null ? (ViewGroup) getParent() : this.W;
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
                        this.U = true;
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
        View childAt = getChildAt(0);
        if (childAt != null) {
            j(i / childAt.getHeight());
        }
    }

    public void setScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks) {
        this.Q = observableScrollViewCallbacks;
    }

    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.W = viewGroup;
    }
}
