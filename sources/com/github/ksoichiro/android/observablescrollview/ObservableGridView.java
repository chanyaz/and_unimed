package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class ObservableGridView extends GridView implements Scrollable {
    private int a;
    private int b = -1;
    private int c;
    private int d;
    private int e;
    private SparseIntArray f;
    private ObservableScrollViewCallbacks g;
    private ScrollState h;
    private boolean i;
    private boolean j;
    private boolean k;
    private MotionEvent l;
    private ViewGroup m;
    private ArrayList<a> n;
    private ArrayList<a> o;
    private OnScrollListener p;
    private OnScrollListener q = new OnScrollListener() {
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (ObservableGridView.this.p != null) {
                ObservableGridView.this.p.onScroll(absListView, i, i2, i3);
            }
            ObservableGridView.this.b();
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (ObservableGridView.this.p != null) {
                ObservableGridView.this.p.onScrollStateChanged(absListView, i);
            }
        }
    };

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
        int c;
        int d;
        int e;
        SparseIntArray f;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.b = -1;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = new SparseIntArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                for (int i = 0; i < readInt; i++) {
                    this.f.put(parcel.readInt(), parcel.readInt());
                }
            }
        }

        /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.b = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            int size = this.f == null ? 0 : this.f.size();
            parcel.writeInt(size);
            if (size > 0) {
                while (i2 < size) {
                    parcel.writeInt(this.f.keyAt(i2));
                    parcel.writeInt(this.f.valueAt(i2));
                    i2++;
                }
            }
        }
    }

    public ObservableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ObservableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f = new SparseIntArray();
        this.n = new ArrayList();
        this.o = new ArrayList();
        super.setClipChildren(false);
        super.setOnScrollListener(this.q);
    }

    private void b() {
        if (this.g != null && getChildCount() > 0) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int firstVisiblePosition2 = getFirstVisiblePosition();
            int i = 0;
            while (firstVisiblePosition2 <= getLastVisiblePosition()) {
                if ((this.f.indexOfKey(firstVisiblePosition2) < 0 || getChildAt(i).getHeight() != this.f.get(firstVisiblePosition2)) && firstVisiblePosition2 % getNumColumnsCompat() == 0) {
                    this.f.put(firstVisiblePosition2, getChildAt(i).getHeight());
                }
                firstVisiblePosition2++;
                i++;
            }
            View childAt = getChildAt(0);
            if (childAt != null) {
                if (this.a < firstVisiblePosition) {
                    if (firstVisiblePosition - this.a != 1) {
                        firstVisiblePosition2 = 0;
                        for (i = firstVisiblePosition - 1; i > this.a; i--) {
                            if (this.f.indexOfKey(i) > 0) {
                                firstVisiblePosition2 += this.f.get(i);
                            }
                        }
                    } else {
                        firstVisiblePosition2 = 0;
                    }
                    this.c += firstVisiblePosition2 + this.b;
                    this.b = childAt.getHeight();
                } else if (firstVisiblePosition < this.a) {
                    if (this.a - firstVisiblePosition != 1) {
                        i = 0;
                        for (firstVisiblePosition2 = this.a - 1; firstVisiblePosition2 > firstVisiblePosition; firstVisiblePosition2--) {
                            if (this.f.indexOfKey(firstVisiblePosition2) > 0) {
                                i += this.f.get(firstVisiblePosition2);
                            }
                        }
                    } else {
                        i = 0;
                    }
                    this.c -= i + childAt.getHeight();
                    this.b = childAt.getHeight();
                } else if (firstVisiblePosition == 0) {
                    this.b = childAt.getHeight();
                }
                if (this.b < 0) {
                    this.b = 0;
                }
                this.e = this.c - childAt.getTop();
                this.a = firstVisiblePosition;
                this.g.onScrollChanged(this.e, this.i, this.j);
                if (this.i) {
                    this.i = false;
                }
                if (this.d < this.e) {
                    this.h = ScrollState.UP;
                } else if (this.e < this.d) {
                    this.h = ScrollState.DOWN;
                } else {
                    this.h = ScrollState.STOP;
                }
                this.d = this.e;
            }
        }
    }

    private int getNumColumnsCompat() {
        int i = 0;
        if (VERSION.SDK_INT >= 11) {
            return getNumColumns();
        }
        if (getChildCount() > 0) {
            int measuredWidth = getChildAt(0).getMeasuredWidth();
            if (measuredWidth > 0) {
                i = getWidth() / measuredWidth;
            }
        }
        return i <= 0 ? -1 : i;
    }

    public int getCurrentScrollY() {
        return this.e;
    }

    public int getHeaderViewCount() {
        return this.n.size();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.g != null) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.j = true;
                    this.i = true;
                    this.g.onDownMotionEvent();
                    break;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof b)) {
            ((b) adapter).a(getNumColumnsCompat());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.a = savedState.a;
        this.b = savedState.b;
        this.c = savedState.c;
        this.d = savedState.d;
        this.e = savedState.e;
        this.f = savedState.f;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.a;
        savedState.b = this.b;
        savedState.c = this.c;
        savedState.d = this.d;
        savedState.e = this.e;
        savedState.f = this.f;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        if (this.g != null) {
            switch (motionEvent.getActionMasked()) {
                case 1:
                case 3:
                    this.k = false;
                    this.j = false;
                    this.g.onUpOrCancelMotionEvent(this.h);
                    break;
                case 2:
                    if (this.l == null) {
                        this.l = motionEvent;
                    }
                    float y = motionEvent.getY() - this.l.getY();
                    this.l = MotionEvent.obtainNoHistory(motionEvent);
                    if (((float) getCurrentScrollY()) - y <= 0.0f) {
                        if (this.k) {
                            return false;
                        }
                        final View view = this.m == null ? (ViewGroup) getParent() : this.m;
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
                        this.k = true;
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

    public void setAdapter(ListAdapter listAdapter) {
        if (this.n.size() > 0) {
            ListAdapter bVar = new b(this.n, this.o, listAdapter);
            int numColumnsCompat = getNumColumnsCompat();
            if (1 < numColumnsCompat) {
                bVar.a(numColumnsCompat);
            }
            super.setAdapter(bVar);
            return;
        }
        super.setAdapter(listAdapter);
    }

    public void setClipChildren(boolean z) {
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.p = onScrollListener;
    }

    public void setScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks) {
        this.g = observableScrollViewCallbacks;
    }

    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.m = viewGroup;
    }
}
